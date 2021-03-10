package dev.controller.dto.social;

public class AjoutAmiDto {

	private Integer idAmi;

	/**
	 * CONSTRUCTEUR VIDE
	 */
	public AjoutAmiDto() {

	}

	/**
	 * CONSTRUCTEUR AVEC PARAMETRES
	 */
	public AjoutAmiDto(Integer idAmi) {
		super();
		this.idAmi = idAmi;
	}

	/**
	 * @return the idAmi
	 */
	public Integer getIdAmi() {
		return idAmi;
	}

	/**
	 * @param idAmi the idAmi to set
	 */
	public void setIdAmi(Integer idAmi) {
		this.idAmi = idAmi;
	}

}
