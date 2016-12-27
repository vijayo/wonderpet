//This class is use for add new members from database
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Member;



import Control.MaintainMemberControl;
import domain.Member;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Add_member extends JFrame{
 private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel(new GridLayout(5,2));
    private JPanel p3 = new JPanel();
    private MaintainMemberControl memberControl;
    private JTextField ID = new JTextField(10);
    private JTextField NAME = new JTextField(10);
    private JTextField TEL = new JTextField(10);
    private JTextField ADDRESS = new JTextField(10);
    private JTextField DOB = new JTextField(10);
    private JButton Submit = new JButton("Submit");
    private JButton Reset = new JButton("Reset");

    public Add_member(){
        memberControl = new MaintainMemberControl();     
        p2.add(new JLabel("Member ID"));
        p2.add(ID);
        p2.add(new JLabel("Member Name"));
        p2.add(NAME);
        p2.add(new JLabel("Phone number"));
        p2.add(TEL);
        p2.add(new JLabel("Address"));
        p2.add(ADDRESS);
        p2.add(new JLabel("Date Of Birth"));
        p2.add(DOB);
        
        p3.add(Submit);
        p3.add(Reset);
        add(p1, BorderLayout.NORTH);
        add(p2);
        add(p3, BorderLayout.SOUTH);
        
//Submit new member details and record in database
        Submit.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           
            Member member = memberControl.selectRecord(ID.getText());
            if (member != null) {
               
                JOptionPane.showMessageDialog(null, "This Id member already exists.",
                        "Duplicate Record",JOptionPane.ERROR_MESSAGE);
                
            } 
            else {

                member = new Member(ID.getText(), NAME.getText(), TEL.getText(),ADDRESS.getText(),
                        DOB.getText());
               
                memberControl.addRecord(member);
               
                JOptionPane.showMessageDialog(null, "New Member added successfully.",
                        "New Member Added",JOptionPane.INFORMATION_MESSAGE);
                
                ID.setText(null);
                NAME.setText(null);
                TEL.setText(null);
                ADDRESS.setText(null);
                DOB.setText(null);
            }
        }
        });
        
//Reset button for reset all input fields
        Reset.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ID.setText(null);
            NAME.setText(null);
            TEL.setText(null);
            ADDRESS.setText(null);
            DOB.setText(null);
        }
        });
        
        setTitle("Add Member");
        setSize(500, 300);
        setLocation(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }  
}
