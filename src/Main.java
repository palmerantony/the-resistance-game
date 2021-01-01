import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        // Accept player names
        acceptPlayerNames();

        // Randomly select players to be spies, when commanded
        selectSpies();

        // Inform spies who the other spies are

        // Permit voting for Round 1

        // Announce votes for Round 1

        // Repeat for N rounds


    }


    private static void acceptPlayerNames() {
        Scanner in = new Scanner(System.in);

        boolean done = false;
        do {
            System.out.println("Please enter player name or X to finish: ");
            String playerName = in.next();
            if (playerName.equals("X")) {
                done = true;
                System.out.println("All done!");
            } else {
                GameData.PLAYER_NAMES.add(playerName);
                System.out.println(playerName + " has been added to the game!");
                System.out.println();
            }
        } while (!done);

        System.out.println("Thank you for entering player names. The following players are in the game:");
        GameData.PLAYER_NAMES.forEach(System.out::println);
        System.out.println();
    }



    private static void selectSpies() {
        System.out.println("***********");
        System.out.println("Selecting spies");

        //Shuffle the list and select three players
        Collections.shuffle(GameData.PLAYER_NAMES);
        List<String> spies = GameData.PLAYER_NAMES.subList(0, 3);
        GameData.SPIES  = spies;
    }



}
