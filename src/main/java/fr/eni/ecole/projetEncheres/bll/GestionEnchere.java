package fr.eni.ecole.projetEncheres.bll;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.ecole.projetEncheres.bo.ArticleVendu;
import fr.eni.ecole.projetEncheres.bo.Enchere;
import fr.eni.ecole.projetEncheres.bo.Utilisateur;
import fr.eni.ecole.projetEncheres.bo.ArticleVendu.EtatVente;
import fr.eni.ecole.projetEncheres.bo.Categorie;
import fr.eni.ecole.projetEncheres.dal.EnchereDAO;

@Service
public class GestionEnchere {
	
	@Autowired
	EnchereDAO Edao;
	@Autowired
	GestionArticleVendu beanGestionArticle;
	@Autowired
	GestionUtilisateur beanGestionUtilisateur;
	
	public List<Enchere> listerEncheresConnexion() {
		List<Enchere> encheres = null;
		encheres = Edao.findAll();		
		return encheres;
	}
	
	public List<Enchere> listerMesEncheresConnexion(Utilisateur u) {
		List<Enchere> encheres = null;
		encheres = Edao.findByUtilisateur(u);		
		return encheres;
	}
	
	public List<Enchere> listerMesEncheresGagnees(Utilisateur u) {
		List<Enchere> encheres = Edao.findByUtilisateur(u);
		List<Enchere> encheresGagnees=new ArrayList<>();
		for (Enchere e : encheres) {
			if (e.getMontant_enchere()==e.getArticle().getPrixVente()&& e.getArticle().getEtatVente()==EtatVente.TERMINEE){
			encheresGagnees.add(e);
			}
		}		
		return encheresGagnees;
	}
	
	public List<Enchere> listerEncheresEnCoursHorsConnexion() {
		List<Enchere> encheres = Edao.findAll();		
		List<Enchere> encheresEnCours=new ArrayList<>();
		for (Enchere e : encheres) {
			if (e.getArticle().getEtatVente()==EtatVente.ENCOURS){
				encheresEnCours.add(e);
			}
		}		
		return encheresEnCours;
	}
	
	
	
	public List<Enchere> listerEncheresEnCoursParCategorieHorsConnexion(Categorie c) {
		List<Enchere> encheres = listerEncheresEnCoursHorsConnexion();		
		List<Enchere> encheresParCategorie=new ArrayList<>();
		for (Enchere e : encheres) {
			if (e.getArticle().getCategorie().equals(c)){
				encheresParCategorie.add(e);
			}		
		}		
		return encheresParCategorie;
	}
	
	public List<Enchere> listerEncheresEnCoursParNomArticleHorsConnexion(ArticleVendu a) {
		List<Enchere> encheres = listerEncheresEnCoursHorsConnexion();		
		List<Enchere> encheresParNomArticle=new ArrayList<>();
		for (Enchere e : encheres) {
			if (e.getArticle().getNomArticle().equals(a.getNomArticle())){
				encheresParNomArticle.add(e);
			}
		}		
		return encheresParNomArticle;
	}
	
	public Utilisateur dernierUtilisateurEnchere(ArticleVendu a) {
		List<Enchere> encheres = Edao.findByArticle(a);		
		int montantEnchereMax = 0;
		Enchere enchereMax = null;
		if(!encheres.isEmpty()) {
			for (Enchere e : encheres) {
				if (e.getMontant_enchere()>montantEnchereMax){
					montantEnchereMax=e.getMontant_enchere();
					enchereMax = e;
				}
			}		
		
			return enchereMax.getUtilisateur();
		}else {
			return null;
		}
	}
	
	//methode de creation d'une enchere
	//mise a jour  du prix de vente de l'article
	//recreditation de l'utilisateur de la dernière enchere
	//debit de l'utilisateur enchere
	public Enchere creationEnchere(int proposition, Utilisateur u, ArticleVendu a) throws Exception {
		Enchere enchere = null;
		int ancierPrixVente = a.getPrixVente();
		if(proposition>a.getPrixVente()) {
			//modification du prix de vente de l'article
			a.setPrixVente(proposition);
			beanGestionArticle.miseAJourEtatPrixVente(a);
			
			//recrediter utilisateur derniere enchere
			Utilisateur uDernier = dernierUtilisateurEnchere(a);
			if(uDernier!=null) {
				uDernier.setCredit(uDernier.getCredit()+ ancierPrixVente);
				beanGestionUtilisateur.modifierUtilisateur(uDernier);
			}
				
			//debiter utilisateur enchere 
			u.setCredit(u.getCredit()-proposition);			
			beanGestionUtilisateur.modifierUtilisateur(u);
			
			//Creation de l'enchere en bdd			
			enchere = new Enchere(LocalDate.now(),proposition,a,u);
			return Edao.save(enchere);					
		}
		return null;		
	}
}
