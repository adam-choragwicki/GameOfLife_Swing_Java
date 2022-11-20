package main;

import javax.swing.*;

public class GameOfLife extends JFrame
{
    GameOfLife()
    {
        model = new Model();
        view = new View();
        controller = new Controller(model, view);

        controller.addActionsToButtons();
        controller.setUniverse();
        controller.addSpeedSliderChangeListener();
    }

    final Model model;
    final View view;
    final Controller controller;
}
