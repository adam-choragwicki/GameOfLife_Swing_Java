package model;

import cell.Cell;
import cell.CellState;
import cell.Coordinates;
import evolution.EvolutionManager;

import java.util.Random;

public class Universe
{
    public Universe(int size)
    {
        this.size = size;
        universeArray = new Cell[size][size];

        for (int row = 0; row < size; row++)
        {
            universeArray[row] = new Cell[size];
        }

        populate(true);
    }

    public Universe(Universe universe)
    {
        this.size = universe.size;
        this.generationCounter = universe.generationCounter;
        this.currentEvolutionSeed = universe.currentEvolutionSeed;
        universeArray = universe.universeArray.clone();

        for (int row = 0; row < size; row++)
        {
            universeArray[row] = universe.universeArray[row].clone();
        }
    }

    public void populate(boolean newSeed)
    {
        clear();

        Random random = new Random();

        if (newSeed)
        {
            currentEvolutionSeed = random.nextLong();
        }

        random.setSeed(currentEvolutionSeed);

        for (int row = 0; row < size; row++)
        {
            for (int column = 0; column < size; column++)
            {
                setCellAt(row, column, (random.nextBoolean() ? CellState.ALIVE : CellState.DEAD));
            }
        }

        generationCounter = 1;
    }

    private void clear()
    {
        for (int row = 0; row < size; row++)
        {
            for (int column = 0; column < size; column++)
            {
                setCellAt(row, column, null);
            }
        }
    }

    public void evolve()
    {
        EvolutionManager.evolveUniverse(this);
        ++generationCounter;
    }

    public int getAliveCellsCount()
    {
        int aliveCellsCount = 0;

        for (int row = 0; row < size; row++)
        {
            for (int column = 0; column < size; column++)
            {
                Coordinates coordinates = new Coordinates(row, column);

                if (getCellAt(coordinates).getState() == CellState.ALIVE)
                {
                    ++aliveCellsCount;
                }
            }
        }

        return aliveCellsCount;
    }

    public void reset()
    {
        populate(false);
    }

    private void setCellAt(int row, int column, CellState cellState)
    {
        universeArray[row][column] = new Cell(cellState);
    }

    public void setCellAt(Coordinates coordinates, CellState cellState)
    {
        setCellAt(coordinates.row, coordinates.column, cellState);
    }

    private Cell getCellAt(int row, int column)
    {
        return universeArray[row][column];
    }

    public Cell getCellAt(Coordinates coordinates)
    {
        return getCellAt(coordinates.row, coordinates.column);
    }

    public int getSize()
    {
        return size;
    }

    public int getGenerationCounter()
    {
        return generationCounter;
    }

    private final int size;
    private int generationCounter;
    private long currentEvolutionSeed;
    private final Cell[][] universeArray;
}
