package it.unimol.monopoly.app;

/**
 * Singleton that defines the Prison object. Prison is a place in which every player can randomly find themselves in
 * throwing dice. In fact, the obtained number can directly take a player to prison, or to the "Transit" box, which
 * takes them back to prison. Said object is composed of a private variable of Turn type, which constitutes the turn of
 * the player who went to prison, and of an integer variable containing the value of the Exit Fee. Once in prison,
 * it's only possible to leave or stay in.
 *
 * @author Angelo Trotta
 * @version 1.0
 */

public class Prison {

    private static Prison instance = new Prison();
    private Turn turn = Turn.getInstance();
    private final int exitFee = 125;

    private Prison() {}

    public static Prison getInstance() {
        return instance;
    }

    public int getExitFee() {
        return exitFee;
    }

    /**
     * It allows a free exit from prison, by setting the {@code isPrisoner} value of the {@link Player} instance to
     * {@code false}.
     *
     * @param player The player currently in prison.
     */
    public void freeExit(Player player) {
        player.setPrisoner(false);
    }

    /**
     * It allows to leave prison by paying a tax, possible only if the money owned by the player is greater than the
     * exit fee. If contrary to that, the player stays in prison.
     *
     * @param player The player currently in prison.
     * @return {@code true} if the player left prison, {@code false} otherwise.
     */
    public boolean paidExit(Player player) {
        if (player.getMoney() >= this.exitFee) {
            player.subMoney(this.exitFee);
            player.setPrisoner(false);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * It makes the player stay in prison, by ending their turn.
     *
     * @param player The player currently in prison.
     */
    public void stay(Player player) {
        turn.endTurn(player);
    }
}
