package main;

public class EvolutionManager
{
    public static void evolveUniverse(Universe universe)
    {
        final Universe originalUniverse = new Universe(universe);
        final int UNIVERSE_SIZE = originalUniverse.getSize();

        for (int row = 0; row < UNIVERSE_SIZE; row++)
        {
            for (int column = 0; column < UNIVERSE_SIZE; column++)
            {
                Coordinates coordinates = new Coordinates(row, column);

                int aliveNeighborsCount = CellManager.getAliveNeighborCellsCount(originalUniverse, coordinates);

                if (originalUniverse.getCellAt(coordinates).getState() == CellState.alive)
                {
                    if (aliveNeighborsCount == 2 || aliveNeighborsCount == 3)
                    {
                        universe.setCellAt(coordinates, CellState.alive);
                    }
                    else
                    {
                        universe.setCellAt(coordinates, CellState.dead);
                    }
                }
                else if (originalUniverse.getCellAt(coordinates).getState() == CellState.dead)
                {
                    if (aliveNeighborsCount == 3)
                    {
                        universe.setCellAt(coordinates, CellState.alive);
                    }
                    else
                    {
                        universe.setCellAt(coordinates, CellState.dead);
                    }
                }
            }
        }
    }
}
