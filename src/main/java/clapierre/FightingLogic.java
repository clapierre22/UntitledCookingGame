package main.java.clapierre;

//import main.java.clapierre.*;

public class FightingLogic {
	public FightingLogic() {
//		Takes the two entities, their weapons, and spits out the result in a reduction of health, or death
	}

	public void calculateFight(Entity entityAttackFrom, Entity entityAttackTo) {
//		Get player weapon/player or entity damage, apply damage to entityAttack if calculateHit
		if (calculateHit(entityAttackFrom, entityAttackTo)) {
//			Need to add grabbing weapon functionality
			if (entityAttackFrom.holdsWeapon()) {
				entityAttackTo.setHealth(entityAttackTo.getHealth() - ((Player) entityAttackFrom).getWeapon().getDamage());
			}
			else {
				entityAttackTo.setHealth(entityAttackTo.getHealth() - entityAttackFrom.getDamage());
			}
//			if EAT.health <= 0, kill entity. This may need additional logic, right now worry about health calculations
		}
	}

	private boolean calculateHit(Entity entityAttackFrom, Entity entityAttackTo) {
//		Determine if the two entities were a. close enough (xy - xy) and b. facing the correct way
//		True if xy - xy is within 40 
		boolean facingRight = entityAttackFrom.facingRight();
		if (Math.abs(entityAttackFrom.getX() - entityAttackTo.getX()) <= 40
				&& Math.abs(entityAttackFrom.getY() - entityAttackTo.getY()) <= 20
				&& ((facingRight && entityAttackFrom.getX() < entityAttackTo.getX())
						|| (!facingRight && entityAttackFrom.getX() > entityAttackTo.getX()))) {
			return true;
		}
		return false;
	}
	
	private int caclulateKnockback(Entity entityAttackFrom, Entity entityAttackTo) {
//		Moves entityTo backwards from direction of hit
		return 0;
	}
	
	public void calculateFightDebug(Entity entityAttackFrom, Entity entityAttackTo) {
		if (calculateHit(entityAttackFrom, entityAttackTo)) {
			System.out.println("Original Health: " + entityAttackTo.getHealth());
			if (entityAttackFrom.holdsWeapon()) {
				System.out.println("Entity holds Weapon");
				System.out.println("Damage " + ((Player) entityAttackFrom).getWeapon().getDamage());
				entityAttackTo.setHealth(entityAttackTo.getHealth() - ((Player) entityAttackFrom).getWeapon().getDamage());
			}
			else {
				System.out.println("No weapon detected");
				System.out.println("Damage " + entityAttackFrom.getDamage());
				entityAttackTo.setHealth(entityAttackTo.getHealth() - entityAttackFrom.getDamage());
			}
			System.out.println("Adjusted Health " + entityAttackTo.getHealth());
		}
	}

	public boolean calculateHitDebug(Entity entityAttackFrom, Entity entityAttackTo) {
	    int attackFromX = entityAttackFrom.getX();
	    int attackFromY = entityAttackFrom.getY();
	    int attackToX = entityAttackTo.getX();
	    int attackToY = entityAttackTo.getY();
	    boolean facingRight = entityAttackFrom.facingRight();

	    System.out.println("Attacker Position: (" + attackFromX + ", " + attackFromY + ")");
	    System.out.println("Target Position: (" + attackToX + ", " + attackToY + ")");
	    System.out.println("Attacker Facing Right: " + facingRight);

	    boolean withinXRange = Math.abs(attackFromX - attackToX) <= 40;
	    boolean withinYRange = Math.abs(attackFromY - attackToY) <= 20;
	    boolean correctDirection = (facingRight && attackFromX < attackToX)
	            || (!facingRight && attackFromX > attackToX);

	    System.out.println("Within X Range: " + withinXRange);
	    System.out.println("Within Y Range: " + withinYRange);
	    System.out.println("Correct Direction: " + correctDirection);

	    boolean hit = withinXRange && withinYRange && correctDirection;
	    System.out.println("Hit: " + hit);
	    return hit;
	}


}