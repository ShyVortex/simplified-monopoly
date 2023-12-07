package it.unimol.monopoly.gui.forms;

import it.unimol.monopoly.app.Player;
import it.unimol.monopoly.app.Rent;
import it.unimol.monopoly.app.Contract;
import it.unimol.monopoly.app.PlayerManager;
import it.unimol.monopoly.gui.frames.RentFrame;
import it.unimol.monopoly.gui.frames.properties.FrameProperties;

import javax.swing.*;

public class RentForm {
    private JList playerList;
    private JList rentList;
    private JButton chooseButton;
    private JButton cancelButton;
    private JButton payButton;
    private JButton revertButton;
    private JPanel mainPanel;
    private JFrame givenFrame;
    private Player player2;

    public RentForm(JFrame myFrame, GameForm gameForm, Player player, PlayerManager players) {
        this.givenFrame = myFrame;
        this.rentList.setVisible(false);
        this.payButton.setVisible(false);
        this.revertButton.setVisible(false);
        setPlayerList(players);

        this.chooseButton.addActionListener(
                actionEvent -> handleChoose(player)
        );

        this.cancelButton.addActionListener(
                actionEvent -> handleCancel()
        );

        this.payButton.addActionListener(
                actionEvent -> handlePay(gameForm, player, player2, players)
        );

        this.revertButton.addActionListener(
                actionEvent -> handleRevert()
        );
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void setPlayerList(PlayerManager players) {
        DefaultListModel playerListModel = new DefaultListModel();
        for (Player x : players.getPlayers().values()) {
            playerListModel.addElement(x);
        }

        this.playerList.setModel(playerListModel);
    }

    private void handleChoose(Player player1) {
        player2 = (Player) this.playerList.getSelectedValue();
        if (player2.getId() != player1.getId()) {
            setRentList(player2);
            this.rentList.setVisible(true);
            this.payButton.setVisible(true);
            this.revertButton.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(
                    this.givenFrame,
                    "You can't select yourself",
                    "ERROR: Same ID",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void setRentList(Player player) {
        DefaultListModel rentListModel = new DefaultListModel();
        for (Contract x : player.getContracts()) {
            assert x != null;
            rentListModel.addElement(x);
        }

        this.rentList.setModel(rentListModel);
    }

    private void handleCancel() {
        this.givenFrame.dispose();
        FrameProperties.openRentFrame(false);
    }

    private void handlePay(GameForm gameForm, Player player1, Player player2, PlayerManager players) {
        Contract chosen = (Contract) this.rentList.getSelectedValue();
        Rent toPay = new Rent();
        boolean payment = toPay.payRent(player1, player2, chosen);

        if (payment) {
            JOptionPane.showMessageDialog(
                    this.givenFrame,
                    "The rent payment of " + chosen.getName() + " was successful." +
                            " " + chosen.getRentValue() + "€ have been subtracted from your account",
                    "Payment completed",
                    JOptionPane.INFORMATION_MESSAGE
            );

            RentFrame.isDisposing = true;
            this.givenFrame.dispose();
            FrameProperties.openRentFrame(false);
            RentFrame.refreshMotherForm(gameForm, player1, players);
        } else {
            JOptionPane.showMessageDialog(
                    this.givenFrame,
                    "The rent payment of " + chosen.getName() + " was unsuccessful because you don't have "
                            + "enough money. Your account has been reset",
                    "ERROR: Not enough money",
                    JOptionPane.ERROR_MESSAGE
            );

            this.givenFrame.dispose();
            FrameProperties.openRentFrame(false);
        }
    }

    private void handleRevert() {
        this.rentList.setVisible(false);
        this.payButton.setVisible(false);
        this.revertButton.setVisible(false);
    }
}
