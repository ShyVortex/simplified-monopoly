package it.unimol.monopoly.app;

import java.io.*;
import java.util.Map;
import java.util.HashMap;

/**
 * Class made to manage players. Once created by the main user through UI, every player is added to a key-value map
 * where the key is each player's ID and the value is the player itself.
 * It implements the {@link Serializable} interface because the state of the object is saved on a file.
 *
 * @author Angelo Trotta
 * @version 2.0
 */

public class PlayerManager implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;
    private Map<Integer, Player> players;

    /**
     * It creates the player manager, by instantiating an empty map.
     */
    public PlayerManager() {
        this.players = new HashMap<>();
    }

    /**
     * It defines the addition of a player to the map.
     *
     * @param id Player's ID to add, which is the key of the map.
     * @param player The player itself, who is the value of the map.
     * @return {@code true} if the number of players is less than or equal to 6, {@code false} otherwise.
     */
    public boolean addPlayer(int id, Player player) {
        assert player != null;

        if (this.players.size() < 6) {
            this.players.put(id, player);
            return true;
        }
        else
            return false;
    }

    /**
     * It checks if a certain name has been already registered by another player.
     *
     * @param nome Name given in input.
     * @return {@code true} if the name is already taken, {@code false} otherwise.
     */
    public boolean checkNameAlreadyTaken(String nome) {
        for (Player x : players.values()) {
            if (nome.equals(x.getName())) {
                Player.aux--;
                return true;
            }
        }

        return false;
    }

    /**
     * It checks if a certain pawn has been already registered by another player.
     *
     * @param nome Name of the pawn give in input.
     * @return {@code true} if the pawn is already taken, {@code false} otherwise.
     */
    public boolean checkPawnAlreadyTaken(String nome) {
        for (Player x : players.values()) {
            if (nome.equals(x.getPawn().getName())) {
                Player.aux--;
                return true;
            }
        }

        return false;
    }

    public Map<Integer, Player> getPlayers() {
        return this.players;
    }

    /**
     * Representation of the player manager as string.
     *
     * @return A string visualization of the manager.
     */
    @Override
    public String toString() {
        assert this.players != null;
        String result = "";
        for (Player player : players.values()) {
            assert player != null;
            result += player + "\n";
        }
        return result;
    }

    /**
     * It changes player at the end of a turn.
     *
     * @param playerId ID of the current player.
     * @return The new player.
     */
    public Player changePlayer(int playerId) {
        int currentId = playerId;
        if (currentId < this.players.size()) {
            currentId++;
        }
        else {
            currentId = 1;
        }
        Player nextPlayer = this.players.get(currentId);

        return nextPlayer;
    }

    /**
     * It handles the saving on file of the player manager.
     *
     * @throws IOException in case of failure.
     */
    public void savePlayers() throws IOException {
        try (
                FileOutputStream fileOutStr = new FileOutputStream("players.sr");
                ObjectOutputStream objOutStr = new ObjectOutputStream(fileOutStr);
        ) {
            objOutStr.writeObject(this);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * It handles the loading from file of the player manager.
     *
     * @return An instance of the {@code PlayerManager} in case of success.
     * @throws FileNotFoundException returns {@code null} if no save file is found.
     */
    public static PlayerManager loadPlayers() throws FileNotFoundException {
        try (
                FileInputStream fileInStr = new FileInputStream("players.sr");
                ObjectInputStream objInStr = new ObjectInputStream(fileInStr);
        ) {
            Object o = objInStr.readObject();
            return (PlayerManager) o;
        }
        catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
        catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}