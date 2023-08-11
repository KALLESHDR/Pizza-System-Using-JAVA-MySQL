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

/**
 *
 * @author KALLESH DR
 */
public class ViewOrders
{
    public void vieworder()
    {
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza", "root", "");
                   Statement St=con.createStatement();
                   PreparedStatement ps=con.prepareStatement("select * from orders");
            ResultSet rs=ps.executeQuery();
            
            int r=0;
            while(rs.next())
            {
                r=rs.getRow();
                System.out.print(rs.getInt(1)+"\t");
                System.out.print(rs.getInt(2)+"\t");
                System.out.print(rs.getString(3)+"\t");
                System.out.print(rs.getInt(4)+"\t");
                System.out.print(rs.getDate(5)+"\t");
                System.out.print(rs.getInt(6)+"\t");
                
                System.out.println("");
            }
            if(r==0)
            {
                System.out.println("No Record Found");
            } 
        }
        catch(Exception e)
                   {
                               System.out.println(e);

                   }
    }
}
