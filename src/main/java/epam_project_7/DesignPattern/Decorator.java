package epam_project_7.DesignPattern;

interface Vehicle
{
	   void run();
}
class Car implements Vehicle 
{

	   @Override
	   public void run() {
	      System.out.println("Vehicle : Car");
	   }
	}

class Motorcycle implements Vehicle {

	   @Override
	   public void run() {
	      System.out.println("Vehicle : Motorcycle");
	   }
	}

abstract class Repair implements Vehicle {
	   protected Vehicle parts;

	   public Repair(Vehicle parts){
	      this.parts = parts;
	   }

	   public void run(){
	      parts.run();
	   }	
	}
class Brake extends Repair {

	   public Brake(Vehicle parts) {
	      super(parts);		
	   }

	   @Override
	   public void run() {
	      parts.run();	       
	      setBrake(parts);
	   }

	   private void setBrake(Vehicle parts){
	      System.out.println("Brake of the vehicle is repaired...!!!");
	   }
	}

public class Decorator 
{
	   public static void main(String[] args) 
	   {

	      Vehicle Car = new Car();

	      Vehicle  rc = new Brake(new Car());

	      Vehicle rr = new Brake(new Motorcycle());
	      Car.run();
	      rc.run();
	      rr.run();
	   }
	}
