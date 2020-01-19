package exercise2;

import java.util.ArrayList;
import java.util.Calendar;

public class Facture {
	
	/* Reference static de la reference facture */
	private static int nextReference = 0;
	
	/* Reference facture */
	private int reference;
	
	/* Date de création de la facture */
	private String date;

	/* Prix TTC */
	private double TTC;
	
	/* Prix HT */
	private double HT;
	
	/* TVA total */
	private double totalTVA;
	
	/* Enreprise liée à la facture, sera toujours la même ici*/
	private Entreprise entreprise;
	
	/* Liste de prestations contenues dans la facture*/
	private ArrayList<Prestation> prestations;
	
	/* Client lié à la facture*/
	private Client client;
	
	/**
	 * Constucteur
	 * @param client le client ayant créer cette facture
	 */
	public Facture(Client client) {
		this.reference = -1;
		this.date = null;
		this.TTC = 0;
		this.HT = 0;
		this.totalTVA = 0;
		this.entreprise = null;
		this.client = client;
		this.prestations = new ArrayList<Prestation>();
	}
	
	/**
	 * Constructeur par copie, utile plus tard pour permettre la modification
	 * de prestations, sans modifier celle déjà presentes dans la facture
	 * @param facture
	 */
	public Facture(Facture facture) {
		this.reference = facture.reference;
		this.date = facture.date;
		this.TTC = facture.TTC;
		this.HT = facture.HT;
		this.totalTVA = facture.totalTVA;
		this.entreprise = facture.entreprise;
		this.client = facture.client;
		this.prestations = new ArrayList<Prestation>();
	}
	
	/**
	 * Ajoute une prestation
	 * @param prestation la prestation à ajouter
	 */
	public void ajouterPrestation(Prestation prestation) {
		prestations.add(prestation);
	}
	
	/**
	 * Permet à l'utilisateur (Client) de stocker sa facture,
	 * une fois stocker la facture ne pourra être modifier,
	 * cela empèche que la modification des éléments contenus dans
	 * une facture ne modifie la facture actuelle
	 */
	public void stocker() {
		//la réference est assciée à un compteur
		this.reference = nextReference++;
		
		//instancie la date actuelle
		this.date = Calendar.getInstance().getTime().toString();
		
		//calcul du TTC : HT * (1 + TVA) * reduction
		for (Prestation prestation : prestations) {
			this.HT += prestation.getPrixUnitaireHT() * prestation.getQuantite() 
					* (1 - prestation.getReduction() / 100);
		}
		this.TTC = this.HT * (1 + Context.TVA / 100);
		this.totalTVA = TTC - HT;
		
		/*constructeur par copie, les futures modifications des designations 
		  n'impacterons pas les factures déjà stockées 
		*/
		Facture facture = new Facture(this);
		this.client.ajouterFacture(facture);
	}
	
	/**
	 * Rend des informations sur la facture
	 */
	public String toString() {
		return "Facture " + reference + " :\n"
				+ entreprise.getAdresse() + "\n"
				+ entreprise.getTelephone() + "\n"
				+ entreprise.getWeb() + "\n"
				+ "Date : " + this.date + "\n"
				+ "Code client : " + this.client.getCodeClient() + "\n"
				+ "Adresse client : " + this.client.getAdresse() + "\n"
				+ "Total HT : " + this.HT+ "\n"
				+ "Total TVA " + Context.TVA + " : " + this.totalTVA+ "\n"
				+ "Total TTC : " + this.TTC;
	}
	
	/**
	 * Change l'entreprise liée à la facture, à utiliser une seulle fois
	 * en début d'instanciation
	 * @param entreprise l'entreprise liée à la facture
	 */
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

}
