package controller;

import config.Config;
import evolution.EvolutionSpeedLevel;
import evolution.EvolutionSpeedManager;

public class EvolutionThread extends Thread
{
    public EvolutionThread(Controller controller)
    {
        this.controller = controller;
        setEvolutionSpeedLevel(Config.DEFAULT_EVOLUTION_SPEED_LEVEL);
    }

    public void setEvolutionSpeedLevel(EvolutionSpeedLevel evolutionSpeedLevel)
    {
        this.evolutionDelayMs = EvolutionSpeedManager.convertEvolutionSpeedLevelValueToEvolutionDelayMs(evolutionSpeedLevel);
    }

    @SuppressWarnings({"InfiniteLoopStatement", "BusyWait"})
    @Override
    public void run()
    {
        while (true)
        {
            controller.getModel().getUniverse().evolve();
            controller.updateGUI();

            try
            {
                Thread.sleep(evolutionDelayMs);
            }
            catch (InterruptedException e)
            {
                try
                {
                    /*Pause evolution*/
                    Thread.sleep(Long.MAX_VALUE);
                }
                catch (InterruptedException ex)
                {
                    /*Resume evolution*/
                    /*Go back to executing loop*/
                }
            }
        }
    }

    final Controller controller;
    int evolutionDelayMs;
}
