package fr.eni.ecole.projetEncheres;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import fr.eni.ecole.projetEncheres.bll.GestionUtilisateur;
import fr.eni.ecole.projetEncheres.bo.Utilisateur;


@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
@ComponentScan({ "fr.eni.ecole.projetEncheres.bll",
	"fr.eni.ecole.projetEncheres.dal",
	"fr.eni.ecole.projetEncheres.bo"})

class GestionUtilisateurTest {
	
	@Autowired
	private GestionUtilisateur beanGestionUser;
	
	@Test
	public void test01CreerUtilisateur() {
		
		Utilisateur toto = new Utilisateur(
				"Toto", "NomToot", "PrenomToto", "toto@toto.com", "06254658965",
				"rue de la toto", "75000", "totoVille", "toto79");
		assertNotNull(toto);
		System.out.println(toto.toString());
		
		Utilisateur tata = new Utilisateur(
				"Tata", "NomTata", "PrenomTata", "tata@toto.com", null,
				"rue de la Tata", "17000", "TataVille", "tata17");
		assertNotNull(tata);
		System.out.println(tata.toString());
		
		beanGestionUser.creerUtilisateur(toto);
		assertTrue(toto.getNoUtilisateur()>0);
		
		beanGestionUser.creerUtilisateur(tata);
		assertTrue(tata.getNoUtilisateur()>1);
		
		List<Utilisateur> utilisateurs = beanGestionUser.listeUtilisateurs();
		assertTrue(utilisateurs.size()==2);
		
	}
	

	@Test
	public void test02TrouverUnUtilisateurParPseudo() {
		Utilisateur u = beanGestionUser.trouverUtilisateurByLogin("Toto");
		assertNotNull(u);
		System.err.println(u.toString());
		Utilisateur u1 = beanGestionUser.trouverUtilisateurByLogin("titi");
		assertNull(u1);
	}
	
	@Test
	public void test03TrouverUnUtilisateurParId() {
		
	}
	
	@Test
	public void test04SupprimerUtilisateur() {
		Utilisateur tata = new Utilisateur(
				"Tata", "NomTata", "PrenomTata", "tata@toto.com", null,
				"rue de la Tata", "17000", "TataVille", "tata17");
		beanGestionUser.supprimerUtilisateur(tata);
		System.err.println(tata.toString());		
	}
	
	@Test
	public void test05ModififierUtilisateur() {
		Utilisateur toto = beanGestionUser.trouverUtilisateurByLogin("Toto");
		toto.setPrenom("Antonin");
		beanGestionUser.modifierUtilisateur(toto);
		}
}
