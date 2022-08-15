package it.unimol.monopoly.threads;

import it.unimol.monopoly.threads.interfaces.Stoppable;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Class that defines a Countdown thread. This thread is an alternative to the class {@link Timer} natively
 * included in Java by default, with the particularity that it can be interrupted safely and without data loss
 * thanks to a new method {@link #stop(Countdown)} which replaces the deprecated one {@link Thread#stop()}.
 * To allow that, Countdown extends the {@link Thread} class and implements the {@link Stoppable} interface
 * with the signatures with the new methods to initialize and interrupt the execution. Each countdown is composed of a
 * timer, a timer task, a date, an atomic boolean variable which represents a {@code flag}, that indicates if
 * the thread is running or not, and a boolean variable indicating if the job that the thread was meant to run is
 * completed or not.
 *
 * @author Angelo Trotta
 * @version 1.0
 */

public class Countdown extends Thread implements Stoppable {
    private Timer gameTimer = new Timer();
    private TimerTask task;
    private Date currentDate = new Date();
    private final AtomicBoolean running = new AtomicBoolean(false);
    private boolean jobCompleted;

    /**
     * It creates a Countdown thread, by calling the constructor of the superclass and setting the {@link TimerTask}.
     */
    public Countdown() {
        super();

        this.setTimerTask();
    }

    /**
     * It defines the thread's execution job. Once started the countdown through {@link #start(Countdown)},
     * it runs the code of this method, that sets the execution flag of the thread to {@code true}, sets the timer
     * executes it, and stops the countdown once completed the rest.
     */
    @Override
    public void run() {
        this.running.set(true);
        gameTimer.schedule(this.task, this.currentDate.getTime());
        this.task.run();
        this.stop(this);
    }

    /**
     * It gives information on the state of the countdown.
     *
     * @return A casting of the atomic boolean variable to a boolean one through the method {@link AtomicBoolean#get()}
     * of the execution flag.
     */
    public boolean isRunning() {
        return this.running.get();
    }

    /**
     * It gives information on the state of the countdown's job.
     *
     * @return The value of the {@link #jobCompleted} variable.
     */
    public boolean isJobCompleted() {
        return jobCompleted;
    }

    /**
     * It sets the {@link TimerTask} job, that constitutes in waiting 180 seconds, then indicating that it has completed
     * its execution by setting the value of the {@link #jobCompleted} variable to {@code true}.
     */
    public void setTimerTask() {
        this.task = new TimerTask() {
            @Override
            public void run() {
                Date actualDate = new Date();
                actualDate.setTime(actualDate.getTime());

                while (running.get()) {
                    Date expiredDate = new Date();

                    if (expiredDate.getTime() - actualDate.getTime() >= 180000) {
                        jobCompleted = true;
                        break;
                    }
                }

                this.cancel();
            }
        };
    }

    /**
     * It allows for the execution of a {@link Countdown} thread and sets its execution flag to {@code true}.
     *
     * @param timer The timer to start.
     */
    @Override
    public void start(Countdown timer) {
        timer.start();
        timer.running.set(true);
    }

    /**
     * It allows for the termination of a {@link Countdown} thread and sets its execution flag to {@code false}.
     *
     * @param timer The timer to start.
     */
    @Override
    public void stop(Countdown timer) {
        timer.running.set(false);
    }

    /**
     * Method of the {@link Stoppable} interface.
     * 
     * @param thread Thread to execute.
     */
    @Override
    public void start(StoppableThread thread) {}

    /**
     * Method of the {@link Stoppable} interface.
     *
     * @param thread Thread to terminate.
     */
    @Override
    public void stop(StoppableThread thread) {}
}
