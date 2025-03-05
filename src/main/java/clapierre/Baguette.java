package main.java.clapierre;

public class Baguette extends HealthItem {
	public Baguette(int x, int y) {
		super(x, y);
		this.sprite = loadSprite("");
		this.health = 10;
	}
}