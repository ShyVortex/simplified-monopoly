package it.unimol.monopoly.app;

import it.unimol.monopoly.gui.forms.RollForm;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * Class that defines the Player object, one of the most important ones, because it allows the execution of all
 * those methods which require the need of a player. In fact, this class is strictly linked to almost all the others.
 * Every player is composed of a name, an ID, a quantity of money, a list of owned contracts, the number of
 * owned contracts, and a boolean variable that indicates if a player is prisoner or not. Each player gets added
 * to the map inside the {@link PlayerManager}.
 * It implements the {@link Serializable} interface because the state of every player is saved on a file.
 *
 * @author Angelo Trotta
 * @version 2.0
 */

public class Player implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;
    private String name;
    private int id;
    private int money;
    private List<Contract> ownedContracts;
    private int numContracts;
    private boolean isPrisoner;
    private Pawn pawn;
    private int position;
    /**
     * Counter variable of support to both this and other classes, used to dynamically increment the IDs
     * of each player the moment they are created, starting from 0, and manage them at best in collaboration with
     * other classes, avoiding possible exceptions or unexpected events during the game.
     */
    public static int aux = 0;

    /**
     * It creates a Player object.
     *
     * @param name Name of the player.
     * @param pawn Pawn chosen by the player.
     */
    public Player(String name, Pawn pawn) {
        this.name = name;
        this.pawn = pawn;
        this.id = aux;
        aux++;
        this.money = 0;
        this.ownedContracts = new ArrayList<>();
        this.numContracts = 0;
        this.position = 0;
        this.isPrisoner = false;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public int getMoney() {
        return this.money;
    }

    public int getNumContracts() {
        return this.numContracts;
    }

    public List<Contract> getContracts() {
        return this.ownedContracts;
    }

    public Pawn getPawn() {
        return pawn;
    }

    public int getPosition() {
        return position;
    }

    public boolean isPrisoner() {
        return this.isPrisoner;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * It adds money to the player's bank account.
     *
     * @param value Quantity of money to add.
     */
    public void addMoney(int value) {
        this.money += value;
    }

    /**
     * It subtracts money from the player's bank account.
     *
     * @param value Quantity of money to subtract.
     */
    public void subMoney(int value) {
        this.money -= value;
    }

    public void setNumContracts(int numContracts) {
        this.numContracts = numContracts;
    }

    public void incNumContratti() {
        this.numContracts++;
    }

    public void setPrisoner(boolean value) {
        this.isPrisoner = value;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * It moves the player by changing his position.
     *
     * @param steps The number obtained from the thrown dice.
     */
    public void addSteps(int steps) {
        this.position += steps;
    }

    /**
     * Method used in the {@link RollForm} so that each player can throw a die before starting their turn.
     * It implements the logic of throwing dice. A die has six faces, so a player can advance from 1 to 6 boxes.
     * Once exceeded the number of boxes inside the {@link PositionManager}, the player passes through the Start
     * and, if necessary, continues their movement.
     */
    public void rollDice() {
        Random random = new Random();
        int steps = random.nextInt(11) + 2; // 0-10 + 2 = 2-12
        this.addSteps(steps);
        if (this.position >= PositionManager.getInstance().getPositions().size()) {
            Turn turn = Turn.getInstance();
            turn.passThroughGO(this);
            int diff = this.position - PositionManager.getInstance().getPositions().size();
            this.setPosition(diff);
            RollForm.wentDownStart = true;
        }
    }

    /**
     * It checks if a player has money.
     *
     * @return {@code true} if the player has an empty bank account, {@code false} otherwise.
     */
    public boolean isPoor() {
        if (this.money <= 0)
            return true;
        else
            return false;
    }

    /**
     * Representation of the player's owned contracts as string.
     *
     * @return A string visualization of the list of owned contracts.
     */
    public String cPtoString() {
        assert this.ownedContracts != null;
        String result = "";
        for (Contract listContract : ownedContracts) {
            assert listContract != null;
            result += listContract.altToString() + "\n";
        }
        return result;
    }

    /**
     * Standard representation of the Player object as string.
     *
     * @return A string of the Player's instance on which the method was called.
     */
    @Override
    public String toString() {
        return this.id + ". " + this.name + "  ->  " + this.pawn.getName().toLowerCase();
    }

    /**
     * It verifies the equality between two players.
     *
     * @param o Takes a generic object in input, executes the casting to a Player object, and checks if the two objects
     *          are equal by ID, money, owned contracts, name and pawn. See {@link Object#equals(Object)} for more
     *          information.
     * @return {@code true} if the equality is verified, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id && money == player.money && numContracts == player.numContracts
                && name.equals(player.name) && ownedContracts.equals(player.ownedContracts) && pawn.equals(player.pawn);
    }

    /**
     * It gives a hash of the Player object by name, ID, money, owned contracts, number of contracts and pawn.
     *
     * @return A hash generated from the parameters indicated above of the corresponding player.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, id, money, ownedContracts, numContracts, pawn);
    }
}
  