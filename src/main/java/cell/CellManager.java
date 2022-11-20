package cell;

import model.Universe;

public class CellManager
{
    public static int getAliveNeighborCellsCount(Universe universe, Coordinates coordinates)
    {
        Cell[] neighborCells = getNeighborCells(universe, coordinates);

        int aliveNeighborsCount = 0;

        for (Cell neighborCell : neighborCells)
        {
            if (neighborCell.getState() == CellState.ALIVE)
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

    public static class NeighborCellsCoordinatesGenerator
    {
        public NeighborCellsCoordinatesGenerator(int universeSize)
        {
            this.universeSize = universeSize;
        }

        public Coordinates[] generateNeighbourCoordinates(Coordinates coordinates)
        {
            Coordinates[] neighbourCoordinates = new Coordinates[NEIGHBOR_CELLS_COUNT];

            final Coordinates[] directionalOffsets = new Coordinates[]
            {
            new Coordinates(-1, -1),
            new Coordinates(-1, 0),
            new Coordinates(-1, +1),
            new Coordinates(0, -1),
            new Coordinates(0, +1),
            new Coordinates(+1, -1),
            new Coordinates(+1, 0),
            new Coordinates(+1, +1)
            };

            for (int i = 0; i < NEIGHBOR_CELLS_COUNT; i++)
            {
                Coordinates coordinatesAfterOffset = coordinates.offsetCoordinates(directionalOffsets[i]);

                if (coordinatesAfterOffset.row == -1)
                {
                    coordinatesAfterOffset.row = universeSize - 1;
                }

                if (coordinatesAfterOffset.row == universeSize)
                {
                    coordinatesAfterOffset.row = 0;
                }

                if (coordinatesAfterOffset.column == -1)
                {
                    coordinatesAfterOffset.column = universeSize - 1;
                }

                if (coordinatesAfterOffset.column == universeSize)
                {
                    coordinatesAfterOffset.column = 0;
                }

                neighbourCoordinates[i] = coordinatesAfterOffset;
            }

            return neighbourCoordinates;
        }

        public static final int NEIGHBOR_CELLS_COUNT = 8;
        final int universeSize;
    }
}
