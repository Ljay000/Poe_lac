
package poe_lac;


public class Login {
    private String name = "";
    private String surname = "";
    private String username = "";
    private String password = "";
    
    private final int MAX_USERNAME = 5;
    private final int MIN_PASSWORD = 8;
    private final String UNDERSCORE = "";
    private final String SPECIAL = "!@#$%^&*()_-=+]}[{'?/.,;:";

  public Login ()
  {
      
  }
            
    public Login(String Name, String Surname, String Username, String Password)
            
    {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }
    
    public boolean checkUserName(String toCheck)
    {
        boolean valid = false;
        if (toCheck.length () <= MAX_USERNAME)
        {
            if (toCheck.contains (UNDERSCORE))
            {
                valid = true;
            }
        
        }
        return valid;
    }
    
    public boolean checkSpecial(String toCheck)
    {
        boolean valid = false;
        
        for (int count = 0; count < SPECIAL.length();count++)
        {
            String str = Character.toString(SPECIAL.charAt(count));
            if (toCheck.contains (str))
            { 
               
                valid =true;
                break;
            }
        }
        return valid;
    }
    
    
    
    
    public boolean checkDigit (String toCheck)
    {
        boolean valid = false;
        
       for (int count = 0; count < toCheck.length (); count++)
       {
           if (Character.isDigit(toCheck.charAt(count)))
           {
               valid = true;
               break;
           }  
               
       }
      return valid;
    }
    
    public boolean checkUpper(String toCheck)
    {
        boolean valid = false;
        
       for (int count = 0; count < toCheck.length (); count++)
       {
           if (Character.isUpperCase(toCheck.charAt(count)))
           {
               valid = true;
               break;
           }   
       }
      return valid;
    }
    
        public boolean checkpasswordComplexity (String toCheck)
        {
            boolean valid = false;
            if (toCheck.length () >= MIN_PASSWORD)
            {
               if ((checkDigit(toCheck)) && (checkUpper(toCheck)))
               {
                   if (checkSpecial(toCheck))
                   {
                    valid = true;    
                   }
               }   
               
            }
        return valid;
        }
    
     public boolean checkempty (String toCheck)
        {
            boolean valid = false;
            if (toCheck.length () >= MIN_PASSWORD)
            {
               if ((checkempty(toCheck)) && (checkempty(toCheck)))
               {
                   if (checkempty(toCheck))
                   {
                    valid = true;    
                   }
               }   
               
            }
        return valid;
        }
    
    public String getName() 
    {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
}
