/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.dragdropdesign.common.util;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Collections;

import com.linet.api.swing.component.dragdrop.DragDropComponent;
import com.rnasystems.projects.dragdropdesign.controlador.panelDisenio.CPanelDisenio;
import com.rnasystems.projects.dragdropdesign.modelo.IcePanelGrid;

/**
 *
 * @author info4
 */
public class IcePanelGridInsideListener implements MouseListener, MouseMotionListener {

    public IcePanelGridInsideListener(IcePanelGrid container) {
        this.container = container;
        listaVertices = new ArrayList<Point>();
        max_ancho = container.getMax_ancho();
        max_alto = container.getMax_alto();
    }

    public void obtieneComponenteActual(MouseEvent e) {
        component = ((CPanelDisenio) AppUtil.sessionMap.get("CPanelDisenio")).getListaComponentesenPaleta().get("" + e.getSource().hashCode());
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent event) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {


        // obtenemos el compoenente actual
        obtieneComponenteActual(e);

        // si aun no esta dentro del panelgrid
        if (container.getComponentesInPanelGrid().get(component.getId()) == null) {

            if (GraphicUtil.estaDentro(container.getComponent(), component.getComponent())) {
                //lo insertamos
                container.getComponent().add(component.getComponent());
                container.getComponentesInPanelGrid().put(component.getId(), component);
                max_ancho.add(component.getComponent().getWidth());
                max_alto.add(component.getComponent().getHeight());

                if (container.getLayout() != 0) {// sino es freedesign
                    redimensionaSize();
                    obtieneFilasColumnas();
                    calculaVerticesGrilla();
                    dibujaGrilla();
                }
            }

        } else { // si esta dentro del panelgrid

            if (container.getLayout() != 0) {// sino es freedesign
                redimensionaSize();
                obtieneFilasColumnas();
                calculaVerticesGrilla();
                dibujaGrilla();
            }
        }

    }

    public void mouseDragged(MouseEvent event) {

        obtieneComponenteActual(event);
        // si aun no esta dentro del panelgrid
        if (container.getComponentesInPanelGrid().get(component.getId()) == null) {

            if (GraphicUtil.estaDentro(container.getComponent(), component.getComponent())) {
                //lo insertamos
                container.getComponent().add(component.getComponent());
                container.getComponentesInPanelGrid().put(component.getId(), component);
                max_ancho.add(component.getComponent().getWidth());
                max_alto.add(component.getComponent().getHeight());

                if (container.getLayout() != 0) {// sino es freedesign
                    redimensionaSize();
                    obtieneFilasColumnas();
                    calculaVerticesGrilla();
                    dibujaGrilla();
                }



            }

        } else { // si esta dentro del panelgrid

            if (container.getLayout() != 0) {// sino es freedesign
                redimensionaSize();
                obtieneFilasColumnas();
                calculaVerticesGrilla();
                dibujaGrilla();
            }

        }

    }

    public int obtieneMaximoAncho() {
        Collections.sort(max_ancho);
        Collections.reverse(max_ancho);
        return ((Integer) max_ancho.get(0)).intValue();
    }

    public int obtieneMaximoAlto() {
        Collections.sort(max_alto);
        Collections.reverse(max_alto);
        return ((Integer) max_alto.get(0)).intValue();
    }

    public void calculaVerticesGrilla() {
        //obtenemos lascoordenadas de los vertices
        if (listaVertices != null && listaVertices.size() > 0) {
            listaVertices.clear();
        }

        int x_temp = 0;
        int y_temp = 0;
        for (int j = 0; j <= rows; j++) {
            for (int i = 0; i <= cols; i++) {
                x_temp = (int) (x_ini + i * ancho_celda);
                y_temp = (int) (y_ini + j * alto_celda);
                Point p = new Point(x_temp, y_temp);
                listaVertices.add(p);
            }
        }
    }

    public void redimensionaSize() {
        Dimension d = container.getComponent().getSize();

        ancho_celda = (int) (obtieneMaximoAncho()) + spacing * 2;
        alto_celda = (int) (obtieneMaximoAlto()) + spacing * 2;

        // modificamos el tamanio del panelGrid
        int new_width = 0;

        new_width = ancho_celda * cols + (2 * margen);


        int new_heigth = 0;
        new_heigth = alto_celda * cols + (2 * margen);


        // redimensionamos el panelgrid
        container.getComponent().setSize(new_width, new_heigth);
    }

    public void dibujaGrilla() {

        Graphics g = container.getComponent().getGraphics();
        //iteramos los vertices
        Graphics2D g2d = (Graphics2D) g;

        int ind_ini = 0;
        int ind_fin = cols;
        for (int a = 0; a <= rows; a++) {
            GraphicUtil.drawLineDashed(g2d, listaVertices.get(ind_ini + a * (cols + 1)).x,
                    listaVertices.get(ind_ini + a * (cols + 1)).y,
                    listaVertices.get(ind_fin + a * (cols + 1)).x,
                    listaVertices.get(ind_fin + a * (cols + 1)).y);
        }


        ind_ini = 0;
        ind_fin = (rows) * (cols + 1);

        for (int a = 0; a <= cols; a++) {
            GraphicUtil.drawLineDashed(g2d, listaVertices.get(ind_ini + a).x,
                    listaVertices.get(ind_ini + a).y,
                    listaVertices.get(ind_fin + a).x,
                    listaVertices.get(ind_fin + a).y);
        }


    }

    public void obtieneFilasColumnas() {
        cols = container.getCols();
        rows = container.getRows();
    }

    public void obtieneNuevaDimensionContainer() {
        //obtengo la dimension de los componentes insetados
    }

    public int getX_fin() {
        return x_fin;
    }

    public void setX_fin(int x_fin) {
        this.x_fin = x_fin;
    }

    public int getY_fin() {
        return y_fin;
    }

    public void setY_fin(int y_fin) {
        this.y_fin = y_fin;
    }
    public Point centro_componente = new Point();
    private IcePanelGrid container;
    private DragDropComponent component;
    private ArrayList<DragDropComponent> listaComponenteIcefaceses;
    private ArrayList<Point> listaVertices;
    private int x_ini = 10;
    private int y_ini = 10;
    private int x_fin = 0;
    private int y_fin = 0;
    private int spacing = 8;
    private int margen = 10;
    int ancho_celda;
    int alto_celda;
    int cols = 3;
    int rows = 3;
    ArrayList<Integer> max_ancho;
    ArrayList<Integer> max_alto;
    private boolean estaDentro = false;
}
