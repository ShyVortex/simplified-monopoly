/*
 * Created by JFormDesigner on Fri May 20 18:59:07 CEST 2022
 */

package it.unimol.monopoly.gui.forms;

import it.unimol.monopoly.app.*;
import it.unimol.monopoly.app.Box;
import it.unimol.monopoly.exceptions.MultipleInstancesException;
import it.unimol.monopoly.gui.LightsUI;
import it.unimol.monopoly.gui.frames.*;
import it.unimol.monopoly.gui.frames.properties.FrameProperties;
import it.unimol.monopoly.threads.Countdown;
import it.unimol.monopoly.threads.StoppableThread;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import javax.swing.*;
import javax.swing.GroupLayout;

import static it.unimol.monopoly.app.PositionManager.PRISON;
import static it.unimol.monopoly.app.PositionManager.GO;

/**
 * @author unknown
 */

public class GameForm {
    private static int remainingTime;
    private JFrame givenFrame;
    private Countdown timer;
    private StoppableThread refreshProcess;
    private StoppableThread textUpdater;
    private StoppableThread turnChanger;
    private StoppableThread resizingChecker;
    private Action exitAction;

    public GameForm(JFrame myFrame, Player player, PlayerManager players, ContractManager contracts) {
        initComponents();
        this.givenFrame = myFrame;
        if (FrameProperties.getScalingFactor() == 2)
            autoResize();
        else
            applyResolution();
        this.givenFrame.add(this.gameScrollPane);
        spawnPlayer(player, players, contracts);
        if (FrameProperties.getResizable())
            checkResizing();

        // Allows to quit the game by using a custom shortcut instead of a mouse click
        exitAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleQuitButton(players, contracts);
            }
        };
        bindKeyToQuit();

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
        // Generated using JFormDesigner Evaluation license - Angelo Trotta
        gameScrollPane = new JScrollPane();
        gamePanel = new JPanel();
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

        //======== gameScrollPane ========
        {

            //======== gamePanel ========
            {
                gamePanel.setBackground(new Color(0xfefffe));
                gamePanel.setMinimumSize(new Dimension(640, 360));
                gamePanel.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax
                . swing. border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing
                . border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .
                Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red
                ) ,gamePanel. getBorder( )) ); gamePanel. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override
                public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName (
                ) )) throw new RuntimeException( ); }} );

                //---- parkingLab ----
                parkingLab.setIcon(new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/boxes/Parking.jpg"))));
                parkingLab.setFocusable(false);

                //---- nyAvenueLab ----
                nyAvenueLab.setIcon(new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/boxes/NewYorkAvenue.jpg"))));
                nyAvenueLab.setFocusable(false);

                //---- tennAvenueLab ----
                tennAvenueLab.setIcon(new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/boxes/TennesseeAvenue.jpg"))));
                tennAvenueLab.setFocusable(false);

                //---- stJamesLab ----
                stJamesLab.setIcon(new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/boxes/StJamesPlace.jpg"))));
                stJamesLab.setFocusable(false);

                //---- pennRailroadLab ----
                pennRailroadLab.setIcon(new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/boxes/PennsylvaniaRailroad.jpg"))));
                pennRailroadLab.setFocusable(false);

                //---- virginiaAvenueLab ----
                virginiaAvenueLab.setIcon(new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/boxes/VirginiaAvenue.jpg"))));
                virginiaAvenueLab.setFocusable(false);

                //---- statesAvenueLab ----
                statesAvenueLab.setIcon(new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/boxes/StatesAvenue.jpg"))));
                statesAvenueLab.setFocusable(false);

                //---- stCharlesLab ----
                stCharlesLab.setIcon(new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/boxes/StCharlesPlace.jpg"))));
                stCharlesLab.setFocusable(false);

                //---- prisonLabel ----
                prisonLabel.setIcon(new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/boxes/Prison.jpg"))));
                prisonLabel.setFocusable(false);

                //---- connecticutAveLab ----
                connecticutAveLab.setIcon(new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/boxes/ConnecticutAvenue.jpg"))));
                connecticutAveLab.setFocusable(false);

                //---- vermontAvenueLab ----
                vermontAvenueLab.setIcon(new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/boxes/VermontAvenue.jpg"))));
                vermontAvenueLab.setFocusable(false);

                //---- orientalAvenueLab ----
                orientalAvenueLab.setIcon(new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/boxes/OrientalAvenue.jpg"))));
                orientalAvenueLab.setFocusable(false);

                //---- readRailroadLab ----
                readRailroadLab.setIcon(new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/boxes/ReadingRailroad.jpg"))));
                readRailroadLab.setFocusable(false);

                //---- waterWorksLab ----
                waterWorksLab.setIcon(new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/boxes/WaterWorks.jpg"))));
                waterWorksLab.setFocusable(false);

                //---- balticAvenueLab ----
                balticAvenueLab.setIcon(new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/boxes/BalticAvenue.jpg"))));
                balticAvenueLab.setFocusable(false);

                //---- meditAvenueLab ----
                meditAvenueLab.setIcon(new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/boxes/MediterraneanAvenue.jpg"))));
                meditAvenueLab.setFocusable(false);

                //---- goLabel ----
                goLabel.setIcon(new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/boxes/GOv2.jpg"))));
                goLabel.setFocusable(false);

                //---- kentuckyAvenueLab ----
                kentuckyAvenueLab.setIcon(new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/boxes/KentuckyAvenue.jpg"))));
                kentuckyAvenueLab.setFocusable(false);

                //---- indianaAvenueLab ----
                indianaAvenueLab.setIcon(new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/boxes/IndianaAvenue.jpg"))));
                indianaAvenueLab.setFocusable(false);

                //---- illinoisAvenueLab ----
                illinoisAvenueLab.setIcon(new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/boxes/IllinoisAvenue.jpg"))));
                illinoisAvenueLab.setFocusable(false);

                //---- bEoRailroadLab ----
                bEoRailroadLab.setIcon(new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/boxes/B&ORailroad.jpg"))));
                bEoRailroadLab.setFocusable(false);

                //---- atlanticAvenueLab ----
                atlanticAvenueLab.setIcon(new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/boxes/AtlanticAvenue.jpg"))));
                atlanticAvenueLab.setFocusable(false);

                //---- ventnorAvenueLab ----
                ventnorAvenueLab.setIcon(new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/boxes/VentnorAvenue.jpg"))));
                ventnorAvenueLab.setFocusable(false);

                //---- marvinGardensLab ----
                marvinGardensLab.setIcon(new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/boxes/MarvinGardens.jpg"))));
                marvinGardensLab.setFocusable(false);

                //---- transitLabel ----
                transitLabel.setIcon(new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/boxes/Transit.jpg"))));
                transitLabel.setFocusable(false);

                //---- pacificAvenueLab ----
                pacificAvenueLab.setIcon(new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/boxes/PacificAvenue.jpg"))));
                pacificAvenueLab.setFocusable(false);

                //---- northCarAvenueLab ----
                northCarAvenueLab.setIcon(new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/boxes/NorthCarolinaAvenue.jpg"))));
                northCarAvenueLab.setFocusable(false);

                //---- pennAvenueLab ----
                pennAvenueLab.setIcon(new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/boxes/PennsylvaniaAvenue.jpg"))));
                pennAvenueLab.setFocusable(false);

                //---- shortLineLab ----
                shortLineLab.setIcon(new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/boxes/ShortLine.jpg"))));
                shortLineLab.setFocusable(false);

                //---- electricCompanyLab ----
                electricCompanyLab.setIcon(new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/boxes/ElectricCompany.jpg"))));
                electricCompanyLab.setFocusable(false);

                //---- parkPlaceLab ----
                parkPlaceLab.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/boxes/ParkPlace.jpg"))));
                parkPlaceLab.setFocusable(false);

                //---- boardwalkLab ----
                boardwalkLab.setIcon(new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/boxes/BoardWalk.jpg"))));
                boardwalkLab.setFocusable(false);

                //---- turnTextArea ----
                turnTextArea.setText("Turn of:");
                turnTextArea.setBackground(new Color(0xfefffe));
                turnTextArea.setFont(new Font("Noto Sans", Font.BOLD, 40));
                turnTextArea.setForeground(new Color(0x7a8c93));
                turnTextArea.setEditable(false);
                turnTextArea.setFocusable(false);

                //---- turnTextPane ----
                turnTextPane.setFont(new Font("Noto Sans", Font.BOLD, 40));
                turnTextPane.setBackground(new Color(0xfefffe));
                turnTextPane.setForeground(new Color(0x7a8c93));
                turnTextPane.setEditable(false);
                turnTextPane.setFocusable(false);

                //---- bankTextPane ----
                bankTextPane.setFont(new Font("Noto Sans", Font.BOLD, 34));
                bankTextPane.setBackground(new Color(0xfefffe));
                bankTextPane.setForeground(new Color(0x7a8c93));
                bankTextPane.setEditable(false);
                bankTextPane.setFocusable(false);

                //---- contractsTextArea ----
                contractsTextArea.setFont(new Font("Noto Sans", Font.BOLD, 36));
                contractsTextArea.setText("Contracts:");
                contractsTextArea.setBackground(new Color(0xfefffe));
                contractsTextArea.setForeground(new Color(0x7a8c93));
                contractsTextArea.setEditable(false);
                contractsTextArea.setFocusable(false);

                //---- contractButton ----
                contractButton.setText("Buy contract");
                contractButton.setBackground(new Color(0xced9dc));
                contractButton.setIcon(null);
                contractButton.setFocusable(false);

                //---- rentButton ----
                rentButton.setText("Pay rent");
                rentButton.setBackground(new Color(0xced9dc));
                rentButton.setFocusable(false);

                //---- feeButton ----
                feeButton.setText("Pay fee");
                feeButton.setBackground(new Color(0xced9dc));
                feeButton.setFocusable(false);

                //---- goButton ----
                goButton.setText("Pass by GO!");
                goButton.setBackground(new Color(0xced9dc));
                goButton.setFocusable(false);

                //---- prisonButton ----
                prisonButton.setText("Go to prison");
                prisonButton.setBackground(new Color(0xced9dc));
                prisonButton.setFocusable(false);

                //---- endTurnButton ----
                endTurnButton.setText("End turn");
                endTurnButton.setBackground(new Color(0xced9dc));
                endTurnButton.setFocusable(false);

                //---- quitButton ----
                quitButton.setText("Quit");
                quitButton.setBackground(new Color(0xced9dc));
                quitButton.setFocusable(false);

                //---- pawnLabel ----
                pawnLabel.setIcon(null);

                //======== contractsScrollPane ========
                {
                    contractsScrollPane.setFocusable(false);

                    //---- contractsTextPane ----
                    contractsTextPane.setFont(new Font("Noto Sans", Font.BOLD, 20));
                    contractsTextPane.setEditable(false);
                    contractsTextPane.setFocusable(false);
                    contractsScrollPane.setViewportView(contractsTextPane);
                }

                //---- timerTextPane ----
                timerTextPane.setBackground(new Color(0xfefffe));
                timerTextPane.setForeground(Color.black);
                timerTextPane.setFont(new Font("Noto Sans", Font.BOLD, 40));
                timerTextPane.setEditable(false);
                timerTextPane.setFocusable(false);

                //---- timerTextArea ----
                timerTextArea.setBackground(new Color(0xfefffe));
                timerTextArea.setForeground(new Color(0xcc3300));
                timerTextArea.setFont(new Font("Noto Sans", Font.BOLD, 40));
                timerTextArea.setText("End of turn:");
                timerTextArea.setEditable(false);
                timerTextArea.setFocusable(false);

                GroupLayout gamePanelLayout = new GroupLayout(gamePanel);
                gamePanel.setLayout(gamePanelLayout);
                gamePanelLayout.setHorizontalGroup(
                    gamePanelLayout.createParallelGroup()
                        .addGroup(gamePanelLayout.createSequentialGroup()
                            .addGap(62, 62, 62)
                            .addGroup(gamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(gamePanelLayout.createSequentialGroup()
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
                                .addGroup(gamePanelLayout.createSequentialGroup()
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
                            .addGroup(gamePanelLayout.createParallelGroup()
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
                            .addGroup(gamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(contractsTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(gamePanelLayout.createSequentialGroup()
                                    .addGroup(gamePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(contractButton, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(feeButton, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(prisonButton, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(quitButton, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(gamePanelLayout.createParallelGroup()
                                        .addComponent(rentButton, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(goButton, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(endTurnButton, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)))
                                .addComponent(contractsScrollPane, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
                                .addGroup(gamePanelLayout.createSequentialGroup()
                                    .addComponent(turnTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(turnTextPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(gamePanelLayout.createSequentialGroup()
                                    .addGroup(gamePanelLayout.createParallelGroup()
                                        .addComponent(bankTextPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pawnLabel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(gamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(timerTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(timerTextPane, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE))))
                            .addGap(201, 201, 201))
                );
                gamePanelLayout.setVerticalGroup(
                    gamePanelLayout.createParallelGroup()
                        .addGroup(gamePanelLayout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addGroup(gamePanelLayout.createParallelGroup()
                                .addGroup(gamePanelLayout.createSequentialGroup()
                                    .addGroup(gamePanelLayout.createParallelGroup()
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
                                    .addGroup(gamePanelLayout.createParallelGroup()
                                        .addComponent(pacificAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nyAvenueLab, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(GroupLayout.Alignment.TRAILING, gamePanelLayout.createSequentialGroup()
                                    .addGroup(gamePanelLayout.createParallelGroup()
                                        .addComponent(turnTextPane)
                                        .addComponent(turnTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(gamePanelLayout.createParallelGroup()
                                        .addGroup(gamePanelLayout.createSequentialGroup()
                                            .addComponent(bankTextPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(timerTextArea))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(gamePanelLayout.createParallelGroup()
                                        .addComponent(pawnLabel, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(timerTextPane))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(gamePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(gamePanelLayout.createSequentialGroup()
                                    .addComponent(contractsTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(contractsScrollPane, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
                                    .addGap(20, 20, 20))
                                .addGroup(gamePanelLayout.createSequentialGroup()
                                    .addGroup(gamePanelLayout.createParallelGroup()
                                        .addComponent(northCarAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tennAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(gamePanelLayout.createParallelGroup()
                                        .addComponent(pennAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(stJamesLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(gamePanelLayout.createParallelGroup()
                                        .addComponent(shortLineLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pennRailroadLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(gamePanelLayout.createParallelGroup()
                                        .addComponent(electricCompanyLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(virginiaAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(gamePanelLayout.createParallelGroup()
                                        .addComponent(parkPlaceLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(statesAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))))
                            .addGroup(gamePanelLayout.createParallelGroup()
                                .addGroup(gamePanelLayout.createSequentialGroup()
                                    .addGroup(gamePanelLayout.createParallelGroup()
                                        .addComponent(boardwalkLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(stCharlesLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(gamePanelLayout.createParallelGroup()
                                        .addComponent(goLabel, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(prisonLabel, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(meditAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(balticAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(waterWorksLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(readRailroadLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(orientalAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(vermontAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(connecticutAveLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(gamePanelLayout.createSequentialGroup()
                                    .addGroup(gamePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(contractButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rentButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(gamePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(feeButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(goButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(gamePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(prisonButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(endTurnButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(quitButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
                            .addGap(530, 530, 530))
                );
            }
            gameScrollPane.setViewportView(gamePanel);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Angelo Trotta
    private JScrollPane gameScrollPane;
    private JPanel gamePanel;
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

    public JScrollPane getGameScrollPane() {
        return gameScrollPane;
    }

    private void applyResolution() {
        Dimension resolution = GameFrame.screenSize;
        this.gameScrollPane.setSize(resolution);
        this.gameScrollPane.setPreferredSize(FrameProperties.NATIVE_RES);
        this.gamePanel.setSize(resolution);
        this.gamePanel.setPreferredSize(FrameProperties.NATIVE_RES);
        refreshGUI();
    }

    private void autoResize() {
        Dimension defaultRes = FrameProperties.DEFAULT_RES;
        Dimension resolution = GameFrame.screenSize;
        double ratioX = (double) resolution.width / defaultRes.width;
        double ratioY = (double) resolution.height / defaultRes.height;
        this.gameScrollPane.setSize(resolution);
        this.gameScrollPane.setPreferredSize(FrameProperties.NATIVE_RES);
        this.gamePanel.setSize(resolution);
        this.gamePanel.setPreferredSize(FrameProperties.NATIVE_RES);
        for (Component comp : this.gamePanel.getComponents()) {
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
        this.gameScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.gameScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    }

    private void disableScrollBar() {
        this.gameScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.gameScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
    }

    private void checkResizing() {
        this.resizingChecker = new StoppableThread(() -> {
            while (timer.isRunning()) {
                if (this.givenFrame.getWidth() != FrameProperties.NATIVE_RES.width &&
                    this.givenFrame.getHeight() != FrameProperties.NATIVE_RES.height)
                        enableScrollBar();
                else
                    disableScrollBar();
            }
        });
        this.resizingChecker.start();
    }

    private void spawnPlayer(Player player, PlayerManager players, ContractManager contracts) {
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
        if (FrameProperties.getScalingFactor() == 1)
            this.setBoxLight(player);
    }

    private void setBoxLight(Player player) {
        PositionManager posizioni = PositionManager.getInstance();
        Box currentBox = posizioni.getPositions().get(player.getPosition());
        String positionName = currentBox.getName();

        LightsUI lights = LightsUI.getInstance();
        lights.setPositionLight(this, positionName);
    }

    private void refreshGUI() {
        this.givenFrame.revalidate();
        this.givenFrame.repaint();
        this.gameScrollPane.revalidate();
        this.gameScrollPane.repaint();
        this.gamePanel.revalidate();
        this.gamePanel.repaint();
    }

    private void bindKeyToQuit() {
        this.quitButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false), "clickQuit");
        this.quitButton.getActionMap().put("clickQuit", exitAction);
    }

    private void handleContractButton(Player player, ContractManager contracts, PlayerManager players) {
        try {
            if (!FrameProperties.isContractFrameOpen()) {
                ContractFrame contractFrame = new ContractFrame(this, player, contracts, players);
                contractFrame.setVisible(true);
                FrameProperties.openContractFrame(true);
            } else
                throw new MultipleInstancesException();

        } catch (MultipleInstancesException e) {
            JOptionPane.showMessageDialog(
                    this.givenFrame,
                    "You can't simultaneously open the contracts window more than once.",
                    "ERROR: Multiple instances",
                    JOptionPane.ERROR_MESSAGE
            );
        }
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
        timer.start();

        this.textUpdater = new StoppableThread(() -> {
            while (timer.isRunning()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {}
                remainingTime--;
                timerTextPane.setText(Integer.toString(remainingTime));
            }
        });
        textUpdater.start();

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
        this.refreshProcess = new StoppableThread(() -> {
            updateBank(player);
            updateContracts(player);
            updateLight(player);
            checkGameOver(players);
            refreshProcess.stop(refreshProcess);
        });

        refreshProcess.start();
    }

    private void handleRentButton(Player player, PlayerManager players) {
        try {
            if (!FrameProperties.isRentFrameOpen()) {
                RentFrame rentFrame = new RentFrame(this, player, players);
                rentFrame.setVisible(true);
                FrameProperties.openRentFrame(true);
            } else
                throw new MultipleInstancesException();

        } catch (MultipleInstancesException e) {
            JOptionPane.showMessageDialog(
                    this.givenFrame,
                    "You can't simultaneously open the rent window more than once.",
                    "ERROR: Multiple instances",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void handleFeeButton(Player player, PlayerManager players) {
        try {
            if (!FrameProperties.isFeeFrameOpen()) {
                FeeFrame feeFrame = new FeeFrame(this, player, players);
                feeFrame.setVisible(true);
                FrameProperties.openFeeFrame(true);
            } else
                throw new MultipleInstancesException();

        } catch (MultipleInstancesException e) {
            JOptionPane.showMessageDialog(
                    this.givenFrame,
                    "You can't simultaneously open the fee window more than once.",
                    "ERROR: Multiple instances",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void handleGOButton(Player player, PlayerManager players) {
        deleteLastLight(player);

        player.addMoney(500);
        player.setPosition(GO);
        JOptionPane.showMessageDialog(
                this.gamePanel,
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
        if (this.resizingChecker != null)
            this.resizingChecker.stop(resizingChecker);

        player.setPrisoner(true);
        player.setPosition(PRISON);
        PrisonForm prisonForm = new PrisonForm(this.givenFrame, player, players, contracts);
        this.givenFrame.setContentPane(prisonForm.getPrisonScrollPane());
        this.givenFrame.revalidate();
        this.givenFrame.repaint();
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
        if (this.resizingChecker != null)
            this.resizingChecker.stop(resizingChecker);

        if (!newPlayer.isPrisoner()) {
            RollFrame rollFrame = new RollFrame(newPlayer, players, contracts);
            this.givenFrame.dispose();
            rollFrame.setVisible(true);
        }
        else {
            PrisonForm newForm = new PrisonForm(this.givenFrame, newPlayer, players, contracts);
            this.givenFrame.setContentPane(newForm.getPrisonScrollPane());
            this.givenFrame.revalidate();
            this.givenFrame.repaint();
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
        this.turnChanger = new StoppableThread(() -> {
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
        });
        turnChanger.start();
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
        if (this.resizingChecker != null)
            this.resizingChecker.stop(resizingChecker);

        // Changing window
        if (!newPlayer.isPrisoner()) {
            RollFrame rollFrame = new RollFrame(newPlayer, players, contracts);
            this.givenFrame.dispose();
            rollFrame.setVisible(true);
        }
        else {
            PrisonForm newForm = new PrisonForm(this.givenFrame, newPlayer, players, contracts);
            this.givenFrame.setContentPane(newForm.getPrisonScrollPane());
        }
    }

    private void checkGameOver(PlayerManager players) {
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
            if (this.resizingChecker != null)
                this.resizingChecker.stop(resizingChecker);

            assert winner != null;
            EndFrame endFrame = new EndFrame(winner);
            this.givenFrame.dispose();
            endFrame.setVisible(true);
        }
    }
}