package es.cesfuencarral.fuenflixapi.service;

import org.springframework.stereotype.Component;

import es.cesfuencarral.fuenflixapi.controller.request.BuyRequest;
import es.cesfuencarral.fuenflixapi.persistence.entity.Content;
import es.cesfuencarral.fuenflixapi.persistence.entity.Payment;
import es.cesfuencarral.fuenflixapi.persistence.entity.User;
import es.cesfuencarral.fuenflixapi.persistence.repository.PaymentRepository;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class BuyServiceImpl implements BuyService {

	private static final Logger LOGGER = Logger.getLogger(BuyServiceImpl.class.getName());

	@Override
	public int buyContentByUser(BuyRequest buyRequest) {

		try {

			if (buyRequest != null ) {

				Payment payment = new Payment(buyRequest.getRate(), new Date(), buyRequest.getUser(), buyRequest.getContent());
				// insertar compra

				return 0;
			} else {
				// devolver error
				return -1;
			}

		} catch (Exception e) {

			LOGGER.log(Level.SEVERE, "BuyServiceImpl.buyContentByUser ERROR : " + e.getLocalizedMessage());
			return -1;
		}

	}
}
