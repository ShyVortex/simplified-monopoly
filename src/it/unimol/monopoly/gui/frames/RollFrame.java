package it.unimol.monopoly.gui.frames;

import it.unimol.monopoly.app.ContractManager;
import it.unimol.monopoly.app.PlayerManager;
import it.unimol.monopoly.app.Player;
import it.unimol.monopoly.gui.forms.RollForm;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class RollFrame extends JFrame {
    private RollForm rollForm;
    private Image icon;

    public RollFrame(Player player, PlayerManager players, ContractManager contracts) {
        super();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize);
        this.setTitle("Monopoly - Initialization");
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        try {
            this.icon = ImageIO.read(new File("src/main/resources/icons/Monopoly.png"));
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
        this.setContentPane(this.rollForm);
    }
}
