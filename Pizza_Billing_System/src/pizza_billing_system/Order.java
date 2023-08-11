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
import java.util.Random;
import java.util.Scanner;
import static javafx.application.Platform.exit;

/**
 *
 * @author KALLESH DR
 */
public class Order
{
    static int c,e,f,d,gh,id,a,b,k,l,p,h,id1,id2;
    public void Createorder()
    {
       try
       {
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza", "root", "");
                   Statement st=con.createStatement();
                   System.out.println("Do you want\n 1.Pizza\n 2.Icecream\n 3.Cock\n");
                           Scanner sc=new Scanner(System.in);
                           int ch=sc.nextInt();
                           if(ch==1)
                           {
                               System.out.println("Enter Pizza ID");
                               id=sc.nextInt();
                               PreparedStatement ps=con.prepareStatement("select id,name,cost from pizza_types where id=?");
                               ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            
            int r=0;
            while(rs.next())
            {
                r=rs.getRow();
                System.out.print(rs.getInt(1)+"\t");
                System.out.print(rs.getString(2)+"\t");
                System.out.print(rs.getInt(3)+"\t");
                
                a=rs.getInt(3);
                System.out.println("");
                //System.out.println(a);
                System.out.println("How many pizza You Need");
                b=sc.nextInt();
                c=a*b;
                
                System.out.println("Doy want to continue With More Items Or Moving To Bill\n");
                System.out.println("To Bill Prees1\n For Continue More Press 0\n");
                int z=sc.nextInt();
                if(z==1)
                {
                    gh=c+e+f;
                    //System.out.println("Your Bill Is \t"+(c));
                    Order o=new Order();
                    o.payment();
                }
                else
                {
                    Createorder();
                }
                
            }
            if(r==0)
            {
                System.out.println("No Record Found");
                Createorder();
            } 
                           }
                           else if(ch==2)
                               {
                               System.out.println("Enter Icecream ID");
                               id1=sc.nextInt();
                               PreparedStatement ps=con.prepareStatement("select id,name,cost from Icecream where id=?");
                               ps.setInt(1,id1);
            ResultSet rs=ps.executeQuery();
            
            int r=0;
            while(rs.next())
            {
                r=rs.getRow();
                System.out.print(rs.getInt(1)+"\t");
                System.out.print(rs.getString(2)+"\t");
                System.out.print(rs.getInt(3)+"\t");
                
                k=rs.getInt(3);
                System.out.println("");
                //System.out.println(a);
                System.out.println("How many Icecream You Need");
                l=sc.nextInt();
                e=k*l;
                
                System.out.println("Doy want to continue With More Items Or Moving To Bill\n");
                System.out.println("To Bill Prees1\nFor Continue More Press 0\n");
                int z=sc.nextInt();
                if(z==1)
                {
                    d=c+e;
                    gh=c+e+f;
                    //System.out.println("Your Bill Is \t"+(d));
                    Order o=new Order();
                    o.payment();
                }
                else
                {
                    Createorder();
                }
                
            }
            if(r==0)
            {
                System.out.println("No Record Found");
                Createorder();
            } 
                           }
                           else if(ch==3)
                               {
                               System.out.println("Enter Cock ID");
                               id2=sc.nextInt();
                               PreparedStatement ps=con.prepareStatement("select id,name,cost from Cock where id=?");
                               ps.setInt(1,id2);
            ResultSet rs=ps.executeQuery();
            
            int r=0;
            while(rs.next())
            {
                r=rs.getRow();
                System.out.print(rs.getInt(1)+"\t");
                System.out.print(rs.getString(2)+"\t");
                System.out.print(rs.getInt(3)+"\t");
                
                p=rs.getInt(3);
                System.out.println("");
                //System.out.println(a);
                System.out.println("How many Cock You Need");
                h=sc.nextInt();
                f=h*p;
                
                System.out.println("Doy want to continue With More Items Or Moving To Bill\n");
                System.out.println("To Bill Prees1\nFor Continue More Press 0\n");
                int z=sc.nextInt();
                if(z==1)
                {
                    gh=c+e+f;
                    /*System.out.println("Your Bill Is \t"+(gh));*/
                    Order o=new Order();
                    o.payment();
                }
                else
                {
                    Createorder();
                }
                
            }
            if(r==0)
            {
                System.out.println("No Record Found");
                Createorder();
                
            } 
                           }
                           
                           
       }
       catch(Exception e)
       {
           System.out.println(e);
       }
    }
    public void payment()
    {
        Random ran=new Random();
        int orderid=ran.nextInt(1000);
        int paymentid=ran.nextInt(100000000);
        


        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|                      Your Orders Are                          |");
        System.out.println("|---------------------------------------------------------------|");
        System.out.println("|Items      id        Units             Cost          Total_Cost|");
        System.out.println("|---------------------------------------------------------------|");
        System.out.println("|Pizza    "+id+"     "+b+"             "+a+"          "+c+"     |");
        System.out.println("|Icecream "+id1+"     "+l+"             "+k+"          "+e+"     |");
        System.out.println("|Cock     "+id2+"     "+h+"             "+p+"          "+f+"     |");
        System.out.println("|Total                  "+(b+h+l)+"                    " +(gh)+"  |");
        System.out.println("|---------------------------------------------------------------|");
        System.out.println("#######################################################################################");
        System.out.println("Enter 1 To Do Confirm Your Order And Move To Payment");
        Scanner sc=new Scanner(System.in);
        int i=sc.nextInt();
        if(i==1)
        {
            System.out.println("Enter Your Email");
            String uemail=sc.next();
        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|                      Your Order Id Is                         |");
        System.out.println("|                        "+orderid+"                            |");
        System.out.println("+---------------------------------------------------------------+");


        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|                      Your Orders Are                          |");
        System.out.println("|---------------------------------------------------------------|");
        System.out.println("|Items      id        Units             Cost          Total_Cost|");
        System.out.println("|---------------------------------------------------------------|");
        System.out.println("|Pizza    "+id+"     "+b+"             "+a+"          "+c+"     |");
        System.out.println("|Icecream "+id1+"     "+l+"             "+k+"          "+e+"     |");
        System.out.println("|Cock     "+id2+"     "+h+"             "+p+"          "+f+"     |");
        System.out.println("|Total                  "+(b+h+l)+"                    " +(gh)+"  |");
        System.out.println("+---------------------------------------------------------------+");
        System.out.println("                                                                 ");
        System.out.println("                                                                 ");
        System.out.println("                                                                 ");
        System.out.println("|---------------------------------------------------------------|");
        System.out.println("|Your Transaction Id Is\n"+paymentid+"                          |");
        System.out.println("                Order Once Palced Not Allowed To Cancel          ");
        System.out.println("                \n Do You Want To Exit Press 1\n                 ");
        
        
                   try
                   {
                       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza", "root", "");
                   Statement St=con.createStatement();
                   PreparedStatement ps=con.prepareStatement("insert into orders (oid,uemail,pid,doo,totalcost) values(?,?,?,now(),?)");
                  
                   ps.setInt(1, orderid);
                   ps.setString(2, uemail);
                   ps.setInt(3, paymentid);
                   ps.setInt(4, gh);
                   //ResultSet rs1=ps1.executeUpdate();
                   int i1=ps.executeUpdate();
                   if(i1==1)
                {
                    System.out.println("                Thank You Visit Again                            ");
            exit();
                    
                }
                else
                {
                    System.out.println("Your Order Canceled Due To Error Re-Order Again"); 
                }
                   }
                   catch(Exception e)
                   {
                               System.out.println(e);

                   }
        
        
        
        
        
        
        
        int ei=sc.nextInt();
        if(ei==1)
        {
            System.out.println("                Thank You Visit Again                            ");
            exit();
        }
        
        



        }


    }
}
