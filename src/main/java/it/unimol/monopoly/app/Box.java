package it.unimol.monopoly.app;

import java.util.Objects;

/**
 * Class that logically represents a box. It wants to be of support to the "physical" creation, through
 * graphical interface, of the {@code JLabels} describing the ingame boxes.
 *
 * @author Angelo Trotta
 * @version 1.0
 */

public class Box {
    private String name;
    private int id;
    public static int aux = 0;

    /**
     * It creates a Box object.
     *
     * @param name name of the box.
     */
    public Box(String name) {
        this.name = name;
        this.id = aux;
        aux++;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * It verifies the equality between two boxes.
     *
     * @param o Takes a generic object in input, executes the casting to a Box object, and checks if the two objects
     *          are equal by ID and name. See {@link Object#equals(Object)} for more information.
     * @return A boolean variable whose value is {@code true} if the equality is verified, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box box = (Box) o;
        return id == box.id && name.equals(box.name);
    }

    /**
     * It gives a hash of the Box object for name and ID.
     *
     * @return A hash of the corresponding box, generated by name and ID.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
