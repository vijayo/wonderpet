//This class is use for get and set variables
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;



public class Product {
    private String Pro_Code;
    private String Pro_Name;
    private String Pro_Type;
    private double Pro_Price;
    public static int C_Product = 0;
        
    public Product(){}
    
    public Product(String Pro_Code){
        this.Pro_Code=Pro_Code;
    }
    
    public Product(String Pro_Code,String Pro_Name,String Pro_Type,double Pro_Price){
        this.Pro_Code  = Pro_Code;
        this.Pro_Name  = Pro_Name;
        this.Pro_Type  = Pro_Type;
        this.Pro_Price = Pro_Price;
        C_Product++;
    }
    
//get
    public String getPro_Code(){
        return Pro_Code ;
    }
    
    public String getPro_Name(){
        return Pro_Name;
    }
    
    public String getPro_Type(){
        return Pro_Type;
    }
    
    public double getPro_Price(){
        return Pro_Price;
    }

//set
    public void setPro_Code(String Pro_Code){
        this.Pro_Code = Pro_Code;
    }
    
    public void setPro_Name(String Pro_Name){
        this.Pro_Name = Pro_Name;
    }
    
    public void setPro_Type(String Pro_Type){
        this.Pro_Type = Pro_Type;
    }
    
    public void setPro_Price(double Pro_Price){
        this.Pro_Price = Pro_Price;
    }
}


