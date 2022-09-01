package fr.eni.ecole.projetEncheres;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
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
import fr.eni.ecole.projetEncheres.bo.ArticleVendu.EtatVente;
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
		beanGestionArticle.modifierArticle(avantModif);	
		
		ArticleVendu aModifier = beanGestionArticle.trouverArticleById(firstId).get();
		aModifier.setPrixVente(100);
		aModifier.setEtatVente(EtatVente.RETIREE);
		beanGestionArticle.modifierArticle(aModifier);
		
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
		Optional<ArticleVendu> artDeleted = beanGestionArticle.trouverArticleById(artToDelete.getNoArticle());
		
		assertTrue(artDeleted.isEmpty());
	}

	
	@Test
	void test05MajAutoEtatDeVente() throws Exception {
		// pour test OK, supprimer la verification de date dans modifier article de 
		Utilisateur u = beanGestionUser.trouverUtilisateurByLogin("toto");
		Categorie c = beanGestionCate.trouverCategorieByLibelle("Loisir");
		Retrait r = new Retrait("14 rue du bas paradis", "79000", "Niort");
		beanGestionRetrait.creerRetrait(r);

		ArticleVendu a = new ArticleVendu(
				"dvd",
				"MyLittlePoney vol.5",
				LocalDate.of(2022, 9, 5), //date debut
				LocalDate.of(2022, 9, 25), // date fin
				20,
				u,
				c,
				r);
		
		beanGestionArticle.creerArticle(a);
		
		System.err.println("Au " + LocalDate.now() + " la vente est " + a.getEtatVente() + "(debut : "+a.getDateDebutEncheres()+" fin : "+a.getDateFinEncheres()+")");
		assertTrue(a.getEtatVente().equals(EtatVente.CREEE));
		
		a.setDateDebutEncheres(LocalDate.of(2022, 8, 1));
		beanGestionArticle.modifierArticle(a);
		System.err.println("date début modifiée en BDD");
		beanGestionArticle.majEtatdeVente();
		a = beanGestionArticle.trouverArticleById(a.getNoArticle()).get();
		System.err.println("exe de la maj des Etats de vente");
		System.err.println("Au " + LocalDate.now() + " la vente est " + a.getEtatVente() + "(debut : "+a.getDateDebutEncheres()+" fin : "+a.getDateFinEncheres()+")");
		assertTrue(a.getEtatVente().equals(EtatVente.ENCOURS));

		a.setDateFinEncheres(LocalDate.of(2022, 8, 30));
		beanGestionArticle.modifierArticle(a);
		beanGestionArticle.majEtatdeVente();
		a = beanGestionArticle.trouverArticleById(a.getNoArticle()).get();
		System.err.println("Au " + LocalDate.now() + " la vente est " + a.getEtatVente() + "(debut : "+a.getDateDebutEncheres()+" fin : "+a.getDateFinEncheres()+")");
		assertTrue(a.getEtatVente().equals(EtatVente.TERMINEE));

	}


}
