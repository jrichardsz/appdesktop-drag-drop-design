/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.dragdropdesign.common.util;

import javax.swing.JMenuItem;
import com.rnasystems.projects.dragdropdesign.modelo.IceCommandButton;
import com.rnasystems.projects.dragdropdesign.modelo.IceInputText;
import com.rnasystems.projects.dragdropdesign.modelo.IceOutputText;
import com.rnasystems.projects.dragdropdesign.modelo.IcePanelGrid;
import com.rnasystems.projects.dragdropdesign.vista.menucontextual.MenuContextualClicDerecho;

/**
 *
 * @author RM-RCM
 */
public class MenuContextualUtil {

    public static void insertMenuContextualClicDerecho(Object compObject) {
        if (compObject instanceof IceInputText) {
           // System.out.println("componente:" + compObject.hashCode());
            JMenuItem[] items = new JMenuItem[4];
            items[0] = new JMenuItem("Cambiar Texo");
            items[1] = new JMenuItem("Cambiar Coordenadas");
            items[2] = new JMenuItem("Cambiar Dimension");
            items[3] = new JMenuItem("Cambiar Propiedades");
            MenuContextualClicDerecho menuContextualClicDerecho = new MenuContextualClicDerecho(items);
            ((IceInputText)compObject).getComponent().addMouseListener(menuContextualClicDerecho);
            new MenuContextualListenerIceInputText(((IceInputText)compObject), items);
        } else if (compObject instanceof IceCommandButton) {
            
            //System.out.println("componente:" + compObject.hashCode());
            JMenuItem[] items = new JMenuItem[4];
            items[0] = new JMenuItem("Cambiar Texo");
            items[1] = new JMenuItem("Cambiar Coordenadas");
            items[2] = new JMenuItem("Cambiar Dimension");
            items[3] = new JMenuItem("Cambiar Propiedades");
            MenuContextualClicDerecho menuContextualClicDerecho = new MenuContextualClicDerecho(items);
            ((IceCommandButton)compObject).getComponent().addMouseListener(menuContextualClicDerecho);
            new MenuContextualListenerIceCommandButton(((IceCommandButton)compObject), items);
            
        } else if (compObject instanceof IceOutputText) {
            
            //System.out.println("componente:" + compObject.hashCode());
            JMenuItem[] items = new JMenuItem[4];
            items[0] = new JMenuItem("Cambiar Texo");
            items[1] = new JMenuItem("Cambiar Coordenadas");
            items[2] = new JMenuItem("Cambiar Dimension");
            items[3] = new JMenuItem("Cambiar Propiedades");
            MenuContextualClicDerecho menuContextualClicDerecho = new MenuContextualClicDerecho(items);
            ((IceOutputText)compObject).getComponent().addMouseListener(menuContextualClicDerecho);
            new MenuContextualListenerIceOutputText(((IceOutputText)compObject), items);
            
        } else if (compObject instanceof IcePanelGrid) {
            
            //System.out.println("componente:" + compObject.hashCode());
            JMenuItem[] items = new JMenuItem[5];
            items[0] = new JMenuItem("Cambiar Layout");
            items[1] = new JMenuItem("Cambiar Coordenadas");
            items[2] = new JMenuItem("Cambiar Dimension");
            items[3] = new JMenuItem("Cambiar Filas:Columnas");
            items[4] = new JMenuItem("Cambiar Propiedades");
            MenuContextualClicDerecho menuContextualClicDerecho = new MenuContextualClicDerecho(items);
            ((IcePanelGrid)compObject).getComponent().addMouseListener(menuContextualClicDerecho);
            new MenuContextualListenerIcePanelGrid(((IcePanelGrid)compObject), items);
        }
    }
}
