package es.cesfuencarral.fuenflixapi.service;

import es.cesfuencarral.fuenflixapi.persistence.entity.Content;
import es.cesfuencarral.fuenflixapi.persistence.entity.ContentType;
import es.cesfuencarral.fuenflixapi.persistence.entity.User;
import es.cesfuencarral.fuenflixapi.persistence.repository.UserRepository;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getName());
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User getProfile(long id) {
		
		try {

			Optional<User> userAux = userRepository.findById(id);

			if (userAux.isPresent()) {
				User user = userAux.get();
				return user;
			} else {
				LOGGER.log(Level.INFO, "UserServiceImpl.getProfile ERROR : profile NOT FOUND.");
			}

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "UserServiceImpl.edit getProfile : " + e.getLocalizedMessage());
		}
		return null;
		
	}
	

}
