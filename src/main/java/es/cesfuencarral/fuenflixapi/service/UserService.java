package es.cesfuencarral.fuenflixapi.service;

import es.cesfuencarral.fuenflixapi.controller.request.LoginRequest;
import es.cesfuencarral.fuenflixapi.controller.request.UserRequest;
import es.cesfuencarral.fuenflixapi.controller.response.UserResponse;
import es.cesfuencarral.fuenflixapi.persistence.entity.User;

public interface UserService {
	
	User getProfile(String username);
	
	UserResponse login(LoginRequest request);
	
	boolean register(UserRequest user);
	
	User editProfile(UserRequest user);
	
}
