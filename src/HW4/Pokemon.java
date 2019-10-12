package HW4;

public class Pokemon {
	
	protected String name;
	protected int currentHealth;
	protected int maxHealth;
	protected int currentPower;
	protected int maxPower;
	protected int numPotions;
	protected int numEthers;
	
	public Pokemon(String name, int health, int power) {
		this.name = name;
		this.health = health;
		this.currentPower = power;
	}
	
	public String getName() {
		return name;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		
	}
	
	public int getPower() {
		
	}
	
	public int getPotions() {
		
	}
	
	public int getEthers() {
		
	}
	
	public boolean isDefeated() {
		
	}
	
	protected void hurt(int damage) {
		
	}
	
	public boolean usePotion() {
		
	}
	
	public boolean useEther() {
		
	}
	
	public boolean specialAttack(Pokemon target) {
		
	}
	
	public boolean physicalAttack(Pokemon target) {
		
	}
	

}