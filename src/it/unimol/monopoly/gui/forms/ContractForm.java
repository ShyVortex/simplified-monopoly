package it.unimol.monopoly.gui.forms;

import it.unimol.monopoly.app.Contract;
import it.unimol.monopoly.app.ContractManager;
import it.unimol.monopoly.app.PlayerManager;
import it.unimol.monopoly.app.Player;
import it.unimol.monopoly.gui.frames.ContractFrame;

import javax.swing.*;

public class ContractForm {
    private JList listContract;
    private JButton purchaseButton;
    private JButton cancelButton;
    private JPanel mainPanel;
    private JFrame givenFrame;

    public ContractForm(JFrame myFrame, GameForm gameForm, Player player, ContractManager contracts, PlayerManager players) {
        this.givenFrame = myFrame;
        setContractList(contracts);

        this.purchaseButton.addActionListener(
                actionEvent -> handlePurchase(gameForm, player, players)
        );

        this.cancelButton.addActionListener(
                actionEvent -> handleCancel()
        );
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void setContractList(ContractManager contracts) {
        DefaultListModel listModel = new DefaultListModel();
        for (Contract x : contracts.getContracts().values()) {
            assert x != null;
            listModel.addElement(x);
        }

        this.listContract.setModel(listModel);
    }

    private void handlePurchase(GameForm gameForm, Player player, PlayerManager players) {
        Contract contract = (Contract) this.listContract.getSelectedValue();
        if (contract.isAvailable() && player.getMoney() >= contract.getPrice()) {
            contract.buyContract(player, contract);
            JOptionPane.showMessageDialog(
                    this.givenFrame,
                    "You have successfully purchased the contract " + contract.getName() + " paying it " + contract.getPrice()
                            + "€.",
                    "Contract purchased",
                    JOptionPane.INFORMATION_MESSAGE
            );
            ContractFrame.isDisposing = true;
            this.givenFrame.dispose();
            ContractFrame.refreshMotherForm(gameForm, player, players);
        }
        else {
            if (contract.isAvailable() && player.getMoney() < contract.getPrice()) {
                JOptionPane.showMessageDialog(
                        this.givenFrame,
                        "You don't have enough money to purchase the contract.",
                        "ERROR: Not enough money",
                        JOptionPane.ERROR_MESSAGE
                );
            }
            if (!contract.isAvailable()) {
                JOptionPane.showMessageDialog(
                        this.givenFrame,
                        "The contract you selected isn't currently available.",
                        "ERROR: Unavailable Contract",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    private void handleCancel() {
        this.givenFrame.dispose();
    }
}
