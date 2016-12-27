//This class is use to connect database
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DA;



import domain.Member;
import java.sql.*;
import javax.swing.*;


public class MemberDA {
    private String host = "jdbc:derby://localhost:1527/GUIAssignment";
    private String user = "bobo";
    private String password = "bobo";
    private String tableName = "Member";
    private Connection conn;
    private PreparedStatement stmt;
    private MemberDA memDA;
    
    public MemberDA(){
        createConnection();
    }
    
    public Member getMemberRecordWithId(String mem_id){
        Member member = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE MEM_ID = ?");
            stmt.setString(1, mem_id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
           
              member = new Member(mem_id, rs.getString("Mem_Name"), rs.getString("Mem_Tel"),
                      rs.getString("Mem_adrs"),rs.getString("mem_dob"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return  member;
    }   
    
    public int verifyMember(String MemberId){
        int i=0;
        try{
            String sqlQueryStr = "SELECT * FROM Member WHERE mem_id ='" + MemberId + "'" ;
            stmt = conn.prepareStatement(sqlQueryStr);
            ResultSet rs = stmt.executeQuery();
            if(rs.next() == true){           
            i = 1;
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return i;
    }
    
    public void addOnNewMemberRecord(Member member) {
      
        try {
          
            stmt = conn.prepareStatement("INSERT INTO Member VALUES(?, ?, ?, ?, ?)");
            stmt.setString(1, member.getM_ID());
            stmt.setString(2, member.getM_Name());
            stmt.setString(3, member.getM_Tel());
            stmt.setString(4, member.getM_Address());
            stmt.setString(5, member.getM_DOB());
            stmt.executeUpdate();
        } 
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateMemberRecord(Member member) {
      
        try {
            
            stmt = conn.prepareStatement("UPDATE Member SET Mem_name = ?, Mem_tel = ?,"
                    + " Mem_adrs = ?, Mem_dob = ? WHERE Mem_id = ?");
         
            stmt.setString(1, member.getM_Name());
            stmt.setString(2, member.getM_Tel());
            stmt.setString(3, member.getM_Address());
            stmt.setString(4, member.getM_DOB());
            stmt.setString(5, member.getM_ID());

            stmt.executeUpdate();
        } 
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    } 

    public void deleteMemberRecordWithId(Member member) {
      
        try {
            stmt = conn.prepareStatement("DELETE FROM Member WHERE mem_id = ?");
            stmt.setString(1, member.getM_ID());

            stmt.executeUpdate();
        } 
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
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