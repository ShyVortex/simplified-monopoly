package app;

import it.unimol.monopoly.app.*;
import it.unimol.monopoly.gui.forms.RollForm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests for the Player class")
class PlayerTest {
    Image carPic, shoePic;
    ImageIcon carIcon, shoeIcon;
    Pawn car, shoe;
    Player player1, player2, player3;

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

        player3 = new Player("Angelo", car);
    }

    @Test
    public void mainTest() {
        assertNotNull(player1);
        assertNotNull(player2);
        assertNotNull(player3);
        assertNotEquals(player1, player2);

        assertNotNull(player3);
        assertNotEquals(player1, player3); // They're not equal yet because they have different IDs

        throwDice(player1);
        throwDice(player2);

        assertNotEquals(player1.getPosition(), 0);
        assertNotEquals(player2.getPosition(), 0);

        player1.getContracts().add(new Contract("Test", 100, 25));
        Contract.resetCounter();
        player3.getContracts().add(new Contract("Test", 100, 25));

        assertNotEquals(player1, player3); // They're not equal yet because they have different IDs

        player1.setPrisoner(true);

        assertNotEquals(player1, player3); // They're not equal yet because they have different IDs

        player1.setId(0);
        player3.setId(0);

        // Now they should be equal
        assertEquals(player1.getName(), player3.getName());
        assertEquals(player1.getId(), player3.getId());
        assertEquals(player1.getMoney(), player3.getMoney());
        assertEquals(player1.getPawn(), player3.getPawn());
        assertEquals(player1.getContracts(), player3.getContracts());
        assertEquals(player1.getNumContracts(), player3.getNumContracts());

        // except one is in prison, the other isn't
        assertNotEquals(player1.isPrisoner(), player3.isPrisoner());
        // one has rolled dice, the other hasn't
        assertNotEquals(player1.getPosition(), player3.getPosition());
        // they have different hashcodes
        assertNotSame(player1.hashCode(), player3.hashCode());

        System.out.println("TEST SUCCESSFUL.\n");
    }

    public void throwDice(Player player) {
        Random random = new Random();
        int passo = random.nextInt(6) + 1;
        player.addSteps(passo);
        if (player.getPosition() >= PositionManager.getInstance().getPositions().size()) {
            Turn turn = Turn.getInstance();
            turn.passThroughGO(player);
            int diff = player.getPosition() - PositionManager.getInstance().getPositions().size();
            player.setPosition(diff);
            RollForm.wentDownStart = true;
        }
    }
}