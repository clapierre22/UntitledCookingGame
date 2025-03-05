package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import main.java.clapierre.*;
//import main.java.clapierre.BasicEnemy;
//import main.java.clapierre.Boss;
//import main.java.clapierre.FightingLogic;
//import main.java.clapierre.HealthItem;
//import main.java.clapierre.Item;
//import main.java.clapierre.Loonie;
//import main.java.clapierre.LootLogic;
//import main.java.clapierre.PlayerOne;
//import main.java.clapierre.ScoreItem;
//import main.java.clapierre.SharpenedWoodenSpoon;
//import main.java.clapierre.WeaponItem;

public class StatLogicTest {
	@Test
	public void testFightingLogic() {
		// test logic here
		BasicEnemy entity = new BasicEnemy(1, 1);
		WeaponItem weapon = new WeaponItem(1, 1);
		HealthItem health = new HealthItem(1, 1);

//    	Check gets and sets
		entity.setHealth(500);
		entity.setDamage(200);
		assertEquals(500, entity.getHealth());
		assertEquals(200, entity.getDamage());

		weapon.setDamage(200);
		weapon.setRarity(2);
		weapon.setLevel(4);
		weapon.setValue(400);
		assertEquals(200, weapon.getDamage());
		assertEquals(2, weapon.getRarity());
		assertEquals(4, weapon.getLevel());
		assertEquals(400, weapon.getValue());

		health.setHealth(100);
		assertEquals(100, health.getHealth());

		PlayerOne player1 = new PlayerOne(100, 100);
		FightingLogic f = new FightingLogic();

//    	Missed attack by the player
		player1.setDamage(100);
		assertEquals(100, player1.getDamage());
		
		f.calculateFight(player1, entity);
		assertEquals(500, entity.getHealth());
		
		player1.setDirection(true);
		assertTrue(player1.facingRight());

//    	Successful attack by the player
		entity.setPosition(110, 100);
		assertEquals(110, entity.getX());
		assertEquals(100, entity.getY());
		f.calculateFight(player1, entity);
//		assertTrue(f.calculateHitDebug(player1, entity));
//    	^^ FIXED THANK GOD
//		f.calculateFightDebug(player1, entity);
		assertEquals(400, entity.getHealth());
//    	^ Error here, 500 when expected 400

//    	Player picks up weapon, damage taken by Enemy should equal item damage
		player1.pickup(weapon);
		f.calculateFight(player1, entity);
		assertEquals(200, entity.getHealth());

//    	Successful attack by Enemy
		entity.setDamage(50);
		f.calculateFight(entity, player1);
		assertEquals(50, player1.getHealth());
	}

	@Test
	public void testLootLogic() {
		BasicEnemy basic = new BasicEnemy(1, 1);
		Boss boss = new Boss(1, 1);
		LootLogic l = new LootLogic();
//    	l.setup();

//    	Test drops, basic enemies don't always drop loot
		Item i = l.dropLoot(boss);
		assertNotNull(i);
		Item b = null;
		while (b == null) {
			b = l.dropLoot(basic);
		}
		assertNotNull(b);

		PlayerOne player1 = new PlayerOne(1, 1);
		player1.clearInventory();

//    	Players can only hold onto weapons (health and score used instantly)
		while (!(i instanceof WeaponItem)) {
			i = l.dropLoot(boss);
		}

		while (!(b instanceof WeaponItem)) {
			b = l.dropLoot(boss);
		}

		player1.pickup(i);
		assertTrue(player1.holds(i));
		assertFalse(player1.holds(b));

		player1.pickup(b);
		assertTrue(player1.holds(b));

		Item tempItem = null;
//    	Should be ~50 for both
		int numTimesCom = 0;
		int numTimesScore = 0;
		for (int j = 0; j < 100; j++) {
			tempItem = l.dropLoot(boss);
			if (tempItem instanceof Baguette || tempItem instanceof SharpenedWoodenSpoon
					|| tempItem instanceof Loonie) {
				numTimesCom++;
			}
			if (tempItem instanceof ScoreItem) {
				numTimesScore++;
			}
			tempItem = null;
		}
		System.out.println("# of Common Items: " + numTimesCom);
		System.out.println("# of Score Items: " + numTimesScore);

		tempItem = null;
//    	Should be ~25
		int numDrops = 0;
		for (int x = 0; x < 100; x++) {
			tempItem = l.dropLoot(basic);
			if (tempItem != null) {
				numDrops++;
				tempItem = null;
			}
		}
		System.out.println("# of Dropped Items: " + numDrops);
	}

	public static void main(String[] args) {
		StatLogicTest test = new StatLogicTest();
		test.testFightingLogic();
		test.testLootLogic();
		System.out.println("All tests completed.");
	}
}
