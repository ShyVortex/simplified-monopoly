package it.unimol.monopoly;

import it.unimol.monopoly.gui.frames.MainFrame;

public class Main {
    public static void main(String[] args) {
       /* try {
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ignored) {} */
        MainFrame window = new MainFrame();
        window.setVisible(true);
    }
}
