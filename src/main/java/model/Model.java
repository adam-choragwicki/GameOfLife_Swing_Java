package model;

public class Model
{
    public Model(int universeSize)
    {
        universe = new Universe(universeSize);
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
