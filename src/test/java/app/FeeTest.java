package app;

import it.unimol.monopoly.app.Fee;
import it.unimol.monopoly.app.Pawn;
import it.unimol.monopoly.app.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests for the Fee class")
class FeeTest {
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
    public void mainTest() {
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

        System.out.println("TEST SUCCESSFUL.\n");
    }

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