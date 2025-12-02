/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.example;

import javax.swing.JOptionPane;

public class FormPengisianPanel extends javax.swing.JPanel {

    private MataKuliah mataKuliah;
    private PilihKuisionerPanel parentPanel;
    private java.awt.Image backgroundImage;
    // Button groups will be allocated dynamically based on loaded questions
    private javax.swing.ButtonGroup[] questionGroups = null;
    private javax.swing.JPanel mainContentPanel;
    private javax.swing.JScrollPane mainScrollPane;
    
    public FormPengisianPanel() {
        initComponents();
        loadBackground();
        setupContent();
    }

    public FormPengisianPanel(MataKuliah mk, PilihKuisionerPanel parent) {
        initComponents();
        loadBackground();
        setupContent();
        this.mataKuliah = mk;
        this.parentPanel = parent;
        loadMataKuliahData();
    }
    
    private void loadBackground() {
        try {
            backgroundImage = new javax.swing.ImageIcon("assets/Background.png").getImage();
        } catch (Exception ex) {
            backgroundImage = null;
        }
    }
    
    private void setupContent() {
        // Set layout utama
        this.setLayout(new java.awt.BorderLayout());
        
        // Add header
        javax.swing.JPanel headerPanel = createHeaderPanel();
        this.add(headerPanel, java.awt.BorderLayout.NORTH);
        
        // Main content dengan scroll
        mainContentPanel = new javax.swing.JPanel();
        mainContentPanel.setLayout(new javax.swing.BoxLayout(mainContentPanel, javax.swing.BoxLayout.Y_AXIS));
        mainContentPanel.setOpaque(false);
        
        // Build content
        buildContent();
        
        mainScrollPane = new javax.swing.JScrollPane(mainContentPanel);
        mainScrollPane.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        mainScrollPane.setOpaque(false);
        mainScrollPane.getViewport().setOpaque(false);
        mainScrollPane.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        mainScrollPane.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        // Center panel untuk mengatur posisi card
        javax.swing.JPanel centerWrapper = new javax.swing.JPanel(new java.awt.BorderLayout());
        centerWrapper.setOpaque(false);
        centerWrapper.setBorder(new javax.swing.border.EmptyBorder(20, 40, 20, 40));
        centerWrapper.add(mainScrollPane, java.awt.BorderLayout.CENTER);
        this.add(centerWrapper, java.awt.BorderLayout.CENTER);
        
        // Add submit button
        javax.swing.JPanel submitPanel = createSubmitPanel();
        this.add(submitPanel, java.awt.BorderLayout.SOUTH);
    }
    
