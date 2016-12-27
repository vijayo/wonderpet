//This class is use to connect database
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DA;



import domain.User;
import java.sql.*;
import javax.swing.*;


public class UserDA {
    private String host = "jdbc:derby://localhost:1527/GUIAssignment";
    private String user = "bobo";
    private String password = "bobo";
    private String tableName = "USERPRF";
    private Connection conn;
    private PreparedStatement stmt;
    private UserDA usDA;
    
    public UserDA(){
        createConnection();
    }
    
    public int verifyUser(String USERID, String PASSWORD){
        int i=0;
        try{
            String sqlQueryStr = "SELECT * FROM USERPRF WHERE USERID ='" + USERID + "' AND PASSWORD ='" + PASSWORD + "'" ;
                stmt = conn.prepareStatement(sqlQueryStr);
                ResultSet rs = stmt.executeQuery();
            if(rs.next() == true){
                i = 1;
                JOptionPane.showMessageDialog(null, "Welcome, " + USERID);
            }
        }catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return i;
    }
    
    public User getUserID(String USERID){
        User user = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE USERID = ?");
            stmt.setString(1, USERID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = new User(USERID, rs.getString("staff_Name"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return  user;
    }
    
    public User getPassword(String PASSWORD) {
        User user = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE PASSWORD = ?");
            stmt.setString(1, PASSWORD);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = new User(rs.getString("USERID"),PASSWORD);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return  user;
    }
    
    public void addUser(User user) {
        try {
            stmt = conn.prepareStatement("INSERT INTO User VALUES(?, ?)");
            stmt.setString(1, user.getUser_ID());
            stmt.setString(2, user.getUser_Password());
            stmt.executeUpdate();
        } 
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateUserRecord(User user) {
        try {
            stmt = conn.prepareStatement("UPDATE User SET PASSWORD = ? WHERE USERID = ?");
            stmt.setString(1, user.getUser_ID());
            stmt.setString(2, user.getUser_Password());
            stmt.executeUpdate();
        } 
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void deleteUser(String USERID) {
        try {
            stmt = conn.prepareStatement("DELETE FROM Staff WHERE USERID = ?");
            stmt.setString(1, USERID);
            stmt.executeUpdate();
        } 
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    } 

    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void shutDown() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    } 
}

