package it.unimol.monopoly.gui.forms;

import it.unimol.monopoly.app.*;
import it.unimol.monopoly.exceptions.BlankNameException;
import it.unimol.monopoly.exceptions.MultipleInstancesException;
import it.unimol.monopoly.exceptions.SpecialCharException;
import it.unimol.monopoly.exceptions.StartingSpaceException;
import it.unimol.monopoly.gui.frames.RollFrame;
import it.unimol.monopoly.gui.frames.SettingsFrame;
import it.unimol.monopoly.gui.frames.properties.FrameProperties;

import javax.swing.*;

import java.awt.*;
import java.util.List;
import java.util.Objects;

import static java.lang.System.exit;

public class MainForm {
    private JButton playerButton;
    private JButton gameButton;
    private JButton quitButton;
    private JTextField nameField;
    private JComboBox pawnBox;
    private JPanel mainPanel;
    private JPanel playerPanel;
    private JButton confirmButton;
    private JButton revertButton;
    private JButton playerListButton;
    private JButton okButton;
    private JPanel playerListPanel;
    private JTextPane playerArea;
    private JButton settingsButton;
    private JFrame givenFrame;
    private Player playerToAdd;
    private Pawn pawnToAdd;
    private PawnManager pawns;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public MainForm(JFrame myFrame, PlayerManager players, ContractManager contracts) {
        this.givenFrame = myFrame;
        this.playerPanel.setVisible(false);
        this.playerListPanel.setVisible(false);

        this.playerButton.addActionListener(
                actionEvent -> handleInsertUI()
        );

        this.playerListButton.addActionListener(
                actionEvent -> handlePlayerList(players)
        );

        this.gameButton.addActionListener(
                actionEvent -> handleStartGame(players, contracts)
        );

        this.quitButton.addActionListener(
                actionEvent -> exit(0)
        );

        this.revertButton.addActionListener(
                actionEvent -> this.playerPanel.setVisible(false)
        );

        this.confirmButton.addActionListener(
                actionEvent -> handleAddPlayer(players)
        );

        this.settingsButton.addActionListener(
                actionEvent -> handleSettingsMenu()
        );
    }

    private void handleInsertUI() {
        this.playerPanel.setVisible(true);
        this.pawnBox.addItem("WHEELBARROW");
        this.pawnBox.addItem("SHOE");
        this.pawnBox.addItem("DOG");
        this.pawnBox.addItem("CAR");
        this.pawnBox.addItem("TOP HAT");
        this.pawnBox.addItem("BATTLESHIP");
    }

    private void handlePlayerList(PlayerManager giocatori) {
        this.playerListPanel.setVisible(true);
        this.playerArea.setText(giocatori.toString());
        if (giocatori.getPlayers().isEmpty())
            this.playerArea.setText("Still no players!");

        this.okButton.addActionListener(
                actionEvent -> this.playerListPanel.setVisible(false)
        );
    }

    private void updatePlayerList(PlayerManager giocatori) {
        this.playerArea.setText(giocatori.toString());
    }

