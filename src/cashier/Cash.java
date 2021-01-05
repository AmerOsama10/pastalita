package cashier;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amer Osama
 */
public class Cash {

    private int id;
    private String name;
    private String phone;
    private String address;
    private String email;
    private String password;
    byte    state;    
    protected Date  startWorkTime;
    protected Date  finishWorkTime;
    public Cash()
    {
        this.id=id;
        this.name=name;
        this.phone=phone;
        this.address=address;
        this.email=email;
        this.password=password;
        startWorkTime = null;
        finishWorkTime = null;
        state = 0;
    }
    
      public Cash(byte state)
    {
        this.id=id;
        this.name=name;
        this.phone=phone;
        this.address=address;
        this.email=email;
        this.password=password;
        startWorkTime = null;
        finishWorkTime = null;
        this.state = state;
    }
      
    
    public Cash(int id,String name,String phone,String address,String email, String password)
    {
        this.id=id;
        this.name=name;
        this.phone=phone;
        this.address=address;
        this.email=email;
        this.password=password;
        startWorkTime = null;
        finishWorkTime = null;
        state = 0;
        
    }
    
    
     public Cash(int id,String name,String phone,String address,String email, String password,byte state)
    {
        this.id=id;
        this.name=name;
        this.phone=phone;
        this.address=address;
        this.email=email;
        this.password=password;
        startWorkTime = null;
        finishWorkTime = null;
        state = 0;
        
    }
    
            
    public int getid()
    {
        return id;
    }
    public String getname()
    {
        return name;
    }
    public String getphone()
    {
        return phone;
    }
    public String getaddress()
    {
        return address;
    }
    public String getemail()
    {
        return email;
    }
    public String getpassword()
    {
        return password;
    }
    
    
    
    
    public static final byte WORKSTATE_NON_ACTIVE = 0;
    public static final byte WORKSTATE_ACTIVE = 1;
    public static final byte WORKSTATE_FINISH = 2;
    public byte getWorkState()
    {
        return this.state;
    }

    public String getStartTime()
    {
        if(startWorkTime == null)
            return null;
        DateFormat df = new SimpleDateFormat("yyyy-M-dd hh:mm:ss a");
        return df.format(startWorkTime);
    }
    
    public String getFinishTime()
    {
        if(finishWorkTime == null)
            return null;
        DateFormat df = new SimpleDateFormat("HH:mm");
        return df.format(finishWorkTime);
    }
    //------------------------------------------------------------
    // other methods
    //------------------------------------------------------------
    public void clockIn()
    {
       // startWorkTime = new Date(System.currentTimeMillis()); 
        state = WORKSTATE_ACTIVE;
    }
    
    public void clockOut()
    {

       // finishWorkTime = new Date(System.currentTimeMillis());
       //state = WORKSTATE_FINISH;
       state = WORKSTATE_NON_ACTIVE;
       
    }
    
    public boolean changeStartTime(Date newStartTime)
    {
        if(state == WORKSTATE_FINISH && newStartTime.after(finishWorkTime))
        {
            return false;
        }
        
        if( newStartTime.after(new Date(System.currentTimeMillis())))
        {
            return false;
        }

        startWorkTime = newStartTime;
        return true;
    }
    
    public boolean changeFinishTime(Date newFinishTime)
    {
        if(newFinishTime.before(startWorkTime))
        {
            return false;
        }
        
        if( newFinishTime.after(new Date(System.currentTimeMillis())))
        {
            return false;
        }
        
        finishWorkTime = newFinishTime;
        return true;
    }
    
   
}
