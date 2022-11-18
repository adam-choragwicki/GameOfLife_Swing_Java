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

    private void setCellAt(int row, int column, CellState cellState)
    {
        universeArray[row][column] = new Cell(new Coordinates(row, column), cellState);
    }

    private Cell getCellAt(int row, int column)
    {
        return universeArray[row][column];
    }

    private final int size;
    private final Cell[][] universeArray;
}
