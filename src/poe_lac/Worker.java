
package poe_lac;
import javax.swing.*;
import java.util.Scanner;

public class Worker 
{
    private final int MAX_USERS = 5;
    Login user [] = new Login[MAX_USERS]; //EMPTY !!!!!
    private int numUsers = 0;// count for how many users registred 
    private int loggedInUser = 0;
    
    public void registerUser()
    {
     Scanner input = new Scanner(System.in);
     Login maybe = new Login();
     String usrInput;
     boolean valid = false;
      
      do
      {
          System.out.print("Enter preferred username [<6 + _");
          usrInput = input.next();
           //  && *checkEmpty(---------------need to check for empty 
          if ((maybe.checkUserName(usrInput))&& (maybe.checkempty(usrInput)))
            {
               valid = true;
            }
         if (!valid)
            {
                printError("Username is not correctly formatted,"+
                        "\nplease ensure that your username contain"+
                        "\nan underscore and is no more than 5 characters"+
                        "\nin length");
            } 
      }while(!valid);
      maybe.setUsername(usrInput);
     //-------------------------------------------------checking password
   
       valid = false;     
            
       do
      {
          System.out.print("Enter preferred username [<7 +UPPER + 0-9 + SPECIAL); _");
          usrInput = input.next();
          if (checkEmptyNull(usrInput))
          {
              usrInput = input.next();
              
              if ((checkEmptyNull(usrInput)))
              {
                  if (maybe.checkpasswordComplexity(usrInput))
                  {
                      valid = true;
                  }
            }
          }
        if (!valid)
        {
            printError("Username is not correctly formatted,"+
                            "\nplease ensure that your username contain"+
                            "\nan underscore and is no more than 5 characters"+
                            "\nin length");

        }
        
        
    }while (!valid);
    
    maybe.setUsername(input.next());
    System.out.print("enter Firstname: ");
    maybe.setName(input.next());
    maybe.setSurname(input.next());
   user[numUsers] = maybe;
      numUsers++; 
     }       
   
    
    
    
   public void printError(String errorMsg)  
   {
       JOptionPane.showMessageDialog(null, errorMsg, "ERROR", JOptionPane.ERROR_MESSAGE);
       
   }   
        
        
        
    public boolean checkEmptyNull(String toCheck) 
    {
        boolean valid = false;
        if ((toCheck != null) && (!toCheck.isEmpty()))
        {
            valid = true;
        }
        return valid;
    }
   
    
  public int printLoginMenu()
  {
      int selection= 0;
      boolean valid = false;
      String userInput = "";
     do
     {
        
      userInput = JOptionPane.showInputDialog(null,"\tMenu" +
              "\n-------------"+
              "\n\tl. Register a User"+
              "\n\t2. Login a User"+
              "\n\t3. Quit",
              "CANBAN APP", JOptionPane.INFORMATION_MESSAGE);
              if (checkEmptyNull(userInput))
              {
               selection = Integer.parseInt(userInput);
               if ((selection > 0 ) && (selection < 4 ))
               {
                   valid = true; 
               }
              if (!valid)
              {
                  printError("Input can only be 1 to 3");
              }
     }
     }while(!valid);
      return selection;
  }
    
    public void loginUser()
    {
        boolean valid = false;
        Scanner input = new Scanner(System.in);
        String username, password;
        
        System.out.println("-----------------");
        System.out.print("Please enter Username");
        username = input.next();
        System.out.println();
        System.out.println("-----------------");
        System.out.print("Please enter Password");
        password = input.next();
        for(int count = 0; count < numUsers; count ++)
        {
            if (user[count].getUsername().equals(username))
            {
                if (user [count].getPassword().equals(password))     
                {
                    valid = true;
                    loggedInUser = count;
                    break;
                }   
            }
        }
        if (valid)
        {
            JOptionPane.showMessageDialog(null,
                "Welcome " + user[loggedInUser].getName() +
                ", " + user[loggedInUser].getSurname() +
                "It is great to see you again.",
                "Login Success",
                JOptionPane.INFORMATION_MESSAGE);
        //PART 2 FROM HERE
        }
    
        else
        {
            printError("Username or paswword incorrect,please try again");
        }   
    }       
    
    
    
    public void mainThread()
    {int selection = 0;
    boolean quit = false;
    
    do
    {
        
        
        
        selection = printLoginMenu();
        switch (selection)
        {
            case 1 : 
             // register a user
                registerUser();
                break;
            case 2 : 
            // login a user
                 registerUser();
                break;
                
            default:
                 quit =true;
        }
    }while (!quit);
    System.exit(0);
    System.out.println("Thank you ");
    }
    
        
    
}