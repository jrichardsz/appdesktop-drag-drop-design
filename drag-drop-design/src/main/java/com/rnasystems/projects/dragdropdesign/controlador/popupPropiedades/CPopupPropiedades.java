/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.dragdropdesign.controlador.popupPropiedades;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.linet.api.swing.component.dragdrop.DragDropComponent;
import com.rnasystems.projects.dragdropdesign.common.util.AppUtil;
import com.rnasystems.projects.dragdropdesign.controlador.panelDisenio.CPanelDisenio;
import com.rnasystems.projects.dragdropdesign.vista.propiedadesComponente.JDialogCambiarDimensiones;
import com.rnasystems.projects.dragdropdesign.vista.propiedadesComponente.JDialogCambiarTexto;
import com.rnasystems.projects.dragdropdesign.vista.propiedadesComponente.JDialogPropiedades;
import com.rnasystems.projects.dragdropdesign.vista.propiedadesComponente.PopupMenuPropiedades;
import com.rnasystems.projects.util.ValidacionesUtil;

/**
 *
 * @author RM-RCMJ
 */
public class CPopupPropiedades implements ActionListener {

    public CPopupPropiedades(PopupMenuPropiedades popupMenuPropiedades) {
        this.popupMenuPropiedades = popupMenuPropiedades;
        jDialogCambiarTexto = new JDialogCambiarTexto(null, true);
        jDialogCambiarDimensiones = new JDialogCambiarDimensiones(null, true);
        jDialogPropiedades = new JDialogPropiedades(null, true);
        insertaFuncionalidad();
    }

    public void insertaFuncionalidad() {
        item1 = ((PopupMenuPropiedades) (AppUtil.sessionMap.get("PopupMenuPropiedades"))).getItem1();
        item2 = ((PopupMenuPropiedades) (AppUtil.sessionMap.get("PopupMenuPropiedades"))).getItem2();
        item3 = ((PopupMenuPropiedades) (AppUtil.sessionMap.get("PopupMenuPropiedades"))).getItem3();

        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);

        jButtonAceptarCambioTexto = jDialogCambiarTexto.getjButton2();
        jButtonAceptarCambioDimension = jDialogCambiarDimensiones.getjButton2();
        jButtonAceptarPropiedades = jDialogPropiedades.getjButton2();

