package it.unimol.monopoly.app;

import it.unimol.monopoly.threads.Countdown;
import it.unimol.monopoly.threads.StoppableThread;

import static java.lang.System.exit;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        int timeInt = 0;
        Countdown timer = new Countdown();
        StoppableThread testThread;

        timer.start(timer);

        testThread = new StoppableThread(new Runnable() {
            @Override
            public void run() {
                while (timer.isRunning()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ignored) {}
                    System.out.println("it.unimol.monopoly.app.Test");
                }
            }
        });
        testThread.start(testThread);


        while (timer.isRunning()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {}
            timeInt++;
            System.out.println(timeInt);
        }

        timer.join();
        testThread.join();

        exit(0);
    }
}
