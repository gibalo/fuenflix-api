package es.cesfuencarral.fuenflixapi.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.cesfuencarral.fuenflixapi.persistence.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}