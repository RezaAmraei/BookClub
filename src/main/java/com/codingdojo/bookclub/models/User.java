package com.codingdojo.bookclub.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "name is requried!")
	@Size(min = 3, max = 30, message = "Username must be between 3 characters and 30 characters")
	private String name;
	
	@NotEmpty(message = "Email is requried!")
	@Email(message = "Please enter a valid email")
	private String email;
	
	@NotEmpty(message = "Password is requried!")
	@Size(min = 8, max = 120, message = "Password must be between 8 characters and 120 characters")
	private String password;
	
	@Transient
	@NotEmpty(message = "Confirm Password is requried!")
	@Size(min = 8, max = 120, message = "Password must be between 8 characters and 120 characters")
	private String confirm;
	
	public User() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String userName) {
		this.name = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
}
