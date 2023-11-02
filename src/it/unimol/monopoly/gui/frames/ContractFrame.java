package it.unimol.monopoly.gui.frames;

import it.unimol.monopoly.app.ContractManager;
import it.unimol.monopoly.app.PlayerManager;
import it.unimol.monopoly.app.Player;
import it.unimol.monopoly.gui.forms.ContractForm;
import it.unimol.monopoly.gui.forms.GameForm;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class ContractFrame extends JFrame {
    private ContractForm form;
    private Image icon;
    public static boolean isDisposing;

    public ContractFrame(GameForm previousForm, Player player, ContractManager contracts, PlayerManager players) {
        this.setSize(500,600);
        this.setTitle("Monopoly - Contracts");
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

        this.form = new ContractForm(this, previousForm, player, contracts, players);
        this.setContentPane(this.form.getMainPanel());
    }

    public static void refreshMotherForm(GameForm previousForm, Player player, PlayerManager players) {
        if (isDisposing)
            previousForm.refresh(player, players);
    }
}