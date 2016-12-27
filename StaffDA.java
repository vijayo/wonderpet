//This class is use to connect database
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DA;



import domain.Staff;
import java.sql.*;
import javax.swing.*;


public class StaffDA {
    private String host = "jdbc:derby://localhost:1527/GUIAssignment";
    private String user = "bobo";
    private String password = "bobo";
    private String tableName = "Staff";
    private Connection conn;
    private PreparedStatement stmt;
    private StaffDA sfDA;
    
    public StaffDA(){
        createConnection();
    }
    
    public Staff getStaffRecordWithId(String sf_id){
        Staff staff = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE SF_ID = ?");
            stmt.setString(1, sf_id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                staff = new Staff(sf_id, rs.getString("staff_Name"), rs.getString("sf_position"),
                        rs.getString("staff_tel"),rs.getString("sf_adrs"),rs.getString("sf_dob"),rs.getDouble("sf_salary"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return  staff;
    }
    
    public void addOnNewMemberRecord(Staff staff) {
        try {
            stmt = conn.prepareStatement("INSERT INTO Staff VALUES(?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, staff.getS_ID());
            stmt.setString(2, staff.getS_Name());
            stmt.setString(3, staff.getS_Department());
            stmt.setString(4, staff.getS_Tel());
            stmt.setString(5, staff.getS_Address());
            stmt.setString(6, staff.getS_DOB());
            stmt.setString(7, String.valueOf(staff.getS_Salary()));
            stmt.executeUpdate();
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateStaffRecord(Staff staff) {
        try {
            stmt = conn.prepareStatement("UPDATE Staff SET staff_name = ?, sf_position = ?, "
                    + "staff_tel = ?, sf_adrs = ? , sf_dob = ? , sf_salary =? WHERE sf_id = ?");
            stmt.setString(1, staff.getS_Name());
            stmt.setString(2, staff.getS_Department());
            stmt.setString(3, staff.getS_Tel());
            stmt.setString(4, staff.getS_Address());
            stmt.setString(5, staff.getS_DOB());
            stmt.setString(6, String.valueOf(staff.getS_Salary()));
            stmt.setString(7, staff.getS_ID());
            stmt.executeUpdate();
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    } 
    
    public void deleteRecord(Staff staff) {
        try {
            stmt = conn.prepareStatement("DELETE FROM Staff WHERE sf_id = ?");
            stmt.setString(1, staff.getS_ID());
            stmt.executeUpdate();
        } catch(SQLException ex) {
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

