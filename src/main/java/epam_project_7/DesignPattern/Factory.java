package epam_project_7.DesignPattern;
interface Bills 
{ 
	void inform(); 
} 
class Current implements Bills 
{ 
	public void inform() 
	{  
		System.out.println("Current Bill"); 
	} 
}

class Water implements Bills 
{ 
	public void inform() 
	{  
		System.out.println("Water Bill"); 
	} 
}

class House 
{ 
	public Bills create(String name) 
	{ 
		if (name == null || name.isEmpty()) 
			return null; 
		if ("Water".equals(name)) { 
			return new Water(); 
		} 
		else if ("Current".equals(name)) { 
			return new Current(); 
		}  
		return null; 
	} 
} 

public class Factory { 
	public static void main(String[] args) 
	{ 
		House no = new House(); 
		Bills notify = no.create("Water");
		Bills notify1 = no.create("Current");
		notify1.inform();
		notify.inform();
	} 
} 

