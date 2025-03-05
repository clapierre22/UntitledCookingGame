package main.java.clapierre;

public class SilverSpoon extends WeaponItem {
	public SilverSpoon(int x, int y) {
		super(x, y);
		this.sprite = loadSprite("");
		this.damage = 20;
	}
}