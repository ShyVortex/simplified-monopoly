package app;

import it.unimol.monopoly.app.Pawn;
import it.unimol.monopoly.app.Player;
import it.unimol.monopoly.app.Prison;
import it.unimol.monopoly.app.Turn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests for the Prison class")
class PrisonTest {
    Image carPic, shoePic;
    ImageIcon carIcon, shoeIcon;
    Pawn car, shoe;
    Player player1, player2;

    @BeforeEach
    public void init() throws IOException {
        carPic = ImageIO.read(new File("src/main/resources/pawns/Car.png"));
        carIcon = new ImageIcon(carPic);
        car = new Pawn("CAR", carIcon);
        player1 = new Player("Angelo", car);

        shoePic = ImageIO.read(new File("src/main/resources/pawns/Shoe.png"));
        shoeIcon = new ImageIcon(shoePic);
        shoe = new Pawn("SHOE", shoeIcon);
        player2 = new Player("Antonio", shoe);
    }

    @Test
    public void mainTest() throws IOException {
        assertNotNull(car);
        assertNotNull(shoe);
        assertNotNull(player1);
        assertNotNull(player2);
        assertNotEquals(player1, player2);

        Prison prison = Prison.getInstance();

        player1.setPrisoner(true);
        player2.setPrisoner(true);

        freeExit(player1);
        freeExit(player2);

        player1.setPrisoner(true);
        player2.setPrisoner(true);
        player1.setMoney(500);
        player2.setMoney(10);

        boolean hasMoneyTest = paidExit(player1, prison);
        boolean noMoneyTest = paidExit(player2, prison);

        assertEquals(player1.getMoney(), 500 - Prison.getInstance().getExitFee());
        assertEquals(player2.getMoney(), 10);
        assertTrue(hasMoneyTest);
        assertFalse(noMoneyTest);

        stay(player2);

        assertFalse(player1.isPrisoner());
        assertTrue(player2.isPrisoner());

        System.out.println("TEST SUCCESSFUL.\n");
    }

    public void freeExit(Player player) {
        player.setPrisoner(false);
    }

    public boolean paidExit(Player player, Prison prison) {
        if (player.getMoney() >= prison.getExitFee()) {
            player.subMoney(prison.getExitFee());
            player.setPrisoner(false);
            return true;
        }
        else {
            return false;
        }
    }

    public void stay(Player player) {
        Turn turn = Turn.getInstance();
        turn.endTurn(player);
    }
}