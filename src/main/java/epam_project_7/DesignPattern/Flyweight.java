package epam_project_7.DesignPattern; 
import java.util.Random; 
import java.util.HashMap; 
interface Player 
{ 
	public void assignWeapon(String weapon); 
	public void mission(); 
} 

class Soldier implements Player 
{ 
	// Intrinsic Attribute 
	private final String TASK; 

	// Extrinsic Attribute 
	private String weapon; 

	public Soldier() 
	{ 
		TASK = "Attack Enemy"; 
	} 
	public void assignWeapon(String weapon) 
	{  
		this.weapon = weapon; 
	} 
	public void mission() 
	{  
		System.out.println("Soldier with  "
						+ weapon + "and his" + " Task is " + TASK); 
	} 
} 
class Enemy implements Player 
{ 
	private final String TASK;  
	private String weapon; 
	public Enemy() 
	{ 
		TASK = "Defend the Soldier"; 
	} 
	public void assignWeapon(String weapon) 
	{ 
		this.weapon = weapon; 
	} 
	public void mission() 
	{ 
		System.out.println("Enemy with weapon "
						+ weapon + " and his" + " Task is " + TASK); 
	} 
} 
 
class PlayerFactory 
{ 
	private static HashMap <String, Player> hm = new HashMap<String, Player>(); 
	public static Player getPlayer(String type) 
	{ 
		Player p = null; 
		if (hm.containsKey(type)) 
				p = hm.get(type); 
		else
		{ 
			switch(type) 
			{ 
			case "Soldier": 
				System.out.println("Soldier Created"); 
				p = new Soldier(); 
				break; 
			case "Enemy": 
				System.out.println("Enemy Created"); 
				p = new Enemy(); 
				break; 
			default : 
				System.out.println("Unreachable code!"); 
			}  
			hm.put(type, p); 
		} 
		return p; 
	} 
} 
 
public class Flyweight 
{ 
	private static String[] playerType = {"Soldier", "Enemy"}; 
	private static String[] weapons = {"AK-47", "Gut Knife", "Desert Eagle"};  
	public static void main(String args[]) 
	{ 
		int i=0;
		while(i<10)
		{ 
			Player p = PlayerFactory.getPlayer(getRandPlayerType()); 
			p.assignWeapon(getRandWeapon()); 
			p.mission(); 
			i=i+1;
		} 
	} 
	public static String getRandPlayerType() 
	{ 
		Random r = new Random();  
		int randInt = r.nextInt(playerType.length);  
		return playerType[randInt]; 
	} 
	public static String getRandWeapon() 
	{ 
		Random r = new Random();  
		int randInt = r.nextInt(weapons.length);  
		return weapons[randInt]; 
	} 
} 
