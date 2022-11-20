package main;

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
                    System.out.println("PAUSE EVOLUTION");
                    Thread.sleep(Long.MAX_VALUE);
                }
                catch (InterruptedException ex)
                {
                    /*Resume evolution*/
                    /*Go back to executing loop*/
                    System.out.println("RESUME EVOLUTION");
                }
            }
        }
    }

    final Controller controller;
    int evolutionDelayMs;
}
