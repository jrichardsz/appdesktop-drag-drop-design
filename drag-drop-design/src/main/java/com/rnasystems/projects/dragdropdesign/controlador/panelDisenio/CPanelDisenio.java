/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.dragdropdesign.controlador.panelDisenio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.linet.api.swing.component.dragdrop.DragDropComponent;
import com.linet.api.swing.listener.move.component.MovementComponentListener;
import com.linet.api.swing.paint.axis.AdvancedAxisPaintComponent;
import com.rnasystems.projects.dragdropdesign.common.util.AppUtil;
import com.rnasystems.projects.dragdropdesign.common.util.IcePanelGridInsideListener;
import com.rnasystems.projects.dragdropdesign.common.util.ListenerClicDerecho;
import com.rnasystems.projects.dragdropdesign.common.util.MenuContextualUtil;
import com.rnasystems.projects.dragdropdesign.modelo.IceCommandButton;
import com.rnasystems.projects.dragdropdesign.modelo.IceInputText;
import com.rnasystems.projects.dragdropdesign.modelo.IceOutputText;
import com.rnasystems.projects.dragdropdesign.modelo.IcePanelGrid;
import com.rnasystems.projects.dragdropdesign.modelo.PanelGrid;
import com.rnasystems.projects.dragdropdesign.vista.nuevoProyecto.disenio.PanelDisenio;
import com.rnasystems.projects.dragdropdesign.vista.propiedadesComponente.PopupMenuPropiedades;

/**
 *
 * @author RM-RCMJ
 */
public class CPanelDisenio implements ActionListener {

    public CPanelDisenio(PanelDisenio panelDisenio) {
        this.panelDisenio = panelDisenio;
        listaComponentesenPaleta = new HashMap<String, DragDropComponent>();
        listaPanelGrid = new HashMap<String, DragDropComponent>();
        listaListenerPanelGrid = new ArrayList<IcePanelGridInsideListener>();
        insertaFuncionalidad();
        setToSessionMap();
        menuPropiedades = new PopupMenuPropiedades();
        listenerClicDerecho = new ListenerClicDerecho(menuPropiedades);
    }

    public void setToSessionMap() {
        AppUtil.sessionMap.put("CPanelDisenio", this);
    }

    public void insertaFuncionalidad() {
        ice_outputText_paleta = panelDisenio.getPaletaPanelColapsable1().getPanelIcefacesControls().getjButton1();
        ice_inputText_paleta = panelDisenio.getPaletaPanelColapsable1().getPanelIcefacesControls().getjButton2();
        ice_commandButton_paleta = panelDisenio.getPaletaPanelColapsable1().getPanelIcefacesControls().getjButton3();
        ice_panelGrid_paleta = panelDisenio.getPaletaPanelColapsable1().getPanelIcefacesControls().getjButton4();

        limpiarLienzo = panelDisenio.getjButton1();

        ice_inputText_paleta.addActionListener(this);
        ice_outputText_paleta.addActionListener(this);
        ice_commandButton_paleta.addActionListener(this);
        ice_panelGrid_paleta.addActionListener(this);
        limpiarLienzo.addActionListener(this);
        //insertaListenerPopupPropiedades();
    }

