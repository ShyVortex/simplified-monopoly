package it.unimol.monopoly.gui.frames;

import it.unimol.monopoly.app.PlayerManager;
import it.unimol.monopoly.app.Player;
import it.unimol.monopoly.gui.forms.GameForm;
import it.unimol.monopoly.gui.forms.FeeForm;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class FeeFrame extends JFrame {
    private FeeForm feeForm;
    private Image icon;
    public static boolean isDisposing;

    public FeeFrame(GameForm previousForm, Player player, PlayerManager players) {
        this.setSize(400,100);
        this.setTitle("Monopoly - Fee");
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

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

        this.feeForm = new FeeForm(this, previousForm, player, players);
        this.setContentPane(this.feeForm.getMainPanel());
    }

    public static void refreshMotherForm(GameForm previousForm, Player player, PlayerManager players) {
        if (isDisposing) {
            previousForm.refresh(player, players);
        }
    }
}
