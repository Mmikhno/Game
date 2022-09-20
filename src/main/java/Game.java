import java.util.ArrayList;
import java.util.List;

public class Game {
    protected List<Player> players = new ArrayList<>();

    public void registered(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;

        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(playerName1)) {
                player1 = players.get(i);
            }
            if (players.get(i).getName().equals(playerName2)) {
                player2 = players.get(i);
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException("Player with the name " + playerName1 + " not registered");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Player with the name " + playerName2 + " not registered");
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player2.getStrength() > player1.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}
