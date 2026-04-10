package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village ;
	private Chef abraracourcix; 
	private ControlEmmenager controlEmmenager;
	private ControlVerifierIdentite controlVerifierIdentite; 
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation ...");
		village = new Village("Le village des irréductibles",10,1);
		abraracourcix = new Chef("Abraracourcix",10,village);
		village.setChef(abraracourcix);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
	}
	@Test 
	void testControlPrendreEtal(){
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertNotNull(controlPrendreEtal, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testprendreEtal(){
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);

		controlEmmenager.ajouterGaulois("houda", 8);
		assertNotEquals(-1,controlPrendreEtal.prendreEtal("houda","Flowers", 8));
		assertEquals(-1,controlPrendreEtal.prendreEtal("houda","Flowers", 8));
		
		
	 
	}
	@Test
	void testverifierIdentite(){
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		assertFalse(controlPrendreEtal.verifierIdentite("Bonemine"));
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		assertTrue(controlPrendreEtal.verifierIdentite("Bonemine"));
	}
	
	
	@Test
	void testresteEtals() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertTrue(controlPrendreEtal.resteEtals());
		controlEmmenager.ajouterGaulois("houda", 10);
		controlPrendreEtal.prendreEtal("houda","flowers",10);
		assertFalse(controlPrendreEtal.resteEtals());
		
	}

}
