package src.test.java.clapierre;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import src.main.java.clapierre.*;

public class GameLogicTest {
    // Tests the game by running a level without any user input
    // Used to judge that the commands themselves are working while using an auto test
	
	@Test
	public void levelLogicTest() {
//		Check all level platforms spawn, with spawn points in valid positions (on top of platforms)
//		Includes visual test to make sure the generated levels look okay
		LevelLogic ll = new LevelLogic();
		Level currentLevel = ll.generateLevel();
		SpawnLogic sl = new SpawnLogic(currentLevel);
		
		PlayerOne player1 = sl.player1Spawn();
		PlayerTwo player2 = sl.player2Spawn();
		BasicEnemy enemy = sl.enemySpawn();
		Boss boss = sl.bossSpawn();
		
//		Get x,y of entities to confirm correct placement
		
		assertEquals(player1.getX(), currentLevel.getP1Spawn().x);
		assertEquals(player1.getY(), currentLevel.getP1Spawn().y);
		assertEquals(player2.getX(), currentLevel.getP2Spawn().x);
		assertEquals(player2.getY(), currentLevel.getP2Spawn().y);
		assertEquals(enemy.getX(), currentLevel.getEnemySpawn().getFirst().x);
		assertEquals(enemy.getY(), currentLevel.getEnemySpawn().getFirst().y);
		assertEquals(boss.getX(), currentLevel.getBossSpawn().x);
		assertEquals(boss.getY(), currentLevel.getBossSpawn().y);
		
//		Add visual test with GamePanel
	}
}
