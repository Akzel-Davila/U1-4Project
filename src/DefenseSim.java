public class DefenseSim{
    private String defender;
    private String opposingAttacker;
    public DefenseSim(String defender, String computerAttack){
        this.defender = defender;
        opposingAttacker = computerAttack;

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
        int randomNum = (int) (Math.random()*4);
        return moves[randomNum];
    }
    public String thirdCompMove(){
        String [] shot = {"Top right", "Top left", "Down the middle", "Right", "Left"};
        int shotPicker =  (int) (Math.random()*6);
        return shot[shotPicker];
    }
    public String firstOutcome(){

    }

}