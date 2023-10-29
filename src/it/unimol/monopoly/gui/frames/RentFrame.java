package it.unimol.monopoly.gui.frames;

import it.unimol.monopoly.app.PlayerManager;
import it.unimol.monopoly.app.Player;
import it.unimol.monopoly.gui.forms.RentForm;
import it.unimol.monopoly.gui.forms.GameForm;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class RentFrame extends JFrame {
    private RentForm rentForm;
    private Image icon;
    public static boolean isDisposing;

    public RentFrame(GameForm previousForm, Player player, PlayerManager players) {
        this.setSize(700,400);
        this.setTitle("Monopoly - Rents");
        this.setMinimumSize(new Dimension(650, 300));
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

        this.rentForm = new RentForm(this, previousForm, player, players);
        this.setContentPane(this.rentForm.getMainPanel());
    }

    public static void refreshMotherForm(GameForm previousForm, Player player, PlayerManager players) {
        if (isDisposing) {
            previousForm.refresh(player, players);
        }
    }
}