    public void insertaListenerPopupPropiedades(Object component) {
//       // ListenerClicDerecho listener = new ListenerClicDerecho(menuPropiedades);
//        System.out.println("componente:"+component.hashCode());
//        JMenuItem[] items = new JMenuItem[3];
//        items[0] = new JMenuItem("Cambiar Texo");
//        items[1] = new JMenuItem("Cambiar Dimension");
//        items[2] = new JMenuItem("Cambiar Propiedades");
//        MenuContextualClicDerecho menuContextualClicDerecho = new MenuContextualClicDerecho(items);
//        component.addMouseListener(menuContextualClicDerecho);
////        component.addMouseListener(listenerClicDerecho);
        MenuContextualUtil.insertMenuContextualClicDerecho(component);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == limpiarLienzo) {//limpiamos
            panelDisenio.getjPanelDraggedComponentes().removeAll();
            panelDisenio.getjPanelDraggedComponentes().validate();
            panelDisenio.getjPanelDraggedComponentes().repaint();
            if (listaComponentesenPaleta != null && listaComponentesenPaleta.size() > 0) {
                listaComponentesenPaleta.clear();
            }
            if (listaPanelGrid != null && listaPanelGrid.size() > 0) {
                listaPanelGrid.clear();
            }
            
        } else if (e.getSource() == ice_inputText_paleta) {
            creayLocalizaInputText();
        } else if (e.getSource() == ice_outputText_paleta) {
            creayLocalizaOutputText();
        } else if (e.getSource() == ice_commandButton_paleta) {
            creayLocalizaCommandButton();
        } else if (e.getSource() == ice_panelGrid_paleta) {
            creayLocalizaPanelGrid();
        }
    }

    public void creayLocalizaInputText() {
        System.out.println("crea input");
        // instanciamos el componente 
        IceInputText componenteIcefaces = new IceInputText();
        JTextField temp = new JTextField();
        // seteamos algunos campos necesarios a nuestro componente
        componenteIcefaces.setComponent(temp);
        componenteIcefaces.setId("" + componenteIcefaces.getComponent().hashCode());
        componenteIcefaces.setText("");
        // obtenemos el numero de componentes para poder situarlo adecuadamente
        int num_comp = listaComponentesenPaleta.size() + 1;
        componenteIcefaces.getComponent().setBounds(posicion_x, num_comp * 25 + 10, weight, height);
        //tamanios por defecto de este componente
        componenteIcefaces.setDimension(temp.getSize().width, temp.getSize().height);
        componenteIcefaces.setCoordenadas(temp.getLocation().x,temp.getLocation().y);
        // agregamos el listener qe movera los componentes :)
        MovementComponentListener listener = new MovementComponentListener(componenteIcefaces);
        //cada componente debe tener su listener guardado
        componenteIcefaces.setListener(listener);
        componenteIcefaces.setType(1);
        // insertamos el listener de clic derecho popup
        insertaListenerPopupPropiedades(componenteIcefaces);
        insertaComponenteAListernersPanelGrids(componenteIcefaces);
        //guardamos en un hash map el compoenente recientemente creado junto con su id
        listaComponentesenPaleta.put(componenteIcefaces.getId(), componenteIcefaces);
        // lo insertamos en el panel donde se arrastran los componentes
        panelDisenio.getjPanelDraggedComponentes().add(componenteIcefaces.getComponent());
        //pasos necesarios para el correcto refrescado de la pantalla
        panelDisenio.validate();
        panelDisenio.repaint();
    }

    public void creayLocalizaCommandButton() {
        
        IceCommandButton componenteIcefaces = new IceCommandButton();
        JButton temp = new JButton("ice:commandButton");
        componenteIcefaces.setComponent(temp);
        componenteIcefaces.setId("" + componenteIcefaces.getComponent().hashCode());
        componenteIcefaces.setText("ice:commandButton");
        
        System.out.println("crea commandButton:"+componenteIcefaces.getId());
        
        // obtenemos el numero de componentes para poder situarlo adecuadamente
        int num_comp = listaComponentesenPaleta.size() + 1;
        componenteIcefaces.getComponent().setBounds(posicion_x, num_comp * 25 + 10, weight, height);

        componenteIcefaces.setDimension(temp.getSize().width, temp.getSize().height);
        componenteIcefaces.setCoordenadas(temp.getLocation().x,temp.getLocation().y);
        
        // agregamos el listener qe movera los componentes :)
        MovementComponentListener listener = new MovementComponentListener(componenteIcefaces);
        
        componenteIcefaces.setListener(listener);
        componenteIcefaces.setType(0);
        // insertamos el listener de clic derecho popup
        insertaListenerPopupPropiedades(componenteIcefaces);
        insertaComponenteAListernersPanelGrids(componenteIcefaces);
        listaComponentesenPaleta.put(componenteIcefaces.getId(), componenteIcefaces);
        // le insertmos el listeners de los panelgrids
        //insertaListenersPanelGridComponente(temp);
        panelDisenio.getjPanelDraggedComponentes().add(componenteIcefaces.getComponent());
        
        AdvancedAxisPaintComponent pintaEjesComponenteListener = new AdvancedAxisPaintComponent(temp);
        
        panelDisenio.validate();
        panelDisenio.repaint();
    }

    public void creayLocalizaOutputText() {
        System.out.println("crea outputput");
        IceOutputText componenteIcefaces = new IceOutputText();
        JLabel temp = new JLabel("ice:outputText");
        componenteIcefaces.setComponent(temp);
        componenteIcefaces.setId("" + componenteIcefaces.getComponent().hashCode());
        componenteIcefaces.setText("ice:outputText");
//         obtenemos el numero de componentes para poder situarlo adecuadamente
        int num_comp = listaComponentesenPaleta.size() + 1;
        componenteIcefaces.getComponent().setBounds(posicion_x, num_comp * 25 + 10, weight, height);
        componenteIcefaces.setDimension(temp.getSize().width, temp.getSize().height);
        componenteIcefaces.setCoordenadas(temp.getLocation().x,temp.getLocation().y);
//         agregamos el listener qe movera los componentes :)
        MovementComponentListener listener = new MovementComponentListener(componenteIcefaces);
        componenteIcefaces.setListener(listener);
        componenteIcefaces.setType(2);
        // insertamos el listener de clic derecho popup
        insertaListenerPopupPropiedades(componenteIcefaces);
        insertaComponenteAListernersPanelGrids(componenteIcefaces);
        listaComponentesenPaleta.put(componenteIcefaces.getId(), componenteIcefaces);
        panelDisenio.getjPanelDraggedComponentes().add(componenteIcefaces.getComponent());
        panelDisenio.validate();
        panelDisenio.repaint();
    }

    public void creayLocalizaPanelGrid() {

        IcePanelGrid componenteIcefaces = new IcePanelGrid();
        System.out.println("crea PanelGrid");
        PanelGrid temp = new PanelGrid();
        componenteIcefaces.setComponent(temp);
        componenteIcefaces.setId("" + componenteIcefaces.getComponent().hashCode());
        
        // obtenemos el numero de componentes para poder situarlo adecuadamente
        int num_comp = listaComponentesenPaleta.size() + 1;
        componenteIcefaces.getComponent().setBounds(posicion_x, num_comp * 25 + 10, 200, 200);
        componenteIcefaces.setDimension(temp.getSize().width, temp.getSize().height);
        componenteIcefaces.setCoordenadas(temp.getLocation().x,temp.getLocation().y);
        // agregamos el listener qe movera los componentes :)
        MovementComponentListener listener = new MovementComponentListener(componenteIcefaces);
        componenteIcefaces.setListener(listener);
        componenteIcefaces.setType(3);
        // insertamos el listener de clic derecho popup
        insertaListenerPopupPropiedades(componenteIcefaces);
        // lo seteamos en el hash map de componentes 
        // listaComponentesenPaleta.put(componenteIcefaces.getId(), componenteIcefaces);
        // cada panelgrid debe tener una coleccion de compoenetes dentro de el

        // agregamos el listener de este panel grid a todos los componentes

        //insertaListenerPanelGridAllComponentes(temp);
        creaListenerPanelGrid(componenteIcefaces);


        listaPanelGrid.put(componenteIcefaces.getId(), componenteIcefaces);
        panelDisenio.getjPanelDraggedComponentes().add(componenteIcefaces.getComponent());
        panelDisenio.validate();
        panelDisenio.repaint();
    }

    /**
     * Por cada Icepanelgrid creado se debe crear un listener que maneje todos sus procesos 
     **/
    public void creaListenerPanelGrid(IcePanelGrid container) {
        //InsercionComponenteListener componenteListener = new IcePanelGridInsideListener(container, componente_paleta);
        // ahora este listener debe manejar a todos los componentes que esten en el panel de disenio
        // para manejar cuando esten o no esten dentro del panel
//        System.out.println("Iterando todos los componentes de el panel de disenio");
        if (listaComponentesenPaleta != null && !listaComponentesenPaleta.isEmpty()) {
            Iterator it = listaComponentesenPaleta.entrySet().iterator();
            DragDropComponent temp = null;
            IcePanelGridInsideListener listener = new IcePanelGridInsideListener(container);
            listaListenerPanelGrid.add(listener);
            while (it.hasNext()) {
                Map.Entry e = (Map.Entry) it.next();
                temp = (DragDropComponent) e.getValue();
//                System.out.println("componente encontrado:"+temp.getId());
                //guardamos estos componentes en la lista 
                //container.getListaComponenteIcefaceses().add(temp);

                temp.getComponent().addMouseListener(listener);
                temp.getComponent().addMouseMotionListener(listener);
            }
        }

    }

    public void insertaComponenteAListernersPanelGrids(DragDropComponent componenteIcefaces){
        //iteramos la lista de listener de todos los panelgrids
        
        for(IcePanelGridInsideListener listener:listaListenerPanelGrid){
            componenteIcefaces.getComponent().addMouseListener(listener);
            componenteIcefaces.getComponent().addMouseMotionListener(listener);
        }
        
    }
    
    /**
     * recibe un componente y lanza un listener para que detecte si esta dentro de algun panelgrid.
     * se lanza un listener por cada panelgrid que halla en el panel de disenio 
     **/
