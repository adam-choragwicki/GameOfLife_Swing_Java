package view;

import config.Config;
import evolution.EvolutionSpeedLevel;
import model.Model;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame
{
    public MainWindow(Model model)
    {
        super("Game of Life");
        this.model = model;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addComponents();

        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addComponents()
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

        createNewUniverseButton = new JButton("CREATE NEW UNIVERSE");
        createNewUniverseButton.setFont(new Font(null, Font.BOLD, Config.LABEL_FONT_SIZE));
        createNewUniverseButton.setFocusable(false);
        buttonsPanel.add(createNewUniverseButton);

        changeUniverseSizeButton = new JButton("CHANGE UNIVERSE SIZE");
        changeUniverseSizeButton.setFont(new Font(null, Font.BOLD, Config.LABEL_FONT_SIZE));
        changeUniverseSizeButton.setFocusable(false);
        buttonsPanel.add(changeUniverseSizeButton);

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

        universeDisplay = new UniverseDisplay(model.getUniverse());

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

    public JButton getCreateNewUniverseButton()
    {
        return createNewUniverseButton;
    }

    public JButton getChangeUniverseSizeButton()
    {
        return changeUniverseSizeButton;
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

    public void updateUniverseDisplay()
    {
        remove(universeDisplay);
        universeDisplay = new UniverseDisplay(model.getUniverse());
        add(universeDisplay, BorderLayout.EAST);

        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    JToggleButton toggleEvolutionButton;
    JButton resetEvolutionButton;
    JButton createNewUniverseButton;
    JButton changeUniverseSizeButton;
    JLabel generationCounterLabel;
    JLabel aliveCellsCounterLabel;
    JLabel speedSliderLabel;
    JSlider speedSlider;
    UniverseDisplay universeDisplay;

    final Model model;
}
