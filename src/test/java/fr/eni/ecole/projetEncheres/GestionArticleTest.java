package fr.eni.ecole.projetEncheres;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
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
		System.err.println(u.toString());
		
		LocalDate dateDebut = LocalDate.of(2022, 9, 5);
		LocalDate dateFin = LocalDate.of(2022, 9, 25);
		
		System.err.println(dateDebut);
		System.err.println(dateFin);

		Retrait r = new Retrait("3 rue du Retrait", "79000", "Niort");
		beanGestionRetrait.creerRetrait(r);
		ArticleVendu a = new ArticleVendu("cd", "cd ACDC", dateDebut, dateFin, 20, u, c, r);
		beanGestionArticle.creerArticle(a);
		
		Optional<ArticleVendu> a2 = beanGestionArticle.chercherArticleById(1);
		assertNotNull(a2);
		System.err.println(a);	
		
	}

}
