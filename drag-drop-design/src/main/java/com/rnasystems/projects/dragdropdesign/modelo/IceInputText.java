/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rnasystems.projects.dragdropdesign.modelo;

import javax.swing.JTextField;

import com.linet.api.swing.component.dragdrop.DragDropComponent;

/**
 *
 * @author RM-RCMJ
 */
public class IceInputText extends DragDropComponent {




   private String texto;

    public String getText() {
        return texto;
    }

    public void setText(String texto) {
        this.texto = texto;
        JTextField jTextField = (JTextField) getComponent();
        jTextField.setText(this.texto);
    }

   

}
