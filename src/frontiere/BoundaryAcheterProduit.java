package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		// TODO à completer
		
		if(!controlAcheterProduit.verifierIdentite(nomAcheteur)){
			System.out.println("Je suis desolee "+nomAcheteur +"mais il faut etre un habitant de notre village pour commencer ici ");
		}else {
			String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter  ?");
			String[] vendeursProduit = controlAcheterProduit.vendeursProduit(produit);
			if(vendeursProduit != null) {
				int vendeur = 0;
				do {
					System.out.println("Chez quel commerçant voulez-vous acheter des " + produit + " ?");
					for(int i=0; i<vendeursProduit.length; i++) {
						System.out.println((i+1) + " - " + vendeursProduit[i]);
					}
					vendeur = Clavier.entrerEntier("");
				}while(vendeur > vendeursProduit.length || vendeur<=0);
				String nomVendeur = vendeursProduit[vendeur - 1];
				System.out.println(nomAcheteur +" se deplace jusqu'a l'etal de vendeur "+ nomVendeur);
				
				StringBuilder message = new StringBuilder();
				message.append("Bonjour "+nomAcheteur);
				int nbproduit=Clavier.entrerEntier("Combien de"+produit+ "voulez-vous acheter?\n");
				int quantite = controlAcheterProduit.getQuantiteProduit(nomVendeur);
				if(quantite==0) {
					System.out.println(nomAcheteur+"veut acheter"+ nbproduit + produit + "malheureusement il n' y en a plus !");
					
				}else if(quantite<nbproduit){
					System.out.println(nomAcheteur +"veut acheter" + nbproduit + produit +","+ "malheureusement"+ nomVendeur + "n'en a plus que" + quantite + ". "+ nomAcheteur + "achete tout le stock de"+ nomVendeur);
					controlAcheterProduit.acheterProduit(nomVendeur, nbproduit);
				}else {
					System.out.println(nomAcheteur +  " achete "+""+ nbproduit+"" +""+ produit +""+" a "+ nomVendeur);
				}
			}	
				else {
					System.out.println("Desolé , personne ne vend ce produit au marché");
				}
				
				
			
		}
		
	}
}
