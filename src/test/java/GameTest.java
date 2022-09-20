import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameTest {

    protected List<Player> players = new ArrayList<>();
    Game game = new Game();

    Player player1 = new Player(1, "Player1", 10);
    Player player2 = new Player(2, "Player2", 15);
    Player player3 = new Player(3, "Player3", 95);
    Player player4 = new Player(4, "Player4", 95);
    Player player5 = new Player(5, "Player5", 90);

    @Test
    public void bothRegisteredFirstIsWinner() {
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        game.registered(player3);
        game.registered(player5);
        int expected = 1;
        int actual = game.round("Player3", "Player5");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void bothRegisteredSecondIsWinner() {
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        game.registered(player1);
        game.registered(player2);
        Assertions.assertEquals(2, game.round("Player1", "Player2"));
    }

    @Test
    public void bothRegisteredGameInDraw() {
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        game.registered(player3);
        game.registered(player4);
        Assertions.assertEquals(0, game.round("Player3", "Player4"));
    }

    @Test
    public void firstIsNotRegistered() {
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        game.registered(player3);
        game.registered(player5);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Player4", "Player5"));
    }

    @Test
    public void secondIsNotRegistered() {
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        game.registered(player2);
        game.registered(player3);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Player2", "Player5"));
    }

    @Test
    public void bothAreNotRegistered() {
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        game.registered(player1);
        game.registered(player2);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Player3", "Player4"));

    }
}
