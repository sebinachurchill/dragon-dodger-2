//Gameplay.java
//Holds Swing components for gameplay screen

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import java.util.Random;

public class Gameplay extends JPanel implements ActionListener {
    //Declare instance of wizard
    private Wizard player;
    
    String playerInfo; //variable for player info
    
    String finalScore; //variable for the final score

    //Player and dragon labels
    JLabel lblPlayer;
    JLabel lblDragon1;
    JLabel lblDragon2;
    JLabel lblDragon3;
    JLabel lblDragon4;
    JLabel lblPlayerInfo;

    //Score and live labels to display
    JLabel lblScoreLabel = new JLabel("Score: ");
    JLabel lblScore = new JLabel();
    JLabel lblLivesLabel = new JLabel("Lives: ");
    JLabel lblLives = new JLabel();

    public String obj; //variable for player choice (wand or shield)

    //Variables for lives, score, and speed
    public int lives = 0;
    public int score = 0;
    public int speed;
    
    public int pIcon = 0; //Variable to control current icon in player animation
    
    //Wizard icons for animation
    ImageIcon icoWiz1;
    ImageIcon icoWiz2;
    
    //Dragon icons for animation
    public int dIcon = 0;
    ImageIcon icoDragMid;
    ImageIcon icoDragDown;
    ImageIcon icoDragUp;
    
    //Icons for talisman
    ImageIcon shieldPic;
    ImageIcon blastPic;
   
    boolean red; //boolean for talisman
    
    int dragonSpeed = 30; //dragon speed

    //Integers for player and dragon location
    int x, y, width, height;
    int x2, y2, width2, height2;
    int x3, y3;
    int x4, y4;
    int x5, y5;
    int xb, yb, widthb, heightb;

    //Timers for movement of each dragon
    Timer tmrDragon1 = new Timer(100, this);
    Timer tmrDragon2 = new Timer(100, this);
    Timer tmrDragon3 = new Timer(100, this);
    Timer tmrDragon4 = new Timer(100, this);
    Timer tmrPlayerAni = new Timer(300, this);
    Timer tmrDragonAni = new Timer(150, this);
    Timer tmrDragonSpeed = new Timer(3000, this);

    Timer tmrChoose = new Timer(2000, this); //Timer for choosing dragon
    Timer tmrCollision = new Timer(1, this); //Timer that checks for 

    Timer tmrScore = new Timer(1000, this); //Timer for player score  

    Random dragonNum = new Random(); //Random number
    
    //Boolean for dragon choice
    boolean drag1 = false;
    boolean drag2 = false;
    boolean drag3 = false;
    boolean drag4 = false;

