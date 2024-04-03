package Test;
import Regular_Enemies.Monster;

public class PlayerTest extends Monster{

    public PlayerTest(){

        //Main Creature Details.
        setRace("Human");
        setHP(3000);
        setMinAttack(20);        
        setMaxAttack(25);
        setMovementSpeed(8);
        
        //Attack Names.
        setAttackNames("Basic Attack", "Heavy Attack", "Special Attack");
    }
}