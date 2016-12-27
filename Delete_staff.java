//This class is use for delete staff from database by enter staff ID
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Staff;



import Control.MaintainStaffControl;
import domain.Staff;
import javax.swing.*;


public class Delete_staff extends JFrame{

    private MaintainStaffControl staffControl;
    private int n;
    
    public Delete_staff(){
     staffControl = new MaintainStaffControl();
        String id = "";
        id = JOptionPane.showInputDialog(null, 
        "Please enter the ID", 
        "Delete Staff Record", 
        JOptionPane.WARNING_MESSAGE          
        );
        
        Staff staff = staffControl.selectRecordID(id);
        if(staff!= null){
             n = JOptionPane.showConfirmDialog(null, "DELETE RECORD?", 
                        "RECORD DELETED", JOptionPane.OK_CANCEL_OPTION);
            if(n==JOptionPane.OK_OPTION)
                staffControl.DeleteRecord(staff);
        }
        else {
                JOptionPane.showMessageDialog(null, "This ID Not Found.", 
                        "RECORD NOT FOUND",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
