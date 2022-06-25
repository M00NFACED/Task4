package ru.vsu.cs.pekshev.T4.sort.demo;

import java.awt.EventQueue;
import java.util.Locale;
import javax.swing.*;

import static java.awt.Frame.MAXIMIZED_BOTH;

import ru.vsu.cs.pekshev.util.SwingUtils;


public class Program {

    /**
     *
     *
     * @param args Параметры командной строки
     * @throws Exception Любое исключение
     */
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.ROOT);

        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        SwingUtils.setDefaultFont("Arial", 20);

        EventQueue.invokeLater(() -> {
            try {
                JFrame frameMain = new SortDemoFrame();
                frameMain.setVisible(true);
                frameMain.setExtendedState(MAXIMIZED_BOTH);
            } catch (Exception ex) {
                SwingUtils.showErrorMessageBox(ex);
            }
        });
    }
}
