//MainScreen.java
//Holds Swing components for main screen

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class MainScreen implements ActionListener{
    
    //Create JFrame object
    JFrame frame = new JFrame();
    
    //Create and name buttons on MainScreen
    JButton btnInstructions = new JButton("INSTRUCTIONS");
    JButton btnScores = new JButton("HIGHSCORES");
    JButton btnStart = new JButton("START");
    
    //Create and name title label
    JLabel lblTitle = new JLabel("Dragon Dodger 2.0");
    //Create font
    Font font = new Font("Serif", Font.BOLD, 48);
    
    MainScreen(){
        //Close application when X is clicked
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Creating a JPanel object and setting the layout manager to Border Layout
        JPanel panel = new JPanel(new BorderLayout());
        //Create JPanel with Flow Layout manager
        JPanel panel2 = new JPanel();
        //Create JPanel with Box Layout manager
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        
        //Align title label and add to panel
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        panel.add(lblTitle, BorderLayout.NORTH);
        
        //Set label font
        lblTitle.setFont(font);
        
        //Add instructions and scores button to panel2
        panel2.add(btnInstructions);
        panel2.add(btnScores);
        
        //Add all buttons to panel 3
        panel3.add(panel2);
        btnStart.setHorizontalAlignment(JLabel.CENTER); //Align start button
        panel3.add(btnStart);
        
        //Add panel 3 to panel
        panel.add(panel3, BorderLayout.SOUTH);
        
        //Create background image icon
        ImageIcon icon = new ImageIcon("Images/Background.jpg");
        
        //Create JLabel with icon
        JLabel lblBackground = new JLabel(icon);
        
        //Add background label to panel
        panel.add(lblBackground, BorderLayout.CENTER);
        
        //Add action listeners
        btnInstructions.addActionListener(this);
        btnScores.addActionListener(this);
        btnStart.addActionListener(this);
        
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
        //Check if instructions button is clicked
        if (e.getSource () == btnInstructions){
            //Open instructions frame
            Instructions instructions = new Instructions();

            //Close frame
            frame.dispose();
        }
        
        //Check if scores button is clicked
        if (e.getSource () == btnScores){
            //Open scores frame
            Scores score = new Scores();
            
            //Close frame
            frame.dispose();
        }
        
        //Check if start button is clicked
        if (e.getSource () == btnStart){
            //Open character select frame
            frame.setFocusable(false);
            //Close frame
            frame.dispose();
            Characters characters = new Characters();
        }
    }
}
