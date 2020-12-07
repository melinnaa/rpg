package rpg;
/**
 * 
 * ENEMY EST UNE CLASSE ABSTRAITE QUI DÉFINIT LES CARACTÉRISTIQUES DES ENNEMIS
 * UN ENNEMI PROVOQUE DES DÉGATS À UN CERTAIN TAUX
 * UN ENNEMI ATTAQUE LE JOUEUR
 * UN ENNEMI PEUT SE BLESSER
 */
public abstract class Enemy extends Entity {
	protected double damage;
	
	abstract public void hit_me(double damage);
	
	protected void attackPlayer() {
		Main.player.hit_me(damage);		
	}
}
