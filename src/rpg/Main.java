package rpg;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;

/**
 * 
 * MAIN.CLASS DÉMARRE LE JEU AVEC UN MENU
 * LE MENU PERMET D'AFFICHER LA MAP, LE MAGASIN OU L'INVENTAIRE
 *
 */
public class Main {
	
	public static Player player = new Player(); 
	public static Shop shop = new Shop();
	public static Map map = new Map();
	
	public static void main(String[] args) {
		
		System.out.println("!!! MESSAGE CONCERNANT LA MANIPULATION DE LA MAP !!! \n"
				+ "Votre perso est représenté par le carré bleu tandis que les ennemis sont représentés par les autre carrés. \n"
				+ "Vous devez manipuler les flèches de votre clavier. \n"
				+ "Si lorsque vous saisissez une direction et que votre personnage n'avance pas, c'est normal \n"
				+ "Cela signifie que vous devez regarder la console car vous avez rencontré un ennemi !\n"
				+ "NE PAS RAPPUYER (car cela ferait avancer votre perso tout seul après avoir combatu ou fuit le monstre).. \n" 
				+ "En effet j'ai inséré un removeKeyListener mais les entrées de l'utilisateur semblent s'enregistrer pour les appliquer après et\n"
				+ "je n'ai pas trouvé la solution à mon problème.."
				+ "Je vous laisse tester le jeu! Merci pour votre attention.");
		System.out.println(System.lineSeparator());
		System.out.println("Welcome "+ player.getCaste()+" !!! \n"
				+"Your are actually in the creepy 'FOREST OF THE END'. \n"
				+ "Your aim is to arrive to the top left of the map \n"
				+ "but you have to overcome monsters and obstacles.. \n");
				
				//PAS POSSIBLE CAR MA MÉTHODE DE DÉSÉRIALISATION NE FONCTIONNE PAS
				//+ "Your goal is to beat the best score of the last player.. GOOD LUCK!!!");
		System.out.println(System.lineSeparator());
		
		displayMenu();
	}
	//Display a menu with 3 options
	private static void displayMenu() {
		
		while (true) {			
			String[] menu = {"1-Play","2-Check my inventory", "3-Go to shop"};
			
			for (String option : menu) {
				System.out.println(option+"   ");
			}
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Select an option (1 2 or 3)");
			String str = sc.nextLine();
			
			if (str.equals("1")) {
				 displayMap();
				 break;
			}
			
			else if (str.equals("2")) {
				displayInventory();
			}
			
			else if (str.equals("3")) {
				 displayShop();
			}
			
			else {
				System.out.println("Select 1 2 or 3");
			}
		}
	}
	
	//Display the map
	private static void displayMap() {
		map.showMap();
	}
	
	//Display the shop
	private static void displayShop() {
		shop.showShop();
	}
	
	//Display the inventory
	public static void displayInventory() {
		player.changeWeapon();	
	}
	
	/**
	 * 
	 * METHODE POUR ENREGISTRER LE SCORE S'IL A BATTU LE RECORD
	 * QUE JE N'AI PAS PU UTILISER CAR MA MÉTHODE DE DÉSÉRIALISATION NE FONCTIONNE
	 * PAS
	 */
	public static void serialize(Player best_player) {
		System.out.println("on serialise");
		Gson gson = new Gson();
		
		// 1. Java object to JSON file
		try (FileWriter writer = new FileWriter("best_score.json")) {
            gson.toJson(best_player, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }	    
	       
		// 2. Java object to JSON string
	    String jsonInString = gson.toJson(best_player);
	    System.out.println(jsonInString);
	}
	
	/**
	 * 
	 * METHODE POUR RÉCUPÉRER LE MEILLEUR SCORE D"UNE AUTRE PARTIE POUR 
	 * LE COMPARER AVEC LE SCORE ACTUEL
	 * CETTE MÉTHODE NE MARCHE PAS..
	 */
	public static int deserialize() {
	 Gson gson = new Gson();
	 
        try (Reader reader = new FileReader("best_score.json")) {
        	System.out.println("on deserialise2");
            // Convert JSON File to Java Object
      
        	//LE BUG SE TROUVE EN DESSOUS
            Player last_best_player = gson.fromJson(reader, Player.class);
            // print staff object
            System.out.println(last_best_player);
            int last_best_score = last_best_player.xp;
            System.out.println("etape2 score:"+last_best_player);
            
            return last_best_score;
            

        } catch (IOException e) {
            e.printStackTrace();
        }
		return 0;
	}
	
	

}
