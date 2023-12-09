package it.unimol.monopoly.gui.forms;

import it.unimol.monopoly.app.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class EndForm {
    private JLabel gameOverLabel;
    private JTextPane gameOverPane;
    private JButton quitButton;
    private JPanel endPanel;
    private JFrame givenFrame;
    private Image gameOverImage;

    public EndForm(JFrame myFrame, Player player) {
        this.givenFrame = myFrame;

        try {
            URL gameOverUrl = this.getClass().getResource("/icons/GameOver.jpg");
            assert gameOverUrl != null;
            this.gameOverImage = ImageIO.read(gameOverUrl);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    this.givenFrame,
                    "Game Over icon not found",
                    "Missing icon",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        assert this.gameOverImage != null;
        ImageIcon gameOverIcon = new ImageIcon(gameOverImage);
        this.gameOverLabel.setIcon(gameOverIcon);

        setWinnerText(player);

        this.quitButton.addActionListener(
                actionEvent -> handleEndGame()
        );
    }

    public JPanel getEndPanel() {
        return endPanel;
    }

    private void setWinnerText(Player player) {
        this.gameOverPane.setText("GAME OVER!\n" +
                "Winner: " + player.getName());
    }

    private void handleEndGame() {
        File contractData = new File("contracts.sr");
        File playerData = new File("players.sr");
        File turnoData = new File("turn.sr");
        contractData.delete();
        playerData.delete();
        turnoData.delete();

        this.givenFrame.dispose();
        System.exit(0);
    }
}
