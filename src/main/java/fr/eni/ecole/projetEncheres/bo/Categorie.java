package fr.eni.ecole.projetEncheres.bo;

import java.util.List;

/**
 * @author sbodin2022
 *
 */
public class Categorie {

	private int noCategorie;
	private String libelle;

	private List<ArticleVendu> articles;

	/**
	 * 
	 */
	public Categorie() {
	}

	/**
	 * @param noCategorie
	 * @param libelle
	 */
	public Categorie(int noCategorie, String libelle) {
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}

	/**
	 * @param noCategorie
	 * @param libelle
	 * @param articles
	 */
	public Categorie(int noCategorie, String libelle, List<ArticleVendu> articles) {
		this.noCategorie = noCategorie;
		this.libelle = libelle;
		this.articles = articles;
	}

	// autres méthodes

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Categorie [noCategorie=");
		builder.append(noCategorie);
		builder.append(", libelle=");
		builder.append(libelle);
		builder.append("]");
		return builder.toString();
	}
	
	

	// getters et setters
	/**
	 * @return the noCategorie
	 */
	public int getNoCategorie() {
		return noCategorie;
	}

	/**
	 * @param noCategorie the noCategorie to set
	 */
	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
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

}

