package dev.repository.social;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.entites.social.Message;

/**
 * Repository Message
 */
public interface MessageRepo extends JpaRepository<Message, Integer> {

}
