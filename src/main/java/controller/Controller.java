package controller;

import evolution.EvolutionSpeedManager;
import model.Model;
import view.MainWindow;
import view.UniverseSizeDialog;

public class Controller
{
    public Controller(Model model, MainWindow view)
    {
        this.model = model;
        this.view = view;
        this.evolutionThread = new EvolutionThread(this);

        addActionsToButtons();
        addSpeedSliderChangeListener();

        updateGUI();
    }

    public void addActionsToButtons()
    {
        view.getToggleEvolutionButton().addActionListener(actionEvent ->
        {
            view.getResetEvolutionButton().setEnabled(!view.getToggleEvolutionButton().isSelected());
            view.getCreateNewUniverseButton().setEnabled(!view.getToggleEvolutionButton().isSelected());
            view.getChangeUniverseSizeButton().setEnabled(!view.getToggleEvolutionButton().isSelected());
            view.getToggleEvolutionButton().setText(!view.getToggleEvolutionButton().isSelected() ? "PLAY" : "STOP");
            toggleEvolution();
        });

        view.getResetEvolutionButton().addActionListener(actionEvent ->
        {
            model.resetEvolution();
            updateGUI();
        });

        view.getCreateNewUniverseButton().addActionListener(actionEvent ->
        {
            model.createNewUniverse();
            updateGUI();
        });

        view.getChangeUniverseSizeButton().addActionListener(actionEvent ->
        {
            UniverseSizeDialog universeSizeDialog = new UniverseSizeDialog();

            if (universeSizeDialog.isOkClicked())
            {
                model.createNewUniverse(universeSizeDialog.getRequestedUniverseSize());
                view.updateUniverseDisplay();
            }

            updateGUI();
        });
    }

    public void addSpeedSliderChangeListener()
    {
        view.getSpeedSlider().addChangeListener(changeEvent ->
        {
            int speedSliderValue = view.getSpeedSlider().getValue();
            evolutionThread.setEvolutionSpeedLevel(EvolutionSpeedManager.convertEvolutionSpeedSliderValueToEvolutionSpeedLevelValue(speedSliderValue));
        });
    }

    public void updateGUI()
    {
        view.getGenerationCounterLabel().setText(String.format("Generation: %d   ", model.getUniverse().getGenerationCounter()));
        view.getAliveCellsCounterLabel().setText(String.format("Alive cells: %d", model.getUniverse().getAliveCellsCount()));
        view.getUniverseDisplay().repaint();
    }

    public void toggleEvolution()
    {
        if (!evolutionThread.isAlive())
        {
            evolutionThread.start();
        }
        else
        {
            evolutionThread.interrupt();
        }
    }

    public Model getModel()
    {
        return model;
    }

    private final Model model;
    private final MainWindow view;
    private final EvolutionThread evolutionThread;
}
