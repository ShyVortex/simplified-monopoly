package it.unimol.monopoly.app;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RentTest {

    RentTest() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        Image carPic = ImageIO.read(new File("src/it/unimol/monopoly/pawns/Car.png"));
        ImageIcon carIcon = new ImageIcon(carPic);
        Pawn car = new Pawn("CAR", carIcon);
        Player player1 = new Player("Angelo", car);

        Image shoePic = ImageIO.read(new File("src/it/unimol/monopoly/pawns/Shoe.png"));
        ImageIcon shoeIcon = new ImageIcon(shoePic);
        Pawn shoe = new Pawn("SHOE", shoeIcon);
        Player player2 = new Player("Antonio", shoe);

        Contract test1 = new Contract("Test1", 100, 25);
        Contract test2 = new Contract("Test2", 85, 15);

        player1.getContracts().add(test1);
        player2.getContracts().add(test2);

        player1.setMoney(500);
        player2.setMoney(500);

        assertNotNull(car);
        assertNotNull(shoe);
        assertNotNull(player1);
        assertNotNull(player2);

        boolean firstTest = payRent(player1, player2, test1);
        boolean secondTest = payRent(player1, player2, test2);
        boolean thirdTest = payRent(player2, player1, test1);
        boolean fourthTest = payRent(player2, player1, test2);

        if (firstTest && secondTest && thirdTest && fourthTest)
            System.out.println("TEST SUCCESSFUL.");
    }

    @Test
    public static boolean payRent(Player player1, Player player2, Contract contract) {
        if (player1.getMoney() >= contract.getRentValue()) {
            player1.subMoney(contract.getRentValue());
            player2.addMoney(contract.getRentValue());
            return true;
        }
        else {
            player2.addMoney(player1.getMoney());
            player1.setMoney(0);
            return false;
        }
    }
}