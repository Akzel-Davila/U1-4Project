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

        //User enters the score for the game to end (Exit condition for the program)
        System.out.println("Enter how many goals the winning team should score to end the game:");
        int goalNum = Integer.parseInt(s.nextLine());
        int userTeamGoals = 0;
        int oppTeamGoals = 0;
        //While loop that will end once the target goals have been matched
        while ((userTeamGoals!=goalNum) && (oppTeamGoals!=goalNum)){
            oppTeamGoals++;
        }

    }
}