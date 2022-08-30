package fr.eni.ecole.projetEncheres.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.ecole.projetEncheres.bo.Categorie;


public interface CategorieDAO extends JpaRepository<Categorie, Integer>{

	Categorie findByLibelle(String libelle);

}
