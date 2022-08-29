package fr.eni.ecole.projetEncheres.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.ecole.projetEncheres.bo.Utilisateur;

public interface UtilisateurDAO extends JpaRepository<Utilisateur, Integer>{

}
