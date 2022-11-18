package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NeighborCellsCoordinatesGeneratorTest
{
    @BeforeEach
    void setUp()
    {
        universe = new Universe(4);

        universe.setCellAt(new Coordinates(0, 0), CellState.alive);
        universe.setCellAt(new Coordinates(0, 1), CellState.alive);
        universe.setCellAt(new Coordinates(0, 2), CellState.dead);
        universe.setCellAt(new Coordinates(0, 3), CellState.alive);
        universe.setCellAt(new Coordinates(1, 0), CellState.alive);
        universe.setCellAt(new Coordinates(1, 1), CellState.dead);
        universe.setCellAt(new Coordinates(1, 2), CellState.alive);
        universe.setCellAt(new Coordinates(1, 3), CellState.dead);
        universe.setCellAt(new Coordinates(2, 0), CellState.alive);
        universe.setCellAt(new Coordinates(2, 1), CellState.alive);
        universe.setCellAt(new Coordinates(2, 2), CellState.dead);
        universe.setCellAt(new Coordinates(2, 3), CellState.dead);
        universe.setCellAt(new Coordinates(3, 0), CellState.dead);
        universe.setCellAt(new Coordinates(3, 1), CellState.alive);
        universe.setCellAt(new Coordinates(3, 2), CellState.alive);
        universe.setCellAt(new Coordinates(3, 3), CellState.alive);

        neighborCellsCoordinatesGenerator = new NeighborCellsCoordinatesGenerator(universe.getSize());
    }

    @Test
    @DisplayName("Upper left corner cell")
    void generateNeighbourCoordinates1()
    {
        Coordinates[] coordinates = neighborCellsCoordinatesGenerator.generateNeighbourCoordinates(new Coordinates(0, 0));

        assertEquals(NeighborCellsCoordinatesGenerator.NEIGHBOR_CELLS_COUNT, coordinates.length);

        compareCoordinates(3, 3, coordinates[0]);
        compareCoordinates(3, 0, coordinates[1]);
        compareCoordinates(3, 1, coordinates[2]);
        compareCoordinates(0, 3, coordinates[3]);
        compareCoordinates(0, 1, coordinates[4]);
        compareCoordinates(1, 3, coordinates[5]);
        compareCoordinates(1, 0, coordinates[6]);
        compareCoordinates(1, 1, coordinates[7]);
    }

    @Test
    @DisplayName("Lower right corner cell")
    void generateNeighbourCoordinates2()
    {
        NeighborCellsCoordinatesGenerator neighborCellsCoordinatesGenerator = new NeighborCellsCoordinatesGenerator(universe.getSize());
        Coordinates[] coordinates = neighborCellsCoordinatesGenerator.generateNeighbourCoordinates(new Coordinates(3, 3));

        assertEquals(NeighborCellsCoordinatesGenerator.NEIGHBOR_CELLS_COUNT, coordinates.length);

        compareCoordinates(2, 2, coordinates[0]);
        compareCoordinates(2, 3, coordinates[1]);
        compareCoordinates(2, 0, coordinates[2]);
        compareCoordinates(3, 2, coordinates[3]);
        compareCoordinates(3, 0, coordinates[4]);
        compareCoordinates(0, 2, coordinates[5]);
        compareCoordinates(0, 3, coordinates[6]);
        compareCoordinates(0, 0, coordinates[7]);
    }

    @Test
    @DisplayName("Edge non-corner cell")
    void generateNeighbourCoordinates3()
    {
        NeighborCellsCoordinatesGenerator neighborCellsCoordinatesGenerator = new NeighborCellsCoordinatesGenerator(universe.getSize());
        Coordinates[] coordinates = neighborCellsCoordinatesGenerator.generateNeighbourCoordinates(new Coordinates(0, 1));

        assertEquals(NeighborCellsCoordinatesGenerator.NEIGHBOR_CELLS_COUNT, coordinates.length);

        compareCoordinates(3, 0, coordinates[0]);
        compareCoordinates(3, 1, coordinates[1]);
        compareCoordinates(3, 2, coordinates[2]);
        compareCoordinates(0, 0, coordinates[3]);
        compareCoordinates(0, 2, coordinates[4]);
        compareCoordinates(1, 0, coordinates[5]);
        compareCoordinates(1, 1, coordinates[6]);
        compareCoordinates(1, 2, coordinates[7]);
    }

    @Test
    @DisplayName("Non-edge non-corner cell")
    void generateNeighbourCoordinates4()
    {
        NeighborCellsCoordinatesGenerator neighborCellsCoordinatesGenerator = new NeighborCellsCoordinatesGenerator(universe.getSize());
        Coordinates[] coordinates = neighborCellsCoordinatesGenerator.generateNeighbourCoordinates(new Coordinates(1, 1));

        assertEquals(NeighborCellsCoordinatesGenerator.NEIGHBOR_CELLS_COUNT, coordinates.length);

        compareCoordinates(0, 0, coordinates[0]);
        compareCoordinates(0, 1, coordinates[1]);
        compareCoordinates(0, 2, coordinates[2]);
        compareCoordinates(1, 0, coordinates[3]);
        compareCoordinates(1, 2, coordinates[4]);
        compareCoordinates(2, 0, coordinates[5]);
        compareCoordinates(2, 1, coordinates[6]);
        compareCoordinates(2, 2, coordinates[7]);
    }

    void compareCoordinates(int expectedRow, int expectedColumn, Coordinates actualCoordinates)
    {
        Coordinates expectedCoordinates = new Coordinates(expectedRow, expectedColumn);

        assertEquals(expectedCoordinates.row, actualCoordinates.row);
        assertEquals(expectedCoordinates.column, actualCoordinates.column);
    }

    private Universe universe;
    private NeighborCellsCoordinatesGenerator neighborCellsCoordinatesGenerator;
}
