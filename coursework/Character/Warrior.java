package Character;

public class Warrior extends Dwarves {
    private double armor;
    private double magResistance;
    private double attackSpeed;
    private double stealth;
    private double movementSpeed;
    private double demage;
   private double [] stat = new double[13];
    public Warrior() {

        armor = getStrength()  + 10;
        magResistance = getIntelligence() -5;
        attackSpeed = getDexterity();
        stealth = getDexterity() - 10;
        movementSpeed =getStrength()- 5;
        demage=getStrength();

    }
    public void print_stats() {
        System.out.println("Your dwarfen warior specific stats are:\nArmor: "+armor+"\nMag Resistance: "+magResistance+"\nAttack Speed: "+attackSpeed+"\nStealth: "+stealth+"\nMovement Speed: "+movementSpeed+"\n");

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
