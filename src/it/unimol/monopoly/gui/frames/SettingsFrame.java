package it.unimol.monopoly.gui.frames;

import it.unimol.monopoly.gui.forms.SettingsForm;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class SettingsFrame extends JFrame {
    private SettingsForm settingsForm;
    private Image icon;
    public static final Dimension DEFAULT_RES = new Dimension(1920, 1080);

    public SettingsFrame() {
        super();

        this.setSize(500,600);
        this.setTitle("MonopolySettings");
        this.setMinimumSize(new Dimension(450,400));
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

        this.settingsForm = new SettingsForm(this);
        this.setContentPane(this.settingsForm.getMainPanel());
    }
}
