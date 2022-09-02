package fr.eni.ecole.projetEncheres;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import fr.eni.ecole.projetEncheres.bll.GestionArticleVendu;
import fr.eni.ecole.projetEncheres.bll.GestionEnchere;
import fr.eni.ecole.projetEncheres.bll.GestionUtilisateur;
import fr.eni.ecole.projetEncheres.bo.ArticleVendu;
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
	
	@Test
	void testCreationEnchere() throws Exception {
		ArticleVendu a1= beanGA.trouverArticleById(2).get();
		assertNotNull(a1);
		System.err.println(a1);		
		Utilisateur u1 = beanGU.trouverUtilisateurByLogin("gege");
		assertNotNull(u1);	
		Utilisateur u2 = beanGU.trouverUtilisateurByLogin("tata");
		System.err.println(u2);
		System.err.println(u2.getCredit());	
		
		Enchere e1 = beanGE.creationEnchere(30, u2, a1);
		System.err.println(u2.getCredit());		
		assertTrue(u2.getCredit()==170);
		Enchere e2 = beanGE.creationEnchere(50, u1, a1);
		assertTrue(u2.getCredit()==200);
		System.err.println(u2.getCredit());	
		assertNotNull(e2);
		assertTrue(e2.getId()>0);
	
		
		
		
	
	}

	@Test
	void test01ListerEncheresConnexion() {
		fail("Not yet implemented");
	}

	@Test
	void testListerMesEncheresConnexion() {
		fail("Not yet implemented");
	}

	@Test
	void testListerMesEncheresGagnees() {
		fail("Not yet implemented");
	}

	@Test
	void testListerEncheresEnCoursHorsConnexion() {
		fail("Not yet implemented");
	}

	@Test
	void testListerEncheresEnCoursParCategorieHorsConnexion() {
		fail("Not yet implemented");
	}

	@Test
	void testListerEncheresEnCoursParNomArticleHorsConnexion() {
		fail("Not yet implemented");
	}

	@Test
	void testDernierUtilisateurEnchere() {
		fail("Not yet implemented");
	}

	

}
