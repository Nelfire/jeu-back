package dev.controller.social;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.dto.batiment.BatimentJoueurCreationDto;
import dev.controller.dto.social.CreationGuildeDto;
import dev.entites.social.Guilde;
import dev.services.social.GuildeService;

@RestController
@RequestMapping("guilde")
public class GuildeController {

	GuildeService guildeService;

	/**
	 * @param guildeService
	 */
	public GuildeController(GuildeService guildeService) {
		super();
		this.guildeService = guildeService;
	}
	
	@PostMapping
	public ResponseEntity<?> creationGuilde(@RequestBody CreationGuildeDto creationGuildeDto) {
		Guilde creationGuilde = guildeService.creationGuilde(creationGuildeDto);
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("resultat", "Guilde créée").body(creationGuilde);
	}
	
	@GetMapping("/listerGuildes")
	public List<Guilde> listerLesGuildes() {
		return this.guildeService.listerLesGuildes();
	}
}
