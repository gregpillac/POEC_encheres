package fr.eni.ecole.projetEncheres.bll;

import org.springframework.beans.factory.annotation.Autowired;

import fr.eni.ecole.projetEncheres.bo.Retrait;
import fr.eni.ecole.projetEncheres.dal.RetraitDAO;

public class GestionRetrait {
	
	@Autowired
	RetraitDAO dao;

	public void creerRetrait(Retrait ret) {
		dao.save(ret);
	}
}
