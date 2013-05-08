/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.dragdropdesign.test;

/**
 *
 * @author RM-RCM
 */
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BotonConTooltip extends JFrame {

        private static final long serialVersionUID = 1L;
        
        public BotonConTooltip(){
                super("Botón con Tooltip");     
                
                getContentPane().setLayout(new FlowLayout());
                                
                JButton boton = new JButton("Pasa sobre este botón");
                boton.setToolTipText("Tooltip del botón");
                getContentPane().add(boton);
                        
                setSize(400,300);
                setVisible(true);
        }
        
        
        public static void main(String[] args) {
                new BotonConTooltip();
        }

}

