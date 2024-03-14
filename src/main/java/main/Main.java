package main;

import view.UniverseSizeDialog;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Started Game of life");

        UniverseSizeDialog universeSizeDialog = new UniverseSizeDialog();
        new Application(universeSizeDialog.getRequestedUniverseSize());

        System.out.println("Shutting down Game of life");
    }
}