        jButtonAceptarCambioTexto.addActionListener(this);
        jButtonAceptarCambioDimension.addActionListener(this);
        jButtonAceptarPropiedades.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == item1) {//cambiar texto
//            jDialogCambiarTexto.setVisible(true);
            obtieneComponenteFocusYExtraeTexto();
        } else if (e.getSource() == item2) {//cambiar dimensiones
            obtieneComponenteFocusYExtraeDimension();
        } else if (e.getSource() == item3) {// propiedades
            jDialogPropiedades.setVisible(true);
        } else if (e.getSource() == jButtonAceptarCambioTexto) {// aceptar cambio texto
            //obtenemos el componente que lanzo el evento clic derecho
            obtieneComponenteFocusYGuardaCambioTexto();
        } else if (e.getSource() == jButtonAceptarCambioDimension) {// aceptar cambio texto
            //obtenemos el componente que lanzo el evento clic derecho
            obtieneComponenteFocusYGuardaCambioDimension();
        } else if (e.getSource() == jButtonAceptarCambioTexto) {// aceptar cambio texto
            //obtenemos el componente que lanzo el evento clic derecho
            obtieneComponenteFocusYGuardaCambioTexto();
        }
    }

    public void obtieneComponenteFocusYExtraeTexto() {
         component = (JComponent) AppUtil.sessionMap.get("Componente_focus");
        if (component instanceof JButton) {
            System.out.println("es el boton:" + component.hashCode());
            componenteIcefaces = ((CPanelDisenio)AppUtil.sessionMap.get("CPanelDisenio")).getListaComponentesenPaleta().get(""+component.hashCode());
            String texto = componenteIcefaces.getText();
            jDialogCambiarTexto.getjTextField1().setText(texto);
            jDialogCambiarTexto.setVisible(true);
        } else if (component instanceof JTextField) {
            System.out.println("es el JTextField:" + component.hashCode());
            componenteIcefaces = ((CPanelDisenio)AppUtil.sessionMap.get("CPanelDisenio")).getListaComponentesenPaleta().get(""+component.hashCode());
            String texto = componenteIcefaces.getText();
            jDialogCambiarTexto.getjTextField1().setText(texto);
            jDialogCambiarTexto.setVisible(true);
        } else if (component instanceof JLabel) {
            System.out.println("es el JLabel:" + component.hashCode());
            componenteIcefaces = ((CPanelDisenio)AppUtil.sessionMap.get("CPanelDisenio")).getListaComponentesenPaleta().get(""+component.hashCode());
            String texto = componenteIcefaces.getText();
            jDialogCambiarTexto.getjTextField1().setText(texto);
            jDialogCambiarTexto.setVisible(true);
        } else if (component instanceof JPanel) {
            System.out.println("es el JPanel:" + component.hashCode());
        }
    }

    public void obtieneComponenteFocusYGuardaCambioTexto() {
         component = (JComponent) AppUtil.sessionMap.get("Componente_focus");
        if (component instanceof JButton) {
            System.out.println("es el boton:" + component.hashCode());
            JButton comp = (JButton) component;
            comp.setText(jDialogCambiarTexto.getjTextField1().getText());
            //ahora actualizamos el bean componente
            componenteIcefaces = ((CPanelDisenio)AppUtil.sessionMap.get("CPanelDisenio")).getListaComponentesenPaleta().get(""+component.hashCode());
            componenteIcefaces.setText(jDialogCambiarTexto.getjTextField1().getText());
            jDialogCambiarTexto.setVisible(false);
        } else if (component instanceof JTextField) {
            System.out.println("es el JTextField:" + component.hashCode());
            JTextField comp = (JTextField) component;
            comp.setText(jDialogCambiarTexto.getjTextField1().getText());
            componenteIcefaces = ((CPanelDisenio)AppUtil.sessionMap.get("CPanelDisenio")).getListaComponentesenPaleta().get(""+component.hashCode());
            componenteIcefaces.setText(jDialogCambiarTexto.getjTextField1().getText());
            jDialogCambiarTexto.setVisible(false);
        } else if (component instanceof JLabel) {
            System.out.println("es el JLabel:" + component.hashCode());
            JLabel comp = (JLabel) component;
            comp.setText(jDialogCambiarTexto.getjTextField1().getText());
            componenteIcefaces = ((CPanelDisenio)AppUtil.sessionMap.get("CPanelDisenio")).getListaComponentesenPaleta().get(""+component.hashCode());
            componenteIcefaces.setText(jDialogCambiarTexto.getjTextField1().getText());
            jDialogCambiarTexto.setVisible(false);
        } else if (component instanceof JPanel) {
            System.out.println("es el JPanel:" + component.hashCode());
        }
    }

    public void obtieneComponenteFocusYGuardaCambioDimension() {
         component = (JComponent) AppUtil.sessionMap.get("Componente_focus");
            int w = ValidacionesUtil.parseStringIntForce(jDialogCambiarDimensiones.getjTextField1().getText());
            int h = ValidacionesUtil.parseStringIntForce(jDialogCambiarDimensiones.getjTextField2().getText());
        if (component instanceof JButton) {
            System.out.println("es el boton:" + component.hashCode());
            JButton comp = (JButton) component;
            comp.setSize(w,h);
            componenteIcefaces = ((CPanelDisenio)AppUtil.sessionMap.get("CPanelDisenio")).getListaComponentesenPaleta().get(""+component.hashCode());
            componenteIcefaces.setWidth(w);
            componenteIcefaces.setHeight(h);
            jDialogCambiarDimensiones.setVisible(false);
        } else if (component instanceof JTextField) {
            System.out.println("es el JTextField:" + component.hashCode());
            JTextField comp = (JTextField) component;
            comp.setSize(w,h);
            componenteIcefaces = ((CPanelDisenio)AppUtil.sessionMap.get("CPanelDisenio")).getListaComponentesenPaleta().get(""+component.hashCode());
            componenteIcefaces.setWidth(w);
            componenteIcefaces.setHeight(h);
            jDialogCambiarDimensiones.setVisible(false);
        } else if (component instanceof JLabel) {
            System.out.println("es el JLabel:" + component.hashCode());
            JLabel comp = (JLabel) component;
            comp.setSize(w,h);
            componenteIcefaces = ((CPanelDisenio)AppUtil.sessionMap.get("CPanelDisenio")).getListaComponentesenPaleta().get(""+component.hashCode());
            componenteIcefaces.setWidth(w);
            componenteIcefaces.setHeight(h);
            jDialogCambiarDimensiones.setVisible(false);
        } else if (component instanceof JPanel) {
            System.out.println("es el JPanel:" + component.hashCode());
            JPanel comp = (JPanel) component;
            comp.setSize(w,h);
            
//            componenteIcefaces = ((CPanelDisenio)AppUtil.sessionMap.get("CPanelDisenio")).getListaPanelGird().get(""+component.hashCode());
            
            componenteIcefaces.setWidth(w);
            componenteIcefaces.setHeight(h);
            jDialogCambiarDimensiones.setVisible(false);
        }
    }

    public void obtieneComponenteFocusYExtraeDimension() {
            component = (JComponent) AppUtil.sessionMap.get("Componente_focus");
            int w = ValidacionesUtil.parseStringIntForce(jDialogCambiarDimensiones.getjTextField1().getText());
            int h = ValidacionesUtil.parseStringIntForce(jDialogCambiarDimensiones.getjTextField2().getText());
        if (component instanceof JButton) {
            System.out.println("es el boton:" + component.hashCode());
            componenteIcefaces = ((CPanelDisenio)AppUtil.sessionMap.get("CPanelDisenio")).getListaComponentesenPaleta().get(""+component.hashCode());
            jDialogCambiarDimensiones.getjTextField1().setText(""+componenteIcefaces.getWidth());
            jDialogCambiarDimensiones.getjTextField2().setText(""+componenteIcefaces.getHeight());
            jDialogCambiarDimensiones.setVisible(true);
        } else if (component instanceof JTextField) {
            System.out.println("es el JTextField:" + component.hashCode());
            componenteIcefaces = ((CPanelDisenio)AppUtil.sessionMap.get("CPanelDisenio")).getListaComponentesenPaleta().get(""+component.hashCode());
            jDialogCambiarDimensiones.getjTextField1().setText(""+componenteIcefaces.getWidth());
            jDialogCambiarDimensiones.getjTextField2().setText(""+componenteIcefaces.getHeight());
            jDialogCambiarDimensiones.setVisible(true);
        } else if (component instanceof JLabel) {
            System.out.println("es el JLabel:" + component.hashCode());
            componenteIcefaces = ((CPanelDisenio)AppUtil.sessionMap.get("CPanelDisenio")).getListaComponentesenPaleta().get(""+component.hashCode());
            jDialogCambiarDimensiones.getjTextField1().setText(""+componenteIcefaces.getWidth());
            jDialogCambiarDimensiones.getjTextField2().setText(""+componenteIcefaces.getHeight());
            jDialogCambiarDimensiones.setVisible(true);
        } else if (component instanceof JPanel) {
            System.out.println("es el JPanel:" + component.hashCode());
            
//            componenteIcefaces = ((CPanelDisenio)AppUtil.sessionMap.get("CPanelDisenio")).getListaPanelGird().get(""+component.hashCode());
            
            System.out.println("componenteIcefaces:"+componenteIcefaces);
            jDialogCambiarDimensiones.getjTextField1().setText(""+componenteIcefaces.getWidth());
            jDialogCambiarDimensiones.getjTextField2().setText(""+componenteIcefaces.getHeight());
            jDialogCambiarDimensiones.setVisible(true);
        }
    }
    private PopupMenuPropiedades popupMenuPropiedades;
    private JMenuItem item1;//cambiar textp
    private JMenuItem item2;//cambiar dimension
    private JMenuItem item3;//propiedades
    private JDialogCambiarTexto jDialogCambiarTexto;
    private JDialogCambiarDimensiones jDialogCambiarDimensiones;
    private JDialogPropiedades jDialogPropiedades;
    private JButton jButtonAceptarCambioTexto;
    private JButton jButtonAceptarCambioDimension;
    private JButton jButtonAceptarPropiedades;
    private JComponent component;
    private DragDropComponent componenteIcefaces;
//    private JButton jButtonAceptarCambioTexto;
}
