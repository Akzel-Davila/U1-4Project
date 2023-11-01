import java.util.Scanner;
public class SoccerRunner {
    public static void main(String[] args){
        System.out.println("Welcome to the Soccer Simulator!");
        System.out.println("In this simulation you will chose your team and an attack and defender that will represent you");
        System.out.println("You will also choose the opposing team along with their attacker and defender");
        AttackerSim a = new AttackerSim("jhsqbhj", "Messi");
        System.out.println(a.attackOutcome());
    }
}