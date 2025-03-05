package main.java.clapierre;

public class FryingPan extends WeaponItem {
	public FryingPan(int x, int y) {
		super(x, y);
		this.sprite = loadSprite("");
		this.damage = 65;
//		FryingPan should also have its own sound file
	}
}