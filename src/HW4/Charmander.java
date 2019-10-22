package HW4;

public class Charmander extends Pokemon{

	private static final int fireBall = 5;
	private static final int bite = 4;
	
	public Charmander(int health, int power) {
		super("Charmander", health, power);
	}
	
	@Override
	public boolean specialAttack(Pokemon target) {
		if(this.isDefeated() || target.isDefeated()) {
			return false;
		}
		if(this.currentPower > 0) {
			if(this.currentPower >= fireBall) {
				target.hurt(fireBall);
				this.currentPower -= fireBall;
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
		target.hurt(bite);
		return true;
	}
	
	public String toString() {
		return "Charmander [name=" + this.name + ", health=" + this.currentHealth + ", power=" + this.currentPower + "]";
	}
	
	public boolean equals(Object other) {
		if (!(other instanceof Charmander)) {
			return false;
		}
		Charmander mander = (Charmander) other;
		return mander.currentHealth == this.currentHealth && mander.currentPower == this.currentPower
				&& mander.name.equals(this.name);
	}

}
