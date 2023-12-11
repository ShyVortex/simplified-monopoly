package app;

import it.unimol.monopoly.threads.Countdown;
import it.unimol.monopoly.threads.StoppableThread;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.System.exit;

@DisplayName("Test for threads")
public class ThreadTest {
    @Test
    public void mainTest() throws InterruptedException {
        int timeInt = 0;
        Countdown timer = new Countdown();
        StoppableThread testThread;

        timer.start(timer);

        testThread = new StoppableThread(() -> {
            while (timer.isRunning()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("OK");
            }
        });
        testThread.start(testThread);


        while (timer.isRunning() && timeInt < 5) {
            try {
                if (timeInt == 4) {
                    testThread.stop(testThread);
                    timer.stop(timer);
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timeInt++;
            System.out.println(timeInt);
        }
        timer.join();
        testThread.join();

        assert !timer.isJobCompleted() && !testThread.isAlive();
        System.out.println("TERMINATED");

        System.out.println("\nALL TESTS SUCCESSFUL.\n");
    }
}
