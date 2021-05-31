# Serialization__Desrialization

Requirement is to seralize and Deserialize the given data. i used five classes inorder to get the requirement.

To take the input from the user and to show the choices like create,display,raisesalary,exit i used Employee class.

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

Three classes Clerk,Programmer,Manager are used to intialize the basic requirements of employees like desig and salary and raise salary perc

      public final class Clerk extends Employee 
      {
        public Clerk() 
        {
          desig = "Clerk";
          sal = 20000;
        }
        public void raiseSalary() 
        {
          sal += 1000;
        }

      }

      public final class Programmer extends Employee 
      {
        public Programmer()
        {
          desig = "Programmer";
          sal = 40000;
        }
        public void raiseSalary()
        {
          sal += 3000;
        }
      }

      public final class Manager extends Employee 
      {
        public Manager()
        {
          desig = "Manager";
          sal = 30000;
        }
        public void raiseSalary()
        {
          sal += 2000;
        }
      }
      
  and the final class of DataEntryIntoFile is used 
  
  and to store the the path of serialization data i gave path 
  
    String fileName = "C:/Users/anilp/Desktop/java/Serialization and Deserialization/data_of_employee.txt";
    
 To select the outer choices 
 
    System.out.print("\n\n1.CREATE\n2.DISPLAY\n3.RAISESALARY\n4.EXIT\n5.displayAllData\nENTER YOUR CHOICE: ");
    
 And to deserialization purpose and to restrict the duplicate data 
 
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
