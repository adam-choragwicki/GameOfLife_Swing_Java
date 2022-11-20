package main;

import view.UniverseSizeDialog;

public class Main
{
    public static void main(String[] args)
    {
        UniverseSizeDialog universeSizeDialog = new UniverseSizeDialog();
        new GameOfLife(universeSizeDialog.getRequestedUniverseSize());
    }
}
