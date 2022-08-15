package it.unimol.monopoly.app;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class TurnTest {
    static int playerId;
    static boolean loadSuccess;

    public static void main(String[] args) throws IOException {
        int instanceId;
        try {
            instanceId = loadTurn();
            loadSuccess = true;
        } catch (FileNotFoundException e) {
            instanceId = -1;
            loadSuccess = false;
        }

        Image carPic = ImageIO.read(new File("src/it/unimol/monopoly/pawns/Car.png"));
        ImageIcon carIcon = new ImageIcon(carPic);
        Pawn car = new Pawn("CAR", carIcon);
        Player player1 = new Player("Angelo", car);

        Image shoePic = ImageIO.read(new File("src/it/unimol/monopoly/pawns/Shoe.png"));
        ImageIcon shoeIcon = new ImageIcon(shoePic);
        Pawn shoe = new Pawn("SCARPA", shoeIcon);
        Player player2 = new Player("Antonio", shoe);

        assertNotNull(car);
        assertNotNull(shoe);
        assertNotNull(player1);
        assertNotNull(player2);
        assertNotEquals(player1, player2);

        endTurn(player1);
        endTurn(player2);

        assertEquals(playerId, player2.getId());

        if (loadSuccess)
            assertEquals(playerId, instanceId);
        else
            assertNotEquals(playerId, instanceId);

        saveTurn();

        System.out.println("TEST SUCCESSFUL.");
    }

    @Test
    public static boolean endTurn(Player player) {
        playerId = player.getId();
        return true;
    }

    @Test
    public static void saveTurn() {
        try (
                FileOutputStream fileOutStr = new FileOutputStream("test/it/unimol/monopoly/app/testsaves/turn.sr");
                ObjectOutputStream objOutStr = new ObjectOutputStream(fileOutStr);
        ) {
            objOutStr.writeObject(playerId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public static int loadTurn() throws FileNotFoundException {
        try (
                FileInputStream fileInStr = new FileInputStream("test/it/unimol/monopoly/app/testsaves/turn.sr");
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