    private javax.swing.JPanel createHeaderPanel() {
        javax.swing.JPanel headerPanel = new javax.swing.JPanel();
        headerPanel.setLayout(new java.awt.BorderLayout());
        headerPanel.setPreferredSize(new java.awt.Dimension(10, 80));
        headerPanel.setBackground(java.awt.Color.decode("#334EAC"));

        javax.swing.JLabel headerTitle = new javax.swing.JLabel();
        headerTitle.setFont(new java.awt.Font("Segoe UI", 1, 20));
        headerTitle.setForeground(java.awt.Color.white);
        headerTitle.setText("KUISIONER PENILAIAN KINERJA DOSEN");
        headerTitle.setBorder(new javax.swing.border.EmptyBorder(8, 16, 8, 8));
        headerPanel.add(headerTitle, java.awt.BorderLayout.WEST);

        // Profile section on right
        javax.swing.JPanel profilePanel = new javax.swing.JPanel();
        profilePanel.setOpaque(false);
        profilePanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 8, 8));
        
        javax.swing.JLabel jLabelProfileImage = new javax.swing.JLabel();
        try {
            java.awt.Image img = new javax.swing.ImageIcon("assets/BackgroundLogin.png").getImage();
            java.awt.Image scaled = img.getScaledInstance(48, 48, java.awt.Image.SCALE_SMOOTH);
            jLabelProfileImage.setIcon(new javax.swing.ImageIcon(scaled));
        } catch (Exception ex) {
            // leave empty
        }
        
        javax.swing.JLabel jLabelProfileName = new javax.swing.JLabel();
        jLabelProfileName.setForeground(java.awt.Color.white);
        jLabelProfileName.setFont(new java.awt.Font("Georgia", 1, 12));
        jLabelProfileName.setText("Nama Mahasiswa");
        
        javax.swing.JLabel jLabelProfileNim = new javax.swing.JLabel();
        jLabelProfileNim.setForeground(java.awt.Color.white);
        jLabelProfileNim.setFont(new java.awt.Font("Georgia", 0, 11));
        jLabelProfileNim.setText("NIM: 00000000");

        javax.swing.JPanel profileText = new javax.swing.JPanel();
        profileText.setOpaque(false);
        profileText.setLayout(new javax.swing.BoxLayout(profileText, javax.swing.BoxLayout.Y_AXIS));
        profileText.add(jLabelProfileName);
        profileText.add(jLabelProfileNim);
        profilePanel.add(jLabelProfileImage);
        profilePanel.add(profileText);
        headerPanel.add(profilePanel, java.awt.BorderLayout.EAST);

        return headerPanel;
    }
    
    private javax.swing.JPanel createSubmitPanel() {
        btnSubmit.setPreferredSize(new java.awt.Dimension(140, 45));
        btnSubmit.setFont(new java.awt.Font("Georgia", 1, 14));
        javax.swing.JPanel submitPanel = new javax.swing.JPanel();
        submitPanel.setOpaque(false);
        submitPanel.setBorder(new javax.swing.border.EmptyBorder(20, 0, 20, 0));
        submitPanel.add(btnSubmit);
        return submitPanel;
    }
    
    private void buildContent() {
        // Add padding at top
        mainContentPanel.add(javax.swing.Box.createVerticalStrut(20));
        
        // Create main white card
        javax.swing.JPanel cardPanel = createCardPanel();
        mainContentPanel.add(cardPanel);
        
        // Add padding at bottom
        mainContentPanel.add(javax.swing.Box.createVerticalStrut(20));
    }
    
    private javax.swing.JPanel createCardPanel() {
        javax.swing.JPanel cardPanel = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                int arc = 28;
                int shadowSize = 8;
                java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
                g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
                // shadow
                g2.setColor(new java.awt.Color(0,0,0,60));
                g2.fillRoundRect(shadowSize, shadowSize, getWidth()-shadowSize*2, getHeight()-shadowSize*2, arc, arc);
                // main white panel
                g2.setColor(java.awt.Color.white);
                g2.fillRoundRect(0, 0, getWidth()-shadowSize, getHeight()-shadowSize, arc, arc);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        cardPanel.setOpaque(false);
        cardPanel.setLayout(new javax.swing.BoxLayout(cardPanel, javax.swing.BoxLayout.Y_AXIS));
        cardPanel.setBorder(new javax.swing.border.EmptyBorder(32, 32, 32, 32));
        
        // Set maximum width tapi tetap responsive
        cardPanel.setMaximumSize(new java.awt.Dimension(
            java.lang.Integer.MAX_VALUE, 
            java.lang.Integer.MAX_VALUE
        ));
        
        // Add title section
        addTitleSection(cardPanel);
        
        // Add instructions section
        addInstructionsSection(cardPanel);
        
        // Add course info section
        addCourseInfoSection(cardPanel);
        
        // Add questions section
        addQuestionsSection(cardPanel);
        
        return cardPanel;
    }
    
    private void addTitleSection(javax.swing.JPanel cardPanel) {
        javax.swing.JLabel titleBig = new javax.swing.JLabel("SELAMAT DATANG DI");
        titleBig.setFont(new java.awt.Font("Georgia", 0, 15));
        titleBig.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        
        javax.swing.JLabel titleBig2 = new javax.swing.JLabel("KUISIONER PENILAIAN KINERJA DOSEN");
        titleBig2.setFont(new java.awt.Font("Georgia", 1, 22));
        titleBig2.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);

        cardPanel.add(titleBig);
        cardPanel.add(javax.swing.Box.createVerticalStrut(4));
        cardPanel.add(titleBig2);
        cardPanel.add(javax.swing.Box.createVerticalStrut(24));
    }
    
    private void addInstructionsSection(javax.swing.JPanel cardPanel) {
        javax.swing.JTextArea instructionsText = new javax.swing.JTextArea();
        instructionsText.setColumns(20);
        instructionsText.setRows(5);
        // full instruction text (ensure not truncated)
        instructionsText.setText("Petunjuk Pengisian:\n\nBerikan penilaian Anda secara objektif terhadap kinerja dosen selama satu semester ini.\nPenilaian Anda bersifat anonim dan akan digunakan untuk perbaikan proses pembelajaran.\nPilih nilai pada skala 1-5 untuk setiap pernyataan, di mana 1 = Sangat Tidak Setuju dan 5 = Sangat Setuju.\nSetelah menyelesaikan semua pertanyaan, tekan tombol Submit untuk menyimpan penilaian.");
        instructionsText.setFont(new java.awt.Font("Georgia", 0, 12));
        instructionsText.setOpaque(false);
        instructionsText.setLineWrap(true);
        instructionsText.setWrapStyleWord(true);
        instructionsText.setEditable(false);
        instructionsText.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        
        javax.swing.JScrollPane instructionsScroll = new javax.swing.JScrollPane(instructionsText);
        instructionsScroll.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        instructionsScroll.setOpaque(false);
        instructionsScroll.getViewport().setOpaque(false);
        instructionsScroll.setMaximumSize(new java.awt.Dimension(
            java.lang.Integer.MAX_VALUE, 
            120
        ));
        
        cardPanel.add(instructionsScroll);
        cardPanel.add(javax.swing.Box.createVerticalStrut(24));
    }
    
    private void addCourseInfoSection(javax.swing.JPanel cardPanel) {
        javax.swing.JPanel infoRow = new javax.swing.JPanel(new java.awt.BorderLayout());
        infoRow.setOpaque(false);
        infoRow.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        
        javax.swing.JPanel infoGrid = new javax.swing.JPanel(new java.awt.GridLayout(2, 2, 12, 6));
        infoGrid.setOpaque(false);
        
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        jLabel4.setFont(new java.awt.Font("Georgia", 1, 12));
        jLabel4.setText("Mata Kuliah");
        
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        jLabel7.setFont(new java.awt.Font("Georgia", 1, 12));
        jLabel7.setText("Nama Dosen");
        
        LabelMataKuliah.setFont(new java.awt.Font("Georgia", 1, 12));
        LabelMataKuliah.setText(" ");
        
        LabelNamaDosen.setFont(new java.awt.Font("Georgia", 1, 12));
        LabelNamaDosen.setText(" ");
        
        infoGrid.add(jLabel4);
        infoGrid.add(LabelMataKuliah);
        infoGrid.add(jLabel7);
        infoGrid.add(LabelNamaDosen);
        
        infoRow.add(infoGrid, java.awt.BorderLayout.CENTER);
        cardPanel.add(infoRow);
        cardPanel.add(javax.swing.Box.createVerticalStrut(24));
    }
    
    private void addQuestionsSection(javax.swing.JPanel cardPanel) {
        String[] QUESTIONS = loadQuestions();
        // allocate groups to match number of loaded questions
        questionGroups = new javax.swing.ButtonGroup[QUESTIONS.length];

        String[] bagian = {
            "Bagian A: Kemampuan Pedagogi (Penyampaian Materi)",
            "Bagian B: Penguasaan Materi", 
            "Bagian C: Interaksi dan Motivasi",
            "Bagian D: Evaluasi dan Umpan Balik"
        };

        int qIndex = 0;
        for (int b = 0; b < bagian.length; b++) {
            javax.swing.JPanel panelBagian = new javax.swing.JPanel();
            panelBagian.setBorder(javax.swing.BorderFactory.createTitledBorder(bagian[b]));
            panelBagian.setLayout(new javax.swing.BoxLayout(panelBagian, javax.swing.BoxLayout.Y_AXIS));
            panelBagian.setOpaque(false);
            
            // Set agar panel bagian bisa melebar sesuai parent
            panelBagian.setMaximumSize(new java.awt.Dimension(
                java.lang.Integer.MAX_VALUE, 
                java.lang.Integer.MAX_VALUE
            ));

            // Each bagian contains up to 5 questions
            for (int i = 0; i < 5 && qIndex < QUESTIONS.length; i++) {
                javax.swing.JPanel qRow = new javax.swing.JPanel();
                qRow.setLayout(new java.awt.BorderLayout()); // Ganti ke BorderLayout
                qRow.setOpaque(false);
                
                javax.swing.JLabel qLabel = new javax.swing.JLabel(QUESTIONS[qIndex]);
                qLabel.setFont(new java.awt.Font("Georgia", 0, 12));
                qLabel.setBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 10));
                
                javax.swing.JPanel radioPanel = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
                radioPanel.setOpaque(false);
                
                javax.swing.ButtonGroup bg = new javax.swing.ButtonGroup();
                questionGroups[qIndex] = bg;
                for (int v = 1; v <= 5; v++) {
                    javax.swing.JRadioButton rb = new javax.swing.JRadioButton(String.valueOf(v));
                    rb.setActionCommand(String.valueOf(v));
                    rb.setFont(new java.awt.Font("Georgia", 0, 11));
                    bg.add(rb);
                    radioPanel.add(rb);
                }
                
                qRow.add(qLabel, java.awt.BorderLayout.CENTER);
                qRow.add(radioPanel, java.awt.BorderLayout.EAST);
                panelBagian.add(qRow);
                panelBagian.add(javax.swing.Box.createVerticalStrut(8));
                qIndex++;
            }

            cardPanel.add(panelBagian);
            if (b < bagian.length - 1) {
                cardPanel.add(javax.swing.Box.createVerticalStrut(16));
            }
        }
    }
    
    private void loadMataKuliahData() {
        if (mataKuliah != null) {
            LabelMataKuliah.setText(mataKuliah.getNamaMataKuliah());
            LabelNamaDosen.setText("NOVERI LYSBETTI M, S.T., M.Sc");
        }
    }
    
    private int getNilaiPertanyaan() {
        // deprecated single-question getter; keep for compatibility
        return 0;
    }
    
    private void navigateBack() {
        MainJFrame mainFrame = (MainJFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        if (mainFrame != null && parentPanel != null) {
            mainFrame.changePanel(parentPanel);
        }
    }

    public void submitPenilaian() {
        int nQuestions = (questionGroups == null) ? 0 : questionGroups.length;
        if (nQuestions == 0) {
            JOptionPane.showMessageDialog(this,
                    "Tidak ada pertanyaan yang dimuat, submit dibatalkan.",
                    "Peringatan",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int[] values = new int[nQuestions];
        int total = 0;
        for (int i = 0; i < nQuestions; i++) {
            javax.swing.ButtonGroup bg = questionGroups[i];
            if (bg == null || bg.getSelection() == null) {
                JOptionPane.showMessageDialog(this,
                        "Mohon isi semua pertanyaan sebelum submit (kosong: " + (i+1) + ")",
                        "Peringatan",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            int val = Integer.parseInt(bg.getSelection().getActionCommand());
            values[i] = val;
            total += val;
        }

        double rata = total / (double) nQuestions;

        if (mataKuliah != null) {
            mataKuliah.setSudahDiisi(true);

            JOptionPane.showMessageDialog(this,
                    "Penilaian berhasil disimpan!\n" +
                            "Mata Kuliah: " + mataKuliah.getNamaMataKuliah() + "\n" +
                            "Rata-rata nilai: " + String.format("%.2f", rata),
                    "Berhasil",
                    JOptionPane.INFORMATION_MESSAGE);

            if (parentPanel != null) {
                parentPanel.refreshTable();
            }

            navigateBack();
        }
    }

    // Try to load questions from classpath resource (/com/example/questions.txt) or from
    // project resource file demo/src/main/resources/com/example/questions.txt or from
    // working directory questions.txt. If none found, return the default list.
    private String[] loadQuestions() {
        java.util.List<String> lines = new java.util.ArrayList<>();
        // 1) try classpath resource (package path)
        try (java.io.InputStream is = getClass().getResourceAsStream("/com/example/questions.txt")) {
            if (is != null) {
                try (java.io.BufferedReader r = new java.io.BufferedReader(new java.io.InputStreamReader(is))) {
                    String ln;
                    while ((ln = r.readLine()) != null) {
                        ln = ln.trim();
                        if (!ln.isEmpty()) lines.add(ln);
                    }
                }
            }
        } catch (Exception ex) {
            // ignore and try file system
        }

        // 2) try project resource path
        if (lines.isEmpty()) {
            java.io.File f = new java.io.File("demo/src/main/resources/com/example/questions.txt");
            if (!f.exists()) f = new java.io.File("questions.txt");
            if (f.exists()) {
                try (java.io.BufferedReader r = new java.io.BufferedReader(new java.io.FileReader(f))) {
                    String ln;
                    while ((ln = r.readLine()) != null) {
                        ln = ln.trim();
                        if (!ln.isEmpty()) lines.add(ln);
                    }
                } catch (Exception ex) {
                    // ignore
                }
            }
        }

        if (!lines.isEmpty()) {
            return lines.toArray(new String[0]);
        }

        // fallback default questions (20)
        return new String[] {
            "1. Dosen menjelaskan tujuan perkuliahan secara jelas.",
            "2. Dosen mampu membuat materi yang kompleks menjadi mudah dipahami.",
            "3. Dosen menggunakan metode pengajaran secara bervariasi dan menarik.",
            "4. Dosen memanfaatkan media atau teknologi pembelajaran dengan efektif.",
            "5. Dosen mampu menciptakan suasana kelas yang kondusif untuk belajar.",
            "6. Dosen menguasai materi perkuliahan dengan baik.",
            "7. Dosen mampu menjawab pertanyaan mahasiswa dengan jelas.",
            "8. Dosen mengaitkan teori dengan aplikasi praktis.",
            "9. Dosen memperbarui materi sesuai perkembangan keilmuan.",
            "10. Dosen menunjukkan kompetensi akademik yang memadai.",
            "11. Dosen mendorong partisipasi aktif mahasiswa.",
            "12. Dosen memberikan umpan balik yang konstruktif.",
            "13. Dosen bersikap adil terhadap semua mahasiswa.",
            "14. Dosen menciptakan suasana kelas yang kondusif.",
            "15. Dosen memotivasi mahasiswa untuk berpikir kritis.",
            "16. Dosen menggunakan evaluasi yang sesuai untuk mengukur capaian.",
            "17. Dosen memberikan penjelasan tentang kriteria penilaian.",
            "18. Dosen menindaklanjuti hasil evaluasi dengan umpan balik.",
            "19. Dosen menyediakan sumber belajar tambahan.",
            "20. Dosen mengintegrasikan teknologi dengan pembelajaran."
        };
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelMataKuliah = new javax.swing.JLabel();
        LabelNamaDosen = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
    }// </editor-fold>//GEN-END:initComponents
    
    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
    
    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        submitPenilaian();
    }//GEN-LAST:event_btnSubmitActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelMataKuliah;
    private javax.swing.JLabel LabelNamaDosen;
    private javax.swing.JButton btnSubmit;
    // End of variables declaration//GEN-END:variables
}