package com.um.myapp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table (name="User_Info")
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY) 
	@NotNull
	private Integer id;
	@Size(min=2, max=14)
	private String name;
	@Size(min=6, max=12) 
	private String password;
	private String confirmPassword;
	@Email
	@NotEmpty
	private String email;
	@NotNull
	@Past 
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date date;
	private String phone;
	@NotEmpty
	private String address;
	@NotNull
	private String gender;

	
	//Check if this is for New of Update
	public boolean isNew(){
		return (this.id == null);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public enum Gender{
		MALE, FEMALE;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", email=" + email + ", date=" + date + ", phone=" + phone + ", address=" + address + ", gender="
				+ gender + "]";
	}
}
