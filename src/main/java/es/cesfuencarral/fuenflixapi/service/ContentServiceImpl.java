package es.cesfuencarral.fuenflixapi.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.cesfuencarral.fuenflixapi.controller.request.ContentFilterRequest;
import es.cesfuencarral.fuenflixapi.controller.request.ContentRequest;
import es.cesfuencarral.fuenflixapi.persistence.entity.Content;
import es.cesfuencarral.fuenflixapi.persistence.entity.ContentType;
import es.cesfuencarral.fuenflixapi.persistence.repository.ContentRepository;
import es.cesfuencarral.fuenflixapi.persistence.repository.ContentTypeRepository;

@Component
public class ContentServiceImpl implements ContentService {

	private static final Logger LOGGER = Logger.getLogger(BuyServiceImpl.class.getName());

	@Autowired
	private ContentRepository contentRepository;

	@Autowired
	private ContentTypeRepository contentTypeRepository;

	@Override
	public void edit(long content, ContentRequest request) {

		try {

			Optional<Content> contentAux = contentRepository.findById(content);
			Optional<ContentType> contentTypeAux = contentTypeRepository.findById(request.getContentType());

			if (contentAux.isPresent() && contentTypeAux.isPresent()) {
				contentAux.get().update(contentTypeAux.get(), request);

				contentRepository.save(contentAux.get());
				LOGGER.log(Level.INFO, "ContentServiceImpl.edit Edit OK");
			} else {
				LOGGER.log(Level.INFO, "ContentServiceImpl.edit Edit ERROR : Content Type NOT FOUND.");
			}

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "ContentServiceImpl.edit ERROR : " + e.getLocalizedMessage());
		}

	}

	@Override
	public void add(ContentRequest request) {

		try {
			Optional<ContentType> contentTypeAux = contentTypeRepository.findById(request.getContentType());

			if (contentTypeAux.isPresent()) {
				contentRepository.save(new Content(contentTypeAux.get(), request));
				LOGGER.log(Level.INFO, "ContentServiceImpl.add Insert OK");
			} else {
				LOGGER.log(Level.INFO, "ContentServiceImpl.add Insert ERROR : Content Type NOT FOUND.");
			}

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "ContentServiceImpl.add ERROR : " + e.getLocalizedMessage());
		}
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Content> getAll() {
		try {
			LOGGER.log(Level.INFO, "ContentServiceImpl.getAll OK");

			return contentRepository.findAll();

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "ContentServiceImpl.getAll ERROR : " + e.getLocalizedMessage());
			return null;
		}

	}

	@Override
	public List<Content> getFiltered(ContentFilterRequest request) {
		// TODO Auto-generated method stub
		try {
			LOGGER.log(Level.INFO, "ContentServiceImpl.getAll OK");

			//contentRepository.findByFilter(request.getContentType());
			return null;

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "ContentServiceImpl.getAll ERROR : " + e.getLocalizedMessage());
			return null;
		}
	}
}
