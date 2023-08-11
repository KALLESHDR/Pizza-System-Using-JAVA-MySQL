/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizza_billing_system;

import java.io.*;
import java.sql.*;
import java.util.Scanner;
import static javafx.application.Platform.exit;

/**
 *
 * @author KALLESH DR
 */
public class User
{
    String uemail,upassword,pw;
    Scanner sc=new Scanner(System.in);

    public void Login()
    {
        try
        {
             
           
            System.out.print("Enter EmailID : ");
            uemail=sc.next();
            System.out.print("Enter Password : ");
            upassword=sc.next();
            
            /*Console cons=System.console();
            char arr[]=cons.readPassword("Enter Password : ");
            upassword=new String(arr);*/
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza", "root", "");
                   Statement st=con.createStatement();
                  
            PreparedStatement ps=con.prepareStatement("select uemail,upassword from user where uemail=? and upassword=md5(?)");
            ps.setString(1, uemail);
            ps.setString(2, upassword);
            ResultSet rs=ps.executeQuery();
            
            int r=0;
            rs.next();
            r=rs.getRow();
            
            if(r==1)
            {
                System.out.println("1.View_Menu\t 2.Order\t 3.View_Order");
                int ch=sc.nextInt();
                if(ch==1)
                {
                    View v=new View();
                    v.view_items();
                }
                else if(ch==2)
                {
                    Order o=new Order();
                    o.Createorder();
                }
                else if(ch==3)
                {
                     System.out.println("Enter Your Order_ID");
                    int oid=sc.nextInt();
                   PreparedStatement ps1=con.prepareStatement("select * from orders where oid=?");
                   ps1.setInt(1, oid);
           // ResultSet rs1=ps1.executeQuery();
            ResultSet rs1=ps1.executeQuery();
            
            int r1=0;
            while(rs.next())
            {
                r1=rs.getRow();
                System.out.print(rs.getInt(1)+"\t");
                System.out.print(rs.getInt(2)+"\t");
                System.out.print(rs.getString(3)+"\t");
                System.out.print(rs.getInt(4)+"\t");
                System.out.print(rs.getDate(5)+"\t");
                System.out.print(rs.getInt(6)+"\t");
                
                System.out.println("");
            }
            if(r1==0)
            {
                System.out.println("No Record Found");
            }  
                }
                else if(ch>=4)
                {
                   exit();
                }
                
            }
            else
            {
                System.out.println("Login info is not correct");
            }
                        
        }
        catch(Exception e)
        {
            System.out.print(e);
    }
}
}
