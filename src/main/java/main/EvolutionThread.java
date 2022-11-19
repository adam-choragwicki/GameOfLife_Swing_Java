package main;

public class EvolutionThread extends Thread
{
    public EvolutionThread(GameOfLife gameOfLife)
    {
        this.guiHandle = gameOfLife;
    }

    @Override
    public void run()
    {
        int generation = 1;

        while (true)
        {
            System.out.printf("Generation: %d\n", generation);

            guiHandle.generationCounterLabel.setText(String.format("Generation: %d", generation));
            guiHandle.aliveCellsCounterLabel.setText(String.format("Alive cells: %d", guiHandle.universe.getAliveCellsCount()));
            guiHandle.universe.evolve();
            ++generation;
            guiHandle.universeDisplay.repaint();

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

    //TODO do it in smarter way
    GameOfLife guiHandle;
}
