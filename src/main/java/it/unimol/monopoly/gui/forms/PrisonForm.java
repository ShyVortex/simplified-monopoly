/*
 * Created by JFormDesigner on Fri May 20 18:59:07 CEST 2022
 */

package it.unimol.monopoly.gui.forms;

import it.unimol.monopoly.app.*;
import it.unimol.monopoly.gui.LightsUI;
import it.unimol.monopoly.gui.frames.GameFrame;
import it.unimol.monopoly.gui.frames.RollFrame;
import it.unimol.monopoly.gui.frames.properties.FrameProperties;
import it.unimol.monopoly.threads.StoppableThread;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class PrisonForm {
    private JFrame givenFrame;
    private boolean poorSkip;
    private Action exitAction;
    private StoppableThread resizingChecker;

    public PrisonForm(JFrame myFrame, Player player, PlayerManager players, ContractManager contracts) {
        initComponents();
        this.givenFrame = myFrame;
        if (FrameProperties.getScalingFactor() == 2)
            autoResize();
        else
            applyResolution();
        this.givenFrame.add(this.prisonScrollPane);
        spawnPlayer(player);
        if (FrameProperties.getResizable())
            checkResizing();

        // Allows to quit the game by using a custom shortcut instead of a mouse click
        exitAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleQuit(players, contracts);
            }
        };
        bindKeyToQuit();

        this.freeExitButton.addActionListener(
                actionEvent -> handleFreeExit(player, players, contracts)
        );

        this.paidExitButton.addActionListener(
                actionEvent -> handlePaidExit(player, players, contracts)
        );

        this.stayButton.addActionListener(
                actionEvent -> handleStay(player, players, contracts)
        );

        this.quitButton.addActionListener(
                actionEvent -> handleQuit(players, contracts)
        );
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Angelo Trotta
        prisonScrollPane = new JScrollPane();
        prisonPanel = new JPanel();
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
        bancaTextPane = new JTextPane();
        contractsTextArea = new JTextArea();
        freeExitButton = new JButton();
        paidExitButton = new JButton();
        stayButton = new JButton();
        quitButton = new JButton();
        pawnLabel = new JLabel();
        contractsScrollPane = new JScrollPane();
        contractsTextPane = new JTextPane();
        prisonTextArea = new JTextArea();
        positionTextArea = new JTextArea();
        positionTextPane = new JTextPane();

        //======== prisonScrollPane ========
        {

            //======== prisonPanel ========
            {
                prisonPanel.setBackground(new Color(0xfefffe));
                prisonPanel.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder(
                0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder
                . BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt. Color.
                red) ,prisonPanel. getBorder( )) ); prisonPanel. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .
                beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

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
                parkPlaceLab.setIcon(new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/boxes/ParkPlace.jpg"))));
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

                //---- bancaTextPane ----
                bancaTextPane.setFont(new Font("Noto Sans", Font.BOLD, 34));
                bancaTextPane.setBackground(new Color(0xfefffe));
                bancaTextPane.setForeground(new Color(0x7a8c93));
                bancaTextPane.setEditable(false);
                bancaTextPane.setFocusable(false);

                //---- contractsTextArea ----
                contractsTextArea.setFont(new Font("Noto Sans", Font.BOLD, 36));
                contractsTextArea.setText("Contracts:");
                contractsTextArea.setBackground(new Color(0xfefffe));
                contractsTextArea.setForeground(new Color(0x7a8c93));
                contractsTextArea.setEditable(false);
                contractsTextArea.setFocusable(false);

                //---- freeExitButton ----
                freeExitButton.setText("Free exit");
                freeExitButton.setBackground(new Color(0xced9dc));
                freeExitButton.setIcon(null);
                freeExitButton.setFocusable(false);

                //---- paidExitButton ----
                paidExitButton.setText("Paid exit");
                paidExitButton.setBackground(new Color(0xced9dc));
                paidExitButton.setFocusable(false);

                //---- stayButton ----
                stayButton.setText("Stay in prison");
                stayButton.setBackground(new Color(0xced9dc));
                stayButton.setFocusable(false);

                //---- quitButton ----
                quitButton.setText("Quit from the game");
                quitButton.setBackground(new Color(0xced9dc));
                quitButton.setFocusable(false);

                //---- pawnLabel ----
                pawnLabel.setIcon(null);
                pawnLabel.setFocusable(false);

                //======== contractsScrollPane ========
                {
                    contractsScrollPane.setFocusable(false);

                    //---- contractsTextPane ----
                    contractsTextPane.setFont(new Font("Noto Sans", Font.BOLD, 20));
                    contractsTextPane.setEditable(false);
                    contractsTextPane.setFocusable(false);
                    contractsScrollPane.setViewportView(contractsTextPane);
                }

                //---- prisonTextArea ----
                prisonTextArea.setText("In prison!");
                prisonTextArea.setFont(new Font("Noto Sans", Font.BOLD, 40));
                prisonTextArea.setEditable(false);
                prisonTextArea.setBackground(new Color(0xfefffe));
                prisonTextArea.setForeground(new Color(0x7a8c93));
                prisonTextArea.setFocusable(false);

                //---- positionTextArea ----
                positionTextArea.setBackground(new Color(0xfefffe));
                positionTextArea.setForeground(new Color(0xffcc66));
                positionTextArea.setFont(new Font("Noto Sans", Font.BOLD, 40));
                positionTextArea.setText("Position:");
                positionTextArea.setEditable(false);
                positionTextArea.setFocusable(false);

                //---- positionTextPane ----
                positionTextPane.setBackground(new Color(0xfefffe));
                positionTextPane.setForeground(Color.black);
                positionTextPane.setFont(new Font("Noto Sans", Font.BOLD, 20));
                positionTextPane.setEditable(false);
                positionTextPane.setFocusable(false);

                GroupLayout prisonPanelLayout = new GroupLayout(prisonPanel);
                prisonPanel.setLayout(prisonPanelLayout);
                prisonPanelLayout.setHorizontalGroup(
                    prisonPanelLayout.createParallelGroup()
                        .addGroup(prisonPanelLayout.createSequentialGroup()
                            .addGap(59, 59, 59)
                            .addGroup(prisonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(prisonPanelLayout.createSequentialGroup()
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
                                .addGroup(prisonPanelLayout.createSequentialGroup()
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
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(prisonPanelLayout.createParallelGroup()
                                .addComponent(pacificAvenueLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                .addComponent(transitLabel, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                .addComponent(northCarAvenueLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                .addComponent(boardwalkLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                .addComponent(goLabel, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                .addComponent(pennAvenueLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                .addComponent(shortLineLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                .addComponent(electricCompanyLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                .addComponent(parkPlaceLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 802, Short.MAX_VALUE)
                            .addGroup(prisonPanelLayout.createParallelGroup()
                                .addComponent(prisonTextArea, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                .addComponent(contractsTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(prisonPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(freeExitButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(paidExitButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(stayButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(quitButton, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE))
                                .addGroup(prisonPanelLayout.createSequentialGroup()
                                    .addComponent(turnTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(turnTextPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(prisonPanelLayout.createSequentialGroup()
                                    .addGroup(prisonPanelLayout.createParallelGroup()
                                        .addComponent(bancaTextPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pawnLabel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                                    .addGap(27, 27, 27)
                                    .addGroup(prisonPanelLayout.createParallelGroup()
                                        .addComponent(positionTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(positionTextPane, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
                                .addComponent(contractsScrollPane, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE))
                            .addGap(204, 204, 204))
                );
                prisonPanelLayout.setVerticalGroup(
                    prisonPanelLayout.createParallelGroup()
                        .addGroup(prisonPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(prisonTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(prisonPanelLayout.createParallelGroup()
                                .addGroup(prisonPanelLayout.createSequentialGroup()
                                    .addGroup(prisonPanelLayout.createParallelGroup()
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
                                    .addGroup(prisonPanelLayout.createParallelGroup()
                                        .addComponent(pacificAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nyAvenueLab, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(prisonPanelLayout.createSequentialGroup()
                                    .addGroup(prisonPanelLayout.createParallelGroup()
                                        .addComponent(turnTextPane)
                                        .addComponent(turnTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(prisonPanelLayout.createParallelGroup()
                                        .addGroup(prisonPanelLayout.createSequentialGroup()
                                            .addComponent(bancaTextPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(pawnLabel, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(prisonPanelLayout.createSequentialGroup()
                                            .addComponent(positionTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addGap(6, 6, 6)
                                            .addComponent(positionTextPane, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(prisonPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(prisonPanelLayout.createSequentialGroup()
                                    .addComponent(contractsTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(contractsScrollPane, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
                                    .addGap(20, 20, 20))
                                .addGroup(prisonPanelLayout.createSequentialGroup()
                                    .addGroup(prisonPanelLayout.createParallelGroup()
                                        .addComponent(northCarAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tennAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(prisonPanelLayout.createParallelGroup()
                                        .addComponent(pennAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(stJamesLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(prisonPanelLayout.createParallelGroup()
                                        .addComponent(shortLineLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pennRailroadLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(prisonPanelLayout.createParallelGroup()
                                        .addComponent(electricCompanyLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(virginiaAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(prisonPanelLayout.createParallelGroup()
                                        .addComponent(parkPlaceLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(statesAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))))
                            .addGroup(prisonPanelLayout.createParallelGroup()
                                .addGroup(prisonPanelLayout.createSequentialGroup()
                                    .addGroup(prisonPanelLayout.createParallelGroup()
                                        .addComponent(boardwalkLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(stCharlesLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(prisonPanelLayout.createParallelGroup()
                                        .addComponent(goLabel, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(prisonLabel, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(meditAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(balticAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(waterWorksLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(readRailroadLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(orientalAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(vermontAvenueLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(connecticutAveLab, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(prisonPanelLayout.createSequentialGroup()
                                    .addComponent(freeExitButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(paidExitButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(stayButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(quitButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
                            .addGap(588, 588, 588))
                );
            }
            prisonScrollPane.setViewportView(prisonPanel);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Angelo Trotta
    private JScrollPane prisonScrollPane;
    private JPanel prisonPanel;
    private JLabel parkingLab;
    private JLabel nyAvenueLab;
    private JLabel tennAvenueLab;
    private JLabel stJamesLab;
    private JLabel pennRailroadLab;
    private JLabel virginiaAvenueLab;
    private JLabel statesAvenueLab;
    private JLabel stCharlesLab;
    private JLabel prisonLabel;
    private JLabel connecticutAveLab;
    private JLabel vermontAvenueLab;
    private JLabel orientalAvenueLab;
    private JLabel readRailroadLab;
    private JLabel waterWorksLab;
    private JLabel balticAvenueLab;
    private JLabel meditAvenueLab;
    private JLabel goLabel;
    private JLabel kentuckyAvenueLab;
    private JLabel indianaAvenueLab;
    private JLabel illinoisAvenueLab;
    private JLabel bEoRailroadLab;
    private JLabel atlanticAvenueLab;
    private JLabel ventnorAvenueLab;
    private JLabel marvinGardensLab;
    private JLabel transitLabel;
    private JLabel pacificAvenueLab;
    private JLabel northCarAvenueLab;
    private JLabel pennAvenueLab;
    private JLabel shortLineLab;
    private JLabel electricCompanyLab;
    private JLabel parkPlaceLab;
    private JLabel boardwalkLab;
    private JTextArea turnTextArea;
    private JTextPane turnTextPane;
    private JTextPane bancaTextPane;
    private JTextArea contractsTextArea;
    private JButton freeExitButton;
    private JButton paidExitButton;
    private JButton stayButton;
    private JButton quitButton;
    private JLabel pawnLabel;
    private JScrollPane contractsScrollPane;
    private JTextPane contractsTextPane;
    private JTextArea prisonTextArea;
    private JTextArea positionTextArea;
    private JTextPane positionTextPane;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public JLabel getPrigioneLabel() {
        return prisonLabel;
    }

    public JScrollPane getPrisonScrollPane() {
        return prisonScrollPane;
    }

    private void applyResolution() {
        Dimension resolution = GameFrame.screenSize;
        this.prisonScrollPane.setSize(resolution);
        this.prisonScrollPane.setPreferredSize(FrameProperties.NATIVE_RES);
        this.prisonPanel.setSize(resolution);
        this.prisonPanel.setPreferredSize(FrameProperties.NATIVE_RES);
        refreshGUI();
    }

    private void autoResize() {
        Dimension defaultRes = FrameProperties.DEFAULT_RES;
        Dimension resolution = GameFrame.screenSize;
        double ratioX = (double) resolution.width / defaultRes.width;
        double ratioY = (double) resolution.height / defaultRes.height;
        this.prisonScrollPane.setSize(resolution);
        this.prisonScrollPane.setPreferredSize(FrameProperties.NATIVE_RES);
        this.prisonPanel.setSize(resolution);
        this.prisonPanel.setPreferredSize(FrameProperties.NATIVE_RES);
        for (Component comp : this.prisonPanel.getComponents()) {
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
        this.prisonScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.prisonScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    }

    private void disableScrollBar() {
        this.prisonScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.prisonScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
    }

    private void checkResizing() {
        this.resizingChecker = new StoppableThread(() -> {
            while (true) {
                if (this.givenFrame.getWidth() != FrameProperties.NATIVE_RES.width &&
                        this.givenFrame.getHeight() != FrameProperties.NATIVE_RES.height)
                    enableScrollBar();
                else
                    disableScrollBar();
            }
        });
        this.resizingChecker.start();
    }

    private void spawnPlayer(Player player) {
        PositionManager positions = PositionManager.getInstance();

        // Generating icon
        ImageIcon pawnShape = player.getPawn().getShape();
        assert pawnShape != null;
        this.pawnLabel.setIcon(pawnShape);

        // Setting turn text
        this.turnTextPane.setText(player.getName());

        // Money visualization
        this.bancaTextPane.setText(player.getMoney() + "€");

        // Contracts visualization
        Contract.i = 1;
        this.contractsTextPane.setText(player.cPtoString());

        // Position visualization
        this.positionTextPane.setText(positions.getPositions().get(player.getPosition()).getName());

        // Box illumination
        if (FrameProperties.getScalingFactor() == 1)
            this.setBoxLight();
    }

    private void setBoxLight() {
        LightsUI lights = LightsUI.getInstance();
        lights.setPrisonLight(this);
    }

    private void refreshGUI() {
        this.givenFrame.revalidate();
        this.givenFrame.repaint();
        this.prisonScrollPane.revalidate();
        this.prisonScrollPane.repaint();
        this.prisonPanel.revalidate();
        this.prisonPanel.repaint();
    }

    private void bindKeyToQuit() {
        this.quitButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false), "clickQuit");
        this.quitButton.getActionMap().put("clickQuit", exitAction);
    }

    private void handleFreeExit(Player player, PlayerManager players, ContractManager contracts) {
        Prison prison = Prison.getInstance();
        prison.freeExit(player);
        JOptionPane.showMessageDialog(
                this.givenFrame,
                "You left prison for free!",
                "INFO: Free exit",
                JOptionPane.INFORMATION_MESSAGE
        );
        if (this.resizingChecker != null)
            this.resizingChecker.stop(resizingChecker);

        GameForm gameForm = new GameForm(this.givenFrame, player, players, contracts);
        this.givenFrame.setContentPane(gameForm.getGameScrollPane());
        this.givenFrame.revalidate();
        this.givenFrame.repaint();
    }

    private void handlePaidExit(Player player, PlayerManager players, ContractManager contracts) {
        Prison prison = Prison.getInstance();
        boolean hasMoney = prison.paidExit(player);

        if (hasMoney) {
            JOptionPane.showMessageDialog(
                    this.givenFrame,
                    "You left prison by paying. 125€ have been subtracted from your account.",
                    "INFO: Paid exit",
                    JOptionPane.INFORMATION_MESSAGE
            );
            if (this.resizingChecker != null)
                this.resizingChecker.stop(resizingChecker);

            GameForm gameForm = new GameForm(this.givenFrame, player, players, contracts);
            this.givenFrame.setContentPane(gameForm.getGameScrollPane());
            this.givenFrame.revalidate();
            this.givenFrame.repaint();
        }
        else {
            JOptionPane.showMessageDialog(
                    this.givenFrame,
                    "You don't have enough money. You will stay in prison for another turn.",
                    "ERROR: Not enough money",
                    JOptionPane.ERROR_MESSAGE
            );
            poorSkip = true;
            this.handleStay(player, players, contracts);
        }
    }

    private void handleStay(Player player, PlayerManager players, ContractManager contracts) {
        Prison prison = Prison.getInstance();
        prison.stay(player);

        if (!poorSkip) {
            JOptionPane.showMessageDialog(
                    this.givenFrame,
                    "You've decided to stay in prison.",
                    "INFO: Extra turn in prison",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }

        Player changePlayer = players.changePlayer(Turn.playerId);
        if (this.resizingChecker != null)
            this.resizingChecker.stop(resizingChecker);
        if (!changePlayer.isPrisoner()) {
            RollFrame rollFrame = new RollFrame(changePlayer, players, contracts);
            this.givenFrame.dispose();
            rollFrame.setVisible(true);
        }
        else {
            changePrisoner(changePlayer, players, contracts);
        }
    }

    private void changePrisoner(Player player, PlayerManager players, ContractManager contracts) {
        PrisonForm currentForm = new PrisonForm(this.givenFrame, player, players, contracts);
        this.givenFrame.setContentPane(currentForm.getPrisonScrollPane());
    }

    private void handleQuit(PlayerManager players, ContractManager contracts) {
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
}
