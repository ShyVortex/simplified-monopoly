package it.unimol.monopoly.app;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * Class that defines the Contract object, with all the logical methods for purchasing a contract, paying rent
 * and checking if multiple contracts are equal. Each contract gets automatically created when the match starts
 * and then added to a map inside the {@link ContractManager}.
 * It implements the {@link Serializable} interface since the state of every contract is saved on a file.
 *
 * @author Angelo Trotta
 * @version 2.0
 */

public class Contract implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;
    private String name;
    private int id;
    private int price;
    private int rentValue;
    private boolean isAvailable;
    private static int aux = 1;
    /**
     * Counter variable to support other classes, used to handle the contract IDs at best and avoid
     * eventual exceptions or unexpected events during the game.
     */
    public static int i = 1;

    /**
     * It creates a Contract object.
     *
     * @param name Name of the contract.
     * @param price Price of the contract.
     * @param rentValue Value of the rent's price, once a contract is purchased by a player.
     */
    public Contract(String name, int price, int rentValue) {
        this.name = name;
        this.price = price;
        this.rentValue = rentValue;
        this.id = aux;
        aux++;
        this.isAvailable = true;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public int getPrice() {
        return this.price;
    }

    public int getRentValue() {
        return this.rentValue;
    }

    /**
     * It verifies the availability of a contract, indicating if it has been purchased already or not.
     *
     * @return {@code true} if the contract was purchased, {@code false} otherwise.
     */
    public boolean isAvailable() {
        return this.isAvailable;
    }

    public void setAvailability(boolean available) {
        isAvailable = available;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * It resets the private counter {@code aux} of Contract, utilized to dynamically increment the contract IDs
     * at the time of their creation. The method is only used for testing purposes.
     */
    public static void resetCounter() {
        aux = 1;
    }

    /**
     * It allows the automatic purchase of initial contracts for each player at the start of the match.
     *
     * @param player Buyer
     * @param contract Random contract passed from the {@link ContractManager}, which constitutes an initial contract.
     */
    public void buyInitialContract(Player player, Contract contract) {
        if (contract.isAvailable()) {
            contract.isAvailable = false;
            player.subMoney(contract.price);
            player.getContracts().add(contract);
        }
    }

    /**
     * Method to purchase a contract.
     *
     * @param player Player who has to buy a contract.
     * @param contract Contract to acquire.
     * @return {@code true} if the purchase was successful, {@code false} otherwise.
     */
    public boolean buyContract(Player player, Contract contract) {
        if (contract.isAvailable()) {
            if (player.getMoney() >= contract.price) {
                contract.isAvailable = false;
                player.subMoney(contract.price);
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

    /**
     * Alternative representation of the Contract object as string.
     *
     * @return A string of the contract's instance on whom the method was called.
     */
    public String altToString() {
        return i++ + ". " + this.name;
    }

    /**
     * Standard representation of the Contract object as string. It overrides the method {@link Object#toString()}.
     *
     * @return A string of the contract's instance on whom the method was called.
     */
    public String toString() {
        if (this.isAvailable) {
            return this.id + ". " + this.name + " (" + "Price: " + this.price + "€, " + "Rent: " + this.rentValue + "€) " + "| "
            + "AVAILABLE";
        }
        else {
            return this.id + ". " + this.name + " (" + "Price: " + this.price + "€, " + "Rent: " + this.rentValue + "€) " + "| "
            + "UNAVAILABLE";
        } 
    }

    /**
     * It verifies the equality between two contracts.
     *
     * @param o Takes a generic object in input, executes the casting to a Contract object, and checks if the two objects
     *          are equal by ID, price, rent, and availability. See {@link Object#equals(Object)} for more information.
     * @return {@code true} if the equality is verified, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return price == contract.price && rentValue == contract.rentValue && isAvailable == contract.isAvailable
                && name.equals(contract.name);
    }

    /**
     * It gives a hash of the Contract object by name, ID, price, rent and availability.
     *
     * @return A hash generated from the parameters indicated above of the corresponding contract.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, id, price, rentValue, isAvailable);
    }
}