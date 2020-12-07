package rpg;

/**
 * 
 * POSITION.CLASS DÉFINI LA POSITION DE L'ENTITÉ PASSÉE AU CONSTRUCTEUR
 * AVEC LES COORDONNÉES DE LA MAP
 * PERMET DE CHANGER LA POSITION DU JOUEUR SUITE À UNE ENTRÉE SUR LE CLAVIER
 * PERMET DE GÉNÉRER UNE POSITION ALÉATOIRE POUR CHAQUE ENNEMI
 *
 */
public class Position {
	private int currX, currY;
	
	public Position(Entity entity) {
		
		if (entity instanceof Player) {
			this.currX = 800;
			this.currY = 0;
		}	
		
		else {
			this.currX=(int)(Math.random()*8)*100;
			this.currY=(int)(Math.random()*8)*100;
		}
	}
	
	//Change player's position
	public void changePosition(String direction) {
		
		if (direction=="up" && 0<this.currX) {
			this.currX-=100;
		}
		
		else if (direction=="down" && this.currX<800) {
			this.currX+=100;
		}
		
		else if (direction=="left" && 0<this.currY) {
			this.currY-=100;
		}
		
		else if (direction=="right" && this.currY<800) {
			this.currY+=100;
		}
	}
	
	//Generate a random position for enemies
	public static void randomEnemyPosition() {
		for (int i=0; i<Map.enemies.size(); i++) { 
			Map.enemiesPos.get(i).currX=(int)(Math.random()*8)*100;
			Map.enemiesPos.get(i).currY=(int)(Math.random()*8)*100;
		}
	}
	
	public int getX() {
		return this.currX;
	}
	
	public int getY() {
		return this.currY;
	}
		
}
