//This class is use for get and set variables
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;



public class User {
    private String User_ID;
    private String User_Password;
    
    public User(){}
    
    public User(String User_ID,String User_Password){
        this.User_ID = User_ID;
        this.User_Password= User_Password;
    }
    
//get
     public String getUser_ID(){
        return User_ID;
    }
     
    public String getUser_Password(){
        return User_Password;
    }
    
//set
    public void setUser_ID(){
        this.User_ID = User_ID;
    }
    
    public void setUser_Password(){
        this.User_Password = User_Password;
    }
}
