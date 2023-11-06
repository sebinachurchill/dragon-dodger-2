//Wizard.java
//Abstract wizard class used as parent class for the
//Dragneel and Fullbuster child classes

abstract public class Wizard {
    //Instance variables for health and speed
    public static int health, speed;
    
    //Wizard constructor
    public Wizard(int healthNum, int speedNum){
        //Assigns designated values to instance variables
        health = healthNum;
        speed = speedNum;
    }
    
    //Accessor method for health
    int getHealth() {
        return health;
    }
    
    //Accessor method for speed
    int getSpeed() {
        return speed;
    }
    
    //Abstract method for wizard information
    //Changes depending on the class that inherits it
    abstract String wizardInfo();
}
