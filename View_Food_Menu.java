// This class is use for view food's records in database
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


public class View_Food_Menu extends JFrame {

    static private String DATABASE_URL = "jdbc:derby://localhost:1527/GUIAssignment";
    static private String USERNAME = "bobo";
    static private String PASSWORD = "bobo";
    static final String FOOD_QUERY = "SELECT * FROM Product Where PROD_TYPE = 'Snack'";
    private TablesModel tableModel;
    private TableRowSorter<TablesModel> sorter;
    private JTable resultTable;
    
    public View_Food_Menu() {
        super("Menu Result");

        try {
            tableModel = new TablesModel(DATABASE_URL, USERNAME, PASSWORD, FOOD_QUERY);
 
            resultTable = new JTable(tableModel);

            Box boxNorth = Box.createHorizontalBox();
        
            add(new JScrollPane(resultTable), BorderLayout.CENTER);
            add(boxNorth, BorderLayout.NORTH);

            sorter = new TableRowSorter<TablesModel>(tableModel);
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
            System.exit(1);
        }
    }

}
