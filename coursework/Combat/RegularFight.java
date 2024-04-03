import java.util.Scanner;

import Game_Play.*;
import Regular_Enemies.*;

public class RegularFight extends Fight {
    private Monster enemy;

    public RegularFight(Hero thePlayer) {
        super(thePlayer);
        
        int random = (int)((Math.random()*5));
        switch(random) {
            case 0 : enemy = new Dragon();break;
            case 1 : enemy = new IceGolem();break;
            case 2 : enemy = new Orc(); break;
            case 3 : enemy = new Skeleton(); break;
            case 4 : enemy = new Werewolf(); break;
            default : enemy = new Orc();break;
        }
        setEnemyHP(enemy.getHP());
        setPlayerFirst(firstMove());

        enemy.creatureForm();
        System.out.println(enemy.encounterMessage());

        if (getPlayerFirst()) {
            playerTurn();
        } else {
            enemyTurn();
        }
    }

    public Monster getEnemy(){
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
