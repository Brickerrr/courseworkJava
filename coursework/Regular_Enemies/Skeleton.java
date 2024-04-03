package Regular_Enemies;

public class Skeleton extends Monster{

    public Skeleton(){
        
        //Main Creature Details.
        setRace("Skeleton");
        setHP(100);
        setMinAttack(3);        
        setMaxAttack(6);
        setMovementSpeed(25);

        //Elite Names.
        setEliteNames("Vikein the Mad Bard", "Zakin, Lord of the Undead", "Vegalok");

        //Item Drops.
        setItemDrops("Bonewalker Boots - (Type '8' to pick up: Or '0' to leave).",
                "Necromancer's Staff - (Type '3' to pick up: Or '0' to leave).",
                "Nostro's Skeletal Axe - (Type '4' to pick up: Or '0' to leave).");
        
        //Attack Names.
        setAttackNames("Boney Slap", "Projectile Head-Butt", "Rattling Undead Dance");
        
        //Dialogue Lines.
        setDialogueOne("Rattle your bones and clatter your teeth! I'm bone-tired of losing! Let's show 'em our funny bone-crushing moves!");
        setDialogueTwo("Attention Fleshbags! I'll be cracking jokes and bones in equal measure! Let's boogie!");
        setDialogueThree("Outta the Road! Or I'll serve up some bone-shaking jokes and bone-crushing moves! Bone-appétit!");
    }   
}
