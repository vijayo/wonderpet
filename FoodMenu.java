//This class is the main menu of add, edit, delete, view, and search food.
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Menu;



import UI.MainMenu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class FoodMenu extends JFrame{


    private JButton add = new JButton("Add");
    private JButton update = new JButton("Update");
    private JButton delete = new JButton("Delete");
    private JButton Read = new JButton("View");
    private JButton search = new JButton("Search");
    private JLabel L1 = new  JLabel("Welcome to BOBO Restaurant.");
    private JLabel background = new JLabel (new ImageIcon(getClass().getResource("/images/bobo.png")));
    private ImageIcon Exit = new ImageIcon(getClass().getResource("/images/Exit.png"));
    private JButton m_menu = new JButton(Exit);

    
    public FoodMenu(){
       
        L1.setFont(new Font("Magneto", Font.BOLD + Font.ITALIC,80));
        L1.setForeground(Color.WHITE);
        add.setFont(new Font("Magneto",Font.BOLD  + Font.ITALIC,35));
        add.setForeground(Color.DARK_GRAY);
        update.setFont(new Font("Magneto",Font.BOLD  + Font.ITALIC,35));
        update.setForeground(Color.DARK_GRAY);
        delete.setFont(new Font("Magneto",Font.BOLD  + Font.ITALIC,35));
        delete.setForeground(Color.DARK_GRAY);
        Read.setFont(new Font("Magneto",Font.BOLD  + Font.ITALIC,35));
        Read.setForeground(Color.DARK_GRAY);
        search.setFont(new Font("Magneto",Font.BOLD  + Font.ITALIC,35));
        search.setForeground(Color.DARK_GRAY);
        JPanel p1 = new JPanel(new GridLayout(3,1,0,79));
        p1.add(L1);
        p1.setOpaque(false);
        
        JPanel p2 = new JPanel(new GridLayout(1,5,30,25));
        p2.add(add);
        p2.add(update);
        p2.add(Read);
        p2.add(delete);
        p2.add(search);
        p2.setOpaque(false);
        p1.add(p2, BorderLayout.CENTER);
        
        JPanel p3 = new JPanel(new GridLayout(1,4,0,25));
        p3.add(new JLabel());
        p3.add(new JLabel());
        p3.add(new JLabel());
        p3.add(m_menu,BorderLayout.SOUTH);
        p3.setOpaque(false);
        p1.add(p3,BorderLayout.SOUTH);
        
        background.setLayout(new FlowLayout());
        background.add(p1);
        add(background);
        
        add.addActionListener(new addnew());
        update.addActionListener(new updatemenu());
        delete.addActionListener(new deletemenu());
        search.addActionListener(new searchmenu());
        
//To view all food details 
        Read.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                new View_Food_Menu();
            }
        });
        
        m_menu.addActionListener(new main());
        setTitle("FoodMenu");
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        
    }
    
//Add new food details to database
    private class addnew implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int food =1 ;
             new Add_menu(food); 
        }
    }
    
//Edit and update food's records
    private class updatemenu implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        new Update_menu();
        }
    }
    
//Delete food's records 
    private class deletemenu implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Delete_menu();
        }
    }

//Back to main menu
    private class main implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose(); 
            new MainMenu();
        }
    }
    
//Search for specific drink to view the food details
    private class searchmenu implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Search_Menu();
        }
    }  
}
