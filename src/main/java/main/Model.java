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

    public void resetEvolution()
    {
        universe.reset();
    }

    public void generateNewUniverse()
    {
        universe.populate(true);
    }

    final Universe universe;
}
