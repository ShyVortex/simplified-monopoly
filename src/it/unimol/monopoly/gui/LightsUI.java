package it.unimol.monopoly.gui;

import it.unimol.monopoly.gui.forms.GameForm;
import it.unimol.monopoly.gui.forms.PrisonForm;

import javax.swing.*;
import java.awt.*;

public class LightsUI {
    private static LightsUI instance = new LightsUI();

    private LightsUI() {}

    public static LightsUI getInstance() {
        return instance;
    }

    public void setPositionLight(GameForm gameForm, String position) {
        if (position.equals("GO"))
            gameForm.goLabel.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                    new Color(255,204,102,255)));
        if (position.equals("Mediterranean Avenue"))
            gameForm.meditAvenueLab.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                    new Color(255,204,102,255)));
        if (position.equals("Baltic Avenue"))
            gameForm.balticAvenueLab.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                    new Color(255,204,102,255)));
        if (position.equals("Reading Railroad"))
            gameForm.readRailroadLab.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                    new Color(255,204,102,255)));
        if (position.equals("Oriental Avenue"))
            gameForm.orientalAvenueLab.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                    new Color(255,204,102,255)));
        if (position.equals("Vermont Avenue"))
            gameForm.vermontAvenueLab.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                    new Color(255,204,102,255)));
        if (position.equals("Connecticut Avenue"))
            gameForm.connecticutAveLab.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                    new Color(255,204,102,255)));
        if (position.equals("PRISON"))
            gameForm.prisonLabel.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                    new Color(255,204,102,255)));
        if (position.equals("St. Charles Place"))
            gameForm.stCharlesLab.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                    new Color(255,204,102,255)));
        if (position.equals("States Avenue"))
            gameForm.statesAvenueLab.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                    new Color(255,204,102,255)));
        if (position.equals("Virginia Avenue"))
            gameForm.virginiaAvenueLab.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                    new Color(255,204,102,255)));
        if (position.equals("Pennsylvania Railroad"))
            gameForm.pennRailroadLab.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                    new Color(255,204,102,255)));
        if (position.equals("St. James Place"))
            gameForm.stJamesLab.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                    new Color(255,204,102,255)));
        if (position.equals("Tennessee Avenue"))
            gameForm.tennAvenueLab.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                    new Color(255,204,102,255)));
        if (position.equals("New York Avenue"))
            gameForm.nyAvenueLab.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                    new Color(255,204,102,255)));
        if (position.equals("PARKING"))
            gameForm.parkingLab.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                    new Color(255,204,102,255)));
        if (position.equals("Kentucky Avenue"))
            gameForm.kentuckyAvenueLab.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                    new Color(255,204,102,255)));
        if (position.equals("Indiana Avenue"))
            gameForm.indianaAvenueLab.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                    new Color(255,204,102,255)));
        if (position.equals("Illinois Avenue"))
            gameForm.illinoisAvenueLab.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                    new Color(255,204,102,255)));
        if (position.equals("B.&.O. Railroad"))
            gameForm.bEoRailroadLab.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                    new Color(255,204,102,255)));
        if (position.equals("Atlantic Avenue"))
            gameForm.atlanticAvenueLab.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                    new Color(255,204,102,255)));
        if (position.equals("Ventnor Avenue"))
            gameForm.ventnorAvenueLab.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                    new Color(255,204,102,255)));
        if (position.equals("Marvin Gardens"))
            gameForm.marvinGardensLab.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                    new Color(255,204,102,255)));
        if (position.equals("TRANSIT"))
            gameForm.prisonLabel.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                    new Color(255,204,102,255)));
        if (position.equals("Pacific Avenue"))
            gameForm.pacificAvenueLab.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                    new Color(255,204,102,255)));
        if (position.equals("North Carolina Avenue"))
            gameForm.northCarAvenueLab.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                    new Color(255,204,102,255)));
        if (position.equals("Pennsylvania Avenue"))
            gameForm.pennAvenueLab.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                    new Color(255,204,102,255)));
        if (position.equals("Short Line"))
            gameForm.shortLineLab.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                    new Color(255,204,102,255)));
        if (position.equals("Park Place"))
            gameForm.parkPlaceLab.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                    new Color(255,204,102,255)));
        if (position.equals("Boardwalk"))
            gameForm.boardwalkLab.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                    new Color(255,204,102,255)));
    }

    public void setPrisonLight(PrisonForm prisonForm) {
        prisonForm.getPrigioneLabel().setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                new Color(255,204,102,255)));
    }

    public void removeLight(GameForm gameForm, String position) {
        if (position.equals("GO"))
            gameForm.goLabel.setBorder(BorderFactory.createEmptyBorder());
        if (position.equals("Mediterranean Avenue"))
            gameForm.meditAvenueLab.setBorder(BorderFactory.createEmptyBorder());
        if (position.equals("Baltic Avenue"))
            gameForm.balticAvenueLab.setBorder(BorderFactory.createEmptyBorder());
        if (position.equals("Reading Railroad"))
            gameForm.readRailroadLab.setBorder(BorderFactory.createEmptyBorder());
        if (position.equals("Oriental Avenue"))
            gameForm.orientalAvenueLab.setBorder(BorderFactory.createEmptyBorder());
        if (position.equals("Vermont Avenue"))
            gameForm.vermontAvenueLab.setBorder(BorderFactory.createEmptyBorder());
        if (position.equals("Connecticut Avenue"))
            gameForm.connecticutAveLab.setBorder(BorderFactory.createEmptyBorder());
        if (position.equals("PRISON"))
            gameForm.prisonLabel.setBorder(BorderFactory.createEmptyBorder());
        if (position.equals("St. Charles Place"))
            gameForm.stCharlesLab.setBorder(BorderFactory.createEmptyBorder());
        if (position.equals("States Avenue"))
            gameForm.statesAvenueLab.setBorder(BorderFactory.createEmptyBorder());
        if (position.equals("Virginia Avenue"))
            gameForm.virginiaAvenueLab.setBorder(BorderFactory.createEmptyBorder());
        if (position.equals("Pennsylvania Railroad"))
            gameForm.pennRailroadLab.setBorder(BorderFactory.createEmptyBorder());
        if (position.equals("St. James Place"))
            gameForm.stJamesLab.setBorder(BorderFactory.createEmptyBorder());
        if (position.equals("Tennessee Avenue"))
            gameForm.tennAvenueLab.setBorder(BorderFactory.createEmptyBorder());
        if (position.equals("New York Avenue"))
            gameForm.nyAvenueLab.setBorder(BorderFactory.createEmptyBorder());
        if (position.equals("PARKING"))
            gameForm.parkingLab.setBorder(BorderFactory.createEmptyBorder());
        if (position.equals("Kentucky Avenue"))
            gameForm.kentuckyAvenueLab.setBorder(BorderFactory.createEmptyBorder());
        if (position.equals("Indiana Avenue"))
            gameForm.indianaAvenueLab.setBorder(BorderFactory.createEmptyBorder());
        if (position.equals("Illinois Avenue"))
            gameForm.illinoisAvenueLab.setBorder(BorderFactory.createEmptyBorder());
        if (position.equals("B.&.O. Railroad"))
            gameForm.bEoRailroadLab.setBorder(BorderFactory.createEmptyBorder());
        if (position.equals("Atlantic Avenue"))
            gameForm.atlanticAvenueLab.setBorder(BorderFactory.createEmptyBorder());
        if (position.equals("Ventnor Avenue"))
            gameForm.ventnorAvenueLab.setBorder(BorderFactory.createEmptyBorder());
        if (position.equals("Marvin Gardens"))
            gameForm.marvinGardensLab.setBorder(BorderFactory.createEmptyBorder());
        if (position.equals("TRANSIT"))
            gameForm.prisonLabel.setBorder(BorderFactory.createEmptyBorder());
        if (position.equals("Pacific Avenue"))
            gameForm.pacificAvenueLab.setBorder(BorderFactory.createEmptyBorder());
        if (position.equals("North Carolina Avenue"))
            gameForm.northCarAvenueLab.setBorder(BorderFactory.createEmptyBorder());
        if (position.equals("Pennsylvania Avenue"))
            gameForm.pennAvenueLab.setBorder(BorderFactory.createEmptyBorder());
        if (position.equals("Short Line"))
            gameForm.shortLineLab.setBorder(BorderFactory.createEmptyBorder());
        if (position.equals("Park Place"))
            gameForm.parkPlaceLab.setBorder(BorderFactory.createEmptyBorder());
        if (position.equals("Boardwalk"))
            gameForm.boardwalkLab.setBorder(BorderFactory.createEmptyBorder());
    }
}