    //panel constructor
    public Gameplay(String wizard) {
        //Set frame size
        setPreferredSize(new Dimension(625, 500));

        //Variable for wizard type
        obj = wizard;

        //Check if player chose red wizard
        //and assign appropriate icons
        if (obj.compareToIgnoreCase("Wand") == 0) {
            player = new Dragneel(3, 25, "Wand");
            icoWiz1 = new ImageIcon("Images/Red1.png");
            icoWiz2 = new ImageIcon("Images/Red2.png");
            //shieldPic = new ImageIcon("Images/Blast.png");
            //talisman = new JLabel(blastPic);
            //red = true;

            //Check if player chose blue wizard
            //and assign appropriate icons
        } else {
            player = new Fullbuster(5, 15, "Shield");
            icoWiz1 = new ImageIcon("Images/Blue1.png");
            icoWiz2 = new ImageIcon("Images/Blue2.png");
            //shieldPic = new ImageIcon("Images/Shield.png");
            //talisman = new JLabel(shieldPic);
            //red = false;
        }
        
        playerInfo = player.wizardInfo();
        System.out.println(playerInfo);
        
        //Label for player information
        lblPlayerInfo = new JLabel(playerInfo);

        //Get lives and health of player
        lives = player.getHealth();
        speed = player.getSpeed();

        this.setLayout(null); //set layout to null

        //Declare dragon icons
        icoDragMid = new ImageIcon("Images/DragonMid.png");
        icoDragDown = new ImageIcon("Images/DragonDown.png");
        icoDragUp = new ImageIcon("Images/DragonUp.png");

        //Create and name gameplay labels (icon holders)
        lblPlayer = new JLabel(icoWiz1);
        lblDragon1 = new JLabel(icoDragUp);
        lblDragon2 = new JLabel(icoDragUp);
        lblDragon3 = new JLabel(icoDragUp);
        lblDragon4 = new JLabel(icoDragUp);

        //Add labels to pane
        this.add(lblPlayer);
        this.add(lblDragon1);
        this.add(lblDragon2);
        this.add(lblDragon3);
        this.add(lblDragon4);
        this.add(lblScoreLabel);
        this.add(lblScore);
        this.add(lblLivesLabel);
        this.add(lblLives);
        this.add(lblPlayerInfo);

        lblLives.setText(Integer.toString(lives)); //display player lives

        //Set player location variables
        Insets insets = this.getInsets();
        Dimension size = lblPlayer.getPreferredSize();
        lblPlayer.setBounds(insets.left, insets.top, size.width, size.height);
        x = insets.left;
        y = insets.top;
        width = size.width;
        height = size.height;
        
        
        //Set info label location variables
        Dimension sizeb = lblPlayerInfo.getPreferredSize();
        xb = insets.left;
        yb = insets.top;
        widthb = sizeb.width;
        heightb = sizeb.height;
        lblPlayerInfo.setBounds(250 + insets.left, 470 + insets.top, sizeb.width, size.height);

        //Set dragon1 location variables
        Dimension size2 = lblDragon1.getPreferredSize();
        x2 = 650 + insets.left;
        y2 = insets.top;
        width2 = size2.width;
        height2 = size2.height;

        //Set dragon2 location variables
        x3 = 650 + insets.left;
        y3 = 121 + insets.top;

        //Set dragon3 location variables
        x4 = 650 + insets.left;
        y4 = 242 + insets.top;

        //Set dragon4 location variables
        x5 = 650 + insets.left;
        y5 = 364 + insets.top;

        //Set location of dragons
        lblDragon1.setBounds(650 + insets.left, insets.top, size2.width, size2.height);
        lblDragon2.setBounds(650 + insets.left, 121 + insets.top, size2.width, size2.height);
        lblDragon3.setBounds(650 + insets.left, 242 + insets.top, size2.width, size2.height);
        lblDragon4.setBounds(650 + insets.left, 364 + insets.top, size2.width, size2.height);

        //Dimension size3 = lblScoreLabel.getPreferredSize();
        //Set label location variables
        lblScoreLabel.setBounds(insets.left, 470 + insets.top, size.width, size.height);
        lblScore.setBounds(50 + insets.left, 470 + insets.top, size.width, size.height);
        lblLivesLabel.setBounds(125 + insets.left, 470 + insets.top, size.width, size.height);
        lblLives.setBounds(175 + insets.left, 470 + insets.top, size.width, size.height);

        //Add listeners
        PlayerListener monitorPlayer = new PlayerListener();
        addKeyListener(monitorPlayer);
        this.setFocusable(true);

        //Call timer method
        timer();
    }

    private class PlayerListener implements KeyListener {

        // keyPressed called when a key has been pressed.
        @Override
        public void keyPressed(KeyEvent e) {
            //Check if player pressed W
            if (e.getKeyCode() == KeyEvent.VK_W) {
                //Move player up
                if (y > 0) {
                    y -= 5;
                    lblPlayer.setBounds(x, y, width, height);
                }
            }

            //Check if player pressed S
            if (e.getKeyCode() == KeyEvent.VK_S) {
                //Move player down
                if (y < 440) {
                    y += 5;
                    lblPlayer.setBounds(x, y, width, height);
                }
            }

            //Check if player pressed A
            if (e.getKeyCode() == KeyEvent.VK_A) {
                //Move player left
                if (x > 5) {
                    x -= 5;
                    lblPlayer.setBounds(x, y, width, height);
                }
            }

            //Check if player pressed D
            if (e.getKeyCode() == KeyEvent.VK_D) {
                //Move player right
                if (x < 570) {
                    x += 5;
                    lblPlayer.setBounds(x, y, width, height);
                }
            }
        }

        //Empty method
        @Override
        public void keyReleased(KeyEvent e) {
        }

        //empty method
        @Override
        public void keyTyped(KeyEvent e) {
        } //Invoked when a key has been typed.
    }

