//This class is use to connect database
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DA;



import domain.Product;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;


public class ProductDA {
    private String host = "jdbc:derby://localhost:1527/GUIAssignment";
    private String user = "bobo";
    private String password = "bobo";
    private String tableName = "Product";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public ProductDA(){
        createConnection();
    }
    
    public Product getProductRecordWithCode(String prod_code){
        Product product = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE prod_code = ?");
            stmt.setString(1, prod_code);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                product = new  Product(prod_code, rs.getString("prod_name"), rs.getString("prod_type"),
                        rs.getDouble("prod_price"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return  product;
    }
    
    public Product getProductRecordWithName(String prod_name) {
        Product product = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE prod_name = ?%");
            stmt.setString(1, prod_name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                product = new  Product(rs.getString("prod_code"), prod_name, rs.getString("prod_type"),
                        rs.getDouble("prod_price"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return  product;
    }
    
    public void addOnNewProductRecord(Product product) {
        try {
            stmt = conn.prepareStatement("INSERT INTO Product VALUES(?, ?, ?, ?)");
            stmt.setString(1, product.getPro_Code());
            stmt.setString(2, product.getPro_Name());
            stmt.setString(3, product.getPro_Type());
            stmt.setString(4, String.valueOf(product.getPro_Price()));
            stmt.executeUpdate();
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateProductRecord(Product product) {
        try {
            stmt = conn.prepareStatement("UPDATE Product SET  prod_name = ?, prod_type = ?, "
                    + "prod_price = ?  WHERE prod_code = ?");
            stmt.setString(1, product.getPro_Name());
            stmt.setString(2, product.getPro_Type());
            stmt.setString(3, String.valueOf(product.getPro_Price()));
            stmt.setString(4, product.getPro_Code());
            stmt.executeUpdate();
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    } 
    
    public void deleteProductRecordWithCode(String getPro_Code) {
        try {
            stmt = conn.prepareStatement("DELETE FROM Product WHERE prod_code = ?");
            stmt.setString(1, getPro_Code);
            stmt.executeUpdate();
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void deleteProductRecordWithCode(Product product) {
      
        try {
            stmt = conn.prepareStatement("DELETE FROM Product WHERE prod_code = ?");
            stmt.setString(1, product.getPro_Code());

            stmt.executeUpdate();
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateAllProductPriceByAAmount(Double amount) {
        try {
            stmt = conn.prepareStatement("UPDATE product SET prod_price = prod_price + amount");   
            stmt.setString(1, String.valueOf(amount));
            stmt.executeUpdate();
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    } 
    
    public void updateAllProductPriceByPercentage(int percentage) {
        try {
            stmt = conn.prepareStatement("UPDATE product SET prod_price = prod_price * (1+(?/100))");   
            stmt.setString(1, String.valueOf(percentage));
            stmt.executeUpdate();
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    } 
    
    public Product getCurrentRecord() {
        Product product = null;
         try {
            product = new Product(rs.getString("Prod_Code"), rs.getString("Prod_Name"), 
                    rs.getString("Prod_Type"),rs.getDouble("Prod_Price"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return product;
    }
    
    public Product getCurrentRecord1() {
        Product product = null;
         try {
            product = new Product(rs.getString("Prod_Code"), rs.getString("Prod_Name"), 
                    rs.getString("Prod_Type"),rs.getDouble("Prod_Price"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return product;
    }
    
    public ArrayList<Product> getProductArray() {
        
        String sqlQueryStr = "SELECT * from " + tableName;
        
        ArrayList<Product> product = new ArrayList<Product>();
        try {
            stmt = conn.prepareStatement(sqlQueryStr);
            rs = stmt.executeQuery();
            while (rs.next()) {
                product.add(getCurrentRecord());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        return product;
    }
    
    public ArrayList<Product> getProductArray(String pay_code) {
        
        String sqlQueryStr = "SELECT * FROM Product P, Pay_prod L WHERE L.Prod_Code = "
                + "P.Prod_Code AND L.PAY_CODE= "+"'"+pay_code+"'";
        
        ArrayList<Product> product = new ArrayList<Product>();
        try {
            stmt = conn.prepareStatement(sqlQueryStr);
            rs = stmt.executeQuery();
            while (rs.next()) {
                product.add(getCurrentRecord1());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        return product;
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

