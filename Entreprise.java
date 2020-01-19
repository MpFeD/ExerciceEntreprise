package exercise2;

import java.util.ArrayList;

public class Entreprise {
	
	/* Adresse de l'entreprise */
	private String adresse;
	
	/* Telephone de l'entreprise */
	private String telephone;
	
	/* Adresse web de l'entreprise */
	private String web;
	
	/* Liste de prestations que l'entreprise peut fournir */
	private ArrayList<Prestation> prestations;
	
	/**
	 * Constructeur 
	 * @param adresse l'adresse de l'entreprise
	 * @param telephone le telephone de l'entreprise
	 * @param web l'adresse web de l'entreprise
	 */
	public Entreprise(String adresse, String telephone, String web) {
		this.adresse = adresse;
		this.telephone = telephone;
		this.web = web;
		prestations = new ArrayList<Prestation>();
	}
	
	/**
	 * Rend l'adresse de l'entreprise
	 * @return l'adresse de l'entreprise
	 */
	public String getAdresse() {
		return adresse;
	}
	
	/**
	 * Rend le telephone de l'entreprise 
	 * @return le telephone de l'entreprise 
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * Rend l'adresse web
	 * @return l'adresse web de l'entreprise
	 */
	public String getWeb() {
		return web;
	}
	
	/**
	 * Créer une prestation selon les paramètre et l'ajoute à la liste de prestations
	 * @param designation nom de la prestation
	 * @param prixUnitaireHT le prix hors taxes
	 * @param quantite la quantité de cette prestation
	 * @param reduction la reduction à appliquer
	 */
	public void creerPrestation(String designation, int prixUnitaireHT, int quantite, int reduction) {
		Prestation prestation = new Prestation(designation, prixUnitaireHT, quantite, reduction);
		prestations.add(prestation);
	}
	
	/**
	 * Rend la liste des prestations de l'entreprise
	 * @return la liste des prestations
	 */
	public ArrayList<Prestation> getPrestations(){
		return prestations;
	}
	
	
	/**
	 * Comme énoncé, le nom d'une prestation peut changer à tout instant,
	 * recupère la prestation à l'index donnée et change son nom à la désignation donnée
	 * @param designation la nouvelle désignation
	 * @param index l'index de la prestation à changer
	 */
	private void setDesignationName(String designation, int index) {
		try {
			Prestation prestation = prestations.get(index);
			prestation.setDesignation(designation);
		} catch(IndexOutOfBoundsException indexOutOfBoundsException) {
			//Bad index
		}
	}

}
