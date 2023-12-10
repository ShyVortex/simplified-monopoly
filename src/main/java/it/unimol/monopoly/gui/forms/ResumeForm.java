package it.unimol.monopoly.gui.forms;

import it.unimol.monopoly.app.ContractManager;
import it.unimol.monopoly.app.PlayerManager;
import it.unimol.monopoly.app.Player;
import it.unimol.monopoly.app.Turn;
import it.unimol.monopoly.gui.frames.RollFrame;
import it.unimol.monopoly.gui.frames.SettingsFrame;

import javax.swing.*;

import static java.lang.System.exit;

public class ResumeForm {
    private JPanel mainPanel;
    private JButton resumeGameButton;
    private JButton playerListButton;
    private JButton quitButton;
    private JPanel playerListPanel;
    private JButton okButton;
    private JTextPane playerArea;
    private JButton settingsButton;
    private JFrame givenFrame;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public ResumeForm(JFrame myFrame, PlayerManager players, ContractManager contracts) {
        this.givenFrame = myFrame;
        this.playerListPanel.setVisible(false);

        this.resumeGameButton.addActionListener(
                actionEvent -> handleResume(players, contracts)
        );

        this.playerListButton.addActionListener(
                actionEvent -> handlePlayerList(myFrame, players)
        );

        this.quitButton.addActionListener(
                actionEvent -> exit(0)
        );

        this.settingsButton.addActionListener(
                actionEvent -> handleSettingsMenu()
        );
    }

    private void handlePlayerList(JFrame myFrame, PlayerManager players) {
        this.playerListPanel.setVisible(true);
        this.playerArea.setText(players.toString());

        this.okButton.addActionListener(
                actionEvent -> this.playerListPanel.setVisible(false)
        );
    }

    private void handleSettingsMenu() {
        SettingsFrame settingsFrame = new SettingsFrame();
        settingsFrame.setVisible(true);
    }

    private void handleResume(PlayerManager players, ContractManager contracts) {
        Player lastPlayer = players.changePlayer(Turn.playerId);

        RollFrame rollFrame = new RollFrame(lastPlayer, players, contracts);
        this.givenFrame.dispose();
        rollFrame.setVisible(true);
    }

}
