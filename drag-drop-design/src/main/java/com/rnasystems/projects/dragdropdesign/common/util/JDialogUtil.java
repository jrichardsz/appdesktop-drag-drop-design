/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.dragdropdesign.common.util;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.linet.api.swing.component.dragdrop.DragDropComponent;
import com.rnasystems.projects.dragdropdesign.modelo.IcePanelGrid;

/**
 *
 * @author RM-RCM
 */
public class JDialogUtil {

    public static String showCambiarTextoDialog(Component component,DragDropComponent componenteIcefaces) {
        //String seleccion = JOptionPane.showInputDialog(component, "Cambiar", "Texto", JOptionPane.QUESTION_MESSAGE);
        String seleccion = JOptionPane.showInputDialog(component, "Cambiar Texto",componenteIcefaces.getText());
        return seleccion;
    }

    public static String[] showCambiarCoordenadasDialog(Component component,DragDropComponent componenteIcefaces) {

        JPanel panel = new JPanel();

        javax.swing.JLabel jLabelx;
        javax.swing.JLabel jLabely;
        javax.swing.JTextField jTextFieldx;
        javax.swing.JTextField jTextFieldy;

        jLabelx = new javax.swing.JLabel();
        jTextFieldx = new javax.swing.JTextField();
        jTextFieldy = new javax.swing.JTextField();
        
        jTextFieldx.setText(""+componenteIcefaces.getX());
        jTextFieldy.setText(""+componenteIcefaces.getY());
        
        jLabely = new javax.swing.JLabel();
        
        jLabelx.setText("x:");
        jLabely.setText("y:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(panel);
        panel.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabelx).addGap(18, 18, 18).addComponent(jTextFieldx, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE).addComponent(jLabely).addGap(18, 18, 18).addComponent(jTextFieldy, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabelx).addComponent(jTextFieldx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabely).addComponent(jTextFieldy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        // display the jpanel in a joptionpane dialog, using showMessageDialog
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, panel);

        String x = jTextFieldx.getText();
        String y = jTextFieldy.getText();
        
        String[] resultado = {x,y};

        return resultado;
    }
    
    public static String[] showCambiarDimensionDialog(Component component,DragDropComponent componenteIcefaces) {

        JPanel panel = new JPanel();

        javax.swing.JLabel jLabelw;
        javax.swing.JLabel jLabelh;
        javax.swing.JTextField jTextFieldw;
        javax.swing.JTextField jTextFieldh;

        jLabelw = new javax.swing.JLabel();
        jTextFieldw = new javax.swing.JTextField();
        jTextFieldh = new javax.swing.JTextField();
        
        jTextFieldw.setText(""+componenteIcefaces.getWidth());
        jTextFieldh.setText(""+componenteIcefaces.getHeight());
        
        jLabelh = new javax.swing.JLabel();
        
        jLabelw.setText("w:");
        jLabelh.setText("h:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(panel);
        panel.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabelw).addGap(18, 18, 18).addComponent(jTextFieldw, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE).addComponent(jLabelh).addGap(18, 18, 18).addComponent(jTextFieldh, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabelw).addComponent(jTextFieldw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabelh).addComponent(jTextFieldh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        // display the jpanel in a joptionpane dialog, using showMessageDialog
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, panel);

        String w = jTextFieldw.getText();
        String h = jTextFieldh.getText();
        
        String[] resultado = {w,h};

        return resultado;
    }    
    
    public static String[] showCambiarFilasColumnasDialog(Component component,DragDropComponent componenteIcefaces) {

        JPanel panel = new JPanel();

        javax.swing.JLabel jLabelw;
        javax.swing.JLabel jLabelh;
        javax.swing.JTextField jTextFieldw;
        javax.swing.JTextField jTextFieldh;

        jLabelw = new javax.swing.JLabel();
        jTextFieldw = new javax.swing.JTextField();
        jTextFieldh = new javax.swing.JTextField();
        
        jTextFieldw.setText(""+((IcePanelGrid)componenteIcefaces).getRows());
        jTextFieldh.setText(""+((IcePanelGrid)componenteIcefaces).getCols());
        
        jLabelh = new javax.swing.JLabel();
        
        jLabelw.setText("Filas:");
        jLabelh.setText("Columnas:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(panel);
        panel.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabelw).addGap(18, 18, 18).addComponent(jTextFieldw, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE).addComponent(jLabelh).addGap(18, 18, 18).addComponent(jTextFieldh, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabelw).addComponent(jTextFieldw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabelh).addComponent(jTextFieldh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        // display the jpanel in a joptionpane dialog, using showMessageDialog
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, panel);

        String f = jTextFieldw.getText();
        String c = jTextFieldh.getText();
        
        String[] resultado = {f,c};

        return resultado;
    }        
    
    
    public static String showCambiarLayoutDialog(Component component,DragDropComponent componenteIcefaces) {
       
        IcePanelGrid icePanelGrid = (IcePanelGrid) componenteIcefaces;
        Object[] possibleValues = {"Free Design", "Grilla"};
        Object selectedValue = JOptionPane.showInputDialog(null,"Layout", "Seleccione tipo de layout",JOptionPane.INFORMATION_MESSAGE, null,possibleValues, possibleValues[icePanelGrid.getLayout()]);
            
            return ""+selectedValue;
                    
    }    
    
    
    /*
     
     JOptionPane.showMessageDialog(null,"Your","TITLE", ipList, JOptionPane.PLAIN_MESSAGE);
     */
}
