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
//import static javafx.application.Platform.exit;

/**
 *
 * @author KALLESH DR
 */
public class Adminview
{
 public void AdminViews()
 {
     try
     {
         Scanner sc = new Scanner(System.in);
     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza", "root", "");
                   Statement St=con.createStatement();
      System.out.println("+-------------------Welcome Admin----------------+");
                   System.out.println("|            1.Add Items                         |");
                   System.out.println("|            2.View Items                        |");
                   System.out.println("|            3.View Users                        |");
                   System.out.println("|            4.View Orders                       |");
                   System.out.println("+------------------------------------------------+");
                   int ch=sc.nextInt();  
                  
                   
                   if(ch==1)
                   {
                       System.out.println("Which Item You Need To Update");
                       System.out.println("1.PIZZA 2.ICECREAM 3.COCKS");
                       int a=sc.nextInt();
                       if(a==1)
                       {
                             String Name;
                             int Cost;
                             String SIZE;
                             System.out.println("Enter Name");
                             Name=sc.next();
                             System.out.println("Enter Cost");
                             Cost=sc.nextInt();
                             System.out.println("Enter Size(S/M/L)");
                             SIZE=sc.next();
                             
                   PreparedStatement ps1=con.prepareStatement("insert into pizza_types (Name,Cost,SIZE) values(?,?,?)");
                  
                   ps1.setString(1, Name);
                          
                   ps1.setInt(2, Cost);
                          
                   ps1.setString(3, SIZE);
                   //ResultSet rs1=ps1.executeUpdate();
                   int i=ps1.executeUpdate();
                   if(i==1)
                {
                    System.out.println("Item Added Sussefully");  
                    
                }
                else
                {
                    System.out.println("Item Not Added"); 
                }
                   
                   
                       }
                       else if(a==2)
                           {
                           
                             String name;
                             int cost;
                             String flavour;
                             System.out.println("Enter Name");
                             name=sc.next();
                             System.out.println("Enter Cost");
                             cost=sc.nextInt();
                             System.out.println("Enter Flavour");
                             flavour=sc.next();
                             
                   PreparedStatement ps2=con.prepareStatement("insert into Icecream (name,cost,flavour) values(?,?,?)");
                  
                   ps2.setString(1, name);
                          
                   ps2.setInt(2, cost);
                          
                   ps2.setString(3, flavour);
                   //ResultSet rs1=ps1.executeUpdate();
                   int i=ps2.executeUpdate();
                   if(i==1)
                {
                    System.out.println("Item Added Sussefully");                }
                else
                {
                    System.out.println("Item Not Added"); 
                }
                           }
                   else if(a==3)
                           {
                           
                             String name;
                             int cost;
                             String flavour;
                             System.out.println("Enter Name");
                             name=sc.next();
                             System.out.println("Enter Cost");
                             cost=sc.nextInt();
                             System.out.println("Enter Flavour");
                             flavour=sc.next();
                             
                   PreparedStatement ps2=con.prepareStatement("insert into Cock (name,cost,flavour) values(?,?,?)");
                  
                   ps2.setString(1, name);
                          
                   ps2.setInt(2, cost);
                          
                   ps2.setString(3, flavour);
                   //ResultSet rs1=ps1.executeUpdate();
                   int i=ps2.executeUpdate();
                   if(i==1)
                {
                    System.out.println("Item Added Sussefully");  
                }
                else
                {
                    System.out.println("Item Not Added"); 
                }
                           }
                
                       
                      
                   }
                   /*-------------------View Items--------------*/
                if(ch==2)
                {
                    View v=new View();
                    v.view_items();
                    
                    
                }
                else if(ch==3)
                {
                    
        PreparedStatement ps3=con.prepareStatement("select uid,uname,umobile,uemail from user");
            ResultSet rs5=ps3.executeQuery();
            
            int r1=0;
            while(rs5.next())
            {
                r1=rs5.getRow();
                System.out.print(rs5.getInt(1)+"\t");
                System.out.print(rs5.getString(2)+"\t");
                System.out.print(rs5.getLong(3)+"\t");
                System.out.print(rs5.getString(4)+"\t");
                
                System.out.println("");
            }
            
            if(r1==0)
            {
                System.out.println("No Record Found");
            } 
                }
                
                else if(ch==4)
                {
                    ViewOrders vo=new ViewOrders();
                    vo.vieworder();
                }
                else if(ch>4)
                {
                    exit();
                }
     
     }
     catch(Exception e)
     {
         
     }


                
                
 }

    private void exit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
