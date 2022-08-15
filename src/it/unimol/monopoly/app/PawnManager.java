package it.unimol.monopoly.app;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Singleton that manages all the different pawns. Pawns are automatically created by the method {@link #setDefaultPawns()},
 * and added to a key-value map where the key is a string with the pawn's name and the value is the pawn itself.
 * Everything is executed starting from the constructor, which calls the method quoted above.
 *
 * @author Angelo Trotta
 * @version 1.0
 */

public class PawnManager {
    private Map<String, Pawn> pawns;
    private static PawnManager instance = new PawnManager();

    private PawnManager() {
        this.pawns = new HashMap<>();
        setDefaultPawns();
    }

    public static PawnManager getInstance() {
        return instance;
    }

    public Map<String, Pawn> getPawns() {
        return pawns;
    }

    private void setDefaultPawns() {
        try {
            Image barrowPic = ImageIO.read(new File("src/it/unimol/monopoly/pawns/Wheelbarrow.png"));
            Image shoePic = ImageIO.read(new File("src/it/unimol/monopoly/pawns/Shoe.png"));
            Image dogPic = ImageIO.read(new File("src/it/unimol/monopoly/pawns/Dog.png"));
            Image carPic = ImageIO.read(new File("src/it/unimol/monopoly/pawns/Car.png"));
            Image hatPic = ImageIO.read(new File("src/it/unimol/monopoly/pawns/TopHat.png"));
            Image shipPic = ImageIO.read(new File("src/it/unimol/monopoly/pawns/Battleship.png"));

            ImageIcon barrowIcon = new ImageIcon(barrowPic);
            ImageIcon shoeIcon = new ImageIcon(shoePic);
            ImageIcon dogIcon = new ImageIcon(dogPic);
            ImageIcon carIcon = new ImageIcon(carPic);
            ImageIcon hatIcon = new ImageIcon(hatPic);
            ImageIcon shipIcon = new ImageIcon(shipPic);

            Pawn wheelbarrow = new Pawn("WHEELBARROW", barrowIcon);
            Pawn shoe = new Pawn("SHOE", shoeIcon);
            Pawn dog = new Pawn("DOG", dogIcon);
            Pawn car = new Pawn("CAR", carIcon);
            Pawn topHat = new Pawn("TOP HAT", hatIcon);
            Pawn battleship = new Pawn("BATTLESHIP", shipIcon);

            this.pawns.put("WHEELBARROW", wheelbarrow);
            this.pawns.put("SHOE", shoe);
            this.pawns.put("DOG", dog);
            this.pawns.put("CAR", car);
            this.pawns.put("TOP HAT", topHat);
            this.pawns.put("BATTLESHIP", battleship);
        } catch (IOException ignored) {}
    }
}
