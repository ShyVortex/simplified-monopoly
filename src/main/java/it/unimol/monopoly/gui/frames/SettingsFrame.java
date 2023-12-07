package it.unimol.monopoly.gui.frames;

import it.unimol.monopoly.app.Game;
import it.unimol.monopoly.gui.forms.SettingsForm;
import it.unimol.monopoly.gui.frames.properties.FrameProperties;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.URL;

public class SettingsFrame extends JFrame {
    private SettingsForm settingsForm;
    private Image icon;
    private WindowListener exitListener = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            FrameProperties.openSettingsPage(false);
            super.windowClosing(e);
        }
    };

    public SettingsFrame() {
        super();

        this.setSize(550,600);
        this.setTitle("MonopolySettings - " + Game.releaseVersion);
        this.setMinimumSize(new Dimension(450,400));
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

        this.settingsForm = new SettingsForm(this);
        this.setContentPane(this.settingsForm.getMainPanel());
    }
}
