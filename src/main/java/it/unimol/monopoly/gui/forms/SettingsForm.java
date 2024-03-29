package it.unimol.monopoly.gui.forms;

import it.unimol.monopoly.exceptions.NoScalingMethodException;
import it.unimol.monopoly.exceptions.NoVideoModeException;
import it.unimol.monopoly.exceptions.UnsupportedResException;
import it.unimol.monopoly.gui.frames.GameFrame;
import it.unimol.monopoly.gui.frames.RollFrame;
import it.unimol.monopoly.gui.frames.properties.FrameProperties;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class SettingsForm {
    private JButton cancelButton;
    private JButton applyButton;
    private JComboBox videoBox;
    private JComboBox resolutionBox;
    private JPanel mainPanel;
    private JButton AR_43_Button;
    private JButton AR_1610_Button;
    private JButton AR_169_Button;
    private JButton OFFButton;
    private JButton ONButton;
    private JButton AR_219_Button;
    private JRadioButton linearRadioButton;
    private JRadioButton zoomInRadioButton;
    private JFrame givenFrame;
    private boolean borderless;
    private short aspectRatio;

    public JPanel getMainPanel() {
        return this.mainPanel;
    }

    public SettingsForm(JFrame myFrame) {
        this.givenFrame = myFrame;
        this.videoBox.addItem("");
        this.videoBox.addItem("Windowed");
        this.videoBox.addItem("Borderless");
        this.resolutionBox.addItem("Auto");

        this.videoBox.addActionListener(
                actionEvent -> handleVideoMode()
        );

        this.cancelButton.addActionListener(
                actionEvent -> {
                    this.givenFrame.dispose();
                    FrameProperties.openSettingsPage(false);
                }
        );

        this.applyButton.addActionListener(
                actionEvent -> handleApply()
        );

        this.AR_43_Button.addActionListener(
                actionEvent -> {
                    this.aspectRatio = 1;
                    handleResolutions();
                }
        );

        this.AR_1610_Button.addActionListener(
                actionEvent -> {
                    this.aspectRatio = 2;
                    handleResolutions();
                }
        );

        this.AR_169_Button.addActionListener(
                actionEvent -> {
                    this.aspectRatio = 3;
                    handleResolutions();
                }
        );

        this.AR_219_Button.addActionListener(
                actionEvent -> {
                    this.aspectRatio = 4;
                    handleResolutions();
                }
        );

        this.linearRadioButton.addActionListener(
                actionEvent -> handleLinearScaling()
        );

        this.zoomInRadioButton.addActionListener(
                actionEvent -> handleZoomInScaling()
        );

        this.OFFButton.addActionListener(
                actionEvent -> FrameProperties.setResizable(false)
        );

        this.ONButton.addActionListener(
                actionEvent -> FrameProperties.setResizable(true)
        );
    }

    private void handleVideoMode() {
        this.videoBox.removeItem("");
        String selectedInput = Objects.requireNonNull(this.videoBox.getSelectedItem()).toString();

        if (selectedInput.equals("Windowed"))
            this.borderless = false;
        else // equals("Borderless")
            this.borderless = true;
    }

    private void handleResolutions() {
        switch (this.aspectRatio) {
            case 1:
                this.resolutionBox.removeAllItems();
                this.resolutionBox.addItem("Auto");
                this.resolutionBox.addItem("1024x768");
                this.resolutionBox.addItem("1280x960");
                this.resolutionBox.addItem("1440x1050");
                this.resolutionBox.addItem("1440x1080");
                this.resolutionBox.addItem("1600x1200");
                this.resolutionBox.addItem("1856x1392");
                this.resolutionBox.addItem("1920x1440");
                this.resolutionBox.addItem("2048x1536");
                break;
            case 2:
                this.resolutionBox.removeAllItems();
                this.resolutionBox.addItem("Auto");
                this.resolutionBox.addItem("1280x800");
                this.resolutionBox.addItem("1440x900");
                this.resolutionBox.addItem("1680x1050");
                this.resolutionBox.addItem("1920x1200");
                this.resolutionBox.addItem("2560x1600");
                this.resolutionBox.addItem("3840x2400");
                break;
            case 3:
                this.resolutionBox.removeAllItems();
                this.resolutionBox.addItem("Auto");
                this.resolutionBox.addItem("1024x576");
                this.resolutionBox.addItem("1280x720");
                this.resolutionBox.addItem("1366x768");
                this.resolutionBox.addItem("1600x900");
                this.resolutionBox.addItem("1920x1080");
                this.resolutionBox.addItem("2048x1152");
                this.resolutionBox.addItem("2560x1440");
                this.resolutionBox.addItem("3200x1800");
                this.resolutionBox.addItem("3840x2160");
                break;
            case 4:
                this.resolutionBox.removeAllItems();
                this.resolutionBox.addItem("Auto");
                this.resolutionBox.addItem("2560x1080");
                this.resolutionBox.addItem("3440x1440");
                this.resolutionBox.addItem("3840x1600");
                this.resolutionBox.addItem("5120x2160");
                break;
            default:
                break;
        }
    }

    private void handleLinearScaling() {
        if (zoomInRadioButton.isSelected())
            this.zoomInRadioButton.setSelected(false);

        this.linearRadioButton.setSelected(true);
        FrameProperties.setScalingFactor(2);
    }

    private void handleZoomInScaling() {
        if (linearRadioButton.isSelected())
            this.linearRadioButton.setSelected(false);

        this.zoomInRadioButton.setSelected(true);
        FrameProperties.setScalingFactor(1);
    }

    private void handleApply() {
        String vidBreakable = Objects.requireNonNull(this.videoBox.getSelectedItem()).toString();
        String resBreakable = Objects.requireNonNull(this.resolutionBox.getSelectedItem()).toString();

        String[] input = new String[2];
        if (!resBreakable.equals("Auto"))
            input = resBreakable.split("x");
        else {
            input[0] = String.valueOf(FrameProperties.NATIVE_RES.width);
            input[1] = String.valueOf(FrameProperties.NATIVE_RES.height);
        }
        int[] convertedInput = new int[2];
        convertedInput[0] = Integer.parseInt(input[0]);
        convertedInput[1] = Integer.parseInt(input[1]);
        Dimension resolution = new Dimension(convertedInput[0], convertedInput[1]);

        try {
            if (vidBreakable.isEmpty())
                throw new NoVideoModeException();
            if (!linearRadioButton.isSelected() && !zoomInRadioButton.isSelected()
                    && !resolution.equals(FrameProperties.NATIVE_RES))
                throw new NoScalingMethodException();

            if (borderless)
                FrameProperties.setDisplayValue(1);
            else
                FrameProperties.setDisplayValue(0);

            String videoInput = Objects.requireNonNull(this.resolutionBox.getSelectedItem()).toString();
            Dimension maxDisplaySize = Toolkit.getDefaultToolkit().getScreenSize();
            int maxWidth = maxDisplaySize.width;
            int maxHeight = maxDisplaySize.height;

            try {
                if (videoInput.equals("Auto")) {
                    resolution = maxDisplaySize;
                } else {
                    if (resolution.width > maxWidth || resolution.height > maxHeight)
                        throw new UnsupportedResException();
                }
                if (resolution.equals(FrameProperties.NATIVE_RES)) {
                    FrameProperties.setScalingFactor(1);

                    JOptionPane.showMessageDialog(
                            this.givenFrame,
                            "You have selected your monitor's native resolution. Scaling has been disabled.",
                            "WARNING: Scaling not supported",
                            JOptionPane.WARNING_MESSAGE
                    );
                }

                if (!resolution.equals(FrameProperties.DEFAULT_RES)) {
                    JOptionPane.showMessageDialog(
                            this.givenFrame,
                            "This software was designed to work correctly only when in 1920x1080. " +
                                    "Changing resolution may lead to unexpected results, as this feature is still " +
                                    "being worked on.",
                            "WARNING: Resolution Scaling",
                            JOptionPane.WARNING_MESSAGE
                    );
                }

                RollFrame.screenSize = resolution;
                GameFrame.screenSize = resolution;

            } catch (UnsupportedResException ure) {
                JOptionPane.showMessageDialog(
                        this.givenFrame,
                        "Selected resolution is higher than your monitor's maximum supported one.",
                        "ERROR: Unsupported resolution",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        } catch (NoVideoModeException novme) {
            JOptionPane.showMessageDialog(
                    this.givenFrame,
                    "You didn't select a video mode.",
                    "ERROR: No Video Mode",
                    JOptionPane.ERROR_MESSAGE
            );
        } catch (NoScalingMethodException nosme) {
            JOptionPane.showMessageDialog(
                    this.givenFrame,
                    "You didn't select a scaling method.",
                    "ERROR: No Scaling Method",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

}
