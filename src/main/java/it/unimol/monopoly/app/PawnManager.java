package it.unimol.monopoly.app;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
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
            URL barrowUrl = this.getClass().getResource("/pawns/Wheelbarrow.png");
            URL shoeUrl = this.getClass().getResource("/pawns/Shoe.png");
            URL dogUrl = this.getClass().getResource("/pawns/Dog.png");
            URL carUrl = this.getClass().getResource("/pawns/Car.png");
            URL hatUrl = this.getClass().getResource("/pawns/TopHat.png");
            URL shipUrl = this.getClass().getResource("/pawns/Battleship.png");

            assert barrowUrl != null;
            assert shoeUrl != null;
            assert dogUrl != null;
            assert carUrl != null;
            assert hatUrl != null;
            assert shipUrl != null;

            Image barrowPic = ImageIO.read(barrowUrl);
            Image shoePic = ImageIO.read(shoeUrl);
            Image dogPic = ImageIO.read(dogUrl);
            Image carPic = ImageIO.read(carUrl);
            Image hatPic = ImageIO.read(hatUrl);
            Image shipPic = ImageIO.read(shipUrl);

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
