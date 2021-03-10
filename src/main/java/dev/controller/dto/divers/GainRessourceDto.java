package dev.controller.dto.divers;

public class GainRessourceDto {

	private Integer gainPierre;
	private Integer gainBois;
	private Integer gainOr;
	private Integer gainNourriture;

	/**
	 * CONSTRUCTEUR VIDE
	 */
	public GainRessourceDto() {

	}

	/**
	 * CONSTRUCTEUR AVEC PARAMETRES
	 * 
	 * @param gainPierre
	 * @param gainBois
	 * @param gainOr
	 * @param gainNourriture
	 */
	public GainRessourceDto(Integer gainPierre, Integer gainBois, Integer gainOr, Integer gainNourriture) {
		super();
		this.gainPierre = gainPierre;
		this.gainBois = gainBois;
		this.gainOr = gainOr;
		this.gainNourriture = gainNourriture;
	}

	/**
	 * @return the gainPierre
	 */
	public Integer getGainPierre() {
		return gainPierre;
	}

	/**
	 * @param gainPierre the gainPierre to set
	 */
	public void setGainPierre(Integer gainPierre) {
		this.gainPierre = gainPierre;
	}

	/**
	 * @return the gainBois
	 */
	public Integer getGainBois() {
		return gainBois;
	}

	/**
	 * @param gainBois the gainBois to set
	 */
	public void setGainBois(Integer gainBois) {
		this.gainBois = gainBois;
	}

	/**
	 * @return the gainOr
	 */
	public Integer getGainOr() {
		return gainOr;
	}

	/**
	 * @param gainOr the gainOr to set
	 */
	public void setGainOr(Integer gainOr) {
		this.gainOr = gainOr;
	}

	/**
	 * @return the gainNourriture
	 */
	public Integer getGainNourriture() {
		return gainNourriture;
	}

	/**
	 * @param gainNourriture the gainNourriture to set
	 */
	public void setGainNourriture(Integer gainNourriture) {
		this.gainNourriture = gainNourriture;
	}

}
