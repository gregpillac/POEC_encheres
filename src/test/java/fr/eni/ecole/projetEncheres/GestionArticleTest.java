package fr.eni.ecole.projetEncheres;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import fr.eni.ecole.projetEncheres.bll.GestionArticleVendu;
import fr.eni.ecole.projetEncheres.bll.GestionCategorie;
import fr.eni.ecole.projetEncheres.bll.GestionRetrait;
import fr.eni.ecole.projetEncheres.bll.GestionUtilisateur;
import fr.eni.ecole.projetEncheres.bo.ArticleVendu;
import fr.eni.ecole.projetEncheres.bo.Categorie;
import fr.eni.ecole.projetEncheres.bo.Retrait;
import fr.eni.ecole.projetEncheres.bo.Utilisateur;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
@ComponentScan({ "fr.eni.ecole.projetEncheres.bll",
	"fr.eni.ecole.projetEncheres.dal",
	"fr.eni.ecole.projetEncheres.bo"})

class GestionArticleTest {
	@Autowired
	GestionUtilisateur beanGestionUser;
	@Autowired
	GestionArticleVendu beanGestionArticle;
	@Autowired
	GestionCategorie beanGestionCate;
	@Autowired
	GestionRetrait beanGestionRetrait;
	
	@Test
	void test01CreerUnArticle() {
		Utilisateur u = beanGestionUser.trouverUtilisateurByLogin("toto");
		assertNotNull(u);
		assertTrue(u.getNoUtilisateur()>0);
		System.err.println(u.toString());
		
		Categorie c = beanGestionCate.trouverCategorieByLibelle("Loisir");
		assertNotNull(c);
		System.err.println(c.toString());
		
		Retrait r = new Retrait("3 rue du Retrait", "79000", "Niort");
		beanGestionRetrait.creerRetrait(r);
		
		ArticleVendu a = new ArticleVendu(
				"cd",
				"cd ACDC",
				LocalDate.of(2022, 9, 5),
				LocalDate.of(2022, 9, 25),
				20,
				u,
				c,
				r);
		beanGestionArticle.creerArticle(a);
				
		Optional<ArticleVendu> a2 = beanGestionArticle.trouverArticleById(a.getNoArticle());
		assertNotNull(a2);
		System.err.println(a2);		
	}
	
	@Test
	void test02ListerArticles() {		
		List<ArticleVendu> articles = beanGestionArticle.listeArticles();
		assertTrue(articles.size() > 0);
	}
	
	@Test
	void test03ModifierArticle() throws Exception {
		List<ArticleVendu> articles = beanGestionArticle.listeArticles();
		int firstId = articles.get(0).getNoArticle();

		ArticleVendu avantModif = beanGestionArticle.trouverArticleById(firstId).get();
		avantModif.setPrixVente(0);
		beanGestionArticle.modifierArticleById(avantModif);	
		
		ArticleVendu aModifier = beanGestionArticle.trouverArticleById(firstId).get();
		aModifier.setPrixVente(100);;
		beanGestionArticle.modifierArticleById(aModifier);
		
		ArticleVendu apresModif = beanGestionArticle.trouverArticleById(firstId).get();
		
		assertNotEquals(avantModif.getPrixVente(), apresModif.getPrixVente());
		System.err.println("Prix avant : " + avantModif.getPrixVente());
		System.err.println("Prix apres : " + apresModif.getPrixVente());
	}
	
	@Test
	void test04SupprimerArticle() throws Exception {
		List<ArticleVendu> articles = beanGestionArticle.listeArticles();
		int firstId = articles.get(0).getNoArticle();
		
		ArticleVendu artToDelete = beanGestionArticle.trouverArticleById(firstId).get();
		
		beanGestionArticle.supprimerArticle(artToDelete);
		Optional<ArticleVendu> artDeleted = beanGestionArticle.trouverArticleById(firstId);
		
		assertTrue(artDeleted.isEmpty());
	}

}
