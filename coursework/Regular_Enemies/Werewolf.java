package Regular_Enemies;

public class Werewolf extends Monster{

    public Werewolf(){

        //Main Creature Details.
        setRace("Werewolf");
        setHP(65);
        setMinAttack(9);        
        setMaxAttack(14);
        setMovementSpeed(25);
 
        //Elite Names.
        setEliteNames("Roffe the Damned", "Ulfr", "Goro");
 
        //Item Drops.
        setItemDrops("Wolf-Skull Mace - (Type '5' to pick up: Or '0' to leave).",
                "Wolf Pelt Armour - (Type '6' to pick up: Or '0' to leave).",
                "Ophelia's Claw Rapier - (Type '7' to pick up: Or '0' to leave).");
         
        //Attack Names.
        setAttackNames("Savage Slah", "Claw Whirlwind", "Feral Charge");

        //Dialogue Lines.
        setDialogueOne("Tonight, as we Wander the Shadows, our Claws shall slash thee. And our fangs shall rip thee apart.");
        setDialogueTwo("Beneath the Moon's, our blessed Goddess' eye, we shall unleash our Primal Fury.");
        setDialogueThree("Our howls will echo in the Shadows as we tear through thee.");
    }
}
