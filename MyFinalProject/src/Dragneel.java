//Dragneel.java
//Dragneel child class that inherits Wizard parent class

public class Dragneel extends Wizard{
    //Instance variable for wand
    private String wand;
    
    //Dragneel constructor
    public Dragneel(int healthNum, int speedNum, String wizWand){
        //Adds variables from parent class
        super(healthNum, speedNum);     
        
        //Assigns tool to Wizard
        wand = wizWand;
    }
    
    @Override
    //displayInfo method that overrides parent class and prints information for Dragneel
    //Dragneel inherits the abstract method
    public String wizardInfo(){
        return("Health: " + super.getHealth() + " -- Speed: " + super.getSpeed() + " -- Talisman: " + wand + "!");
    }
}
