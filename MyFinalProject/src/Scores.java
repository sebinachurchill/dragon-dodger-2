//Scores.java
//Holds Swing components for score page

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Scores implements ActionListener{
    //Create JFrame object
    JFrame frame = new JFrame();
    
    //Create and name back button
    JButton btnBack = new JButton("BACK");
    
    //Create and name scores label
    JLabel lblScoresTitle = new JLabel("Scores");
    //Create font
    Font font = new Font("Serif", Font.BOLD, 48);
    
    //Intialize and declare scoresList
    DefaultListModel scoresList = new DefaultListModel();
    //Create and name JList
    JList lstScores = new JList(scoresList);
    
    Scores(){
        //Close application when X is clicked
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create JPanel with Border Layout manager
        JPanel panel = new JPanel(new BorderLayout());
        //Create JPanel with Flow Layout manager
        JPanel panel2 = new JPanel();
        
        //Align button and label
        lblScoresTitle.setHorizontalAlignment(JLabel.CENTER);
       
        //Set title font
        lblScoresTitle.setFont(font);
        
        //Add back button to panel2
        panel2.add(btnBack);
        
        //Add panel2 and label to panel
        panel.add(lstScores, BorderLayout.CENTER);
        panel.add(panel2, BorderLayout.SOUTH);
        panel.add(lblScoresTitle, BorderLayout.NORTH);
        
        //Add action listener to back button
        btnBack.addActionListener(this);
        
        String playerScore; //variable for name and score
        Scanner fileScan = null; //Scanner object for reading
        Scanner playerScan;
        boolean found = true; //boolean for finding file
            
        try {
            //Try to scan ClassList text file
            fileScan = new Scanner(new File("Scores.txt"));  
        } catch (FileNotFoundException exception) { //this block will run if can't find the file
            //if file not found, assign variable to false
            found = false;
        }
            
        //Check if file was found
        //Will run as long as file exists and exception is not found
        if (found == true) { 
            //Create array to hold scores
            ArrayList<ScoreHolder> scoreArray = new ArrayList<>();
            
            //Read and process each line of the file
            while (fileScan.hasNext()){
                String name = "Unknown";
                int score = 0;
                
                //Read next line into playerScore string variable
                playerScore = fileScan.nextLine();
                
                playerScan = new Scanner(playerScore);
                
                playerScan.useDelimiter(" -- ");
                
                int number = 0;
                
                while(playerScan.hasNext()){
                    
                    while(number == 0){
                        try {
                                //Check if hours is an integer
                                name = playerScan.next();
                                number = 1; //set number to 2
                            }
                            
                            //Catch clause called if section in string is not a number
                            catch (NumberFormatException exception) {
                                //Set hours to 0 if number is not an integer
                                name = "Anonymous";
                            }
                    }
                    
                    while(number == 1){
                        try {
                                //Check if hours is an integer
                                score = Integer.parseInt(playerScan.next());
                                number = 0; //set number to 2
                            }
                            
                            //Catch clause called if section in string is not a number
                            catch (NumberFormatException exception) {
                                //Set hours to 0 if number is not an integer
                                score = 0;
                            }
                    }         
                    ScoreHolder player = new ScoreHolder(name, score);
                    scoreArray.add(player);
                    System.out.println(player.getInfo());
                }
            }
            
            for (int y = 1; y < scoreArray.size(); y += 1){
                for (int x = 0; x < scoreArray.size() - 1; x += 1){
                    if (scoreArray.get(x).getScore() <= scoreArray.get(y).getScore()){
                        ScoreHolder holder;
                        ScoreHolder holder2;
                        
                        //Put the person at index x into a placeholder so that the information doesn't get lost
                        holder = scoreArray.get(x);
                        holder2 = scoreArray.get(y);
                    
                        //Put the information of the person at index y into index x in the array
                        scoreArray.set(x, scoreArray.get(y));
                                                      
                        //Put the information of the person at x (now in the holder) into index y in the array
                        scoreArray.set(y, holder);
                    }
                }
            }
            for (int i = 0; i < scoreArray.size(); i++) {
                scoresList.addElement(scoreArray.get(i).getInfo());
            }
    }
        

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
