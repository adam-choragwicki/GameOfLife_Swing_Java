package main;

import javax.swing.*;

public class GameOfLife extends JFrame
{
    GameOfLife(int requestedUniverseSize)
    {
        model = new Model(requestedUniverseSize);
        view = new View(requestedUniverseSize);
        controller = new Controller(model, view);

        controller.addActionsToButtons();
        controller.setUniverse();
        controller.addSpeedSliderChangeListener();
    }

    final Model model;
    final View view;
    final Controller controller;
}
