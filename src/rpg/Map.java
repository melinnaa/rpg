package rpg;

import java.util.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

import javax.swing.*;

/**
 * 
 * MAP.CLASS EST UNE JFRAME QUI DÉFINI LES CARACTÉRISTIQUES DE LA MAP.
 * ELLE ÉMET DES ACTIONS VIA LES TOUCHES FLÉCHÉES DU CLAVIER.
 * ELLE CONTIENT LES POSITIONS DE CHAQUE ENTITÉ.
 * LES DIFFÉRENTES ENTITÉS SONT MISES EN RELATION PAR LEURS POSITIONS SUR LA MAP.
 *
 */
public class Map extends JFrame implements KeyListener {
	
	private static int width = 900;
	private  static int height = 900;
		
	private static int nbEnemies = 16;
	public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	public static ArrayList <Position> enemiesPos = new ArrayList <Position>();
	
	public static MapDrawing mapDrawing = new MapDrawing();
	public static Position playerPos = new Position(Main.player);
	

	public Map() {
		
		setTitle("Map");
		setSize(width, height);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addKeyListener(this);
		
		//Creation of monsters and obstacles
		for (int i=0; i<nbEnemies/2; i++) { 			
			Monster currMonster = new Monster();
			enemies.add(currMonster);
			enemiesPos.add(new Position(currMonster));
			
			Obstacle currObstacle = new Obstacle();
			enemies.add(currObstacle);
			enemiesPos.add(new Position(currObstacle));			
		}
		
		add(mapDrawing);
				
	}
	
	public void showMap() {
		setVisible(true);		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		Position.randomEnemyPosition();
		
		if (checkIfEnemy()==false) {
			switch (e.getKeyCode()) {
				case 38:
					playerPos.changePosition("up");
					break;
				case 39:
					playerPos.changePosition("right");
					break;
				case 40:
					playerPos.changePosition("down");
					break;
				case 37:
					playerPos.changePosition("left");
					break;
			}
		}
		
		checkIfWin();
		mapDrawing.repaint();
		
		try {
			checkIfBattle();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
	}
	// If the player position is at the top right of the map then he wins
	public void checkIfWin() {
		if (playerPos.getX()==0 && playerPos.getY()==800) {
			System.out.println("You win the game!");
			System.out.println("You finished  with "+ Main.player.xp +" xp !");
			
			//LA DÉSÉRIALISATION RENCONTRE UN PROBLÈME QUE JE N'AI PAS PU SOLUTIONNER
			/*int last_best_score =  Main.deserialize();
			System.out.println("yo"+last_best_score);
			if (Main.player.xp > last_best_score) {
				System.out.println("You beated the last best score of "+ last_best_score +" !");
				Main.serialize(Main.player);
			}
			else {
				System.out.println("You didn't beat the record of "+ last_best_score);
			}*/
			
			System.exit(0);
		}
	}
	
	//If the player position is equal to an enemy position than the player has the choice to fight or to escape
	public void checkIfBattle() throws InterruptedException {
		for (int i=0; i<enemies.size(); i++) { 
			if (enemiesPos.get(i).getX() == playerPos.getY() && enemiesPos.get(i).getY() == playerPos.getY()) {	
				removeKeyListener(this);
				Enemy currEnemy = enemies.get(i);
				System.out.println("You met a(n) "+currEnemy.getName()+" !");
							
				while (true) {
				
					//Launch fight or escape?
					Scanner sc = new Scanner(System.in);
					System.out.println("Select an option:");
					System.out.println("1-Combattre");
					System.out.println("2-Fuir");
					
					String res = sc.nextLine();
					
					//Launch a fight
					if (res.equals("1")) { 
						Main.player.changeWeapon();
						System.out.println("The fight is in progress..");
						Thread.sleep(3000);
						Battle battle = new Battle(currEnemy);
						battle.start();
						battle.checkResult();
						//If the enemy is dead then continue the game
						if (currEnemy.isDead()) {
							addKeyListener(this);
						}
						break;
					}
					
					//Escape the enemy
					else if (res.equals("2")) {
						System.out.println("You escape the enemy, you do not earn xp !");
						addKeyListener(this);			
						break;
					}
				
					else {
						System.out.println("You must select 1 or 2");
					}
					
				}	
				
			}
		}
	}
	
	private boolean checkIfEnemy() {
		for (int i=0; i<enemies.size(); i++) { 
			if (enemiesPos.get(i).getX() != playerPos.getY() || enemiesPos.get(i).getY() != playerPos.getY()) {	
				return false;		
			}
		}
		return true;
	}
			
	@Override
	public void keyReleased(KeyEvent e) {		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {		
	}
	
}
