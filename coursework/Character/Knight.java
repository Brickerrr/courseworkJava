package Character;

public class Knight extends Human{

    private double armor;
    private double magResistance;
    private double attackSpeed;
    private double stealth;
    private double movementSpeed;


   private double demage;

    private double []stat = new double[13];
    // we made them all outside methods so we can access teh globaly
    // create a array where 1st bracket is  code for the stat and the second is the number
    public Knight() {

        armor = getResistance()+15;
        magResistance = getIntelligence();
        attackSpeed = getDexterity() -5;
        stealth = getDexterity() -10;
        movementSpeed = getStrength();
        demage=getStrength();



    }
    // same as before print stats
    public void print_stats() {
        System.out.println("Your dwarfen druid specific stats are\nArmor: "+armor+"\nMag Resistance: "+magResistance+"\nAttack Speed: "+attackSpeed+"\nStealth: "+stealth+"\nMovement Speed: "+movementSpeed+"\n");
    }



    public double stat(int code){

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

