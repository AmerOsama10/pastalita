/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orders;

import items.Items;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Amer Osama
 */
public class findIemsDetails {
    
    private int itemid;
    findIemsDetails(int itemid){
        this.itemid=itemid;
        
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
    public ArrayList<Items>getItemList(int itemid)
    {
        ArrayList<Items>itemList=new ArrayList<Items>();
        Connection connection= getConnection();
        String query="SELECT * FROM `Items`WHERE `item_id`="+itemid;
        Statement st;
        ResultSet rs;
        try{
            st=connection.createStatement();
            rs=st.executeQuery(query);
            Items item;
            while(rs.next())
            {
                item = new Items(rs.getInt("item_id"),rs.getString("item_name"),rs.getString("item_size"),rs.getFloat("item_cost"));
                itemList.add(item);
            }
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "العنصر غير موجود");
        }
        return itemList;
    }
    
    
    

    
    
    
      
    
}
