package main.java.clapierre;

public class Tiramisu extends HealthItem {
	public Tiramisu(int x, int y) {
		super(x, y);
		this.sprite = loadSprite("");
		this.health = 100;
	}
}