package Bosses;

public class Bramzark extends Boss{

    public Bramzark(){

        //Main Creature Details.
        setName("Bramzark the Despoiler");
        setHP(600);
        setMinAttack(15);        
        setMaxAttack(25);
        setMovementSpeed(25);

        //Item Drops.
        setItemDrops("Oolak's Ring - (Type '18' to pick up: Or '0' to leave).",
                "Azzak's Demon Staff - (Type '19' to pick up: Or '0' to leave).",
                "Demon Lord Armour - (Type '20' to pick up: Or '0' to leave).");
        
        //Attack Names.
        setAttackNames("Demon Claw Slash", "Meteorite Shower", "Ancient Demonic Karate Chop");

        //Dialogue Lines.
        setDialogueOne("From the shadows of time, I emerge, a harbinger of doom. Tremble, mortals, as I unleash chaos upon thee!");
        setDialogueTwo("Behold my darkness, for it shall consume all. Tremble, fools, before my relentless might and eternal reign of terror.");
        setDialogueThree("In the abyss of my power, all shall perish. Witness the darkness's embrace as I crush hope beneath my heel.");    
    }

    
    //Bramzark's Special Ability 1 - Heal & Increased Attack Power.
    //Single Use Ability.
    public double specialBerserkerRage(){
        System.out.println("Bramzark Used Berserker's Rage");
        double upgrade = 100;
        setMinAttack(18);
        setMaxAttack(22);
        System.out.println("His Health has Increased by: " + upgrade + "\n" + 
                        "And his Attack Power has Increased by: 10." );

        return upgrade;
    }
    
    //Bramzark's Special Ability 2 - Attacks Player when even when a Lower Number is Rolled.
    //Recurring Ability.
    public double specialCounterAssault(){
        System.out.println("Bramzark Used Counter Assault.");
        
        return attack();
    }
}
