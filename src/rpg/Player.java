package rpg;

import java.util.*;

/**
 * 
 * PLAYER.CLASS CORRESPOND AUX CARACTÉRISTIQUES DU JOUEUR ET DE SON PERSONNAGE
 * SES ACTIONS: CHOISIR SA CASTE, CHANGER SON ARME, EN ACHETER UNE NOUVELLE, REGARDER SON PORTE MONNAIE,
 * ATTAQUER L'ENNEMI ET SE BLESSER.
 *
 */
public class Player extends Entity {
	
	private static String [] castes = {"WARRIOR","WIZARD","MAGUS"};
	
	private String caste;
	private ArrayList<Weapon> inventory = new ArrayList<Weapon>();
	private Weapon weapon;
	private int money;
	public int xp;
	
	static Scanner sc = new Scanner(System.in);
	
	public Player() {
		inventory.add(new Hammer());
		weapon = inventory.get(0);
		money = 300;
		life = 1000;
		xp = 0;
		
		chooseCaste();		
	}
	
	public void chooseCaste() {
		
		while (true) {
			System.out.println("Choose a caste among the following: ");
			
			for (int i=0; i<castes.length; i++) {
				System.out.println(castes[i]);
			}
			
			String str = sc.nextLine();
			
			if (Arrays.binarySearch(castes, str.toUpperCase())!=-1) {
				caste = str.toUpperCase();
				break;
			}
			
			else {
				System.out.println("Cast is not recognized");
			}
		}
	}
	
	//Display the inventory
	public void changeWeapon() {

		System.out.println("Your current weapon: "+weapon.getName()+". Do you want to change ?");
		System.out.println("1-YES 2-NO");
		
		//The user makes his choice
		String str = sc.nextLine();
		
		while (!str.equals("2")) {
			System.out.println("Select a weapon in your inventory");
			
			//Display all player weapons 
			for (int i=0; i<inventory.size(); i++) {
				System.out.println(i+1+"-"+inventory.get(i).getName());
			}
			
			//User choose a weapon
			String weaponChoice = sc.nextLine();
			
			for (int i=0; i<inventory.size(); i++) {
				if (weaponChoice.equals(i+1+"")) {
					weapon = inventory.get(Integer.parseInt(weaponChoice)-1);
					
				}
			}
			
			System.out.println("Your current weapon: "+weapon.getName()+". Do you want to change ?");
			System.out.println("1-YES 2-NO");
			
			//For the loop, user makes his choice
			str = sc.nextLine();
		}
		
	}	
	
	public void buyWeapon(Weapon weapon, int price) {	
		money-=price;
		inventory.add(weapon);			
	}
	
	//Check if player's money is enough for what he wants to buy
	public boolean checkMoney(int price) {
		if (money>=price) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void attackEnemy(Enemy enemy) {
		if (weapon!=null) {
			weapon.attackEnemy(enemy);
		}
	}
	
	@Override
	public void hit_me(double damage) {
		life -= damage;
		
	}
	
	public String getCaste() {
		return caste;
	}
	
	public int getMoney() {
		return money;
	}
	
	public Weapon getWeapon() {
		return weapon;
	}	
	
	public ArrayList<Weapon> getInventory() {
		return inventory;
	}
	
}
