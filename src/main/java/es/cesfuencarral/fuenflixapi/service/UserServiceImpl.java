package es.cesfuencarral.fuenflixapi.service;

import es.cesfuencarral.fuenflixapi.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

}
