package it.unimol.monopoly.gui.frames;

import it.unimol.monopoly.app.ContractManager;
import it.unimol.monopoly.app.PlayerManager;
import it.unimol.monopoly.app.Player;
import it.unimol.monopoly.gui.forms.GameForm;
import it.unimol.monopoly.gui.forms.PrisonForm;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class GameFrame extends JFrame {
    private GameForm gameForm;
    private PrisonForm prisonForm;
    private Image icon;
    public static short displayValue;
    public static Dimension screenSize;

    public GameFrame(Player player, PlayerManager players, ContractManager contracts) {
        super();

        this.setSize(screenSize);
        this.setTitle("MonopolyGame");
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //              Fullscreen                //
        if (displayValue == 1) {
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.setUndecorated(true);
        }
        ////////////////////////////////////////////

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

        if (!player.isPrisoner()) {
            this.gameForm = new GameForm(this, player, players, contracts);
            this.setContentPane(this.gameForm.getGameScrollPane());
        }
        else {
            this.prisonForm = new PrisonForm(this, player, players, contracts);
            this.setContentPane(this.prisonForm.getPrisonScrollPane());
        }
    }
}
