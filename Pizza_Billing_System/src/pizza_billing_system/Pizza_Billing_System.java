/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizza_billing_system;

import static java.lang.System.exit;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author KALLESH DR
 */
public class Pizza_Billing_System
{
    static int choice;

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        
       input();
       
       try
       {
          while(true)
          {
              
           switch (choice) {
               case 1:
                   Admin admin = new Admin();
                   admin.AdminLogin();
                   input();
                   break;
               case 2:
                   User us=new User();
                   us.Login();
                   input();
                   break;
               case 3:
                   UserReg u=new UserReg();
                   u.UserRegistration();
                   input();
                   break;
               case 4:
                   System.out.print("Thank You!!!!!!!!!!!!!!!!!!!!!!!------------------------Visit Again-------------------------");
                   exit(0);
                   break;
               default:
                   System.out.println("Invalid Choice");
                   exit(0);
                   break;
           }
       }
       }
       catch(Exception e)
       {
           System.out.println(e);
       }
    }
    public static void input()
    {
        System.out.println("+----------------Welcome To V3Pizza--------------------------+");
       System.out.println("|                1.Admin  login                              |");
       System.out.println("|                2.User login                                |");
       System.out.println("|                3.User Registration                         |");
       System.out.println("|                4.Exit                                      |");
       System.out.println("+----------------   By Kallesh D R --------------------------+");
       Scanner sc = new Scanner(System.in);
       System.out.println("ENTER YOUR CHOICE\n");
       choice=sc.nextInt();
    }
    
}
