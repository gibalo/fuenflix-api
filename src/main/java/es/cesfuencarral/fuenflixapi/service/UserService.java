package es.cesfuencarral.fuenflixapi.service;

import es.cesfuencarral.fuenflixapi.persistence.entity.User;

public interface UserService {
	
	User getProfile(long id);
	
}
