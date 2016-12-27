//This class is use for edit and update drink details and food details in database
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


public class Update_menu extends JFrame {   
    
    private MaintainProductControl prodControl;
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel(new GridLayout(4,2));
    private JPanel p3 = new JPanel();
    
    private JTextField ID = new JTextField(10);
    private JTextField NAME = new JTextField(10);
    private JTextField TYPE = new JTextField(10);
    private JTextField PRICE = new JTextField(10);

    private JButton Submit = new JButton("Submit");
    private JButton Reset = new JButton("Reset");
    private String code;
    
    public Update_menu(){
        
        prodControl = new MaintainProductControl();
        Product product;
        code = (String) JOptionPane.showInputDialog(null, 
        "Please Input Menu Code", 
        "Update Menu Record", 
        JOptionPane.QUESTION_MESSAGE          
        );
      
        product = prodControl.selectRecordWithCode(code);
        if(product!=null){
            
            ID.setText(product.getPro_Code());
            NAME.setText(product.getPro_Name());
            PRICE.setText(String.format("%.2f", product.getPro_Price()));
            TYPE.setText(product.getPro_Type());
            TYPE.setEditable(false);
            p2.add(new JLabel("ID Code"));
            p2.add(ID);
            p2.add(new JLabel("Food Name"));
            p2.add(NAME);
            p2.add(new JLabel("Price"));
            p2.add(PRICE);
            p2.add(new JLabel("Type"));
            p2.add(TYPE);
            prodControl.UpdateRecord(product);
            p3.add(Submit);
            p3.add(Reset);
      
            add(p1, BorderLayout.NORTH);
            add(p2);
            add(p3, BorderLayout.SOUTH);
        
//Submit latest drink details and food details
        Submit.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           
            if(product!=null){
                product.setPro_Code(ID.getText());
                product.setPro_Name(NAME.getText());
                product.setPro_Price(Double.valueOf(PRICE.getText()));
                product.setPro_Type(TYPE.getText());
            
                
                double price = Double.parseDouble(PRICE.getText());
            if(price <=-1){
                     JOptionPane.showMessageDialog(null, "Price ErrorInput",
                        "Food Menu Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                prodControl.UpdateRecord(product);
                JOptionPane.showMessageDialog(null, "New Food Menu updated successfully.",
                           "Food Menu Update",JOptionPane.INFORMATION_MESSAGE);
            }
                
                ID.setText(null);
                NAME.setText(null);
                PRICE.setText(null);
                TYPE.setText(null);
            }
            else{
                 JOptionPane.showMessageDialog(null, "This Menu Code Not Found.",
                    "RECORD NOT FOUND",JOptionPane.ERROR_MESSAGE);
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
        
        setTitle("Update Menu");
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
