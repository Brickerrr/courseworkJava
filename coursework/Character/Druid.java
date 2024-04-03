package Character;


public class Druid extends Dwarves {
    // druid is child class for dwarves
    // here we difne other stats like armor and magres...
    // they are all dervide from the stats in dwarves class
   private double armor;
    private double magResistance;
    private double attackSpeed;
    private double stealth;
   private double movementSpeed;


    double demage;

    private double []stat = new double[13];
    // we made them all outside methods so we can access teh globaly
    // create a array where 1st bracket is  code for the stat and the second is the number
    public Druid() {

        armor = getStrength();
        magResistance = getIntelligence();
        attackSpeed = getDexterity() + 5;
        stealth = getDexterity() + 5;
        movementSpeed = getStrength()+ 10;
        demage=getStrength()-5;



    }
    // same as before print stats
    public void print_stats() {
        System.out.println("Your dwarfen druid specific stats are\nArmor: "+armor+"\nMag Resistance: "+magResistance+"\nAttack Speed: "+attackSpeed+"\nStealth: "+stealth+"\nMovement Speed: "+movementSpeed+"\n");
    }


    public double stat(int code){
        //this is the method to get the precise stats when we need them we just call it and put in the code for the stat
        // when in fight and dragon attacks we can just call it with the code that is appropriate for armor and health and
        // do the necessary callculations
        // when decide on gampely and fight tackticks we can implement changeg scheeme right now everything regenerate back to full

        stat [0]=getStrength();
        stat [1]=getDexterity();
        stat [2]=getIntelligence();
        stat [3]=getCharisma();
        stat [4]=getResistance();
        stat [5]=getEndurance();
        stat [6]=getHealth();
        stat [7]=armor;
        stat [8]=magResistance;
        stat [9]=attackSpeed;
        stat [10]=stealth;
        stat [11]=movementSpeed;
        stat [12]=demage;

        return stat[code] ;

    }
    public double getStat(int code) {

        return stat[code];
    }



}
