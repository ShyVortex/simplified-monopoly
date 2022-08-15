package it.unimol.monopoly.app;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FeeTest {
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

        Fee fee1 = new Fee(100);
        Fee fee2 = new Fee(9999);

        player1.setMoney(500);
        player2.setMoney(2500);

        boolean hasMoneyTest = payFee(player1, fee1);
        boolean noMoneyTest = payFee(player2, fee2);

        assertTrue(hasMoneyTest);
        assertFalse(noMoneyTest);
        assertEquals(player1.getMoney(), 400);
        assertEquals(player2.getMoney(), 0);

        System.out.println("TEST SUCCESSFUL.");
    }

    @Test
    public static boolean payFee(Player player, Fee fee) {
        if (player.getMoney() >= fee.getValue()) {
            player.subMoney(fee.getValue());
            return true;
        }
        else {
            player.setMoney(0);
            return false;
        }
    }
}