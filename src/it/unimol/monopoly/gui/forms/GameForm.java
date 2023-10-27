/*
 * Created by JFormDesigner on Fri May 20 18:59:07 CEST 2022
 */

package it.unimol.monopoly.gui.forms;

import it.unimol.monopoly.app.*;
import it.unimol.monopoly.app.Box;
import it.unimol.monopoly.gui.LightsUI;
import it.unimol.monopoly.gui.frames.*;
import it.unimol.monopoly.threads.Countdown;
import it.unimol.monopoly.threads.StoppableThread;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.*;
import javax.swing.GroupLayout;

import static it.unimol.monopoly.app.PositionManager.PRISON;
import static it.unimol.monopoly.app.PositionManager.GO;

/**
 * @author unknown
 */

public class GameForm extends JPanel {
    private static int remainingTime;
    private final AtomicBoolean running = new AtomicBoolean(false);
    private JFrame givenFrame;
    private Countdown timer;
    private StoppableThread refreshProcess;
    private StoppableThread textUpdater;
    private StoppableThread turnChanger;

    public GameForm(JFrame myFrame, Player player, PlayerManager players, ContractManager contracts) {
        this.givenFrame = myFrame;
        initComponents();
        spawnPlayer(player, players, contracts);

        this.contractButton.addActionListener(
                actionEvent -> handleContractButton(player, contracts, players)
        );

        this.rentButton.addActionListener(
                actionEvent -> handleRentButton(player, players)
        );

        this.feeButton.addActionListener(
                actionEvent -> handleFeeButton(player, players)
        );

        this.goButton.addActionListener(
                actionEvent -> handleGOButton(player, players)
        );

        this.prisonButton.addActionListener(
                actionEvent -> handlePrisonButton(player, players, contracts)
        );

        this.endTurnButton.addActionListener(
                actionEvent -> handleEndTurnButton(player, players, contracts)
        );

        this.quitButton.addActionListener(
                actionEvent -> handleQuitButton(players, contracts)
        );
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        parkingLab = new JLabel();
        nyAvenueLab = new JLabel();
        tennAvenueLab = new JLabel();
        stJamesLab = new JLabel();
        pennRailroadLab = new JLabel();
        virginiaAvenueLab = new JLabel();
        statesAvenueLab = new JLabel();
        stCharlesLab = new JLabel();
        prisonLabel = new JLabel();
        connecticutAveLab = new JLabel();
        vermontAvenueLab = new JLabel();
        orientalAvenueLab = new JLabel();
        readRailroadLab = new JLabel();
        waterWorksLab = new JLabel();
        balticAvenueLab = new JLabel();
        meditAvenueLab = new JLabel();
        goLabel = new JLabel();
        kentuckyAvenueLab = new JLabel();
        indianaAvenueLab = new JLabel();
        illinoisAvenueLab = new JLabel();
        bEoRailroadLab = new JLabel();
        atlanticAvenueLab = new JLabel();
        ventnorAvenueLab = new JLabel();
        marvinGardensLab = new JLabel();
        transitLabel = new JLabel();
        pacificAvenueLab = new JLabel();
        northCarAvenueLab = new JLabel();
        pennAvenueLab = new JLabel();
        shortLineLab = new JLabel();
        electricCompanyLab = new JLabel();
        parkPlaceLab = new JLabel();
        boardwalkLab = new JLabel();
        turnTextArea = new JTextArea();
        turnTextPane = new JTextPane();
        bankTextPane = new JTextPane();
        contractsTextArea = new JTextArea();
        contractButton = new JButton();
        rentButton = new JButton();
        feeButton = new JButton();
        goButton = new JButton();
        prisonButton = new JButton();
        endTurnButton = new JButton();
        quitButton = new JButton();
        pawnLabel = new JLabel();
        contractsScrollPane = new JScrollPane();
        contractsTextPane = new JTextPane();
        timerTextPane = new JTextPane();
        timerTextArea = new JTextArea();

        //======== this ========
        setBackground(new Color(0xfefffe));

        //---- parkingLab ----
        parkingLab.setIcon(new ImageIcon(getClass().getResource("/Parking.jpg")));

        //---- nyAvenueLab ----
        nyAvenueLab.setIcon(new ImageIcon(getClass().getResource("/NewYorkAvenue.jpg")));

        //---- tennAvenueLab ----
        tennAvenueLab.setIcon(new ImageIcon(getClass().getResource("/TennesseeAvenue.jpg")));

        //---- stJamesLab ----
        stJamesLab.setIcon(new ImageIcon(getClass().getResource("/StJamesPlace.jpg")));

        //---- pennRailroadLab ----
        pennRailroadLab.setIcon(new ImageIcon(getClass().getResource("/PennsylvaniaRailroad.jpg")));

        //---- virginiaAvenueLab ----
        virginiaAvenueLab.setIcon(new ImageIcon(getClass().getResource("/VirginiaAvenue.jpg")));

        //---- statesAvenueLab ----
        statesAvenueLab.setIcon(new ImageIcon(getClass().getResource("/StatesAvenue.jpg")));

        //---- stCharlesLab ----
        stCharlesLab.setIcon(new ImageIcon(getClass().getResource("/StCharlesPlace.jpg")));

        //---- prisonLabel ----
        prisonLabel.setIcon(new ImageIcon(getClass().getResource("/Prison.jpg")));

        //---- connecticutAveLab ----
        connecticutAveLab.setIcon(new ImageIcon(getClass().getResource("/ConnecticutAvenue.jpg")));

        //---- vermontAvenueLab ----
        vermontAvenueLab.setIcon(new ImageIcon(getClass().getResource("/VermontAvenue.jpg")));

        //---- orientalAvenueLab ----
        orientalAvenueLab.setIcon(new ImageIcon(getClass().getResource("/OrientalAvenue.jpg")));

        //---- readRailroadLab ----
        readRailroadLab.setIcon(new ImageIcon(getClass().getResource("/ReadingRailroad.jpg")));

        //---- waterWorksLab ----
        waterWorksLab.setIcon(new ImageIcon(getClass().getResource("/WaterWorks.jpg")));

        //---- balticAvenueLab ----
        balticAvenueLab.setIcon(new ImageIcon(getClass().getResource("/BalticAvenue.jpg")));

        //---- meditAvenueLab ----
        meditAvenueLab.setIcon(new ImageIcon(getClass().getResource("/MediterraneanAvenue.jpg")));

        //---- goLabel ----
        goLabel.setIcon(new ImageIcon(getClass().getResource("/GOv2.jpg")));

        //---- kentuckyAvenueLab ----
        kentuckyAvenueLab.setIcon(new ImageIcon(getClass().getResource("/KentuckyAvenue.jpg")));

        //---- indianaAvenueLab ----
        indianaAvenueLab.setIcon(new ImageIcon(getClass().getResource("/IndianaAvenue.jpg")));

        //---- illinoisAvenueLab ----
        illinoisAvenueLab.setIcon(new ImageIcon(getClass().getResource("/IllinoisAvenue.jpg")));

        //---- bEoRailroadLab ----
        bEoRailroadLab.setIcon(new ImageIcon(getClass().getResource("/B&ORailroad.jpg")));

        //---- atlanticAvenueLab ----
        atlanticAvenueLab.setIcon(new ImageIcon(getClass().getResource("/AtlanticAvenue.jpg")));

        //---- ventnorAvenueLab ----
        ventnorAvenueLab.setIcon(new ImageIcon(getClass().getResource("/VentnorAvenue.jpg")));

        //---- marvinGardensLab ----
        marvinGardensLab.setIcon(new ImageIcon(getClass().getResource("/MarvinGardens.jpg")));

        //---- transitLabel ----
        transitLabel.setIcon(new ImageIcon(getClass().getResource("/Transit.jpg")));

        //---- pacificAvenueLab ----
        pacificAvenueLab.setIcon(new ImageIcon(getClass().getResource("/PacificAvenue.jpg")));

        //---- northCarAvenueLab ----
        northCarAvenueLab.setIcon(new ImageIcon(getClass().getResource("/NorthCarolinaAvenue.jpg")));

        //---- pennAvenueLab ----
        pennAvenueLab.setIcon(new ImageIcon(getClass().getResource("/PennsylvaniaAvenue.jpg")));

        //---- shortLineLab ----
        shortLineLab.setIcon(new ImageIcon(getClass().getResource("/ShortLine.jpg")));

        //---- electricCompanyLab ----
        electricCompanyLab.setIcon(new ImageIcon(getClass().getResource("/ElectricCompany.jpg")));

        //---- parkPlaceLab ----
        parkPlaceLab.setIcon(new ImageIcon(getClass().getResource("/ParkPlace.jpg")));

        //---- boardwalkLab ----
        boardwalkLab.setIcon(new ImageIcon(getClass().getResource("/BoardWalk.jpg")));

        //---- turnTextArea ----
        turnTextArea.setText("Turn of:");
        turnTextArea.setBackground(new Color(0xfefffe));
        turnTextArea.setFont(new Font("Noto Sans", Font.BOLD, 40));
        turnTextArea.setForeground(new Color(0x7a8c93));
        turnTextArea.setEditable(false);

        //---- turnTextPane ----
        turnTextPane.setFont(new Font("Noto Sans", Font.BOLD, 40));
        turnTextPane.setBackground(new Color(0xfefffe));
        turnTextPane.setForeground(new Color(0x7a8c93));
        turnTextPane.setEditable(false);

        //---- bankTextPane ----
        bankTextPane.setFont(new Font("Noto Sans", Font.BOLD, 34));
        bankTextPane.setBackground(new Color(0xfefffe));
        bankTextPane.setForeground(new Color(0x7a8c93));
        bankTextPane.setEditable(false);

        //---- contractsTextArea ----
        contractsTextArea.setFont(new Font("Noto Sans", Font.BOLD, 36));
        contractsTextArea.setText("Contracts:");
        contractsTextArea.setBackground(new Color(0xfefffe));
        contractsTextArea.setForeground(new Color(0x7a8c93));
        contractsTextArea.setEditable(false);

        //---- contractButton ----
        contractButton.setText("Buy contract");
        contractButton.setBackground(new Color(0xced9dc));
        contractButton.setIcon(null);

        //---- rentButton ----
        rentButton.setText("Pay rent");
        rentButton.setBackground(new Color(0xced9dc));

        //---- feeButton ----
        feeButton.setText("Pay fee");
        feeButton.setBackground(new Color(0xced9dc));

        //---- goButton ----
        goButton.setText("Pass by GO!");
        goButton.setBackground(new Color(0xced9dc));

        //---- prisonButton ----
        prisonButton.setText("Go to prison");
        prisonButton.setBackground(new Color(0xced9dc));

        //---- endTurnButton ----
        endTurnButton.setText("End turn");
        endTurnButton.setBackground(new Color(0xced9dc));

        //---- quitButton ----
        quitButton.setText("Quit");
        quitButton.setBackground(new Color(0xced9dc));

        //---- pawnLabel ----
        pawnLabel.setIcon(null);

        //======== contractsScrollPane ========
        {

            //---- contractsTextPane ----
            contractsTextPane.setFont(new Font("Noto Sans", Font.BOLD, 20));
            contractsTextPane.setEditable(false);
            contractsScrollPane.setViewportView(contractsTextPane);
        }

        //---- timerTextPane ----
        timerTextPane.setBackground(new Color(0xfefffe));
        timerTextPane.setForeground(Color.black);
        timerTextPane.setFont(new Font("Noto Sans", Font.BOLD, 40));
        timerTextPane.setEditable(false);

        //---- timerTextArea ----
        timerTextArea.setBackground(new Color(0xfefffe));
        timerTextArea.setForeground(new Color(0xcc3300));
        timerTextArea.setFont(new Font("Noto Sans", Font.BOLD, 40));
        timerTextArea.setText("End of turn:");
        timerTextArea.setEditable(false);

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(62, 62, 62)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(parkingLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(kentuckyAvenueLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(indianaAvenueLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(illinoisAvenueLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bEoRailroadLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(atlanticAvenueLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ventnorAvenueLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(marvinGardensLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                        .addComponent(nyAvenueLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                        .addComponent(tennAvenueLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                        .addComponent(stJamesLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                        .addComponent(pennRailroadLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                        .addComponent(virginiaAvenueLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                        .addComponent(statesAvenueLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                        .addComponent(stCharlesLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(prisonLabel, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(connecticutAveLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(vermontAvenueLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(orientalAvenueLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(readRailroadLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(waterWorksLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(balticAvenueLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(meditAvenueLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(pacificAvenueLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                        .addComponent(transitLabel, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                        .addComponent(northCarAvenueLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                        .addComponent(pennAvenueLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                        .addComponent(shortLineLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                        .addComponent(electricCompanyLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                        .addComponent(parkPlaceLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                        .addComponent(boardwalkLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                        .addComponent(goLabel, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 792, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(contractsTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(contractButton, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                                .addComponent(feeButton, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                                .addComponent(prisonButton, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                                .addComponent(quitButton, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(rentButton, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                                .addComponent(goButton, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                                .addComponent(endTurnButton, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)))
                        .addComponent(contractsScrollPane, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(turnTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(turnTextPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(bankTextPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(pawnLabel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(timerTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(timerTextPane, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE))))
                    .addGap(201, 201, 201))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(parkingLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                .addComponent(kentuckyAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                .addComponent(indianaAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                .addComponent(illinoisAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                .addComponent(bEoRailroadLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                .addComponent(atlanticAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                .addComponent(ventnorAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                .addComponent(marvinGardensLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                .addComponent(transitLabel, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(pacificAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                .addComponent(nyAvenueLab, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(turnTextPane)
                                .addComponent(turnTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(bankTextPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(timerTextArea))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(pawnLabel, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                                .addComponent(timerTextPane))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(contractsTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(contractsScrollPane, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(northCarAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                .addComponent(tennAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(pennAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                .addComponent(stJamesLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(shortLineLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                .addComponent(pennRailroadLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(electricCompanyLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                .addComponent(virginiaAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(parkPlaceLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                .addComponent(statesAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(boardwalkLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                .addComponent(stCharlesLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(goLabel, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                .addComponent(prisonLabel, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                .addComponent(meditAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                .addComponent(balticAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                .addComponent(waterWorksLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                .addComponent(readRailroadLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                .addComponent(orientalAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                .addComponent(vermontAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                .addComponent(connecticutAveLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(contractButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addComponent(rentButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(feeButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addComponent(goButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(prisonButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addComponent(endTurnButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(quitButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
                    .addGap(530, 530, 530))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JLabel parkingLab;
    public JLabel nyAvenueLab;
    public JLabel tennAvenueLab;
    public JLabel stJamesLab;
    public JLabel pennRailroadLab;
    public JLabel virginiaAvenueLab;
    public JLabel statesAvenueLab;
    public JLabel stCharlesLab;
    public JLabel prisonLabel;
    public JLabel connecticutAveLab;
    public JLabel vermontAvenueLab;
    public JLabel orientalAvenueLab;
    public JLabel readRailroadLab;
    public JLabel waterWorksLab;
    public JLabel balticAvenueLab;
    public JLabel meditAvenueLab;
    public JLabel goLabel;
    public JLabel kentuckyAvenueLab;
    public JLabel indianaAvenueLab;
    public JLabel illinoisAvenueLab;
    public JLabel bEoRailroadLab;
    public JLabel atlanticAvenueLab;
    public JLabel ventnorAvenueLab;
    public JLabel marvinGardensLab;
    public JLabel transitLabel;
    public JLabel pacificAvenueLab;
    public JLabel northCarAvenueLab;
    public JLabel pennAvenueLab;
    public JLabel shortLineLab;
    public JLabel electricCompanyLab;
    public JLabel parkPlaceLab;
    public JLabel boardwalkLab;
    private JTextArea turnTextArea;
    private JTextPane turnTextPane;
    private JTextPane bankTextPane;
    private JTextArea contractsTextArea;
    private JButton contractButton;
    private JButton rentButton;
    private JButton feeButton;
    private JButton goButton;
    private JButton prisonButton;
    private JButton endTurnButton;
    private JButton quitButton;
    private JLabel pawnLabel;
    private JScrollPane contractsScrollPane;
    private JTextPane contractsTextPane;
    private JTextPane timerTextPane;
    private JTextArea timerTextArea;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private void spawnPlayer(Player player, PlayerManager players, ContractManager contracts) {
        PositionManager positions = PositionManager.getInstance();

        // Icon generation
        ImageIcon pawnShape = player.getPawn().getShape();
        assert pawnShape != null;
        this.pawnLabel.setIcon(pawnShape);

        // Setting turn text
        this.turnTextPane.setText(player.getName());

        // Money visualization
        this.bankTextPane.setText(player.getMoney() + "€");

        // Contracts visualization
        Contract.i = 1;
        this.contractsTextPane.setText(player.cPtoString());

        // Timer visualization
        this.timerTextPane.setText(Integer.toString(180));
        updateTimer(player, players, contracts);

        // Box illumination
        this.setBoxLight(player);
    }

    private void setBoxLight(Player player) {
        PositionManager posizioni = PositionManager.getInstance();
        Box currentBox = posizioni.getPositions().get(player.getPosition());
        String positionName = currentBox.getName();

        LightsUI lights = LightsUI.getInstance();
        lights.setPositionLight(this, positionName);
    }

    private void handleContractButton(Player player, ContractManager contracts, PlayerManager players) {
        ContractFrame contractFrame = new ContractFrame(this, player, contracts, players);
        contractFrame.setVisible(true);
    }

    private void updateBank(Player player) {
        this.bankTextPane.setText(player.getMoney() + "€");
    }

    private void updateContracts(Player player) {
        Contract.i = 1;
        this.contractsTextPane.setText(player.cPtoString());
    }

    private void updateLight(Player player) {
        this.setBoxLight(player);
    }

    private void updateTimer(Player player, PlayerManager players, ContractManager contracts) {
        remainingTime = Integer.parseInt(this.timerTextPane.getText());
        this.timer = new Countdown();
        timer.start(timer);

        this.textUpdater = new StoppableThread(new Runnable() {
            @Override
            public void run() {
                while (timer.isRunning()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ignored) {}
                    remainingTime--;
                    timerTextPane.setText(Integer.toString(remainingTime));
                }
            }
        });
        textUpdater.start(textUpdater);

        handleNoTimeLeft(timer, player, players, contracts);
    }

    private void deleteLastLight(Player player) {
        PositionManager posizioni = PositionManager.getInstance();
        LightsUI lights = LightsUI.getInstance();
        Box currentBox = posizioni.getPositions().get(player.getPosition());
        String positionName = currentBox.getName();
        lights.removeLight(this, positionName);
    }

    public void refresh(Player player, PlayerManager players) {
        this.refreshProcess = new StoppableThread(new Runnable() {
            @Override
            public void run() {
                updateBank(player);
                updateContracts(player);
                updateLight(player);
                checkGameOver(players);
                refreshProcess.stop(refreshProcess);
            }
        });

        refreshProcess.start(refreshProcess);
    }

    private void handleRentButton(Player player, PlayerManager players) {
        RentFrame rentFrame = new RentFrame(this, player, players);
        rentFrame.setVisible(true);
    }

    private void handleFeeButton(Player player, PlayerManager players) {
        FeeFrame feeFrame = new FeeFrame(this, player, players);
        feeFrame.setVisible(true);
    }

    private void handleGOButton(Player player, PlayerManager players) {
        deleteLastLight(player);

        player.addMoney(500);
        player.setPosition(GO);
        JOptionPane.showMessageDialog(
                this,
                "You've passed by GO! 500€ have been added to your account.",
                "Passage by GO",
                JOptionPane.INFORMATION_MESSAGE
        );

        refresh(player, players);
    }

    private void handlePrisonButton(Player player, PlayerManager players, ContractManager contracts) {
        deleteLastLight(player);

        // Closing threads
        this.timer.stop(timer);
        this.textUpdater.stop(textUpdater);
        this.turnChanger.stop(turnChanger);

        player.setPrisoner(true);
        player.setPosition(PRISON);
        PrisonForm prisonForm = new PrisonForm(this.givenFrame, player, players, contracts);
        this.givenFrame.setContentPane(prisonForm);
    }

    private void handleEndTurnButton(Player player, PlayerManager players, ContractManager contracts) {
        Turn turn = Turn.getInstance();
        turn.endTurn(player);
        Player newPlayer = players.changePlayer(Turn.playerId);

        JOptionPane.showMessageDialog(
                this.givenFrame,
                "You've decided to end your turn.",
                "Changing turn",
                JOptionPane.INFORMATION_MESSAGE
        );

        // Closing threads
        this.timer.stop(timer);
        this.textUpdater.stop(textUpdater);
        this.turnChanger.stop(turnChanger);

        if (!newPlayer.isPrisoner()) {
            RollFrame rollFrame = new RollFrame(newPlayer, players, contracts);
            this.givenFrame.dispose();
            rollFrame.setVisible(true);
        }
        else {
            PrisonForm newForm = new PrisonForm(this.givenFrame, newPlayer, players, contracts);
            this.givenFrame.setContentPane(newForm);
        }
    }

    private void handleQuitButton(PlayerManager players, ContractManager contracts) {
        Turn turn = Turn.getInstance();
        String[] options = {"YES", "NO"};
        int onClose = JOptionPane.showOptionDialog
                (
                        this.givenFrame,
                        "Do you want to save the match?",
                        "Quit options",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]
                );
        if (onClose == 0) {
            try {
                contracts.saveContracts();
                players.savePlayers();
                turn.saveTurn();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                 JOptionPane.showMessageDialog(
                         this.givenFrame,
                         "The match has been saved. Closing...",
                         "Quit by saving",
                         JOptionPane.INFORMATION_MESSAGE
                 );

                 this.givenFrame.dispose();
            }
            System.exit(0);
        }
        else {
            JOptionPane.showMessageDialog(
                    this.givenFrame,
                    "You've decided not to save. Closing...",
                    "Quit without saving",
                    JOptionPane.INFORMATION_MESSAGE
            );
            File contractData = new File("contracts.sr");
            File playerData = new File("players.sr");
            File turnoData = new File("turn.sr");
            contractData.delete();
            playerData.delete();
            turnoData.delete();

            this.givenFrame.dispose();
        }
        System.exit(0);
    }

    private void handleNoTimeLeft(Countdown timer, Player player, PlayerManager players, ContractManager contracts) {
        this.turnChanger = new StoppableThread(new Runnable() {
            @Override
            public void run() {
                while (timer.isRunning()) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ignored) {}
                }
                if (timer.isJobCompleted()) {
                    JOptionPane.showMessageDialog(
                            givenFrame,
                            "You have run out of time.",
                            "INFO: Turn time exceeded",
                            JOptionPane.ERROR_MESSAGE
                    );
                    elapsedTurnChange(player, players, contracts);
                }
            }
        });
        turnChanger.start(turnChanger);
    }

    private void elapsedTurnChange(Player player, PlayerManager players, ContractManager contracts) {

        // Changing player
        Turn turn = Turn.getInstance();
        turn.endTurn(player);
        Player newPlayer = players.changePlayer(Turn.playerId);

        // Closing threads
        this.timer.stop(timer);
        this.textUpdater.stop(textUpdater);
        this.turnChanger.stop(turnChanger);

        // Changing window
        if (!newPlayer.isPrisoner()) {
            RollFrame rollFrame = new RollFrame(newPlayer, players, contracts);
            this.givenFrame.dispose();
            rollFrame.setVisible(true);
        }
        else {
            PrisonForm newForm = new PrisonForm(this.givenFrame, newPlayer, players, contracts);
            this.givenFrame.setContentPane(newForm);
        }
    }

    public void checkGameOver(PlayerManager players) {
        Player winner = null;
        int limit = players.getPlayers().size() - 1;
        int counter = 0;

        for (Player x : players.getPlayers().values()) {
            if (x.isPoor())
                counter++;
            else
                winner = x;
        }

        if (counter >= limit) {
            JOptionPane.showMessageDialog(
                    this.givenFrame,
                    "All players except one have 0€.",
                    "GAME OVER!",
                    JOptionPane.INFORMATION_MESSAGE
            );

            // Closing threads
            this.timer.stop(timer);
            this.textUpdater.stop(textUpdater);
            this.turnChanger.stop(turnChanger);

            assert winner != null;
            EndFrame endFrame = new EndFrame(winner);
            this.givenFrame.dispose();
            endFrame.setVisible(true);
        }
    }
}