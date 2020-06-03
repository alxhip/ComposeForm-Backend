package com.compose.composeforms.message.request;

import java.util.Set;

import javax.validation.constraints.*;

public class SignUpForm {
	@NotBlank
	@Size(min = 3, max = 50)
	private String name;

	@NotBlank
	@Size(min = 3, max = 50)
	private String username;

	@NotBlank
	@Size(max = 60)
	@Email
	private String email;

	@Size(min = 10, max = 10)
	private String nipt;

	private Set<String> role;

	@NotBlank
	@Size(min = 6, max = 40)
	private String password;

	private double latitude;

	private double longitude;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Set<String> getRole() {
		return this.role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

	public String getNipt() {
		return nipt;
	}

	public void setNipt(String nipt) {
		this.nipt = nipt;
	}

	
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "SignUpForm [name=" + name + ", username=" + username + ", email=" + email + ", nipt=" + nipt + ", role="
				+ role + ", password=" + password + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

}