    private void handleAddPlayer(PlayerManager giocatori) {
        if (giocatori.getPlayers().size() < 6) {
            try {
                this.pawns = PawnManager.getInstance();
                String nomeGiocatore = "";
                nomeGiocatore = this.nameField.getText();
                if (nomeGiocatore.equals(""))
                    throw new BlankNameException();
                else if (nomeGiocatore.startsWith(" "))
                    throw new StartingSpaceException();
                else if
                (
                        nomeGiocatore.contains("@") || nomeGiocatore.contains("#") || nomeGiocatore.contains("+") ||
                                nomeGiocatore.contains("*") || nomeGiocatore.contains("-") || nomeGiocatore.contains("_") ||
                                nomeGiocatore.contains("'") || nomeGiocatore.contains(";") || nomeGiocatore.contains(":") ||
                                nomeGiocatore.contains("(") || nomeGiocatore.contains(")") || nomeGiocatore.contains("[") ||
                                nomeGiocatore.contains("{") || nomeGiocatore.contains("}") || nomeGiocatore.contains("£") ||
                                nomeGiocatore.contains("$") || nomeGiocatore.contains("%") || nomeGiocatore.contains("&") ||
                                nomeGiocatore.contains("/") || nomeGiocatore.contains("=") || nomeGiocatore.contains("!") ||
                                nomeGiocatore.contains("|") || nomeGiocatore.contains("^") || nomeGiocatore.contains("?")
                )
                    throw new SpecialCharException();
                String selectedInput = Objects.requireNonNull(this.pawnBox.getSelectedItem()).toString();
                this.pawnToAdd = this.pawns.getPawns().get(selectedInput);
                this.playerToAdd = new Player(nomeGiocatore, pawnToAdd);
                boolean isNameAlreadyUsed = giocatori.checkNameAlreadyTaken(nomeGiocatore);
                boolean isPedinaAlreadyUsed = giocatori.checkPawnAlreadyTaken(selectedInput);
                if (!isNameAlreadyUsed && !isPedinaAlreadyUsed)
                    giocatori.addPlayer(this.playerToAdd.getId(), this.playerToAdd);
                else {
                    if (isNameAlreadyUsed && isPedinaAlreadyUsed)
                        Player.aux++;
                    if (isNameAlreadyUsed) {
                        JOptionPane.showMessageDialog(
                                this.givenFrame,
                                "You can't create two or more players with the same name.",
                                "ERROR: Duplicated name",
                                JOptionPane.ERROR_MESSAGE
                        );
                    }
                    if (isPedinaAlreadyUsed) {
                        JOptionPane.showMessageDialog(
                                this.givenFrame,
                                "You can't create two or more players with the same pawn.",
                                "ERROR: Duplicated pawn",
                                JOptionPane.ERROR_MESSAGE
                        );
                    }
                }
                this.updatePlayerList(giocatori);
            } catch (BlankNameException e) {
                JOptionPane.showMessageDialog(
                        this.givenFrame,
                        "You can't select an empty name.",
                        "ERROR: Void string",
                        JOptionPane.ERROR_MESSAGE
                );
            } catch (StartingSpaceException e) {
                JOptionPane.showMessageDialog(
                        this.givenFrame,
                        "You can't start your name with a backspace character.",
                        "ERROR: Starting backspace char",
                        JOptionPane.ERROR_MESSAGE
                );
            } catch (SpecialCharException e) {
                JOptionPane.showMessageDialog(
                        this.givenFrame,
                        "You can't enter special characters.",
                        "ERROR: Special characters",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        } else {
            JOptionPane.showMessageDialog(
                    this.givenFrame,
                    "You can't add more than 6 players",
                    "ERROR: Full load",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void handleSettingsMenu() {
        try {
            if (!FrameProperties.isSettingsPageOpen()) {
                SettingsFrame settingsFrame = new SettingsFrame();
                settingsFrame.setVisible(true);
                FrameProperties.openSettingsPage(true);
            } else
                throw new MultipleInstancesException();

        } catch (MultipleInstancesException e) {
            JOptionPane.showMessageDialog(
                    this.givenFrame,
                    "You can't simultaneously open the settings page more than once.",
                    "ERROR: Multiple instances",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void handleStartGame(PlayerManager players, ContractManager contracts) {
        if (players.getPlayers().size() < 2) {
            JOptionPane.showMessageDialog(
                    this.givenFrame,
                    "You can't start the game with less than two players.",
                    "ERROR: Not enough players",
                    JOptionPane.ERROR_MESSAGE
            );
        } else {
            Game game = new Game(players);
            game.setPlayersMoney(players);
            game.setInitialContractsNum(players);
            players = game.generateOrder(players);
            contracts = game.setMatchContracts(contracts);
            for (Player player : players.getPlayers().values()) {
                List<Contract> listContracts = game.generateRandomContracts(contracts);
                int contractsPrice = game.buyInitialContracts(player, listContracts);
                JOptionPane.showMessageDialog(
                        this.givenFrame,
                        "The player " + player.getName() + " has received " + player.getNumContracts() + " contracts "
                                + "paying them " + contractsPrice + "€.",
                        "Initial contracts purchase",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
            Player player = game.setFirstPlayer(players);

            RollFrame rollFrame = new RollFrame(player, players, contracts);
            rollFrame.setVisible(true);
            this.givenFrame.dispose();
        }
    }

}