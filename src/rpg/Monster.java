package rpg;

public class Monster extends Enemy {

	public Monster() {
		this.name = "monstre";
		this.life = 500;
		this.damage = 80;
	}
	
	@Override
	public void hit_me(double damage) {
		life -= damage;
	}
	
}
