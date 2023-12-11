package app;

import it.unimol.monopoly.app.Pawn;
import it.unimol.monopoly.app.PawnManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests for the Pawn Manager")
class PawnManagerTest {
    PawnManager pawns;
    Image carPic, shoePic, barrowPic, dogPic, hatPic, shipPic;
    ImageIcon carIcon, shoeIcon, barrowIcon, dogIcon, hatIcon, shipIcon;
    Pawn car, shoe, wheelbarrow, dog, topHat, battleship;

    @BeforeEach
    public void init() throws IOException {
        pawns = PawnManager.getInstance();

        carPic = ImageIO.read(new File("src/main/resources/pawns/Car.png"));
        carIcon = new ImageIcon(carPic);
        car = new Pawn("CAR", carIcon);

        shoePic = ImageIO.read(new File("src/main/resources/pawns/Shoe.png"));
        shoeIcon = new ImageIcon(shoePic);
        shoe = new Pawn("SHOE", shoeIcon);

        barrowPic = ImageIO.read(new File("src/main/resources/pawns/Wheelbarrow.png"));
        barrowIcon = new ImageIcon(barrowPic);
        wheelbarrow = new Pawn("WHEELBARROW", barrowIcon);

        dogPic = ImageIO.read(new File("src/main/resources/pawns/Dog.png"));
        dogIcon = new ImageIcon(dogPic);
        dog = new Pawn("DOG", dogIcon);

        hatPic = ImageIO.read(new File("src/main/resources/pawns/TopHat.png"));
        hatIcon = new ImageIcon(hatPic);
        topHat = new Pawn("TOP HAT", hatIcon);

        shipPic = ImageIO.read(new File("src/main/resources/pawns/Battleship.png"));
        shipIcon = new ImageIcon(shipPic);
        battleship = new Pawn("BATTLESHIP", shipIcon);
    }

    @Test
    public void mainTest() {
        assertNotNull(car);
        assertNotNull(shoe);
        assertNotNull(wheelbarrow);
        assertNotNull(dog);
        assertNotNull(topHat);
        assertNotNull(battleship);
        assertNotEquals(car, shoe);
        assertNotEquals(car, wheelbarrow);
        assertNotEquals(car, dog);
        assertNotEquals(car, topHat);
        assertNotEquals(car, battleship);
        assertNotEquals(shoe, wheelbarrow);
        assertNotEquals(shoe, dog);
        assertNotEquals(shoe, topHat);
        assertNotEquals(shoe, battleship);
        assertNotEquals(wheelbarrow, dog);
        assertNotEquals(wheelbarrow, topHat);
        assertNotEquals(wheelbarrow, battleship);
        assertNotEquals(dog, topHat);
        assertNotEquals(dog, battleship);
        assertNotEquals(topHat, battleship);

        if (pawns.getPawns().get("CAR").equals(car))
            System.out.println("TEST PASSED");
        if (pawns.getPawns().get("SHOE").equals(shoe))
            System.out.println("TEST PASSED");
        if (pawns.getPawns().get("WHEELBARROW").equals(wheelbarrow))
            System.out.println("TEST PASSED");
        if (pawns.getPawns().get("DOG").equals(dog))
            System.out.println("TEST PASSED");
        if (pawns.getPawns().get("TOP HAT").equals(topHat))
            System.out.println("TEST PASSED");
        if (pawns.getPawns().get("BATTLESHIP").equals(battleship))
            System.out.println("TEST PASSED");

        System.out.println("\nALL TESTS SUCCESSFUL.\n");
    }
}