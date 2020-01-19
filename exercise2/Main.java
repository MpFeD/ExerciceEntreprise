package exercise2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Main {
	
	//Enterprise static reference 
	static Entreprise entreprise;
	
	//Client static reference
	static Client client = null;
	
	//Client static reference
	static Facture facture = null;
			

	public static void main(String[] args) {   
		
		//Enterprise data, ajoute des prestations à proposées
		entreprise = new Entreprise("36 rue du test", "0144859652", "www.test.fr");
		entreprise.creerPrestation("designation 1", 100, 1, 0);
		entreprise.creerPrestation("designation 2", 150, 2, 0);
		entreprise.creerPrestation("designation 3", 100, 2, 10);
		entreprise.creerPrestation("designation 4", 80, 1, 0);
		entreprise.creerPrestation("designation 5", 200, 4, 50);
		
		//jframe
		JFrame jFrame = new JFrame("Exercice");  
		
		//Nom client field
		final JTextField clientAdresseField = new JTextField(); 
		clientAdresseField.setBounds(50, 50, 150, 20);
		
		//Bouton créer client
	    JButton creerClientButton = new JButton("Creer client");  
	    creerClientButton.setBounds(50, 100, 150, 30);  
	    
	    //Bouton créer facture
	    JButton creerFactureButton = new JButton("Creer facture");  
	    creerFactureButton.setBounds(50, 150, 150, 30); 
	    creerFactureButton.setVisible(false);
	    
	    //Bouton créer prestation
	    JButton ajouterPrestationButton = new JButton("Ajouter prestation");  
	    ajouterPrestationButton.setBounds(50, 200, 150, 30); 
	    ajouterPrestationButton.setVisible(false);
	    
	    //Bouton stocker facture
	    JButton stockerFactureButton = new JButton("Stocker facture");  
	    stockerFactureButton.setBounds(50, 250, 150, 30); 
	    stockerFactureButton.setVisible(false);
	    
	    //Bouton info facture
	    JButton infoFactureButton = new JButton("Info facture");  
	    infoFactureButton.setBounds(50, 300, 150, 30); 
	    infoFactureButton.setVisible(false);
	    
	    //Prestations check boxes
	    JCheckBoxMenuItem prestationsCheckBox1 = new JCheckBoxMenuItem(
	    		entreprise.getPrestations().get(0).getDesination());
	    prestationsCheckBox1.setBounds(250, 200, 100, 30);
	    prestationsCheckBox1.setVisible(false);
	    
	    JCheckBoxMenuItem prestationsCheckBox2 = new JCheckBoxMenuItem(
	    		entreprise.getPrestations().get(1).getDesination());
	    prestationsCheckBox2.setBounds(350, 200, 100, 30);
	    prestationsCheckBox2.setVisible(false);
	    
	    JCheckBoxMenuItem prestationsCheckBox3 = new JCheckBoxMenuItem(
	    		entreprise.getPrestations().get(2).getDesination());
	    prestationsCheckBox3.setBounds(450, 200, 100, 30);
	    prestationsCheckBox3.setVisible(false);
	    
	    JCheckBoxMenuItem prestationsCheckBox4 = new JCheckBoxMenuItem(
	    		entreprise.getPrestations().get(3).getDesination());
	    prestationsCheckBox4.setBounds(550, 200, 100, 30);
	    prestationsCheckBox4.setVisible(false);
	    
	    JCheckBoxMenuItem prestationsCheckBox5 = new JCheckBoxMenuItem(
	    		entreprise.getPrestations().get(4).getDesination());
	    prestationsCheckBox5.setBounds(650, 200, 100, 30);
	    prestationsCheckBox5.setVisible(false);
	    
	    //Creer client action
	    creerClientButton.addActionListener(new ActionListener(){  
		public void actionPerformed(ActionEvent e){  
				if (!clientAdresseField.getText().isEmpty()) {
					client = new Client(clientAdresseField.getText());
					creerFactureButton.setVisible(true);
				}
			}  
	    });  
	    
	    //Creer facture action
	    creerFactureButton.addActionListener(new ActionListener(){  
  		public void actionPerformed(ActionEvent e){  
  				facture = new Facture(client);
  				facture.setEntreprise(entreprise);
  				ajouterPrestationButton.setVisible(true);
  				prestationsCheckBox1.setVisible(true);
  				prestationsCheckBox2.setVisible(true);
  				prestationsCheckBox3.setVisible(true);
  				prestationsCheckBox4.setVisible(true);
  				prestationsCheckBox5.setVisible(true);
  				
  				stockerFactureButton.setVisible(false);
  				infoFactureButton.setVisible(false);
  			}  
  	    });
	    
	    //Ajouter prestation action
	    ajouterPrestationButton.addActionListener(new ActionListener(){  
  		public void actionPerformed(ActionEvent e){  
  				if (prestationsCheckBox1.isSelected()) {
  					facture.ajouterPrestation(entreprise.getPrestations().get(0));
  					stockerFactureButton.setVisible(true);
  				}
  				if (prestationsCheckBox2.isSelected()) {
  					facture.ajouterPrestation(entreprise.getPrestations().get(1));
  					stockerFactureButton.setVisible(true);
  				}
  				if (prestationsCheckBox3.isSelected()) {
  					facture.ajouterPrestation(entreprise.getPrestations().get(2));
  					stockerFactureButton.setVisible(true);
  				}
  				if (prestationsCheckBox4.isSelected()) {
  					facture.ajouterPrestation(entreprise.getPrestations().get(3));
  					stockerFactureButton.setVisible(true);
  				}
  				if (prestationsCheckBox5.isSelected()) {
  					facture.ajouterPrestation(entreprise.getPrestations().get(4));
  					stockerFactureButton.setVisible(true);
  				}
  			}  
  	    });
	    
	    //Stocker facture action
	    stockerFactureButton.addActionListener(new ActionListener(){  
	  		public void actionPerformed(ActionEvent e){  
		  			facture.stocker();
		  			infoFactureButton.setVisible(true);
	  			}  
	  	    });
		    
	    //Info client action
	    infoFactureButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				for (Facture facture : client.getFactures()) {
					System.out.println(facture.toString());
				}
			}
		}); 
	    
	    jFrame.add(prestationsCheckBox1);
	    jFrame.add(prestationsCheckBox2);
	    jFrame.add(prestationsCheckBox3);
	    jFrame.add(prestationsCheckBox4);
	    jFrame.add(prestationsCheckBox5);
	    jFrame.add(creerClientButton); 
	    jFrame.add(clientAdresseField );
	    jFrame.add(creerFactureButton); 
	    jFrame.add(ajouterPrestationButton);
	    jFrame.add(stockerFactureButton);
	    jFrame.add(infoFactureButton);
	    
	    jFrame.setSize(800, 600);  
	    jFrame.setLayout(null);  
	    jFrame.setVisible(true);   
	}   

}
	    

