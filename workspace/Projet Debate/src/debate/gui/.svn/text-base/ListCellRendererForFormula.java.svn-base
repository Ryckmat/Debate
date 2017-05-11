/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package debate.gui;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import satoulouse.FormulaLabel;

/**
 *
 * @author Propriétaire
 */
public class ListCellRendererForFormula implements ListCellRenderer{

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index,
            boolean isSelected, boolean cellHasFocus) {
        FormulaLabel labelToReturn = new FormulaLabel("") ;
        if (value instanceof String) {
            labelToReturn= new FormulaLabel((String) value);
        }
        if (isSelected) {
            labelToReturn.setForeground(Color.red);
        } else {
            labelToReturn.setForeground(Color.black);
        }
        
        return labelToReturn ;

    }


}

