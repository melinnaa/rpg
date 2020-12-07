package rpg;

public abstract class Entity {
	
	protected int life;
	protected String name;
	
	abstract public void hit_me(double damage);
	
	public boolean isDead() {
		if (this.life <= 0) {
			return true;
		}
		return false;		
	}
	
	public String getName(){
		return name;
	}
	
	public double getLife() {
		return life;
	}
	
	
}
