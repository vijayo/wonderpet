//This class is use for delete member from database by enter member ID
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Member;



import Control.MaintainMemberControl;
import domain.Member;
import javax.swing.*;


public class Delete_member extends JFrame{

    private MaintainMemberControl memberControl;
    private int n;
    
    public Delete_member() {
        memberControl = new MaintainMemberControl();
        String code = "";
        code = JOptionPane.showInputDialog(null, 
        "Enter Member Id", 
        "Delete Member Record", 
        JOptionPane.WARNING_MESSAGE          
        );
        Member member = memberControl.selectRecord(code);
        if(member!= null){
             n = JOptionPane.showConfirmDialog(null, "DELETE RECORD?", 
                        "RECORD DELETED", JOptionPane.OK_CANCEL_OPTION);
            if(n==JOptionPane.OK_OPTION)
                memberControl.DeleteRecord(member);
        }
        else {
            JOptionPane.showMessageDialog(null, "This Member Id NOT FOUND.", 
                    "ID NOT FOUND",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
