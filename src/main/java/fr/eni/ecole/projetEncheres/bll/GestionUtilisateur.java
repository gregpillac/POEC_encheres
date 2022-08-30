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
	
	public void supprimerUtilisateur(Utilisateur u) {
		Utilisateur uTrouve = trouverUtilisateurByLogin(u.getPseudo());
		if (uTrouve!=null) {
			dao.deleteById(uTrouve.getNoUtilisateur());;
			System.err.println("utilisateur supprimé " + uTrouve);
		} else {
			System.err.println("L'utilisateur n'existe pas");
		}			
	}
	
	public Utilisateur trouverUtilisateurByLogin(String login) {
		Utilisateur u = null;
		Utilisateur uPseudo = dao.findByPseudo(login);
		Utilisateur uMail = dao.findByEmail(login);
		if (uPseudo != null) {
			u = uPseudo; 
		} else if( uMail != null) {
			u = uMail; 
		} 
		return u;
	}
	
	public void modifierUtilisateur(Utilisateur u) {
		Utilisateur uTrouve = trouverUtilisateurByLogin(u.getPseudo());
		if (uTrouve!= null) {
			dao.save(u);
			System.err.println("utilisateur modifié");
		} else {
			System.err.println("L'utilisateur n'existe pas");
		}			
	}
	
}
