package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvolutionManagerTest
{
    @Test
    void evolveUniverse1()
    {
        Universe universe = new Universe(4);

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

        EvolutionManager.evolveUniverse(universe);

        assertEquals(CellState.dead, universe.getCellAt(new Coordinates(0, 0)).getState());
        assertEquals(CellState.dead, universe.getCellAt(new Coordinates(0, 1)).getState());
        assertEquals(CellState.dead, universe.getCellAt(new Coordinates(0, 2)).getState());
        assertEquals(CellState.dead, universe.getCellAt(new Coordinates(0, 3)).getState());
        assertEquals(CellState.dead, universe.getCellAt(new Coordinates(1, 0)).getState());
        assertEquals(CellState.dead, universe.getCellAt(new Coordinates(1, 1)).getState());
        assertEquals(CellState.alive, universe.getCellAt(new Coordinates(1, 2)).getState());
        assertEquals(CellState.dead, universe.getCellAt(new Coordinates(1, 3)).getState());
        assertEquals(CellState.dead, universe.getCellAt(new Coordinates(2, 0)).getState());
        assertEquals(CellState.dead, universe.getCellAt(new Coordinates(2, 1)).getState());
        assertEquals(CellState.dead, universe.getCellAt(new Coordinates(2, 2)).getState());
        assertEquals(CellState.dead, universe.getCellAt(new Coordinates(2, 3)).getState());
        assertEquals(CellState.dead, universe.getCellAt(new Coordinates(3, 0)).getState());
        assertEquals(CellState.dead, universe.getCellAt(new Coordinates(3, 1)).getState());
        assertEquals(CellState.dead, universe.getCellAt(new Coordinates(3, 2)).getState());
        assertEquals(CellState.dead, universe.getCellAt(new Coordinates(3, 3)).getState());
    }

    @Test
    void evolveUniverse2()
    {
        Universe universe = new Universe(5);

        universe.setCellAt(new Coordinates(0, 0), CellState.dead);
        universe.setCellAt(new Coordinates(0, 1), CellState.alive);
        universe.setCellAt(new Coordinates(0, 2), CellState.dead);
        universe.setCellAt(new Coordinates(0, 3), CellState.dead);
        universe.setCellAt(new Coordinates(0, 4), CellState.alive);
        universe.setCellAt(new Coordinates(1, 0), CellState.dead);
        universe.setCellAt(new Coordinates(1, 1), CellState.dead);
        universe.setCellAt(new Coordinates(1, 2), CellState.alive);
        universe.setCellAt(new Coordinates(1, 3), CellState.alive);
        universe.setCellAt(new Coordinates(1, 4), CellState.dead);
        universe.setCellAt(new Coordinates(2, 0), CellState.dead);
        universe.setCellAt(new Coordinates(2, 1), CellState.dead);
        universe.setCellAt(new Coordinates(2, 2), CellState.dead);
        universe.setCellAt(new Coordinates(2, 3), CellState.alive);
        universe.setCellAt(new Coordinates(2, 4), CellState.dead);
        universe.setCellAt(new Coordinates(3, 0), CellState.alive);
        universe.setCellAt(new Coordinates(3, 1), CellState.dead);
        universe.setCellAt(new Coordinates(3, 2), CellState.dead);
        universe.setCellAt(new Coordinates(3, 3), CellState.dead);
        universe.setCellAt(new Coordinates(3, 4), CellState.alive);
        universe.setCellAt(new Coordinates(4, 0), CellState.dead);
        universe.setCellAt(new Coordinates(4, 1), CellState.alive);
        universe.setCellAt(new Coordinates(4, 2), CellState.alive);
        universe.setCellAt(new Coordinates(4, 3), CellState.dead);
        universe.setCellAt(new Coordinates(4, 4), CellState.dead);

        EvolutionManager.evolveUniverse(universe);

        assertEquals(CellState.alive, universe.getCellAt(new Coordinates(0, 0)).getState());
        assertEquals(CellState.alive, universe.getCellAt(new Coordinates(0, 1)).getState());
        assertEquals(CellState.dead, universe.getCellAt(new Coordinates(0, 2)).getState());
        assertEquals(CellState.dead, universe.getCellAt(new Coordinates(0, 3)).getState());
        assertEquals(CellState.dead, universe.getCellAt(new Coordinates(0, 4)).getState());
        assertEquals(CellState.dead, universe.getCellAt(new Coordinates(1, 0)).getState());
        assertEquals(CellState.dead, universe.getCellAt(new Coordinates(1, 1)).getState());
        assertEquals(CellState.alive, universe.getCellAt(new Coordinates(1, 2)).getState());
        assertEquals(CellState.alive, universe.getCellAt(new Coordinates(1, 3)).getState());
        assertEquals(CellState.alive, universe.getCellAt(new Coordinates(1, 4)).getState());
        assertEquals(CellState.dead, universe.getCellAt(new Coordinates(2, 0)).getState());
        assertEquals(CellState.dead, universe.getCellAt(new Coordinates(2, 1)).getState());
        assertEquals(CellState.alive, universe.getCellAt(new Coordinates(2, 2)).getState());
        assertEquals(CellState.alive, universe.getCellAt(new Coordinates(2, 3)).getState());
        assertEquals(CellState.dead, universe.getCellAt(new Coordinates(2, 4)).getState());
        assertEquals(CellState.alive, universe.getCellAt(new Coordinates(3, 0)).getState());
        assertEquals(CellState.alive, universe.getCellAt(new Coordinates(3, 1)).getState());
        assertEquals(CellState.alive, universe.getCellAt(new Coordinates(3, 2)).getState());
        assertEquals(CellState.alive, universe.getCellAt(new Coordinates(3, 3)).getState());
        assertEquals(CellState.alive, universe.getCellAt(new Coordinates(3, 4)).getState());
        assertEquals(CellState.dead, universe.getCellAt(new Coordinates(4, 0)).getState());
        assertEquals(CellState.alive, universe.getCellAt(new Coordinates(4, 1)).getState());
        assertEquals(CellState.alive, universe.getCellAt(new Coordinates(4, 2)).getState());
        assertEquals(CellState.alive, universe.getCellAt(new Coordinates(4, 3)).getState());
        assertEquals(CellState.alive, universe.getCellAt(new Coordinates(4, 4)).getState());
    }
}
