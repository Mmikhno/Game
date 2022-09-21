import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;


public class GameTest {

    Game game = new Game();
    HashMap<String, Player> players = new HashMap<>();

    Player player1 = new Player(1, "Player1", 10);
    Player player2 = new Player(2, "Player2", 15);
    Player player3 = new Player(3, "Player3", 96);
    Player player4 = new Player(4, "Player4", 95);
    Player player5 = new Player(5, "Player5", 95);

    @BeforeEach
    public void setup() {
        players.put("Player1", player1);
        players.put("Player2", player2);
        players.put("Player3", player3);
        players.put("Player4", player4);
        players.put("Player5", player5);
    }


    @Test
    public void bothRegisteredFirstIsWinner() {
        game.registered(player3);
        game.registered(player5);
        int expected = 1;
        int actual = game.round2("Player3", "Player5");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void bothRegisteredSecondIsWinner() {
        game.registered(player1);
        game.registered(player2);
        Assertions.assertEquals(2, game.round2("Player1", "Player2"));
    }

    @Test
    public void bothRegisteredGameInDraw() {
        game.registered(player4);
        game.registered(player5);
        Assertions.assertEquals(0, game.round2("Player5", "Player4"));
    }

    @Test
    public void firstIsNotRegistered() {
        game.registered(player3);
        game.registered(player5);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round2("Player4", "Player5"));
    }

    @Test
    public void secondIsNotRegistered() {
        game.registered(player2);
        game.registered(player3);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round2("Player2", "Player5"));
    }

    @Test
    public void bothAreNotRegistered() {
        game.registered(player1);
        game.registered(player2);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round2("Player3", "Player4"));
    }


}
