package dev.controller.dto;

public class ArmeeJoueurCreationDto {

	private Integer idUnitee;
	private Integer quantitee;
	/**
	 * @param idUnitee
	 * @param quantitee
	 */
	public ArmeeJoueurCreationDto(Integer idUnitee, Integer quantitee) {
		super();
		this.idUnitee = idUnitee;
		this.quantitee = quantitee;
	}
	/**
	 * @return the idUnitee
	 */
	public Integer getIdUnitee() {
		return idUnitee;
	}
	/**
	 * @param idUnitee the idUnitee to set
	 */
	public void setIdUnitee(Integer idUnitee) {
		this.idUnitee = idUnitee;
	}
	/**
	 * @return the quantitee
	 */
	public Integer getQuantitee() {
		return quantitee;
	}
	/**
	 * @param quantitee the quantitee to set
	 */
	public void setQuantitee(Integer quantitee) {
		this.quantitee = quantitee;
	}

	
	
	
}
