package Regular_Enemies;
import java.util.*;


public class Monster{

    // Main monster Details. 
    private String race;
    private String name;
    private double HP; 
    private double minAttack;
    private double maxAttack;
    private double movementSpeed;

    //Elite Names. 
    private String bossNameOne;
    private String bossNameTwo;
    private String bossNameThree;

    //Item Drops. 
    private String commonDrop;
    private String rareDrop;
    private String legendaryDrop;
    private int randomGoldDrop;

    //Fields for Rarity creature Generator. 
    private int randomCreatureGen;
    private String bossNameGen;

    //Fields for attack cycle. Both names and attack range. 
    private String attackOne;
    private String attackTwo;
    private String specialAttack;
    private int attackRange;

    //Fields for Dialogue.
    protected int randomDialogueGen;
    protected String dialogueOne;
    protected String dialogueTwo;
    protected String dialogueThree;



    // Getters.
    public String getRace(){
        return race;
    }

    public String getName(){
        return name;
    }

    public double getHP(){
        return HP;
    }

    public double getMinAttack(){
        return minAttack;
    }

    public double getMaxAttack(){
        return maxAttack;
    }

    /* added by me */
    public double getSpeed() {
        return movementSpeed;
    }

    public String getBossNameOne(){
        return bossNameOne;
    }

    public String getBossNameTwo(){
        return bossNameTwo;
    }

    public String getBossNameThree(){
        return bossNameThree;
    }

    public String getItemDrops(){
        String itemDrops = "Common Drop: " + commonDrop + " Rare Drop: " + rareDrop + " Legendary Drop: " + legendaryDrop;
        return itemDrops;
    }

    public String getAttackNames(){
        String attackNames = "Basic Attack: " + attackOne + " Heavy Attack: " + attackTwo + " Special Attack: " + specialAttack;
        return attackNames;
    }

    public String getDialogueOne() {
        return dialogueOne;
    }

    public String getDialogueTwo() {
        return dialogueTwo;
    }

    public String getDialogueThree() {
        return dialogueThree;
    }


    //Setters.
    public void setRace(String aRace){
        race = aRace;
    }

    public void setName(String aName){
        name = aName;
    }

    public void setHP(double aHP){
        HP = aHP;
    }

    public void setMinAttack(double aMinAttack){
        minAttack = aMinAttack;
    }

    public void setMaxAttack(double aMaxAttack){
        maxAttack = aMaxAttack;
    }

    public void setMovementSpeed(double aMovementSpeed){
        movementSpeed = aMovementSpeed;
    }

    public void setAttackNames(String aAttackOne, String aAttackTwo, String aSpecialAttack){
        attackOne = aAttackOne;
        attackTwo = aAttackTwo;
        specialAttack = aSpecialAttack;
    }

    public void setItemDrops(String aCommonDrop, String aRareDrop, String aLegendaryDrop){
        commonDrop = aCommonDrop;
        rareDrop = aRareDrop;
        legendaryDrop = aLegendaryDrop;
    }

    public void setEliteNames(String aBossNameOne, String aBossNameTwo, String aBossNameThree){
        bossNameOne = aBossNameOne;
        bossNameTwo = aBossNameTwo;
        bossNameThree = aBossNameThree;
    }

    public void setDialogueOne(String dialogueOne) {
        this.dialogueOne = dialogueOne;
    }

    public void setDialogueTwo(String dialogueTwo) {
        this.dialogueTwo = dialogueTwo;
    }

    public void setDialogueThree(String dialogueThree) {
        this.dialogueThree = dialogueThree;
    }


    //Other Methods:

    // Encounter Message - will display Name, HP and Attack Power.
    public String encounterMessage(){
        String encounter = "";
        encounter += "You've encountered: " + getName() + "\n";
        encounter += dialogue() + "\n";
        encounter += "They have: " + getHP() + " HP." + "\n";
        encounter += "Minimum Attack Power: " + getMinAttack() + "\n"; 
        encounter += "Maximum Attack Power: " + getMaxAttack() + "\n"; 

        return encounter;
    }


    //Method for generating Random Dialogue.
    public String dialogue(){
        randomDialogueGen = (int)(Math.random()*3)+1;
        String dialogueOutput = "";

        if (randomDialogueGen == 1){
            dialogueOutput = dialogueOne;

        } else if (randomDialogueGen == 2){
            dialogueOutput = dialogueTwo;

        } else {
            dialogueOutput = dialogueThree;
        } 
        
        return dialogueOutput;
    }


    // Method for determining wether a Common or Rare Enemy Spawns. 
    // This Method will also return whether a Boss or a Regular enemy is encountered.  
    public String creatureForm(){
        randomCreatureGen = (int)(Math.random()*100)+1;
        Random random = new Random();

        //Gereates a Random Boss name - Add Some Variety to the Game.
        if (randomCreatureGen >= 85) {
            String[] bossNames = {bossNameOne, bossNameTwo, bossNameThree}; 
            bossNameGen = bossNames[random.nextInt(bossNames.length)];
            // Stats For the Boss. 
            this.HP = HP + 40;
            this.minAttack = minAttack + 8;
            this.minAttack = minAttack + 8; 

            // String output for elite encounter. 
           name = bossNameGen + " (" + race + " Elite)!";

        } else {

            // String output for regular encounter. 
            name =  "a " + race;
        }

        return name;
    }


