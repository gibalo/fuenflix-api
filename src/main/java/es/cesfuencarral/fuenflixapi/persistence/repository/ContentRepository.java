package es.cesfuencarral.fuenflixapi.persistence.repository;

import es.cesfuencarral.fuenflixapi.persistence.entity.Content;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ContentRepository extends JpaRepository<Content, Long> {

	List<Content> findByFilter(@Param("contentType") long contentType);
}