package model;

import config.Config;

public class Model
{
    public Model()
    {
        createNewUniverse(Config.DEFAULT_UNIVERSE_SIZE);
    }

    public Universe getUniverse()
    {
        return universe;
    }

    public void setUniverse(Universe universe)
    {
        // Swapping the universe reference avoids cross-thread mutation of the live model.
        this.universe = universe;
    }

    public void resetEvolution()
    {
        universe.reset();
    }

    public void createNewUniverse()
    {
        universe.populate(true);
    }

    public void createNewUniverse(int universeSize)
    {
        universe = new Universe(universeSize);
    }

    Universe universe;
}
