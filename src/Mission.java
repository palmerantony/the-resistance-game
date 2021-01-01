import java.util.ArrayList;
import java.util.List;

public class Mission {

    private final int numberOfPlayersRequired;
    private final int numberOfSuccessesRequired;

    private int numberOfRecordedSuccesses = 0;
    private int numberOfRecordedFailures = 0;


    /**
     * Set up a mission with the required number of players and successes.
     */
    Mission(int numberOfPlayersRequired, int numberOfSuccessesRequired) {
        this.numberOfPlayersRequired = numberOfPlayersRequired;
        this.numberOfSuccessesRequired = numberOfSuccessesRequired;
    }


    /**
     * Record one success against this mission
     */
    void addSuccess() {
        numberOfRecordedSuccesses++;
    }


    /**
     * Record one failure against this mission
     */
    void addFailure() {
        numberOfRecordedFailures++;
    }


    /**
     * @return true if the mission has the required number of successes
     */
    boolean hasMissionSucceeded() {
        return numberOfRecordedSuccesses >= numberOfSuccessesRequired;
    }


    /**
     * @return the number of votes to fail
     */
    public int getNumberOfRecordedFailures() {
        return numberOfRecordedFailures;
    }
}