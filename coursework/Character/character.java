package Character;
public class character {
    //public static Object dwarves;
    // character class in perent class here we declare what stats the hero has
   // private double strength;
    protected double strength;
    protected double dexterity;
    protected double intelligence;
    protected double charisma;
    protected double resistance;
    protected double endurance;
   protected double health;
    // because this is parent class i want to declare the number here so in dwarf class which is child class we put the numbers there with super
    public character(int strength, int dexterity, int intelligence, int charisma, int resistance, int endurance, int health) {
       // this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.charisma = charisma;
        this.resistance = resistance;
        this.endurance = endurance;
        this.health = health;
    }



}
