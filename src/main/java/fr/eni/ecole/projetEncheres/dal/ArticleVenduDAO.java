package fr.eni.ecole.projetEncheres.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.ecole.projetEncheres.bo.ArticleVendu;


public interface ArticleVenduDAO extends JpaRepository<ArticleVendu, Integer>{


}
