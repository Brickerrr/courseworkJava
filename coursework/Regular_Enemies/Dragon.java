package Regular_Enemies;

public class Dragon extends Monster{

    protected double test;

    public Dragon(){

        //Main Creature Details.
        setRace("Dragon");
        setHP(100);
        setMinAttack(8);        
        setMaxAttack(12);
        setMovementSpeed(15);

         //Elite Names.
        setEliteNames("Ertali the Sky Empress", "Xudoir the Damned", "Ormioryt the Eternal");

         //Item Drops.
        setItemDrops("Dragon Scale Gloves - (Type '11' to pick up: Or '0' to leave).",
                "Dragon Tooth Club - (Type '12' to pick up: Or '0' to leave).",
                "Quelii's Elven Bow - (Type '13' to pick up: Or '0' to leave).");
        
        //Attack Names.
        setAttackNames("Arial Assault", "Fire Barrage", "Infernal Storm");

        //Dialogue Lines.
        setDialogueOne("Once majestic witness our sorrowful flight! With heavy hearts, we unleash our flames, mourning our fallen kin!");
        setDialogueTwo("Darkness descends as I unleash my wrath. Let the flames of chaos consume all who dare challenge my dominion.");
        setDialogueThree("From the shadows of time, I emerge, a harbinger of doom. Tremble, mortals, as I unleash chaos upon you!");
    }   
}
