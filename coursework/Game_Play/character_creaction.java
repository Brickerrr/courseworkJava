package Game_Play;
import java.util.Scanner;

import Character.*;

public class character_creaction {


    protected int specialization=1;
    protected int choice;

    public void creation () {
        Scanner sc =new Scanner(System.in);

        int redo = 1;
        int code=0;
        System.out.println("Do you want to create your own hero(0)or choose from premade characters (1)");
        int ownHero = sc.nextInt();

        if (ownHero ==1) {


            do {
                System.out.println("Choose your character:\n1:dwarves\n2:Human\n3:Elves\n4:Orcs\n5:Halflings\n");

                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        Dwarves dwarv = new Dwarves();
                        dwarv.print_stats();
                        System.out.println("Choose your specialization:\n1:warior\n2:druid\n0:redo");
                        this.specialization = sc.nextInt();



                        switch (specialization) {
                            case 1:

                                Warrior w = new Warrior();
                                w.print_stats();
                                System.out.println("Are you happy with your choise:\n1:yes\n0:no(redo)");
                                choice = sc.nextInt();

                                break;
                            case 2:
                                Druid d = new Druid();
                                d.print_stats();
                                System.out.println("Are you happy with your choise:\n1:yes\n0:no(redo)");
                                choice = sc.nextInt();
                                break;
                            case 0:


                                break;
                            default:
                                break;
                        }
                        break;
                    case 2:
                        break;
                    case 3:

                    break;


                    default:
                        break;
                }
            } while (choice == 0);

//
//            Hero createCharacter = new Hero();
//            createCharacter.setHero(choice, specialization,ownHero);


        }else if(ownHero==0){
            OwnHero createHero = new OwnHero();
            createHero.OwnHero();

        }




    }


}
