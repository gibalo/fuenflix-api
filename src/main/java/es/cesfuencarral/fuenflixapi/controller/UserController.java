package es.cesfuencarral.fuenflixapi.controller;

import es.cesfuencarral.fuenflixapi.controller.request.ContentFilterRequest;
import es.cesfuencarral.fuenflixapi.controller.request.LoginRequest;
import es.cesfuencarral.fuenflixapi.controller.request.UserRequest;
import es.cesfuencarral.fuenflixapi.controller.response.ContentResponse;
import es.cesfuencarral.fuenflixapi.controller.response.LoginResponse;
import es.cesfuencarral.fuenflixapi.controller.response.ProfileResponse;
import es.cesfuencarral.fuenflixapi.controller.response.UserResponse;
import es.cesfuencarral.fuenflixapi.persistence.entity.User;
import es.cesfuencarral.fuenflixapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
public class UserController {

	private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

	@Autowired
	private UserService userService;

	/* Access: All users */

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<UserResponse> login(@RequestBody LoginRequest request) {
		try {
			LOGGER.log(Level.INFO, "UserController.login login: " + request.toString());

			UserResponse userResponse = userService.login(request);
			
			if(userResponse.getUsername() != null) {
				return ResponseEntity.ok(userResponse);
			}else {
				return new ResponseEntity<UserResponse>(HttpStatus.NOT_FOUND);
			}
			
		} catch (NoSuchMethodError | Exception e) {

			LOGGER.log(Level.SEVERE, "UserController.login exception " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ResponseEntity<LoginResponse> logout() {
		try {
			// TODO

			LOGGER.log(Level.INFO, "UserController.logout start: ");

			return new ResponseEntity<>(HttpStatus.OK);

		} catch (NoSuchMethodError | Exception e) {

			LOGGER.log(Level.SEVERE, "UserController.logout exception " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/profile/{username}", method = RequestMethod.GET)
	public ResponseEntity<ProfileResponse> getProfile(@PathVariable String username) {
		try {

			LOGGER.log(Level.INFO, "UserController.getProfile start: ");

			ProfileResponse profile = new ProfileResponse(userService.getProfile(username));

			return new ResponseEntity<ProfileResponse>(profile, HttpStatus.OK);

		} catch (NoSuchMethodError | Exception e) {

			LOGGER.log(Level.SEVERE, "UserController.getProfile exception " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public ResponseEntity<Object> editProfile(@RequestBody UserRequest request) {
		try {

			LOGGER.log(Level.INFO, "UserController.editProfile start: ");
			userService.editProfile(request);
			
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (NoSuchMethodError | Exception e) {

			LOGGER.log(Level.SEVERE, "UserController.editProfile exception " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/* Access : Admin only */
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
	public ResponseEntity<Object> editUser(@RequestBody UserRequest request, @RequestParam(value = "id") String user) {
		try {

			LOGGER.log(Level.INFO, "UserController.editUser start: ");

			return new ResponseEntity<>(HttpStatus.OK);

		} catch (NoSuchMethodError | Exception e) {

			LOGGER.log(Level.SEVERE, "UserController.editUser exception " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public ResponseEntity<Object> addUser(@RequestBody UserRequest request) {
		try {

			LOGGER.log(Level.INFO, "UserController.addUser start: ");
			
			if(userService.register(request)) {
				return new ResponseEntity<>(HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		
		} catch (NoSuchMethodError | Exception e) {

			LOGGER.log(Level.SEVERE, "UserController.addUser exception " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<List<UserResponse>> getUsers() {
		try {

			LOGGER.log(Level.INFO, "UserController.addUser start: ");

			return new ResponseEntity<>(HttpStatus.OK);

		} catch (NoSuchMethodError | Exception e) {

			LOGGER.log(Level.SEVERE, "UserController.addUser exception " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteUser(@RequestParam(value = "id") String user) {
		try {

			LOGGER.log(Level.INFO, "UserController.deleteUser start: ");

			return new ResponseEntity<>(HttpStatus.OK);

		} catch (NoSuchMethodError | Exception e) {

			LOGGER.log(Level.SEVERE, "UserController.deleteUser exception " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
