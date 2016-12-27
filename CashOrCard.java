/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.StartBusiness;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import domain.Payment;
import java.util.ArrayList;


public class CashOrCard extends JFrame{
    private ImageIcon Cash = new ImageIcon(getClass().getResource("/images/cash.jpg"));
    private ImageIcon Card = new ImageIcon(getClass().getResource("/images/card.jpg"));
    private JButton CashButton = new JButton(Cash);
    private JButton CardButton = new JButton(Card);
    private double total;
    private int quan;
    private double gst;
    private double memdis;
    private double finaltotal;
    private Payment payment;
    private ArrayList<domain.Product> tmpproductArray;
            
    public CashOrCard(double total,int quan,double gst,double memdis,double finaltotal,Payment payment,ArrayList<domain.Product> tmpproductArray){
        this.total=total;
        this.quan=quan;
        this.gst=gst;
        this.memdis=memdis;
        this.finaltotal=finaltotal;
        this.payment=payment;
        this.tmpproductArray=tmpproductArray;
        
        setLayout(new GridLayout(1,2));
        add(CashButton);
        add(CardButton);
    
        setTitle("CASH OR CARD");
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 300);
        setLocation(400, 400);
    
    
        CashButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                String amount = JOptionPane.showInputDialog("Enter payment amount");
               double payamount = Double.parseDouble(amount);
               while(payamount<payment.getP_Amount()){
                    amount = JOptionPane.showInputDialog("Insufficient amount,Reenter amount");
                payamount = Double.parseDouble(amount);
               
               }
               
                new SeatsArea(payment.getUserID());
                new Print_receipt(total,quan,gst,memdis,finaltotal,payment,tmpproductArray,payamount);
                dispose();
                }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
    CardButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                String amount=JOptionPane.showInputDialog(null,"Enter Card Number","Enter Card Number",JOptionPane.QUESTION_MESSAGE);
                int card = Integer.parseInt(amount);
                new SeatsArea(payment.getUserID());
                new Print_receipt_card(total,quan,gst,memdis,finaltotal,payment,tmpproductArray,card);
                dispose();
               }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });

    }
    
}
