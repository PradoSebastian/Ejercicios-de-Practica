/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author prado
 */
public class ServidorGUI extends javax.swing.JFrame {
    
    /**
     * Creates new form ServidorGUI
     */
    public ServidorGUI() {
        initComponents();
        hacerInterfaz();
    }
    
    public void hacerInterfaz ()
    {
        this.setTitle("Servidor");
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.areaChat.setEditable(false);
    }
    
    public void actualizarChat(String msj)
    {
        this.areaChat.append("Cliente dice: "+msj+"\n");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedor_areaChat = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        areaChat = new javax.swing.JTextArea();
        contenedor_btnText = new javax.swing.JPanel();
        txt_mensaje = new javax.swing.JTextField();
        btn_enviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        areaChat.setColumns(20);
        areaChat.setRows(5);
        scroll.setViewportView(areaChat);

        javax.swing.GroupLayout contenedor_areaChatLayout = new javax.swing.GroupLayout(contenedor_areaChat);
        contenedor_areaChat.setLayout(contenedor_areaChatLayout);
        contenedor_areaChatLayout.setHorizontalGroup(
            contenedor_areaChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll)
        );
        contenedor_areaChatLayout.setVerticalGroup(
            contenedor_areaChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedor_areaChatLayout.createSequentialGroup()
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addContainerGap())
        );

        txt_mensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_mensajeActionPerformed(evt);
            }
        });

        btn_enviar.setText("Enviar");
        btn_enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contenedor_btnTextLayout = new javax.swing.GroupLayout(contenedor_btnText);
        contenedor_btnText.setLayout(contenedor_btnTextLayout);
        contenedor_btnTextLayout.setHorizontalGroup(
            contenedor_btnTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedor_btnTextLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(txt_mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btn_enviar)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        contenedor_btnTextLayout.setVerticalGroup(
            contenedor_btnTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedor_btnTextLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(contenedor_btnTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_enviar))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor_areaChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(contenedor_btnText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(contenedor_areaChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contenedor_btnText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_mensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_mensajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_mensajeActionPerformed

    private void btn_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enviarActionPerformed
        
    }//GEN-LAST:event_btn_enviarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaChat;
    private javax.swing.JButton btn_enviar;
    private javax.swing.JPanel contenedor_areaChat;
    private javax.swing.JPanel contenedor_btnText;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextField txt_mensaje;
    // End of variables declaration//GEN-END:variables

    public JTextArea getAreaChat() {
        return areaChat;
    }

    public JButton getBtn_enviar() {
        return btn_enviar;
    }

    public JPanel getContenedor_areaChat() {
        return contenedor_areaChat;
    }

    public JPanel getContenedor_btnText() {
        return contenedor_btnText;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public JTextField getTxt_mensaje() {
        return txt_mensaje;
    }
    
    

}
