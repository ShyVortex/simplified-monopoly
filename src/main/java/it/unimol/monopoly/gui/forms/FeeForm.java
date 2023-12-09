package it.unimol.monopoly.gui.forms;

import it.unimol.monopoly.app.Fee;
import it.unimol.monopoly.app.PlayerManager;
import it.unimol.monopoly.app.Player;
import it.unimol.monopoly.gui.frames.FeeFrame;
import it.unimol.monopoly.gui.frames.properties.FrameProperties;

import javax.swing.*;

public class FeeForm {
    private JTextField feeField;
    private JButton okButton;
    private JButton cancelButton;
    private JPanel mainPanel;
    private JFrame givenFrame;

    public FeeForm(JFrame myFrame, GameForm gameForm, Player player, PlayerManager players) {
        this.givenFrame = myFrame;

        this.okButton.addActionListener(
                actionEvent -> handleInputFee(gameForm, player, players)
        );

        this.cancelButton.addActionListener(
                actionEvent -> handleCancel()
        );
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void handleInputFee(GameForm gameForm, Player player, PlayerManager players) {
        String input = this.feeField.getText();
        boolean checkIfNumeric = this.isNumeric(input);
        if (checkIfNumeric) {
            int convertedValue = Integer.parseInt(input);
            convertedValue = Math.abs(convertedValue);
            Fee fee = new Fee(convertedValue);
            boolean canPay = fee.payFee(player);
            if (canPay) {
                JOptionPane.showMessageDialog(
                        this.givenFrame,
                        "Fee successfully paid. " + convertedValue + "€ have been subtracted from your account.",
                        "Payment completed",
                        JOptionPane.INFORMATION_MESSAGE
                );

                FeeFrame.isDisposing = true;
                this.givenFrame.dispose();
                FrameProperties.openFeeFrame(false);
                FeeFrame.refreshMotherForm(gameForm, player, players);
            } else {
                JOptionPane.showMessageDialog(
                        this.givenFrame,
                        "The fee couldn't be paid because you don't have enough money. Your account has been reset.",
                        "ERROR: Not enough money",
                        JOptionPane.ERROR_MESSAGE
                );

                FeeFrame.isDisposing = true;
                this.givenFrame.dispose();
                FeeFrame.refreshMotherForm(gameForm, player, players);
            }
        } else {
            JOptionPane.showMessageDialog(
                    this.givenFrame,
                    "You entered an incorrect value.",
                    "ERROR: Non-valid Input",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private boolean isNumeric(String input) {
        if (input.isEmpty() || input.isBlank()) // If the string is empty, returns false
            return false;

        try {                                // Tries to cast the string to an integer
            int x = Integer.parseInt(input);
        } catch (NumberFormatException e) { // If it finds a numeric value returns false
            return false;
        }

        return true;                       // Else returns true
    }

    private void handleCancel() {
        this.givenFrame.dispose();
        FrameProperties.openFeeFrame(false);
    }

}
