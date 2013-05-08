/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rnasystems.projects.dragdropdesign.controlador.menuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;

/**
 *
 * @author RM-RCMJ
 */
public class CMenubar implements ActionListener{

    public CMenubar(JMenu jMenuArchivo) {
        this.jMenuArchivo = jMenuArchivo;
        insertaFuncionalidad();
    }

    public void insertaFuncionalidad(){

        jMenuItemNuevoProyecto = jMenuArchivo.getItem(0);
        jMenuItemNuevoProyecto.addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jMenuItemNuevoProyecto){
              
        }
    }


    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenuItem jMenuItemNuevoProyecto;

}
