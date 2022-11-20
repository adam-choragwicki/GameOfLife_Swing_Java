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
        view.getPlayButton().addActionListener(actionEvent ->
        {
            System.out.println("PLAY BUTTON CLICKED");
            view.getResetButton().setEnabled(!view.getPlayButton().isSelected());
            toggleEvolution();
        });

        view.getResetButton().addActionListener(actionEvent ->
        {
            System.out.println("RESET EVOLUTION CLICKED");
            model.resetEvolution();
            updateGUI();
        });
    }

    public void updateGUI()
    {
        view.getGenerationCounterLabel().setText("Generation: %d".formatted(model.getUniverse().getGeneration()));
        view.getAliveCellsCounterLabel().setText("Alive cells: %d".formatted(model.getUniverse().getAliveCellsCount()));
        view.getUniverseDisplay().repaint();
    }

    public void toggleEvolution()
    {
        System.out.println("START EVOLUTION CLICKED");

        if (!evolutionThread.isAlive())
        {
            System.out.println("STARTING THREAD");
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
            System.out.println("PROCESS SPEED CHANGE, new value=" + speedSliderValue);
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
