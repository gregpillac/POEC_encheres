package fr.eni.ecole.projetEncheres;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import fr.eni.ecole.projetEncheres.bll.GestionCategorie;
import fr.eni.ecole.projetEncheres.bo.Categorie;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
@ComponentScan({ "fr.eni.ecole.projetEncheres.bll",
	"fr.eni.ecole.projetEncheres.dal",
	"fr.eni.ecole.projetEncheres.bo"})
class GestionCategoriesTest {

	@Autowired
    private GestionCategorie beanGestionCategorie;

	@Test
	void test00ListerCategorie() {
		List<Categorie> categories = beanGestionCategorie.listeCategories();
		assertTrue(categories.size()==0);
		System.err.println("test01");

	}
	
   @Test
    void test01CreerCategorie() {
        
        Categorie cat1 = new Categorie("Informatique");
        Categorie cat2 = new Categorie("Meuble");
        Categorie cat3 = new Categorie("Jeux");
        Categorie cat4 = new Categorie("Livres");
        Categorie cat5 = new Categorie("Electroménager");
        Categorie cat6 = new Categorie("Papeterie");
        Categorie cat7 = new Categorie("Loisir");
        Categorie cat8 = new Categorie("Autre");
        
        beanGestionCategorie.creerCategorie(cat1);
        beanGestionCategorie.creerCategorie(cat2);
        beanGestionCategorie.creerCategorie(cat3);
        beanGestionCategorie.creerCategorie(cat4);
        beanGestionCategorie.creerCategorie(cat5);
        beanGestionCategorie.creerCategorie(cat6);
        beanGestionCategorie.creerCategorie(cat7);
        beanGestionCategorie.creerCategorie(cat8);
        
		System.err.println("test02");

    }
   
   @Test
   void test02SupprimerCategorie() {
	   Categorie catAsupprimer = new Categorie("Autre");
	   beanGestionCategorie.supprimerCategorie(catAsupprimer);
	   
		System.err.println("test03");

   }
}
