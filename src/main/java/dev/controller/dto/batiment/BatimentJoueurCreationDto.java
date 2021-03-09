package dev.controller.dto.batiment;

public class BatimentJoueurCreationDto {

	private Integer idBatiment;

	public BatimentJoueurCreationDto() {
		
	}
	/**
	 * @param batiment
	 */
	public BatimentJoueurCreationDto(Integer idBatiment) {
		super();
		this.idBatiment = idBatiment;
	}
	/**
	 * @return the idBatiment
	 */
	public Integer getIdBatiment() {
		return idBatiment;
	}
	/**
	 * @param idBatiment the idBatiment to set
	 */
	public void setIdBatiment(Integer idBatiment) {
		this.idBatiment = idBatiment;
	}
	
}
