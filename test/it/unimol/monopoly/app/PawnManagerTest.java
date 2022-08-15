package it.unimol.monopoly.app;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PawnManagerTest {
    public static void main(String[] args) throws IOException {
        PawnManager pawns = PawnManager.getInstance();

        Image carPic = ImageIO.read(new File("src/it/unimol/monopoly/pawns/Car.png"));
        ImageIcon carIcon = new ImageIcon(carPic);
        Pawn car = new Pawn("CAR", carIcon);

        Image shoePic = ImageIO.read(new File("src/it/unimol/monopoly/pawns/Shoe.png"));
        ImageIcon shoeIcon = new ImageIcon(shoePic);
        Pawn shoe = new Pawn("SHOE", shoeIcon);

        Image barrowPic = ImageIO.read(new File("src/it/unimol/monopoly/pawns/Wheelbarrow.png"));
        ImageIcon barrowIcon = new ImageIcon(barrowPic);
        Pawn wheelbarrow = new Pawn("WHEELBARROW", barrowIcon);

        Image dogPic = ImageIO.read(new File("src/it/unimol/monopoly/pawns/Dog.png"));
        ImageIcon dogIcon = new ImageIcon(dogPic);
        Pawn dog = new Pawn("DOG", dogIcon);

        Image hatPic = ImageIO.read(new File("src/it/unimol/monopoly/pawns/TopHat.png"));
        ImageIcon hatIcon = new ImageIcon(hatPic);
        Pawn topHat = new Pawn("TOP HAT", hatIcon);

        Image shipPic = ImageIO.read(new File("src/it/unimol/monopoly/pawns/Battleship.png"));
        ImageIcon shipIcon = new ImageIcon(shipPic);
        Pawn battleship = new Pawn("BATTLESHIP", shipIcon);

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

        System.out.println("\nALL TESTS SUCCESSFUL.");
    }
}