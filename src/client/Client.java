/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;


public class Client {
    private int id;
    private String name,phone,address,notes;
    public Client(int id ,String name,String phone,String address,String notes)
    {
        this.id=id;
        this.name=name;
        this.phone= phone;
        this.address=address;
        this.notes=notes;
    }

    public Client(String name,String phone,String address,String notes)
{
   this.name=name;
        this.phone= phone;
        this.address=address;
        this.notes=notes;
}
    /**
     * @return the name
     */
  
    public int getid()
    {
        return id;
    }
    public String getName() {
        return name;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }
    
}
