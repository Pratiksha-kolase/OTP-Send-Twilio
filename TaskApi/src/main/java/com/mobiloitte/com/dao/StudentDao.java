package com.mobiloitte.com.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobiloitte.com.model.StudentModel;

public interface StudentDao extends JpaRepository<StudentModel, Long>{

	Optional<StudentModel> findByFirstname(String firstname);

	Optional<StudentModel> findByLastname(String lastname);

	Optional<StudentModel> findByPassword(String password);

	Optional<StudentModel> findByMobile(Long mobile);

	Optional<StudentModel> findByMail(String mail);

	Optional<StudentModel> findByAddress(String address);

	Optional<StudentModel> findByRollno(Long rollno);

	Optional<StudentModel> findByStdusername(String stdusername);

}
