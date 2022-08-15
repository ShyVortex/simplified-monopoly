package it.unimol.monopoly.app;

import it.unimol.monopoly.gui.forms.RollForm;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    public static void main(String[] args) throws IOException {
        Image carPic = ImageIO.read(new File("src/it/unimol/monopoly/pawns/Car.png"));
        ImageIcon carIcon = new ImageIcon(carPic);
        Pawn car = new Pawn("CAR", carIcon);
        Player player1 = new Player("Angelo", car);

        Image shoePic = ImageIO.read(new File("src/it/unimol/monopoly/pawns/Shoe.png"));
        ImageIcon shoeIcon = new ImageIcon(shoePic);
        Pawn shoe = new Pawn("SHOE", shoeIcon);
        Player player2 = new Player("Antonio", shoe);

        assertNotNull(player1);
        assertNotNull(player2);
        assertNotEquals(player1, player2);

        Player player3 = new Player("Angelo", car);

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

        assertEquals(player1, player3); // Now they should be equal

        System.out.println("TEST SUCCESSFUL.");
    }

    @Test
    public static void throwDice(Player player) {
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