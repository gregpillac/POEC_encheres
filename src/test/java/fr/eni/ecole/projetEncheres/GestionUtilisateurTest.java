package fr.eni.ecole.projetEncheres;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import fr.eni.ecole.projetEncheres.bll.GestionUtilisateur;
import fr.eni.ecole.projetEncheres.bo.Utilisateur;


@SpringBootTest
@ComponentScan({ "fr.eni.ecole.projetEncheres.bll",
	"fr.eni.ecole.projetEncheres.dal",
	"fr.eni.ecole.projetEncheres.bo"})
class GestionUtilisateurTest {
	
	@Autowired
	private GestionUtilisateur beanGestionUser;
	

	@Test
	public void testCreerUtilisateur() {
		
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
		
		// beanGestionUser.creerUtilisateur(toto);
		
	}

}