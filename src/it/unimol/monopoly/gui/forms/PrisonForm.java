/*
 * Created by JFormDesigner on Fri May 20 18:59:07 CEST 2022
 */

package it.unimol.monopoly.gui.forms;

import it.unimol.monopoly.app.*;
import it.unimol.monopoly.gui.LightsUI;
import it.unimol.monopoly.gui.frames.RollFrame;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class PrisonForm extends JPanel {
    private JFrame givenFrame;
    public PrisonForm(JFrame myFrame, Player player, PlayerManager players, ContractManager contracts) {
        this.givenFrame = myFrame;
        initComponents();
        spawnPlayer(player);

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

        //======== this ========
        setBackground(new Color(254, 255, 254));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing.
        border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER
        , javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font
        .BOLD ,12 ), java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (
        new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r"
        .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

        //---- parkingLab ----
        URL parkingUrl = ClassLoader.getSystemResource("Parking.jpg");
        parkingLab.setIcon(new ImageIcon(parkingUrl));

        //---- nyAvenueLab ----
        URL nyAvenueUrl = ClassLoader.getSystemResource("NewYorkAvenue.jpg");
        nyAvenueLab.setIcon(new ImageIcon(nyAvenueUrl));

        //---- tennAvenueLab ----
        URL tennAvenueUrl = ClassLoader.getSystemResource("TennesseeAvenue.jpg");
        tennAvenueLab.setIcon(new ImageIcon(tennAvenueUrl));

        //---- stJamesLab ----
        URL stJamesUrl = ClassLoader.getSystemResource("StJamesPlace.jpg");
        stJamesLab.setIcon(new ImageIcon(tennAvenueUrl));

        //---- pennRailroadLab ----
        URL pennRailroadUrl = ClassLoader.getSystemResource("PennsylvaniaRailroad.jpg");
        pennRailroadLab.setIcon(new ImageIcon(pennRailroadUrl));

        //---- virginiaAvenueLab ----
        URL virginiaAvenueUrl = ClassLoader.getSystemResource("VirginiaAvenue.jpg");
        virginiaAvenueLab.setIcon(new ImageIcon(virginiaAvenueUrl));

        //---- statesAvenueLab ----
        URL statesAvenueUrl = ClassLoader.getSystemResource("StatesAvenue.jpg");
        statesAvenueLab.setIcon(new ImageIcon(statesAvenueUrl));

        //---- stCharlesLab ----
        URL stCharlesUrl = ClassLoader.getSystemResource("StCharlesPlace.jpg");
        stCharlesLab.setIcon(new ImageIcon(stCharlesUrl));

        //---- prisonLabel ----
        URL prisonUrl = ClassLoader.getSystemResource("Prison.jpg");
        prisonLabel.setIcon(new ImageIcon(prisonUrl));

        //---- connecticutAveLab ----
        URL connecticutAveUrl = ClassLoader.getSystemResource("ConnecticutAvenue.jpg");
        connecticutAveLab.setIcon(new ImageIcon(connecticutAveUrl));

        //---- vermontAvenueLab ----
        URL vermontAvenueUrl = ClassLoader.getSystemResource("VermontAvenue.jpg");
        vermontAvenueLab.setIcon(new ImageIcon(vermontAvenueUrl));

        //---- orientalAvenueLab ----
        URL orientalAvenueUrl = ClassLoader.getSystemResource("OrientalAvenue.jpg");
        orientalAvenueLab.setIcon(new ImageIcon(orientalAvenueUrl));

        //---- readRailroadLab ----
        URL readRailroadUrl = ClassLoader.getSystemResource("ReadingRailroad.jpg");
        readRailroadLab.setIcon(new ImageIcon(readRailroadUrl));

        //---- waterWorksLab ----
        URL waterWorksUrl = ClassLoader.getSystemResource("WaterWorks.jpg");
        waterWorksLab.setIcon(new ImageIcon(waterWorksUrl));

        //---- balticAvenueLab ----
        URL balticAvenueUrl = ClassLoader.getSystemResource("BalticAvenue.jpg");
        balticAvenueLab.setIcon(new ImageIcon(balticAvenueUrl));

        //---- meditAvenueLab ----
        URL meditAvenueUrl = ClassLoader.getSystemResource("MediterraneanAvenue.jpg");
        meditAvenueLab.setIcon(new ImageIcon(meditAvenueUrl));

        //---- goLabel ----
        URL goUrl = ClassLoader.getSystemResource("GOv2.jpg");
        goLabel.setIcon(new ImageIcon(goUrl));

        //---- kentuckyAvenueLab ----
        URL kentuckyAvenueUrl = ClassLoader.getSystemResource("KentuckyAvenue.jpg");
        kentuckyAvenueLab.setIcon(new ImageIcon(kentuckyAvenueUrl));

        //---- indianaAvenueLab ----
        URL indianaAvenueUrl = ClassLoader.getSystemResource("IndianaAvenue.jpg");
        indianaAvenueLab.setIcon(new ImageIcon(indianaAvenueUrl));

        //---- illinoisAvenueLab ----
        URL illinoisAvenueUrl = ClassLoader.getSystemResource("IllinoisAvenue.jpg");
        illinoisAvenueLab.setIcon(new ImageIcon(illinoisAvenueUrl));

        //---- bEoRailroadLab ----
        URL bEoRailroadUrl = ClassLoader.getSystemResource("B&ORailroad.jpg");
        bEoRailroadLab.setIcon(new ImageIcon(bEoRailroadUrl));

        //---- atlanticAvenueLab ----
        URL atlanticAvenueUrl = ClassLoader.getSystemResource("AtlanticAvenue.jpg");
        atlanticAvenueLab.setIcon(new ImageIcon(atlanticAvenueUrl));

        //---- ventnorAvenueLab ----
        URL ventnorAvenueUrl = ClassLoader.getSystemResource("VentnorAvenue.jpg");
        ventnorAvenueLab.setIcon(new ImageIcon(ventnorAvenueUrl));

        //---- marvinGardensLab ----
        URL marvinGardensUrl = ClassLoader.getSystemResource("MarvinGardens.jpg");
        marvinGardensLab.setIcon(new ImageIcon(marvinGardensUrl));

        //---- transitLabel ----
        URL transitUrl = ClassLoader.getSystemResource("Transit.jpg");
        transitLabel.setIcon(new ImageIcon(transitUrl));

        //---- pacificAvenueLab ----
        URL pacificAvenueUrl = ClassLoader.getSystemResource("PacificAvenue.jpg");
        pacificAvenueLab.setIcon(new ImageIcon(pacificAvenueUrl));

        //---- northCarAvenueLab ----
        URL northCarAvenueUrl = ClassLoader.getSystemResource("NorthCarolinaAvenue.jpg");
        northCarAvenueLab.setIcon(new ImageIcon(northCarAvenueUrl));

        //---- pennAvenueLab ----
        URL pennAvenueUrl = ClassLoader.getSystemResource("PennsylvaniaAvenue.jpg");
        pennAvenueLab.setIcon(new ImageIcon(pennAvenueUrl));

        //---- shortLineLab ----
        URL shortLineUrl = ClassLoader.getSystemResource("ShortLine.jpg");
        shortLineLab.setIcon(new ImageIcon(shortLineUrl));

        //---- electricCompanyLab ----
        URL electricCompanyUrl = ClassLoader.getSystemResource("ElectricCompany.jpg");
        electricCompanyLab.setIcon(new ImageIcon(electricCompanyUrl));

        //---- parkPlaceLab ----
        URL parkPlaceUrl = ClassLoader.getSystemResource("ParkPlace.jpg");
        parkPlaceLab.setIcon(new ImageIcon(parkPlaceUrl));

        //---- boardwalkLab ----
        URL boardwalkUrl = ClassLoader.getSystemResource("BoardWalk.jpg");
        boardwalkLab.setIcon(new ImageIcon(boardwalkUrl));

        //---- turnTextArea ----
        turnTextArea.setText("Turn of:");
        turnTextArea.setBackground(new Color(254, 255, 254));
        turnTextArea.setFont(new Font("Noto Sans", Font.BOLD, 40));
        turnTextArea.setForeground(new Color(122, 140, 147));
        turnTextArea.setEditable(false);

        //---- turnTextPane ----
        turnTextPane.setFont(new Font("Noto Sans", Font.BOLD, 40));
        turnTextPane.setBackground(new Color(254, 255, 254));
        turnTextPane.setForeground(new Color(122, 140, 147));
        turnTextPane.setEditable(false);

        //---- bancaTextPane ----
        bancaTextPane.setFont(new Font("Noto Sans", Font.BOLD, 34));
        bancaTextPane.setBackground(new Color(254, 255, 254));
        bancaTextPane.setForeground(new Color(122, 140, 147));
        bancaTextPane.setEditable(false);

        //---- contractsTextArea ----
        contractsTextArea.setFont(new Font("Noto Sans", Font.BOLD, 36));
        contractsTextArea.setText("Contracts:");
        contractsTextArea.setBackground(new Color(254, 255, 254));
        contractsTextArea.setForeground(new Color(122, 140, 147));
        contractsTextArea.setEditable(false);

        //---- freeExitButton ----
        freeExitButton.setText("Free exit");
        freeExitButton.setBackground(new Color(206, 217, 220));
        freeExitButton.setIcon(null);

        //---- paidExitButton ----
        paidExitButton.setText("Paid exit");
        paidExitButton.setBackground(new Color(206, 217, 220));

        //---- stayButton ----
        stayButton.setText("Stay in prison");
        stayButton.setBackground(new Color(206, 217, 220));

        //---- quitButton ----
        quitButton.setText("Quit from the game");
        quitButton.setBackground(new Color(206, 217, 220));

        //---- pawnLabel ----
        pawnLabel.setIcon(null);

        //======== contractsScrollPane ========
        {

            //---- contractsTextPane ----
            contractsTextPane.setFont(new Font("Noto Sans", Font.BOLD, 20));
            contractsTextPane.setEditable(false);
            contractsScrollPane.setViewportView(contractsTextPane);
        }

        //---- prisonTextArea ----
        prisonTextArea.setText("In prison!");
        prisonTextArea.setFont(new Font("Noto Sans", Font.BOLD, 40));
        prisonTextArea.setEditable(false);
        prisonTextArea.setBackground(new Color(254, 255, 254));
        prisonTextArea.setForeground(new Color(122, 140, 147));

        //---- positionTextArea ----
        positionTextArea.setBackground(new Color(254, 255, 254));
        positionTextArea.setForeground(new Color(255, 204, 102));
        positionTextArea.setFont(new Font("Noto Sans", Font.BOLD, 40));
        positionTextArea.setText("Position:");
        positionTextArea.setEditable(false);

        //---- positionTextPane ----
        positionTextPane.setBackground(new Color(254, 255, 254));
        positionTextPane.setForeground(Color.black);
        positionTextPane.setFont(new Font("Noto Sans", Font.BOLD, 20));
        positionTextPane.setEditable(false);

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(59, 59, 59)
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
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(pacificAvenueLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                        .addComponent(transitLabel, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                        .addComponent(northCarAvenueLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                        .addComponent(boardwalkLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                        .addComponent(goLabel, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                        .addComponent(pennAvenueLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                        .addComponent(shortLineLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                        .addComponent(electricCompanyLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                        .addComponent(parkPlaceLab, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 296, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(prisonTextArea, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                        .addComponent(contractsTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(freeExitButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(paidExitButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(stayButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(quitButton, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(turnTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(turnTextPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(bancaTextPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(pawnLabel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                            .addGap(27, 27, 27)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(positionTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(positionTextPane, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
                        .addComponent(contractsScrollPane, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE))
                    .addGap(204, 204, 204))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(prisonTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
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
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(turnTextPane)
                                .addComponent(turnTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(bancaTextPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(pawnLabel, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(positionTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(6, 6, 6)
                                    .addComponent(positionTextPane, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)))
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
                            .addComponent(freeExitButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(paidExitButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(stayButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(quitButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
                    .addGap(588, 588, 588))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Angelo Trotta
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

    private void spawnPlayer(Player player) {
        PositionManager positions = PositionManager.getInstance();

        // Generating icon
        ImageIcon formaPedina = player.getPawn().getShape();
        assert formaPedina != null;
        this.pawnLabel.setIcon(formaPedina);

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
        this.setBoxLight();
    }

    private void setBoxLight() {
        LightsUI lights = LightsUI.getInstance();
        lights.setPrisonLight(this);
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

        GameForm gameForm = new GameForm(this.givenFrame, player, players, contracts);
        this.givenFrame.setContentPane(gameForm);
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

            GameForm gameForm = new GameForm(this.givenFrame, player, players, contracts);
            this.givenFrame.setContentPane(gameForm);
        }
        else {
            JOptionPane.showMessageDialog(
                    this.givenFrame,
                    "You don't have enough money. You will stay in prison for another turn.",
                    "ERROR: Not enough money",
                    JOptionPane.ERROR_MESSAGE
            );

            this.handleStay(player, players, contracts);
        }
    }

    private void handleStay(Player player, PlayerManager players, ContractManager contracts) {
        Prison prison = Prison.getInstance();
        prison.stay(player);

        JOptionPane.showMessageDialog(
                this.givenFrame,
                "You've decided to stay in prison.",
                "INFO: Extra turn in prison",
                JOptionPane.INFORMATION_MESSAGE
        );

        Player changePlayer = players.changePlayer(Turn.playerId);
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
        this.givenFrame.setContentPane(currentForm);
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
