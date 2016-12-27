//This class is use for edit and update staff details in database
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Staff;



import Control.MaintainStaffControl;
import domain.Staff;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Update_staff extends JFrame {   
    
    private MaintainStaffControl staffControl;
    private JPanel p2 = new JPanel(new GridLayout(8,2));
    private JPanel p3 = new JPanel();
    
    private JTextField idtf = new JTextField(20);
    private JTextField nametf = new JTextField(20);
    private JTextField positiontf = new JTextField(20);
    private JTextField phnotf = new JTextField(20);
    private JTextField addresstf = new JTextField(20);
    private JTextField dobtf = new JTextField(20);
    private JTextField salarytf = new JTextField(20);

    private JButton Submit = new JButton("Submit");
    private JButton Reset = new JButton("Reset");
    private String id;
    
    public Update_staff(){
        
        staffControl = new MaintainStaffControl();
        Staff staff;
        id = (String) JOptionPane.showInputDialog(null, 
        "Please Input Staff ID ", 
        "Update Staff Record", 
        JOptionPane.QUESTION_MESSAGE          
        );
      
        staff = staffControl.selectRecordID(id);
        if(staff!=null){
            
            idtf.setText(staff.getS_ID());
            nametf.setText(staff.getS_Name());
            positiontf.setText(staff.getS_Department());
            phnotf.setText(staff.getS_Tel());
            addresstf.setText(staff.getS_Address());
            dobtf.setText(staff.getS_DOB());
            salarytf.setText(String.format("%.2f", staff.getS_Salary()));
            
            p2.add(new JLabel("Id"));
            p2.add(idtf);
            p2.add(new JLabel("Name"));
            p2.add(nametf);
            p2.add(new JLabel("Department"));
            p2.add(positiontf);
            p2.add(new JLabel("Phone Number"));
            p2.add(phnotf);
            p2.add(new JLabel("Address"));
            p2.add(addresstf);
            p2.add(new JLabel("Date of Birth"));
            p2.add(dobtf);
            p2.add(new JLabel("Salary"));
            p2.add(salarytf);

            p3.add(Submit);
            p3.add(Reset);
      
            add(p2);
            add(p3, BorderLayout.SOUTH);
        
//Submit latest staff details
        Submit.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
             if(staff!=null){
            
                staff.setS_ID(idtf.getText());
                staff.setS_Name(nametf.getText());
                staff.setS_Department(positiontf.getText());
                staff.setS_Tel(phnotf.getText());
                staff.setS_Address(addresstf.getText());
                staff.setS_DOB(dobtf.getText());
                staff.setS_Salary(Double.valueOf(salarytf.getText()));
                
                idtf.setText(null);
                nametf.setText(null);
                positiontf.setText(null);
                phnotf.setText(null);
                addresstf.setText(null);
                dobtf.setText(null);
                salarytf.setText(null);
                
               staffControl.UpdateRecord(staff);
                JOptionPane.showMessageDialog(null, "This Staff Details updated successfully.",
                        "Staff Updated",JOptionPane.INFORMATION_MESSAGE);
             }else{
             JOptionPane.showMessageDialog(null, "This Staff ID Not Found.",
                    "RECORD NOT FOUND",JOptionPane.ERROR_MESSAGE);
             } 
        }
        });

//Reset button for reset all input fields
        Reset.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                idtf.setText(null);
                nametf.setText(null);
                positiontf.setText(null);
                phnotf.setText(null);
                addresstf.setText(null);
                dobtf.setText(null);
                salarytf.setText(null);
        }
    });
        
        setTitle("Update Staff");
        setSize(500, 300);
        setLocation(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        }
        else{
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }
}
