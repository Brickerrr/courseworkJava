import java.util.Scanner;

import Game_Play.Hero;
import Game_Play.Weapon;

public abstract class Fight {
    private Hero player;
    private int turn;
    private boolean keepGoing;
    private double playerHP;
    private double enemyHP;
    private boolean playerFirst;

    public Fight(Hero thePlayer) {
        player = thePlayer;
        turn = 1;
        keepGoing = true;
        //playerHP = player.getStat(6);
        playerHP = 9999;
    }

    public Hero getHero() {
        return player;
    }

    public boolean getPlayerFirst() {
        return playerFirst;
    }

    public void setPlayerFirst(boolean check) {
        playerFirst = check;
    }

    public void damagePlayer(double number) {
        playerHP = playerHP - number;
    }

    public void setEnemyHP(double HP) {
        enemyHP = HP;
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

    public abstract void enemyTurn();

    public void playerLoss() {
        stopFight();
        System.out.println("You Died!");
        /*end game */
    }

    public abstract void playerWin();

    public abstract boolean firstMove();
}

