package main;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame
{
    View(int universeSize)
    {
        super("Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addComponents(universeSize);

        pack();
        setLocationRelativeTo(null);
        setMinimumSize(getSize());
        setResizable(false);
        setVisible(true);
    }

    private void addComponents(int universeSize)
    {
        JPanel controlsPanel = new JPanel();
        controlsPanel.setLayout(new BoxLayout(controlsPanel, BoxLayout.Y_AXIS));

        JPanel buttonsPanel = new JPanel();

        toggleEvolutionButton = new JToggleButton("PLAY");
        toggleEvolutionButton.setFont(new Font(null, Font.BOLD, Config.LABEL_FONT_SIZE));

        toggleEvolutionButton.setFocusable(false);
        buttonsPanel.add(toggleEvolutionButton);

        resetEvolutionButton = new JButton("RESET");
        resetEvolutionButton.setFont(new Font(null, Font.BOLD, Config.LABEL_FONT_SIZE));
        resetEvolutionButton.setFocusable(false);
        buttonsPanel.add(resetEvolutionButton);

        generateUniverseButton = new JButton("GENERATE UNIVERSE");
        generateUniverseButton.setFont(new Font(null, Font.BOLD, Config.LABEL_FONT_SIZE));
        generateUniverseButton.setFocusable(false);
        buttonsPanel.add(generateUniverseButton);

        controlsPanel.add(buttonsPanel);

        JPanel labelsPanel = new JPanel();
        generationCounterLabel = new JLabel("Generation #");
        generationCounterLabel.setFont(new Font(null, Font.BOLD, Config.LABEL_FONT_SIZE));
        labelsPanel.add(generationCounterLabel);

        aliveCellsCounterLabel = new JLabel("Alive: ");
        aliveCellsCounterLabel.setFont(new Font(null, Font.BOLD, Config.LABEL_FONT_SIZE));
        labelsPanel.add(aliveCellsCounterLabel);

        controlsPanel.add(labelsPanel);

        JPanel speedControlPanel = new JPanel();

        speedSliderLabel = new JLabel("Speed level");
        speedSliderLabel.setFont(new Font(null, Font.BOLD, Config.LABEL_FONT_SIZE));
        speedControlPanel.add(speedSliderLabel);

        speedSlider = new JSlider(EvolutionSpeedLevel.LEVEL_1.getNumericValue(), EvolutionSpeedLevel.LEVEL_10.getNumericValue(), EvolutionSpeedLevel.LEVEL_5.getNumericValue());
        speedSlider.setMajorTickSpacing(1);
        speedSlider.setPaintTicks(true);
        speedControlPanel.add(speedSlider);

        controlsPanel.add(speedControlPanel);

        universeDisplay = new UniverseDisplay(universeSize);

        add(controlsPanel, BorderLayout.WEST);
        add(universeDisplay, BorderLayout.EAST);
    }

    public JToggleButton getToggleEvolutionButton()
    {
        return toggleEvolutionButton;
    }

    public JButton getResetEvolutionButton()
    {
        return resetEvolutionButton;
    }

    public JButton getGenerateUniverseButton()
    {
        return generateUniverseButton;
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

    JToggleButton toggleEvolutionButton;
    JButton resetEvolutionButton;
    JButton generateUniverseButton;
    JLabel generationCounterLabel;
    JLabel aliveCellsCounterLabel;
    JLabel speedSliderLabel;
    JSlider speedSlider;
    UniverseDisplay universeDisplay;
}
