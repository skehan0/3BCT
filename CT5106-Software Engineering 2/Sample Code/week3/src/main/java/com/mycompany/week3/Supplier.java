package com.mycompany.week3;

public class Supplier
{

  
    private String name;
    private String address;
    private String telephone;
    private String email;

    public Supplier()
    {
    }

    public Supplier(String name, String address, String telephone, String email)
    {
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
    }
    
    public String getName()
    {
        return name;
    }

    
    
    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
    
    
}
