package fr.eni.ecole.projetEncheres.bo;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**
 * @author sbodin2022
 *
 */
@Entity
public class Categorie {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int noCategorie;
	@NotBlank
	private String libelle;

	

	/**
	 * 
	 */
	public Categorie() {
	}

	/**
	 * @param noCategorie
	 * @param libelle
	 */
	public Categorie(String libelle) {		
		this.libelle = libelle;
	}

	/**
	 * @param noCategorie
	 * @param libelle
	 * @param articles
	 */
	public Categorie(int noCategorie, String libelle) {
		this.noCategorie = noCategorie;
		this.libelle = libelle;
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

