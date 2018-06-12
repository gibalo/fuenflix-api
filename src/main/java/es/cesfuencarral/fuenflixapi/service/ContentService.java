package es.cesfuencarral.fuenflixapi.service;

import java.util.List;

import es.cesfuencarral.fuenflixapi.controller.request.ContentFilterRequest;
import es.cesfuencarral.fuenflixapi.controller.request.ContentRequest;
import es.cesfuencarral.fuenflixapi.persistence.entity.Content;

public interface ContentService {

	void edit(long content, ContentRequest request);

	void add(ContentRequest request);

	void delete(long id);

	List<Content> getAll();

	List<Content> getFiltered(ContentFilterRequest request);
}
