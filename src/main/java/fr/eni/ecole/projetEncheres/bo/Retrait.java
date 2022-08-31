package fr.eni.ecole.projetEncheres.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Retrait {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@NotNull
	private String rue;
	@NotNull
	private String codePostal;
	@NotNull
	private String ville;
	
	
	public Retrait() {
	}
	
	
	public Retrait(@NotNull int id, @NotNull String rue, @NotNull String codePostal, @NotNull String ville) {
		this.id = id;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	
	public Retrait(@NotNull String rue, @NotNull String codePostal, @NotNull String ville) {
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	public String getRue() {
		return rue;
	}


	public void setRue(String rue) {
		this.rue = rue;
	}


	public String getCodePostal() {
		return codePostal;
	}


	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


//	public ArticleVendu getArticle() {
//		return article;
//	}
//
//
//	public void setArticle(ArticleVendu article) {
//		this.article = article;
//	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Retrait [rue=");
		builder.append(rue);
		builder.append(", id=");
		builder.append(id);
		builder.append(", codePostal=");
		builder.append(codePostal);
		builder.append(", ville=");
		builder.append(ville);
		builder.append("]");
		return builder.toString();
	}	

}
