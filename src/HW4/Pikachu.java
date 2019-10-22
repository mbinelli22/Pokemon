package HW4;

public class Pikachu extends Pokemon{

	private static final int thunderBolt = 6;
	private static final int swipe = 3;
	
	public Pikachu(int health, int power) {
		super("Pikachu", health, power);
	}
	
	@Override
	public boolean specialAttack(Pokemon target) {
		if(this.isDefeated() || target.isDefeated()) {
			return false;
		}
		if(this.currentPower > 0) {
			if(this.currentPower >= thunderBolt) {
				target.hurt(thunderBolt);
				this.currentPower -= thunderBolt;
			}
			else {
				target.hurt(this.currentPower);
				this.currentPower = 0;
			}
			return true;
		}
		return false;
	}
	
	@Override
	public boolean physicalAttack(Pokemon target) {
		if(this.isDefeated() || target.isDefeated()) {
			return false;
		}
		target.hurt(swipe);
		return true;
	}
	
	public String toString() {
		
	}
	
	public boolean equals(Object other) {
		
	}

}
