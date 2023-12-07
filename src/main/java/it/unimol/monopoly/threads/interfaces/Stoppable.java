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
     * It defines the start of execution of a {@link StoppableThread}.
     *
     * @param thread The thread to execute.
     */
    public void start(StoppableThread thread);

    /**
     * It defines the start of execution of a {@link Countdown} thread.
     *
     * @param timer The timer to start.
     */
    public void start(Countdown timer);

    /**
     * It defines the stop of execution of a {@link StoppableThread}.
     *
     * @param thread The thread to stop.
     */
    public void stop(StoppableThread thread);

    /**
     * It defines the stop of execution of a {@link Countdown} thread.
     *
     * @param timer The timer to stop.
     */
    public void stop(Countdown timer);
}
