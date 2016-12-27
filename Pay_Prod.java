//This class is use for get and set variables
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;



public class Pay_Prod{
    private Product Pro_Code;
    private Payment P_NO;
        
    public Pay_Prod(){
    
    }
    
    public Pay_Prod(Product Pro_Code){
        this.Pro_Code =Pro_Code;
    }
    
    public Pay_Prod(Payment P_NO){
        this.P_NO = P_NO;
    }
    
    public Pay_Prod(Product Pro_Code,Payment P_NO){
        this.Pro_Code = Pro_Code;
        this.P_NO     = P_NO;
    }
    
//get
    public Product getPro_Code (){
        return Pro_Code ;
    }

    public Payment getP_NO(){
        return P_NO;
    }

//set
    public void setPro_Code(Product Pro_Code){
        this.Pro_Code = Pro_Code;
    }

    public void setP_NO(Payment P_NO){
        this.P_NO = P_NO;
    }
}



