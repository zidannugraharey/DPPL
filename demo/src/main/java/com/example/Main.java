package com.example;

// Program ini dibuat oleh kelompok 2

import javax.swing.JFrame;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        // Run Swing UI on Event Dispatch Thread
        java.awt.EventQueue.invokeLater(() -> {
            try {
                // Set look and feel
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                
                LoginPageFrame frame = new LoginPageFrame();
                frame.setTitle("SISTEM PENILAIAN KINERJA DOSEN");
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Fullscreen
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}