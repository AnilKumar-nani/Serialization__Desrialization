import java.util.ArrayList;
import java.io.*;

public class DataEntryIntoFile 
{	
	public static void main(String[] args) 
	{
		String fileName = "C:/Users/anilp/Desktop/java/Serialization and Deserialization/data_of_employee.txt";
		
			try 
			{
				FileOutputStream fos;
				FileInputStream fis;
				ObjectOutputStream oos;
				ObjectInputStream ois;
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				ArrayList employee = new ArrayList();

				int outerMenuChoice = 0, innerMenuChoice = 0;
				do
				{
					System.out.print("\n\n1.CREATE\n2.DISPLAY\n3.RAISESALARY\n4.EXIT\n5.displayAllData\nENTER YOUR CHOICE: ");
					outerMenuChoice = Integer.parseInt(br.readLine());
					switch(outerMenuChoice) 
					{
						case 1: 
						{
							do 
							{
								System.out.print("\n\n1.CLERK\n2.MANAGER\n3.PROGRAMMER\n4.EXIT\nENTER YOUR CHOICE: ");
								innerMenuChoice = Integer.parseInt(br.readLine());
								Employee emp = null;
								switch(innerMenuChoice) 
								{
									case 1: emp = new Clerk();
											break;
									case 2: emp = new Manager();
											break;
									case 3: emp = new Programmer();
											break;
									case 4: break;
									default: System.out.print("\n\ninvalid entry...!");
										    break;
								}
								if(innerMenuChoice == 1 || innerMenuChoice == 2 || innerMenuChoice == 3) 
								{
									boolean existing = false;
									for( Object k : employee) 
									{
										Employee e = (Employee) k;
														
										if(e.name.equals(emp.name) && e.age == emp.age) 
										{
											System.out.print("\nRecord already exists...");
											existing = true;
											break;
										}
									}
									if(!existing) 
									{
										employee.add(emp);
										ArrayList al;
										try 
										{
											fis = new FileInputStream(fileName);
											ois = new ObjectInputStream(fis);
											al = (ArrayList) ois.readObject();
											ois.close();
										}
										catch (Exception e) 
										{
											al = new ArrayList();
										}
										al.add(emp);
										fos = new FileOutputStream(fileName);
										fos.close();
										fos = new FileOutputStream(fileName);
										oos = new ObjectOutputStream(fos);
										oos.writeObject(al);
										al = null;
										oos.close();
									}
								}
								} while(innerMenuChoice != 4);
							  	  break;
							}	
							case 2: 
							{
								if(employee.size() == 0) 
								{
									System.out.print("\n\nNorecords found.....?");
									break;
								}
								for(Object e:employee) System.out.print(e);
								break;
							}
							case 3: 
							{
								if(employee.size() == 0) 
								{
									System.out.print("\n\nNorecords found.....?");
									break;
								}
								for(Object k:employee) 
								{
									Employee e = (Employee) k;
									e.raiseSalary();
								}
								System.out.print("\n\nSalary raised...");
								break;
							}
							case 4: System.out.print("\nExiting....!");
									break;
							case 5:
									try 
									{
										fis = new FileInputStream(fileName);
										ois = new ObjectInputStream(fis);
										ArrayList al = (ArrayList) ois.readObject();
							
										for(Object e: al) 
										{
											System.out.println(e);
										}
							
										fis.close();
										ois.close();
									} 
									catch (Exception e1) 
									{
										System.out.println("file empty");
									}
								
									break;
									default: System.out.print("\nInvalid choice....$");
						
					}
				} while(outerMenuChoice != 4);
			
		}
		catch(Exception e) {e.printStackTrace();}
	}
}