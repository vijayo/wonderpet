/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;



import UI.StartBusiness.SeatsArea;
import UI.Member.MemberMenu;
import UI.Staff.Staff;
import UI.Menu.DrinkMenu;
import UI.Menu.FoodMenu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MainMenu extends JFrame{

    private JButton Start_B = new JButton("Start Business");
    private JButton Food_M = new JButton("Food Menu");
    private JButton Staff_D = new JButton("Staff Details");
    private JButton membership = new JButton("Membership");
    private JLabel L1 = new  JLabel("Welcome to BOBO Restaurant.");
    private JLabel background = new JLabel (new ImageIcon(getClass().getResource("/images/bobo.png")));
    private ImageIcon Exit = new ImageIcon(getClass().getResource("/images/Exit.png"));
    private JButton logoff = new JButton(Exit);
    private String[] F_D = {"Food Menu", "Drink Menu"};
    private JComboBox FDname = new JComboBox(F_D);
    private String user;
    
    public MainMenu(){
        new MainMenu(user);
    }
    
    public MainMenu(String user){
        this.user=user;
        L1.setFont(new Font("Magneto", Font.BOLD + Font.ITALIC,80));
        L1.setForeground(Color.WHITE);
        Start_B.setFont(new Font("Magneto",Font.BOLD  + Font.ITALIC,35));
        Start_B.setForeground(Color.DARK_GRAY);
        Food_M.setFont(new Font("Magneto",Font.BOLD  + Font.ITALIC,35));
        Food_M.setForeground(Color.DARK_GRAY);
        Staff_D.setFont(new Font("Magneto",Font.BOLD  + Font.ITALIC,35));
        Staff_D.setForeground(Color.DARK_GRAY);
        membership.setFont(new Font("Magneto",Font.BOLD  + Font.ITALIC,35));
        membership.setForeground(Color.DARK_GRAY);
        JPanel p1 = new JPanel(new GridLayout(3,1,0,79));
        p1.add(L1);
        p1.setOpaque(false);
        
        JPanel p2 = new JPanel(new GridLayout(1,4,30,25));
        p2.add(Start_B);
        p2.add(Food_M);
        p2.add(Staff_D);
        p2.add(membership);
        p2.setOpaque(false);
        p1.add(p2, BorderLayout.CENTER);
        
        JPanel p3 = new JPanel(new GridLayout(1,4,0,25));
        p3.add(new JLabel());
        p3.add(new JLabel());
        p3.add(new JLabel());
        p3.add(logoff,BorderLayout.SOUTH);
        p3.setOpaque(false);
        p1.add(p3,BorderLayout.SOUTH);
        
        background.setLayout(new FlowLayout());
        background.add(p1);
        add(background);
        
//show tip while mouse pointing specific button
        Food_M.setToolTipText("To select type of menu such as drink menu or food menu"); 
        Staff_D.setToolTipText("To manage staff of bobo restaurant"); 
        membership.setToolTipText("To manage membership of bobo restaurant"); 
        logoff.setToolTipText("Log out");
        
        Start_B.addActionListener(new StartBusiness());
        Food_M.addActionListener(new Food_Menu());
        Staff_D.addActionListener(new StaffDetails());
        membership.addActionListener(new member());
        logoff.addActionListener(new LogOff());
        
        setTitle("MainMenu");
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        
    }
    
//ActionListener for starting business
    private class StartBusiness implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new SeatsArea(user);
        }
    }
    
//ActionListener for select food menu and drink menu
    private class Food_Menu implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String f_d = (String)JOptionPane.showInputDialog(null,"Please select either one.", 
                    "Menu", JOptionPane.QUESTION_MESSAGE, null, F_D,F_D[0]);
            if(f_d.equals("Food Menu")){
                dispose();
                new FoodMenu();
            }
            if(f_d.equals("Drink Menu")){
                dispose();
                new DrinkMenu();
            }
            
        }
    }
    
//ActionListener for edit staff details
    private class StaffDetails implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new Staff();
        }
    }
    
//ActionListener for edit member details
    private class member implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new MemberMenu();
        }
    }
    
//ActionListener for log out account and back to log in page
    private class LogOff implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose(); 
            new LogIn();
        }
    }  
}
