/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.dragdropdesign.controlador.panelCodigo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.linet.api.swing.component.dragdrop.DragDropComponent;
import com.rnasystems.projects.dragdropdesign.common.util.AppUtil;
import com.rnasystems.projects.dragdropdesign.controlador.panelDisenio.CPanelDisenio;
import com.rnasystems.projects.dragdropdesign.generadorcodigo.icefaces.GeneraCodigoPanelGrid;
import com.rnasystems.projects.dragdropdesign.vista.nuevoProyecto.codigo.PanelCodigo;

/**
 *
 * @author RM-RCMJ
 */
public class CPanelCodigoIcefaces implements ActionListener {

    public CPanelCodigoIcefaces(PanelCodigo panelCodigo) {
        this.panelCodigo = panelCodigo;
        insertaFuncionalidad();
    }

    public void insertaFuncionalidad() {
        jButtonActualizar = panelCodigo.getjButtonActualizar();
        jTextAreaCodigo = panelCodigo.getjTextAreaCodigo();
        jButtonActualizar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jButtonActualizar) {
            //obtenenmos la lista de componentes creados
            listaComponentesenPaleta = ((CPanelDisenio) (AppUtil.sessionMap.get("CPanelDisenio"))).getListaComponentesenPaleta();
            //creaLineasCodigo();
            GeneraCodigoPanelGrid codigoPanelGrid = new GeneraCodigoPanelGrid();
            codigoPanelGrid.inicializaVariables(null);
            imprimeCodigo();
        }

    }

    public void creaLineasCodigo() {
        if (lineas_codigo != null && lineas_codigo.size() > 0) {
            lineas_codigo.clear();
        }

        //creaStyle();
        insertaComponentesModoDiv();
    }

    public void insertaComponentesModoDiv() {
        String inicioDiv = "\t\t<ice:panelGrid style=\"width: 200px;height: 200px;position:relative;\">";
        lineas_codigo.add(inicioDiv);

        //deacuerdo al tipo insertamos el componente
        Iterator it = listaComponentesenPaleta.entrySet().iterator();
        DragDropComponent temp = null;
        String linea="";
        int c=0;
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

    public String insertaCommandButton(int c,DragDropComponent componente){
        String temp = "\t\t\t<ice:commandButton  "
                + "value=\""+componente.getText()+"\" "
                + "style=\"position:absolute; left:"+componente.getX()+"px;top:"+componente.getY()+"px;\""
                + " ></ice:commandButton>";
        return temp;
    }

    public String insertaInputText(int c,DragDropComponent componente){
        String temp = "\t\t\t\t<ice:inputText  "
                + "value=\""+componente.getText()+"\" "
                + "style=\"position:absolute; left:"+componente.getX()+"px;top:"+componente.getY()+"px;\""
                + "></ice:inputText>";
        return temp;
    }

    public String insertaOutputText(int c,DragDropComponent componente){
        String temp = "\t\t\t<ice:outputText  "
                + "value=\""+componente.getText()+"\" "
                + "style=\"position:absolute; left:"+componente.getX()+"px;top:"+componente.getY()+"px;\""
                + "></ice:outputText>";
        return temp;
    }


    public void imprimeCodigo() {
        jTextAreaCodigo.setText("");
        for (String linea : lineas_codigo) {
            jTextAreaCodigo.append(linea + "\n");
        }
    }

    public void creaStyle() {

        String definicion = "\t\t<style type=\"text/css\">";
        String container = "\t\t\t#contatiner{width:500px; height:400px;position:relative;}";
        // agregamos las lineas anteriores a la lista
        lineas_codigo.add(definicion);
        lineas_codigo.add(container);
        // aqui creamos tasntas lineas como componentes se crearon
        Iterator it = listaComponentesenPaleta.entrySet().iterator();
        DragDropComponent temp = null;
        int x = 0;
        int y = 0;
        int c = 0;
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            temp = (DragDropComponent) e.getValue();
            x = temp.getListener().getX_fin();
            y = temp.getListener().getY_fin();

            lineas_codigo.add("\t\t\t" + creaStyleComponente(x, y, c));
            c++;
        }

        //cerramos el style
        String fin_style = "\t\t</style>";
        lineas_codigo.add(fin_style);


    }

    public String creaStyleComponente(int x, int y, int c) {
        String temp = "#comp_" + c + "{ position:absolute; left: @xpx; top: @ypx; }";
        temp = temp.replaceAll("@x", "" + x);
        temp = temp.replaceAll("@y", "" + y);
        return temp;
    }
    private HashMap<String, DragDropComponent> listaComponentesenPaleta;
    private ArrayList<String> lineas_codigo = new ArrayList<String>();
    private PanelCodigo panelCodigo;
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JTextArea jTextAreaCodigo;
    
}
