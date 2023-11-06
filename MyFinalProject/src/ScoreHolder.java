//ScoreHolder.java
//Class to hold scores from file

public class ScoreHolder {
    //Instance variables for name and score
    private String name;
    private int score;
    
    //Constructor for ScoreHolder
    public ScoreHolder(String playerName, int playerScore){
        //Set name and score values
        name = playerName;
        score = playerScore;
    }
    
    //Accessor method for name
    String getName(){
        return(name);
    }
    
    //Accessor method for score
    int getScore(){
        return(score);
    }
    
    //Accessor method will return name and score info
    String getInfo(){
        return(name + " -- " + score);
    }
}
