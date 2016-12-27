/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class LogInErrorMsg extends JFrame{
    
    private ImageIcon logo = new ImageIcon(getClass().getResource("/images/accessdenied.jpg"));
    public void FailImage(){
        
    }
    
    public LogInErrorMsg(){
        JPanel p1 = new JPanel(new FlowLayout());
        p1.add(new JLabel(logo));
        final JDialog dialog = new JDialog();
        dialog.setTitle("Message");
        dialog.setModal(true);
        dialog.setLocation(380,220);
        dialog.setContentPane(p1);

        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.pack();

//create timer to dispose of dialog after 2 seconds
        Timer timer = new Timer(2000, new AbstractAction() {
           @Override
           public void actionPerformed(ActionEvent ae) {
               dialog.dispose();
            }
    });
//the timer should only go off once
    timer.setRepeats(false);

//start timer to close JDialog as dialog modal we must start the timer before its visible
    timer.start();
    dialog.setVisible(true);    
    }
}
