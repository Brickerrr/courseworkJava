package Regular_Enemies;

public class Orc extends Monster{

    public Orc(){

        //Main Creature Details.
        setRace("Orc");
        setHP(70);
        setMinAttack(6);        
        setMaxAttack(12);
        setMovementSpeed(20);

        //Elite Names.
        setEliteNames("Orzanug", "Warchief Garlullak", "Ferazul the Mad Shaman");

        //Item Drops.
        setItemDrops("Rusty Sword - (Type '2' to pick up: Or '0' to leave).",
                "Sturdy Iron Shield - (Type '9' to pick up: Or '0' to leave).",
                "Byzular's Spiked Club - (Type '10' to pick up: Or '0' to leave).");
        
        //Attack Names.
        setAttackNames("Regular Strike", "Ferocious Slash", "Primal Fury");

        //Dialogue Lines.
        setDialogueOne("With axes high and war cries loud, I shall paint the battlefield red with the blood, in the name of Byzular!.");
        setDialogueTwo("Through chaos and carnage. The screams of my foes will fuel my relentless advance to victory!");
        setDialogueThree("With death in my eyes and fury in our hearts, I shall crush you and claim victory!");
    }   
}
