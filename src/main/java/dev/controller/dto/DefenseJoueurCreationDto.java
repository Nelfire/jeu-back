package dev.controller.dto;

public class DefenseJoueurCreationDto {

	private Integer idDefense;
	private Integer quantite;
	/**
	 * @param idDefense
	 * @param quantite
	 */
	public DefenseJoueurCreationDto(Integer idDefense, Integer quantite) {
		super();
		this.idDefense = idDefense;
		this.quantite = quantite;
	}
	/**
	 * @return the idDefense
	 */
	public Integer getIdDefense() {
		return idDefense;
	}
	/**
	 * @param idDefense the idDefense to set
	 */
	public void setIdDefense(Integer idDefense) {
		this.idDefense = idDefense;
	}
	/**
	 * @return the quantite
	 */
	public Integer getQuantite() {
		return quantite;
	}
	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}
	
	
	
}
