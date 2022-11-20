package cell;

public class Cell
{
    public Cell(CellState cellState)
    {
        this.cellState = cellState;
    }

    public CellState getState()
    {
        return cellState;
    }

    private final CellState cellState;
}
