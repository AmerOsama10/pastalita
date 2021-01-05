/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashier;

import items.Items;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Amer Osama
 */
public class findCashierDetails {
 private int cashierid;
    findCashierDetails(int cashierid){
        this.cashierid=cashierid;
        
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
    
  public ArrayList<Cash>getCashierList(int itemid)
    {
        ArrayList<Cash>CashierList=new ArrayList<Cash>();
        Connection connection= getConnection();
        String query="SELECT * FROM `cashiers`WHERE `cashier_id`="+cashierid;
        Statement st;
        ResultSet rs;
        try{
            st=connection.createStatement();
            rs=st.executeQuery(query);
            Cash cash;
            while(rs.next())
            {
                cash = new Cash(rs.getInt("cashier_id"),
                                rs.getString("cashier_name"),
                                rs.getString("cashier_phone"),
                                rs.getString("cashier_address"),
                                rs.getString("cashier_email"),
                                rs.getString("cashier_password"),
                                rs.getByte("cashier_state")
                );
            CashierList.add(cash);
            }
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "العنصر غير موجود");
        }
        return CashierList;
    }
}
    
    