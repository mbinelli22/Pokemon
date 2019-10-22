package HW4;

public class Vulpix extends Pokemon{

	private static final int flashFire = 7;
	private static final int swipe = 2;
	
	public Vulpix(int health, int power) {
		super("Vulpix", health, power);
	}
	
	public boolean specialAttack(Pokemon target) {
		if(this.isDefeated() || target.isDefeated()){
			return false;
		}

		if(this.currentPower>0){
			if(this.currentPower>=flashFire) {
				target.hurt(flashFire);
				this.currentPower -= flashFire;
			} else {
				target.hurt(this.currentPower);
				this.currentPower=0;
			}
			return true;
		} else {
			return false;
		}
	}
	
	public boolean physicalAttack(Pokemon target) {
		if(this.isDefeated() || target.isDefeated())
			return false;

		target.hurt(swipe);
		return true;

	}
	
	public String toString() {
		
	}
	
	public boolean equals(Object other) {
		
	}
	
}
