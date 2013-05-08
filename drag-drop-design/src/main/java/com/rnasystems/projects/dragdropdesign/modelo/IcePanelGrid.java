/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.dragdropdesign.modelo;

import java.util.ArrayList;
import java.util.HashMap;

import com.linet.api.swing.component.dragdrop.DragDropComponent;
import com.rnasystems.projects.dragdropdesign.vista.util.VistaUtil;

/**
 *
 * @author RM-RCM
 */
public class IcePanelGrid extends DragDropComponent {

    public IcePanelGrid() {
    
        componentesInPanelGrid = new HashMap<String, DragDropComponent>();
        max_alto = new ArrayList<Integer>();
        max_ancho = new ArrayList<Integer>();
        panelGrid = new PanelGrid();
        
    }
//
//    public void agregaComponente(ComponenteIcefaces componenteIcefaces) {
//        panelGrid.add(componenteIcefaces.getComponent());
//        listaComponenteIcefaceses.add(componenteIcefaces);
//    }

    public void limpiaListaComponenteIcefaceses() {
        if (componentesInPanelGrid != null && componentesInPanelGrid.size() > 0) {
            componentesInPanelGrid.clear();
        }
    }    
    
    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

//    public ArrayList<ComponenteIcefaces> getListaComponenteIcefaceses() {
//        return listaComponenteIcefaceses;
//    }
//
//    public void setListaComponenteIcefaceses(ArrayList<ComponenteIcefaces> listaComponenteIcefaceses) {
//        this.listaComponenteIcefaceses = listaComponenteIcefaceses;
//    }
    
    
    

    public ArrayList<Integer> getMax_alto() {
        return max_alto;
    }

    public void setMax_alto(ArrayList<Integer> max_alto) {
        this.max_alto = max_alto;
    }

    public ArrayList<Integer> getMax_ancho() {
        return max_ancho;
    }

    public void setMax_ancho(ArrayList<Integer> max_ancho) {
        this.max_ancho = max_ancho;
    }

    public PanelGrid getPanelGrid() {
        return panelGrid;
    }

    public void setPanelGrid(PanelGrid panelGrid) {
        this.panelGrid = panelGrid;
    }

    public HashMap<String, DragDropComponent> getComponentesInPanelGrid() {
        return componentesInPanelGrid;
    }

    public void setComponentesInPanelGrid(HashMap<String, DragDropComponent> componentesInPanelGrid) {
        this.componentesInPanelGrid = componentesInPanelGrid;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    
    
    
    private int cols=VistaUtil.NUM_INI_COLS_PANELGRID;
    private int rows=VistaUtil.NUM_INI_ROWS_PANELGRID;  
    private int layout =0; //0 -> div  1-> icepanelgrid position  2-> icepanelgrid layout
    //private ArrayList<ComponenteIcefaces> listaComponenteIcefaceses;
    private HashMap<String, DragDropComponent> componentesInPanelGrid;      
    private ArrayList<Integer> max_ancho;
    private ArrayList<Integer> max_alto;  
    private PanelGrid panelGrid;
}
