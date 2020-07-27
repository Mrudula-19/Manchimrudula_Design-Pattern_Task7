package epam_project_7.DesignPattern;
import java.util.HashMap; 
import java.util.Map; 
abstract class Flower implements Cloneable 
{ 	
	protected String fname; 	
	abstract void add(); 	
	public Object clone() 
	{ 
		Object clone = null; 
		try
		{ 
			clone = super.clone(); 
		} 
		catch (CloneNotSupportedException e) 
		{ 
			e.printStackTrace(); 
		} 
		return clone; 
	} 
} 
class Rose extends Flower 
{ 
	public Rose() 
	{ 
		this.fname = "rose"; 
	} 

	@Override
	void add() 
	{ 
		System.out.println("The colour of rose is red..!!"); 
	} 	
} 
class Lotus extends Flower{ 

	public Lotus() 
	{ 
		this.fname = "lotus"; 
	} 

	@Override
	void add() 
	{ 
		System.out.println("The color of lotus is pink..!!"); 
	} 
}

class Lilly extends Flower{ 

	public Lilly() 
	{ 
		this.fname = "lilly"; 
	} 
	@Override
	void add() 
	{ 
		System.out.println("The color of lilly is white..!!"); 
	} 
}

class FlowerStore { 
	private static Map<String, Flower> colorMap = new HashMap<String, Flower>(); 	
	static
	{ 
		colorMap.put("Rose", new Rose()); 
		colorMap.put("Lotus", new Lotus()); 
		colorMap.put("Lilly", new Lilly());
	} 	
	public static Flower getColor(String colorName) 
	{ 
		return (Flower) colorMap.get(colorName).clone(); 
	} 
} 

class Prototype 
{ 
	public static void main (String[] args) 
	{ 
		FlowerStore.getColor("Rose").add(); 
		FlowerStore.getColor("Lotus").add(); 
		FlowerStore.getColor("Lilly").add();  
	} 
} 

