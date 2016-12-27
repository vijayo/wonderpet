//This class is use for get and set variables
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;



public class Staff{
    private String S_ID;
    private String S_Name;
    private String S_Department;
    private String S_Tel;
    private String S_Address;
    private String S_DOB;
    private double S_Salary;
    public static int C_Staff = 0;
	
    public Staff(){}
    
    public Staff(String S_ID){
        this.S_ID = S_ID;
    }
    
    public Staff(String S_ID,String S_Name,double S_Salary){
        this.S_ID = S_ID;
        this.S_Name= S_Name;
        this.S_Salary=S_Salary;
    }
    
    public Staff(String S_ID,String S_Name,String S_Department, String S_Tel, String S_Address, String S_DOB,double S_Salary){
        this.S_ID         = S_ID;
        this.S_Name       = S_Name;
        this.S_Department = S_Department;
        this.S_Tel        = S_Tel;
        this.S_Address    = S_Address;
        this.S_DOB        = S_DOB;
        this.S_Salary     = S_Salary;
        C_Staff++;
    }
    
//get
    public String getS_ID(){
        return S_ID;
    }
    
    public String getS_Name(){
        return S_Name;
    }
    
    public String getS_Department(){
        return S_Department;
    }
    
    public String getS_Tel(){
        return S_Tel;
    }
    
    public String getS_Address(){
        return S_Address;
    }
    
    public String getS_DOB(){
        return S_DOB;
    }
    
    public double getS_Salary(){
        return S_Salary;
    }
        
//set
    public void setS_ID(String S_ID){
        this.S_ID = S_ID;
    }

    public void setS_Name(String S_Name){
        this.S_Name = S_Name;
    }

    public void setS_Department(String S_Department){
        this.S_Department = S_Department;
    }

    public void setS_Tel(String S_Tel){
        this.S_Tel = S_Tel;
    }

    public void setS_Address(String S_Address){
        this.S_Address = S_Address;
    }

    public void setS_DOB(String S_DOB){
        this.S_DOB = S_DOB;
    }

    public void setS_Salary(double S_Salary){
        this.S_Salary = S_Salary;
    }

    @Override
    public String toString(){
        return String.format("%-6s", S_ID);
    }

    public String toString1(){
        return String.format("%-6s, %-25s,%-.2f", S_ID, S_Name,S_Salary);
    }

    public String toString2(){
        return String.format("%-6s, %-25s, %-10s, %-11s, %-70s, %-10s, %-.2f", 
                S_ID, S_Name, S_Department,S_Tel, S_Address, S_DOB, S_Salary);
    }
}