package com.mobiloitte.com.controller;

import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.net.AprEndpoint.Sendfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RestController;

import com.mobiloitte.com.dto.StudentDto;
import com.mobiloitte.com.model.StudentModel;
import com.mobiloitte.com.service.StudentService;


@RestController
public class StudentController {
	@Autowired
	private StudentService studService;

	@PostMapping("/insert")
	public ResponseEntity<String> insert(@RequestBody StudentDto studDto) {

		return studService.insert(studDto);
	}
	@GetMapping("/getbyfirstname/{firstname}")
	public Optional<StudentModel> firstname(@PathVariable("firstname") String firstname) {

		return studService.getByFirstname(firstname);
	}

	@GetMapping("/getbylastname/{lastname}")
	public Optional<StudentModel> lastname(@PathVariable("lastname") String lastname) {

		return studService.getByLastname(lastname);
	}
	@GetMapping("/getAllData")
	public List<StudentModel> allData() {
		return studService.allData();
	}

	@GetMapping("/getById/{studId}")
	public Optional<StudentModel> getById(@PathVariable("studId") Long studId) {
		return studService.getById(studId);

	}

	@GetMapping("getByStudentusername/{stdusername}")
	public Optional<StudentModel> getByUsername(@PathVariable("stdusername") String stdusername) {

		return studService.getByUsername(stdusername);
	}
	@GetMapping("getByAddress/{address}")
	public Optional<StudentModel> getByAddress(@PathVariable("address") String address) {

		return studService.getByAddress(address);
	}
	
	@GetMapping("getByRollno/{rollno}")
	public Optional<StudentModel> getByRollNo(@PathVariable("rollno") Long rollno) {

		return studService.getByRollNo(rollno);
	}
	@GetMapping("/sendotp")
	public ResponseEntity<String> send()
	{
		return studService.sendOtp();
	}
	
	
	@PutMapping("/update/{studId}")
	public ResponseEntity<String> update(@PathVariable("studId") Long studId, @RequestBody StudentDto studDto) {

		return studService.update(studId, studDto);
	}

	@DeleteMapping("/deleteUser/{studId}")
	public ResponseEntity<String> deleteUser(@PathVariable("studId") Long studId) {
		return studService.deleteUser(studId);
	}
}
