//This class is use for delete food details and drink details from database by enter food ID and drink ID
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Menu;



import Control.MaintainProductControl;
import domain.Product;
import javax.swing.*;


public class Delete_menu extends JFrame{

    private MaintainProductControl prodControl;
    private int n;
    public Delete_menu() {
        prodControl = new MaintainProductControl();
        String code = "";
        code = JOptionPane.showInputDialog(null, 
        "Please enter the Code", 
        "Delete Menu Record", 
        JOptionPane.WARNING_MESSAGE          
        );
        Product product = prodControl.selectRecordWithCode(code);
        if(product!= null){
             n = JOptionPane.showConfirmDialog(null, "DELETE RECORD?", 
                        "RECORD DELETED", JOptionPane.OK_CANCEL_OPTION);
            if(n==JOptionPane.OK_OPTION)
                prodControl.DeleteRecord(product);
        }
        else {
                JOptionPane.showMessageDialog(null, "This Member Id NOT FOUND.", 
                        "ID NOT FOUND",JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
