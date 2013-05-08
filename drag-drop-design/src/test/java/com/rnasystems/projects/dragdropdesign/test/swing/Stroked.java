/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.dragdropdesign.test.swing;

/**
 *
 * @author ext_synps03
 */
import java.awt.*;
import java.awt.geom.*;
import java.applet.*;

public class Stroked extends Applet {

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Rectangle2D rectangle = new Rectangle2D.Double(20, 20, 200, 100);
        Line2D line2D = new Line2D.Double( 20, 20, 200, 20);
        g2d.setColor(Color.blue);
        g2d.setStroke(new BasicStroke(1f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1f, new float[]{2f}, 0f));
        g2d.draw(line2D);
    }
}
