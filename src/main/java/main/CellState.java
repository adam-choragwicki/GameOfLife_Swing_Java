package main;

public enum CellState
{
    alive('O'),
    dead('X');

    CellState(char textRepresentation)
    {
        this.textRepresentation = textRepresentation;
    }

    public char getTextRepresentation()
    {
        return textRepresentation;
    }

    private final char textRepresentation;
}
