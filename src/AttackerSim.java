import java.util.*;
public class AttackerSim {
    private String team;
    private String player;

    public AttackerSim(String team, String player){
        this.team = team;
        this.player = player;
    }
    public int firstBall(){
        int ballNum = (int)(Math.random()*2)+1;
        return ballNum;
    }
    public void updateBall(int ballNum){
        if (ballNum == 1){
            ballNum = 2;
        }
        else{
            ballNum = 1;
        }
    }
    public String attackOutcome(String direction){
        int odds = 0;
        String[] directions = {"right", "left"};
        if (direction.equals(directions[(int) (Math.round(Math.random()))])){
            odds = 3;
        }
        else{odds = 1;}
        int outcomeNum = (int) (Math.random() * (10))+odds;
        int outcomePicker = (int) (Math.round(Math.random()));
        String[] goodOutcomes = {player + " dribbles right past", "INCREDIBLE " + player + " HAS DUSTED"};
        String[] badOutcomes = {"How embarrassing " + player + " has tripped and lost the ball to", "Yikes " + player + " could not win the 1v1 against"};
        if (outcomeNum > 5){
            return goodOutcomes[outcomePicker];
        }
        else{
            return badOutcomes[outcomePicker];
        }
    }
    public int checkOutcome(String outcome){
        String[] goodOutcomes = {player + " dribbles right past", "INCREDIBLE " + player + " HAS DUSTED"};
        for (int i = 0; i < goodOutcomes.length; i++){
            if(goodOutcomes[i].equals(outcome)){
                return 1;
            }
        }
        return 0;
    }
    public boolean pastDefender(Integer moveNum){
        int numPicker = (int) (Math.random() * 3)+1;
        return numPicker == moveNum;
    }
    public boolean goalScored(Integer shootNum){
        int success = (int) (Math.random() * 5)+1;
        int success2 = (int) (Math.random() * 5)+1;
        return (shootNum == success) || (shootNum == success2);
    }

    public void makeSub(String newPlayer){
        player = newPlayer;
    }



}
