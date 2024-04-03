
import Game_Play.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {




        Hero hero = new Hero();
        for (int i = 0; i <= 12; i++) {
            System.out.println(hero.getStat(i));

        }
        //changig stats and getting stats
        //when changig the health or any other stats after battle don put in the new hp but put hpw much deamge the hero has taken becouse
        // the way it is coded is that we add the value ther so hp+= demage_taken
        hero.statModifyAdd(0, 1.5);
        System.out.println("stat 0"+hero.getStat(0));

        // Money pouch modify get
        hero.modifyMoneyPouch(0, -20);
        System.out.println("Money Gold"+hero.getMoneyPouch(0));


        //Inventory and weapon creation
        hero.modifyInventory(20);
        System.out.println(hero.getStat(12));


        hero.exchange("Gold","Bronze",100);


    }
}


//TODO: Add comments and javadoc to each class