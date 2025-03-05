package main.java.clapierre;

public class Donut extends HealthItem {
	public Donut(int x, int y) {
		super(x, y);
		this.sprite = loadSprite("");
		this.health = 25;
	}
}