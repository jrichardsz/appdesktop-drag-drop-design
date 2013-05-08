/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelCodigo.java
 *
 * Created on 10-sep-2011, 12:47:28
 */

package com.rnasystems.projects.dragdropdesign.vista.nuevoProyecto.codigo;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import com.rnasystems.projects.dragdropdesign.controlador.panelCodigo.CPanelCodigo;
import com.rnasystems.projects.dragdropdesign.controlador.panelCodigo.CPanelCodigoIcefaces;
import com.rnasystems.projects.dragdropdesign.vista.util.VistaUtil;

/**
 *
 * @author RM-RCMJ
 */
public class PanelCodigo extends javax.swing.JPanel {

    /** Creates new form PanelCodigo */
    public PanelCodigo() {
        initComponents();
        new CPanelCodigo(this);
        //new CPanelCodigoIcefaces(this);
        setBoundsComponentes();
    }

    public void setBoundsComponentes(){
        setLayout(null);
        setBoundsJButtonActualizar();
        setBoundsJTextAreaCodigo();
    }

    public void setBoundsJButtonActualizar(){
        jButtonActualizar.setBounds(VistaUtil.X_BUTTON_ACTUALIZAR,VistaUtil.Y_BUTTON_ACTUALIZAR,VistaUtil.WIDHT_BUTTON_ACTUALIZAR,VistaUtil.HEIGHT_BUTTON_ACTUALIZAR);
    }

    public void setBoundsJTextAreaCodigo(){
        jScrollPane1.setBounds(VistaUtil.X_TEXT_CODIGO,VistaUtil.Y_TEXT_CODIGO,VistaUtil.WIDHT_TEXT_CODIGO,VistaUtil.HEIGHT_TEXT_CODIGO);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaCodigo = new javax.swing.JTextArea();
        jButtonActualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxModo = new javax.swing.JComboBox();

        jTextAreaCodigo.setColumns(20);
        jTextAreaCodigo.setRows(5);
        jScrollPane1.setViewportView(jTextAreaCodigo);

        jButtonActualizar.setText("Actualizar");

        jLabel1.setText("Seleccione modo:");

        jComboBoxModo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Div Html          -> Position: Relative Absolute", "IcePanelGrid   -> Position: Relative Absolute", "IcePanelGrid   -> Cols Rows" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 847, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonActualizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxModo, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxModo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );
    }// </editor-fold>//GEN-END:initComponents

    public JButton getjButtonActualizar() {
        return jButtonActualizar;
    }

    public void setjButtonActualizar(JButton jButtonActualizar) {
        this.jButtonActualizar = jButtonActualizar;
    }

    public JTextArea getjTextAreaCodigo() {
        return jTextAreaCodigo;
    }

    public void setjTextAreaCodigo(JTextArea jTextAreaCodigo) {
        this.jTextAreaCodigo = jTextAreaCodigo;
    }

    public JComboBox getjComboBoxModo() {
        return jComboBoxModo;
    }

    public void setjComboBoxModo(JComboBox jComboBoxModo) {
        this.jComboBoxModo = jComboBoxModo;
    }




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JComboBox jComboBoxModo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaCodigo;
    // End of variables declaration//GEN-END:variables

}