/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rnasystems.projects.dragdropdesign.vista.util;

import java.awt.Toolkit;

/**
 *
 * @author RM-RCMJ
 */
public class VistaUtil {

    public static int WIDTH_SCREEN = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static int HEIGHT_SCREEN = Toolkit.getDefaultToolkit().getScreenSize().height;
    public static int WIDTH_PANEL_CORE = WIDTH_SCREEN/7;
    public static int HEIGHT_PANEL_CORE = HEIGHT_SCREEN/7;

    public static int HEIGHT_MENU_BAR = 25;

    //Panel principal
    public static int WIDHT_PANEL_PRINCIPAL = WIDTH_SCREEN;
    public static int HEIGHT_PANEL_PRINCIPAL = HEIGHT_PANEL_CORE*6;

    //Panel Nuevo Proyecto
    public static int MARGEN_PANEL_NUEVO_PROYECTO = 4;
    public static int WIDHT_PANEL_NUEVO_PROYECTO = WIDTH_SCREEN-MARGEN_PANEL_NUEVO_PROYECTO;
    public static int HEIGHT_PANEL_NUEVO_PROYECTO = HEIGHT_PANEL_PRINCIPAL-MARGEN_PANEL_NUEVO_PROYECTO;

    //Panel disenio Panel Dragged
    public static int X_PANEL_DRAGGED = 10;
    public static int Y_PANEL_DRAGGED = 30;
    public static int WIDHT_PANEL_DRAGGED  = WIDTH_PANEL_CORE*5;
    public static int HEIGHT_PANEL_DRAGGED  = HEIGHT_PANEL_CORE*5;

    //Panel disenio Panel Paleta
    public static int X_PANEL_PALETA= WIDTH_PANEL_CORE*5+30;
    public static int Y_PANEL_PALETA = 30;
    public static int WIDHT_PANEL_PALETA  = WIDTH_PANEL_CORE*2-50;
    public static int HEIGHT_PANEL_PALETA  = HEIGHT_PANEL_CORE*5;

    //Panel disenio JLabel coordenadas del cursos
    public static int X_LABEL_COORDENADAS = 10;
    public static int Y_LABEL_COORDENADAS = 10;
    public static int WIDHT_LABEL_COORDENADAS = 150;
    public static int HEIGHT_LABEL_COORDENADAS = 15;

    //Panel disenio JButton Limpiar
    public static int WIDHT_BUTTON_LIMPIAR = 80;
    public static int HEIGHT_BUTTON_LIMPIAR = 20;
    public static int X_BUTTON_LIMPIAR = WIDTH_PANEL_CORE*5-WIDHT_BUTTON_LIMPIAR;
    public static int Y_BUTTON_LIMPIAR = 8;

    //Panel Codigo JButton Actualizar
    public static int WIDHT_BUTTON_ACTUALIZAR = 80;
    public static int HEIGHT_BUTTON_ACTUALIZAR = 20;
    public static int X_BUTTON_ACTUALIZAR = 10;
    public static int Y_BUTTON_ACTUALIZAR = 10;

    //Panel disenio JtextAreaCodigo
    public static int X_TEXT_CODIGO= 10;
    public static int Y_TEXT_CODIGO = 35;
    public static int WIDHT_TEXT_CODIGO  = WIDTH_PANEL_CORE*6;
    public static int HEIGHT_TEXT_CODIGO  = HEIGHT_PANEL_CORE*4;


    //Panel disenio JtextAreaCodigo
    public static int NUM_INI_ROWS_PANELGRID= 3;
    public static int NUM_INI_COLS_PANELGRID= 3;


    public static void limpiar(){
        
    }
}
