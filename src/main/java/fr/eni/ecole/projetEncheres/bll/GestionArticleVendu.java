package fr.eni.ecole.projetEncheres.bll;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.ecole.projetEncheres.bo.ArticleVendu;
import fr.eni.ecole.projetEncheres.bo.ArticleVendu.EtatVente;
import fr.eni.ecole.projetEncheres.dal.ArticleVenduDAO;

@Service
public class GestionArticleVendu {
	
	@Autowired
	ArticleVenduDAO dao;
	
	public void creerArticle(ArticleVendu a) {
			dao.save(a);
	}
	
	public List<ArticleVendu> listeArticles() {
		List<ArticleVendu> articles = dao.findAll();
		return articles;
	}
	
	public Optional<ArticleVendu> trouverArticleById (int id) {
		Optional<ArticleVendu> article = dao.findById(id);
		/*if (articleTrouve.isPresent()) {
			article = articleTrouve.get(); ---> pêrmet de recup l objet s'il n'est pas vide / a tester dans le controller
		}*/ 
		return article;
	}
	
	public void modifierArticle (ArticleVendu art) throws Exception {
		Optional<ArticleVendu> articleToFind = dao.findById(art.getNoArticle());
		if (articleToFind.isPresent()) {
			ArticleVendu article = articleToFind.get();
			if (LocalDate.now().isBefore(article.getDateDebutEncheres())) {
				dao.save(art);
			} else {
				throw new Exception("Trop tard pour modifier");
			}
		} else {
			throw new Exception("Article non present");
		}
		//TODO : gerer les exceptions de modifArticle ou condition dans Controller
	}
	
	public void miseAJourPrixVente (ArticleVendu art) throws Exception {
		Optional<ArticleVendu> articleToFind = dao.findById(art.getNoArticle());
		if (articleToFind.isPresent()) {
			ArticleVendu article = articleToFind.get();
			dao.save(art);			
		} else {
			throw new Exception("Article non present");
		}
		//TODO : gerer les exceptions de modifArticle ou condition dans Controller
	}
	
	
	public void supprimerArticle (ArticleVendu art) throws Exception {
		Optional<ArticleVendu> articleToFind = dao.findById(art.getNoArticle());
		if (articleToFind.isPresent()) {
			ArticleVendu article = articleToFind.get();
			
			if (LocalDate.now().isBefore(article.getDateDebutEncheres())) {
				dao.delete(art);
			} else {
				throw new Exception("Trop tard pour supprimer");
			}
		} else {
			throw new Exception("Article non present");
		}
		//TODO : gerer les exceptions de suppressionArticle
	}
	
	public void majEtatdeVente() throws Exception{
		// TODO : gerer l'etat de vente en batch ou procedure stockée ??

		List<ArticleVendu> articles = dao.findAll();
		LocalDate now = LocalDate.now();
		for (ArticleVendu a : articles) {
			if (a.getDateFinEncheres().isEqual(now) || a.getDateFinEncheres().isBefore(now)) {
				a.setEtatVente(EtatVente.TERMINEE);
				modifierArticle(a);
				System.err.println("passage en condition termine");
			} else if (a.getDateDebutEncheres().isEqual(now) || a.getDateDebutEncheres().isBefore(now)) {
				a.setEtatVente(EtatVente.ENCOURS);
				modifierArticle(a);
				System.err.println("passage en condition en cours");
			} System.err.println("bordel");
		}
	}
	
	public void etatVenteRetire(ArticleVendu art) throws Exception {
		art.setEtatVente(EtatVente.RETIREE);
		modifierArticle(art);
	}
	
}
  