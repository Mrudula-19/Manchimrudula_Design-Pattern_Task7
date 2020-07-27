package epam_project_7.DesignPattern;
interface Strategy {
	   public int doOperation(int n1, int n2);
	}

class Multiply implements Strategy
{
	   @Override
	   public int doOperation(int a, int b) {
	      return a*b;
	   }
	}

class Division implements Strategy
{
	   @Override
	   public int doOperation(int a, int b) {
	      return a/b;
	   }
	}

class Addition implements Strategy
{
	   @Override
	   public int doOperation(int a, int b) {
	      return a+b;
	   }
	}

class Subtraction implements Strategy
{
	   @Override
	   public int doOperation(int a, int b) {
	      return a-b;
	   }
	}

class Operation
{
	   private Strategy strategy;

	   public Operation(Strategy strategy){
	      this.strategy = strategy;
	   }

	   public int execute(int a, int b){
	      return strategy.doOperation(a,b);
	   }
	}

public class StrategyPattern
{
	   public static void main(String[] args)
	   {
	      Operation add = new Operation(new Addition());		
	      System.out.println("300 + 200 = " + add.execute(300,200));

	      Operation sub= new Operation(new Subtraction());		
	      System.out.println("37 - 19 = " + sub.execute(37,19));

	      Operation mul = new Operation(new Multiply());		
	      System.out.println("19 * 19 = " + mul.execute(19,19));
	      
	      Operation div = new Operation(new Division());		
	      System.out.println("50 / 5 = " + div.execute(50, 5));
	      
	      
	   }
	}

