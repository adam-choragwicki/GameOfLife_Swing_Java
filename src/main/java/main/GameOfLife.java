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
        addActionsToButtons();

        universe = new Universe(Config.UNIVERSE_SIZE);
        universeDisplay.setUniverse(universe);
        evolutionThread = new EvolutionThread(this);

        pack();
        setLocationRelativeTo(null);
        setMinimumSize(getSize());
        setVisible(true);
    }

    private void addComponents()
    {
        JPanel buttonsPanel = new JPanel();

        playButton = new JToggleButton("PLAY");
        playButton.setFocusable(false);
        buttonsPanel.add(playButton);

        resetButton = new JButton("RESET");
        resetButton.setFocusable(false);
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

    private void addActionsToButtons()
    {
        playButton.addActionListener(actionEvent -> startEvolution());
        resetButton.addActionListener(actionEvent -> resetEvolution());
    }

    private void startEvolution()
    {
        System.out.println("START EVOLUTION CLICKED");

        if(!evolutionThread.isAlive())
        {
            System.out.println("STARTING THREAD");
            evolutionThread.start();
        }
        else
        {
            evolutionThread.interrupt();
        }
    }

    private void resetEvolution()
    {

    }

    JToggleButton playButton;
    JButton resetButton;
    JLabel generationCounterLabel;
    JLabel aliveCellsCounterLabel;
    Universe universe;
    UniverseDisplay universeDisplay;
    EvolutionThread evolutionThread;
}
