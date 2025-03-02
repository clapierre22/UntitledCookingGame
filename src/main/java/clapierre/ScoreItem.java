package src.main.java.clapierre;

public class ScoreItem extends Item {
    public ScoreItem(int x, int y){
        super(x, y);
        this.entityName = "Score Entity";
    }
    
//  Score Items: Common Loonie (10 score), Rare Toonie (20 score), Epic Green Tea (50 score), Legendary Harold (100 score)
    
//    protected void adjustScore() {
//    	score += (score * (level * .25));
//    }
//    Moved to Item.java
}
