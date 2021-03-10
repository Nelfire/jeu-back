package dev.controller.dto.joueur;

public class InformationRessourcesJoueur {
	private Integer apportPierreSeconde;
	private Integer apportBoisSeconde;
	private Integer apportOrSeconde;
	private Integer apportNourritureSeconde;
	private Long quantiteMaximaleStockagePierre;
	private Long quantiteMaximaleStockageBois;
	private Long quantiteMaximaleStockageOr;
	private Long quantiteMaximaleStockageNourriture;
	private Long pierrePossession;
	private Long boisPossession;
	private Long orPossession;
	private Long nourriturePossession;
	private Long gemmePossession;

	/**
	 * 
	 */
	public InformationRessourcesJoueur() {
		super();
	}

	/**
	 * @param apportPierreSeconde
	 * @param apportBoisSeconde
	 * @param apportOrSeconde
	 * @param apportNourritureSeconde
	 * @param quantiteMaximaleStockagePierre
	 * @param quantiteMaximaleStockageBois
	 * @param quantiteMaximaleStockageOr
	 * @param quantiteMaximaleStockageNourriture
	 * @param pierrePossession
	 * @param boisPossession
	 * @param orPossession
	 * @param nourriturePossession
	 * @param gemmePossession
	 */
	public InformationRessourcesJoueur(Integer apportPierreSeconde, Integer apportBoisSeconde, Integer apportOrSeconde,
			Integer apportNourritureSeconde, Long quantiteMaximaleStockagePierre, Long quantiteMaximaleStockageBois,
			Long quantiteMaximaleStockageOr, Long quantiteMaximaleStockageNourriture, Long pierrePossession,
			Long boisPossession, Long orPossession, Long nourriturePossession, Long gemmePossession) {
		super();
		this.apportPierreSeconde = apportPierreSeconde;
		this.apportBoisSeconde = apportBoisSeconde;
		this.apportOrSeconde = apportOrSeconde;
		this.apportNourritureSeconde = apportNourritureSeconde;
		this.quantiteMaximaleStockagePierre = quantiteMaximaleStockagePierre;
		this.quantiteMaximaleStockageBois = quantiteMaximaleStockageBois;
		this.quantiteMaximaleStockageOr = quantiteMaximaleStockageOr;
		this.quantiteMaximaleStockageNourriture = quantiteMaximaleStockageNourriture;
		this.pierrePossession = pierrePossession;
		this.boisPossession = boisPossession;
		this.orPossession = orPossession;
		this.nourriturePossession = nourriturePossession;
		this.gemmePossession = gemmePossession;
	}

	/**
	 * @return the apportPierreSeconde
	 */
	public Integer getApportPierreSeconde() {
		return apportPierreSeconde;
	}

	/**
	 * @return the apportBoisSeconde
	 */
	public Integer getApportBoisSeconde() {
		return apportBoisSeconde;
	}

	/**
	 * @return the apportOrSeconde
	 */
	public Integer getApportOrSeconde() {
		return apportOrSeconde;
	}

	/**
	 * @return the apportNourritureSeconde
	 */
	public Integer getApportNourritureSeconde() {
		return apportNourritureSeconde;
	}

	/**
	 * @return the quantiteMaximaleStockagePierre
	 */
	public Long getQuantiteMaximaleStockagePierre() {
		return quantiteMaximaleStockagePierre;
	}

	/**
	 * @return the quantiteMaximaleStockageBois
	 */
	public Long getQuantiteMaximaleStockageBois() {
		return quantiteMaximaleStockageBois;
	}

	/**
	 * @return the quantiteMaximaleStockageOr
	 */
	public Long getQuantiteMaximaleStockageOr() {
		return quantiteMaximaleStockageOr;
	}

	/**
	 * @return the quantiteMaximaleStockageNourriture
	 */
	public Long getQuantiteMaximaleStockageNourriture() {
		return quantiteMaximaleStockageNourriture;
	}

	/**
	 * @return the pierrePossession
	 */
	public Long getPierrePossession() {
		return pierrePossession;
	}

	/**
	 * @return the boisPossession
	 */
	public Long getBoisPossession() {
		return boisPossession;
	}

	/**
	 * @return the orPossession
	 */
	public Long getOrPossession() {
		return orPossession;
	}

