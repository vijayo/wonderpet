//This class is use for get and set variables
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;



public class Member{
    private String M_ID;
    private String M_Name;
    private String M_Tel;
    private String M_Address;
    private String M_DOB;
    public static int C_Member = 0;

    public Member(){ 
    }

    public Member(String M_ID){ 
        this.M_ID= M_ID;
    }

    public Member(String M_ID,String M_Name,String M_Tel, String M_Address, String M_DOB){
        this.M_ID         = M_ID;
        this.M_Name       = M_Name;
        this.M_Tel        = M_Tel;
        this.M_Address    = M_Address;
        this.M_DOB        = M_DOB;
        C_Member++;
    }

//get
    public String getM_ID (){
        return M_ID ;
    }

    public String getM_Name(){
        return M_Name;
    }

    public String getM_Tel(){
        return M_Tel;
    }

    public String getM_Address(){
        return M_Address;
    }

    public String getM_DOB(){
        return M_DOB;
    }

//set
    public void setM_ID(String M_ID){
        this.M_ID = M_ID;
    }

    public void setM_Name(String M_Name){
        this.M_Name = M_Name;
    }

    public void setM_Tel(String M_Tel){
        this.M_Tel = M_Tel;
    }

    public void setM_Address(String M_Address){
        this.M_Address = M_Address;
    }

    public void setM_DOB(String M_DOB){
        this.M_DOB = M_DOB;
    }
}
