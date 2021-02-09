package dev.controller.social;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.entites.social.Message;
import dev.services.social.MessageService;

@RestController
@RequestMapping("messages")
public class MessageController {

	private MessageService messageService;

	/**
	 * @param messageService
	 */
	public MessageController(MessageService messageService) {
		super();
		this.messageService = messageService;
	}
	
	@GetMapping
	public List<Message> listerMessages() {
		return this.messageService.listerMessages();
	}
	
	
	@PostMapping
	public ResponseEntity<?> publierMessage(@RequestBody String contenu) {
		System.out.println("Blip");
		Message message = messageService.publierMessage(contenu);
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("resultat", "Message envoyé").body(message);
	}
}
