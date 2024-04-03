package Bosses;
public class TheUnknown extends Boss{

    public TheUnknown(){

          //Main Creature Details.
          setName("The Unknown");
          setHP(400);
          setMinAttack(12);        
          setMaxAttack(20);
          setMovementSpeed(30);
  
          //Item Drops.
          setItemDrops("Thief's Ring - (Type '21' to pick up: Or '0' to leave).",
                    "Irrilian Staf - (Type '22' to pick up: Or '0' to leave).",
                    "Olko's Twin Daggers - (Type '23' to pick up: Or '0' to leave).");
          
          //Attack Names.
          setAttackNames("Misty Dropkick", "Shadow Blade Frenzy", "Soul Possession");
  
          //Dialogue Lines.
          setDialogueOne("In the shadows, I am the embodiment of terror. Witness the eclipse of hope as I unleash my malevolent fury.");
          setDialogueTwo("Submit to the void, for I am its master. In my wake, only despair and ruin shall remain.");
          setDialogueThree("From the depths of darkness, I emerge, wielding shadows as my weapon. Surrender to oblivion or face eternal torment.");
    }


    //The Unknown's Special Ability 1 - Heal. 
    //Recurring Ability. 
    public double specialHealthRegen(){
        double healthIncrement = 2;
        healthIncrement++;
        System.out.println("The Unknown used Azzaji's Shadow Blessing.");
        System.out.println("It's health has Increased by: " + healthIncrement + "\n");

        return healthIncrement;
    }

    //The Unknown's Special Ability 2 - Double Attack.
    //Recurring Ability.
    public double specialDoubleAttack(){
        System.out.println("Double Attack");
        double attackOne = attack();
        double attackTwo = attack();

        double fullAttack = attackOne + attackTwo;

        return fullAttack;
    }
}
