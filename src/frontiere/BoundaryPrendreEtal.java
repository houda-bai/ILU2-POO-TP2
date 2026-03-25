package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		StringBuilder message = new StringBuilder();
		if(!nomVendeurConnu) {
			message.append("Je suis desolee"+ nomVendeur +"mais il faut etre un habitant de notre village pour commencer ici \n");
			System.out.println(message.toString());
		}else {
			StringBuilder texte = new StringBuilder();
			texte.append("Bonjour"+nomVendeur+"je vais regarder si je peux vous trouver un etal ");
		}
		boolean etalDisponible = controlPrendreEtal.resteEtals();
		StringBuilder afficher = new StringBuilder();
		if(!etalDisponible) {
			afficher.append("Desolee"+ nomVendeur + "je n'ai plus d'etal qui ne soit pas deja occupe");
			System.out.println(afficher.toString());
			
		}else {
			installerVendeur(nomVendeur);
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder message = new StringBuilder();
		message.append("C'est parfait , il me reste un etal pour vous !\n");
		message.append("Il me faudra quelques renseignements:\n");
		message.append("Quel produit souhaitez-vous vendre?\n");
		String produit=Clavier.entrerChaine(message.toString());
		message.append("Combien souhaitez-vous en vendre?\n");
		int nbProduit=Clavier.entrerEntier(message.toString());
		
		int numeroEtal=controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if(numeroEtal!=-1) {
			System.out.println("Le vendre"+nomVendeur+ "s'est installe a l'etal n : " + numeroEtal);
		}
		
		
	}
}
