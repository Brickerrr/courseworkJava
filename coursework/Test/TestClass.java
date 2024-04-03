package Test;
import java.util.*;
import Regular_Enemies.*;
import Bosses.*;

public class TestClass{

    
    public static void main(String[] args) {

        int replay; 

        //Creating Player.
        PlayerTest pl1 = new PlayerTest();
        double playerHP = pl1.getHP(); 


        // Creating the Dragon.
        Dragon en1 = new Dragon();
        //Calling creatureForm() so there's a chance that an Elite will spawn.
        en1.creatureForm();
        System.out.println(en1.encounterMessage());
        double enemyHP = en1.getHP();

        //Battle One:
        do{ 
            Scanner in = new Scanner(System.in);

            int diceRoll = (int)(Math.random()*6)+1;
            int diceRollTwo = (int)(Math.random()*6)+1;
            System.out.println("The Enemy Rolled: " + diceRoll); 
            System.out.println("The Player Rolled: " + diceRollTwo + "\n");

    
            if (diceRoll > diceRollTwo){
                playerHP -= en1.attack();
                System.out.println("Player HP: " + playerHP);
        
            } else if (diceRollTwo > diceRoll) {
                enemyHP -= pl1.attack();
                System.out.println("Enemy HP: " + enemyHP);
            }
            
            if (enemyHP <= 0){
                System.out.println(en1.death());
            } 
         
            do{
                System.out.println("Type '1'to Roll Again or '0' to Quit.");
                replay = in.nextInt(); 

                if (replay !=0 && replay !=1){
                    System.out.println("Invalid Input.");
                }

            } while (replay !=0 && replay !=1);
        } while (enemyHP > 0 && playerHP > 0);


        System.out.println("Battle Over." + "\n" + "\n"); 



        // Creating the Orc.
        Orc en2 = new Orc();
        //Calling creatureForm() so there's a chance that an Elite will spawn.
        en2.creatureForm();
        System.out.println(en2.encounterMessage());
        enemyHP = en2.getHP();

        //Battle Two:
        do{ 
            Scanner in = new Scanner(System.in);

            int diceRoll = (int)(Math.random()*6)+1;
            int diceRollTwo = (int)(Math.random()*6)+1;
            System.out.println("The Enemy Rolled: " + diceRoll); 
            System.out.println("The Player Rolled: " + diceRollTwo + "\n");

    
            if (diceRoll > diceRollTwo){
                playerHP -= en2.attack();
                System.out.println("Player HP: " + playerHP);
              
        
            } else if (diceRollTwo > diceRoll) {
                enemyHP -= pl1.attack();
                System.out.println("Enemy HP: " + enemyHP);   
            }
            
            if (enemyHP <= 0){
                System.out.println(en2.death());
            } 
         

            do{
                System.out.println("Type '1'to Roll Again or '0' to Quit.");
                replay = in.nextInt(); 

                if (replay !=0 && replay !=1){
                    System.out.println("Invalid Input.");
                }

            } while (replay !=0 && replay !=1);
        } while (enemyHP > 0 && playerHP > 0);


        System.out.println("Battle Over." + "\n" + "\n"); 
    

    
        //Creating the Boss The Unknown. 
        TheUnknown tn1 = new TheUnknown();
        System.out.println(tn1.encounterMessage());
        enemyHP = tn1.getHP();

        //Boss Battle One - The Unknown:
        do{ 
            Scanner in = new Scanner(System.in);

            int diceRoll = (int)(Math.random()*6)+1;
            int diceRollTwo = (int)(Math.random()*6)+1;
            System.out.println("The Enemy Rolled: " + diceRoll); 
            System.out.println("The Player Rolled: " + diceRollTwo + "\n");


            // If enemy Rolls Higher. 
            if (diceRoll > diceRollTwo){
                if (enemyHP < 150){
                    enemyHP += tn1.specialHealthRegen();
                    playerHP -= tn1.specialDoubleAttack();
                    System.out.println("Player HP: " + playerHP);
                    
                } else {
                    playerHP -= tn1.attack();
                    System.out.println("Player HP: " + playerHP);   
                }
            
            // If player Rolls Higher. 
            } else if (diceRollTwo > diceRoll) {
                enemyHP -= pl1.attack();
                System.out.println("Enemy HP: " + enemyHP);   
            }
            
            if (enemyHP <= 0){
                System.out.println(tn1.death());
            } 
        

            do{
                System.out.println("Type '1'to Roll Again or '0' to Quit.");
                replay = in.nextInt(); 

                if (replay !=0 && replay !=1){
                    System.out.println("Invalid Input.");
                }

            } while (replay !=0 && replay !=1);
        } while (enemyHP > 0 && playerHP > 0);

        System.out.println("Battle Over." + "\n" + "\n");




        //Creating the Boss Bramzark. 
        Bramzark br1 = new Bramzark();
        System.out.println(br1.encounterMessage());
        enemyHP = br1.getHP();

        // Boolean for one of the bosses abilities so that it's single use. 
        boolean abilityUsed = false;


        //Boss Battle Two - Bramzark:
        do{ 
            Scanner in = new Scanner(System.in);

            int diceRoll = (int)(Math.random()*6)+1;
            int diceRollTwo = (int)(Math.random()*6)+1;
            System.out.println("The Enemy Rolled: " + diceRoll); 
            System.out.println("The Player Rolled: " + diceRollTwo + "\n");

            // If Enemy Rolls Higher. 
            if (diceRoll > diceRollTwo){
                if (enemyHP < 200 && abilityUsed == false){
                    abilityUsed = true;
                    enemyHP += br1.specialBerserkerRage();

                    playerHP -= tn1.attack();
                    System.out.println("Player HP: " + playerHP); 

                } else {
                playerHP -= br1.attack();
                System.out.println("Player HP: " + playerHP);
                }
            
            // If Player Rolls Higher.    
            } else if (diceRollTwo > diceRoll) {
                if (enemyHP < 100){
                    playerHP -= br1.specialCounterAssault();
                    System.out.println("Player HP: " + playerHP);

                    enemyHP -= pl1.attack();
                    System.out.println("Enemy HP: " + enemyHP);

                } else {
                    enemyHP -= pl1.attack();
                    System.out.println("Enemy HP: " + enemyHP);
                }  
            }
            
            if (enemyHP <= 0){
                System.out.println(br1.death());
            } 
        

            do{
                System.out.println("Type '1'to Roll Again or '0' to Quit.");
                replay = in.nextInt(); 

                if (replay !=0 && replay !=1){
                    System.out.println("Invalid Input.");
                }

            } while (replay !=0 && replay !=1);
        } while (enemyHP > 0 && playerHP > 0);


        System.out.println("Game Over."); 
    }  
}
