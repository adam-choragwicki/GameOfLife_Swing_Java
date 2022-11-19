package main;

public class GameOfLife
{
    GameOfLife()
    {
        Universe universe = new Universe(Config.UNIVERSE_SIZE);

        int targetGenerationsCount = 5;

        for (int generation = 1; generation <= targetGenerationsCount; generation++)
        {
            System.out.printf("Generation: %d\n", generation);
            System.out.printf("Alive cells: %d\n\n", universe.getAliveCellsCount());
            universe.display();
            universe.evolve();
            System.out.println("\n----------\n");
        }
    }
}
