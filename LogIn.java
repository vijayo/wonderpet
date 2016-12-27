/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;



import DA.UserDA;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class LogIn extends JFrame{
    private JTextField jtfUser = new JTextField(15);
    private JPasswordField passwordField = new JPasswordField(15);
    private JLabel input1 = new JLabel("User name: ");
    private JLabel input2 = new JLabel("Password: ");
    private String username="chiang";
    private String password="123456";
    private JButton Login = new JButton("Login");
    private JButton Reset = new JButton("Reset");
    private UserDA usDA;
    
    public LogIn(){
        JLabel background=new JLabel (new ImageIcon(getClass().getResource("/images/bobo.png")));
        input1.setFont(new Font("Magneto",Font.BOLD,33));
        input2.setFont(new Font("Magneto",Font.BOLD,33));
        Login.setFont(new Font("Magneto", Font.BOLD,20));
        Reset.setFont(new Font("Magneto", Font.BOLD,20));
        jtfUser.setOpaque(false);
        jtfUser.setFont(new Font("Magneto", Font.BOLD, 30));
        jtfUser.setForeground(Color.WHITE);
        passwordField.setFont(new Font("Magneto", Font.BOLD, 35));
        passwordField.setOpaque(false);
        passwordField.setForeground(Color.WHITE);
        setLayout(new BorderLayout(5,10));
        input1.setForeground(Color.WHITE);
        input2.setForeground(Color.WHITE);
        JPanel p1 = new JPanel(new GridLayout(3,1));
        p1.add(new JLabel());
        p1.setOpaque(false);
      
        JPanel p2 = new JPanel(new GridLayout());
        p2.add(new JLabel());
        p2.setOpaque(false);
        p1.add(p2);
        JPanel p3 = new JPanel(new GridLayout(1,3));
        p3.add(new JLabel());
        
        JPanel p4 = new JPanel(new GridLayout(3,2,15,10));
        p4.add(input1);
        p4.add(jtfUser);
        p4.add(input2);
        p4.add(passwordField);
        JPanel p5 = new JPanel(new GridLayout(1,2));
        p5.add(new JLabel());
        p5.add(Login);
        p5.setOpaque(false);
        p4.add(p5);
        JPanel p6 = new JPanel(new GridLayout(1,2));
        p6.add(Reset);
        p6.add(new JLabel());
        p6.setOpaque(false);
        p4.add(p6);
        p4.setOpaque(false);
        p3.add(p4);
        p3.add(new JLabel());
        p3.setOpaque(false);
        p1.add(p3);
        background.setLayout(new GridLayout());
        background.add(p1);
        add(background);
        
        Login.addActionListener(new verify());
        Reset.addActionListener(new reset());
        
//Login by using enter
        passwordField.addActionListener(new verify1());
        
        setTitle("Login");
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);
    }
    
//Login function
    private class verify implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            usDA = new UserDA();
            String user = jtfUser.getText();
            String pass = passwordField.getText();
            int i = usDA.verifyUser(user, pass);
            if(i == 1){
                new MainMenu(user);
                dispose();
            }else{
                new LogInErrorMsg();
            }
        }
    }
        
// ActionListener for Login by using enter
    private class verify1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            passwordField.requestFocusInWindow();
            usDA = new UserDA();
            String user = jtfUser.getText();
            String pass = passwordField.getText();
            int i = usDA.verifyUser(user, pass);
            if(i == 1){
                dispose();
                new MainMenu(user);
            }else{
                new LogInErrorMsg();
            }
        }
    }
        
//Reset text field and password field to null
    private class reset implements ActionListener {
       public void actionPerformed(ActionEvent e) {
          jtfUser.setText("");
          passwordField.setText("");
        }
    }
    
    public static void main(String[] args) {
        new LogIn();
    }
}
