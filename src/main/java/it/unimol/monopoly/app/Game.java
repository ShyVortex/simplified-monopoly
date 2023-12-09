package it.unimol.monopoly.app;

import java.util.Random;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * Initialization class of the game of Monopoly.
 * The methods in this class are used only once. In fact, the moment the user clicks on the button
 * "Start Game" inside the {@link it.unimol.monopoly.gui.forms.MainForm}, all the below methods are called, and they provide
 * the creation of the contracts, the order of the players' turns and the automatic purchase of initial contracts.
 * If the state of the game is saved and the application closed and re-executed, this class won't be called anymore,
 * as everything that had to be generated was successfully done and saved on file.
 *
 * @author Angelo Trotta
 * @version 1.0
 */

public class Game {
    private int startingMoney;
    private int initialContracts;
    public static final String releaseVersion = "2.1.1";

    /**
     * The variables of the class are set based on the number of players registered in the {@link PlayerManager}.
     *
     * @param players The player manager is passed in input.
     */
    public Game(PlayerManager players) {
        switch (players.getPlayers().size()) {
            case 2:
                this.startingMoney = 8750;
                this.initialContracts = 7;
                break;
            case 3:
                this.startingMoney = 7500;
                this.initialContracts = 6;
                break;
            case 4:
                this.startingMoney = 6250;
                this.initialContracts = 5;
                break;
            case 5:
                this.startingMoney = 5000;
                this.initialContracts = 4;
                break;
            case 6:
                this.startingMoney = 3750;
                this.initialContracts = 3;
                break;
            default:
        }
    }

    /**
     * It sets the starting quantity of money obtained from the constructor to all players in the game.
     *
     * @param players The player manager.
     */
    public void setPlayersMoney(PlayerManager players) {
        for (Player player : players.getPlayers().values()) {
            player.setMoney(this.startingMoney);
        }
    }

    /**
     * It sets the number of initial contracts obtained from the constructor to all players in the game.
     *
     * @param players The player manager.
     */
    public void setInitialContractsNum(PlayerManager players) {
        for (Player player : players.getPlayers().values()) {
            player.setNumContracts(this.initialContracts);
        }
    }

    /**
     * It generates an order for all players' turns. The method works first of all by creating a list of integers,
     * to which the IDs of each player are incremented by one and then added, going from the value of 1 to the
     * maximum of 6. After that, the list is randomly shuffled, obtaining a set of random IDs from 1 to 6.
     * The player IDs in the current manager are then updated, but it still has the previous order of the turns.
     * So, to finish, a new, updated manager is created, which has the new order, and it's returned to the caller.
     *
     * @param players The player manager.
     * @return A new instance of the {@code PlayerManager} with the updated order.
     */
    public PlayerManager generateOrder(PlayerManager players) {
        List<Integer> playersOrder = new ArrayList<>();
        for (int i = 0; i < players.getPlayers().size(); i++)
            playersOrder.add(i+1);
        Collections.shuffle(playersOrder, new Random());
        int i = 0;
        for (Player player : players.getPlayers().values()) {
            player.setId(playersOrder.get(i));
            i++;
        }
        PlayerManager randomPlayers = new PlayerManager();
        for (Player player : players.getPlayers().values()) {
            randomPlayers.getPlayers().put(player.getId(), player);
        }
        return randomPlayers;
    }

    /**
     * It finds the player with the smallest possible ID inside the new player manager updated with a random order of turns,
     * who will be the first player to start the match.
     *
     * @param players The player manager.
     * @return The starting player.
     */
    public Player setFirstPlayer(PlayerManager players) {
        int minId = Collections.min(players.getPlayers().keySet());
        Player player = players.getPlayers().get(minId);

        return player;
    }