    // Method Responisble for randomly determining item drop. 
    public String death(){
        String itemDrop = "";
        //Dice Roll for random Item Drop after enemy Death.
        int randomItemDrop = (int)(Math.random()*100)+1;
      
        //Regular Enemy Item Drops.
        if (randomItemDrop <= 65 && !(randomCreatureGen >= 85)) {
            randomGoldDrop = (int)(Math.random()*20)+1;
            itemDrop = "You've Killed the " + getName() + "\n" + 
                    " Items dropped: " + commonDrop + " (Common Item) and " + "\n" + randomGoldDrop + " Gold";        

        } else  if (randomItemDrop > 65 && !(randomCreatureGen >= 85)){
            randomGoldDrop = (int)(Math.random()*30)+1;
            itemDrop = "You've Killed the " + getName() + "\n" + 
                                " Items dropped: " + rareDrop + " (Rare Item) and " + "\n" + randomGoldDrop + " Gold";            
        
        // Boss Item Drops. 
        // Note: Common and Rare items repeated, since bosses drop more Gold too.
        } else if (randomItemDrop <= 60  && randomCreatureGen >= 85) {
            randomGoldDrop = (int)(Math.random()*45)+1;
            itemDrop = "You've Killed " + getName() + "\n" + 
                                " Items dropped: " + commonDrop + " (Common Item) and " + "\n" + randomGoldDrop + " Gold";  
    
        } else if (randomItemDrop > 60 && randomItemDrop < 85 && randomCreatureGen >= 85) {
            randomGoldDrop = (int)(Math.random()*75)+1;
            itemDrop = "You've Killed " + getName() + "\n" + 
                                " Items dropped: " + rareDrop + " (Rare Item) and " + "\n" + randomGoldDrop + " Gold";
        
        } else if (randomItemDrop > 85 && randomCreatureGen >= 85) {
            randomGoldDrop = (int)(Math.random()*100)+1;
            itemDrop = "You've Killed " + getName() + "\n" + 
                                " Items dropped: " + legendaryDrop + " (Legendary Item) and " + "\n" + randomGoldDrop + " Gold";  
        }

        return itemDrop;
    }    


    // Method for Different Attacks. 
    public double attack(){
        //Dice roll for generating a random attack. 
        int randomAttackGen = (int)(Math.random()*10)+1;

        //Block for Regular Attack.
        if (randomAttackGen > 1 && randomAttackGen < 6) {
            attackRange = (int)(Math.random()*(this.minAttack-this.maxAttack+1)+this.minAttack);
            System.out.println("Enemy used: " + attackOne + "\n" 
                                + " They dealt: " + attackRange + " Damage." + "\n"); 

        //Block for Heavy Attack.                  
        } else if (randomAttackGen > 5 && randomAttackGen < 10) {
            attackRange = (int)(Math.random()*(this.minAttack-this.maxAttack+1)+this.minAttack+2);
            System.out.println("Enemy used: " + attackTwo + "\n" + 
                                " They dealt: " + attackRange + " Damage." + "\n");
           
        //Block for Special Attack.
        } else if (randomAttackGen == 10) {
            attackRange = (int)(Math.random()*(this.minAttack-this.maxAttack+1)+this.minAttack+3);
            System.out.println("Enemy used: " + specialAttack + "\n" +
                                 "They dealt: " + attackRange + " Damage." + "\n");              
        }   

        return attackRange;     
    }  

    //toString Method.
    public String toString() {
        String enemyDetails = "";

        enemyDetails+= "NSame: " + name + "\n";
        enemyDetails+= "HP: " + HP + "\n";
        enemyDetails+= "Minimum Attack Power: " + minAttack + " Maximum Attack Power: " + maxAttack + "\n";
        enemyDetails+= "Movement Speed: " + movementSpeed + "\n"; 
        enemyDetails+= "Boss Names: " + bossNameOne + ", " + bossNameTwo + ", " + bossNameThree + "\n";
        enemyDetails+= "Item Drops: Common: " + commonDrop + "\n" + "Rare: " + rareDrop + "\n" + "Legendary: " + legendaryDrop + "\n";
        enemyDetails+= "Attacks: Regular: " + attackOne + " Heavy: " + attackTwo + " Special: " + specialAttack + "\n";
        enemyDetails+= "Dialogue One: " + dialogueOne + "\n";
        enemyDetails+= "Dialogue Two: " + dialogueTwo + "\n"; 
        enemyDetails+= "Dialogue One: " + dialogueThree + "\n";


        return enemyDetails;
    }
}