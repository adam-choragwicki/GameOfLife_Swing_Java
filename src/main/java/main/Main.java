package main;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Started Game of life");
        javax.swing.SwingUtilities.invokeLater(Game::new); // guarantees all Swing component creation happens on the Event Dispatch Thread
    }
}
