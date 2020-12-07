package rpg;

public class Obstacle extends Enemy {
	
	public Obstacle() {
		this.name = "obstacle";
		this.life = 500;
		this.damage = 80;
	}
	
	@Override
	public void hit_me(double damage) {
		life -= damage;
	}
	
}
