package it.unimol.monopoly.app;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class PlayerManagerTest {
    public static void main(String[] args) throws IOException {
        PlayerManager players;
        try {
            players = loadPlayers();
        } catch (FileNotFoundException e) {
            players = new PlayerManager();
        }

        Image carPic = ImageIO.read(new File("src/it/unimol/monopoly/pawns/Car.png"));
        ImageIcon carIcon = new ImageIcon(carPic);
        Pawn car = new Pawn("CAR", carIcon);
        Player player1 = new Player("Angelo", car);

        Image shoePic = ImageIO.read(new File("src/it/unimol/monopoly/pawns/Shoe.png"));
        ImageIcon shoeIcon = new ImageIcon(shoePic);
        Pawn shoe = new Pawn("SHOE", shoeIcon);
        Player player2 = new Player("Antonio", shoe);

        assertNotNull(players);
        assertNotNull(player1);
        assertNotNull(player2);
        assertNotEquals(player1, player2);

        addPlayer(players, 1, player1);
        addPlayer(players, 2, player2);

        Image barrowPic = ImageIO.read(new File("src/it/unimol/monopoly/pawns/Wheelbarrow.png"));
        ImageIcon barrowIcon = new ImageIcon(barrowPic);
        Pawn wheelbarrow = new Pawn("WHEELBARROW", barrowIcon);
        Player player3 = new Player("Lorenzo", wheelbarrow);

        boolean checkNameTest = checkNameAlreadyTaken(players, "Lorenzo");
        boolean checkPawnTest = checkPedinaAlreadyTaken(players, "WHEELBARROW");

        assertNotNull(player3);
        assertNotEquals(player1, player3);
        assertNotEquals(player2, player3);

        if (!checkNameTest && !checkPawnTest)
            addPlayer(players, 3, player3);

        int currentId = 1;
        Player nextPlayerTest = changePlayer(players, currentId);

        assertNotNull(nextPlayerTest);
        assertNotEquals(player1, nextPlayerTest);
        assertNotEquals(player3, nextPlayerTest);
        assertEquals(player2, nextPlayerTest);

        if (!checkNameTest && !checkPawnTest && nextPlayerTest.getId() == 1 && player2.equals(nextPlayerTest))
            System.out.println("TEST SUCCESSFUL --> new GestoreGiocatori()");

        if (checkNameTest && checkPawnTest && nextPlayerTest.getId() == 1 && player2.equals(nextPlayerTest))
            System.out.println("TEST SUCCESSFUL --> loadGiocatori()");
    }

    @Test
    public static boolean addPlayer(PlayerManager giocatori, int id, Player player) {
        assert player != null;

        if (giocatori.getPlayers().size() < 6) {
            giocatori.getPlayers().put(id, player);
            return true;
        }
        else
            return false;
    }

    @Test
    public static boolean checkNameAlreadyTaken(PlayerManager giocatori, String nome) {
        for (Player x : giocatori.getPlayers().values()) {
            if (nome.equals(x.getName())) {
                Player.aux--;
                return true;
            }
        }

        return false;
    }

    @Test
    public static boolean checkPedinaAlreadyTaken(PlayerManager giocatori, String nome) {
        for (Player x : giocatori.getPlayers().values()) {
            if (nome.equals(x.getPawn().getName())) {
                Player.aux--;
                return true;
            }
        }

        return false;
    }

    @Test
    public static Player changePlayer(PlayerManager giocatori, int playerId) {
        int currentId = playerId;
        if (currentId < giocatori.getPlayers().size()) {
            currentId++;
        }
        else {
            currentId = 1;
        }
        Player nextPlayer = giocatori.getPlayers().get(currentId);

        return nextPlayer;
    }

    @Test
    public static void savePlayers(PlayerManager giocatori) throws IOException {
        try (
                FileOutputStream fileOutStr = new FileOutputStream("test/it/unimol/monopoly/app/testsaves/players.sr");
                ObjectOutputStream objOutStr = new ObjectOutputStream(fileOutStr);
        ) {
            objOutStr.writeObject(giocatori);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public static PlayerManager loadPlayers() throws FileNotFoundException {
        try (
                FileInputStream fileInStr = new FileInputStream("test/it/unimol/monopoly/app/testsaves/players.sr");
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