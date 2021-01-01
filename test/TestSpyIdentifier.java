import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSpyIdentifier {

    public static final SpyIdentifier IDENT = new SpyIdentifier();

    @Before
    public void setup() {
        //Two players
        GameData.PLAYER_NAMES.add("BILL");
        GameData.PLAYER_NAMES.add("TED");
        //One is a spy
        GameData.SPIES.add("BILL");
    }


    @Test
    public void testResistance() {
        SpyIdentifier.PlayerStatus result = IDENT.getSpyStatusForPlayer("TED");
        assertEquals("Player should be resistance", SpyIdentifier.PlayerStatus.RESISTANCE, result);
    }


    @Test
    public void testSpy() {
        SpyIdentifier.PlayerStatus result = IDENT.getSpyStatusForPlayer("BILL");
        assertEquals("Player should be spy", SpyIdentifier.PlayerStatus.SPY, result);
    }


    @Test
    public void testUnknown() {
        SpyIdentifier.PlayerStatus result = IDENT.getSpyStatusForPlayer("other");
        assertEquals("Player should be not in the game", SpyIdentifier.PlayerStatus.NOT_IN_GAME, result);
    }

}
