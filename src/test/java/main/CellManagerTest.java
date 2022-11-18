package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellManagerTest
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
    }

    @Test
    void getAliveNeighborCellsCount()
    {
        assertEquals(5, CellManager.getAliveNeighborCellsCount(universe, new Coordinates(0, 0)));
        assertEquals(5, CellManager.getAliveNeighborCellsCount(universe, new Coordinates(0, 1)));
        assertEquals(6, CellManager.getAliveNeighborCellsCount(universe, new Coordinates(0, 2)));
        assertEquals(5, CellManager.getAliveNeighborCellsCount(universe, new Coordinates(0, 3)));
        assertEquals(5, CellManager.getAliveNeighborCellsCount(universe, new Coordinates(1, 0)));
        assertEquals(6, CellManager.getAliveNeighborCellsCount(universe, new Coordinates(1, 1)));
        assertEquals(3, CellManager.getAliveNeighborCellsCount(universe, new Coordinates(1, 2)));
        assertEquals(5, CellManager.getAliveNeighborCellsCount(universe, new Coordinates(1, 3)));
        assertEquals(4, CellManager.getAliveNeighborCellsCount(universe, new Coordinates(2, 0)));
        assertEquals(5, CellManager.getAliveNeighborCellsCount(universe, new Coordinates(2, 1)));
        assertEquals(5, CellManager.getAliveNeighborCellsCount(universe, new Coordinates(2, 2)));
        assertEquals(5, CellManager.getAliveNeighborCellsCount(universe, new Coordinates(2, 3)));
        assertEquals(7, CellManager.getAliveNeighborCellsCount(universe, new Coordinates(3, 0)));
        assertEquals(5, CellManager.getAliveNeighborCellsCount(universe, new Coordinates(3, 1)));
        assertEquals(5, CellManager.getAliveNeighborCellsCount(universe, new Coordinates(3, 2)));
        assertEquals(4, CellManager.getAliveNeighborCellsCount(universe, new Coordinates(3, 3)));
    }

    private Universe universe;
}
