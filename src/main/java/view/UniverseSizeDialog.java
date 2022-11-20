package view;

import config.Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UniverseSizeDialog extends JDialog
{
    public UniverseSizeDialog()
    {
        setTitle("Universe size dialog");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(null);

        setSize(dialogWidth, dialogHeight);

        addLabel();
        addComboBox();
        addButtons();

        addActions();

        setLocationRelativeTo(null);
        setMinimumSize(getSize());
        setResizable(false);
        setModal(true);
        setVisible(true);
    }

    private void addLabel()
    {
        JLabel universeSizeLabel = new JLabel("Choose universe size");
        universeSizeLabel.setBounds(0, 0, dialogWidth, 50);
        universeSizeLabel.setFont(new Font(null, Font.BOLD, 50));
        add(universeSizeLabel);
    }

    private void addComboBox()
    {
        universeSizeComboBox = new JComboBox<>();
        universeSizeComboBox.setBounds(0, 60, dialogWidth - 15, 50);
        universeSizeComboBox.setFocusable(false);
        universeSizeComboBox.setFont(new Font(null, Font.BOLD, 30));

        ((JLabel) universeSizeComboBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = Config.MIN_UNIVERSE_SIZE; i <= Config.MAX_UNIVERSE_SIZE; i++)
        {
            universeSizeComboBox.addItem(i);
        }

        universeSizeComboBox.setSelectedIndex(25);

        add(universeSizeComboBox);
    }

    private void addButtons()
    {
        okButton = new JButton("OK");
        okButton.setBounds(0, 130, dialogWidth - 15, 40);
        okButton.setFocusable(false);

        add(okButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(0, 170, dialogWidth - 15, 40);
        cancelButton.setFocusable(false);

        add(cancelButton);
    }

    @SuppressWarnings("ConstantConditions")
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

        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosed(WindowEvent e)
            {
                if (!okClicked)
                {
                    System.exit(0);
                }
            }
        });
    }

    public int getRequestedUniverseSize()
    {
        return requestedUniverseSize;
    }

    private JComboBox<Integer> universeSizeComboBox;
    private JButton okButton;
    private JButton cancelButton;

    private final int dialogWidth = 527;
    @SuppressWarnings("FieldCanBeLocal")
    private final int dialogHeight = 250;
    private int requestedUniverseSize;
    private boolean okClicked;
}
