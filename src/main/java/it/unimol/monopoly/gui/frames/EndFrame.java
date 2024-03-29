package it.unimol.monopoly.gui.frames;

import it.unimol.monopoly.app.Game;
import it.unimol.monopoly.app.Player;
import it.unimol.monopoly.gui.forms.EndForm;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class EndFrame extends JFrame {
    private EndForm endForm;
    private Image icon;

    public EndFrame(Player player) {
        super();

        this.setSize(500,600);
        this.setTitle("MonopolyEnd - " + Game.releaseVersion);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        try {
            URL iconUrl = this.getClass().getResource("/icons/Monopoly.png");
            assert iconUrl != null;
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

        try {
            this.endForm = new EndForm(this, player);
            this.setContentPane(this.endForm.getEndPanel());

        } catch (ClassFormatError e) {
            JOptionPane.showMessageDialog(
                    this,
                    "There was an unexpected error. Anyway, congrats to the winner: " + player.getName() + "!",
                    "ERROR: Game Over failure",
                    JOptionPane.ERROR_MESSAGE
            );
            JOptionPane.showMessageDialog(
                    this,
                    "Exiting now...",
                    "INFO: Forced Quit",
                    JOptionPane.INFORMATION_MESSAGE
            );
            System.exit(0);
        }
    }
}
