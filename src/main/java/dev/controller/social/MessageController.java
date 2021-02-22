package dev.controller.social;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.dto.social.MessageAjoutDto;
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
	public MessageAjoutDto postMessage(@RequestBody @Valid MessageAjoutDto messageAjoutDto) {
		return this.messageService.publierMessage(messageAjoutDto);
	}
}
