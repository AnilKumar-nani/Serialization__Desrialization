import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;

public abstract class Employee implements Serializable 
{
	String name, desig;
	int age, sal;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
	public Employee() 
	{
		try
		{
			System.out.print("\nenter your name: ");
			name = br.readLine();
			System.out.print("\nenter your age: ");
			age = Integer.parseInt(br.readLine());
		}
		catch(Exception e){}	
	}
	public String toString() 
	{
		return "\n\n---------------------------\nName: "+ name + "\nAge: " + age + "\nSalary: " + sal + "\nDesignation: " + desig +"\n----------------------------";
	}
	public abstract void raiseSalary();
}
