package it.unimol.monopoly.gui.frames.properties;

import java.awt.*;

public class FrameProperties {
    // Class defining global variables with default values, which can be changed.
    private static short displayValue;
    private static short scalingFactor = 1; // 1 = Zoom-In, 2 = Linear
    private static boolean allowResizable;
    private static boolean settingsPageOpen;
    private static boolean contractFrameOpen;
    private static boolean feeFrameOpen;
    private static boolean rentFrameOpen;
    public static final Dimension DEFAULT_RES = new Dimension(1920, 1080);
    public static final Dimension NATIVE_RES = Toolkit.getDefaultToolkit().getScreenSize();

    public static short getDisplayValue() {
        return displayValue;
    }

    public static short getScalingFactor() {
        return scalingFactor;
    }

    public static boolean getResizable() {
        return allowResizable;
    }

    public static boolean isSettingsPageOpen() {
        return settingsPageOpen;
    }

    public static boolean isContractFrameOpen() {
        return contractFrameOpen;
    }

    public static boolean isFeeFrameOpen() {
        return feeFrameOpen;
    }

    public static boolean isRentFrameOpen() {
        return rentFrameOpen;
    }

    public static void setDisplayValue(int displayValue) {
        FrameProperties.displayValue = (short) displayValue;
    }

    public static void setScalingFactor(int num) {
        scalingFactor = (short) num;
    }

    public static void setResizable(boolean allowResizable) {
        FrameProperties.allowResizable = allowResizable;
    }

    public static void openSettingsPage(boolean val) {
        settingsPageOpen = val;
    }

    public static void openContractFrame(boolean val) {
        contractFrameOpen = val;
    }

    public static void openFeeFrame(boolean val) {
        feeFrameOpen = val;
    }

    public static void openRentFrame(boolean val) {
        rentFrameOpen = val;
    }
}
