public class SpyIdentifier {


    /**
     * @return whether the player is resistance, a spy, or not in the game at all
     */
    PlayerStatus getSpyStatusForPlayer(String playerName) {
        if (!GameData.PLAYER_NAMES.contains(playerName)) {
            System.out.println("Ths player is not in the game!");
            return PlayerStatus.NOT_IN_GAME;
        } else if (GameData.SPIES.contains(playerName)) {
            return PlayerStatus.SPY;
        } else {
         return PlayerStatus.RESISTANCE;
        }
    }

    enum PlayerStatus {



        RESISTANCE {

            void informPlayer() {
                System.out.println("You are RESISTANCE");
            }
        },
        SPY {

            void informPlayer() {
                System.out.println("You are a SPY. Your fellow spies are: " + GameData.SPIES);
            }
        },
        NOT_IN_GAME {

            void informPlayer() {
                System.out.println("You are not in the game....");
            }
        };

        abstract void informPlayer();
    }
}