    //Action performed method
    @Override
    public void actionPerformed(ActionEvent e) {
        //If collision timer ticks
        if (e.getSource() == tmrCollision) {
            //Call checkCollision and checkHealth methods
            checkCollision();
            checkHealth();
        }
        
        
        //=================================
        //If each dragon timer ticks, call
        //the move method for that dragon
        //=================================
        if (e.getSource() == tmrDragon1) {
            moveDragon1();
        }

        if (e.getSource() == tmrDragon2) {
            moveDragon2();
        }

        if (e.getSource() == tmrDragon3) {
            moveDragon3();
        }

        if (e.getSource() == tmrDragon4) {
            moveDragon4();
        }
        //=================================
        //=================================

        
        
        //If choose timer ticks
        if (e.getSource() == tmrChoose) {
            //Call select dragon method
            selectDragon();
        }

        //If score timer ticks
        if (e.getSource() == tmrScore) {
            //Increment score by 5 and display
            score += 5;
            lblScore.setText(Integer.toString(score));
        }
        
        //If player animation timer ticks
        if (e.getSource() == tmrPlayerAni) {
            //Alternate between two images for animation with case statement
            switch (pIcon){
                case 0:
                    lblPlayer.setIcon(icoWiz1);
                    pIcon = 1;
                    break;
                case 1:
                    lblPlayer.setIcon(icoWiz2);
                    pIcon = 0;
                    break;
            }
        }
        
        //If dragon animation timer ticks
        if (e.getSource() == tmrDragonAni) {
            //====================================
            //Use case statement to alternate
            //between 3 images to make the dragons
            //appear to be flapping their wings
            //when they fly. Once an icon is
            //changed, change case number so that
            //a new icon will be set each time
            //====================================
            switch (dIcon){
                case 0:
                    lblDragon1.setIcon(icoDragMid);
                    lblDragon2.setIcon(icoDragMid);
                    lblDragon3.setIcon(icoDragMid);
                    lblDragon4.setIcon(icoDragMid);
                    dIcon = 1;
                    break;
                case 1:
                    lblDragon1.setIcon(icoDragDown);
                    lblDragon2.setIcon(icoDragDown);
                    lblDragon3.setIcon(icoDragDown);
                    lblDragon4.setIcon(icoDragDown);
                    dIcon = 2;
                    break;
                case 2:
                    lblDragon1.setIcon(icoDragMid);
                    lblDragon2.setIcon(icoDragMid);
                    lblDragon3.setIcon(icoDragMid);
                    lblDragon4.setIcon(icoDragMid);
                    dIcon = 3;
                    break;
                case 3:
                    lblDragon1.setIcon(icoDragUp);
                    lblDragon2.setIcon(icoDragUp);
                    lblDragon3.setIcon(icoDragUp);
                    lblDragon4.setIcon(icoDragUp);
                    dIcon = 0;
                    break;
            }
            //====================================
            //====================================
        }
        
        
        
        //If dragon speed timer ticks
        if (e.getSource() == tmrDragonSpeed) {
            //Increase dragon speed
            dragonSpeed++;
        }
    }

    //Timer method
    public void timer() {
        //Start many timers
        tmrChoose.start();
        tmrScore.start();
        tmrCollision.start();
        tmrPlayerAni.start();
        tmrDragonAni.start();
        tmrDragonSpeed.start();
    }

    //Select dragon method
    public void selectDragon() {
        //Generate random number between 0 and 3
        int RandNum = dragonNum.nextInt(4);

        //START APPROPRIATE TIMER DEPENDING ON RANDOM NUMBER
        //IF DRAGON CHOSEN IS ALREADY MOVING,
        //START ANOTHER TIMER
        
        //If random number is 0, start dragon timer 1
        if (RandNum == 0) {
            if(drag1 == false){
                drag1 = true;
                tmrDragon1.start();
            }else{
                tmrDragon2.start();
            }
        }

        //If random number is 1, start dragon timer 2
        if (RandNum == 1) {
            if(drag2 == false){
                drag2 = true;
                tmrDragon2.start();
            }else{
                tmrDragon3.start();
            }
        }

        //If random number is 2, start dragon timer 3
        if (RandNum == 2) {
            if(drag3 == false){
                drag3 = true;
                tmrDragon3.start();
            }else{
                tmrDragon4.start();
            }
        }

        //If random number is 4, start dragon timer 4
        if (RandNum == 3) {
            if(drag4 == false){
                drag4 = true;
                tmrDragon4.start();
            }else{
                tmrDragon1.start();
            }
        }
    }
    
    
    
    
    //==========================================================================
    //MOVE DRAGON METHODS
    //X VALUE FOR EACH DRAGON IS DECREMENTED BY SPEED AMOUNT
    //SET DRAGON BOUNDS TO NEW COORDINATES
    //STOP THE SPECIFIED DRAGON TIMER
    //RESET DRAGON LOCATION TO THE RIGHT SIDE OF THE SCREEN
    //==========================================================================
    
