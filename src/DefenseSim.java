/***
 *The class represents the different parts of playing defense. There is an opposing attacker and an attacker
 * defender, and a goalie trying to stop them.
 */
public class DefenseSim{
    private String defender;
    private final String opposingAttacker;
    private String attacker;

    private String goodOutcome;
    private String badOutcome;

    /***
     * Constructors for the DefenseSim class
     * @param userDefender represents the defender on the users team
     * @param computerAttack represents the attacker going against the user
     * @param userAttacker represents the users attack that has to play defense agaisnt the opposing attacker
     */
    public DefenseSim(String userDefender, String computerAttack, String userAttacker){
        defender = userDefender;
        opposingAttacker = computerAttack;
        attacker = userAttacker;
        goodOutcome = "";
        badOutcome = "";
    }

    /***
     * firstCompMove() method which randomly picks a move for the computer
     * @return returns the direction the opposing attacker is moving
     */
    public String firstCompMove(){
        int randomNum = (int) (Math.random()*2) +1;
        if (randomNum == 1){
            return "left";
        }
        return "right";
    }

    /***
     * secondCompMove() method which randomly picks an item from the list to represent a computer skill move
     * @return returns the random move in the list
     */
    public String secondCompMove(){
        String [] moves = {"nutmeg", "the cruyff turn", "stepover"};
        int randomNum = (int) (Math.random()*3);
        return moves[randomNum];
    }

    /***
     * thirdCompMove() method which randomly picks an item from the list to determine where the opposing attacker
     * shoots
     * @return returns the random direction in the list
     */
    public String thirdCompMove(){
        String [] shot = {"Top right", "Top left", "Down the middle", "Right", "Left"};
        int shotPicker =  (int) (Math.random()*5);
        return shot[shotPicker];
    }

    /***
     * firstOutcome method will create a String that contains the outcome of the opposing attacker vs the attacker
     * which will reflect whether the defense was successful or not
     * @param userDirection a string representing which direction the user is defending
     * @return returns the String that represents the outcome
     */
    public String firstOutcome(String userDirection) {
        String compDirect = firstCompMove();
        String firstDefenseOutcome = "";
        if (userDirection.equals(compDirect)) {
            firstDefenseOutcome = opposingAttacker + " goes " + compDirect + "...\nAND GETS THE BALL STOLEN BY " + attacker;
            goodOutcome = firstDefenseOutcome;
        } else {
            firstDefenseOutcome = opposingAttacker + " goes " + compDirect + "\nAND RUNS PAST " + attacker + " HOW INCREDIBLE";
            badOutcome = firstDefenseOutcome;
        }
        return firstDefenseOutcome;
    }

    /***
     * secondOutcomes method will create a String that contains the outcome of opposing attacker vs
     * the user defender which will reflect if the defense was successful or not
     * @param defenseNum an int representing which move the user wants to defense against
     * @return returns the String that represents the outcome
     */
    public String secondOutcomes(Integer defenseNum){
        int randCompNum = (int) (Math.random()*3)+1;
        String compMove = secondCompMove();
        String secondDefenseOutcome = "";
        if (defenseNum == randCompNum){
            secondDefenseOutcome = opposingAttacker + " attempts the " + compMove + " \nBUT " + defender + " IS ABLE TO READ THE MOVE AND TAKE THE BALL";
            goodOutcome = secondDefenseOutcome;
        }
        else{
            secondDefenseOutcome = opposingAttacker + " attempts the " + compMove + "\nAND THEY ARE ABLE TO LOSE THE DEFENDER AND MAKE A RUN TOWARDS THE GOAL";
            badOutcome = secondDefenseOutcome;
        }
        return secondDefenseOutcome;
    }

    /***
     * thirdOutcomes method will create a String that contains the outcome of opposing attacker vs
     * the users goalie which will reflect if a goal is scored or not
     * @param blockNum an int representing which section of the goal the user wants to defense against
     * @return returns the String that represents the outcome
     */
    public String thirdOutcomes (Integer blockNum){
        int blocked = (int) (Math.random() * 5)+1;
        int blocked2 = (int) (Math.random() * 5)+1;
        String thirdDefenseOutcome = "";
        String compShot = thirdCompMove();
        if ((blockNum == blocked) || (blockNum == blocked2)) {
            thirdDefenseOutcome = opposingAttacker + " shoots " + compShot + "\nAND THE GOALIE IS ABLE TO BLOCK IT" ;
            goodOutcome = thirdDefenseOutcome;
        }
        else{
            thirdDefenseOutcome = opposingAttacker + " shoots " + compShot + "\nAND HITS THE BACK OF THE NETTTTT";
            badOutcome = thirdDefenseOutcome;
        }
        return thirdDefenseOutcome;
    }

    /***
     * outcomeChecker method which checks if the current outcome is good or bad
     * @param userOutcome a String that contains the current outcome of the defense
     * @return returns a boolean that represents if the defense was successful
     */
    public boolean outcomeChecker(String userOutcome) {
        return goodOutcome.equals(userOutcome);
    }

    /***
     * toString method which returns a String that contains the information about the attacker
     * defender and opposing attacker
     * @return returns a properly formatted String that displays the current players
     */
    public String toString(){
        return "The current attacker is " + attacker + ". The opposing attacker is " + opposingAttacker + ". The curremt defender is " + defender +".";
    }
}