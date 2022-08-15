/*
 * Created by JFormDesigner on Sat May 21 17:45:10 CEST 2022
 */

package it.unimol.monopoly.gui.forms;

import it.unimol.monopoly.app.*;
import it.unimol.monopoly.gui.frames.GameFrame;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

import static it.unimol.monopoly.app.PositionManager.*;

/**
 * @author unknown
 */
public class RollForm extends JPanel {
    private JFrame givenFrame;
    private static JFrame messageFrame;
    private static boolean skipMessage;
    public static boolean wentDownStart;
    public RollForm(JFrame myFrame, Player player, PlayerManager players, ContractManager contracts) {
        initComponents();
        this.givenFrame = myFrame;
        messageFrame = this.givenFrame;
        initialize(player);
        elaboratePosition(player);

        this.okButton.addActionListener(
                actionEvent -> handleOK(player, players, contracts)
        );
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Angelo Trotta
        playerTextArea = new JTextArea();
        playerTextPane = new JTextPane();
        diceLabel = new JLabel();
        diceRollTextArea = new JTextArea();
        positionTextArea = new JTextArea();
        positionIDTextPane = new JTextPane();
        positionNameTextPane = new JTextPane();
        okButton = new JButton();

        //======== this ========
        setBackground(new Color(254, 255, 254));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing.
        border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax. swing. border. TitledBorder. CENTER
        , javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dialo\u0067" ,java .awt .Font
        .BOLD ,12 ), java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (
        new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("borde\u0072"
        .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

        //---- playerTextArea ----
        playerTextArea.setFont(new Font("Noto Sans", Font.BOLD, 40));
        playerTextArea.setText("Turn of:");
        playerTextArea.setBackground(new Color(254, 255, 254));
        playerTextArea.setForeground(new Color(122, 140, 147));
        playerTextArea.setEditable(false);

        //---- playerTextPane ----
        playerTextPane.setFont(new Font("Noto Sans", Font.BOLD, 40));
        playerTextPane.setBackground(new Color(254, 255, 254));
        playerTextPane.setForeground(new Color(122, 140, 147));
        playerTextPane.setEditable(false);

        //---- diceLabel ----
        diceLabel.setIcon(new ImageIcon(getClass().getResource("/it/unimol/monopoly/pawns/Dice.png")));

        //---- diceRollTextArea ----
        diceRollTextArea.setText("Rolling the dice...");
        diceRollTextArea.setFont(new Font("Noto Sans", Font.BOLD, 40));
        diceRollTextArea.setBackground(new Color(254, 255, 254));
        diceRollTextArea.setForeground(new Color(122, 140, 147));
        diceRollTextArea.setEditable(false);

        //---- positionTextArea ----
        positionTextArea.setFont(new Font("Noto Sans", Font.BOLD, 40));
        positionTextArea.setText("Your position is:");
        positionTextArea.setBackground(new Color(254, 255, 254));
        positionTextArea.setForeground(new Color(122, 140, 147));
        positionTextArea.setEditable(false);

        //---- positionIDTextPane ----
        positionIDTextPane.setFont(new Font("Noto Sans", Font.BOLD, 40));
        positionIDTextPane.setBackground(new Color(254, 255, 254));
        positionIDTextPane.setForeground(new Color(122, 140, 147));

        //---- positionNameTextPane ----
        positionNameTextPane.setBackground(new Color(254, 255, 254));
        positionNameTextPane.setForeground(Color.black);
        positionNameTextPane.setFont(new Font("Noto Sans", Font.BOLD, 30));
        positionNameTextPane.setEditable(false);

        //---- okButton ----
        okButton.setText("OK");
        okButton.setBackground(new Color(206, 217, 220));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(139, 139, 139)
                    .addComponent(playerTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(playerTextPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1613, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(753, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(diceRollTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(diceLabel, GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(positionTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(positionIDTextPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addComponent(positionNameTextPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(687, 687, 687))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(okButton)
                            .addGap(78, 78, 78))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(92, 92, 92)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(playerTextPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(playerTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(106, 106, 106)
                    .addComponent(diceLabel, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
                    .addGap(33, 33, 33)
                    .addComponent(diceRollTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(71, 71, 71)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(positionTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(positionIDTextPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(positionNameTextPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                    .addComponent(okButton)
                    .addGap(90, 90, 90))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Angelo Trotta
    private JTextArea playerTextArea;
    private JTextPane playerTextPane;
    private JLabel diceLabel;
    private JTextArea diceRollTextArea;
    private JTextArea positionTextArea;
    private JTextPane positionIDTextPane;
    private JTextPane positionNameTextPane;
    private JButton okButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

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
                    "You went to prison!",
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

        GameFrame gameFrame = new GameFrame(player, giocatori, contratti);
        gameFrame.setVisible(true);
        this.givenFrame.dispose();
    }
}
