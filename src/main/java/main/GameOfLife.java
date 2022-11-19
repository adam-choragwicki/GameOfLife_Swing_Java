package main;

import javax.swing.*;

public class GameOfLife extends JFrame
{
    GameOfLife()
    {
        super("Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        addComponents();

        universe = new Universe(Config.UNIVERSE_SIZE);
        universeDisplay.setUniverse(universe);

        pack();
        setLocationRelativeTo(null);
        setMinimumSize(getSize());
        setVisible(true);

        startEvolution();
    }

    private void startEvolution()
    {
        int targetGenerationsCount = 10;

        for (int generation = 1; generation <= targetGenerationsCount; generation++)
        {
            try
            {
                generationCounterLabel.setText(String.format("Generation: %d", generation));
                aliveCellsCounterLabel.setText(String.format("Alive cells: %d", universe.getAliveCellsCount()));
                universe.evolve();
                universeDisplay.repaint();
                Thread.sleep(Config.EVOLUTION_DELAY_MS);
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }

    private void addComponents()
    {
        JPanel buttonsPanel = new JPanel();

        playButton = new JToggleButton("PLAY");
        buttonsPanel.add(playButton);

        resetButton = new JButton("RESET");
        buttonsPanel.add(resetButton);

        add(buttonsPanel);

        JPanel labelsPanel = new JPanel();

        generationCounterLabel = new JLabel("Generation #");
        labelsPanel.add(generationCounterLabel);

        aliveCellsCounterLabel = new JLabel("Alive: ");
        labelsPanel.add(aliveCellsCounterLabel);
        add(labelsPanel);

        universeDisplay = new UniverseDisplay(Config.UNIVERSE_SIZE);
        add(universeDisplay);
    }

    JToggleButton playButton;
    JButton resetButton;
    JLabel generationCounterLabel;
    JLabel aliveCellsCounterLabel;
    Universe universe;
    UniverseDisplay universeDisplay;
}
