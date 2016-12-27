//This class is use for edit and update member details in database
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


public class Update_member extends JFrame{

    private MaintainMemberControl memberControl;
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel(new GridLayout(5,2));
    private JPanel p3 = new JPanel();
    
    private JTextField ID = new JTextField(10);
    private JTextField NAME = new JTextField(10);
    private JTextField TEL = new JTextField(10);
    private JTextField ADDRESS = new JTextField(10);
    private JTextField DOB = new JTextField(10);

    private JButton Submit = new JButton("Submit");
    private JButton Reset = new JButton("Reset");
    private String code;
    
    public Update_member(){
        
        memberControl = new MaintainMemberControl();
        Member member;
        code = (String) JOptionPane.showInputDialog(null, 
        "Please Input Member Id", 
        "Update Menu Record", 
        JOptionPane.QUESTION_MESSAGE          
        );
      
        member = memberControl.selectRecord(code);
        if(member!=null){
            
            ID.setText(member.getM_ID());
            NAME.setText(member.getM_Name());
            TEL.setText(member.getM_Tel());
            ADDRESS.setText(member.getM_Address());
            DOB.setText(member.getM_DOB());
            
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
            memberControl.UpdateRecord(member);
            p3.add(Submit);
            p3.add(Reset);
      
            add(p1, BorderLayout.NORTH);
            add(p2);
            add(p3, BorderLayout.SOUTH);
        
//Submit latest member details
            Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           
                if(member!=null){
                    member.setM_ID(ID.getText());
                    member.setM_Name(NAME.getText());
                    member.setM_Tel(TEL.getText());
                    member.setM_Address(ADDRESS.getText());
                    member.setM_DOB(DOB.getText());

                memberControl.UpdateRecord(member);
                    JOptionPane.showMessageDialog(null, "This Member Details updated successfully.",
                            "Member Updated",JOptionPane.INFORMATION_MESSAGE);
                    ID.setText(null);
                    NAME.setText(null);
                    TEL.setText(null);
                    ADDRESS.setText(null);
                    DOB.setText(null);
                }
                else{
                 JOptionPane.showMessageDialog(null, "This Member Id Not Found.",
                    "MEMBER ID NOT FOUND",JOptionPane.ERROR_MESSAGE);
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
            setTitle("Update Member Details");
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
