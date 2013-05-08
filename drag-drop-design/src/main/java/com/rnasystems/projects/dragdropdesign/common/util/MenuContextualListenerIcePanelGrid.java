/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.dragdropdesign.common.util;

import java.awt.event.ActionEvent;

import javax.swing.JMenuItem;

import com.linet.api.swing.listener.menu.contextual.ContexMenuListener;
import com.rnasystems.projects.dragdropdesign.modelo.IcePanelGrid;
import com.rnasystems.projects.util.ValidacionesUtil;

/**
 *
 * @author RM-RCM
 */
public class MenuContextualListenerIcePanelGrid extends ContexMenuListener {

    public MenuContextualListenerIcePanelGrid(IcePanelGrid icePanelGrid, JMenuItem[] jMenuItems) {
        super(jMenuItems);
        this.icePanelGrid = icePanelGrid;
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jMenuItems[0]) {

            String res = JDialogUtil.showCambiarLayoutDialog(null, icePanelGrid);
            if(res.equals("")){
                
            }else if(res.equals("Free Design")){
                icePanelGrid.setLayout(0);
            }else {
                icePanelGrid.setLayout(1);
            }
                    
            //System.out.println(""+selectedValue);
        } else if (e.getSource() == jMenuItems[1]) {
            String[] resultado = JDialogUtil.showCambiarCoordenadasDialog(null, icePanelGrid);

            int x = ValidacionesUtil.parseStringToIntDefault(resultado[0], icePanelGrid.getX());
            int y = ValidacionesUtil.parseStringToIntDefault(resultado[1], icePanelGrid.getY());

            icePanelGrid.setCoordenadas(x, y);

            System.out.println("coordenadas");
        } else if (e.getSource() == jMenuItems[2]) {

            String[] resultado = JDialogUtil.showCambiarDimensionDialog(null, icePanelGrid);

            int w = ValidacionesUtil.parseStringToIntDefault(resultado[0], icePanelGrid.getWidth());
            int h = ValidacionesUtil.parseStringToIntDefault(resultado[1], icePanelGrid.getHeight());

            icePanelGrid.setDimension(w, h);

            System.out.println("dimension");
        } else if (e.getSource() == jMenuItems[3]) {
            
            String[] resultado = JDialogUtil.showCambiarFilasColumnasDialog(null, icePanelGrid);

            int f = ValidacionesUtil.parseStringToIntDefault(resultado[0], icePanelGrid.getWidth());
            int c = ValidacionesUtil.parseStringToIntDefault(resultado[1], icePanelGrid.getHeight());
            
            icePanelGrid.setCols((c==0)?3:c);
            icePanelGrid.setRows((f==0)?3:f);
            
            System.out.println("propiedades");            
        } else if (e.getSource() == jMenuItems[4]) {
            System.out.println("propiedades");
        }



    }
    private IcePanelGrid icePanelGrid;
}
