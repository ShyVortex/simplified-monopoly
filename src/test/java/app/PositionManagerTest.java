package app;

import it.unimol.monopoly.app.Box;
import it.unimol.monopoly.app.PositionManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test for the Position Manager")
class PositionManagerTest {
    @Test
    public void mainTest() {
        Map<Integer, Box> positions = new HashMap<>();

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

        positions.put(go.getId(), go);
        positions.put(mediterraneanAvenue.getId(), mediterraneanAvenue);
        positions.put(balticAvenue.getId(), balticAvenue);
        positions.put(readingRailroad.getId(), readingRailroad);
        positions.put(orientalAvenue.getId(), orientalAvenue);
        positions.put(vermontAvenue.getId(), vermontAvenue);
        positions.put(connecticutAvenue.getId(), connecticutAvenue);
        positions.put(prison.getId(), prison);
        positions.put(stCharlesPlace.getId(), stCharlesPlace);
        positions.put(statesAvenue.getId(), statesAvenue);
        positions.put(virginiaAvenue.getId(), virginiaAvenue);
        positions.put(pennsylvaniaRailroad.getId(), pennsylvaniaRailroad);
        positions.put(stJamesPlace.getId(), stJamesPlace);
        positions.put(tennesseeAvenue.getId(), tennesseeAvenue);
        positions.put(newYorkAvenue.getId(), newYorkAvenue);
        positions.put(parking.getId(), parking);
        positions.put(kentuckyAvenue.getId(), kentuckyAvenue);
        positions.put(indianaAvenue.getId(), indianaAvenue);
        positions.put(illinoisAvenue.getId(), illinoisAvenue);
        positions.put(bEoRailroad.getId(), bEoRailroad);
        positions.put(atlanticAvenue.getId(), atlanticAvenue);
        positions.put(ventnorAvenue.getId(), ventnorAvenue);
        positions.put(marvinGardens.getId(), marvinGardens);
        positions.put(transit.getId(), transit);
        positions.put(pacificAvenue.getId(), pacificAvenue);
        positions.put(northCarolinaAvenue.getId(), northCarolinaAvenue);
        positions.put(pennsylvaniaAvenue.getId(), pennsylvaniaAvenue);
        positions.put(shortLine.getId(), shortLine);
        positions.put(parkPlace.getId(), parkPlace);
        positions.put(boardWalk.getId(), boardWalk);

        Box.aux = 0;
        PositionManager realPositions = PositionManager.getInstance();

        int i = 0;
        for (Box x : positions.values()) {
            Box y = realPositions.getPositions().get(i);
            assertEquals(x.getId(), y.getId());
            assertEquals(x.getName(), y.getName());
            assertNotSame(x.hashCode(), y.hashCode());
            i++;
        }

        System.out.println("TEST SUCCESSFUL.\n");
        Box.aux = 0;
    }
}