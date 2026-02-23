package cell;

import model.Universe;

public class CellManager
{
    public static int getAliveNeighborCellsCount(Universe universe, Coordinates coordinates)
    {
        int aliveNeighborsCount = 0;

        Coordinates[] neighborCellsCoordinates = new NeighborCellsCoordinatesGenerator(universe.getSize())
                .generateNeighbourCoordinates(coordinates);

        for (Coordinates neighborCoordinates : neighborCellsCoordinates)
        {
            Cell neighborCell = universe.getCellAt(neighborCoordinates);
            if (neighborCell.getState() == CellState.ALIVE)
            {
                ++aliveNeighborsCount;
            }
        }

        return aliveNeighborsCount;
    }

    public static class NeighborCellsCoordinatesGenerator
    {
        public NeighborCellsCoordinatesGenerator(int universeSize)
        {
            this.universeSize = universeSize;
        }

        public Coordinates[] generateNeighbourCoordinates(Coordinates coordinates)
        {
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

            int neighborIndex = 0;
            Coordinates[] neighborCoordinates = new Coordinates[NEIGHBOR_CELLS_COUNT];

            for (int i = 0; i < NEIGHBOR_CELLS_COUNT; i++)
            {
                Coordinates coordinatesAfterOffset = coordinates.offsetCoordinates(directionalOffsets[i]);

                if (coordinatesAfterOffset.row < 0 || coordinatesAfterOffset.row >= universeSize)
                {
                    continue;
                }

                if (coordinatesAfterOffset.column < 0 || coordinatesAfterOffset.column >= universeSize)
                {
                    continue;
                }

                neighborCoordinates[neighborIndex++] = coordinatesAfterOffset;
            }

            Coordinates[] result = new Coordinates[neighborIndex];
            System.arraycopy(neighborCoordinates, 0, result, 0, neighborIndex);
            return result;
        }

        public static final int NEIGHBOR_CELLS_COUNT = 8;
        final int universeSize;
    }
}
