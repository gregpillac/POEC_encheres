package fr.eni.ecole.projetEncheres.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.ecole.projetEncheres.bo.ArticleVendu;
import fr.eni.ecole.projetEncheres.bo.Enchere;
import fr.eni.ecole.projetEncheres.bo.Utilisateur;



public interface EnchereDAO extends JpaRepository<Enchere, Integer> {

	List<Enchere> findByArticle(ArticleVendu a);

	List<Enchere> findByUtilisateur(Utilisateur u);

	
}
