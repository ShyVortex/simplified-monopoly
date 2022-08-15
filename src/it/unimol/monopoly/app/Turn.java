package it.unimol.monopoly.app;

import java.io.*;

/**
 * Singleton that defines the Turn object. This class is important to allow both the change of turn during the game,
 * and the saving of the match's state. It will have the methods of all the operations that are possible in a turn of a
 * monopoly game.
 *
 * @author Angelo Trotta
 * @version 1.0
 */

public class Turn implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private static Turn instance = new Turn();

    /**
     * Variable with the ID of the player that has to change turn.
     */
    public static int playerId;

    private Turn() {}

    public static Turn getInstance() {
        return instance;
    }

    /**
     * It allows the player to pass through "GO", adding 500€ to his bank account.
     *
     * @param player The current player.
     */
    public void passThroughGO(Player player) {
        player.addMoney(500);
    }

    /**
     * It makes the player to go to prison, setting the {@code isPrisoner} variable to {@code true}.
     *
     * @param player The current player.
     */
    public void goToPrison(Player player) {
        player.setPrisoner(true);
    }

    /**
     * It allows the player to end their turn, passing their ID to the {@link #playerId} variable.
     *
     * @param player The player who has to change turn.
     * @return Always {@code true}, since the change of turn is always possible.
     */
    public boolean endTurn(Player player) {
        playerId = player.getId();
        return true;
    }

    /**
     * It allows to save the turns state on file, so that when the match is resumed the order of them isn't changed.
     */
    public void saveTurn() {
        try (
            FileOutputStream fileOutStr = new FileOutputStream("src/main/saves/turn.sr");
            ObjectOutputStream objOutStr = new ObjectOutputStream(fileOutStr);
        ) {
            objOutStr.writeObject(playerId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * It allows to load the turns state from file, to resume the match exactly from where it was interrupted.
     *
     * @return the value of {@link #playerId} if the variable is successfully loaded, {@code -1} otherwise.
     * @throws FileNotFoundException In case the save file is not found.
     */
    public static int loadTurn() throws FileNotFoundException {
        try (
            FileInputStream fileInStr = new FileInputStream("src/main/saves/turn.sr");
            ObjectInputStream objInStr = new ObjectInputStream(fileInStr);
        ) {
            playerId = (int) objInStr.readObject();
            return playerId;
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return -1;
    }
}