//Instructions.java
//Holds Swing components for instructions page

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class Instructions implements ActionListener{
    //Create JFrame object
    JFrame frame = new JFrame();
    
    //Create and name back button
    JButton btnBack = new JButton("BACK");
    
    //Create text area and display all instructions
    JTextArea txaInfo = new JTextArea("   Ancient dragons have awoken and are attacking the Earth!\n"
            + "   Only the strongest wizards are able to stop them.\n"
            + "   In order to stay alive, you have to dodge the invading dragons by moving left and right.\n"
            + "   Press W to move up.\n"
            + "   Press A to move left.\n"
            + "   Press S to move down.\n"
            + "   Press D to move right.\n"
            + "   Good luck, valiant hero!\n"
            + "   Your adventure awaits.");
    
    //Create and name instructions label
    JLabel lblInfoTitle = new JLabel("Instructions");
    //Create font
    Font font = new Font("Serif", Font.BOLD, 48);
    
    Instructions(){
        //Close application when X is clicked
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create JPanel with Border Layout manager
        JPanel panel = new JPanel(new BorderLayout());
        //Create JPanel with Flow Layout manager
        JPanel panel2 = new JPanel();
        
        //Align button and label
        lblInfoTitle.setHorizontalAlignment(JLabel.CENTER);
       
        //Set title font
        lblInfoTitle.setFont(font);
        
        //Add back button to panel2
        panel2.add(btnBack);
        
        //Add panel2 and label to panel
        panel.add(txaInfo, BorderLayout.CENTER);
        panel.add(panel2, BorderLayout.SOUTH);
        panel.add(lblInfoTitle, BorderLayout.NORTH);
        
        //Add action listener to back button
        btnBack.addActionListener(this);

        //Show the contents
        frame.setContentPane(panel);
        //Sets the frame to be visible
        frame.setVisible (true);
        //Make frame not resizable
        frame.setResizable(false);
        //Set frame size
        frame.setSize(700, 500);
    }
    
    @Override
    //Action performed method
    public void actionPerformed(ActionEvent e){
        //If back button is clicked
        if (e.getSource () == btnBack){
            //Open main screen
            MainScreen mainScreen = new MainScreen();
            
            //Close frame
            frame.dispose();
        }
    }
}
