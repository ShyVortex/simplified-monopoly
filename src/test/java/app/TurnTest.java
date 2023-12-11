package app;

import it.unimol.monopoly.app.Pawn;
import it.unimol.monopoly.app.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests for the Turn class")
class TurnTest {
    static int playerId;
    static boolean loadSuccess;
    int instanceId;
    Image carPic, shoePic;
    ImageIcon carIcon, shoeIcon;
    Pawn car, shoe;
    Player player1, player2;

    @BeforeEach
    public void init() throws IOException {
        try {
            instanceId = loadTurn();
            loadSuccess = true;
        } catch (FileNotFoundException e) {
            instanceId = -1;
            loadSuccess = false;
        }

        carPic = ImageIO.read(new File("src/main/resources/pawns/Car.png"));
        carIcon = new ImageIcon(carPic);
        car = new Pawn("CAR", carIcon);
        player1 = new Player("Angelo", car);

        shoePic = ImageIO.read(new File("src/main/resources/pawns/Shoe.png"));
        shoeIcon = new ImageIcon(shoePic);
        shoe = new Pawn("SCARPA", shoeIcon);
        player2 = new Player("Antonio", shoe);
    }

    @Test
    public void mainTest() throws IOException {
        assertNotNull(car);
        assertNotNull(shoe);
        assertNotNull(player1);
        assertNotNull(player2);
        assertNotEquals(player1, player2);

        if (loadSuccess)
            assertEquals(playerId, instanceId);
        else
            assertNotEquals(playerId, instanceId);

        endTurn(player1);
        endTurn(player2);

        assertEquals(playerId, player2.getId());

        saveTurn();

        System.out.println("TEST SUCCESSFUL.\n");
    }

    public void endTurn(Player player) {
        playerId = player.getId();
    }

    @Test
    public void saveTurn() {
        try (
                FileOutputStream fileOutStr = new FileOutputStream("src/test/testsaves/turn.sr");
                ObjectOutputStream objOutStr = new ObjectOutputStream(fileOutStr);
        ) {
            objOutStr.writeObject(playerId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int loadTurn() throws FileNotFoundException {
        try (
                FileInputStream fileInStr = new FileInputStream("src/test/testsaves/turn.sr");
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