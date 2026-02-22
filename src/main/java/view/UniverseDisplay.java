package view;

import cell.CellState;
import cell.Coordinates;
import config.Config;
import model.Universe;

import javax.swing.*;
import java.awt.*;

public class UniverseDisplay extends JPanel
{
    public UniverseDisplay(Universe universe)
    {
        setUniverse(universe);
    }

    public void setUniverse(Universe universe)
    {
        // Universe may be swapped on the EDT after background evolution.
        this.universe = universe;
        this.universeSize = universe.getSize();
        setPreferredSize(new Dimension(this.universeSize * Config.CELL_SIZE, this.universeSize * Config.CELL_SIZE));
        revalidate();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(Color.black);

        for (int row = 0; row < universeSize; row++)
        {
            for (int column = 0; column < universeSize; column++)
            {
                Coordinates cellCoordinates = new Coordinates(row, column);

                if (universe.getCellAt(cellCoordinates).getState() == CellState.ALIVE)
                {
                    graphics2D.fillRect(column * Config.CELL_SIZE, row * Config.CELL_SIZE, Config.CELL_SIZE, Config.CELL_SIZE);
                }
                else
                {
                    graphics2D.drawRect(column * Config.CELL_SIZE, row * Config.CELL_SIZE, Config.CELL_SIZE, Config.CELL_SIZE);
                }
            }
        }
    }

    private Universe universe;
    private int universeSize;
}
