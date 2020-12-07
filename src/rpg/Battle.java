package rpg;
/**
 * 
 * BATTLE.CLASS GÈRE LES COMBATS ENTRE LE JOUEUR ET UN ENNEMI PASSÉ AU CONSTRUCTEUR.
 * ELLE PERMET DE DÉCLENCHER UN COMBAT À MORT.
 * ELLE PERMET DE VOIR LE RÉSULTAT (MORT DE QUELLE ENTITÉ).
 *
 */
public class Battle {
	
	private Enemy enemy;
	private Player player = Main.player;
	
	
	public Battle(Enemy enemy) {
		this.enemy = enemy;
	}
	//Start a battle
	public void start() {
		
		while (this.player.getLife()>0 && this.enemy.getLife()>0) {
			int whoIndex = (int)(Math.random()*2);
			
			if (whoIndex==0) {
				this.player.attackEnemy(this.enemy);
				
			}
			else if (whoIndex==1) {
				this.enemy.attackPlayer();
			}
		}
	}
	//Check the results of the battle
	public void checkResult() {
		
		//If the player is dead -> game over
		if (this.player.isDead()) {
			System.out.println("You are dead.. GAME OVER");
			System.exit(0);
			//Map.end();		
		}
		
		//If the enemy is dead, it disappears from the game and the player earn XP
		else if (this.enemy.isDead()) {
			Map.enemies.remove(enemy);
			System.out.println("You are the winner! It remains "+this.player.life+" points of life !");
			Main.player.xp+=100;
			System.out.println("Your earn 100 xp!");
		}
	}

}
