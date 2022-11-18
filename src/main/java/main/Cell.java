package main;

public class Cell
{
    Cell(Coordinates coordinates, CellState cellState)
    {
        this.coordinates = coordinates;
        this.cellState = cellState;
    }

    @Override
    public String toString()
    {
        return String.valueOf(cellState.getTextRepresentation());
    }

    private final Coordinates coordinates;
    private final CellState cellState;
}
