package it.unimol.monopoly.gui.frames;

import it.unimol.monopoly.app.PlayerManager;
import it.unimol.monopoly.app.Player;
import it.unimol.monopoly.gui.forms.GameForm;
import it.unimol.monopoly.gui.forms.FeeForm;
import it.unimol.monopoly.gui.frames.properties.FrameProperties;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.URL;

public class FeeFrame extends JFrame {
    private FeeForm feeForm;
    private Image icon;
    public static boolean isDisposing;
    private WindowListener exitListener = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            FrameProperties.openFeeFrame(false);
            super.windowClosing(e);
        }
    };

    public FeeFrame(GameForm previousForm, Player player, PlayerManager players) {
        this.setSize(400,100);
        this.setTitle("Monopoly - Fee");
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.addWindowListener(this.exitListener);

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

        this.feeForm = new FeeForm(this, previousForm, player, players);
        this.setContentPane(this.feeForm.getMainPanel());
    }

    public static void refreshMotherForm(GameForm previousForm, Player player, PlayerManager players) {
        if (isDisposing) {
            previousForm.refresh(player, players);
        }
    }
}
