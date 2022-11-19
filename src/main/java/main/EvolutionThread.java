package main;

public class EvolutionThread extends Thread
{
    public EvolutionThread(Controller controller)
    {
        this.controller = controller;
    }

    @Override
    public void run()
    {
        while (true)
        {
            System.out.printf("Generation: %d\n", controller.getModel().getUniverse().getGeneration());

            controller.getModel().getUniverse().evolve();
            controller.updateGUI();

            try
            {
                Thread.sleep(Config.EVOLUTION_DELAY_MS);
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
}
