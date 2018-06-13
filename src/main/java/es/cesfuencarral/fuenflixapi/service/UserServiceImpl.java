package es.cesfuencarral.fuenflixapi.service;

import es.cesfuencarral.fuenflixapi.controller.request.LoginRequest;
import es.cesfuencarral.fuenflixapi.controller.request.UserRequest;
import es.cesfuencarral.fuenflixapi.controller.response.UserResponse;
import es.cesfuencarral.fuenflixapi.persistence.entity.Content;
import es.cesfuencarral.fuenflixapi.persistence.entity.ContentType;
import es.cesfuencarral.fuenflixapi.persistence.entity.Profile;
import es.cesfuencarral.fuenflixapi.persistence.entity.User;
import es.cesfuencarral.fuenflixapi.persistence.repository.ProfileRepository;
import es.cesfuencarral.fuenflixapi.persistence.repository.UserRepository;

import java.util.List;
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

	@Autowired
	private ProfileRepository profileRepository;

	@Override
	public User getProfile(String username) {

		try {

			Optional<User> userAux = userRepository.findByUsername(username);

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

	@Override
	public UserResponse login(LoginRequest request) {
		try {

			Optional<User> userAux = userRepository.findByUsername(request.getUsername());

			if (userAux.isPresent()) {
				User user = userAux.get();

				if (user.getPassword().equals(request.getPassword())) {

					return new UserResponse(user);
				} else {
					return null;
				}

			} else {
				LOGGER.log(Level.INFO, "UserServiceImpl.login ERROR : user NOT FOUND.");
			}

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "UserServiceImpl.login LOGIN ERROR : " + e.getLocalizedMessage());
		}
		return null;
	}

	@Override
	public boolean register(UserRequest user) {

		try {

			Optional<User> userAux = userRepository.findByUsername(user.getUsername());

			if (!userAux.isPresent()) {

				LOGGER.log(Level.INFO, "UserServiceImpl.register ERROR : user FOUND.");
				return false;
			} else {

				Optional<Profile> profileAux = profileRepository.findById((long) 2);

				if (profileAux.isPresent() && profileAux.isPresent()) {

					userAux.get().setProfile(profileAux.get());
					userRepository.save(userAux.get());
					return true;
				}

			}

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "UserServiceImpl.register Register ERROR : " + e.getLocalizedMessage());
		}
		return false;
	}

	@Override
	public User editProfile(UserRequest user) {

		try {

			Optional<User> userAux = userRepository.findByUsername(user.getUsername());
			if (userAux.isPresent()) {
				
				userAux.get().setName(user.getName());
				userAux.get().setAddress(user.getAddress());
				userAux.get().setEmail(user.getEmail());
				userAux.get().setPassword(user.getPassword());
				
				userRepository.save(userAux.get());
				return userAux.get();
			} else {
				LOGGER.log(Level.INFO, "UserServiceImpl.edit ERROR : User NOT FOUND.");
				return null;
			}

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "UserServiceImpl.edit Edit ERROR : " + e.getLocalizedMessage());
		}
		return null;
	}

}
