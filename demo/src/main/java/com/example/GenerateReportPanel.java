package com.example;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GenerateReportPanel extends JPanel {

    public GenerateReportPanel(List<MataKuliah> daftarMataKuliah) {
        setLayout(new BorderLayout());
        setBackground(new Color(245, 246, 250));

        JLabel title = new JLabel("Laporan Kuisioner");
        title.setFont(new Font("Georgia", Font.BOLD, 18));
        title.setBorder(new javax.swing.border.EmptyBorder(12, 12, 12, 12));
        add(title, BorderLayout.NORTH);

        JTextArea reportArea = new JTextArea();
        reportArea.setEditable(false);
        reportArea.setFont(new Font("Georgia", Font.PLAIN, 13));
        StringBuilder sb = new StringBuilder();
        sb.append("Ringkasan Mata Kuliah:\n\n");
        int filled = 0;
        for (MataKuliah mk : daftarMataKuliah) {
            sb.append(String.format("%d. %s - %s\n", mk.getNo(), mk.getNamaMataKuliah(), mk.getStatusText()));
            if (mk.isSudahDiisi()) filled++;
        }
        sb.append("\nTotal mata kuliah: ").append(daftarMataKuliah.size());
        sb.append("\nTerisi: ").append(filled);
        reportArea.setText(sb.toString());

        JScrollPane sp = new JScrollPane(reportArea);
        add(sp, BorderLayout.CENTER);

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottom.setOpaque(false);

        JButton backBtn = new JButton("Kembali");
        backBtn.addActionListener(e -> {
            MainJFrame mainFrame = (MainJFrame) SwingUtilities.getWindowAncestor(this);
            if (mainFrame != null) {
                mainFrame.showPilihKuisionerPanel();
            }
        });
        bottom.add(backBtn);

        JButton exportBtn = new JButton("Generate Laporan");
        exportBtn.addActionListener(e -> {
            // Placeholder: implement export (PDF/CSV) here as needed.
            JOptionPane.showMessageDialog(this, "Generate laporan: fitur ekspor belum diimplementasikan.", "Info", JOptionPane.INFORMATION_MESSAGE);
        });
        bottom.add(exportBtn);

        add(bottom, BorderLayout.SOUTH);
    }
}