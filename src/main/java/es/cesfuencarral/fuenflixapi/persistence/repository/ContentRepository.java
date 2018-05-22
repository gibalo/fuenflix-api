package es.cesfuencarral.fuenflixapi.persistence.repository;

import es.cesfuencarral.fuenflixapi.persistence.entity.Content;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ContentRepository extends JpaRepository<Content, Long> {

	/**
	 * Returns a List<Content> filtering by user purchases
	 * 
	 * @param user
	 *            ID
	 * @return List<Content>
	 */
	List<Content> findByUserContent(@Param("user") long user);

	/**
	 * Returns a List<Content> filtering by ContentType
	 * 
	 * @param contentType
	 *            ID
	 * @return List<Content>
	 */
	List<Content> findByContentType(@Param("contentType") long contentType);

}