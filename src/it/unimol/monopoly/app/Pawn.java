package it.unimol.monopoly.app;

import javax.swing.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * Class that defines the Pawn object, chosen by each player before the start of the match. Every pawn is made up of
 * a name, and a shape that represents it. The pawn's shape is an {@link ImageIcon} and not an {@code Image} to make some
 * UI method calls easier, since they necessarily require the presence of an {@code ImageIcon}.
 *
 * @author Angelo Trotta
 * @version 1.0
 */

public class Pawn implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private ImageIcon shape;

    /**
     * It creates a Pawn object.
     *
     * @param name Name of the pawn.
     * @param shape Shape of the pawn.
     */
    public Pawn(String name, ImageIcon shape) {
        this.name = name;
        this.shape = shape;
    }

    public String getName() {
        return name;
    }

    public ImageIcon getShape() {
        return shape;
    }

    /**
     * It verifies the equality between two pawns.
     *
     * @param o Takes a generic object in input, executes the casting to a Player object, and checks if the two objects
     *          are equal by name. See {@link Object#equals(Object)} for more information.
     * @return {@code true} if the equality is verified, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pawn pawn = (Pawn) o;
        return name.equals(pawn.name);
    }

    /**
     * It gives a hash of the Pawn object by name.
     *
     * @return A generated hash by name of the corresponding pawn.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
