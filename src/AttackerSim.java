import java.util.*;
public class AttackerSim {
    private String team;
    private String player;

    public AttackerSim(String userTeam, String userPlayer){
        team = userTeam;
        player = userPlayer;
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
    public String attackOutcome(){
        int outcomeNum = (int) (Math.random() * 10)+1;
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
        for (int i = 0; i <goodOutcomes.length; i++){
            if(goodOutcomes[i].equals(outcome)){
                return 1;
            }
        }
        return 0;
    }
    public void makeSub(String newPlayer){
        player = newPlayer;
    }



}
