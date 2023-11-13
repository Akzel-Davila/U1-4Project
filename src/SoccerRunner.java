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
        String userAttacker = s.nextLine();
        AttackerSim userAttack = new AttackerSim(userTeam,userAttacker);
        System.out.println("Enter your teams defender: ");
        String userDefender = s.nextLine();

        //Opposing Team
        System.out.println("Enter the team you would like to play against");
        String opposingTeam = s.nextLine();
        System.out.println("Enter the opposing teams attacker:");
        String opposingAttacker = s.nextLine();
        System.out.println("Enter the opposing teams defender: ");
        String opposingDefender = s.nextLine();
        DefenseSim userDefend = new DefenseSim(userDefender,opposingAttacker,userAttacker);

        //User enters the score for the game to end (Exit condition for the program)
        System.out.println("Enter how many goals the winning team should score to end the game:");
        int goalNum = Integer.parseInt(s.nextLine());
        int userTeamGoals = 0;
        int oppTeamGoals = 0;

        //While loop that will end once the target goals have been matched
        int hasBall = userAttack.firstBall();
        while ((userTeamGoals!=goalNum) && (oppTeamGoals!=goalNum)){
            if (hasBall == 1){
                System.out.println(userTeam + " has the ball!");
                System.out.println("Would you like " + userAttacker + " to go left or right?: ");
                String direction = s.nextLine();
                System.out.println("And would you look at that...");
                direction = direction.toLowerCase(Locale.ROOT);
                String message = userAttack.attackOutcome(direction);
                System.out.println(message + " " + opposingAttacker);
                int outcomeNum = userAttack.checkOutcome(message);
                //Moves towards the defender stage
                if (outcomeNum==1){
                    System.out.println(userAttacker + " is now approaching the defender, get ready to type a number to choose a move!");
                    System.out.println("Would you like to: \n [1] Attempt a rainbow flick \n [2] Attempt to dribble past the defender \n [3] Attempt a stepover");
                    int userMove = Integer.parseInt(s.nextLine());
                    boolean success = userAttack.pastDefender(userMove);
                    if (success){
                        System.out.println(userAttacker + " HAS SUCCESSFULLY MOVED PASSED " + opposingDefender);
                        System.out.println(userAttacker + " is now face to face with the goalie");
                        System.out.println("Will " + userAttacker + " shoot: \n[1] Top right \n[2] Top left \n[3] Down the middle \n[4]  Right \n[5] left");
                        int userShot = Integer.parseInt(s.nextLine());
                        boolean goal = userAttack.goalScored(userShot);
                        if (goal){
                            System.out.println("GOALLLLLLL");
                            System.out.println(userAttacker + " HAS MADE " + userTeam + " PROUD");
                            userTeamGoals++;
                            System.out.println("The score is now " + userTeamGoals + "-" + oppTeamGoals);
                            hasBall=2;
                        }
                        else{
                            System.out.print("AMAZING THE KEEPER SAVES THE BALL");
                            hasBall=2;
                        }
                    }
                    else{
                        System.out.println("How unfortunate the defender has prediected " + userAttacker + "'s move and has stolen the ball");
                        hasBall=2;
                    }
                }
            }
            if(hasBall==2) {
                System.out.println(opposingTeam + " has the ball!");
                System.out.println(opposingAttacker + " is preparing to make a move!");
                System.out.println("Would you like to go right or left?");
                String defenseDirect = s.nextLine();
                defenseDirect = defenseDirect.toLowerCase();
                String firstOutcome = userDefend.firstOutcome(defenseDirect);
                boolean blocked = userDefend.outcomeChecker(firstOutcome);
                System.out.println(firstOutcome);
                if (!blocked){
                    System.out.println(opposingAttacker + " is now approaching " + userDefender);
                    System.out.println("Should " + userDefender + " prepare for: \n [1] A nutmeg \n [2] The Cruyff Turn \n [3] A stepover");
                    int defendMove = Integer.parseInt(s.nextLine());
                    String secondOutcome = userDefend.secondOutcomes(defendMove);
                    boolean pastDefender = userDefend.outcomeChecker(secondOutcome);
                    System.out.println(secondOutcome);
                    if (!pastDefender){
                        System.out.println(opposingAttacker + " is now approaching the goalie");
                        System.out.println("Should the goalie defend: \n[1] Top right \n[2] Top left \n[3] Down the middle \n[4]  Right \n[5] left");
                        int goalieMove = Integer.parseInt(s.nextLine());
                        System.out.print("GOALLLLLL");
                        hasBall=1;
                    }
                    else{
                        hasBall=1;
                    }

                }
                else{
                    hasBall=1;
                }


            }
        }
    }
}
