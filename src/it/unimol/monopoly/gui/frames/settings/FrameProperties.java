package it.unimol.monopoly.gui.frames.settings;

import java.awt.*;

public class FrameProperties {
    // Class defining global variables with default values, which can be changed.
    public static short displayValue;
    public static short scalingFactor = 1;
    public static boolean allowResizable;
    public static final Dimension DEFAULT_RES = new Dimension(1920, 1080);
    public static final Dimension NATIVE_RES = Toolkit.getDefaultToolkit().getScreenSize();
}
