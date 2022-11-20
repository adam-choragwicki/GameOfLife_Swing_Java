package evolution;

import cell.CellManager;
import cell.CellState;
import cell.Coordinates;
import model.Universe;

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

                if (originalUniverse.getCellAt(coordinates).getState() == CellState.ALIVE)
                {
                    if (aliveNeighborsCount == 2 || aliveNeighborsCount == 3)
                    {
                        universe.setCellAt(coordinates, CellState.ALIVE);
                    }
                    else
                    {
                        universe.setCellAt(coordinates, CellState.DEAD);
                    }
                }
                else if (originalUniverse.getCellAt(coordinates).getState() == CellState.DEAD)
                {
                    if (aliveNeighborsCount == 3)
                    {
                        universe.setCellAt(coordinates, CellState.ALIVE);
                    }
                    else
                    {
                        universe.setCellAt(coordinates, CellState.DEAD);
                    }
                }
            }
        }
    }
}
