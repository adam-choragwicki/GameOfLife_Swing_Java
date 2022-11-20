package main;

public class Main
{
    public static void main(String[] args)
    {
        UniverseSizeDialog universeSizeDialog = new UniverseSizeDialog();
        final int requestedUniverseSizeDialog = universeSizeDialog.getRequestedUniverseSize();

        if (requestedUniverseSizeDialog != UniverseSizeDialog.EXIT_APPLICATION)
        {
            new GameOfLife(requestedUniverseSizeDialog);
        }
    }
}
