package dev.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.controller.dto.BatimentDto;
import dev.controller.dto.BatimentJoueurDto;
import dev.entites.Joueur;
import dev.entites.batiment.Batiment;
import dev.entites.joueur.BatimentJoueur;
import dev.repository.joueur.BatimentJoueurRepo;

@Service
public class BatimentJoueurService {
	
	private BatimentJoueurRepo batimentJoueurRepo;

	/**
	 * @param batimentJoueurRepo
	 */
	public BatimentJoueurService(BatimentJoueurRepo batimentJoueurRepo) {
		this.batimentJoueurRepo = batimentJoueurRepo;
	}
	
	public List<BatimentJoueurDto> listerMesBatiments(Integer idJoueur) {
		
		List<BatimentJoueurDto> listeMesBatiments = new ArrayList<>();
		for (BatimentJoueur batiment : batimentJoueurRepo.findByJoueurId(idJoueur)) {
			BatimentJoueurDto batimentJoueurDto = new BatimentJoueurDto(batiment.getJoueur(), batiment.getBatiment(),batiment.getNiveau(),batiment.getNombreExploitantsActif());
			listeMesBatiments.add(batimentJoueurDto);	
		}
		return listeMesBatiments;
	}

	
//	/**
//	 * AJOUT D'UNE ABSENCE
//	 * 
//	 * @param absenceDto
//	 * @return une AbsenceVisualisationDto
//	 */
//	@Transactional
//	public BatimentJoueurDto creationBatimentJoueur(Integer idJoueur, BatimentJoueurDto absenceDemandeDto) {
//
//		String email = SecurityContextHolder.getContext().getAuthentication().getName();
//
//		Collegue collegue = collegueRepository.findByEmail(email).orElseThrow(() -> new CollegueAuthentifieNonRecupereException("Le collègue authentifié n'a pas été récupéré"));
//
//		Absence absence = new Absence(absenceDemandeDto.getDateDebut(), absenceDemandeDto.getDateFin(), absenceDemandeDto.getType(), absenceDemandeDto.getMotif(),
//				absenceDemandeDto.getStatut(), collegue);
//
//		if (absence.getDateDebut().isBefore(LocalDate.now()) || (absence.getDateDebut().isEqual(LocalDate.now()))) // Cas jour saisi dans le passé ou aujourd'hui, erreur
//		{
//			throw new DateDansLePasseOuAujourdhuiException("Une demande d'absence ne peut être saisie sur une date ultérieure ou le jour présent.");
//		} else if (absence.getDateFin().isBefore(absence.getDateDebut())) // Cas DateFin < DateDebut
//		{
//			throw new AbsenceDateFinAvantDateDebutException("La date de fin ne peut être inférieure à la date du début de votre absence.");
//		} else if (absence.getType().equals(TypeAbsence.CONGES_SANS_SOLDE) && absence.getMotif().isEmpty()) // Cas congès sans solde, et motif manquant
//		{
//			throw new AbsenceMotifManquantCongesSansSoldeException("Un motif est obligatoire dans le cas où vous souhaitez demander un congé sans solde.");
//		} else if ((absence.getStatut().equals(Statut.EN_ATTENTE_VALIDATION)) || (absence.getStatut().equals(Statut.VALIDEE) || (absence.getStatut().equals(Statut.INITIALE)))) // Impossible de saisir une demande qui chevauche une
//																																// autre sauf si celle-ci est
//																																// en statut REJETEE
//		{
//			List<Absence> listAbsences = new ArrayList<>();
//			listAbsences = this.absenceRepository.findByCollegueEmail(email).orElseThrow(() -> new CollegueAuthentifieNotAbsencesException("Le collègue n'a pas d'absences"));
//
//			for (Absence abs : listAbsences) {
//				// GERER TOUS LES CAS POSSIBLES , POUR EVITER LES CHEVAUCHEMENTS D'ABSENCES
//				if (
//						(
//							(
//									absenceDemandeDto.getDateDebut().isAfter(abs.getDateDebut())
//							)
//							&&
//							(
//									absenceDemandeDto.getDateDebut().isBefore(abs.getDateFin())
//							)
//						)
//						&& 
//						(
//							(
//									absenceDemandeDto.getDateFin().isAfter(abs.getDateDebut())
//							)
//							&& 
//							(
//									absenceDemandeDto.getDateFin().isBefore(abs.getDateFin())
//							)
//						)
//					)
//				{
//					throw new AbsenceChevauchementException("Votre date de début et votre date de fin chevauchent une période d'absence déjà existante");
//				}
//				
//				else if // Si la date début + date fin englobe un interval déjà selectionné (CAS 4)
//				(
//					
//					(
//							absenceDemandeDto.getDateDebut().isBefore(abs.getDateDebut())
//					) 
//					&&
//					(
//							absenceDemandeDto.getDateFin().isAfter(abs.getDateFin())
//					)
//					
//				)
//				{
//					throw new AbsenceChevauchementException("Votre demande chevauche une période d'absence déjà existante");
//				} 
//				else if // Si la date début avant + date fin englobe un interval déjà selectionné (CAS 2)
//				(
//					
//					(
//							absenceDemandeDto.getDateDebut().isBefore(abs.getDateDebut())
//					) 
//					&& 
//					(
//							absenceDemandeDto.getDateFin().isBefore(abs.getDateFin())
//					) 
//					&& 
//					(
//							absenceDemandeDto.getDateFin().isAfter(abs.getDateDebut())
//					)
//					
//				) 
//				{
//					throw new AbsenceChevauchementException("Votre date de début est correcte , mais votre date de fin chevauche une période d'absence déjà existante");
//				} 
//				else if // Si la date début avant + date fin englobe un interval déjà selectionné (CAS 3)
//				(
//					
//					(
//							absenceDemandeDto.getDateDebut().isBefore(abs.getDateFin())
//					)
//					&& 
//					(
//							absenceDemandeDto.getDateFin().isAfter(abs.getDateFin())
//					)
//					&& 
//					(
//							absenceDemandeDto.getDateDebut().isAfter(abs.getDateDebut())
//					)
//					
//				) 
//				{
//					throw new AbsenceChevauchementException("Votre date de fin est correcte , mais votre date de début chevauche une période d'absence déjà existante");
//				}
//				else if // Si la date fin = date debut déjà existante (CAS 5)
//				(
//					absenceDemandeDto.getDateFin().equals(abs.getDateDebut())
//				)
//				{
//					throw new AbsenceChevauchementException("Votre date de fin est la même que la date de début d'une absence déjà existante");
//				} 
//				else if // Si la date fin = date fin déjà existante (CAS 5)
//				(
//					absenceDemandeDto.getDateFin().equals(abs.getDateFin())
//				)
//				{
//					throw new AbsenceChevauchementException("Votre date de fin est la même que la date de fin d'une absence déjà existante");
//				}
//				else if // Si la date debut = date debut déjà existante (CAS 5)
//				(
//					absenceDemandeDto.getDateDebut().equals(abs.getDateDebut())
//				)
//				{
//					throw new AbsenceChevauchementException("Votre date de début est la même que la date de début d'une absence déjà existante");
//				} 
//				else if // Si la date début = date fin déjà existante (CAS 5)
//				(
//					absenceDemandeDto.getDateDebut().equals(abs.getDateFin())
//				)
//				{
//					throw new AbsenceChevauchementException("Votre date de début est la même que la date de fin d'une absence déjà existante");
//				}
//			}
//
//		}
//
//		this.absenceRepository.save(absence);
//		return new AbsenceDemandeDto(absence.getDateDebut(), absence.getDateFin(), absence.getType(),
//				absence.getMotif(), absence.getStatut());
//	}
	
	
}
