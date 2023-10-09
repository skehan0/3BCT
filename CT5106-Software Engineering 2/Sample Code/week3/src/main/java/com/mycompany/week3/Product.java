package com.mycompany.week3;



/**
 *
 * @author o_molloy
 */
public final class Product  {
    
    private String name;
    private String description;
    private double price;
    private int ID;
    private Supplier supplier;
    
    public Product() {
        
    }
    
    public Product(String name, String description, double price, int ID) {
        setName(name);
        setDescription(description);
        setPrice(price);
        setID(ID);
    }

    public Supplier getSupplier()
    {
        return supplier;
    }

    public void setSupplier(Supplier supplier)
    {
        this.supplier = supplier;
    }
    
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public int getID() {
        return ID;
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }
    
}
