package main;

import java.util.Random;

public class Universe
{
    public Universe(int size)
    {
        this.size = size;

        universeArray = new char[size][size];

        for (int row = 0; row < size; row++)
        {
            universeArray[row] = new char[size];
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
                setCellAt(row, column, random.nextBoolean() ? CellState.alive : CellState.dead);
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

    private void setCellAt(int row, int column, char value)
    {
        universeArray[row][column] = value;
    }

    private char getCellAt(int row, int column)
    {
        return universeArray[row][column];
    }

    private final int size;
    private final char[][] universeArray;
}
