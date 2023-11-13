public class DefenseSim{
    private String defender;
    private final String opposingAttacker;
    private String attacker;

    private String goodOutcome;
    private String badOutcome;
    public DefenseSim(String userDefender, String computerAttack, String userAttacker){
        defender = userDefender;
        opposingAttacker = computerAttack;
        attacker = userAttacker;
        goodOutcome = "";
        badOutcome = "";
    }
    public String firstCompMove(){
        int randomNum = (int) (Math.random()*2) +1;
        if (randomNum == 1){
            return "left";
        }
        return "right";
    }
    public String secondCompMove(){
        String [] moves = {"nutmeg", "the cruyff turn", "stepover"};
        int randomNum = (int) (Math.random()*3);
        return moves[randomNum];
    }
    public String thirdCompMove(){
        String [] shot = {"Top right", "Top left", "Down the middle", "Right", "Left"};
        int shotPicker =  (int) (Math.random()*5);
        return shot[shotPicker];
    }
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
    public boolean outcomeChecker(String userOutcome) {
        return goodOutcome.equals(userOutcome);
    }
}