package fr.eni.ecole.projetEncheres.bo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Retrait {
	
	@Id
	@OneToOne
	private String noArticle ;
	@NotNull
	private String rue;
	@NotNull
	private String codePostal;
	@NotNull
	private String ville;
	
	@ManyToOne
	private ArticleVendu article ;

	
	public Retrait() {
	}
	
	public Retrait(String noArticle, @NotNull String rue, @NotNull String codePostal, @NotNull String ville,
			ArticleVendu article) {
		this.noArticle = noArticle;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.article = article;
	}

	
	public String getNoArticle() {
		return noArticle;
	}


	public void setNoArticle(String noArticle) {
		this.noArticle = noArticle;
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


	public ArticleVendu getArticle() {
		return article;
	}


	public void setArticle(ArticleVendu article) {
		this.article = article;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Retrait [noArticle=");
		builder.append(noArticle);
		builder.append(", rue=");
		builder.append(rue);
		builder.append(", codePostal=");
		builder.append(codePostal);
		builder.append(", ville=");
		builder.append(ville);
		builder.append(", article=");
		builder.append(article);
		builder.append("]");
		return builder.toString();
	}	

}
