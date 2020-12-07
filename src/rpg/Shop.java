package rpg;

import java.util.*;
/**
 * 
 * SHOP.CLASS PERMET À L'UTILISATEUR DE SE PROCURER DES ARMES EN ÉCHANGE DE PPT.
 * LE CATALOGUE PRÉSENTE LES ARMES AVEC LEUR PRIX.
 * LE STOCK CONTIENT LES ARMES À DÉLIVRER.
 * 
 * LE SHOP A COMME ACTIONS: LE SERVICE CLEINTÈLE, L'AFFICHAGE DES ARTICLES ET LA TRANSACTION
 *
 */
public class Shop {
	
	static ArrayList<Weapon> stock = new ArrayList<Weapon>();
	static HashMap<String, Integer> catalog = new HashMap<String, Integer>();
	
	public Shop() {	
		catalog.put("AXE", 100);
		catalog.put("HAMMER", 100);
		catalog.put("GUN", 150);
		
		stock.add(new Axe());
		stock.add(new Hammer());
		stock.add(new Gun());
	}
	
	public static void showShop() {
		showItems();
		System.out.println("Which weapon do you want to get? (quit: q)");
		System.out.println("Your wallet: "+Main.player.getMoney());
		
		Scanner sc = new Scanner(System.in);	
		String str = sc.nextLine();
			
		while (!str.equals("q")) {
			
			str = str.toUpperCase();
			
			if (catalog.containsKey(str)) {				
				transaction(str);
			}
			
			else {
				System.out.println("Sorry we don't recognized the weapon.");
			}
			
			System.out.println("Do you want to see the catalog again ?");
			System.out.println("1-YES 2-NO");
			
			Scanner sc2 = new Scanner(System.in);	
			String str2 = sc2.nextLine();
			
			while (true) {
				if (str2.equals("1")) {
					showItems();
					break;
				}
				else if (str2.equals("2")) {
					break;
				}
				else {
					System.out.println("Select 1 or 2");
					str2 = sc2.nextLine();
				}
			}
			
			System.out.println("Which weapon do you want to get? (quit: q)");	
			System.out.println("Your wallet: "+Main.player.getMoney());
			str = sc.nextLine();
		}
	}
	
	//Display weapons catalog
	public static void showItems() {	
		for (int i=0; i<stock.size(); i++) {
			System.out.println(stock.get(i).Ascii_art());
			System.out.println(stock.get(i).getName()+": "+catalog.get(stock.get(i).getName())+" ppt");		
		}	
	}
	
	public static void transaction(String weapon) {
		
		boolean success = false;
		
		if (weapon.equals("AXE") && Main.player.checkMoney(catalog.get("AXE"))) {
			Main.player.buyWeapon(new Axe(), catalog.get("AXE"));	
			success = true;
		}
		
		else if (weapon.equals("HAMMER") && Main.player.checkMoney(catalog.get("HAMMER"))) {
			Main.player.buyWeapon(new Hammer(), catalog.get("HAMMER"));
			success = true;
		}
		
		else if (weapon.equals("GUN") && Main.player.checkMoney(catalog.get("GUN"))) {
			Main.player.buyWeapon(new Gun(), catalog.get("GUN"));
			success = true;
		}
		
		if (success==true) {
			System.out.println("You've just got: "+weapon);
		}
		
		else {
			System.out.println("You don't have enough ppt!");
		}
	}
	
}
