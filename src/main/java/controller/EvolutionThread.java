package controller;

import config.Config;
import evolution.EvolutionSpeedLevel;
import evolution.EvolutionSpeedManager;
import evolution.EvolutionManager;
import model.Universe;

import javax.swing.SwingUtilities;

public class EvolutionThread extends Thread
{
    public EvolutionThread(Controller controller)
    {
        this.controller = controller;
        setDaemon(true);
        setEvolutionSpeedLevel(Config.DEFAULT_EVOLUTION_SPEED_LEVEL);
    }

    public void setEvolutionSpeedLevel(EvolutionSpeedLevel evolutionSpeedLevel)
    {
        this.evolutionDelayMs = EvolutionSpeedManager.convertEvolutionSpeedLevelValueToEvolutionDelayMs(evolutionSpeedLevel);
    }

    public void pauseEvolution()
    {
        paused = true;
        interrupt();
    }

    public void resumeEvolution()
    {
        synchronized (pauseLock)
        {
            paused = false;
            pauseLock.notifyAll();
        }
    }

    public boolean isPaused()
    {
        return paused;
    }

    @Override
    public void run()
    {
        while (true)
        {
            // Block the background thread while evolution is paused.
            synchronized (pauseLock)
            {
                while (paused)
                {
                    try
                    {
                        pauseLock.wait();
                    }
                    catch (InterruptedException ignored)
                    {
                        /* Keep waiting until resumed. */
                    }
                }
            }

            // Compute the next generation on a snapshot to avoid mutating the UI model off the EDT.
            Universe current = controller.getModel().getUniverse();
            Universe next = new Universe(current);
            EvolutionManager.evolveUniverse(next);

            // Publish the new universe on the EDT so Swing sees a consistent model.
            SwingUtilities.invokeLater(() ->
            {
                controller.getModel().setUniverse(next);
                controller.getView().getUniverseDisplay().setUniverse(next);
                controller.updateGUI();
            });

            try
            {
                Thread.sleep(evolutionDelayMs);
            }
            catch (InterruptedException ignored)
            {
                /* Continue with the current delay. */
            }
        }
    }

    private final Controller controller;
    private final Object pauseLock = new Object();
    private volatile boolean paused = true;
    private volatile int evolutionDelayMs;
}
