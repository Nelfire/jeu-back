package dev.services.social;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Service;
import dev.controller.dto.social.MessageAjoutDto;
import dev.entites.joueur.Joueur;
import dev.entites.social.Message;
import dev.repository.social.MessageRepo;
import dev.services.joueur.JoueurService;

@Service
public class MessageService {

	private MessageRepo messageRepo;
	private JoueurService joueurService;

	/**
	 * @param messageRepo
	 * @param joueurService
	 */
	public MessageService(MessageRepo messageRepo, JoueurService joueurService) {
		super();
		this.messageRepo = messageRepo;
		this.joueurService = joueurService;
	}

	/**
	 * LISTER TOUS LES MESSAGES
	 */
	public List<Message> listerMessages() {
		
		// INITIALISATIONS
		List<Message> listeMessages = new ArrayList<>();
		
		// RECHERCHE DE TOUS LES MESSAGES
		for (Message message : messageRepo.findAll()) {
			listeMessages.add(message);
		}
		
		// RETOUR
		return listeMessages;
	}

	/**
	 * AJOUT D'UN MESSAGE
	 */
	public MessageAjoutDto publierMessage(@Valid MessageAjoutDto messageDto) {

		// RECUPERATION DU JOUEUR
		Joueur jou = this.joueurService.recuperationJoueur();

		// DATE DE MAINTENANT
		long datePublication = new Date().getTime();

		Message message = new Message(jou, datePublication, messageDto.getContenu());

		// SAUVEGARDE
		this.messageRepo.save(message);

		// RETOUR
		return new MessageAjoutDto(messageDto.getContenu());
	}
}
