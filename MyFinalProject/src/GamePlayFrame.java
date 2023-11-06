//GamePlayFrame.java
//Creates gameplay screen

import javax.swing.JFrame;

public class GamePlayFrame extends JFrame {

    public GamePlayFrame(String wizard) {
        super("Gameplay");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit on close
        this.getContentPane().add(new Gameplay(wizard)); //set content to gameplay frame
        this.pack(); //pack frame
        this.setResizable(false); //make sure frame can't be resized
        this.setVisible(true); //make frame visible
    }

}
