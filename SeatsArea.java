/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.StartBusiness;



import DA.PaymentDA;
import domain.Payment;
import java.awt.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.*;
import java.util.*;
import UI.MainMenu;
import UI.LogIn;


public class SeatsArea extends JFrame {
    private JMenuBar menubar = new JMenuBar();
    private JMenu File = new JMenu("File");
    private JMenuItem BMainMenu = new JMenuItem("Back to main menu");
    private JMenuItem LogOut = new JMenuItem("LogOut");
    private JButton T1 = new JButton("T1");
    private JButton T2 = new JButton("T2");
    private JButton T3 = new JButton("T3");
    private JButton T4 = new JButton("T4");
    private JButton T5 = new JButton("T5");
    private JButton T6 = new JButton("T6");
    private JButton T7 = new JButton("T7");
    private JButton T8 = new JButton("T8");
    private JButton T9 = new JButton("T9");
    private JButton T10 = new JButton("T10");
    private JButton T11 = new JButton("T11");
    private String user;
    private PaymentDA _payment;
    private String date;
    private ArrayList<domain.Payment> paymentArray;
    
    
    public SeatsArea(String user){
        this.user=user;
         date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        _payment =new PaymentDA();
        paymentArray=_payment.getPaymentArray();
    JLabel background=new JLabel (new ImageIcon(getClass().getResource("/images/FloorPlan.png")));
    
    JPanel p1 = new JPanel(null);
    p1.setOpaque(false);
    
    File.add(BMainMenu);
    File.add(LogOut);
    menubar.add(File);
    
    T1.setBounds(270,305,48,48);
    T2.setBounds(460,325,48,48);
    T3.setBounds(770,325,48,48);
    T4.setBounds(1083,300,48,48);
    T5.setBounds(290,462,48,48);
    T6.setBounds(457,460,48,48);
    T7.setBounds(876,470,48,48);
    T8.setBounds(223,618,48,48);
    T9.setBounds(379,618,48,48);
    T10.setBounds(531,615,55,55);
    T11.setBounds(1003,607,55,55);

    p1.add(T1);
    p1.add(T2);
    p1.add(T3);
    p1.add(T4);
    p1.add(T5);
    p1.add(T6);
    p1.add(T7);
    p1.add(T8);
    p1.add(T9);
    p1.add(T10);
    p1.add(T11);
    
    
     T1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               _payment =new PaymentDA();
                paymentArray=_payment.getPaymentArray();
                String payment_no = "PY0"+String.valueOf(paymentArray.size()+1); 
                Payment payment = new Payment(payment_no,date,0,user,"","table1");
                  new StartBA(payment);
                  dispose();
            }
        });
     
        T2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               _payment =new PaymentDA();
                paymentArray=_payment.getPaymentArray();
                String payment_no = "PY0"+String.valueOf(paymentArray.size()+1); 
                Payment payment = new Payment(payment_no,date,0,user,"","table2");
                  new StartBA(payment);
                  dispose();
            }
        });
        
        T3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               _payment =new PaymentDA();
                paymentArray=_payment.getPaymentArray();
                String payment_no = "PY0"+String.valueOf(paymentArray.size()+1); 
                Payment payment = new Payment(payment_no,date,0,user,"","table3");
                  new StartBA(payment);
                  dispose();
            }
        });
        
        T4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               _payment =new PaymentDA();
                paymentArray=_payment.getPaymentArray();
                String payment_no = "PY0"+String.valueOf(paymentArray.size()+1); 
                Payment payment = new Payment(payment_no,date,0,user,"","table4");
                  new StartBA(payment);
                  dispose();
            }
        });
        
        T5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               _payment =new PaymentDA();
                paymentArray=_payment.getPaymentArray();
                String payment_no = "PY0"+String.valueOf(paymentArray.size()+1); 
                Payment payment = new Payment(payment_no,date,0,user,"","table5");
                  new StartBA(payment);
                  dispose();
            }
        });
        
       T6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               _payment =new PaymentDA();
                paymentArray=_payment.getPaymentArray();
                String payment_no = "PY0"+String.valueOf(paymentArray.size()+1); 
                Payment payment = new Payment(payment_no,date,0,user,"","table6");
                  new StartBA(payment);
                  dispose();
            }
        });
       
        T7.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               _payment =new PaymentDA();
                paymentArray=_payment.getPaymentArray();
                String payment_no = "PY0"+String.valueOf(paymentArray.size()+1); 
                Payment payment = new Payment(payment_no,date,0,user,"","table7");
                  new StartBA(payment);
                  dispose();
            }
        });
        
        T8.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               _payment =new PaymentDA();
                paymentArray=_payment.getPaymentArray();
                String payment_no = "PY0"+String.valueOf(paymentArray.size()+1); 
                Payment payment = new Payment(payment_no,date,0,user,"","table8");
                  new StartBA(payment);
                  dispose();
            }
        });
        
        T9.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               _payment =new PaymentDA();
                paymentArray=_payment.getPaymentArray();
                String payment_no = "PY0"+String.valueOf(paymentArray.size()+1); 
                Payment payment = new Payment(payment_no,date,0,user,"","table9");
                  new StartBA(payment);
                  dispose();
            }
        });
        
        T10.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               _payment =new PaymentDA();
                paymentArray=_payment.getPaymentArray();
                String payment_no = "PY0"+String.valueOf(paymentArray.size()+1); 
                Payment payment = new Payment(payment_no,date,0,user,"","table10");
                  new StartBA(payment);
                  dispose();
            }
        });
        
        T11.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               _payment =new PaymentDA();
                paymentArray=_payment.getPaymentArray();
                String payment_no = "PY0"+String.valueOf(paymentArray.size()+1); 
                Payment payment = new Payment(payment_no,date,0,user,"","table11");
                  new StartBA(payment);
                  dispose();
            }
        });
        
    background.setLayout(new GridLayout());
    background.add(p1);
    add(background);

    BMainMenu.addActionListener(new BMM());
    LogOut.addActionListener(new LO());
    
    
        setJMenuBar(menubar);
        setTitle("");
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);
}
    
    private class BMM implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                new MainMenu();
                dispose();
            }
        }
    
    private class LO implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                new LogIn();
                dispose();
            }
        }

}
