import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner in = new Scanner(System.in);


    public static void main(String[] args) throws InterruptedException {

        // Accept player names
        acceptPlayerNames();

        // Randomly select players to be spies, when commanded
        selectSpies();

        // Inform spies who the other spies are
        informSpies();


        // Permit voting for Round 1

        // Announce votes for Round 1

        // Repeat for N rounds


    }



    private static void acceptPlayerNames() throws InterruptedException {

        boolean done = false;
        do {
            System.out.println("Please enter player name or X to finish: ");
            String playerName = in.next();
            if (playerName.equals("X")) {
                done = true;
                System.out.println("All done!");
                Thread.sleep(500);
            } else {
                GameData.PLAYER_NAMES.add(playerName);
                System.out.println(playerName + " has been added to the game!");
                System.out.println();
            }
        } while (!done);
        System.out.println("*");
        Thread.sleep(500);
        System.out.println("**");
        Thread.sleep(500);
        System.out.println("***");
        Thread.sleep(500);
        System.out.println("Thank you for entering player names. The following players are in the game:");
        GameData.PLAYER_NAMES.forEach(System.out::println);
        System.out.println();

        Thread.sleep(1000);
    }



    private static void selectSpies() throws InterruptedException {
        System.out.println("***********");
        System.out.print("Selecting spies");
        for (int i = 0; i<5; i++){
            System.out.print(".");
            Thread.sleep(500);
        }
        System.out.println();
        //Shuffle the list and select three players
        Collections.shuffle(GameData.PLAYER_NAMES);
        List<String> spies = GameData.PLAYER_NAMES.subList(0, 3);
        GameData.SPIES  = spies;
    }



    private static void informSpies() {
        SpyIdentifier identifier = new SpyIdentifier();
        System.out.println("***********");

        do {
            System.out.println("Please enter your name to be informed of your status. Or enter \"X\" to move on.");
            String playerName = in.next();
            if ("X".equals(playerName)) break;
            SpyIdentifier.PlayerStatus result = identifier.getSpyStatusForPlayer(playerName);
            result.informPlayer();
            System.out.println();
        } while(true);
        System.out.println("***********");
    }


}
