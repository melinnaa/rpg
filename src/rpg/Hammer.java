package rpg;

public class Hammer extends Weapon {
	
	private static final String name = "HAMMER";
	private static final double DAMAGE = 200;
	private static final double MONSTER_DAMAGE_RATIO = 0.8;
	private static final double OBSTACLE_DAMAGE_RATIO = 1.2;
	
	
	
	public Hammer() {
		super(name,DAMAGE,MONSTER_DAMAGE_RATIO,OBSTACLE_DAMAGE_RATIO);
	}
	
	public String Ascii_art() {
		return "    !#########       #\n"
				+ "               !########!          ##!\n"
				+ "            !########!               ###\n"
				+ "         !##########                  ####\n"
				+ "       ######### #####                ######\n"
				+ "        !###!      !####!              ######\n"
				+ "          !           #####            ######!\n"
				+ "                        !####!         #######\n"
				+ "                           #####       #######\n"
				+ "                             !####!   #######!\n"
				+ "                                ####!########\n"
				+ "             ##                   ##########\n"
				+ "           ,######!          !#############\n"
				+ "         ,#### ########################!####!\n"
				+ "       ,####'     ##################!'    #####\n"
				+ "     ,####'            #######              !####!\n"
				+ "    ####'                                      #####\n"
				+ "    ~##                                          ##~";
	}
}
