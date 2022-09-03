package fr.eni.ecole.projetEncheres;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import fr.eni.ecole.projetEncheres.bll.GestionArticleVendu;
import fr.eni.ecole.projetEncheres.bll.GestionCategorie;
import fr.eni.ecole.projetEncheres.bll.GestionEnchere;
import fr.eni.ecole.projetEncheres.bll.GestionUtilisateur;
import fr.eni.ecole.projetEncheres.bo.ArticleVendu;
import fr.eni.ecole.projetEncheres.bo.Categorie;
import fr.eni.ecole.projetEncheres.bo.Enchere;
import fr.eni.ecole.projetEncheres.bo.Utilisateur;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
@ComponentScan({ "fr.eni.ecole.projetEncheres.bll",
	"fr.eni.ecole.projetEncheres.dal",
	"fr.eni.ecole.projetEncheres.bo"})

class GestionEnchereTest {
	
	@Autowired
	GestionArticleVendu beanGA;
	@Autowired
	GestionUtilisateur beanGU;
	@Autowired
	GestionEnchere beanGE;
	@Autowired
	GestionCategorie beanGC;
/*	
	@Test
	void testCreationEnchere() throws Exception {
		ArticleVendu a1= beanGA.trouverArticleById(3).get();
		ArticleVendu a2= beanGA.trouverArticleById(4).get();
		ArticleVendu a3= beanGA.trouverArticleById(6).get();
		assertNotNull(a1);
		System.err.println(a1);		
		Utilisateur u1 = beanGU.trouverUtilisateurByLogin("gege");
		assertNotNull(u1);	
		Utilisateur u2 = beanGU.trouverUtilisateurByLogin("tata");
		System.err.println(u2);
		System.err.println(u2.getCredit());	
		
		Enchere e1 = beanGE.creationEnchere(30, u1, a1);
	
		Enchere e3 = beanGE.creationEnchere(25, u1, a3);
		
	
		assertNotNull(e1.getId()>0);
		System.err.println(u2.getCredit());		
	
		Enchere e2 = beanGE.creationEnchere(50, u1, a1);
	
		System.err.println(u2.getCredit());	
		assertNotNull(e2);
		assertTrue(e2.getId()>0);
		
	}
*/	
	
	@Test
	void test01ListerEncheresConnexion() {
		List<Enchere> encheres = beanGE.listerEncheresConnexion();
		assertNotNull(encheres);
		System.err.println(encheres);
	}

	@Test
	void testListerMesEncheresConnexion() {
		Utilisateur u = beanGU.trouverUtilisateurByLogin("gege");
		assertNotNull(u);
		List<Enchere> encheres = beanGE.listerMesEncheresConnexion(u);
		assertNotNull(encheres);
		System.err.println(encheres);
	}

	@Test
	void testListerMesEncheresGagnees() {
		Utilisateur u = beanGU.trouverUtilisateurByLogin("gege");
		assertNotNull(u);
		List<Enchere> encheres = beanGE.listerMesEncheresGagnees(u);
		assertNotNull(encheres);
		System.err.println(encheres);		
	}

	@Test
	void testListerEncheresEnCoursHorsConnexion() {
		List<Enchere> encheres = beanGE.listerEncheresEnCoursHorsConnexion();
		assert(encheres.size()==3);
		System.err.println(encheres.get(0).getArticle().getCategorie()    +"   "+encheres.get(1).getArticle().getCategorie() +"    "+encheres.get(2).getArticle().getCategorie() );
		
	}

	@Test
	void testListerEncheresEnCoursParCategorieHorsConnexion() {
		Categorie c = beanGC.trouverCategorieByLibelle("Autre");
		System.err.println(c);
		List<Enchere> encheres = beanGE.listerEncheresEnCoursParCategorieHorsConnexion(c);
		System.err.println(encheres);
	}

	@Test
	void testListerEncheresEnCoursParNomArticleHorsConnexion() {
		ArticleVendu a = beanGA.trouverArticleById(3).get();
		System.err.println(a.getNomArticle());
		List<Enchere> encheres = beanGE.listerEncheresEnCoursParNomArticleHorsConnexion(a);
		System.err.println(encheres);
		assert(encheres.size()==2);
	}
/*
	@Test
	void testDernierUtilisateurEnchere() {
		fail("Test fonctionnel OK");
	}
*/
	

}
