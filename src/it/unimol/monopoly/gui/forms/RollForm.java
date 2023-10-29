/*
 * Created by JFormDesigner on Sat May 21 17:45:10 CEST 2022
 */

package it.unimol.monopoly.gui.forms;

import it.unimol.monopoly.app.*;
import it.unimol.monopoly.gui.frames.GameFrame;
import it.unimol.monopoly.gui.frames.RollFrame;
import it.unimol.monopoly.gui.frames.SettingsFrame;
import it.unimol.monopoly.threads.StoppableThread;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

import static it.unimol.monopoly.app.PositionManager.*;
/**
 * @author unknown
 */
public class RollForm {
    private JFrame givenFrame;
    private static JFrame messageFrame;
    private static boolean skipMessage;
    public static boolean wentDownStart;
    private StoppableThread resizingChecker;
    private Action buttonClickAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            okButton.doClick();
        }
    };

    public RollForm(JFrame myFrame, Player player, PlayerManager players, ContractManager contracts) {
        initComponents();
        this.givenFrame = myFrame;
        messageFrame = this.givenFrame;
        if (GameFrame.scalingFactor == 2)
            autoResize();
        else
            applyResolution();
        this.givenFrame.add(this.rollScrollPane);
        initialize(player);
        elaboratePosition(player);
        bindKeyToButton();
        checkResizing();

        this.okButton.addActionListener(
                actionEvent -> handleOK(player, players, contracts)
        );
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        rollScrollPane = new JScrollPane();
        rollPanel = new JPanel();
        playerTextArea = new JTextArea();
        playerTextPane = new JTextPane();
        diceLabel = new JLabel();
        diceRollTextArea = new JTextArea();
        positionTextArea = new JTextArea();
        positionIDTextPane = new JTextPane();
        positionNameTextPane = new JTextPane();
        okButton = new JButton();

        //======== rollScrollPane ========
        {

            //======== rollPanel ========
            {
                rollPanel.setBackground(new Color(0xfefffe));
                rollPanel.setMinimumSize(new Dimension(640, 360));

                //---- playerTextArea ----
                playerTextArea.setFont(new Font("Noto Sans", Font.BOLD, 40));
                playerTextArea.setText("Turn of:");
                playerTextArea.setBackground(new Color(0xfefffe));
                playerTextArea.setForeground(new Color(0x7a8c93));
                playerTextArea.setEditable(false);

                //---- playerTextPane ----
                playerTextPane.setFont(new Font("Noto Sans", Font.BOLD, 40));
                playerTextPane.setBackground(new Color(0xfefffe));
                playerTextPane.setForeground(new Color(0x7a8c93));
                playerTextPane.setEditable(false);

                //---- diceLabel ----
                diceLabel.setIcon(new ImageIcon(getClass().getResource("/Dice.png")));

                //---- diceRollTextArea ----
                diceRollTextArea.setText("Rolling the dice...");
                diceRollTextArea.setFont(new Font("Noto Sans", Font.BOLD, 40));
                diceRollTextArea.setBackground(new Color(0xfefffe));
                diceRollTextArea.setForeground(new Color(0x7a8c93));
                diceRollTextArea.setEditable(false);
                diceRollTextArea.setAutoscrolls(false);

                //---- positionTextArea ----
                positionTextArea.setFont(new Font("Noto Sans", Font.BOLD, 40));
                positionTextArea.setText("Your position is:");
                positionTextArea.setBackground(new Color(0xfefffe));
                positionTextArea.setForeground(new Color(0x7a8c93));
                positionTextArea.setEditable(false);
                positionTextArea.setAutoscrolls(false);

                //---- positionIDTextPane ----
                positionIDTextPane.setFont(new Font("Noto Sans", Font.BOLD, 40));
                positionIDTextPane.setBackground(new Color(0xfefffe));
                positionIDTextPane.setForeground(new Color(0x7a8c93));

                //---- positionNameTextPane ----
                positionNameTextPane.setBackground(new Color(0xfefffe));
                positionNameTextPane.setForeground(Color.black);
                positionNameTextPane.setFont(new Font("Noto Sans", Font.BOLD, 30));
                positionNameTextPane.setEditable(false);

                //---- okButton ----
                okButton.setText("OK");
                okButton.setBackground(new Color(0xced9dc));

                GroupLayout rollPanelLayout = new GroupLayout(rollPanel);
                rollPanel.setLayout(rollPanelLayout);
                rollPanelLayout.setHorizontalGroup(
                    rollPanelLayout.createParallelGroup()
                        .addGroup(rollPanelLayout.createSequentialGroup()
                            .addGroup(rollPanelLayout.createParallelGroup()
                                .addGroup(rollPanelLayout.createSequentialGroup()
                                    .addGap(139, 139, 139)
                                    .addComponent(playerTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(playerTextPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(rollPanelLayout.createSequentialGroup()
                                    .addGap(759, 759, 759)
                                    .addGroup(rollPanelLayout.createParallelGroup()
                                        .addComponent(diceRollTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(diceLabel, GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(rollPanelLayout.createSequentialGroup()
                                            .addComponent(positionTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(positionIDTextPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(positionNameTextPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                            .addContainerGap(1246, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, rollPanelLayout.createSequentialGroup()
                            .addGap(0, 1733, Short.MAX_VALUE)
                            .addComponent(okButton)
                            .addGap(674, 674, 674))
                );
                rollPanelLayout.setVerticalGroup(
                    rollPanelLayout.createParallelGroup()
                        .addGroup(rollPanelLayout.createSequentialGroup()
                            .addGap(92, 92, 92)
                            .addGroup(rollPanelLayout.createParallelGroup()
                                .addComponent(playerTextPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(playerTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(110, 110, 110)
                            .addComponent(diceLabel, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(diceRollTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(71, 71, 71)
                            .addGroup(rollPanelLayout.createParallelGroup()
                                .addGroup(rollPanelLayout.createSequentialGroup()
                                    .addComponent(positionTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(positionNameTextPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addComponent(positionIDTextPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(133, 133, 133)
                            .addComponent(okButton)
                            .addContainerGap(1048, Short.MAX_VALUE))
                );
            }
            rollScrollPane.setViewportView(rollPanel);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane rollScrollPane;
    private JPanel rollPanel;
    private JTextArea playerTextArea;
    private JTextPane playerTextPane;
    private JLabel diceLabel;
    private JTextArea diceRollTextArea;
    private JTextArea positionTextArea;
    private JTextPane positionIDTextPane;
    private JTextPane positionNameTextPane;
    private JButton okButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public JScrollPane getRollScrollPane() {
        return rollScrollPane;
    }

    private void applyResolution() {
        Dimension resolution = GameFrame.screenSize;
        this.rollScrollPane.setSize(resolution);
        this.rollScrollPane.setPreferredSize(SettingsFrame.NATIVE_RES);
        this.rollPanel.setSize(resolution);
        this.rollPanel.setPreferredSize(SettingsFrame.NATIVE_RES);
        refreshGUI();
    }

    private void autoResize() {
        Dimension defaultRes = SettingsFrame.DEFAULT_RES;
        Dimension resolution = RollFrame.screenSize;
        double ratioX = (double) resolution.width / defaultRes.width;
        double ratioY = (double) resolution.height / defaultRes.height;
        this.rollScrollPane.setSize(resolution);
        this.rollScrollPane.setPreferredSize(SettingsFrame.NATIVE_RES);
        this.rollPanel.setSize(resolution);
        this.rollPanel.setPreferredSize(SettingsFrame.NATIVE_RES);
        for (Component comp : this.rollPanel.getComponents()) {
            int newSizeX = (int) Math.floor(comp.getWidth() * ratioX);
            int newSizeY = (int) Math.floor(comp.getHeight() * ratioY);
            Dimension newSize = new Dimension(newSizeX, newSizeY);
            if (comp instanceof JTextArea || comp instanceof JTextPane) {
                Font currentFont = comp.getFont();
                int newFontSize = (int) Math.floor(currentFont.getSize() * ratioX);
                Font scaledFont = new Font(currentFont.getName(), currentFont.getStyle(), newFontSize);
                comp.setFont(scaledFont);
            } else {
                comp.setSize(newSize);
                comp.setPreferredSize(newSize);
                if (comp instanceof JLabel) {
                    comp.setBounds(comp.getX(), comp.getY(), newSizeX, newSizeY);
                    if (((JLabel) comp).getIcon() != null) {
                        ImageIcon originalIcon = (ImageIcon) ((JLabel) comp).getIcon();
                        Image originalImage = originalIcon.getImage();

                        // Creating scaled version of the Icon
                        int newImageX = (int) Math.floor(originalIcon.getIconWidth() * ratioX);
                        int newImageY = (int) Math.floor(originalIcon.getIconHeight() * ratioY);
                        Image scaledImage = originalImage.getScaledInstance(newImageX, newImageY, Image.SCALE_SMOOTH);
                        ImageIcon scaledIcon = new ImageIcon(scaledImage);

                        ((JLabel) comp).setIcon(scaledIcon);
                    }
                }
            }
        }
        refreshGUI();
    }

    private void enableScrollBar() {
        this.rollScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.rollScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    }

    private void disableScrollBar() {
        this.rollScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.rollScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
    }

    private void checkResizing() {
        this.resizingChecker = new StoppableThread(() -> {
            while (true) {
                if (this.givenFrame.getWidth() != SettingsFrame.NATIVE_RES.width &&
                        this.givenFrame.getHeight() != SettingsFrame.NATIVE_RES.height)
                    enableScrollBar();
                else
                    disableScrollBar();
            }
        });
        this.resizingChecker.start();
    }

    private void initialize(Player player) {
        // Setting name of the turn
        this.playerTextPane.setText(player.getName());
    }

    private void elaboratePosition(Player player) {
        if (!player.isPrisoner()) {
            PositionManager posizioni = getInstance();

            player.rollDice();
            this.positionIDTextPane.setText(Integer.toString(player.getPosition()));
            this.positionNameTextPane.setText(posizioni.getPositions().get(player.getPosition()).getName());

            if (player.getPosition() == PRISON) {
                player.setPrisoner(true);
            } else if (player.getPosition() == TRANSIT) {
                player.setPrisoner(true);
            }
        }
        else {
            PositionManager posizioni = getInstance();
            skipMessage = true;

            this.positionIDTextPane.setText(Integer.toString(player.getPosition()));
            this.positionNameTextPane.setText(posizioni.getPositions().get(player.getPosition()).getName());
        }
    }

    private void refreshGUI() {
        this.givenFrame.revalidate();
        this.givenFrame.repaint();
        this.rollScrollPane.revalidate();
        this.rollScrollPane.repaint();
        this.rollPanel.revalidate();
        this.rollPanel.repaint();
    }

    private void bindKeyToButton() {
        this.okButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), "pressed");
        this.okButton.getActionMap().put("pressed", buttonClickAction);
    }

    public static void goMessage() {
        JOptionPane.showMessageDialog(
                messageFrame,
                "You've passed through GO! 500€ have been added to your account.",
                "GO Reached",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void handleOK(Player player, PlayerManager giocatori, ContractManager contratti) {
        if (wentDownStart) {
            goMessage();
            wentDownStart = false;
        }
        else if (player.getPosition() == PRISON && !skipMessage) {
            JOptionPane.showMessageDialog(
                    this.givenFrame,
                    "You ended up in jail!",
                    "Position: prison",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
        else if (player.getPosition() == TRANSIT) {
            JOptionPane.showMessageDialog(
                    this.givenFrame,
                    "Police has caught you. Now you are in prison!",
                    "Transit to prison",
                    JOptionPane.INFORMATION_MESSAGE
            );
            player.setPosition(PRISON);
        }
        this.resizingChecker.stop(resizingChecker);

        GameFrame gameFrame = new GameFrame(player, giocatori, contratti);
        gameFrame.setVisible(true);
        this.givenFrame.dispose();
    }
}
