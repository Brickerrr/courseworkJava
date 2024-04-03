package Game_Play;
import Character.Druid;
import Character.Warrior;
import Character.*;
import java.util.*;

/**
 * @author Matus Illith ID:2325478
 * @version final version, 11/03/2024
 *
 * <p>This class ins the hub of interacting with the  character classes and any other class</p>
 * <p> Here we create our Hero and set stats</p>
 * <p>Through this class/object we will get every stat we need modify inventory change stat...</p>
 * */


public class Hero{


/**
 *
 *<p>all the private fields are here</p>
 * @param ownHero <p>is when we want to choose from pre-made characters int 1 is for pre-made 0 is for creating our own.</p>
 * @param choice <p>when we choose from pre-made character we have a choice of Dwarfe-1,Halfling-2,Human-3</p>
 * @param specialization each of these pre-made character has their own specilaiyation which modify the stats further
 * @param stat[] <p>this array holds all the stats that hero gets</p>
 * @param moneyPouch[] <p>this array holds all the info on money</p>
 * @param Inventory is a array list of objects weapons each weapon changes the stats
 *
 * */
    private int ownHero;
    private int specialization;
    private int choice;



    private double []stat= new double[13];
    private int[]moneyPouch= new int[3];
    private String name;
    ArrayList<Weapon> Inventory = new ArrayList<Weapon>();
    private final Map<String, Double> exchangeRates=new HashMap<>();


    //calling this function when we are creating the character
    //to define what type of character we have
    /**
     * @constructor <p> Constructor for hero class has part of the gameplay. In the constructor we ask user to create a character.
     * and we call method setStats which sets the fields accordingly </p>
     * */
    public Hero(){
        Scanner sc =new Scanner(System.in);

        int redo = 1;
        int code=0;
        System.out.println("Do you want to create your own hero(0)or choose from premade characters (1)");
        ownHero = sc.nextInt();

        if (ownHero ==1) {


            do {
                System.out.println("Choose your character:\n1:dwarves\n2:Halflings\n3:Human");

                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        Dwarves dwarv = new Dwarves();
                        dwarv.print_stats();
                        System.out.println("Choose your specialization:\n1:warior\n2:druid");
                        this.specialization = sc.nextInt();



                        switch (specialization) {
                            case 1:

                                Warrior w = new Warrior();
                                w.print_stats();
                                System.out.println("Are you happy with your choise:\n1:yes\n0:no(redo)");
                                redo = sc.nextInt();

                                break;
                            case 2:
                                Druid d = new Druid();
                                d.print_stats();
                                System.out.println("Are you happy with your choise:\n1:yes\n0:no(redo)");
                                redo = sc.nextInt();
                                break;
                            case 0:


                                break;
                            default:
                                System.out.println("Invalid choice");
                                break;
                        }
                        break;
                    case 2:
                        Halflings halfling=new Halflings();
                        halfling.print_stats();
                        System.out.println("Choose your specialization:\n1:Thief\n2:UmpaLumpa\n0:redo");
                        this.specialization = sc.nextInt();
                        switch (specialization) {
                            case 1:
                                Thief thief = new Thief();
                                thief.print_stats();
                                System.out.println("Are you happy with your choise:\n1:yes\n0:no(redo)");
                                redo = sc.nextInt();
                            break;

                            case 2:
                                UmpaLumpa umpalumpa = new UmpaLumpa();
                                umpalumpa.print_stats();
                                System.out.println("Are you happy with your choise:\n1:yes\n0:no(redo)");
                                redo = sc.nextInt();
                                break;
                            default:
                                System.out.println("Invalid choice");

                                break;

                        }
                        break;
                    case 3:
                        Human human=new Human();
                        human.print_stats();
                        System.out.println("Choose your specialization:\n1:Knight\n2:Bard\n0:redo");
                        this.specialization = sc.nextInt();
                        switch (specialization){
                            case 1:
                                Knight knight=new Knight();
                                knight.print_stats();
                                System.out.println("Are you happy with your choise:\n1:yes\n0:no(redo)");
                                redo = sc.nextInt();
                                break;
                            case 2:
                                Bard bard= new Bard();
                                bard.print_stats();
                                System.out.println("Are you happy with your choise:\n1:yes\n0:no(redo)");
                                redo = sc.nextInt();
                                break;
                            default:
                                System.out.println("Invalid choice");

                                break;
                        }



                        break;


                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            } while (redo == 0);


           setStats();


        }else if(ownHero==0){

            setStats();

        }




    }



/**
 * @method setStats
 * <p>In setStats method we set the name of the hero and add values to the fields which we declared earlier</p>
 * <p> Also when we want to create own hero we call the class class OwnHero from this method which will gives us options. and we set stats for own hero here also</p>
 *<p>At the end of the method we call setInventory method which sets all the diferent weapons we have</p>
 * */


