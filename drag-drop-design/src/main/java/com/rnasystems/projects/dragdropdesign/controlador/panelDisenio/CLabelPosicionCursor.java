/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rnasystems.projects.dragdropdesign.controlador.panelDisenio;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author RM-RCMJ
 */
public class CLabelPosicionCursor implements MouseListener, MouseMotionListener{

    public CLabelPosicionCursor(JLabel coordenadas_cursor) {
        this.coordenadas_cursor = coordenadas_cursor;
        this.coordenadas_cursor.addMouseListener(this);
        this.coordenadas_cursor.addMouseMotionListener(this);
    }

    public CLabelPosicionCursor(JLabel coordenadas_cursor, JPanel panelDisenio) {
        this.coordenadas_cursor = coordenadas_cursor;
        this.panelDisenio = panelDisenio;
        this.panelDisenio.addMouseListener(this);
        this.panelDisenio.addMouseMotionListener(this);
    }



    public void mouseClicked(MouseEvent event) {
        coordenadas_cursor.setText("Clicked at [" + event.getX()
                + ", " + event.getY() + "]");
    }

    // handle event when mouse pressed
    public void mousePressed(MouseEvent event) {
        coordenadas_cursor.setText("Pressed at [" + event.getX()
                + ", " + event.getY() + "]");
    }

    // handle event when mouse released after dragging
    public void mouseReleased(MouseEvent event) {
        coordenadas_cursor.setText("Released at [" + event.getX()
                + ", " + event.getY() + "]");
    }

    // handle event when mouse enters area
    public void mouseEntered(MouseEvent event) {
        coordenadas_cursor.setText("Mouse entered at [" + event.getX()
                + ", " + event.getY() + "]");
        //getContentPane().setBackground(Color.GREEN);
    }

    // handle event when mouse exits area
    public void mouseExited(MouseEvent event) {
        coordenadas_cursor.setText("Mouse outside window");
        //getContentPane().setBackground(Color.WHITE);
    }

    // MouseMotionListener event handlers
    // handle event when user drags mouse with button pressed
    public void mouseDragged(MouseEvent event) {

        coordenadas_cursor.setText("Dragged at [" + event.getX()
                + ", " + event.getY() + "] by buton");
    }

    // handle event when user moves mouse
    public void mouseMoved(MouseEvent event) {
        coordenadas_cursor.setText("Moved at [" + event.getX()
                + ", " + event.getY() + "]");
    }

    private JLabel coordenadas_cursor;
    private JPanel panelDisenio;


}
