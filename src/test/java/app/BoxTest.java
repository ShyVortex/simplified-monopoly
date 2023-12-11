package app;

import it.unimol.monopoly.app.Box;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test for the Box class")
class BoxTest {
    @Test
    public void mainTest() {
        Box box1 = new Box("Test1");
        Box box2 = new Box("Test2");

        assertNotNull(box1);
        assertNotNull(box2);

        assertNotEquals(box1, box2);

        box1.setName("test");
        box2.setName("test");
        System.out.println(box1.getId());
        System.out.println(box2.getId());

        assertNotEquals(box1, box2);
        assertEquals(box1.getName(), box2.getName());

        box1.setId(0);
        box2.setId(0);
        System.out.println(box1.getId() + " " + box1.getName());
        System.out.println(box2.getId() + " " + box2.getName());

        assertEquals(box1, box2);

        box1.setName(null);
        box2.setName(null);

        assertNull(box1.getName());
        assertNull(box2.getName());

        System.out.println("\nTEST SUCCESSFUL.\n");
        Box.aux = 0;
    }
}