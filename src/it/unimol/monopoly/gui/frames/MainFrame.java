package it.unimol.monopoly.gui.frames;

import it.unimol.monopoly.app.ContractManager;
import it.unimol.monopoly.app.Game;
import it.unimol.monopoly.app.PlayerManager;
import it.unimol.monopoly.app.Turn;
import it.unimol.monopoly.gui.forms.MainForm;
import it.unimol.monopoly.gui.forms.ResumeForm;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class MainFrame extends JFrame {
    private MainForm mainForm;
    private ResumeForm resumeForm;
    private Image icon;
    private Turn turn;

    public MainFrame() {
        super();

        this.setSize(500,600);
        this.setTitle("MonopolyMenu - " + Game.releaseVersion);
        this.setMinimumSize(new Dimension(450,400));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        try {
            URL iconUrl = ClassLoader.getSystemResource("Monopoly.png");
            this.icon = ImageIO.read(iconUrl);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Application icon not found",
                    "Missing icon",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        assert this.icon != null;
        this.setIconImage(this.icon);

        PlayerManager players = new PlayerManager();
        ContractManager contracts = new ContractManager();
        try {
            contracts = ContractManager.loadContracts();
            players = PlayerManager.loadPlayers();
            Turn.playerId = Turn.loadTurn();
            this.resumeForm = new ResumeForm(this, players, contracts);
            this.setContentPane(this.resumeForm.getMainPanel());
        } catch (FileNotFoundException e) {
            this.mainForm = new MainForm(this, players, contracts);
            this.setContentPane(this.mainForm.getMainPanel());
        } catch (IncompatibleClassChangeError e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Game files were updated and their state is deprecated. Please delete save files.",
                    "Save Restoration Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
