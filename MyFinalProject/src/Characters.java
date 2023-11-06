//Characters.java
//Holds Swing components for character screen

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class Characters implements ActionListener {
    public static GamePlayFrame gameplay;

    //Variables for character attributes
    public static int health, speed;
    public static String talisman;
    public static String player;
    public static String wizard;

    //Create JFrame object
    JFrame frame = new JFrame();

    //Create and name components on main screen
    JButton btnBack = new JButton("BACK");
    JButton btnPlay = new JButton("PLAY");
    JRadioButton rdbRed = new JRadioButton("Dragneel (Fast)");
    JRadioButton rdbBlue = new JRadioButton("Fullbuster (Strong)");
    JLabel lblTitle = new JLabel("Character Select");
    Font font = new Font("Serif", Font.BOLD, 48);

    //Create button group
    ButtonGroup bngChoice = new ButtonGroup();

    Characters() {
        //Close application when X is clicked
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add radio buttons to button group
        bngChoice.add(rdbRed);
        bngChoice.add(rdbBlue);

        //Set font
        lblTitle.setFont(font);
        //Align label
        lblTitle.setHorizontalAlignment(JLabel.CENTER);

        //Create JPanel with Border Layout manager
        JPanel panel = new JPanel(new BorderLayout());

        //Create grid
        GridLayout grid = new GridLayout(2, 2);

        //Create JPanels with Flow Layout manager
        JPanel panel2 = new JPanel();
        //Set grid pattern
        panel2.setLayout(grid);

        //Create JPanel with Flow Layout pattern and add buttons
        JPanel panel3 = new JPanel();
        panel3.add(btnBack);
        panel3.add(btnPlay);

        //Create character image icons
        ImageIcon icon = new ImageIcon("Images/RedSelect.png");
        ImageIcon icon2 = new ImageIcon("Images/BlueSelect.png");

        //Create JLabel with icon
        JLabel lblRed = new JLabel(icon);
        JLabel lblBlue = new JLabel(icon2);

        //Add icon labels to panel
        panel2.add(lblRed);
        panel2.add(lblBlue);
        panel2.add(rdbRed);
        panel2.add(rdbBlue);

        //Add contents to panel
        panel.add(panel2, BorderLayout.CENTER);
        panel.add(panel3, BorderLayout.SOUTH);
        panel.add(lblTitle, BorderLayout.NORTH);

        //Add action listeners to buttons
        btnBack.addActionListener(this);
        btnPlay.addActionListener(this);

        //Show the contents
        frame.setContentPane(panel);
        //Sets the frame to be visible
        frame.setVisible(true);
        //Make frame not resizable
        frame.setResizable(false);
        //Set frame size
        frame.setSize(700, 500);
    }

    @Override
    //Action performed method
    public void actionPerformed(ActionEvent e) {
        //Check if back button is clicked
        if (e.getSource() == btnBack) {
            //Open main screen
            MainScreen mainScreen = new MainScreen();

            //Close frame
            frame.dispose();
        }

        //Check if play button is clicked
        if (e.getSource() == btnPlay) {
            //Check if player has not selected a character
            if (rdbRed.isSelected() == false && rdbBlue.isSelected() == false) {
                //Prompt player to select character
                lblTitle.setText("Select a Character");

            } else {

                //Close frame
                //frame.dispose();
                //If red is selected
                if (rdbRed.isSelected()) {
                    //Create wizard with certain attributes
                    wizard = "Wand";

                    //If blue is selected
                } else if (rdbBlue.isSelected()) {
                    //Create wizard with certain attributes
                    wizard = "Shield";
                }
                frame.setFocusable(false);
                //Close frame
                frame.dispose();
                //Open main screen
                //Gameplay gameplay = new Gameplay(wizard);
                gameplay = new GamePlayFrame(wizard);
            }
        }
    }
    
    //Method that will close gameplay frame
    public static void close(){
        gameplay.dispose();
    }
}
