package es.cesfuencarral.fuenflixapi.controller;


import es.cesfuencarral.fuenflixapi.controller.request.BuyRequest;
import es.cesfuencarral.fuenflixapi.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class BuyController {
	
	private static final Logger LOGGER = Logger.getLogger(BuyController.class.getName());

	@Autowired
    private BuyService buyService;

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/buy", method = RequestMethod.POST)
	public ResponseEntity<Object> buyContent(@RequestBody BuyRequest request) {
		try {

			LOGGER.log(Level.INFO, "BuyController.buyContent start: " + request.toString());

			return new ResponseEntity<>(HttpStatus.OK);

		} catch(NoSuchMethodError | Exception e) {

            LOGGER.log(Level.SEVERE, "BuyController.buyContent exception " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
}
