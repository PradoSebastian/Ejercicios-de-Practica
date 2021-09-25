/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robot;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author prado
 */
public class RobotGUI extends javax.swing.JFrame {

    /**
     * Creates new form RobotGUI
     */
    public RobotGUI() {
        initComponents();
        iniciar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        panelPrueba = new javax.swing.JPanel();
        tituloP = new javax.swing.JLabel();
        btn_IP = new javax.swing.JButton();
        btn_PI = new javax.swing.JButton();
        btn_PT = new javax.swing.JButton();
        panelAvanz = new javax.swing.JPanel();
        tituloA = new javax.swing.JLabel();
        btn_IA = new javax.swing.JButton();
        btn_A = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo.setFont(new java.awt.Font("Viner Hand ITC", 3, 36)); // NOI18N
        titulo.setText("ROBOT");

        panelPrueba.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));

        tituloP.setFont(new java.awt.Font("Viner Hand ITC", 3, 14)); // NOI18N
        tituloP.setText("Versión Básica");

        btn_IP.setText("Más Información");

        btn_PT.setFont(new java.awt.Font("Viner Hand ITC", 2, 18)); // NOI18N
        btn_PT.setText("Intentar");
        btn_PT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPruebaLayout = new javax.swing.GroupLayout(panelPrueba);
        panelPrueba.setLayout(panelPruebaLayout);
        panelPruebaLayout.setHorizontalGroup(
            panelPruebaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPruebaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_IP)
                .addGap(20, 20, 20))
            .addGroup(panelPruebaLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btn_PI, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btn_PT, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        panelPruebaLayout.setVerticalGroup(
            panelPruebaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPruebaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPruebaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloP, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_IP))
                .addGap(18, 18, 18)
                .addGroup(panelPruebaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_PI, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(btn_PT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        panelAvanz.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));

        tituloA.setFont(new java.awt.Font("Viner Hand ITC", 3, 14)); // NOI18N
        tituloA.setText("Versión Avanzada");

        btn_IA.setText("Más Información");

        btn_A.setBackground(new java.awt.Color(255, 255, 255));
        btn_A.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flecha.png"))); // NOI18N
        btn_A.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAvanzLayout = new javax.swing.GroupLayout(panelAvanz);
        panelAvanz.setLayout(panelAvanzLayout);
        panelAvanzLayout.setHorizontalGroup(
            panelAvanzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAvanzLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloA, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btn_A, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(btn_IA)
                .addGap(18, 18, 18))
        );
        panelAvanzLayout.setVerticalGroup(
            panelAvanzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAvanzLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAvanzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAvanzLayout.createSequentialGroup()
                        .addGroup(panelAvanzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tituloA)
                            .addComponent(btn_IA))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_A, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(panelPrueba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(311, 311, 311))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(panelAvanz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(154, 154, 154))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPrueba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAvanz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_PTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PTActionPerformed
        this.setVisible(false);
        this.bIGUI.setVisible(true);
    }//GEN-LAST:event_btn_PTActionPerformed

    private void btn_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AActionPerformed
        this.setVisible(false);
        this.aGUI.setVisible(true);
    }//GEN-LAST:event_btn_AActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_A;
    private javax.swing.JButton btn_IA;
    private javax.swing.JButton btn_IP;
    private javax.swing.JButton btn_PI;
    private javax.swing.JButton btn_PT;
    private javax.swing.JPanel panelAvanz;
    private javax.swing.JPanel panelPrueba;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel tituloA;
    private javax.swing.JLabel tituloP;
    // End of variables declaration//GEN-END:variables
    
    private AvanzadaGUI aGUI;
    private BasicaIntetoGUI bIGUI;
    
    public void iniciar()
    {
        this.aGUI = new AvanzadaGUI();
        this.bIGUI = new BasicaIntetoGUI();
        this.getContentPane().setBackground(Color.WHITE);
        this.setTitle("Robot");
        this.setLocationRelativeTo(null);        
        this.setVisible(false);
        
        this.panelAvanz.setBackground(Color.WHITE);
        this.panelPrueba.setBackground(Color.WHITE);
    }
    
    public JButton getBtn_A() {
        return btn_A;
    }

    public JButton getBtn_IA() {
        return btn_IA;
    }

    public JButton getBtn_IP() {
        return btn_IP;
    }

    public JButton getBtn_PI() {
        return btn_PI;
    }

    public JButton getBtn_PT() {
        return btn_PT;
    }

    public JPanel getPanelAvanz() {
        return panelAvanz;
    }

    public JPanel getPanelPrueba() {
        return panelPrueba;
    }

    public JLabel getTitulo() {
        return titulo;
    }

    public JLabel getTituloA() {
        return tituloA;
    }

    public JLabel getTituloP() {
        return tituloP;
    }

    public AvanzadaGUI getaGUI() {
        return aGUI;
    }

    public BasicaIntetoGUI getbIGUI() {
        return bIGUI;
    }
    
    
    

}