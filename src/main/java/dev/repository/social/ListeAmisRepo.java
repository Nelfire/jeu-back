package dev.repository.social;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.entites.social.ListeAmis;

/**
 * Repository Liste Amis
 */
public interface ListeAmisRepo extends JpaRepository<ListeAmis, Integer> {

	ListeAmis findByProprietaireListe(Integer proprietaireListe);
}
