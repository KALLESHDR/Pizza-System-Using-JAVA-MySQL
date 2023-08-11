/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizza_billing_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author KALLESH DR
 */
public class UserReg
{
    int uid;
    long umobile;
    String uemail,upassword,uname;
   public void UserRegistration()
   {
       Scanner sc=new Scanner(System.in);
       try
       {
           
                                System.out.println("Enter Name");
                                uname=sc.next();
                                System.out.println("Enter Number");
                                umobile=sc.nextLong();
                                System.out.println("Enter E-mail");
                                uemail=sc.next();
                                System.out.println("Enter Password");
                                upassword=sc.next();

           
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza", "root", "");
                   Statement st=con.createStatement();
                   PreparedStatement ps1=con.prepareStatement("select uemail,umobile from user where uemail=? or umobile=?");
            //ps1.setInt(1, uid);
            ps1.setString(1, uemail);
            ps1.setLong(2, umobile);
            ResultSet rs=ps1.executeQuery();
           
            int r=0;
            rs.next();
            r=rs.getRow();
            
            if(r==0)
            {
                PreparedStatement ps2=con.prepareStatement("insert into user(uname,umobile,uemail,upassword) values(?,?,?,md5(?))");
                //ps2.setInt(1, uid);
                ps2.setString(1, uname);
                ps2.setLong(2, umobile);
                ps2.setString(3, uemail);
                ps2.setString(4, upassword);
                
                int i=ps2.executeUpdate();
                if(i==1)
                {
                     System.out.println("Account Registered Successfully");
                       
                }
                else
                {
                                        System.out.println("Account not created.");

                }
            }
            else
            {
                                     System.out.println("User info already Exist");

            }
       }
       catch ( Exception e)
    {
        System.out.println(e);
    }
   }
}
