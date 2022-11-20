package main;

public class Cell
{
    Cell(CellState cellState)
    {
        this.cellState = cellState;
    }

    @Override
    public String toString()
    {
        return String.valueOf(cellState.getTextRepresentation());
    }

    public CellState getState()
    {
        return cellState;
    }

    private final CellState cellState;
}
