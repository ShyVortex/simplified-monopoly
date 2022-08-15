package it.unimol.monopoly.app;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ContractTest {
    public static void main(String[] args) throws IOException {
        Contract contract1 = new Contract("Test1", 100, 25);
        Contract contract2 = new Contract("Test2", 85, 15);

        Image carPic = ImageIO.read(new File("src/it/unimol/monopoly/pawns/Car.png"));
        ImageIcon carIcon = new ImageIcon(carPic);
        Pawn car = new Pawn("CAR", carIcon);
        Player player = new Player("Angelo", car);
        player.setMoney(500);

        assertNotNull(contract1);
        assertNotNull(contract2);
        assertNotNull(car);
        assertNotNull(player);

        assertNotEquals(contract1, contract2);

        Contract contract3 = new Contract("Test1", 100, 25);
        contract3.setId(contract1.getId());
        assertEquals(contract1, contract3);

        boolean firstTest = buyContract(player, contract1);
        boolean secondTest = buyContract(player, contract2);

        player.setMoney(0);

        boolean thirdTest = buyContract(player, contract1);
        boolean fourthTest = buyContract(player, contract2);

        if (firstTest && secondTest && !thirdTest && !fourthTest)
            System.out.println("TEST SUCCESSFUL.");
    }

    @Test
    public static boolean buyContract(Player player, Contract contract) {
        if (contract.isAvailable()) {
            if (player.getMoney() >= contract.getPrice()) {
                contract.setAvailability(false);
                player.subMoney(contract.getPrice());
                player.getContracts().add(contract);
                player.incNumContratti();
                return true;
            }
            else
                return false;
        }
        else {
            return false;
        }
    }
}