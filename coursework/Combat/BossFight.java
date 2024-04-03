import java.util.Scanner;

import Bosses.*;
import Game_Play.Hero;

public class BossFight extends Fight{
    private Boss enemy;

    public BossFight(Hero thePlayer) {
        super(thePlayer);
        
        int random = (int)((Math.random()*2));
        switch(random) {
            case 0 : enemy = new Bramzark();break;
            case 1 : enemy = new TheUnknown();break;
            default : enemy = new TheUnknown();break;
        }
        setEnemyHP(enemy.getHP());
        setPlayerFirst(firstMove());

        System.out.println(enemy.encounterMessage());

        if (getPlayerFirst()) {
            playerTurn();
        } else {
            enemyTurn();
        }
    }
    
    public Boss getEnemy() {
        return enemy;
    }

    @Override
    public void enemyTurn() {

        System.out.println("The enemy approaches...\n");
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
