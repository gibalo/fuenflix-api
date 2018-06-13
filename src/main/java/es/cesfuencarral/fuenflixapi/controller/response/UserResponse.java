package es.cesfuencarral.fuenflixapi.controller.response;

import es.cesfuencarral.fuenflixapi.persistence.entity.User;

public class UserResponse {

	private String token;
	private String username;
	private int level;

	public UserResponse() {

	}

	public UserResponse(User entity) {
		this.token = "FFXXCFC";
		this.username = entity.getUsername();
		this.level = entity.getProfile().getLevel();
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
