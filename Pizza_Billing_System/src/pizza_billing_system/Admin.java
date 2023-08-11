/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizza_billing_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
//import static pizza_billing_system.View.view_items;


/**
 *
 * @author KALLESH DR
 */
public class Admin
{
    int ch;
    private static String Username,Password;
    Scanner sc = new Scanner(System.in);
    public void AdminLogin()
    {
        try
        {
                   System.out.println("ENTER YOUR USERNAME\n");
                   Username=sc.next();
                   System.out.println("ENTER YOUR PASSWORD\n");
                   Password=sc.next();
                   
                   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza", "root", "");
                   Statement St=con.createStatement();
                   PreparedStatement ps=con.prepareStatement("Select * from admin where username=? and Password=?");
                   ps.setString(1, Username);
                   ps.setString(2, Password);
                   ResultSet rs=ps.executeQuery();
                   
                   int r=0;
            rs.next();
            r=rs.getRow();
            
            while(true)
            {
                if(r==1)
            {
                Adminview av=new Adminview();
                av.AdminViews();
            }
            
            else
            {
                System.out.println("Login info is not correct");
            }
            }
                   //Rs = St.executeQuery("Select * from admin where username=admin and Password=admin123");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    /*public void input()
    {
     System.out.println("+-------------------Welcome Admin----------------+");
                   System.out.println("|            1.Add Items                         |");
                   System.out.println("|            2.View Users                        |");
                   System.out.println("|            3.Remove Users                      |");
                   System.out.println("|            4.View Items                        |");
                   System.out.println("+------------------------------------------------+");
                   ch=sc.nextInt();   
    }*/
}
