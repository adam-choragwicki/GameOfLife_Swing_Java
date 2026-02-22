package view;

import config.Config;

import javax.swing.*;
import java.awt.*;

public class UniverseSizeDialog extends JDialog
{
    public UniverseSizeDialog()
    {
        setTitle("Universe size dialog");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(null);

        setSize(DIALOG_WIDTH, DIALOG_HEIGHT);

        addLabel();
        addComboBox();
        addButtons();

        addActions();

        setLocationRelativeTo(null);
        setMinimumSize(getSize());
        setResizable(false);
        setModal(true);
        requestedUniverseSize = Config.DEFAULT_UNIVERSE_SIZE;
        setVisible(true);
    }

    private void addLabel()
    {
        JLabel universeSizeLabel = new JLabel("Choose universe size");
        universeSizeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        universeSizeLabel.setBounds(0, 0, DIALOG_WIDTH, 50);
        universeSizeLabel.setFont(new Font(null, Font.BOLD, 50));
        add(universeSizeLabel);
    }

    private void addComboBox()
    {
        universeSizeComboBox = new JComboBox<>();
        universeSizeComboBox.setBounds(0, 60, DIALOG_WIDTH - 15, 50);
        universeSizeComboBox.setFocusable(false);
        universeSizeComboBox.setFont(new Font(null, Font.BOLD, 30));

        ((JLabel) universeSizeComboBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = Config.MIN_UNIVERSE_SIZE; i <= Config.MAX_UNIVERSE_SIZE; i++)
        {
            universeSizeComboBox.addItem(i);
        }

        universeSizeComboBox.setSelectedItem(Config.DEFAULT_UNIVERSE_SIZE);

        add(universeSizeComboBox);
    }

    private void addButtons()
    {
        okButton = new JButton("OK");
        okButton.setBounds(0, 130, DIALOG_WIDTH - 15, 40);
        okButton.setFocusable(false);

        add(okButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(0, 170, DIALOG_WIDTH - 15, 40);
        cancelButton.setFocusable(false);

        add(cancelButton);
    }

    private void addActions()
    {
        okButton.addActionListener(actionEvent ->
        {
            requestedUniverseSize = (int) universeSizeComboBox.getSelectedItem();
            okClicked = true;
            dispose();
        });

        cancelButton.addActionListener(actionEvent ->
        {
            okClicked = false;
            dispose();
        });
    }

    public int getRequestedUniverseSize()
    {
        return requestedUniverseSize;
    }

    public boolean isOkClicked()
    {
        return okClicked;
    }

    private JComboBox<Integer> universeSizeComboBox;
    private JButton okButton;
    private JButton cancelButton;

    private final int DIALOG_WIDTH = 700;
    private final int DIALOG_HEIGHT = 250;
    private int requestedUniverseSize;
    private boolean okClicked;
}
