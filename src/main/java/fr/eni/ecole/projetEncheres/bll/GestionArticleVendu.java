package fr.eni.ecole.projetEncheres.bll;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.ecole.projetEncheres.bo.ArticleVendu;
import fr.eni.ecole.projetEncheres.dal.ArticleVenduDAO;

@Service
public class GestionArticleVendu {
	
	@Autowired
	ArticleVenduDAO dao;
	
	public void creerArticle(ArticleVendu a) {
			dao.save(a);
	}
	
	public Optional<ArticleVendu> chercherArticleById (int id) {
		Optional<ArticleVendu> article = dao.findById(id);
		/*if (articleTrouve.isPresent()) {
			article = articleTrouve.get(); ---> pêrmet de recup l objet s'il n'est pas vide / a tester dans le controller
		}*/ 
		return article;
	}
}
