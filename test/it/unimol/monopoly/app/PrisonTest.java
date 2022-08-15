package it.unimol.monopoly.app;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PrisonTest {
    public static void main(String[] args) throws IOException {
        Image carPic = ImageIO.read(new File("src/it/unimol/monopoly/pawns/Car.png"));
        ImageIcon carIcon = new ImageIcon(carPic);
        Pawn car = new Pawn("CAR", carIcon);
        Player player1 = new Player("Angelo", car);

        Image shoePic = ImageIO.read(new File("src/it/unimol/monopoly/pawns/Shoe.png"));
        ImageIcon shoeIcon = new ImageIcon(shoePic);
        Pawn shoe = new Pawn("SHOE", shoeIcon);
        Player player2 = new Player("Antonio", shoe);

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

        assertEquals(player2.getMoney(), 10);

        stay(player2);

        assertFalse(player1.isPrisoner());
        assertTrue(player2.isPrisoner());

        System.out.println("TEST SUCCESSFUL.");
    }

    @Test
    public static void freeExit(Player player) {
        player.setPrisoner(false);
    }

    @Test
    public static boolean paidExit(Player player, Prison prison) {
        if (player.getMoney() >= prison.getExitFee()) {
            player.subMoney(prison.getExitFee());
            player.setPrisoner(false);
            return true;
        }
        else {
            return false;
        }
    }

    @Test
    public static void stay(Player player) {
        Turn turn = Turn.getInstance();
        turn.endTurn(player);
    }
}