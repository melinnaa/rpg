package rpg;

public class Axe extends Weapon {	
	
	private static final String name = "AXE";
	private static final double DAMAGE = 200;
	private static final double MONSTER_DAMAGE_RATIO = 0.8;
	private static final double OBSTACLE_DAMAGE_RATIO = 1.2;	
	
	public Axe() {
		super(name,DAMAGE,MONSTER_DAMAGE_RATIO,OBSTACLE_DAMAGE_RATIO);
	}
		
	public String Ascii_art() {
		return "         __\n"
				+ "        ,. |_'.\n"
				+ "       / / /:\\ \\\n"
				+ "     _/_/_/::: |\n"
				+ "    /o_'/o>::/ /\n"
				+ "    / /'/:::/ /\n"
				+ "   / /_/::.'_/\n"
				+ "  / / \\__.-'              \n"
				+ " / /                      \n"
				+ "/ /                        \n"
				+ " /";
	}

}
