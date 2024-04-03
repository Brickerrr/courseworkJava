package Game_Play;

public class Weapon {

    private String weaponName;
    private int statCode;
    private double statModifier;



    public Weapon(String weaponName, int statCode, double statModifier){
        this.weaponName = weaponName;
        this.statCode = statCode;
        this.statModifier = statModifier;
    }

    public String getWeaponName(){

        return weaponName;
    }
    public int getStatCode(){
        return statCode;

    }
    public double getStatModifier(){

        return statModifier;
    }





}
