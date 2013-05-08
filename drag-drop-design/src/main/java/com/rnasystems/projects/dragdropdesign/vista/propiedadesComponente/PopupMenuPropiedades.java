/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rnasystems.projects.dragdropdesign.vista.propiedadesComponente;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import com.rnasystems.projects.dragdropdesign.common.util.AppUtil;
import com.rnasystems.projects.dragdropdesign.controlador.popupPropiedades.CPopupPropiedades;

/**
 *
 * @author RM-RCMJ
 */
public class PopupMenuPropiedades extends JPopupMenu{

    public PopupMenuPropiedades() {
        iniItemsMenu();
        setToSessionMap();
        new CPopupPropiedades(this);

    }

    public void setToSessionMap() {
        AppUtil.sessionMap.put("PopupMenuPropiedades", this);
    }
    public void iniItemsMenu(){
        item1 = new JMenuItem("Cambiar Texto");
        item2 = new JMenuItem("Cambiar Dimension");
        item3 = new JMenuItem("Propiedades");
        add(item1);
        add(item2);
        add(item3);
    }

    public JMenuItem getItem1() {
        return item1;
    }

    public void setItem1(JMenuItem item1) {
        this.item1 = item1;
    }

    public JMenuItem getItem2() {
        return item2;
    }

    public void setItem2(JMenuItem item2) {
        this.item2 = item2;
    }

    public JMenuItem getItem3() {
        return item3;
    }

    public void setItem3(JMenuItem item3) {
        this.item3 = item3;
    }

    

    private JMenuItem item1;
    private JMenuItem item2;
    private JMenuItem item3;

}
