package app;

import it.unimol.monopoly.app.Pawn;
import it.unimol.monopoly.app.Player;
import it.unimol.monopoly.app.PlayerManager;
import org.jdom.IllegalAddException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests for the Pawn Manager")
class PlayerManagerTest {
    PlayerManager players;
    Image carPic, shoePic, barrowPic;
    ImageIcon carIcon, shoeIcon, barrowIcon;
    Pawn car, shoe, wheelbarrow;
    Player player1, player2, player3;

    @BeforeEach
    public void init() throws IOException {
        try {
            players = loadPlayers();
        } catch (FileNotFoundException e) {
            players = new PlayerManager();
        }

        carPic = ImageIO.read(new File("src/main/resources/pawns/Car.png"));
        carIcon = new ImageIcon(carPic);
        car = new Pawn("CAR", carIcon);
        player1 = new Player("Angelo", car);

        shoePic = ImageIO.read(new File("src/main/resources/pawns/Shoe.png"));
        shoeIcon = new ImageIcon(shoePic);
        shoe = new Pawn("SHOE", shoeIcon);
        player2 = new Player("Antonio", shoe);

        barrowPic = ImageIO.read(new File("src/main/resources/pawns/Wheelbarrow.png"));
        barrowIcon = new ImageIcon(barrowPic);
        wheelbarrow = new Pawn("WHEELBARROW", barrowIcon);
        player3 = new Player("Lorenzo", wheelbarrow);
    }

    @Test
    public void mainTest() {
        assertNotNull(players);
        assertNotNull(player1);
        assertNotNull(player2);
        assertNotEquals(player1, player2);

        addPlayer(1, player1);
        addPlayer(2, player2);

        boolean checkNameTest = checkNameAlreadyTaken("Lorenzo");
        boolean checkPawnTest = checkPedinaAlreadyTaken("WHEELBARROW");

        assertNotNull(player3);
        assertNotEquals(player1, player3);
        assertNotEquals(player2, player3);

        if (!checkNameTest && !checkPawnTest)
            addPlayer(3, player3);

        int currentId = 1;
        Player nextPlayerTest = changePlayer(currentId);

        assertNotNull(nextPlayerTest);
        assertNotEquals(player1, nextPlayerTest);
        assertNotEquals(player3, nextPlayerTest);
        assertEquals(player2, nextPlayerTest);

        savePlayers();

        if (!checkNameTest && !checkPawnTest && nextPlayerTest.getId() == 1 && player2.equals(nextPlayerTest))
            System.out.println("TEST SUCCESSFUL --> new PlayerManager()\n");

        if (checkNameTest && checkPawnTest && nextPlayerTest.getId() == 1 && player2.equals(nextPlayerTest))
            System.out.println("TEST SUCCESSFUL --> loadPlayers()\n");
    }

    public void addPlayer(int id, Player player) {
        assert player != null;

        try {
            if (players.getPlayers().size() < 6) {
                players.getPlayers().put(id, player);
            } else
                throw new IllegalAddException("LIMIT REACHED");
        } catch (IllegalAddException e) {
            System.out.println("PLAYER TABLE IS FULL!");
        }
    }

    public boolean checkNameAlreadyTaken(String name) {
        for (Player x : players.getPlayers().values()) {
            if (name.equals(x.getName())) {
                Player.aux--;
                return true;
            }
        }

        return false;
    }

    public boolean checkPedinaAlreadyTaken(String name) {
        for (Player x : players.getPlayers().values()) {
            if (name.equals(x.getPawn().getName())) {
                Player.aux--;
                return true;
            }
        }

        return false;
    }

    public Player changePlayer(int playerId) {
        int currentId = playerId;
        if (currentId < players.getPlayers().size()) {
            currentId++;
        }
        else {
            currentId = 1;
        }
        Player nextPlayer = players.getPlayers().get(currentId);

        return nextPlayer;
    }

    @Test
    public void savePlayers() {
        try (
                FileOutputStream fileOutStr = new FileOutputStream("src/test/testsaves/players.sr");
                ObjectOutputStream objOutStr = new ObjectOutputStream(fileOutStr);
        ) {
            objOutStr.writeObject(players);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PlayerManager loadPlayers() throws FileNotFoundException {
        try (
                FileInputStream fileInStr = new FileInputStream("src/test/testsaves/players.sr");
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