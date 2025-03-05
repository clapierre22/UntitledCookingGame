package main.java.clapierre;

import java.util.*;

import src.main.java.clapierre.*;

public class LootLogic {
	HashMap<Integer, List<Item>> possibleItems;
	Random r;
	List<Item> tempList;
	List<Integer> dropSpec;

	public LootLogic() {
//		Takes the enemy information, and drops loot in response to the entity level and attributes
//		HashMap to hold all objects with the type and rarity hashed
		this.possibleItems = new HashMap<>();
		this.r = new Random();
		this.tempList = new ArrayList<>();
		this.dropSpec = new ArrayList<>();

		setup();
	}

	private void setup() {
		possibleItems.put(0, new ArrayList<>(
				Arrays.asList(new Loonie(1, 1), new Toonie(1, 1), new GreenTea(1, 1), new Harold(1, 1))));
		possibleItems.put(1, new ArrayList<>(
				Arrays.asList(new Baguette(1, 1), new Donut(1, 1), new ApplePie(1, 1), new Tiramisu(1, 1))));
		possibleItems.put(2, new ArrayList<>(Arrays.asList(new SharpenedWoodenSpoon(1, 1), new SilverSpoon(1, 1),
				new KitchenKnife(1, 1), new FryingPan(1, 1))));
	}

	public Item dropLoot(Enemy enemyKilled) {
//		Creates the item with given info from dropType(hasLoot)) so it can be printed on Panel
		if (hasLoot(enemyKilled)) {
			List<Integer> temp = dropType(enemyKilled);
//			possibleItems.get(0);
			Item tempItem = (possibleItems.get(temp.get(0))).get(temp.get(1));
			tempItem.setLevel(temp.get(2));
			temp.clear();
			return tempItem;
		}
		return null;
	}

	public List<Integer> dropType(Enemy enemyKilled) {
//		Drop rates type: Score 50%, Health 35%, Weapon 15%
//		Rarity Rates: Common 50%, Rare 30%, Epic 15%, Legendary 5%
//		Level Rates: Random between enemyLevel - 2, enemyLevel + 2
		dropSpec.clear();

		int typeRand = r.nextInt(10);
		if (typeRand > 5) {
			dropSpec.add(0);
		} else if (typeRand > 1) {
			dropSpec.add(1);
		} else {
			dropSpec.add(2);
		}

		int rarityRand = r.nextInt(10);
		if (rarityRand > 5) {
			dropSpec.add(0);
		} else if (rarityRand > 2) {
			dropSpec.add(1);
		} else if (rarityRand > 0) {
			dropSpec.add(2);
		} else {
			dropSpec.add(3);
		}

		int level = enemyKilled.getLevel();
		dropSpec.add(Math.max(1, r.nextInt(level - 2, level + 2)));
		return dropSpec;
	}

	public boolean hasLoot(Enemy enemyKilled) {
//		Drop rate enemy type: Boss 100%, Basic 25%
		if (enemyKilled instanceof BasicEnemy && r.nextInt(3) == 1) {
			return true;
		}
		if (enemyKilled instanceof Boss) {
			return true;
		}
		return false;
	}
}