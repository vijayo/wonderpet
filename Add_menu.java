//This class is use for add new food and drink
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Menu;



import Control.MaintainProductControl;
import domain.Product;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Add_menu extends JFrame {   
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel(new GridLayout(4,2));
    private JPanel p3 = new JPanel();
    private MaintainProductControl prodControl;
    private JTextField ID = new JTextField(10);
    private JTextField NAME = new JTextField(10);
    private JTextField TYPE = new JTextField(10);
    private JTextField PRICE = new JTextField(10);
    
    private JButton Submit = new JButton("Submit");
    private JButton Reset = new JButton("Reset");

    public Add_menu(int menu){
        prodControl = new MaintainProductControl();
        //p1.add(new JLabel("New Drink"));
        if(menu==1){
            TYPE = new JTextField("Snack");
        }
        else{
            TYPE = new JTextField("Drink");
        }
        TYPE.setEditable(false);
        p2.add(new JLabel("ID Code"));
        p2.add(ID);
        p2.add(new JLabel("Food Name"));
        p2.add(NAME);
        p2.add(new JLabel("Price"));
        p2.add(PRICE);
        p2.add(new JLabel("Type"));
        p2.add(TYPE);
        
        p3.add(Submit);
        p3.add(Reset);
        add(p1, BorderLayout.NORTH);
        add(p2);
        add(p3, BorderLayout.SOUTH);
        
//Submit new food details and drink details in database
        Submit.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           
            Product product = prodControl.selectRecordWithCode(ID.getText());
            if (product != null) {
               
                JOptionPane.showMessageDialog(null, "Food Menu Code already exists.",
                        "Duplicate Record",JOptionPane.ERROR_MESSAGE);
            } 
            else {
                
                double price = Double.parseDouble(PRICE.getText());
                product = new Product(ID.getText(), NAME.getText(), 
                         TYPE.getText(), price);
               
                
                if(price <=-1){
                     JOptionPane.showMessageDialog(null, "Price ErrorInput",
                        "Food Menu Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                prodControl.addRecord(product);
                JOptionPane.showMessageDialog(null, "New Food Menu added successfully.",
                        "Food Menu Added",JOptionPane.INFORMATION_MESSAGE);
                
                ID.setText(null);
                NAME.setText(null);
                PRICE.setText(null);
                TYPE.setText(null);
                }
            }

        }
        });
       
//Reset button for reset all input fields
        Reset.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                ID.setText("");
                NAME.setText("");
                TYPE.setText("");
                PRICE.setText("");
        }
    });
        
        setTitle("Add Menu");
        setSize(500, 300);
        setLocation(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        
    }
}
