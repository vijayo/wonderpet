// This class is use for view members records in database
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Member;



import DA.TablesModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.TableRowSorter;


public class View_Member extends JFrame{

    static private String DATABASE_URL = "jdbc:derby://localhost:1527/GUIAssignment";
    static private String USERNAME = "bobo";
    static private String PASSWORD = "bobo";
    static final String Default_QUERY = "SELECT * FROM Member";
    private TablesModel tableModel;
    private TableRowSorter<TablesModel> sorter;
    private JTable resultTable; 
    
    public View_Member() {
        super("Member Result");

        try {
            tableModel = new TablesModel(DATABASE_URL, USERNAME, PASSWORD, Default_QUERY);
 
            resultTable = new JTable(tableModel);

            Box boxNorth = Box.createHorizontalBox();
        
            add(new JScrollPane(resultTable), BorderLayout.CENTER);
            add(boxNorth, BorderLayout.NORTH);

            sorter = new TableRowSorter<TablesModel>(tableModel);
            resultTable.setRowSorter(sorter);
            setTitle("Member List");
            setSize(1500, 300);
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

    private class WindowCloseListener extends WindowAdapter {

        @Override
        public void windowClosed(WindowEvent event) {
            tableModel.disconnectFromDatabase();
            System.exit(0);
        }
    }
}
