package exercise2;

import java.util.ArrayList;

public class Client {
	
	/* Id static reference */
	private static int nextCodeClient = 0;
	
	/* Code client */
	private int codeClient;
 
	/* Adresse du client */
	private String adresse;
	
	/* Liste des factures liées au client */
	private ArrayList<Facture> factures;
	
	/**
	 * Constructeur 
	 * @param adresse, l'adresse du client
	 */
	public Client(String adresse) {
		this.adresse = adresse;
		this.codeClient = nextCodeClient++;
		this.factures = new ArrayList<Facture>();
	}
	
	/**
	 * Ajoute la facture en parametre à la liste des factures du client
	 * @param facture
	 */
	public void ajouterFacture(Facture facture) {
		factures.add(facture);
	}
	
	/**
	 * Rend l'adresse du client
	 * @return l'adresse du client
	 */
	public String getAdresse() {
		return this.adresse;
	}
	
	/**
	 * Rend la liste des factures du client
	 * @return la liste des factures du client
	 */
	public ArrayList<Facture> getFactures() {
		return this.factures;
	}

	/**
	 * Modifie l'adresse du client
	 * @param adresse la nouvelle adresse
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	/**
	 * Rend le code client
	 * @return le code client
	 */
	public int getCodeClient() {
		return codeClient;
	}

}
