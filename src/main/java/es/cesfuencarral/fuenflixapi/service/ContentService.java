package es.cesfuencarral.fuenflixapi.service;

import es.cesfuencarral.fuenflixapi.controller.request.ContentRequest;

public interface ContentService {

	void edit(long content, ContentRequest request);

	void add(ContentRequest request);

	void delete();

	void getAll();

	void getFiltered();
}
