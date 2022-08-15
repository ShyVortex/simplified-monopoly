package it.unimol.monopoly.app;

/**
 * A short class that handles the logic of rent payments.
 * @author Angelo Trotta
 * @version 1.0
 */

public class Rent {
    /**
     * It manages the payment of rent between two players.
     *
     * @param player1 Current player.
     * @param player2 Player to pay rent to.
     * @param contract Contract bought by {@code player2}, of which {@code player1} has to pay the rent.
     * @return {@code true} if the payment was successful, false otherwise, resetting {@code giocatore1}'s bank account.
     * a 0.
     */
    public boolean payRent(Player player1, Player player2, Contract contract) {
        if (player1.getMoney() >= contract.getRentValue()) {
            player1.subMoney(contract.getRentValue());
            player2.addMoney(contract.getRentValue());
            return true;
        }
        else {
            player2.addMoney(player1.getMoney());
            player1.setMoney(0);
            return false;
        }
    }
}