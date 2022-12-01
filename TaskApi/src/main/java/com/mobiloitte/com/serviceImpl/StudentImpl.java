package com.mobiloitte.com.serviceImpl;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mobiloitte.com.dao.StudentDao;
import com.mobiloitte.com.dto.StudentDto;
import com.mobiloitte.com.model.StudentModel;
import com.mobiloitte.com.service.StudentService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class StudentImpl implements StudentService {
	
	
	@Autowired
	private StudentDao studDao;
	
	@Value("${fromPhoneNo}")
	private String from;

	@Value("${toPhoneNo}")
	private String to;

	@Value("${accountSID}")
	private String account_sid;

	@Value("${authToken}")
	private String auth_Token;

	public ResponseEntity<String> insert(StudentDto studDto) {
		StudentModel studModel = new StudentModel();

		Optional<StudentModel> firstname = studDao.findByFirstname(studDto.getFirstname());
		Optional<StudentModel> lastname = studDao.findByLastname(studDto.getLastname());
		if (!firstname.isPresent() && !lastname.isPresent()) {

			studModel.setFirstname(studDto.getFirstname());
			studModel.setLastname(studDto.getLastname());
		}
		Optional<StudentModel> rollno = studDao.findByRollno(studDto.getRollNo());
		if (!rollno.isPresent()) {

			studModel.setRollNo(studDto.getRollNo());
		}

		Optional<StudentModel> stud = studDao.findByStdusername(studDto.getStdusername());

		if (!stud.isPresent()) {
			studModel.setStdusername(studDto.getStdusername());
		} else {
			return new ResponseEntity<>("Student Already Exists...", HttpStatus.OK);
		}

		Optional<StudentModel> pass = studDao.findByPassword(studDto.getPassword());
		if (!pass.isPresent()) {
			studModel.setPassword(studDto.getPassword());
		} else {
			return new ResponseEntity<>("Password Already Exixts..", HttpStatus.OK);
		}

		Optional<StudentModel> mobile = studDao.findByMobile(studDto.getMobile());
		if (!mobile.isPresent()) {
			studModel.setMobile(studDto.getMobile());
		} else {
			return new ResponseEntity<>("Mobile number Already Exists...", HttpStatus.OK);
		}

		Optional<StudentModel> email = studDao.findByMail(studDto.getMail());
		if (!email.isPresent()) {
			studModel.setAddress(studDto.getAddress());
			studModel.setMail(studDto.getMail());
			studDao.save(studModel);
			return new ResponseEntity<>("Successfully Registered", HttpStatus.OK);
		} else {

			return new ResponseEntity<>("Email Already Registered...", HttpStatus.OK);
		}

	}

	@Override
	public Optional<StudentModel> getByFirstname(String firstname) {

		return studDao.findByFirstname(firstname);
	}

	@Override
	public Optional<StudentModel> getByLastname(String lastname) {

		return studDao.findByLastname(lastname);
	}

	@Override
	public List<StudentModel> allData() {
		return studDao.findAll();
	}

	@Override
	public Optional<StudentModel> getById(Long studId) {

		return studDao.findById(studId);
	}

	@Override
	public Optional<StudentModel> getByUsername(String stdusername) {

		return studDao.findByStdusername(stdusername);
	}

	@Override
	public Optional<StudentModel> getByAddress(String address) {

		return studDao.findByAddress(address);
	}

	@Override
	public ResponseEntity<String> deleteUser(Long studId) {
		studDao.deleteById(studId);
		return new ResponseEntity<>("Student Deleted Successfully.......!", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> update(Long studId, StudentDto studDto) {
		ResponseEntity<String> message = new ResponseEntity<>("", HttpStatus.OK);
		Optional<StudentModel> updateUser = studDao.findById(studId);
		if (updateUser.isPresent()) {
			StudentModel studModel = studDao.getById(studId);
			studModel.setFirstname(studDto.getFirstname());
			studModel.setLastname(studDto.getLastname());
			studModel.setMobile(studDto.getMobile());
			studModel.setAddress(studDto.getAddress());
			studModel.setRollNo(studDto.getRollNo());
			studDao.save(studModel);
			message = new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
		} else {

			message = new ResponseEntity<>("Not found", HttpStatus.OK);
		}
		return message;
	}

	@Override
	public Optional<StudentModel> getByRollNo(Long rollno) {
		return studDao.findByRollno(rollno);
	}

	
	@Override
	public ResponseEntity<String> sendOtp() {
		int max = 10000000;
		int min = 20000000;
		Long a = (long) (Math.random() * (max - min + 1) + min);
		String msg = "Your OTP is " + a;
		try {
			Twilio.init(account_sid, auth_Token);
			Message message = Message.creator(new PhoneNumber(to), new PhoneNumber(from), msg).create();
			
			return new ResponseEntity<>("OTP Send Successfully...", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("OTP Send Failed...", HttpStatus.OK);
	}

	
}
