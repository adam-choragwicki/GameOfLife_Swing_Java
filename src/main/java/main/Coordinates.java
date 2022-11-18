package main;

public class Coordinates
{
    Coordinates(int row, int column)
    {
        this.row = row;
        this.column = column;
    }

    public Coordinates offsetCoordinates(Coordinates coordinates)
    {
        return new Coordinates(row + coordinates.row, column + coordinates.column);
    }

    public int row;
    public int column;
}
