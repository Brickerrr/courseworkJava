package Character;
import java.util.*;

public class OwnHero{

    private double armor;
    private double magResistance;
    private double attackSpeed;
    private double stealth;
    private double movementSpeed;
    double demage;

    ArrayList<Integer> arr= new ArrayList<Integer>() ;
    ArrayList<String> arrNameStat = new ArrayList<String>();
    ArrayList<Integer> arrStat = new ArrayList<Integer>();
    private double[]stat=new double[13];
    int x =7;


    public void OwnHero(){
        Random random = new Random();
        for(int i =0; i < 7; i++) {
            int roll = random.nextInt(20) + 1;
            arr.add(roll);
            System.out.println("You rolled "+roll);
        }

        arrNameStat.add("Strength");
        arrNameStat.add("Resistance");
        arrNameStat.add("Dexterity");
        arrNameStat.add("Intelligence");
        arrNameStat.add("Charisma");
        arrNameStat.add("Endurance");
        arrNameStat.add("Health");

        for (int y =0;y<7;y++){
            arrStat.add(0);
        }





        Stats();

    }
    //************************************************************************************************
    //change it around
    //rather then asking for stat to choose for that value
    // ask for value to choose for that stat
    //************************************************************************************************
    public void Stats(){

        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 7; i++) {
            System.out.println("Which value do you want to set to "+arrNameStat.get(i));
            for (int j = 0; j <x;j++) {
                System.out.println(j + " " + arr.get(j));

            }
            x--;

            boolean erorCatcher= true;

            while(erorCatcher==true) {
                int choice = sc.nextInt();
                if (choice <= x) {
                    arrStat.set(i, arr.get(choice));
                    arr.remove(choice);
                    erorCatcher=false;

                } else {
                    System.out.println("Invalid choice");
                    erorCatcher=true;
                }
            }





        }
        printStats();




    }

    public void printStats(){

        for (int z=0; z <arrNameStat.size(); z++) {
            System.out.println("these are your stats " +arrNameStat.get(z)+" " + arrStat.get(z) );



        }
        setSpecialization();
    }
    public void setSpecialization(){
        System.out.println("Proseesion Knight: Armor= 15,Mag Resistnace = 5, Attack speed = 9, Stealth = 3, movment speed=7, demage =12 ");
        System.out.println("Proseesion Healer Armor= 15,Mag Resistnace = 15, Attack speed = 5, Stealth = 10, movment speed=18, demage =8 ");
        System.out.println("Proseesion Rogue: Armor= 8,Mag Resistnace = 7, Attack speed = 13, Stealth = 18, movment speed=16, demage =15 ");
        System.out.println("Which proffesion do you want to be?1)Knight,2)Healer,3)Rogue");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                armor = 15;
                magResistance =5 ;
                attackSpeed = 9;
                stealth = 3;
                movementSpeed =7;
                demage=12;



                break;
            case 2:
                armor = 15;
                magResistance = 15;
                attackSpeed =5 ;
                stealth =10 ;
                movementSpeed =18;
                demage=8;
                break;
            case 3:
                armor = 8;
                magResistance =7 ;
                attackSpeed = 13;
                stealth = 18;
                movementSpeed =16;
                demage=15;
                break;

            default:
                System.out.println("Inavlid Choice");
                break;
        }




    }
    public double setOwnStats( int code){
        stat [0]=arrStat.get(0);
        stat [1]=arrStat.get(1);
        stat [2]=arrStat.get(2);
        stat [3]=arrStat.get(3);
        stat [4]=arrStat.get(4);
        stat [5]=arrStat.get(5);
        stat [6]=arrStat.get(6);
        stat [7]=armor;
        stat [8]=magResistance;
        stat [9]=attackSpeed;
        stat [10]=stealth;
        stat [11]=movementSpeed;
        stat [12]=demage;

        return stat[code];


    }


}
