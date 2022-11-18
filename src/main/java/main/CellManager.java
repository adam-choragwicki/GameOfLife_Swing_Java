package main;

public class CellManager
{
    public static int getAliveNeighborCellsCount(Universe universe, Coordinates coordinates)
    {
        Cell[] neighborCells = getNeighborCells(universe, coordinates);

        int aliveNeighborsCount = 0;

        for (Cell neighborCell : neighborCells)
        {
            if (neighborCell.getState() == CellState.alive)
            {
                ++aliveNeighborsCount;
            }
        }

        return aliveNeighborsCount;
    }

    private static Cell[] getNeighborCells(Universe universe, Coordinates coordinates)
    {
        NeighborCellsCoordinatesGenerator neighborCellsCoordinatesGenerator = new NeighborCellsCoordinatesGenerator(universe.getSize());
        Coordinates[] neighborCellsCoordinates = neighborCellsCoordinatesGenerator.generateNeighbourCoordinates(coordinates);

        Cell[] neighborCells = new Cell[NeighborCellsCoordinatesGenerator.NEIGHBOR_CELLS_COUNT];

        for (int i = 0; i < NeighborCellsCoordinatesGenerator.NEIGHBOR_CELLS_COUNT; i++)
        {
            neighborCells[i] = universe.getCellAt(neighborCellsCoordinates[i]);
        }

        return neighborCells;
    }
}
