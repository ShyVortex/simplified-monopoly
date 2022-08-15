package it.unimol.monopoly.gui.frames;

import it.unimol.monopoly.app.PlayerManager;
import it.unimol.monopoly.app.Player;
import it.unimol.monopoly.gui.forms.GameForm;
import it.unimol.monopoly.gui.forms.FeeForm;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FeeFrame extends JFrame {
    private FeeForm feeForm;
    private Image icon;
    public static boolean isDisposing;

    public FeeFrame(GameForm previousForm, Player player, PlayerManager players) {
        this.setSize(400,100);
        this.setTitle("Monopoly - Fee");
        this.setMinimumSize(new Dimension(300, 100));
        this.setMaximumSize(new Dimension(600, 100));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        try {
            this.icon = ImageIO.read(new File("src/it/unimol/monopoly/icons/Monopoly.png"));
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
