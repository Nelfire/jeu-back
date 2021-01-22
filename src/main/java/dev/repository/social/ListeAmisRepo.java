package dev.repository.social;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.entites.social.ListeAmis;

public interface ListeAmisRepo extends JpaRepository<ListeAmis, Integer> {

}
