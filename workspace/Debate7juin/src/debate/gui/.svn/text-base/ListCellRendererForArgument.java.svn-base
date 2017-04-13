/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package debate.gui;

import debate.logical.Argument;
import debate.logical.Request;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import satoulouse.Formula;
import satoulouse.FormulaLabel;

/**
 *
 * @author Propriétaire
 */
public class ListCellRendererForArgument implements ListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index,
            boolean isSelected, boolean cellHasFocus) {
        FormulaLabel labelToReturn = new FormulaLabel("");
        if (value instanceof Argument) {
            Argument arg = (Argument) value;
            labelToReturn = new FormulaLabel(arg.getConclusion().toString());
            String tooltip = "Support : \n";
            for (Formula f : arg.getSupport()) {
                tooltip += f.toString()+"\n";
            }
            labelToReturn.setToolTipText(tooltip);
        }
        if (isSelected) {
            labelToReturn.setForeground(Color.red);
        } else {
            labelToReturn.setForeground(Color.black);
        }

        return labelToReturn;

    }
}
