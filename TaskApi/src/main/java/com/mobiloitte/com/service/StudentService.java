package com.mobiloitte.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.mobiloitte.com.dto.StudentDto;
import com.mobiloitte.com.model.StudentModel;

public interface StudentService {

	ResponseEntity<String> insert(StudentDto studDto);

	Optional<StudentModel> getByFirstname(String firstname);

	Optional<StudentModel> getByLastname(String lastname);

	List<StudentModel> allData();

	Optional<StudentModel> getById(Long studId);

	Optional<StudentModel> getByUsername(String studusername);

	Optional<StudentModel> getByAddress(String address);

	ResponseEntity<String> deleteUser(Long studId);

	ResponseEntity<String> update(Long studId, StudentDto studDto);

	Optional<StudentModel> getByRollNo(Long rollno);

	ResponseEntity<String> sendOtp();


	
	


}
