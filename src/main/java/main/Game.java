package main;

import controller.Controller;
import model.Model;
import view.MainWindow;

public class Game
{
    public Game()
    {
        Model model_ = new Model();
        MainWindow view_ = new MainWindow(model_);
        new Controller(model_, view_);
    }
}
