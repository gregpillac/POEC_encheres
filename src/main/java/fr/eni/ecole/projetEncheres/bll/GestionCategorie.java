package fr.eni.ecole.projetEncheres.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.ecole.projetEncheres.bo.Categorie;
import fr.eni.ecole.projetEncheres.dal.CategorieDAO;

@Service
public class GestionCategorie {
	
	@Autowired
	CategorieDAO dao;
	
	public void creerCategorie(Categorie cat) {
		Categorie catCherchee = dao.findByLibelle(cat.getLibelle());
		if ( catCherchee == null) {
			dao.save(cat);
		} else {
			System.err.println("La categorie existe déjà");
		}
	}
	
	public List<Categorie> listeCategories() {
		List<Categorie> categories = dao.findAll();
		return categories;
	}
	
	public Categorie trouverCategorieByLibelle(String libelle) {
		Categorie cat = null;
		Categorie catCherchee = dao.findByLibelle(libelle);
		if ( catCherchee != null) {
			cat = catCherchee;
		} else {
			System.err.println("La categorie n'existe pas");
		}
		return cat;
	}
	
	public void supprimerCategorie(Categorie cat) {
		Categorie catTrouvee = trouverCategorieByLibelle(cat.getLibelle());
		if (catTrouvee != null) {
			dao.deleteById(catTrouvee.getNoCategorie());
		} else {
			System.err.println("La categorie n'existe pas");
		}
	}
}
