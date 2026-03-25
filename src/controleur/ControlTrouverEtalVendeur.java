package controleur;

import villagegaulois.Etal;
import personnages.Gaulois;
import villagegaulois.Village;

public class ControlTrouverEtalVendeur {
	private Village village;

	public ControlTrouverEtalVendeur(Village village) {
		this.village = village;
	}

	public Etal trouverEtalVendeur(String nomVendeur) {
		//TODO a completer
		
		Gaulois habitant = village.trouverHabitant(nomVendeur);
		Etal etal = null;
		if (habitant != null) {
			etal = village.rechercherEtal(habitant);
		}
		return etal;
	}
}
