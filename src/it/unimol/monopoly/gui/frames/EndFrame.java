package it.unimol.monopoly.gui.frames;

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
        this.setTitle("MonopolyEnd");
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

        this.endForm = new EndForm(this, player);
        this.setContentPane(this.endForm.getEndPanel());
    }
}
