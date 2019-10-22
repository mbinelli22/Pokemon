package HW4;

public abstract class Pokemon {
	
	protected String name;
	protected int currentHealth;
	protected final int maxHealth;
	protected int currentPower;
	protected final int maxPower;
	protected int numPotions;
	protected int numEthers;
	protected static final int POTIONVALUE = 25;
	protected static final int ETHERVALUE = 15;
	
	public Pokemon(String name, int health, int power) {
		this.name = name;
		setHealth(health);
		this.maxHealth = this.currentHealth;
		setPower(power);
		this.maxPower = this.currentPower;
		numPotions = 5;
		numEthers = 3;
	}
	
	 
	public String getName() {
		return name;
	}
	
	public int getHealth() {
		return currentHealth;
	}
	
	public void setHealth(int health) {
		if (health >= 0)
			this.currentHealth = health;
	}
	
	public int getPower() {
		return currentPower;
	}
	
	public void setPower(int power) {
		if(power > 0 ) {
			this.currentPower = power;
		}
	}
	
	public int getPotions() {
		return numPotions;
	}
	
	public int getEthers() {
		return numEthers;
	}
	
	public boolean isDefeated() {
		return this.currentHealth == 0;
	}
	
	protected void hurt(int damage) {
		if(isDefeated() || damage < 0)
			return;

		this.currentHealth -= damage;

		if(this.currentHealth < 0)
			this.currentHealth = 0;
	}
	
	public boolean usePotion() {
		if(currentHealth == maxHealth || currentHealth == 0)
			return false;
		if(numPotions > 0) {
			if(POTIONVALUE + this.currentHealth > this.maxHealth) {
				this.currentHealth = this.maxHealth;
			} else {
				this.currentHealth += POTIONVALUE;
			}
			--numPotions;
			return true;
		}
		return false;
	}
	
	public boolean useEther() {
		if(currentPower == maxPower || currentHealth == 0)
			return false;
		if(numEthers > 0) {
			if(ETHERVALUE + this.currentPower > this.maxPower) {
				this.currentPower = this.maxPower;
			} else {
				this.currentPower += ETHERVALUE;
			}
			--numEthers;
			return true;
		}
		return false;
	}
	
	public abstract boolean specialAttack(Pokemon target);
	
	public abstract boolean physicalAttack(Pokemon target);
	

}