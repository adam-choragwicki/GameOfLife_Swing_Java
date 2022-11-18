package main;

public class NeighborCellsCoordinatesGenerator
{
    public NeighborCellsCoordinatesGenerator(int universeSize)
    {
        this.universeSize = universeSize;
    }

    Coordinates[] generateNeighbourCoordinates(Coordinates coordinates)
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

    static final int NEIGHBOR_CELLS_COUNT = 8;
    int universeSize;
}
