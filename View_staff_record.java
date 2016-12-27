// This class is use for view staff records in database
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Staff;



import DA.TablesModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;


public class View_staff_record extends JFrame {

    static final String DATABASE_URL = "jdbc:derby://localhost:1527/GuiAssignment";
    static final String USERNAME = "bobo";
    static final String PASSWORD = "bobo";
    static final String STAFF_QUERY = "SELECT * FROM STAFF";
    private TablesModel tableModel;
    private TableRowSorter<TableModel> sorter;
    private JTable resultTable; 
    private JTextField search = new JTextField();
    
    public View_staff_record() {
        super("Staff Result");

        try {
            tableModel = new TablesModel(DATABASE_URL, USERNAME, PASSWORD, STAFF_QUERY);
            search = new JTextField();
            resultTable = new JTable(tableModel);
                    JScrollPane scrollPane = new JScrollPane(search,
                    ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            Box boxNorth = Box.createHorizontalBox();
        
            add(new JScrollPane(resultTable), BorderLayout.CENTER);
            add(boxNorth, BorderLayout.NORTH);

            sorter = new TableRowSorter<TableModel>(tableModel);
            resultTable.setRowSorter(sorter);
            
            setTitle("Staff List");
            setSize(1500, 300);
            setLocation(400, 400);
            setLocationRelativeTo(null);
            setVisible(true);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
//Search staff by using staff ID
            search.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            
            String b = "Select STAFF_NAME, SF_POSITION, STAFF_TEL, SF_ADRS, SF_DOB, SF_SALARY From Student Where SF_ID = '"+search.getText()+"'";
            try {
                tableModel.setQuery(b);
                System.out.println("***TRACE: in SubmitButtonListener");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);

            }
        }
    });
            
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
