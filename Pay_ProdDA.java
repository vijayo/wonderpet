//This class is use to connect database
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DA;



import domain.Pay_Prod;
import domain.Payment;
import domain.Product;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;


public class Pay_ProdDA {
    private String host = "jdbc:derby://localhost:1527/GUIAssignment";
    private String user = "bobo";
    private String password = "bobo";
    private String tableName = "Pay_prod";
    private Connection conn;
    private PreparedStatement stmt;
    private ProductDA prodDA;
    private PaymentDA payDA;
    private ResultSet rs;
    
    public Pay_ProdDA() {
        createConnection();
        prodDA = new ProductDA();
        payDA = new PaymentDA();
    }

    public Pay_Prod getPay_ProdRecord(String pay_code) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE Pay_code = ?";
        Pay_Prod pay_prod = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, pay_code);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Product pr = prodDA.getProductRecordWithCode(rs.getString("prod_code"));
                Payment pa  = payDA.getPaymentRecord(rs.getString("sf_id"));
           
                pay_prod = new Pay_Prod(pr,pa);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return pay_prod;
    }
    
    public void addPay_ProdRecord(Pay_Prod pay_prod){
        try{      
            stmt = conn.prepareStatement("INSERT INTO pay_prod VALUES(?,?)");
            stmt.setString(1,pay_prod.getPro_Code().getPro_Code());
            stmt.setString(2,pay_prod.getP_NO().getP_NO());
            stmt.executeUpdate();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
      
    public void addPay_ProdRecord(ArrayList<Pay_Prod> pay_prod){
        try{      
            for(int i=0 ; i <pay_prod.size();i++){
            stmt = conn.prepareStatement("INSERT INTO pay_prod VALUES(?,?)");
            stmt.setString(1,pay_prod.get(i).getPro_Code().getPro_Code());
            stmt.setString(2,pay_prod.get(i).getP_NO().getP_NO());
            stmt.executeUpdate();
        }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
      
    public void updatePay_ProdRecord(Pay_Prod pay_prod){
        try{         
            stmt = conn.prepareStatement("UPDATE pay_prod SET prod_code = ? WHERE pay_no = ?");
            //////y no compare with staff_id and member_id , 
            /////if no staff_id and member_id how ??//

            stmt.setString(1,pay_prod.getPro_Code().getPro_Code());
            stmt.setString(2,pay_prod.getP_NO().getP_NO());
            stmt.executeUpdate();

        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
       
    public void deletePay_ProdRecord(String pay_no){
        try{         
            stmt = conn.prepareStatement("DELETE FROM Pay_Prod WHERE pay_no = ?");
            stmt.setString(1, pay_no);
            stmt.executeUpdate();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
     
    public Pay_Prod getCurrentRecord() {
        Pay_Prod pay_prod = null;
         try {
            Product pr = prodDA.getProductRecordWithCode(rs.getString("prod_code"));
            Payment pa  = payDA.getPaymentRecord(rs.getString("sf_id"));
            pay_prod = new Pay_Prod(pr,pa);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return pay_prod;
    }
      
    public ArrayList<Pay_Prod> getProductArray() {
        
        String sqlQueryStr = "SELECT * from " + tableName;
        
        ArrayList<Pay_Prod> pay_prod = new ArrayList<Pay_Prod>();
        try {
            stmt = conn.prepareStatement(sqlQueryStr);
            rs = stmt.executeQuery();
            while (rs.next()) {
                pay_prod.add(getCurrentRecord());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        return pay_prod;
    }
      
    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void shutDown() {
        if (conn != null)
            try {
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
