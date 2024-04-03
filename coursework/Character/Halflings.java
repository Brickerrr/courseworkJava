package Character;

public class Halflings {
    private double strength;
    private double dexterity;
    private double intelligence;
    private double charisma;
    private double resistance;
    private double endurance;
    private double health;

    public Halflings() {
        strength = 10;
        dexterity = 10;
        intelligence = 10;
        charisma = 20;
        resistance = 10;
        endurance = 20;
        health = 20;
        //super(20,10,20,0,10,20,10);

    }

    public void print_stats() {

        System.out.println("Your dwarf stats are:\nStrength: " + strength + "\nDexterity: " + dexterity + "\nIntelligence: " + intelligence + "\nResistance: " + resistance + "\nCharisma: " + charisma + "\nEndurance: " + endurance + "\nHealth: " + health + "\n");
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
