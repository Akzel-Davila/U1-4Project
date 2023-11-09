import java.util.Locale;
import java.util.Scanner;
public class SoccerRunner {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        //The Program Welcomes the User
        System.out.println("Welcome to the Soccer Simulator!");
        System.out.println("In this simulation you will chose your team and an attack and defender that will represent you");
        System.out.println("You will also choose the opposing team along with their attacker and defender");

        //User Team
        System.out.println("Enter the team you would like to play as: ");
        String userTeam = s.nextLine();
        System.out.println("Enter your teams attacker:");
        String userPlayer = s.nextLine();
        AttackerSim userAttack = new AttackerSim(userTeam,userPlayer);

        //Opposing Team
        System.out.println("Enter the team you would like to play against");
        String opposingTeam = s.nextLine();
        System.out.println("Enter the opposing teams attacker:");
        String opposingPlayer = s.nextLine();
        AttackerSim opposingAttack = new AttackerSim(opposingTeam, opposingPlayer);

        //User enters the score for the game to end (Exit condition for the program)
        System.out.println("Enter how many goals the winning team should score to end the game:");
        int goalNum = Integer.parseInt(s.nextLine());
        int userTeamGoals = 0;
        int oppTeamGoals = 0;

        //While loop that will end once the target goals have been matched
        int hasBall = userAttack.firstBall();
        while ((userTeamGoals!=goalNum) && (oppTeamGoals!=goalNum)){
            while (hasBall == 1){
                System.out.println(userTeam + " has the ball!");
                System.out.println("Would you like " + userPlayer + " to go left or right?: ");
                String direction = s.nextLine();
                System.out.println("And would you look at that...");
                direction = direction.toLowerCase(Locale.ROOT);
                String message = userAttack.attackOutcome(direction);
                System.out.println(message + " " + opposingPlayer);
                int outcomeNum = userAttack.checkOutcome(message);
                //Moves towards the defender stage
                if (outcomeNum==1){
                    System.out.println(userPlayer + " is now approaching the defender " + "");
                }


            }
            if(hasBall==2){
                System.out.println("Code is working boss");
            }
            oppTeamGoals++;
        }

    }
}