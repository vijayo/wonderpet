//This class is use for get and set variables
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;



public class Payment {
        private String P_NO;
        private String P_Date;
        private double P_Amount;
        private String UserID;
        private String MemberID;
        private String SitTable;

    public Payment(){}
    
    public Payment(String P_NO){
            this.P_NO=P_NO;
    }
	
    public Payment(String P_NO,String P_Date,double P_Amount,String UserID,String MemberID,String SitTable){
		this.P_NO     = P_NO;
		this.P_Date   = P_Date;
                this.P_Amount = P_Amount;
                this.UserID   = UserID;
                this.MemberID  = MemberID;
                this.SitTable = SitTable;
	}
    
//get
	public String getP_NO (){
		return P_NO ;
	}
        
	public String getP_Date(){
		return P_Date;
	}
        
	public double getP_Amount(){
		return P_Amount;
	}
        
        public String getUserID(){
		return UserID;
	}
        
        public String  getMemberID(){
		return MemberID;
	}
        
        public String getSitTable(){
		return SitTable;
	}
        
//set
	public void setP_NO(String P_NO){
		this.P_NO = P_NO;
	}
        
	public void setP_Date(String P_Date){
		this.P_Date = P_Date;
	}
        
	public void setP_Amount(double P_Amount){
		this.P_Amount = P_Amount;
	}
        
        public void setUserID(String UserID){
		this.UserID = UserID;
	}
        
        public void setMemberID(String MemberID){
		this.MemberID = MemberID;
	}
        
        public void setSitTable(String SitTable){
		this.SitTable = SitTable;
	}
}
