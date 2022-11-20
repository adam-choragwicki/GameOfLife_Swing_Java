package main;

public class Controller
{
    public Controller(Model model, View view)
    {
        this.model = model;
        this.view = view;
        this.evolutionThread = new EvolutionThread(this);
    }

    public void addActionsToButtons()
    {
        view.getToggleEvolutionButton().addActionListener(actionEvent ->
        {
            view.getResetEvolutionButton().setEnabled(!view.getToggleEvolutionButton().isSelected());
            view.getGenerateUniverseButton().setEnabled(!view.getToggleEvolutionButton().isSelected());
            view.getToggleEvolutionButton().setText(!view.getToggleEvolutionButton().isSelected() ? "PLAY" : "STOP");
            toggleEvolution();
        });

        view.getResetEvolutionButton().addActionListener(actionEvent ->
        {
            model.resetEvolution();
            updateGUI();
        });

        view.getGenerateUniverseButton().addActionListener(actionEvent ->
        {
            model.generateNewUniverse();
            updateGUI();
        });
    }

    public void updateGUI()
    {
        view.getGenerationCounterLabel().setText("Generation: %d".formatted(model.getUniverse().getGenerationCounter()));
        view.getAliveCellsCounterLabel().setText("Alive cells: %d".formatted(model.getUniverse().getAliveCellsCount()));
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

    public void addSpeedSliderChangeListener()
    {
        view.getSpeedSlider().addChangeListener(changeEvent ->
        {
            int speedSliderValue = view.getSpeedSlider().getValue();
            evolutionThread.setEvolutionSpeedLevel(EvolutionSpeedManager.convertEvolutionSpeedSliderValueToEvolutionSpeedLevelValue(speedSliderValue));
        });
    }

    public void setUniverse()
    {
        view.getUniverseDisplay().setUniverse(model.getUniverse());
        updateGUI();
    }

    public Model getModel()
    {
        return model;
    }

    private final Model model;
    private final View view;
    private final EvolutionThread evolutionThread;
}
