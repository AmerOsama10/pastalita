/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Amer Osama
 */
public class CheckContinue {
    public CheckContinue()
    {
        
    }
    
    
    public Connection getConnection()
    {
        Connection con;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projecth","root","");
            return con;
        } catch(Exception e)
        {
           return null;
        }
    }
     
    public boolean check(){
        boolean flag=false;
       Connection connection= getConnection();
        String query="SELECT * FROM `cashiers` WHERE `cashier_state`=1";  
        Statement st;
        ResultSet rs;
        try{
            st=connection.createStatement();
            rs=st.executeQuery(query);
           if(rs.next())
           {
               flag=true;
                 
           }
           else
               flag=false;
            
        }
        catch(Exception e)
        {
          
            System.out.print(e.toString());
        }
      
        return flag;
    }
    
    
    public static void main(String []args)
    {
        CheckContinue c=new CheckContinue();
        System.out.print(c.check());
    }

  
}
