/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.dragdropdesign.common.util;

import java.awt.event.ActionEvent;

import javax.swing.JMenuItem;

import com.linet.api.swing.listener.menu.contextual.ContexMenuListener;
import com.rnasystems.projects.dragdropdesign.modelo.IceCommandButton;
import com.rnasystems.projects.util.ValidacionesUtil;

/**
 *
 * @author RM-RCM
 */
public class MenuContextualListenerIceCommandButton extends ContexMenuListener{

    public MenuContextualListenerIceCommandButton(IceCommandButton iceCommandButton, JMenuItem[] jMenuItems) {
        super(jMenuItems);
        this.iceCommandButton = iceCommandButton;
    }
    
        public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==jMenuItems[0]){
            System.out.println("texto");
            String txt = JDialogUtil.showCambiarTextoDialog(null,iceCommandButton);
            iceCommandButton.setText((txt==null)? "IceCommandButton":txt);
            
        }else if(e.getSource()==jMenuItems[1]){
            String[] resultado = JDialogUtil.showCambiarCoordenadasDialog(null,iceCommandButton);
            
            int x = ValidacionesUtil.parseStringToIntDefault(resultado[0],iceCommandButton.getX());
            int y = ValidacionesUtil.parseStringToIntDefault(resultado[1],iceCommandButton.getY());
            
            iceCommandButton.setCoordenadas(x, y);
            
            System.out.println("coordenadas");
        }else if(e.getSource()==jMenuItems[2]){
            
            String[] resultado = JDialogUtil.showCambiarDimensionDialog(null,iceCommandButton);
            
            int w = ValidacionesUtil.parseStringToIntDefault(resultado[0],iceCommandButton.getWidth());
            int h = ValidacionesUtil.parseStringToIntDefault(resultado[1],iceCommandButton.getHeight());
            
            iceCommandButton.setDimension(w, h);
            
            System.out.println("dimension");
        }else if(e.getSource()==jMenuItems[3]){
            System.out.println("propiedades");
        }
        
        
    }
    
    private IceCommandButton iceCommandButton;
}
