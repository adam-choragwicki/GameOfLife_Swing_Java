package main;

import controller.Controller;
import model.Model;
import view.View;

public class GameOfLife
{
    GameOfLife(int requestedUniverseSize)
    {
        model = new Model(requestedUniverseSize);
        view = new View(requestedUniverseSize);
        controller = new Controller(model, view);

        controller.addActionsToButtons();
        controller.addSpeedSliderChangeListener();
        controller.setUniverse();
    }

    final Model model;
    final View view;
    final Controller controller;
}
