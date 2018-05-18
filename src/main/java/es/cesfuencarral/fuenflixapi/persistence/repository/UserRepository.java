package es.cesfuencarral.fuenflixapi.persistence.repository;

import es.cesfuencarral.fuenflixapi.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
//    List<Area> findByValidity(@Param("date") Date date);
}