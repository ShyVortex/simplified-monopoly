package it.unimol.monopoly.app;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {
    public static void main(String[] args) throws IOException {
        Image carPic = ImageIO.read(new File("src/it/unimol/monopoly/pawns/Car.png"));
        ImageIcon carIcon = new ImageIcon(carPic);
        Pawn car = new Pawn("CAR", carIcon);

        Image shoePic = ImageIO.read(new File("src/it/unimol/monopoly/pawns/Shoe.png"));
        ImageIcon shoeIcon = new ImageIcon(shoePic);
        Pawn shoe = new Pawn("SHOE", shoeIcon);

        assertNotNull(car);
        assertNotNull(shoe);
        assertNotEquals(car, shoe);

        Pawn test = new Pawn("CAR", carIcon);

        assertNotNull(test);
        assertEquals(car, test);

        System.out.println("TEST SUCCESSFUL.");
    }
}