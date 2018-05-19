package es.cesfuencarral.fuenflixapi.controller.request;

public class LoginRequest {

	/* fields */
	private String username;
	private String password;

	/* getters & setters */

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/* constructor */

	public LoginRequest() {
	}

	/* other */

	@Override
	public String toString() {
		return "LoginRequest{" + "username='" + username + '\'' + ", password='" + password + '\'' + '}';
	}
}
