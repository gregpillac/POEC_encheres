package fr.eni.ecole.projetEncheres.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.ecole.projetEncheres.bo.Utilisateur;
import fr.eni.ecole.projetEncheres.dal.UtilisateurDAO;

@Service
public class GestionUtilisateur {
	
	@Autowired
	UtilisateurDAO dao;
	
	public void creerUtilisateur(Utilisateur u) {
		dao.save(u);
	}

	public List<Utilisateur> listeUtilisateurs() {
		List<Utilisateur> utilisateurs = dao.findAll();
		return utilisateurs;
	}
}
