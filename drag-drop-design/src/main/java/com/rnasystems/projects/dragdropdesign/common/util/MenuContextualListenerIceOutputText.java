/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.dragdropdesign.common.util;

import java.awt.event.ActionEvent;

import javax.swing.JMenuItem;

import com.linet.api.swing.listener.menu.contextual.ContexMenuListener;
import com.rnasystems.projects.dragdropdesign.modelo.IceOutputText;
import com.rnasystems.projects.util.ValidacionesUtil;

/**
 *
 * @author RM-RCM
 */
public class MenuContextualListenerIceOutputText extends ContexMenuListener {

    public MenuContextualListenerIceOutputText(IceOutputText iceOutputText, JMenuItem[] jMenuItems) {
        super(jMenuItems);
        this.iceOutputText = iceOutputText;
    }

    public void actionPerformed(ActionEvent e) {

       if(e.getSource()==jMenuItems[0]){
            System.out.println("texto");
            String txt = JDialogUtil.showCambiarTextoDialog(null,iceOutputText);
            iceOutputText.setText((txt==null)? "iceOutputText":txt);
            
        }else if(e.getSource()==jMenuItems[1]){
            String[] resultado = JDialogUtil.showCambiarCoordenadasDialog(null,iceOutputText);
            
            int x = ValidacionesUtil.parseStringToIntDefault(resultado[0],iceOutputText.getX());
            int y = ValidacionesUtil.parseStringToIntDefault(resultado[1],iceOutputText.getY());
            
            iceOutputText.setCoordenadas(x, y);
            
            System.out.println("coordenadas");
        }else if(e.getSource()==jMenuItems[2]){
            
            String[] resultado = JDialogUtil.showCambiarDimensionDialog(null,iceOutputText);
            
            int w = ValidacionesUtil.parseStringToIntDefault(resultado[0],iceOutputText.getWidth());
            int h = ValidacionesUtil.parseStringToIntDefault(resultado[1],iceOutputText.getHeight());
            
            iceOutputText.setDimension(w, h);
            
            System.out.println("dimension");
        }else if(e.getSource()==jMenuItems[3]){
            System.out.println("propiedades");
        }


    }
    private IceOutputText iceOutputText;
}
