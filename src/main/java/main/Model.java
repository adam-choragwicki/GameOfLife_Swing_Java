package main;

public class Model
{
    Model()
    {
        universe = new Universe(Config.UNIVERSE_SIZE);
    }

    public Universe getUniverse()
    {
        return universe;
    }

    public void resetUniverse()
    {
        universe.reset();
    }

    public void resetEvolution()
    {
        resetUniverse();
    }

    final Universe universe;
}
