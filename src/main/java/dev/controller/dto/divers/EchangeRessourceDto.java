package dev.controller.dto.divers;

public class EchangeRessourceDto {

    private Integer montantPierre;
    private Integer montantBois;
    private Integer montantOr;
    private Integer montantNourriture;
    private Boolean etatPierre;
    private Boolean etatBois;
    private Boolean etatOr;
    private Boolean etatNourriture;
    
    public EchangeRessourceDto() {
    	
    }
	/**
	 * @param montantPierre
	 * @param montantBois
	 * @param montantOr
	 * @param montantNourriture
	 * @param etatPierre
	 * @param etatBois
	 * @param etatOr
	 * @param etatNourriture
	 */
	public EchangeRessourceDto(Integer montantPierre, Integer montantBois, Integer montantOr, Integer montantNourriture,
			Boolean etatPierre, Boolean etatBois, Boolean etatOr, Boolean etatNourriture) {
		super();
		this.montantPierre = montantPierre;
		this.montantBois = montantBois;
		this.montantOr = montantOr;
		this.montantNourriture = montantNourriture;
		this.etatPierre = etatPierre;
		this.etatBois = etatBois;
		this.etatOr = etatOr;
		this.etatNourriture = etatNourriture;
	}
	/**
	 * @return the montantPierre
	 */
	public Integer getMontantPierre() {
		return montantPierre;
	}
	/**
	 * @param montantPierre the montantPierre to set
	 */
	public void setMontantPierre(Integer montantPierre) {
		this.montantPierre = montantPierre;
	}
	/**
	 * @return the montantBois
	 */
	public Integer getMontantBois() {
		return montantBois;
	}
	/**
	 * @param montantBois the montantBois to set
	 */
	public void setMontantBois(Integer montantBois) {
		this.montantBois = montantBois;
	}
	/**
	 * @return the montantOr
	 */
	public Integer getMontantOr() {
		return montantOr;
	}
	/**
	 * @param montantOr the montantOr to set
	 */
	public void setMontantOr(Integer montantOr) {
		this.montantOr = montantOr;
	}
	/**
	 * @return the montantNourriture
	 */
	public Integer getMontantNourriture() {
		return montantNourriture;
	}
	/**
	 * @param montantNourriture the montantNourriture to set
	 */
	public void setMontantNourriture(Integer montantNourriture) {
		this.montantNourriture = montantNourriture;
	}
	/**
	 * @return the etatPierre
	 */
	public Boolean getEtatPierre() {
		return etatPierre;
	}
	/**
	 * @param etatPierre the etatPierre to set
	 */
	public void setEtatPierre(Boolean etatPierre) {
		this.etatPierre = etatPierre;
	}
	/**
	 * @return the etatBois
	 */
	public Boolean getEtatBois() {
		return etatBois;
	}
	/**
	 * @param etatBois the etatBois to set
	 */
	public void setEtatBois(Boolean etatBois) {
		this.etatBois = etatBois;
	}
	/**
	 * @return the etatOr
	 */
	public Boolean getEtatOr() {
		return etatOr;
	}
	/**
	 * @param etatOr the etatOr to set
	 */
	public void setEtatOr(Boolean etatOr) {
		this.etatOr = etatOr;
	}
	/**
	 * @return the etatNourriture
	 */
	public Boolean getEtatNourriture() {
		return etatNourriture;
	}
	/**
	 * @param etatNourriture the etatNourriture to set
	 */
	public void setEtatNourriture(Boolean etatNourriture) {
		this.etatNourriture = etatNourriture;
	}
    
    
}
