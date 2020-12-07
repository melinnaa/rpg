package rpg;

public class Gun extends Weapon {
	
	private static final String name = "GUN";
	private static final double DAMAGE = 300;
	private static final double MONSTER_DAMAGE_RATIO = 0.8;
	private static final double OBSTACLE_DAMAGE_RATIO = 1.2;
	
	public Gun() {
		super(name,DAMAGE,MONSTER_DAMAGE_RATIO,OBSTACLE_DAMAGE_RATIO);
	}
	
	public String Ascii_art() {
		return "__,\n"
				+ "   __/  ////////  _/                         |\n"
				+ "  < |////////__|\n"
				+ "    )                 *                |__|\n"
				+ "     /        __|\n"
				+ "    /        /  ||   //\n"
				+ "   /        /____//\n"
				+ "  /        /~~~~~\n"
				+ " /        /\n"
				+ "/        /\n"
				+ "-------/";
	}
}
