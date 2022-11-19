package main;

public class GameOfLife
{
    GameOfLife()
    {
        Universe universe = new Universe(Config.UNIVERSE_SIZE);
        universe.display();

        System.out.println("----------");

        universe.evolve();
        universe.display();

        System.out.println("----------");

        universe.evolve();
        universe.display();
    }
}
