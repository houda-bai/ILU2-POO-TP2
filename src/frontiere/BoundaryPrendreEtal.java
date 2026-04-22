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
		if (!nomVendeurConnu) {
			message.append("Je suis desolee " + nomVendeur
					+ " mais il faut etre un habitant de notre village pour commencer ici \n");
			System.out.println(message.toString());
		} else {
			
			StringBuilder texte = new StringBuilder();
			texte.append("Bonjour" + nomVendeur + "je vais regarder si je peux vous trouver un etal ");
			boolean etalDisponible = controlPrendreEtal.resteEtals();
			StringBuilder afficher = new StringBuilder();
			if (!etalDisponible) {
				afficher.append("Desolee" + nomVendeur + "je n'ai plus d'etal qui ne soit pas deja occupe");
				System.out.println(afficher.toString());

			} else {
				installerVendeur(nomVendeur);
		}
		
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder parole = new StringBuilder();
		parole.append("C'est parfait , il me reste un etal pour vous !\n");
		parole.append("Il me faudra quelques renseignements:\n");
		System.out.println(parole);
		String produit = Clavier.entrerChaine("Quel produit souhaitez-vous vendre ?");
		// pour lles questions je les mets dirrect sans \n f la parenthese 
		//avant i did String produit = Clavier.entrerChaine(message.toString);
		//et f le message dert ca genre messageappend("Quel produit souhaitez-vous vendre ?") c fauuux 
		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");

		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numeroEtal != -1) {
			System.out.println("Le vendre" + nomVendeur + "s'est installe a l'etal n : " + numeroEtal);
		}

	}
}


// avant erreur
//public void prendreEtal(String nomVendeur) {
//	boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
//	StringBuilder message = new StringBuilder();
//	if (!nomVendeurConnu) {
//		message.append("Je suis desolee " + nomVendeur
//				+ " mais il faut etre un habitant de notre village pour commencer ici \n");
//		System.out.println(message.toString());
//	} else {
//		
//		
//		StringBuilder afficher = new StringBuilder();
//		if (!etalDisponible) {
//			afficher.append("Desolee" + nomVendeur + "je n'ai plus d'etal qui ne soit pas deja occupe");
//			System.out.println(afficher.toString());
//			StringBuilder texte = new StringBuilder();
//			texte.append("Bonjour" + nomVendeur + "je vais regarder si je peux vous trouver un etal ");
//			boolean etalDisponible = controlPrendreEtal.resteEtals();
//		} else {
//			installerVendeur(nomVendeur);
//	}
//	
//	}
//}
