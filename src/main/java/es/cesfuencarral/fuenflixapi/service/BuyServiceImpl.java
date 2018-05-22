package es.cesfuencarral.fuenflixapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.cesfuencarral.fuenflixapi.controller.request.BuyRequest;
import es.cesfuencarral.fuenflixapi.persistence.entity.Content;
import es.cesfuencarral.fuenflixapi.persistence.entity.User;
import es.cesfuencarral.fuenflixapi.persistence.repository.ContentRepository;
import es.cesfuencarral.fuenflixapi.persistence.repository.UserRepository;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class BuyServiceImpl implements BuyService {

	private static final Logger LOGGER = Logger.getLogger(BuyServiceImpl.class.getName());

	@Autowired
	UserRepository userRepository;

	@Autowired
	ContentRepository contentRepository;

	@Override
	public int buyContentByUser(long user, BuyRequest request) {

		try {

			Optional<User> userAux = userRepository.findById(user);

			Optional<Content> contentAux = contentRepository.findById(request.getContent());

			if (userAux.isPresent() && contentAux.isPresent()) {
				Set<Content> set = userAux.get().getContents() != null && !userAux.get().getContents().isEmpty()
						? userAux.get().getContents()
						: new HashSet<>();
				set.add(contentAux.get());
				userAux.get().setContents(set);
				userRepository.save(userAux.get());

				return 0;
			}
		} catch (Exception e) {

			LOGGER.log(Level.SEVERE, "BuyServiceImpl.buyContentByUser ERROR : " + e.getLocalizedMessage());

		}
		return -1;

	}
}
