package es.cesfuencarral.fuenflixapi.persistence.repository;

import es.cesfuencarral.fuenflixapi.persistence.entity.Content;
import es.cesfuencarral.fuenflixapi.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<Content> findContentsById(@Param("id") long id);
    
    Optional<User> findByUsername(@Param("username") String username);
}