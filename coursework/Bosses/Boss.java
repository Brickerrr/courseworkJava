package Bosses;
public class Boss{

    // Main Boss Details. 
    protected String name;
    protected double HP; 
    protected double minAttack;
    protected double maxAttack;
    protected double movementSpeed;

    //Item Drops. 
    protected String commonDrop;
    protected String rareDrop;
    protected String legendaryDrop;
    protected int randomGoldDrop;

    //Fields for attack cycle. Both names and attack range.
    protected String attackOne;
    protected String attackTwo;
    protected String specialAttack;
    protected int attackRange;

    //Fields for Dialogue.
    protected int randomDialogueGen;
    protected String dialogueOne;
    protected String dialogueTwo;
    protected String dialogueThree;


    //Getters. 
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

    //added by finlay
    public double getSpeed() {
        return movementSpeed;
    }


    //Setters. 
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
        minAttack = aMaxAttack;
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

    public void setMovementSpeed(double aMovementSpeed){
        movementSpeed = aMovementSpeed;
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
    
    
    // Method Responisble for randomly determining item drop. 
    public String death(){
        String itemDrop = "";
         //Dice Roll for random Item Drop after enemy Death.
        int randomItemDrop = (int)(Math.random()*100)+1;
      
        if (randomItemDrop <= 65) {
            randomGoldDrop = (int)(Math.random()*30)+1;
            itemDrop = "You've Killed the " + getName() + "\n" + 
                    " Items dropped: " + commonDrop + " (Common Item) and " + "\n" + randomGoldDrop + " Gold";          

        } else  if (randomItemDrop > 65 && randomItemDrop <= 90){
            randomGoldDrop = (int)(Math.random()*45)+1;
            itemDrop = "You've Killed the " + getName() + "\n" + 
                                " Items dropped: " + rareDrop + " (Rare Item) and " + "\n" + randomGoldDrop + " Gold";            
        
        } else if (randomItemDrop > 90) {
            randomGoldDrop = (int)(Math.random()*60)+1;
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
        String bossDetails = "";

        bossDetails+= "name: " + name + "\n";
        bossDetails+= "HP: " + HP + "\n";
        bossDetails+= "Minimum Attack Power: " + minAttack + " Maximum Attack Power: " + maxAttack + "\n";
        bossDetails+= "Movement Speed: " + movementSpeed + "\n"; 
        bossDetails+= "Item Drops: Common: " + commonDrop + "\n" + " Rare: " + rareDrop + "\n" + " Legenndary: " + legendaryDrop + "\n";
        bossDetails+= "Attacks: Regular: " + attackOne + " Heavy: " + attackTwo + " Special: " + specialAttack + "\n";
        bossDetails+= "Dialogue One: " + dialogueOne + "\n";
        bossDetails+= "Dialogue Two: " + dialogueTwo + "\n"; 
        bossDetails+= "Dialogue One: " + dialogueThree + "\n";


        return bossDetails;
    }  
}