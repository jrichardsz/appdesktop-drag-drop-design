/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.dragdropdesign.generadorcodigo.icefaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.linet.api.swing.component.dragdrop.DragDropComponent;
import com.rnasystems.projects.dragdropdesign.modelo.IcePanelGrid;

/**
 *
 * @author RM-RCM
 */
public class GeneraCodigoPanelGrid {

    public void inicializaVariables(IcePanelGrid icePanelGrid) {
        this.icePanelGrid = icePanelGrid;
        componentesInPanelGrid = this.icePanelGrid.getComponentesInPanelGrid();
        lineas_codigo = new ArrayList<String>();
    }

    public ArrayList<String> getLineasCodigo() {

        // obtenemos el tipo de panelgrid
        int layout = icePanelGrid.getLayout();

        if (layout == 0) {// Free Design
            generaCodigoFreeDesign();
        } else if (layout == 1) {// Grilla
        }

        return lineas_codigo;
    }

    public void generaCodigoFreeDesign() {

        if (lineas_codigo != null && lineas_codigo.size() > 0) {
            lineas_codigo.clear();
        }

        insertaComponentesInIcePanleGrid();
    }

    public void insertaComponentesInIcePanleGrid() {
        String inicioDiv = "\t\t<ice:panelGrid style=\"width: " + icePanelGrid.getWidth() + "px;height: " + icePanelGrid.getHeight() + "px;position:relative;\">";
        lineas_codigo.add(inicioDiv);

        //deacuerdo al tipo insertamos el componente
        Iterator it = componentesInPanelGrid.entrySet().iterator();
        DragDropComponent temp = null;
        String linea = "";
        int c = 0;
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            temp = (DragDropComponent) e.getValue();

            switch (temp.getType()) {
                case 0:
                    linea = insertaCommandButton(c, temp);
                    break;
                case 1:
                    linea = insertaInputText(c, temp);
                    break;
                case 2:
                    linea = insertaOutputText(c, temp);
                    break;
                default:
                    break;
            }
            c++;
            lineas_codigo.add(linea);
        }

        String finDiv = "\t\t</ice:panelGrid>";
        lineas_codigo.add(finDiv);

    }

    public String insertaCommandButton(int c, DragDropComponent componente) {
        String temp = "\t\t\t<ice:commandButton  "
                + "value=\"" + componente.getText() + "\" "
                + "style=\"position:absolute; left:" + componente.getX() + "px;top:" + componente.getY() + "px;\""
                + " ></ice:commandButton>";
        return temp;
    }

    public String insertaInputText(int c, DragDropComponent componente) {
        String temp = "\t\t\t\t<ice:inputText  "
                + "value=\"" + componente.getText() + "\" "
                + "style=\"position:absolute; left:" + componente.getX() + "px;top:" + componente.getY() + "px;\""
                + "></ice:inputText>";
        return temp;
    }

    public String insertaOutputText(int c, DragDropComponent componente) {
        String temp = "\t\t\t<ice:outputText  "
                + "value=\"" + componente.getText() + "\" "
                + "style=\"position:absolute; left:" + componente.getX() + "px;top:" + componente.getY() + "px;\""
                + "></ice:outputText>";
        return temp;
    }
    private IcePanelGrid icePanelGrid;
    private HashMap<String, DragDropComponent> componentesInPanelGrid;
    private ArrayList<String> lineas_codigo = new ArrayList<String>();
}
