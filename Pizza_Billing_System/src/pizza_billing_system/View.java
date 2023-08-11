/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizza_billing_system;

import java.sql.*;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 *
 * @author KALLESH DR
 */
public class View
{
    public void view_items()
    {
        
    
    try
    {
       while(true)
       {
       
       
        System.out.println("Which Item You Need To Update");
                       System.out.println("1.PIZZA 2.ICECREAM 3.COCKS 4.EXIT");
                       Scanner sc=new Scanner(System.in);
                       int ch=sc.nextInt();
                       if(ch==1)
                       {
                          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza", "root", "");
                   Statement St=con.createStatement();
        PreparedStatement ps=con.prepareStatement("select * from pizza_types");
            ResultSet rs=ps.executeQuery();
            
            int r=0;
            while(rs.next())
            {
                r=rs.getRow();
                System.out.print(rs.getInt(1)+"\t");
                System.out.print(rs.getString(2)+"\t");
                System.out.print(rs.getInt(3)+"\t");
                System.out.print(rs.getString(4)+"\t");
                
                System.out.println("");
            }
            
            if(r==0)
            {
                System.out.println("No Record Found");
            } 
                       }
                       
                       else if(ch==2)
                       {
                          
                          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza", "root", "");
                   Statement St=con.createStatement();
        PreparedStatement ps=con.prepareStatement("select * from Icecream");
            ResultSet rs=ps.executeQuery();
            
            int r=0;
            while(rs.next())
            {
                r=rs.getRow();
                System.out.print(rs.getInt(1)+"\t");
                System.out.print(rs.getString(2)+"\t");
                System.out.print(rs.getInt(3)+"\t");
                System.out.print(rs.getString(4)+"\t");
                
                System.out.println("");
            }
            if(r==0)
            {
                System.out.println("No Record Found");
            } 
                       
                       }
                       else if(ch==3)
                       {
                          
                          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza", "root", "");
                   Statement St=con.createStatement();
        PreparedStatement ps=con.prepareStatement("select * from cock");
            ResultSet rs=ps.executeQuery();
            
            int r=0;
            while(rs.next())
            {
                r=rs.getRow();
                System.out.print(rs.getInt(1)+"\t");
                System.out.print(rs.getString(2)+"\t");
                System.out.print(rs.getInt(3)+"\t");
                System.out.print(rs.getString(4)+"\t");
                
                System.out.println("");
            }
            if(r==0)
            {
                System.out.println("No Record Found");
            } 
                       
                       }
                        else if(ch>=4)
                        {
                            break;
                        }
    }
       
    }
    catch ( Exception e)
    {
        System.out.println(e);
    }
    
    }
}
