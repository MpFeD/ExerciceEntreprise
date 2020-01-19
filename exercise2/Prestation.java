package exercise2;

public class Prestation {
	
	/* La designation, description de la prestation */
	private String designation;
	
	/* Le prix unitaire */
	private double prixUnitaireHT;
	
	/* Nombre de prestation */
	private int quantite;
	
	/* Reduction en pourcentage */
	private double reduction;
	
	/**
	 * Créer une prestation avec les paramètres donnés
	 * @param designation la description de la prestation
	 * @param prixUnitaireHT prix de la prestation
	 * @param quantite quantité incluse dans la prestation
	 * @param reduction  optionel, reduction a appliquée
	 */
	public Prestation(String designation, int prixUnitaireHT,
			int quantite, int reduction) {
		this.designation = designation;
		this.prixUnitaireHT = prixUnitaireHT;
		this.quantite = quantite;
		
		// reduction en pourcentage, 0 si mauvais paramètre
		if (reduction >= 0 && reduction <= 100) {
			this.reduction = reduction;
		} else {
			this.reduction = 0;
		}
	}
	
	/**
	 * Modifie la designation selon le paramètre donné
	 * @param designation la designation à modifier
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	/**
	 * Rend le prix de la prestation
	 * @return le prix de la prestation
	 */
	public String getDesination() {
		return this.designation;
	}
	
	/**
	 * Rend le prix de la prestation
	 * @return le prix de la prestation
	 */
	public double getPrixUnitaireHT() {
		return this.prixUnitaireHT;
	}
	
	/**
	 * Rend la quantite de la prestation
	 * @return la quantite de la prestation
	 */
	public int getQuantite() {
		return this.quantite;
	}

	/**
	 * Rend la reduction de la prestation
	 * @return la reduction de la prestation
	 */
	public double getReduction() {
		return this.reduction;
	}
	
	/**
	 * Cette mehode retourne les informations de la prestation
	 * @return les informations de la prestation
	 */
	public String toString() {
		return this.designation + " : " +  this.prixUnitaireHT 
				+"€ * " + this.quantite;
	}
	

}
