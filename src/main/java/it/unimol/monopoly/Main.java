package it.unimol.monopoly;

import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import it.unimol.monopoly.gui.frames.MainFrame;

public class Main {
    public static void main(String[] args) {
        try {
            FlatArcOrangeIJTheme.setup();
            MainFrame window = new MainFrame();
            window.setVisible(true);
            }
        // catch --> if there's an issue loading FlatArc theme
        catch (Error | Exception e) {
            MainFrame window = new MainFrame();
            window.setVisible(true);
        }
    }
}
