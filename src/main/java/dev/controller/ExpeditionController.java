package dev.controller;

import java.util.List;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.entites.expedition.Expedition;
import dev.services.ExpeditionService;
import dev.services.JoueurService;

@RestController
@RequestMapping("expedition")
@EnableScheduling
public class ExpeditionController {

	ExpeditionService expeditionService;
	JoueurService joueurService;
	
	public ExpeditionController(ExpeditionService expeditionService, JoueurService joueurService) {
		this.expeditionService = expeditionService;
		this.joueurService = joueurService;
	}
	
	/**
	 * LISTER TOUTES LES EXPEDITIONS EXISTANTES
	 */
	@GetMapping
	public List<Expedition> listerExpedition() {
		return this.expeditionService.listerExpedition();
	}
	
	/**
	 * DETAILS D'UNE EXPEDITION (Via ID)
	 */
	@GetMapping("/detailsExpedition")
	public Expedition detailExpedition(@RequestParam("id") Integer idExpedition) {
		return this.expeditionService.detailExpedition(idExpedition);
	}
	
	// Tous les jours à minuit
	@Scheduled(cron="0 0 0 * * ?", zone="Europe/Paris")
	@PostMapping("/refeshExpedition")
	public void creerNouvellesExpeditions() {
		System.out.println("Nouvelles expés");
		this.expeditionService.creerNouvellesExpeditions();
	}
}
