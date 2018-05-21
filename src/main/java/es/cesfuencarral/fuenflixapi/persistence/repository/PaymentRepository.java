package es.cesfuencarral.fuenflixapi.persistence.repository;

import es.cesfuencarral.fuenflixapi.persistence.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
	
}