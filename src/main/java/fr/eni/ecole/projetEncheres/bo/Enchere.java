package fr.eni.ecole.projetEncheres.bo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Enchere {
	
	@NotNull
	private LocalDate dateEnchere;
	@NotNull
	private int montant_enchere;
	
	@NotNull
	@OneToMany
	private ArticleVendu article;
	@NotNull
	@OneToMany
	private Utilisateur utilisateur;
	/**
	 * 
	 */
	public Enchere() {
	}
	/**
	 * @param dateEnchere
	 * @param montant_enchere
	 */
	public Enchere(LocalDate dateEnchere, int montant_enchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montant_enchere = montant_enchere;
	}
	/**
	 * @param dateEnchere
	 * @param montant_enchere
	 * @param article
	 * @param utilisateur
	 */
	public Enchere(LocalDate dateEnchere, int montant_enchere, ArticleVendu article, Utilisateur utilisateur) {
		this.dateEnchere = dateEnchere;
		this.montant_enchere = montant_enchere;
		this.article = article;
		this.utilisateur = utilisateur;
	}
	
	//autres méthodes
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Enchere [dateEnchere=");
		builder.append(dateEnchere);
		builder.append(", montant_enchere=");
		builder.append(montant_enchere);
		builder.append(", article=");
		builder.append(article);
		builder.append(", utilisateur=");
		builder.append(utilisateur);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
	//getters et setters
	/**
	 * @return the dateEnchere
	 */
	public LocalDate getDateEnchere() {
		return dateEnchere;
	}
	
	/**
	 * @param dateEnchere the dateEnchere to set
	 */
	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	/**
	 * @return the montant_enchere
	 */
	public int getMontant_enchere() {
		return montant_enchere;
	}
	/**
	 * @param montant_enchere the montant_enchere to set
	 */
	public void setMontant_enchere(int montant_enchere) {
		this.montant_enchere = montant_enchere;
	}
	/**
	 * @return the article
	 */
	public ArticleVendu getArticle() {
		return article;
	}
	/**
	 * @param article the article to set
	 */
	public void setArticle(ArticleVendu article) {
		this.article = article;
	}
	/**
	 * @return the utilisateur
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	/**
	 * @param utilisateur the utilisateur to set
	 */
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
	

	@NotNull
	private LocalDate dateEnchere;
	@NotNull
	private int montant_enchere;

	@NotNull
	@OneToMany
	private ArticleVendu article;
	@NotNull
	@OneToMany
	private Utilisateur utilisateur;

	/**
	 *
	 */
	public Enchere() {
	}

	/**
	 * @param dateEnchere
	 * @param montant_enchere
	 */
	public Enchere(LocalDate dateEnchere, int montant_enchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montant_enchere = montant_enchere;
	}

	/**
	 * @param dateEnchere
	 * @param montant_enchere
	 * @param article
	 * @param utilisateur
	 */
	public Enchere(LocalDate dateEnchere, int montant_enchere, ArticleVendu article, Utilisateur utilisateur) {
		this.dateEnchere = dateEnchere;
		this.montant_enchere = montant_enchere;
		this.article = article;
		this.utilisateur = utilisateur;
	}

	// autres méthodes

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Enchere [dateEnchere=");
		builder.append(dateEnchere);
		builder.append(", montant_enchere=");
		builder.append(montant_enchere);
		builder.append(", article=");
		builder.append(article);
		builder.append(", utilisateur=");
		builder.append(utilisateur);
		builder.append("]");
		return builder.toString();
	}

	// getters et setters
	/**
	 * @return the dateEnchere
	 */
	public LocalDate getDateEnchere() {
		return dateEnchere;
	}

	/**
	 * @param dateEnchere the dateEnchere to set
	 */
	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	/**
	 * @return the montant_enchere
	 */
	public int getMontant_enchere() {
		return montant_enchere;
	}

	/**
	 * @param montant_enchere the montant_enchere to set
	 */
	public void setMontant_enchere(int montant_enchere) {
		this.montant_enchere = montant_enchere;
	}

	/**
	 * @return the article
	 */
	public ArticleVendu getArticle() {
		return article;
	}

	/**
	 * @param article the article to set
	 */
	public void setArticle(ArticleVendu article) {
		this.article = article;
	}

	/**
	 * @return the utilisateur
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	/**
	 * @param utilisateur the utilisateur to set
	 */
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
}