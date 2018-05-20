package es.cesfuencarral.fuenflixapi.service;

import es.cesfuencarral.fuenflixapi.controller.request.BuyRequest;
import es.cesfuencarral.fuenflixapi.persistence.entity.Content;
import es.cesfuencarral.fuenflixapi.persistence.entity.User;

public interface BuyService {

	int buyContentByUser(BuyRequest buyRequest);

}
