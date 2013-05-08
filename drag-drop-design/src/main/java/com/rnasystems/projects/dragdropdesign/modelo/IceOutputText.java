/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rnasystems.projects.dragdropdesign.modelo;

import javax.swing.JLabel;

import com.linet.api.swing.component.dragdrop.DragDropComponent;

/**
 *
 * @author RM-RCMJ
 */
public class IceOutputText extends DragDropComponent {




   private String texto;

    public String getText() {
        return texto;
    }

    public void setText(String texto) {
        this.texto = texto;
        JLabel jLabel = (JLabel) getComponent();
        jLabel.setText(this.texto);
    }

   

}
