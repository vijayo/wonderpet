//This class is use to connect database
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DA;



import domain.Payment;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;


public class PaymentDA {
    private String host = "jdbc:derby://localhost:1527/GUIAssignment";
    private String user = "bobo";
    private String password = "bobo";
    private String tableName = "Payment";
    private Connection conn;
    private PreparedStatement stmt;
    private StaffDA sfDA;
    private MemberDA memDA;
    private ResultSet rs;
    
    public PaymentDA() {
        createConnection();
        sfDA = new StaffDA();
        memDA = new MemberDA();
    }
      
    public Payment getPaymentRecord(String pay_no) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE Pay_no = ?";
        Payment payment = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, pay_no);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                payment = new Payment(pay_no, rs.getString("pay_date"), rs.getDouble("pay_amount"),
                        rs.getString("userid"),rs.getString("mem_id") ,rs.getString("Sittable"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return payment;
    }
        
    public void addPaymentRecord(Payment payment){
        try{      
            stmt = conn.prepareStatement("INSERT INTO Payment VALUES(?,?,?,?,?,?)");

            stmt.setString(1,payment.getP_NO());
            stmt.setString(2,payment.getP_Date());
            stmt.setString(3,String.valueOf(payment.getP_Amount()));
            stmt.setString(4,payment.getUserID());
            stmt.setString(5,payment.getUserID());
            stmt.setString(6,payment.getSitTable());
            stmt.executeUpdate();
            conn.commit();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updatePaymentRecord(Payment payment){
        try{         
            stmt = conn.prepareStatement("UPDATE Payment SET pay_date = ?, pay_amount = ?, "
                    + "sf_id = ? ,mem_id =?, sittable = ?  WHERE pay_no = ?");
            //////y no compare with staff_id and member_id , 
            /////if no staff_id and member_id how ??//

            stmt.setString(1,payment.getP_Date());
            stmt.setString(2,String.valueOf(payment.getP_Amount()));
            stmt.setString(3,payment.getUserID());
            stmt.setString(4,payment.getMemberID());
            stmt.setString(5,payment.getSitTable());
            stmt.setString(6,payment.getP_NO());
            stmt.executeUpdate();
                    
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
       
    public void deletePaymentRecord(String pay_no){
        try{         
            stmt = conn.prepareStatement("DELETE FROM Payment WHERE pay_no = ?");
            stmt.setString(1, pay_no);
            stmt.executeUpdate();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
   
    public Payment getCurrentRecord() {
        Payment payment = null;
        try {
            payment = new Payment(rs.getString("pay_no"), rs.getString("pay_date"), 
                    rs.getDouble("pay_amount"),rs.getString("userid"),rs.getString("mem_id") ,rs.getString("Sittable"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return payment;
    }
      
    public ArrayList<Payment> getPaymentArray() {
        
        String sqlQueryStr = "SELECT * from " + tableName;
        
        ArrayList<Payment> payment = new ArrayList<Payment>();
        try {
            stmt = conn.prepareStatement(sqlQueryStr);
            rs = stmt.executeQuery();
            while (rs.next()) {
                payment.add(getCurrentRecord());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        return payment;
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