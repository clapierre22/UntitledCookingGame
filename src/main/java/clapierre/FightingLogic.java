package src.main.java.clapierre;

import src.main.java.clapierre.*;

public class FightingLogic {
	public FightingLogic() {
//		Takes the two entities, their weapons, and spits out the result in a reduction of health, or death
	}
	
	public void calculateFight(Entity entityAttackFrom, Entity entityAttackTo) {
//		Get player weapon/player or entity damage, apply damage to entityAttack if calculateHit
		if (calculateHit(entityAttackFrom, entityAttackTo)) {
//			Need to add grabbing weapon functionality
			entityAttackTo.setHealth(entityAttackTo.getHealth() - entityAttackFrom.getDamage());
//			if EAT.health <= 0, kill entity. This may need additional logic, right now worry about health calculations
		}
	}
	
	private boolean calculateHit(Entity entityAttackFrom, Entity entityAttackTo) {
//		Determine if the two entities were a. close enough (xy - xy) and b. facing the correct way
//		True if xy - xy is within 40 
		boolean facingRight = entityAttackFrom.facingRight();
		if (Math.abs(entityAttackFrom.getX() - entityAttackTo.getX()) <= 40 
				&& Math.abs(entityAttackFrom.getY() - entityAttackTo.getY()) <= 20 
				&& (facingRight && entityAttackFrom.getX() < entityAttackTo.getX()) 
					|| (!facingRight && entityAttackFrom.getX() > entityAttackTo.getX())) {
			return true
		}
		return false;
	}
}