	/**
	 * @return the nourriturePossession
	 */
	public Long getNourriturePossession() {
		return nourriturePossession;
	}

	/**
	 * @return the gemmePossession
	 */
	public Long getGemmePossession() {
		return gemmePossession;
	}

	/**
	 * @param apportPierreSeconde the apportPierreSeconde to set
	 */
	public void setApportPierreSeconde(Integer apportPierreSeconde) {
		this.apportPierreSeconde = apportPierreSeconde;
	}

	/**
	 * @param apportBoisSeconde the apportBoisSeconde to set
	 */
	public void setApportBoisSeconde(Integer apportBoisSeconde) {
		this.apportBoisSeconde = apportBoisSeconde;
	}

	/**
	 * @param apportOrSeconde the apportOrSeconde to set
	 */
	public void setApportOrSeconde(Integer apportOrSeconde) {
		this.apportOrSeconde = apportOrSeconde;
	}

	/**
	 * @param apportNourritureSeconde the apportNourritureSeconde to set
	 */
	public void setApportNourritureSeconde(Integer apportNourritureSeconde) {
		this.apportNourritureSeconde = apportNourritureSeconde;
	}

	/**
	 * @param quantiteMaximaleStockagePierre the quantiteMaximaleStockagePierre to
	 *                                       set
	 */
	public void setQuantiteMaximaleStockagePierre(Long quantiteMaximaleStockagePierre) {
		this.quantiteMaximaleStockagePierre = quantiteMaximaleStockagePierre;
	}

	/**
	 * @param quantiteMaximaleStockageBois the quantiteMaximaleStockageBois to set
	 */
	public void setQuantiteMaximaleStockageBois(Long quantiteMaximaleStockageBois) {
		this.quantiteMaximaleStockageBois = quantiteMaximaleStockageBois;
	}

	/**
	 * @param quantiteMaximaleStockageOr the quantiteMaximaleStockageOr to set
	 */
	public void setQuantiteMaximaleStockageOr(Long quantiteMaximaleStockageOr) {
		this.quantiteMaximaleStockageOr = quantiteMaximaleStockageOr;
	}

	/**
	 * @param quantiteMaximaleStockageNourriture the
	 *                                           quantiteMaximaleStockageNourriture
	 *                                           to set
	 */
	public void setQuantiteMaximaleStockageNourriture(Long quantiteMaximaleStockageNourriture) {
		this.quantiteMaximaleStockageNourriture = quantiteMaximaleStockageNourriture;
	}

	/**
	 * @param pierrePossession the pierrePossession to set
	 */
	public void setPierrePossession(Long pierrePossession) {
		this.pierrePossession = pierrePossession;
	}

	/**
	 * @param boisPossession the boisPossession to set
	 */
	public void setBoisPossession(Long boisPossession) {
		this.boisPossession = boisPossession;
	}

	/**
	 * @param orPossession the orPossession to set
	 */
	public void setOrPossession(Long orPossession) {
		this.orPossession = orPossession;
	}

	/**
	 * @param nourriturePossession the nourriturePossession to set
	 */
	public void setNourriturePossession(Long nourriturePossession) {
		this.nourriturePossession = nourriturePossession;
	}

	/**
	 * @param gemmePossession the gemmePossession to set
	 */
	public void setGemmePossession(Long gemmePossession) {
		this.gemmePossession = gemmePossession;
	}

	@Override
	public String toString() {
		return "InformationRessourcesJoueur [apportPierreSeconde=" + apportPierreSeconde + ", apportBoisSeconde="
				+ apportBoisSeconde + ", apportOrSeconde=" + apportOrSeconde + ", apportNourritureSeconde="
				+ apportNourritureSeconde + ", quantiteMaximaleStockagePierre=" + quantiteMaximaleStockagePierre
				+ ", quantiteMaximaleStockageBois=" + quantiteMaximaleStockageBois + ", quantiteMaximaleStockageOr="
				+ quantiteMaximaleStockageOr + ", quantiteMaximaleStockageNourriture="
				+ quantiteMaximaleStockageNourriture + ", pierrePossession=" + pierrePossession + ", boisPossession="
				+ boisPossession + ", orPossession=" + orPossession + ", nourriturePossession=" + nourriturePossession
				+ ", gemmePossession=" + gemmePossession + "]";
	}

}
