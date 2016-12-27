//This class is use for search drink details and food details in database
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Menu;



import DA.TablesModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;


public class Search_Menu extends JFrame{
    static private String DATABASE_URL = "jdbc:derby://localhost:1527/GUIAssignment";
    static private String USERNAME = "bobo";
    static private String PASSWORD = "bobo";
   // static final String DEFAULT_QUERY = "Select * FROM MENU Where Code ";
    private TablesModel tableModel;
    private TableRowSorter<TableModel> sorter;
    private JTable resultTable; 
    private String code;
    
    public Search_Menu(){
        
        code = (String) JOptionPane.showInputDialog(null,"Please Input Menu Code","Search Menu Code Record",JOptionPane.QUESTION_MESSAGE);
        if(code != null){

        try {
             String a = "Select * FROM PRODUCT Where PROD_Code ='"+code+"'";
            tableModel = new TablesModel(DATABASE_URL, USERNAME, PASSWORD, a);
 
            resultTable = new JTable(tableModel);

            Box boxNorth = Box.createHorizontalBox();
        
            add(new JScrollPane(resultTable), BorderLayout.CENTER);
            add(boxNorth, BorderLayout.NORTH);

            sorter = new TableRowSorter<>(tableModel);
            resultTable.setRowSorter(sorter);
            setTitle("Menu List");
            setSize(500, 300);
            setLocation(400, 400);
            setLocationRelativeTo(null);
            setVisible(true);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // ensure database connection is closed when user quits application
            addWindowListener(new WindowAdapter (){
                
  		@Override
                public void windowClosed(WindowEvent event) {
                tableModel.disconnectFromDatabase();
                }
            });
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            tableModel.disconnectFromDatabase();
            
        }
    }else{
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }
}
