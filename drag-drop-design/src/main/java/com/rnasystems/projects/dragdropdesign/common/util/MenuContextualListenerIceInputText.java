/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.dragdropdesign.common.util;

import java.awt.event.ActionEvent;

import javax.swing.JMenuItem;

import com.linet.api.swing.listener.menu.contextual.ContexMenuListener;
import com.rnasystems.projects.dragdropdesign.modelo.IceInputText;
import com.rnasystems.projects.util.ValidacionesUtil;

/**
 *
 * @author RM-RCM
 */
public class MenuContextualListenerIceInputText extends ContexMenuListener {

    public MenuContextualListenerIceInputText(IceInputText iceInputText, JMenuItem[] jMenuItems) {
        super(jMenuItems);
        this.iceInputText = iceInputText;
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==jMenuItems[0]){
            System.out.println("texto");
            String txt = JDialogUtil.showCambiarTextoDialog(null,iceInputText);
            iceInputText.setText((txt==null)? "iceInputText":txt);
            
        }else if(e.getSource()==jMenuItems[1]){
            String[] resultado = JDialogUtil.showCambiarCoordenadasDialog(null,iceInputText);
            
            int x = ValidacionesUtil.parseStringToIntDefault(resultado[0],iceInputText.getX());
            int y = ValidacionesUtil.parseStringToIntDefault(resultado[1],iceInputText.getY());
            
            iceInputText.setCoordenadas(x, y);
            
            System.out.println("coordenadas");
        }else if(e.getSource()==jMenuItems[2]){
            
            String[] resultado = JDialogUtil.showCambiarDimensionDialog(null,iceInputText);
            
            int w = ValidacionesUtil.parseStringToIntDefault(resultado[0],iceInputText.getWidth());
            int h = ValidacionesUtil.parseStringToIntDefault(resultado[1],iceInputText.getHeight());
            
            iceInputText.setDimension(w, h);
            
            System.out.println("dimension");
        }else if(e.getSource()==jMenuItems[3]){
            System.out.println("propiedades");
        }


    }
    private IceInputText iceInputText;
}
