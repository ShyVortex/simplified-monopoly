package it.unimol.monopoly.gui.frames.properties;

import java.awt.*;

public class FrameProperties {
    // Class defining global variables with default values, which can be changed.
    public static short displayValue;
    public static short scalingFactor = 1;
    public static boolean allowResizable;
    public static boolean settingsPageOpen;
    public static boolean contractFrameOpen;
    public static boolean feeFrameOpen;
    public static boolean rentFrameOpen;
    public static final Dimension DEFAULT_RES = new Dimension(1920, 1080);
    public static final Dimension NATIVE_RES = Toolkit.getDefaultToolkit().getScreenSize();

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

    public static void setScalingFactor(int num) {
        scalingFactor = (short) num;
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
