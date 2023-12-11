package app;

import it.unimol.monopoly.app.Contract;
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

@DisplayName("Tests for the Contract class")
class ContractTest {
    Contract contract1, contract2, contract3;
    Image carPic;
    ImageIcon carIcon;
    Pawn car;
    Player player;

    @BeforeEach
    public void init() throws IOException {
        contract1 = new Contract("Test1", 100, 25);
        contract2 = new Contract("Test2", 85, 15);

        carPic = ImageIO.read(new File("src/main/resources/pawns/Car.png"));
        carIcon = new ImageIcon(carPic);
        car = new Pawn("CAR", carIcon);
        player = new Player("Angelo", car);
        player.setMoney(500);

        contract3 = new Contract("Test1", 100, 25);
        contract3.setId(contract1.getId());
    }

    @Test
    public void mainTest() {
        assertNotNull(contract1);
        assertNotNull(contract2);
        assertNotNull(contract3);
        assertNotNull(car);
        assertNotNull(player);
        assertNotEquals(contract1, contract2);
        assertEquals(contract1, contract3);

        boolean firstTest = buyContract(player, contract1);
        boolean secondTest = buyContract(player, contract2);

        player.setMoney(0);

        boolean thirdTest = buyContract(player, contract1);
        boolean fourthTest = buyContract(player, contract2);

        if (firstTest && secondTest && !thirdTest && !fourthTest)
            System.out.println("TEST SUCCESSFUL.\n");
    }

    public boolean buyContract(Player player, Contract contract) {
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