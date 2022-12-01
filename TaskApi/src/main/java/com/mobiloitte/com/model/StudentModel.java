package com.mobiloitte.com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class StudentModel {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studId;
	private String firstname;
	private String lastname;
	private String address;
	private Long mobile;
	private String mail;
	private Long rollno;
	private String password;
	private String stdusername;
	public Long getStudId() {
		return studId;
	}
	public void setStudId(Long studId) {
		this.studId = studId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Long getRollNo() {
		return rollno;
	}
	public void setRollNo(Long rollno) {
		this.rollno = rollno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStdusername() {
		return stdusername;
	}
	public void setStdusername(String stdusername) {
		this.stdusername = stdusername;
	}
	@Override
	public String toString() {
		return "StudentModel [studId=" + studId + ", firstname=" + firstname + ", lastname=" + lastname + ", address="
				+ address + ", mobile=" + mobile + ", mail=" + mail + ", rollno=" + rollno + ", password=" + password
				+ ", stdusername=" + stdusername + "]";
	}
	
	

	
	
}