//    public void insertaListenersPanelGridComponente(JComponent component) {
//        IcePanelGridInsideListener listener = null;
//        ComponenteIcefaces temp = null;
//        // iteramos todos los panelGrid creados
//        Iterator it = listaPanelGrid.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry e = (Map.Entry) it.next();
//            temp = (ComponenteIcefaces) e.getValue();
//            listener = new IcePanelGridInsideListener((IcePanelGrid) temp.getComponent(), component);
//        }
//    }
    /**
     * Este metodo se ejecuta cuando se crea un nuevo panelgrid.
     * Se itera todos los componentes existentes en el panel de diseño
     * y      
     **/
//    public void insertaListenerPanelGridAllComponentes(IcePanelGrid panelGrid) {
//        Iterator it = listaComponentesenPaleta.entrySet().iterator();
//        ComponenteIcefaces temp = null;
//        IcePanelGridInsideListener listener = null;
//        while (it.hasNext()) {
//            Map.Entry e = (Map.Entry) it.next();
//            temp = (ComponenteIcefaces) e.getValue();
//            listener = new IcePanelGridInsideListener(panelGrid, temp.getComponent());
//
//        }
//    }
    public HashMap<String, DragDropComponent> getListaComponentesenPaleta() {
        return listaComponentesenPaleta;
    }

    public void setListaComponentesenPaleta(HashMap<String, DragDropComponent> listaComponentesenPaleta) {
        this.listaComponentesenPaleta = listaComponentesenPaleta;
    }

    public HashMap<String, DragDropComponent> getListaPanelGrid() {
        return listaPanelGrid;
    }

    public void setListaPanelGrid(HashMap<String, DragDropComponent> listaPanelGrid) {
        this.listaPanelGrid = listaPanelGrid;
    }
    // MouseListener event handlers
    // handle event when mouse released immediately after press
    private PanelDisenio panelDisenio;
    private JComponent componente_paleta;
    private JButton limpiarLienzo;
    private HashMap<String, DragDropComponent> listaPanelGrid;
    private HashMap<String, DragDropComponent> listaComponentesenPaleta;
    private ArrayList<IcePanelGridInsideListener> listaListenerPanelGrid;
    private int posicion_x = 500;
    private int height = 25;
    private int weight = 100;
    // componentes de paleta
    private JButton ice_outputText_paleta;
    private JButton ice_inputText_paleta;
    private JButton ice_commandButton_paleta;
    private JButton ice_panelGrid_paleta;
    private PopupMenuPropiedades menuPropiedades;
    private ListenerClicDerecho listenerClicDerecho;
}
