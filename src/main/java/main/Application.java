package main;

import controller.Controller;
import model.Model;
import view.MainWindow;

public class Application
{
    Application(int requestedUniverseSize)
    {
        model = new Model(requestedUniverseSize);
        view = new MainWindow(requestedUniverseSize);
        controller = new Controller(model, view);

        controller.addActionsToButtons();
        controller.addSpeedSliderChangeListener();
        controller.setUniverse();
    }

    final Model model;
    final MainWindow view;
    final Controller controller;
}
