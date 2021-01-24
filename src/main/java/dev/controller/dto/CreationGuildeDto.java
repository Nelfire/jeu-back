package dev.controller.dto;

public class CreationGuildeDto {

	private String libelle;
	private String icone;
	/**
	 * @param libelle
	 * @param icone
	 */
	public CreationGuildeDto(String libelle, String icone) {
		super();
		this.libelle = libelle;
		this.icone = icone;
	}
	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}
	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	/**
	 * @return the icone
	 */
	public String getIcone() {
		return icone;
	}
	/**
	 * @param icone the icone to set
	 */
	public void setIcone(String icone) {
		this.icone = icone;
	}
	
	
}
