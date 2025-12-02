package com.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class GenerateReportPanel extends JPanel {

    public GenerateReportPanel(List<MataKuliah> daftarMataKuliah) {
        setLayout(new BorderLayout());
        setBackground(new Color(245, 246, 250));

        // --- HEADER ---
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.decode("#334EAC"));
        headerPanel.setPreferredSize(new Dimension(10, 80));
        
        JLabel title = new JLabel("Laporan Kuisioner");
        title.setFont(new Font("Georgia", Font.BOLD, 22));
        title.setForeground(Color.WHITE);
        title.setBorder(new javax.swing.border.EmptyBorder(8, 16, 8, 8));
        headerPanel.add(title, BorderLayout.WEST);
        add(headerPanel, BorderLayout.NORTH);

        // --- MAIN CONTENT ---
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBorder(new javax.swing.border.EmptyBorder(40, 60, 40, 60));
        contentPanel.setOpaque(false);
        
        // White card
        JPanel card = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int arc = 20;
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.WHITE);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);
                g2.dispose();
            }
        };
        card.setLayout(new BorderLayout());
        card.setBorder(new javax.swing.border.EmptyBorder(32, 32, 32, 32));
        
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
        sp.setBorder(BorderFactory.createEmptyBorder());
        card.add(sp, BorderLayout.CENTER);
        
        contentPanel.add(card, BorderLayout.CENTER);
        add(contentPanel, BorderLayout.CENTER);

        // --- FOOTER ---
        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setOpaque(false);
        bottom.setBorder(new javax.swing.border.EmptyBorder(12, 20, 20, 20));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setOpaque(false);
        
        JButton backBtn = new JButton("Kembali");
        backBtn.setPreferredSize(new Dimension(100, 35));
        backBtn.addActionListener(e -> {
            MainJFrame mainFrame = (MainJFrame) SwingUtilities.getWindowAncestor(this);
            if (mainFrame != null) {
                mainFrame.showPilihKuisionerPanel();
            }
        });
        buttonPanel.add(backBtn);

        JButton exportBtn = new JButton("Generate Laporan");
        exportBtn.setPreferredSize(new Dimension(140, 35));
        exportBtn.addActionListener(e -> {
            // Placeholder: implement export (PDF/CSV) here as needed.
            JOptionPane.showMessageDialog(this, "Generate laporan: fitur ekspor belum diimplementasikan.", "Info", JOptionPane.INFORMATION_MESSAGE);
        });
        buttonPanel.add(exportBtn);
        
        bottom.add(buttonPanel, BorderLayout.EAST);
        add(bottom, BorderLayout.SOUTH);
    }
}