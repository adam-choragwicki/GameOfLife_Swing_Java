package main;

public class GameOfLife
{
    GameOfLife()
    {
        Universe universe = new Universe(Config.UNIVERSE_SIZE);
        universe.display();
    }
}
