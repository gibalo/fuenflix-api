package es.cesfuencarral.fuenflixapi.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.cesfuencarral.fuenflixapi.controller.request.ContentFilterRequest;
import es.cesfuencarral.fuenflixapi.controller.request.ContentRequest;
import es.cesfuencarral.fuenflixapi.controller.response.ContentResponse;
import es.cesfuencarral.fuenflixapi.persistence.entity.Content;
import es.cesfuencarral.fuenflixapi.service.ContentService;

@RestController
public class TestController {
	private static final Logger LOGGER = Logger.getLogger(ContentController.class.getName());

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/test", method = RequestMethod.DELETE)
	public ResponseEntity<Object> edit() {
		try {

			return new ResponseEntity<>(HttpStatus.OK);

		} catch (NoSuchMethodError | Exception e) {

			LOGGER.log(Level.SEVERE, "ContentController.edit exception " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/test", method = RequestMethod.PUT)
	public ResponseEntity<Object> add() {
		try {

			return new ResponseEntity<>(HttpStatus.OK);

		} catch (NoSuchMethodError | Exception e) {

			LOGGER.log(Level.SEVERE, "ContentController.add exception " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ResponseEntity<Object> getAll() {
		try {

			return ResponseEntity.ok(new Content());

		} catch (NoSuchMethodError | Exception e) {

			LOGGER.log(Level.SEVERE, "ContentController.getAll exception " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public ResponseEntity<Object> getAllByFilter(@RequestBody ContentFilterRequest request) {
		try {

			return new ResponseEntity<>(HttpStatus.OK);

		} catch (NoSuchMethodError | Exception e) {

			LOGGER.log(Level.SEVERE, "ContentController.getAllByFilter exception " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
