package Regular_Enemies;

public class IceGolem extends Monster{

    public IceGolem(){

        //Main Creature Details.
        setRace("Ice Golem");
        setHP(100);
        setMinAttack(8);        
        setMaxAttack(14);
        setMovementSpeed(8);

        //Elite Names.
        setEliteNames("Itariel the Frozen Demon", "Nedia", "Vaaldra the Ice Princess");

        //Item Drops.
        setItemDrops("Ice Hammer - (Type '15' to pick up: Or '0' to leave).",
                "Frozen Ring - (Type '16' to pick up: Or '0' to leave).",
                "Ijik's Ice Crown - (Type '17' to pick up: Or '0' to leave).");
        
        //Attack Names.
        setAttackNames("Ice Blast", "Frozen Fury", "Ijik's Avalanche");

        //Dialogue Lines.
        setDialogueOne("With Frozen Fists I will shatter your dreams and freeze your hopes!");
        setDialogueTwo("From the depths of glaciers, you awaken me, cold and relentless. With icy power, I will break you!");
        setDialogueThree("Behold the embodiment of Ijik's wrath! With unyielding force, I shall freeze the battlefield and overcome all who oppose me.");
    }
    
}
