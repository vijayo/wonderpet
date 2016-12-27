//This class is use for add new members from database
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


public class Add_staff extends JFrame{
    private MaintainStaffControl staffControl;
    
    private JLabel id = new JLabel("Id");
    private JLabel name = new JLabel("Name");
    private JLabel position = new JLabel("Department");
    private JLabel phno = new JLabel("Phone Number");
    private JLabel address = new JLabel("Address");
    private JLabel dob = new JLabel("Date of Birth");
    private JLabel salary = new JLabel("Salary");
    private JTextField idtf = new JTextField(20);
    private JTextField nametf = new JTextField(20);
    private JTextField positiontf = new JTextField(20);
    private JTextField phnotf = new JTextField(20);
    private JTextField addresstf = new JTextField(20);
    private JTextField dobtf = new JTextField(20);
    private JTextField salarytf = new JTextField(20);
    private JButton jbtAdd = new JButton("Add");
    private JButton jbtReset = new JButton("Reset");

    public Add_staff(){
        staffControl = new MaintainStaffControl();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();

        p2.setLayout(new GridLayout(8,2));
        p2.add(id);
        p2.add(idtf);
        p2.add(name);
        p2.add(nametf);
        p2.add(position);
        p2.add(positiontf);
        p2.add(phno);
        p2.add(phnotf);
        p2.add(address);
        p2.add(addresstf);
        p2.add(dob);
        p2.add(dobtf);
        p2.add(salary);
        p2.add(salarytf);
        
      
        p3.add(jbtAdd);
        p3.add(jbtReset);

        add(p2, BorderLayout.NORTH);
        add(p3, BorderLayout.SOUTH);
        setTitle("Staff");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    
//Add new staff details and record in database
        jbtAdd.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            Staff staff = staffControl.selectRecordID(idtf.getText());
            if (staff != null){
                JOptionPane.showMessageDialog(null, "Staff Record already exists.",
                        "Duplicate Record",JOptionPane.ERROR_MESSAGE);   
            } 
            else {
                
                double salary = Double.parseDouble(salarytf.getText());
                staff = new Staff(idtf.getText(), nametf.getText(),positiontf.getText(),phnotf.getText(),
                        addresstf.getText(),dobtf.getText(), salary);
               
                staffControl.addRecord(staff);
               
                JOptionPane.showMessageDialog(null, "New Staff Details added successfully.",
                        "Staff Details Added",JOptionPane.INFORMATION_MESSAGE);
                
                idtf.setText(null);
                nametf.setText(null);
                positiontf.setText(null);
                phnotf.setText(null);
                addresstf.setText(null);
                dobtf.setText(null);
                salarytf.setText(null);
            }
        }
      });
      
//Reset button for reset all input fields
        jbtReset.addActionListener(new ActionListener() {
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
    }
}
