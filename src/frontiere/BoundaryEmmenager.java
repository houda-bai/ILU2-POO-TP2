package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println("Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					StringBuilder message= new StringBuilder();
					message.append("Bienvenue villageois" + nomVisiteur + "\n");// 
					message.append("Quelle est votre force? \n");
					int force = Clavier.entrerEntier(message.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					//why we can just do emmenagerGaulois(nomVisiteur) instead of this ?
					break;
					//to do case 2
				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder forcedruide=new StringBuilder();
		forcedruide.append("Bienvennue druide"+nomVisiteur + "\n");
		forcedruide.append("Quelle est votre force?\n" );
		int force =Clavier.entrerEntier(forcedruide.toString());

		
		int effetPotionMax=0;
		int effetPotionMin=0;
		StringBuilder text= new StringBuilder();
		StringBuilder text2= new StringBuilder();
		
		do {
			
			text.append("Quelle est la force de potion la plus faible que vous produisez?\n");
			effetPotionMin = Clavier.entrerEntier(text.toString());
			text2.append("Quelle est la force de potion la plus forte que vous produisiez? \n");
			effetPotionMax = Clavier.entrerEntier(text2.toString());	
		}while( effetPotionMax<effetPotionMin);
		do {
			text.append("Attention Druide , vous vous êtes trompé entre le minimum et le maximum");
		}while(effetPotionMax<effetPotionMin);
		controlEmmenager.ajouterGaulois(nomVisiteur, force);
	}
}
