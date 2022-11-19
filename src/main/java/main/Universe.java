package main;

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

        populate();
    }

    public Universe(Universe universe)
    {
        this.size = universe.size;
        this.generation = universe.generation;
        universeArray = universe.universeArray.clone();

        for (int row = 0; row < size; row++)
        {
            universeArray[row] = universe.universeArray[row].clone();
        }
    }

    private void populate()
    {
        int seed = 0;

        Random random = new Random(seed);

        for (int row = 0; row < size; row++)
        {
            for (int column = 0; column < size; column++)
            {
                setCellAt(row, column, (random.nextBoolean() ? CellState.alive : CellState.dead));
            }
        }

        generation = 1;
    }

    public void evolve()
    {
        EvolutionManager.evolveUniverse(this);
        ++generation;
    }

    public void display()
    {
        for (int row = 0; row < size; row++)
        {
            for (int column = 0; column < size; column++)
            {
                System.out.print(getCellAt(row, column));
            }

            System.out.println();
        }
    }

    public int getAliveCellsCount()
    {
        int aliveCellsCount = 0;

        for (int row = 0; row < size; row++)
        {
            for (int column = 0; column < size; column++)
            {
                Coordinates coordinates = new Coordinates(row, column);

                if (getCellAt(coordinates).getState() == CellState.alive)
                {
                    ++aliveCellsCount;
                }
            }
        }

        return aliveCellsCount;
    }

    public void reset()
    {
        /*Works only for constant seed*/
        populate();
    }

//    public void displayAliveNeighborsCount()
//    {
//        for (int row = 0; row < size; row++)
//        {
//            for (int column = 0; column < size; column++)
//            {
//                int aliveNeighborsCount = CellManager.getAliveNeighborCellsCount(this, new Coordinates(row, column));
//                System.out.print(aliveNeighborsCount);
//            }
//
//            System.out.println();
//        }
//    }

    private void setCellAt(int row, int column, CellState cellState)
    {
        universeArray[row][column] = new Cell(new Coordinates(row, column), cellState);
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

    public int getGeneration()
    {
        return generation;
    }

    private final int size;

    private int generation;
    private final Cell[][] universeArray;
}
