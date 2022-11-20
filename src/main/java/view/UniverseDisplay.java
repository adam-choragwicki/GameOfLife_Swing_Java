package view;

import cell.CellState;
import cell.Coordinates;
import config.Config;
import model.Universe;

import javax.swing.*;
import java.awt.*;

public class UniverseDisplay extends JPanel
{
    public UniverseDisplay(int sizeOfUniverse)
    {
        this.sizeOfUniverse = sizeOfUniverse;
        setPreferredSize(new Dimension(this.sizeOfUniverse * Config.CELL_SIZE, this.sizeOfUniverse * Config.CELL_SIZE));
    }

    public void setUniverse(Universe universe)
    {
        this.universe = universe;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(Color.black);

        for (int row = 0; row < sizeOfUniverse; row++)
        {
            for (int column = 0; column < sizeOfUniverse; column++)
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

    private final int sizeOfUniverse;
    private Universe universe;
}
