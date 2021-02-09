package dev.services.social;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

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
	 */
	public MessageService(MessageRepo messageRepo, JoueurService joueurService) {
		super();
		this.messageRepo = messageRepo;
		this.joueurService = joueurService;
	}


	public List<Message> listerMessages() {
		List<Message> listeMessages = new ArrayList<>();
		for (Message message : messageRepo.findAll()) {
			listeMessages.add(message);
		}
		System.out.println(listeMessages);
		return listeMessages;
	}
	
	public Message publierMessage(String contenu) {
		System.out.println(contenu);

		// RECUPERATION DU JOUEUR
		Joueur jou = this.joueurService.recuperationJoueur();
		
		// DATE DE MAINTENANT
		long datePublication = new Date().getTime();
		
		Message message = new Message(jou,datePublication,contenu);
		
		System.out.println(message);
		// SAUVEGARDE
		this.messageRepo.save(message);
		
		// RETOUR
		return message;
	}
}
