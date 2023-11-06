//EndGame.java
//Holds Swing components for EndGame

import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EndGame implements ActionListener{
    //Declare elements to be added to the frame
    JLabel lblName;
    JLabel lblGameOver;
    JTextField txtNameEntry;
    JButton btnContinue;
    
    JFrame frame = new JFrame(); //the frame
    
    int score; //variable for player score
    
    EndGame(int finalScore){  
        //Close application when X is clicked
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        //Initialize labels and buttons
        lblName = new JLabel("Please enter your name: "); //name prompt
        lblGameOver = new JLabel("GAME OVER"); //game over title
        txtNameEntry = new JTextField(25); //text field for player entry
        btnContinue = new JButton("CONTINUE"); //continue button
        
        score = finalScore; //set score value to player score
        
        //Create panel with box layout manager
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        
        //Create panel with flow layout manager
        JPanel panel2 = new JPanel();
        
        //Add all elements to panel
        panel2.add(lblName);
        panel2.add(txtNameEntry);
        panel1.add(lblGameOver);
        panel1.add(panel2);
        panel1.add(btnContinue);
        
        //Show the contents
        frame.setContentPane(panel1);
        //Sets the frame to be visible
        frame.setVisible (true);
        //Make frame not resizable
        frame.setResizable(false);
        //Set frame size
        frame.setBounds (300, 200, 300, 300);
        
        //Add action listener to continue button
        btnContinue.addActionListener(this);
    }
    
    @Override
    //Action performed method
    public void actionPerformed(ActionEvent e){
        //Check if continue button is clicked
        if (e.getSource () == btnContinue){
            FileWriter fw = null; //FileWriter
            try {
                String name; //variable for player name
                name = txtNameEntry.getText();//set name to what player wrote in text box
                
                //Check if no name was entered
                if(name.compareToIgnoreCase("") == 0){
                    //Set player name to anonymous wizard
                    name = "Anonymous Wizard";
                }
                
                String file = "Scores.txt"; //file to be written to
                    fw = new FileWriter(file, true); //represents a text output file
                    BufferedWriter bw = new BufferedWriter(fw);  //gives output stream buffering capabilities, makes more efficient
                    try (PrintWriter outFile = new PrintWriter(bw)) {
                        outFile.println(name + " -- " + score); //print player name and score to scores file
                        outFile.close(); //closes the PrintWriter object
                        fw.close(); //closes FileWriter object
                    }
                
                //Netbeans also added this and I'm not sure what it does
                } catch (IOException ex) {
                Logger.getLogger(EndGame.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            //Netbeans added this automatically so I'm not sure what it does
            finally {
                try {
                    fw.close();
                } catch (IOException ex) {
                    Logger.getLogger(EndGame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }            }
            
            //Open instructions frame
            MainScreen mainScreen = new MainScreen();
            //Close frame
            frame.dispose();
            
            //Close gameplay frame
            Characters.close();
        }
    }
