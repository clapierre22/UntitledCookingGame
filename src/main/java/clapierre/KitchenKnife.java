package src.main.java.clapierre;

public class KitchenKnife extends WeaponItem {
	public KitchenKnife(int x, int y) {
		super(x, y);
		this.sprite = loadSprite("");
		this.damage = 40;
	}
}