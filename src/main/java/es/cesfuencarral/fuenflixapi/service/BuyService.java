package es.cesfuencarral.fuenflixapi.service;

import es.cesfuencarral.fuenflixapi.controller.request.BuyRequest;

public interface BuyService {

	int buyContentByUser(BuyRequest request);

}
