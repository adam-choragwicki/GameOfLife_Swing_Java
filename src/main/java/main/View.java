package main;

import javax.swing.*;

public class View extends JFrame
{
    View()
    {
        super("Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        addComponents();

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

        speedSliderLabel = new JLabel("Speed level");
        add(speedSliderLabel);

        speedSlider = new JSlider(EvolutionSpeedLevel.LEVEL_1.getNumericValue(), EvolutionSpeedLevel.LEVEL_10.getNumericValue(), EvolutionSpeedLevel.LEVEL_5.getNumericValue());
        speedSlider.setMajorTickSpacing(1);
        speedSlider.setPaintTicks(true);
        add(speedSlider);

        universeDisplay = new UniverseDisplay(Config.UNIVERSE_SIZE);
        add(universeDisplay);
    }

    public JToggleButton getPlayButton()
    {
        return playButton;
    }

    public JButton getResetButton()
    {
        return resetButton;
    }

    public JLabel getGenerationCounterLabel()
    {
        return generationCounterLabel;
    }

    public JLabel getAliveCellsCounterLabel()
    {
        return aliveCellsCounterLabel;
    }

    public UniverseDisplay getUniverseDisplay()
    {
        return universeDisplay;
    }

    public JSlider getSpeedSlider()
    {
        return speedSlider;
    }

    JToggleButton playButton;
    JButton resetButton;
    JLabel generationCounterLabel;
    JLabel aliveCellsCounterLabel;
    JLabel speedSliderLabel;
    JSlider speedSlider;
    UniverseDisplay universeDisplay;
}