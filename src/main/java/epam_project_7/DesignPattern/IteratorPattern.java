package epam_project_7.DesignPattern;
 interface Student
 {
	   public boolean like();
	   public Object next();
}

interface Syllabus
{
	   public Student getSubject();
}

class Subjects implements Syllabus
{
	   public String names[] = {"Maths","Science","Telugu","English"};
	   public Student getSubject()
	   {
	      return new NameSubject();
	   }
	   private class NameSubject implements Student
	   {
	      int index;
	      @Override
	      public boolean like() 
	      {	      
	         if(index < names.length)
	            return true;
	         return false;
	      }

	      @Override
	      public Object next()
	      {	      
	         if(this.like())
	            return names[index++];
	         return null;
	      }		
	   }
}

public class IteratorPattern 
{	
	   public static void main(String[] args)
	   {
	      Subjects names = new Subjects();
	      for(Student id = names.getSubject(); id.like();)
	      {
	         String name = (String)id.next();
	         System.out.println("Subject : " + name);
	      } 	
	   }
}
