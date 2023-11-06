//Fullbuster.java
//Fullbuster child class that inherits Wizard parent class

public class Fullbuster extends Wizard {
    //Instance variable for wand
    private String shield;
    
    //Dragneel constructor
    public Fullbuster(int healthNum, int speedNum, String wizShield){
        //Adds variables from parent class
        super(healthNum, speedNum);

        //Assigns tool to Wizard
        shield = wizShield;
    }
    
    @Override
    //displayInfo method that overrides parent class and prints information for Fullbuster
    //Dragneel inherits the abstract method
    public String wizardInfo(){
        return("Health: " + super.getHealth() + " -- Speed: " + super.getSpeed() + " -- Talisman: " + shield + "!");
    }
}
