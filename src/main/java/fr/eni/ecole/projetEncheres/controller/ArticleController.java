package fr.eni.ecole.projetEncheres.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ArticleController {

	@RequestMapping(value = "/rechercher", method = RequestMethod.POST)
	public String rechercherArticle(ModelMap map) {
		//map.addAttribute("article", "aaa");
		System.out.println("rechercher");
		return "rechercher";
	}
}