    public void moveDragon1() {
        x2 -= dragonSpeed;
        lblDragon1.setBounds(x2, y2, width2, height2);

        if (x2 <= 0) {
            drag1 = false;
            tmrDragon1.stop();
            x2 = 650;
            lblDragon1.setBounds(x2, y2, width2, height2);
        }
    }

    public void moveDragon2() {
        x3 -= dragonSpeed;
        lblDragon2.setBounds(x3, y3, width2, height2);

        if (x3 <= 0) {
            drag2 = false;
            tmrDragon2.stop();
            x3 = 650;
            lblDragon2.setBounds(x3, y3, width2, height2);
        }
    }

    public void moveDragon3() {
        x4 -= dragonSpeed;
        lblDragon3.setBounds(x4, y4, width2, height2);

        if (x4 <= 0) {
            drag3 = false;
            tmrDragon3.stop();
            x4 = 650;
            lblDragon3.setBounds(x4, y4, width2, height2);
        }
    }

    public void moveDragon4() {
        x5 -= dragonSpeed;
        lblDragon4.setBounds(x5, y5, width2, height2);

        if (x5 <= 0) {
            drag4 = false;
            tmrDragon4.stop();
            x5 = 650;
            lblDragon4.setBounds(x5, y5, width2, height2);
        }
    }
    //==========================================================================
    //==========================================================================

    
    
    
    //Check collision method
    public void checkCollision() {
        //Create rectangles for player and dragons
        Rectangle flyingWizard = lblPlayer.getBounds();
        Rectangle d1 = lblDragon1.getBounds();
        Rectangle d2 = lblDragon2.getBounds();
        Rectangle d3 = lblDragon3.getBounds();
        Rectangle d4 = lblDragon4.getBounds();

        
        
        //==================================================
        //CHECK IF PLAYER INTERSECTS A DRAGON
        //IF PLAYER IS INTERSECTING A DRAGON, RESET DRAGON
        //LOCATION TO RIGHT SIDE OF THE SCREEN AND DECREMENT
        //PLAYER LIVES BY 1
        //==================================================      
        if (flyingWizard.intersects(d1)) {
            tmrDragon1.stop();
            drag1 = false;
            x2 = 650;
            lblDragon1.setBounds(x2, y2, width2, height2);
            //Decrease lives
            lives -= 1;
            lblLives.setText(Integer.toString(lives));
        }     
        
        if (flyingWizard.intersects(d2)) {
            tmrDragon2.stop();
            drag2 = false;
            x3 = 650;
            lblDragon2.setBounds(x3, y3, width2, height2);
            //Decrease lives
            lives -= 1;
            lblLives.setText(Integer.toString(lives));
        }
     
        if (flyingWizard.intersects(d3)) {
            tmrDragon3.stop();
            drag3 = false;
            x4 = 650;
            lblDragon3.setBounds(x4, y4, width2, height2);
            //Decrease lives
            lives -= 1;
            lblLives.setText(Integer.toString(lives));
        }

        if (flyingWizard.intersects(d4)) {
            tmrDragon4.stop();
            drag4 = false;
            x5 = 650;
            lblDragon4.setBounds(x5, y5, width2, height2);
            //Decrease lives
            lives -= 1;
            lblLives.setText(Integer.toString(lives));
        }
        
        //==================================================
        //==================================================
    }

    
    
    
    //Method to check current health
    public void checkHealth() {
        //Check if player has no lives left
        if (lives == 0) {
            //Stop all timers
            tmrDragon1.stop();
            tmrDragon2.stop();
            tmrDragon3.stop();
            tmrDragon4.stop();
            tmrChoose.stop();
            tmrCollision.stop();
            tmrScore.stop();
            tmrPlayerAni.stop();
            tmrDragonAni.stop();
            
            //Open endgame screen
            EndGame endgame = new EndGame(score);
        }
    }

}
