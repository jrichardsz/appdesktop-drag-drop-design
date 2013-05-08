/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.dragdropdesign.vista.menucontextual;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

/**
 *
 * @author RM-RCM
 */
public class MenuContextualClicDerecho extends JPopupMenu implements MouseListener{

    public MenuContextualClicDerecho(JMenuItem[] jMenuItems) {
        this.jMenuItems = jMenuItems;
        insertaJMenuItems();
    }

    public void insertaJMenuItems(){
        for(JMenuItem item:jMenuItems){
            add(item);
        }
    }    
    
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {

        } // Right mouse click
        else if (SwingUtilities.isRightMouseButton(e)) {            
            this.show(e.getComponent(), e.getX(), e.getY());
        }
    }

    public void mousePressed(MouseEvent e) {
        
    }

    public void mouseReleased(MouseEvent e) {
        
    }

    public void mouseEntered(MouseEvent e) {
        
    }

    public void mouseExited(MouseEvent e) {
        
    }
    
    private JMenuItem[] jMenuItems;
   
    
    
}
