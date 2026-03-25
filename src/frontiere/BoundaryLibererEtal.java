package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu =controlLibererEtal.isVendeur(nomVendeur);
		if(!vendeurReconnu) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui");
		}else {
			String[] donnesEtal=controlLibererEtal.libererEtal(nomVendeur);
			
			//PQ FAUT METTRE LE IF LA A LINTERUR DE ELSE
			if (donnesEtal[0]=="true") {
				StringBuilder message = new StringBuilder();
				message.append("Vous avez vendu");
				message.append(donnesEtal[4]);
				message.append("sur");
				message.append(donnesEtal[3]);
				message.append(donnesEtal[2]);
				message.append(". \n");
				System.out.println(message.toString());
			}
		}
		
	}

}
