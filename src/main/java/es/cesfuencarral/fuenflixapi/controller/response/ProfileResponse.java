package es.cesfuencarral.fuenflixapi.controller.response;

import es.cesfuencarral.fuenflixapi.persistence.entity.User;

public class ProfileResponse {
	
	private long id;
	private String name;
	private String username;
	private String email;
	private String address;
	private String password;
	
	public ProfileResponse() {
		
	}

	public ProfileResponse(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.username = user.getUsername();
		this.email = user.getEmail();
		this.address = user.getAddress();
		this.password = user.getPassword();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
