package it.unimol.monopoly.threads.interfaces;

import it.unimol.monopoly.threads.Countdown;
import it.unimol.monopoly.threads.StoppableThread;

/**
 * Interface that defines the signatures of the new methods to start or stop the execution of a thread of the type
 * {@link StoppableThread} or {@link Countdown}.
 *
 * @author Angelo Trotta
 * @version 1.0
 */

public interface Stoppable {
    /**
     * It checks if a process by either {@link StoppableThread} or {@link Countdown} is running.
     *
     * @return {@code true} if the running flag is also true, {@code false} otherwise.
     */
    boolean isRunning();

    /**
     * It defines the stop of execution of a {@link StoppableThread}.
     *
     * @param thread The thread to stop.
     */
    void stop(StoppableThread thread);

    /**
     * It defines the stop of execution of a {@link Countdown} thread.
     *
     * @param timer The timer to stop.
     */
    void stop(Countdown timer);
}