    /**
     * All the Monopoly contracts are first created, then added to the contract manager.
     * Check the monopoly rules for more information.
     *
     * @param contracts The contract manager is passed in input.
     * @return The updated contract manager.
     */
    public ContractManager setMatchContracts(ContractManager contracts) {
        Contract mediterraneanAvenue = new Contract("Mediterranean Avenue", 60, 2);
        Contract balticAvenue = new Contract("Baltic Avenue", 60, 4);
        Contract waterWorks = new Contract("Water Works", 80, 5);
        Contract readingRailroad = new Contract("Reading Railroad", 200, 25);
        Contract orientalAvenue = new Contract("Oriental Avenue", 100, 6);
        Contract vermontAvenue = new Contract("Vermont Avenue", 100, 6);
        Contract connecticutAvenue = new Contract("Connecticut Avenue", 120, 8);
        Contract stCharlesPlace = new Contract("St. Charles Place", 140, 10);
        Contract statesAvenue = new Contract("States Avenue", 140, 10);
        Contract virginiaAvenue = new Contract("Virginia Avenue", 160, 12);
        Contract pennsylvaniaRailroad = new Contract("Pennsylvania Railroad", 200, 25);
        Contract stJamesPlace = new Contract("St. James Place", 180, 14);
        Contract tennesseeAvenue = new Contract("Tennessee Avenue", 180, 14);
        Contract newYorkAvenue = new Contract("New York Avenue", 200, 16);
        Contract kentuckyAvenue = new Contract("Kentucky Avenue", 220, 18);
        Contract indianaAvenue = new Contract("Indiana Avenue", 220, 18);
        Contract illinoisAvenue = new Contract("Illinois Avenue", 240, 20);
        Contract bEoRailroad = new Contract("B.&.O. Railroad", 200, 25);
        Contract atlanticAvenue = new Contract("Atlantic Avenue", 260, 22);
        Contract ventnorAvenue = new Contract("Ventnor Avenue", 260, 22);
        Contract marvinGardens = new Contract("Marvin Gardens", 280, 24);
        Contract pacificAvenue = new Contract("Pacific Avenue", 300, 26);
        Contract northCarolinaAvenue = new Contract("North Carolina Avenue", 300, 26);
        Contract pennsylvaniaAvenue = new Contract("Pennsylvania Avenue", 320, 28);
        Contract shortLine = new Contract("Short Line", 200, 25);
        Contract electricCompany = new Contract("Electric Company", 130, 10);
        Contract parkPlace = new Contract("Park Place", 350, 35);
        Contract boardWalk = new Contract("Boardwalk", 400, 40);

        contracts.addContract(mediterraneanAvenue.getId(), mediterraneanAvenue);
        contracts.addContract(balticAvenue.getId(), balticAvenue);
        contracts.addContract(waterWorks.getId(), waterWorks);
        contracts.addContract(readingRailroad.getId(), readingRailroad);
        contracts.addContract(orientalAvenue.getId(), orientalAvenue);
        contracts.addContract(vermontAvenue.getId(), vermontAvenue);
        contracts.addContract(connecticutAvenue.getId(), connecticutAvenue);
        contracts.addContract(stCharlesPlace.getId(), stCharlesPlace);
        contracts.addContract(statesAvenue.getId(), statesAvenue);
        contracts.addContract(virginiaAvenue.getId(), virginiaAvenue);
        contracts.addContract(pennsylvaniaRailroad.getId(), pennsylvaniaRailroad);
        contracts.addContract(stJamesPlace.getId(), stJamesPlace);
        contracts.addContract(tennesseeAvenue.getId(), tennesseeAvenue);
        contracts.addContract(newYorkAvenue.getId(), newYorkAvenue);
        contracts.addContract(kentuckyAvenue.getId(), kentuckyAvenue);
        contracts.addContract(indianaAvenue.getId(), indianaAvenue);
        contracts.addContract(illinoisAvenue.getId(), illinoisAvenue);
        contracts.addContract(bEoRailroad.getId(), bEoRailroad);
        contracts.addContract(atlanticAvenue.getId(), atlanticAvenue);
        contracts.addContract(ventnorAvenue.getId(), ventnorAvenue);
        contracts.addContract(marvinGardens.getId(), marvinGardens);
        contracts.addContract(pacificAvenue.getId(), pacificAvenue);
        contracts.addContract(northCarolinaAvenue.getId(), northCarolinaAvenue);
        contracts.addContract(pennsylvaniaAvenue.getId(), pennsylvaniaAvenue);
        contracts.addContract(shortLine.getId(), shortLine);
        contracts.addContract(electricCompany.getId(), electricCompany);
        contracts.addContract(parkPlace.getId(), parkPlace);
        contracts.addContract(boardWalk.getId(), boardWalk);

        return contracts;
    }

    /**
     * Initial contracts are generated for each player, until a maximum value, given by the variable {@link #initialContracts}.
     * The method works by creating an empty list of contracts first, then adding available contracts to that, which are
     * randomly shuffled. From this bigger list, another, more compact one, is created, and this will have a number of
     * contracts given by the variable quoted above.
     *
     * @param contracts The contract manager.
     * @return The compact list of random contracts.
     */
    public List<Contract> generateRandomContracts(ContractManager contracts) {
        List<Contract> listContracts = new ArrayList<>();
        for (Contract element : contracts.getContracts().values()) {
            if (element.isAvailable())
                listContracts.add(element);
        }
        Collections.shuffle(listContracts);
        List<Contract> compactList = new ArrayList<>();
        for (int i = 0; i < this.initialContracts; i++) {
            compactList.add(listContracts.get(i));
        }
        return compactList;
    }

    /**
     * Once initial contracts are generated for every player, they all need to be purchased. This is an always possible
     * operation since the starting quantity of money for each player is much greater than their cost.
     * So, a small quantity of money, equal to the cost of the contracts, is subtracted from each player.
     *
     * @param player The player passed in input.
     * @param contracts The list of initial owned contracts by the player.
     * @return The sum of the price of all contracts.
     */
    public int buyInitialContracts(Player player, List<Contract> contracts) {
        assert contracts != null;

        int sum = 0;
        for (int i = 0; i < player.getNumContracts(); i++) {
            Contract casuale = contracts.get(i);
            casuale.buyInitialContract(player, casuale);
            sum += casuale.getPrice();
        }
        return sum;
    }
}
