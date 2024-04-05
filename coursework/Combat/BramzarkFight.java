import java.util.Scanner;

import Bosses.*;
import Game_Play.Hero;

public class BramzarkFight extends Fight{
    private Bramzark enemy;
    private boolean abilityUsed;

    public BramzarkFight(Hero thePlayer) {
        super(thePlayer);
        
        enemy = new Bramzark();
        abilityUsed = false;
        setEnemyHP(enemy.getHP());
        setPlayerFirst(firstMove());

        System.out.println(enemy.encounterMessage());

        if (getPlayerFirst()) {
            playerTurn();
        } else {
            enemyTurn();
        }
    }
    
    public Bramzark getEnemy() {
        return enemy;
    }

    public boolean getAbilityStatus() {
        return abilityUsed;
    }

    public void setAbilityStatus(boolean status) {
        abilityUsed = status;
    }

    @Override
    public void enemyTurn() {
        if (getEnemyHP() < (enemy.getHP()/100)*25 && getAbilityStatus() == false) {
            setAbilityStatus(true);
            setEnemyHP(getEnemyHP() + enemy.specialBerserkerRage());
        }
        System.out.println(enemy.getName()  + " approaches...\n");
        double damage = enemy.attack();
        System.out.println("the enemy dealt " + damage + " damage");
        damage = (int)(damage)-(int)((getHero().getStat(7) + getHero().getStat(8))*0.15);

        //stops hp being added to player when attacked if enemies' attack is too weak
        if(damage <0) {
            damage = 0;
        }

        System.out.println( "Damage reduced to " + damage);

        damagePlayer(damage);

        if (getPlayerHP() <=0) {
            playerLoss();
        } else {
            if(getPlayerFirst()) {
                incrementTurn();
            }
            playerTurn();
        }
    }

    @Override
    public void playerWin() {
        stopFight();
        System.out.println("The enemy was defeated! \n");
        Scanner drop = new Scanner(System.in);
        System.out.println(getEnemy().death());

        int index = drop.nextInt();
        getHero().modifyInventory(index);
         
    }

    @Override
    public boolean firstMove() {
        if (getHero().getStat(11) >= enemy.getSpeed()) {
            return true;
        } else {
            return false;
        }
    }
}
