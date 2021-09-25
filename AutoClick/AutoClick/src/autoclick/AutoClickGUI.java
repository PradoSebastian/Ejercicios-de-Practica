/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoclick;

import java.awt.Color;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.KeyEvent;
import java.net.URI;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author prado
 */
public class AutoClickGUI extends javax.swing.JFrame {

    
    
    /**
     * Creates new form AutoClick
     */
    public AutoClickGUI() {
        initComponents();
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocationRelativeTo(null);
        this.Campo_X.setFocusable(false);
        this.Campo_Y.setFocusable(false);
        this.Btn_instrucciones.setFocusable(false);
        this.btn_chrome.setFocusable(false);
        this.btn_link_base.setFocusable(false);
        this.Campo_X.setEditable(false);
        this.Campo_Y.setEditable(false);
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("AutoClick");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popup = new java.awt.PopupMenu();
        abrir = new java.awt.MenuItem();
        cerrar = new java.awt.MenuItem();
        y_label = new javax.swing.JLabel();
        x_label = new javax.swing.JLabel();
        Label_cX = new javax.swing.JLabel();
        Label_cY = new javax.swing.JLabel();
        Campo_Y = new javax.swing.JTextField();
        Campo_X = new javax.swing.JTextField();
        Btn_instrucciones = new javax.swing.JButton();
        btn_link_base = new javax.swing.JButton();
        btn_chrome = new javax.swing.JButton();

        popup.setLabel("popupMenu1");
        popup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popupActionPerformed(evt);
            }
        });

        abrir.setLabel("Abrir App");
        abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirActionPerformed(evt);
            }
        });
        popup.add(abrir);

        cerrar.setLabel("Cerrar App");
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });
        popup.add(cerrar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        y_label.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        y_label.setText("Y");

        x_label.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        x_label.setText("X");

        Label_cX.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Label_cX.setText("Coordenada X");

        Label_cY.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Label_cY.setText("Coordenada Y");

        Campo_Y.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        Campo_X.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        Btn_instrucciones.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Btn_instrucciones.setText("Instrucciones");
        Btn_instrucciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_instruccionesActionPerformed(evt);
            }
        });

        btn_link_base.setText("Link Base");
        btn_link_base.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_link_baseActionPerformed(evt);
            }
        });

        btn_chrome.setText("Abrir Chrome");
        btn_chrome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chromeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(y_label, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Campo_Y, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_link_base)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Label_cX)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_chrome))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Campo_X, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Label_cY))
                                .addGap(46, 46, 46)
                                .addComponent(Btn_instrucciones, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(73, 73, 73)
                    .addComponent(x_label, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(434, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_cX)
                    .addComponent(btn_chrome))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Campo_X, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(Label_cY))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(Btn_instrucciones, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(y_label, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Campo_Y, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_link_base)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(62, 62, 62)
                    .addComponent(x_label, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(160, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
       
    }//GEN-LAST:event_formKeyPressed

    private void Btn_instruccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_instruccionesActionPerformed
        
    }//GEN-LAST:event_Btn_instruccionesActionPerformed

    private void btn_link_baseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_link_baseActionPerformed
        
        if(java.awt.Desktop.isDesktopSupported())
        {
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
            
            if(desktop.isSupported(java.awt.Desktop.Action.BROWSE))
            {
                try 
                {
                    java.net.URI url = new java.net.URI("https://www.youtube.com/watch?v=8c2btF-a4l0");
                    desktop.browse(url);
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
            }
            
        }
        
    }//GEN-LAST:event_btn_link_baseActionPerformed

    private void popupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_popupActionPerformed

    private void abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirActionPerformed
        
    }//GEN-LAST:event_abrirActionPerformed

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_cerrarActionPerformed

    private void btn_chromeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chromeActionPerformed
        Runtime objrun = Runtime.getRuntime();
        
        try 
        {
            objrun.exec("\"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe\"");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_btn_chromeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_instrucciones;
    private javax.swing.JTextField Campo_X;
    private javax.swing.JTextField Campo_Y;
    private javax.swing.JLabel Label_cX;
    private javax.swing.JLabel Label_cY;
    private java.awt.MenuItem abrir;
    private javax.swing.JButton btn_chrome;
    private javax.swing.JButton btn_link_base;
    private java.awt.MenuItem cerrar;
    private java.awt.PopupMenu popup;
    private javax.swing.JLabel x_label;
    private javax.swing.JLabel y_label;
    // End of variables declaration//GEN-END:variables

    public JButton getBtn_instrucciones() {
        return Btn_instrucciones;
    }

    public JTextField getCampo_X() {
        return Campo_X;
    }

    public JTextField getCampo_Y() {
        return Campo_Y;
    }

    public JLabel getLabel_cX() {
        return Label_cX;
    }

    public JLabel getLabel_cY() {
        return Label_cY;
    }

    public JLabel getX_label() {
        return x_label;
    }

    public JLabel getY_label() {
        return y_label;
    }

    public MenuItem getAbrir() {
        return abrir;
    }

    public JButton getBtn_link_base() {
        return btn_link_base;
    }

    public PopupMenu getPopup() {
        return popup;
    }

    
}