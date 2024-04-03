package Character;
public class Dwarves /*extends character*/ {
    //dwarves class is childe class for the character class
    // here we add value to the variables in  character class
    // we use print_stats for printing stats mainly in character creation
    private double strength;
    private double dexterity;
    private double intelligence;
    private double charisma;
    private double resistance;
    private double endurance;
    private double health;



    public Dwarves(){
        strength =20;
        dexterity=10;
        intelligence =20;
        charisma =0;
        resistance=10;
        endurance=20;
        health=10;
        //super(20,10,20,0,10,20,10);

    }
    public void print_stats(){

        System.out.println("Your dwarf stats are:\nStrength: "+strength+"\nDexterity: "+dexterity+"\nIntelligence: "+intelligence+"\nResistance: "+resistance+"\nCharisma: "+charisma+ "\nEndurance: "+endurance+"\nHealth: "+health+"\n");
    }


    public double getStrength(){

        return strength ;
    }
    public double getDexterity(){

        return dexterity;
    }
    public double getIntelligence(){

        return intelligence;

    }
    public double getCharisma(){

        return charisma;
    }
    public double getResistance(){

        return resistance;
    }
    public double getEndurance(){

        return endurance;
    }
    public double getHealth(){

        return health;
    }


}