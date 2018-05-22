package es.cesfuencarral.fuenflixapi.controller;

import es.cesfuencarral.fuenflixapi.controller.request.ContentFilterRequest;
import es.cesfuencarral.fuenflixapi.controller.request.ContentRequest;
import es.cesfuencarral.fuenflixapi.controller.response.ContentResponse;
import es.cesfuencarral.fuenflixapi.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
public class ContentController {

	private static final Logger LOGGER = Logger.getLogger(ContentController.class.getName());

	@Autowired
	private ContentService contentService;

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/content/{id}", method = RequestMethod.POST)
	/**
	 * Edits a Content
	 * 
	 * @param request
	 *            JSON Input with ContentRequest fields
	 * @param content
	 *            Content ID
	 * @return HttpStatus
	 */
	public ResponseEntity<Object> edit(@RequestBody ContentRequest request, @PathVariable(value = "id") long content) {
		try {

			LOGGER.log(Level.INFO, "ContentController.edit start: " + content);

			contentService.edit(content, request);

			return new ResponseEntity<>(HttpStatus.OK);

		} catch (NoSuchMethodError | Exception e) {

			LOGGER.log(Level.SEVERE, "ContentController.edit exception " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/content", method = RequestMethod.PUT)
	/**
	 * Adds new Content
	 * 
	 * @param request
	 *            JSON Input with ContentRequest fields.
	 * @return HttpStatus
	 */
	public ResponseEntity<Object> add(@RequestBody ContentRequest request) {
		try {

			LOGGER.log(Level.INFO, "ContentController.add started ");

			contentService.add(request);

			LOGGER.log(Level.INFO, "ContentController.add finished ");
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (NoSuchMethodError | Exception e) {

			LOGGER.log(Level.SEVERE, "ContentController.add exception " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/content", method = RequestMethod.GET)
	/**
	 * Returns all the contents on the DB
	 * 
	 * @return List<ContentResponse>
	 */
	public ResponseEntity<List<ContentResponse>> getAll() {
		try {

			LOGGER.log(Level.INFO, "ContentController.getAll started.");

			return ResponseEntity.ok(contentService.getAll().stream().map(entity -> new ContentResponse(entity))
					.collect(Collectors.toList()));

		} catch (NoSuchMethodError | Exception e) {

			LOGGER.log(Level.SEVERE, "ContentController.getAll exception " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/content/filter", method = RequestMethod.POST)
	/**
	 * Returns a filtered list by User purchases or ContentType
	 * 
	 * @param request
	 *            JSON Input with ContentFilterRequest fields
	 * @return List<Content>
	 */
	public ResponseEntity<List<ContentResponse>> getAllByFilter(@RequestBody ContentFilterRequest request) {
		try {

			LOGGER.log(Level.INFO, "ContentController.getAllByFilter start: ");

			return ResponseEntity.ok(contentService.getFiltered(request).stream()
					.map(entity -> new ContentResponse(entity)).collect(Collectors.toList()));

		} catch (NoSuchMethodError | Exception e) {

			LOGGER.log(Level.SEVERE, "ContentController.getAllByFilter exception " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	 * TODO
	 * 
	 * @CrossOrigin(origins = "*")
	 * 
	 * @RequestMapping(value = "/content/{id}", method = RequestMethod.DELETE)
	 * public ResponseEntity<Object> delete(@RequestParam(value = "id") String user)
	 * { try {
	 * 
	 * LOGGER.log(Level.INFO, "ContentController.delete start: ");
	 * 
	 * return new ResponseEntity<>(HttpStatus.OK);
	 * 
	 * } catch (NoSuchMethodError | Exception e) {
	 * 
	 * LOGGER.log(Level.SEVERE, "ContentController.delete exception " +
	 * e.getMessage()); return new
	 * ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); } }
	 */
}
