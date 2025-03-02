package src.main.java.clapierre;

import src.main.java.clapierre.*;

public class LootLogic {
	public LootLogic() {
//		Takes the enemy information, and drops loot in response to the entity level and attributes
	}
	
	public Item dropLoot(Enemy enemyKilled) {
//		Creates the item with given info from dropType(hasLoot)) so it can be printed on Panel
		return null;
	}
	
	public int dropType(Enemy enemyKilled) {
//		Drop rates type: Score 50%, Health 35%, Item 15%
//		Rarity Rates: Common 50%, Rare 30%, Epic 15%, Legendary 5%
//		Level Rates: Random between enemyLevel - 2, enemyLevel + 2
		return 0;
	}
	
	public boolean hasLoot(Enemy enemyKilled) {
//		Drop rate enemy type: Boss 100%, Basic 25%
		return false;
	}
}