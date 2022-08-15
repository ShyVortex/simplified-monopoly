package it.unimol.monopoly.app;

/**
 * Simple class that defines the Fee object. Each fee is composed of an integer variable that represents the value of
 * money to pay, and a method to allow the payment itself.
 *
 * @author Angelo Trotta
 * @version 1.0
 */

public class Fee {
    private int value;

    /**
     * It creates a Fee object.
     *
     * @param value The fee's value to pay.
     */
    public Fee(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    /**
     * It allows the payment of the fee. If the player who needs to pay doesn't have enough money, his bank account
     * is reset.
     *
     * @param player The player who has to pay.
     * @return {@code true} if the payment was successful, {@code false} otherwise.
     */
    public boolean payFee(Player player) {
        if (player.getMoney() >= this.value) {
            player.subMoney(this.value);
            return true;
        }
        else {
            player.setMoney(0);
            return false;
        }
    }
}