    public double setStats() {
        Scanner sc = new Scanner(System.in);

        System.out.println("What is your name Hero?");

        name = sc.nextLine();

        switch (ownHero) {

            case 1:
                if(choice==1) {

                    switch (specialization) {
                        case 1:
                            System.out.println("Druid");

                            Warrior heroWarrior = new Warrior();
                            //remove later// for testing
                            for (int i = 0; i <= 12; i++) {
                                stat[i] = heroWarrior.stat(i);
                            }


                            break;


                        case 2:
                            System.out.println("Druid");
                            Druid heroDruid = new Druid();
                            for (int i = 0; i <= 12; i++) {
                                stat[i] = heroDruid.stat(i);
                            }


                            break;


                        default:
                            break;
                    }
                }

                if(choice ==2) {

                    switch (specialization) {
                        case 1:
                            System.out.println("Thief");
                            Thief heroThief = new Thief();
                            for (int i = 0; i <= 12; i++) {
                                stat[i] = heroThief.stat(i);
                            }

                            break;

                        case 2:
                            System.out.println("UmpaLumpa");
                            UmpaLumpa heroUmpaLumpa = new UmpaLumpa();
                            for (int i = 0; i <= 12; i++) {
                                stat[i] = heroUmpaLumpa.stat(i);
                            }
                            break;
                        default:
                            break;
                    }
                }
                if(choice==3) {
                    switch (specialization) {
                        case 1:
                            System.out.println("Knight");
                            Knight heroKnight = new Knight();
                            for (int i = 0; i <= 12; i++) {
                                stat[i] = heroKnight.stat(i);
                            }
                            break;

                        case 2:
                            System.out.println("Bard");
                            Bard heroBard = new Bard();
                            for (int i = 0; i <= 12; i++) {
                                stat[i] = heroBard.stat(i);
                            }
                            for (int i = 0; i <= 2; i++) {
                                moneyPouch[i] = 10;
                            }
                            break;
                        default:
                            break;

                    }
                }
                        break;

            case 0:

                OwnHero createHero = new OwnHero();
                createHero.OwnHero();
                for(int i = 0; i <=12; i++) {
                    stat[i]=createHero.setOwnStats(i);
                }

                break;



        }
        exchangeRates.put("Gold", 1.0);
        exchangeRates.put("Silver", 10.0);
        exchangeRates.put("Copper", 100.0);
        exchangeRates.put("Bronze", 1000.0);

        setInventory();
        return 0;
    }

/**
 * {@code @method}
 *
 *  */

    public double getStat(int index){


        return stat[index] ;
    }

    public void statModifyAdd(int code,double value){

            stat[code] += value;


    }

    public void modifyMoneyPouch(int code,int value){
        moneyPouch[code] += value;


    }
    public int getMoneyPouch(int code){

        return moneyPouch[code];
    }

    public ArrayList<Weapon> getInventory() {
        return Inventory;
    }

    public void setInventory(){
        Inventory.add(new Weapon("NUll",0,0));
        Inventory.add(new Weapon("Spork",12,2.5));

        Inventory.add(new Weapon("Rusty Sword",12,2));
        Inventory.add(new Weapon("Necromancer's Staff",4,4));
        Inventory.add(new Weapon("Nostoro's Skeletal Axe",12,6));

        Inventory.add(new Weapon("Wolf-Skull Mace",0,2));
        Inventory.add(new Weapon("Wolf Pelt Armour",7,5));
        Inventory.add(new Weapon("Ophelia's Claw Rapier",1,8));

        Inventory.add(new Weapon("Bonewalker Boots",11,2));
        Inventory.add(new Weapon("Sturdy Iron Shield",7,7));
        Inventory.add(new Weapon("Byzular's Spiked Club",12,8));

        Inventory.add(new Weapon("Dragon Scale Gloves",3,6));
        Inventory.add(new Weapon("Dragon Tooth Club",12,8));
        Inventory.add(new Weapon("Quelii's Elven Bow",11,12));
        Inventory.add(new Weapon("Health Potion",6,15));

        Inventory.add(new Weapon("Ice Hammer",0,4));
        Inventory.add(new Weapon("Frozen Ring",10,8));
        Inventory.add(new Weapon("Ijik's Ice Crown",8,10));

        Inventory.add(new Weapon("Oolak's Ring",5,6));
        Inventory.add(new Weapon("Azzak's Demon Staff",2,10));
        Inventory.add(new Weapon("Demon Lord Armour",7,15));

        Inventory.add(new Weapon("Thief's Ring",10,6));
        Inventory.add(new Weapon("Irrilian Staff",2,10));
        Inventory.add(new Weapon("Olko's Twin Daggers",9,15));


    }
    public void modifyInventory(int code){
        if(code==0){
            System.out.println("You choose to not pick the weapon");
        }else{
            statModifyAdd(Inventory.get(code).getStatCode(),Inventory.get(code).getStatModifier());
            System.out.println("You picked up the weapon");
        }



    }

 public void exchange(String currencyOne,String currencyTwo,double amount){


        double amountGold= amount/exchangeRates.get(currencyOne);
        double convert= amountGold*exchangeRates.get(currencyTwo);
        System.out.println(amount+" in "+currencyOne+" is "+convert+" in "+currencyTwo);


 }




}

