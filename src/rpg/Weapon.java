package rpg;
/**
 * 
 * WEAPON EST UNE CLASSE ABSTRAITE QUI DÉFINIT LES CARACTÉRISTIQUES GÉNÉRALES D'UNE ARME (NOM, DÉGAT, VISUEL 
 * PUISSANCE DE DÉGAT ENVERS UN MONSTRE, PUISSANCE DE DÉGAT ENVERS UN OBSTACLE)
 * ACTION PRINCIPALE D'UNE ARME: ATTAQUER L'ENNEMI
 *
 */
public abstract class Weapon {
	
	protected String name;
	protected double damage;
	private double MONSTER_DAMAGE_RATIO;
	private double OBSTACLE_DAMAGE_RATIO;
	
	public Weapon (String name, double damage, double monter_damage_ratio, double obstacle_damage_ratio) {
		this.name=name;
		this.damage = damage;
		MONSTER_DAMAGE_RATIO = monter_damage_ratio;
		OBSTACLE_DAMAGE_RATIO = obstacle_damage_ratio;
	}
	
	public String getName() {
		return this.name;
	}
	
	abstract protected String Ascii_art();
	
	public String getAscii() {
		return this.Ascii_art();
	}

	public void attackEnemy(Enemy enemy) {
		if (enemy instanceof Monster) {
			enemy.hit_me(enemy.damage*MONSTER_DAMAGE_RATIO);
		}
		else if (enemy instanceof Obstacle) {
			enemy.hit_me(enemy.damage*OBSTACLE_DAMAGE_RATIO);
		}
	}
	
}

