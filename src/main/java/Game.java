import java.util.*;

public class Game {
    Map<String, Player> players = new HashMap<>();

    public void registered(Player player) {
        players.put(player.getName(), player);
    }

    public int round2(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;
        for (String key : players.keySet()) {
            if (key.equals(playerName1)) {
                player1 = players.get(key);
            }
            if (key.equals(playerName2)) {
                player2 = players.get(key);
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
