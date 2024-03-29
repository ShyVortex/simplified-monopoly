package it.unimol.monopoly.gui.frames;

import it.unimol.monopoly.app.ContractManager;
import it.unimol.monopoly.app.Game;
import it.unimol.monopoly.app.PlayerManager;
import it.unimol.monopoly.app.Player;
import it.unimol.monopoly.gui.forms.RollForm;
import it.unimol.monopoly.gui.frames.properties.FrameProperties;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class RollFrame extends JFrame {
    private RollForm rollForm;
    private Image icon;
    public static Dimension screenSize = FrameProperties.NATIVE_RES;

    public RollFrame(Player player, PlayerManager players, ContractManager contracts) {
        super();

        this.setSize(screenSize);
        this.setTitle("Monopoly - Initialization (" + Game.releaseVersion + ")");
        this.setResizable(FrameProperties.getResizable());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //              Borderless               //
        if (FrameProperties.getDisplayValue() == 1) {
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.setUndecorated(true);
        }
        ////////////////////////////////////////////

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
        this.setIconImage(icon);

        this.rollForm = new RollForm(this, player, players, contracts);
        this.setContentPane(this.rollForm.getRollScrollPane());
    }
}
