package it.unimol.monopoly.app;

import java.util.HashMap;
import java.util.Map;

/**
 * Singleton that manages player positions, which works together with the {@link Box} class. Once all the boxes
 * representing positions are automatically created through the method {@link #setPositions()}, they are
 * saved inside a key-value map where the key is each box's ID and the value is the box itself.
 * Everything is executed starting from the constructor, which calls the method quoted above.
 *
 * @author Angelo Trotta
 * @version 1.0
 */

public class PositionManager {
    private static final PositionManager instance = new PositionManager();
    private final Map<Integer, Box> positions;

    /**
     * Special variable whose value is equal to the "GO" box's ID. It's used to facilitate the reading of the code
     * in other classes.
     */
    public static final int GO = 0;

    /**
     * Special variable whose value is equal to the "PRISON" box's ID. It's used to facilitate the reading of the code
     * in other classes.
     */
    public static final int PRISON = 7;

    /**
     * Special variable whose value is equal to the "PARKING" box's ID. It's used to facilitate the reading of the code
     * in other classes.
     */
    public static final int PARKING = 15;

    /**
     * Special variable whose value is equal to the "TRANSIT" box's ID. It's used to facilitate the reading of the code
     * in other classes.
     */
    public static final int TRANSIT = 23;

    private PositionManager() {
        this.positions = new HashMap<>();
        this.setPositions();
    }

    public static PositionManager getInstance() {
        return instance;
    }

    public Map<Integer, Box> getPositions() {
        return positions;
    }

    private void setPositions() {
        Box go = new Box("GO");
        Box mediterraneanAvenue = new Box("Mediterranean Avenue");
        Box balticAvenue = new Box("Baltic Avenue");
        Box readingRailroad = new Box("Reading Railroad");
        Box orientalAvenue = new Box("Oriental Avenue");
        Box vermontAvenue = new Box("Vermont Avenue");
        Box connecticutAvenue = new Box("Connecticut Avenue");
        Box prison = new Box("PRISON");
        Box stCharlesPlace = new Box("St. Charles Place");
        Box statesAvenue = new Box("States Avenue");
        Box virginiaAvenue = new Box("Virginia Avenue");
        Box pennsylvaniaRailroad = new Box("Pennsylvania Railroad");
        Box stJamesPlace = new Box("St. James Place");
        Box tennesseeAvenue = new Box("Tennessee Avenue");
        Box newYorkAvenue = new Box("New York Avenue");
        Box parking = new Box("PARKING");
        Box kentuckyAvenue = new Box("Kentucky Avenue");
        Box indianaAvenue = new Box("Indiana Avenue");
        Box illinoisAvenue = new Box("Illinois Avenue");
        Box bEoRailroad = new Box("B.&.O. Railroad");
        Box atlanticAvenue = new Box("Atlantic Avenue");
        Box ventnorAvenue = new Box("Ventnor Avenue");
        Box marvinGardens = new Box("Marvin Gardens");
        Box transit = new Box("TRANSIT");
        Box pacificAvenue = new Box("Pacific Avenue");
        Box northCarolinaAvenue = new Box("North Carolina Avenue");
        Box pennsylvaniaAvenue = new Box("Pennsylvania Avenue");
        Box shortLine = new Box("Short Line");
        Box parkPlace = new Box("Park Place");
        Box boardWalk = new Box("Boardwalk");

        this.positions.put(go.getId(), go);
        this.positions.put(mediterraneanAvenue.getId(), mediterraneanAvenue);
        this.positions.put(balticAvenue.getId(), balticAvenue);
        this.positions.put(readingRailroad.getId(), readingRailroad);
        this.positions.put(orientalAvenue.getId(), orientalAvenue);
        this.positions.put(vermontAvenue.getId(), vermontAvenue);
        this.positions.put(connecticutAvenue.getId(), connecticutAvenue);
        this.positions.put(prison.getId(), prison);
        this.positions.put(stCharlesPlace.getId(), stCharlesPlace);
        this.positions.put(statesAvenue.getId(), statesAvenue);
        this.positions.put(virginiaAvenue.getId(), virginiaAvenue);
        this.positions.put(pennsylvaniaRailroad.getId(), pennsylvaniaRailroad);
        this.positions.put(stJamesPlace.getId(), stJamesPlace);
        this.positions.put(tennesseeAvenue.getId(), tennesseeAvenue);
        this.positions.put(newYorkAvenue.getId(), newYorkAvenue);
        this.positions.put(parking.getId(), parking);
        this.positions.put(kentuckyAvenue.getId(), kentuckyAvenue);
        this.positions.put(indianaAvenue.getId(), indianaAvenue);
        this.positions.put(illinoisAvenue.getId(), illinoisAvenue);
        this.positions.put(bEoRailroad.getId(), bEoRailroad);
        this.positions.put(atlanticAvenue.getId(), atlanticAvenue);
        this.positions.put(ventnorAvenue.getId(), ventnorAvenue);
        this.positions.put(marvinGardens.getId(), marvinGardens);
        this.positions.put(transit.getId(), transit);
        this.positions.put(pacificAvenue.getId(), pacificAvenue);
        this.positions.put(northCarolinaAvenue.getId(), northCarolinaAvenue);
        this.positions.put(pennsylvaniaAvenue.getId(), pennsylvaniaAvenue);
        this.positions.put(shortLine.getId(), shortLine);
        this.positions.put(parkPlace.getId(), parkPlace);
        this.positions.put(boardWalk.getId(), boardWalk);
    }
}
