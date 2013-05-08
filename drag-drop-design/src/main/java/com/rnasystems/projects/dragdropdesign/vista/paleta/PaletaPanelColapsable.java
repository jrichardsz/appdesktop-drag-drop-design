    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.dragdropdesign.vista.paleta;

/**
 *
 * @author RM-RCMJ
 */
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.BevelBorder;
import org.jdesktop.swingx.JXTaskPane;
import org.jdesktop.swingx.JXTaskPaneContainer;

public class PaletaPanelColapsable extends JXTaskPaneContainer {



    public PaletaPanelColapsable() {

        // a container to put all JXTaskPane together
        setPreferredSize(new Dimension(250, 300));
        // create another taskPane, it will show details of the selected file
        JXTaskPane details = new JXTaskPane();
        this.setBackground(Color.WHITE);
        details.setTitle("Icefaces Controls");
        details.setExpanded(false);
        panelIcefacesControls = new PanelIcefacesControls();
        details.add(panelIcefacesControls);
        add(details);
    }

    public PanelIcefacesControls getPanelIcefacesControls() {
        return panelIcefacesControls;
    }

    public void setPanelIcefacesControls(PanelIcefacesControls panelIcefacesControls) {
        this.panelIcefacesControls = panelIcefacesControls;
    }


    private PanelIcefacesControls panelIcefacesControls;
}
