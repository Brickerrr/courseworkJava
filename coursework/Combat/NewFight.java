import Game_Play.*;
import Regular_Enemies.*;
import java.util.*;
import Character.*;

public class NewFight {
    private Hero player;
    private Monster enemy;
    private int turn;
    private boolean keepGoing;
    private double playerHP;
    private double enemyHP;
    private boolean playerFirst;

    public NewFight(Hero aHero) {
        player = aHero;
        int random = (int)((Math.random()*5));
        switch(random) {
            case 0 : enemy = new Dragon();break;
            case 1 : enemy = new IceGolem();break;
            case 2 : enemy = new Orc(); break;
            case 3 : enemy = new Skeleton(); break;
            case 4 : enemy = new Werewolf(); break;
            default : enemy = new Orc();break;
        }
        turn = 1;
        keepGoing = true;
        playerHP = player.getStat(6);
        enemyHP = enemy.getHP();
        playerFirst = firstMove();
        //
        enemy.creatureForm();
        System.out.println(enemy.encounterMessage());

        if (playerFirst) {
            playerTurn();
        } else {
            enemyTurn();
        }
    }
    //
    public Monster getEnemy() {
        return enemy;
    }

    public Hero getHero() {
        return player;
    }

    public void playerTurn(){ 
        int choice = 0;
        boolean check = false;
        
        while (!check) {
            Scanner choose = new Scanner(System.in);
            System.out.println("HP: " + getPlayerHP() + "  |  EnemyHP: "+ getEnemyHP() + " \n1. Fight\n2. Inventory\n3. Run");
            choice =choose.nextInt();

            switch(choice) {
                case 1: System.out.println("Fight Selected"); check= true;fightOption(); break;
                case 2: System.out.println("Inventory Selected"); check=true;inventoryOption(); break;
                case 3: System.out.println("Run Selected"); check=true;runOption(); break;
                default: System.out.println("please input a valid option (1,2,3)");
            }
        }
    }

    public void fightOption() {
        //*calc damage and apply to enemy */
        double damage = 0;
        int bestStat = 0;

        for(int i =0; i <3 ; i++) {
            if(player.getStat(i) > player.getStat(bestStat)) {
                bestStat = i;
            }
        }

        switch(bestStat) {
            case 0: System.out.println("You use your muscle to attack the enemy");break;
            case 1: System.out.println("You use your skill and agility to attack the enemy");break;
            case 2: System.out.println("You use a magical attack on the enemy");break;
        }

        double d20Roll = (int)((Math.random()*20)+1);
        damage = (int) (player.getStat(bestStat)/2) + (int)((Math.random()*6)+4) + (int) (d20Roll/3);
        
        if(d20Roll == 20 ) {
            System.out.println("Critcal Hit!");
            damage = damage * 2;
        }

        System.out.println("You dealt " + damage + " damage to the enemy!");

        enemyHP = getEnemyHP() - damage;

        //*initialise player win if enemy hp drops below 0*/
        if (getEnemyHP() <=0) {
            playerWin();
        } else {
            if(playerFirst == false) {
                incrementTurn();
            }
            enemyTurn();
            
        }
        
        
    }

    public void runOption() {
        if (playerFirst) {
            stopFight();
            System.out.println("You ran away sucessfully");
        } else {
            enemyTurn();
        }
    }

    public void inventoryOption() {
        //*open inventory */
        int numberPotions = 0;
        for (Weapon weapon: player.getInventory()) {
            if (weapon.getWeaponName() == "Health Potion") {
                numberPotions++;
            }
        }
        Scanner potion = new Scanner(System.in);
        System.out.println("You have " + numberPotions + " potions, would you like to use one?(1 = yes, 2 = no): ");
        int choice = potion.nextInt();
        //need to find a way to remove from inventory
        switch(choice) {
            case 1: playerHP = getPlayerHP() + 15; if(getPlayerHP() > player.getStat(6)) { playerHP = player.getStat(6);};System.out.println("You used the health potion restoring 15 HP!\n"); playerTurn(); break;
            case 2: System.out.println("You decided not to use a health potion"); playerTurn(); break;
        }
    }

    public void incrementTurn() {
        turn = turn + 1;
    }

    public int getTurn() {
        return turn;
    }

    public double getEnemyHP() {
        return enemyHP;
    }

    public double getPlayerHP() {
        return playerHP;
    }

    public void stopFight() {
        keepGoing = false;
    }

    public boolean getIfGoing() {
        return keepGoing;
    }

    public void enemyTurn() {

        System.out.println("The enemy approaches...\n");
        double damage = enemy.attack();
        System.out.println("the enemy dealt " + damage + " damage");
        damage = (int)(damage)-(int)((player.getStat(7) + player.getStat(8))*0.15);

        //stops hp being added to player when attacked if enemies' attack is too weak
        if(damage <0) {
            damage = 0;
        }

        System.out.println( "Damage reduced to " + damage);

        playerHP = getPlayerHP() - damage;

        if (getPlayerHP() <=0) {
            playerLoss();
        } else {
            if(playerFirst == true) {
                incrementTurn();
            }
            playerTurn();
        }
    }

    public void playerLoss() {
        stopFight();
        System.out.println("You Died!");
        /*end game */
    }

    public void playerWin() {
        stopFight();
        System.out.println("The enemy was defeated! \n");
        Scanner drop = new Scanner(System.in);
        System.out.println(getEnemy().death());

        int index = drop.nextInt();
        player.modifyInventory(index);
         
    }

    public boolean firstMove() {
        if (player.getStat(11) >= enemy.getSpeed()) {
            return true;
        } else {
            return false;
        }
    }
}