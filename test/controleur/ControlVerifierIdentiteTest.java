package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	
	private Village village ;
	
	@Test
	void test() {
		
	}
	void testControlEmmenager() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		assertNotNull(controlEmmenager,"Constructeur ne renvoie pas null");

	}
	@Test
	void testisHabitant() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlVerifierIdentite.ajouterGaulois("Bonemine", 3);
		assertTrue(controlVerifierIdentite.isHabitant("Bonemine"));
		assertFalse(controlVerifierIdentite.isHabitant("Existe pas"));
		controlVerifierIdentite.ajouterDruide("Panoramix",2, 5, 8);
		assertTrue(controlVerifierIdentite.isHabitant("Panoramix"));
		assertFalse(controlVerifierIdentite.isHabitant("Existe pas "));
		
	}

}
