package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import villagegaulois.Village;
import personnages.Chef;

class ControlEmmenagerTest {
	private Village village ; 
	private Chef abraracourcix; 
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation ...");
		village = new Village("Le village des irréductibles",10,5);
		abraracourcix = new Chef("Abraracourcix",10,village);
		village.setChef(abraracourcix);
	}
	

	@Test
	void testControlEmmenager() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		assertNotNull(controlEmmenager,"Constructeur ne renvoie pas null");

	}
	@Test 
	void testisHabitant() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine", 3);
		assertTrue(controlEmmenager.isHabitant("Bonemine"));
		assertFalse(controlEmmenager.isHabitant("Existe pas"));
		controlEmmenager.ajouterDruide("Panoramix",2, 5, 8);
		assertTrue(controlEmmenager.isHabitant("Panoramix"));
		assertFalse(controlEmmenager.isHabitant("Existe pas "));
		
	}
	
	@Test
	void testajouterDruide() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterDruide("Panoramix", 2, 5, 8);
		assertTrue(controlEmmenager.isHabitant("Panoramix"));
		assertFalse(controlEmmenager.isHabitant("Existe pas"));
	}
	
	@Test
	void testajouterGaulois() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine", 3);
		assertTrue(controlEmmenager.isHabitant("Bonemine"));
		assertFalse(controlEmmenager.isHabitant("Existe pas"));
	}

}
