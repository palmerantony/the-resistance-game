import java.util.ArrayList;
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

        // Set player order
        setOrderOfPlay();

        // Permit voting for Round 1
        runMissionOne();


        // Announce votes for Round 1

        // Repeat for N rounds


    }

    private static void runMissionOne() throws InterruptedException {
        System.out.println("Time to select a team for mission 1!");
        printThinkingDots();
        System.out.println("When you are ready to submit mission success/failure, please enter 'X': ");
        printThinkingDots();
        in.next();
        System.out.println("Mission 1 requires two participants");
        Mission mission = new Mission(2,2);
        System.out.println("Please enter first SUCCESS or FAIL");
        String missionResult1 = in.next();
        recordMissionResultInput(mission, missionResult1);
        System.out.println("Please enter second SUCCESS or FAIL");
        String missionResult2 = in.next();
        recordMissionResultInput(mission, missionResult2);

        assessMissionStatus(mission);
    }

    private static void assessMissionStatus(Mission mission) {
        if (mission.hasMissionSucceeded()) {
            System.out.println("Congratulations, RESISTANCE. Your mission has succeeded with [" + mission.getNumberOfRecordedFailures() + "] failure votes");
        } else {
            System.out.println("Disaster has struck! The mission has failed with [" + mission.getNumberOfRecordedFailures() + "] failure votes");
        }
    }

    private static void recordMissionResultInput(Mission mission, String missionResult) {
        if ("SUCCESS".equals(missionResult.toUpperCase())) {
            mission.addSuccess();
        } else if ("FAIL".equals(missionResult.toUpperCase())) {
            mission.addFailure();
        }
    }

    private static void setOrderOfPlay() throws InterruptedException {
        ArrayList<String> names = new ArrayList<>();
        names.addAll(GameData.PLAYER_NAMES);
        Collections.shuffle(names);
        System.out.println("Order of play will be");
        printThinkingDots();
        System.out.println();
        names.forEach(System.out::println);
    }


    private static void acceptPlayerNames() throws InterruptedException {

        boolean done = false;
        do {
            System.out.println("Please enter player name or 'X' to finish: ");
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
        printThinkingDots();
        System.out.println();
        //Shuffle the list and select three players
        ArrayList<String> names = new ArrayList<>();
        names.addAll(GameData.PLAYER_NAMES);
        Collections.shuffle(names);
        List<String> spies = names.subList(0, 3);
        GameData.SPIES  = spies;
    }

    private static void printThinkingDots() throws InterruptedException {
        for (int i = 0; i<5; i++){
            System.out.print(".");
            Thread.sleep(500);
        }
        System.out.println();
    }


    private static void informSpies() {
        SpyIdentifier identifier = new SpyIdentifier();
        System.out.println("***********");

        do {
            System.out.println("Please enter your name to be informed of your status. Or enter 'X' to move on.");
            String playerName = in.next();
            if ("X".equals(playerName)) break;
            SpyIdentifier.PlayerStatus result = identifier.getSpyStatusForPlayer(playerName);
            result.informPlayer();
            System.out.println();
        } while(true);
        System.out.println("***********");
    }


}
