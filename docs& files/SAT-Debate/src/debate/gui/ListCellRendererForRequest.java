/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package debate.gui;

import debate.logical.Request;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import satoulouse.FormulaLabel;

/**
 *
 * @author Propriétaire
 */
public class ListCellRendererForRequest implements ListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index,
            boolean isSelected, boolean cellHasFocus) {
        FormulaLabel labelToReturn = new FormulaLabel("");
        if (value instanceof Request) {
            Request request = (Request) value;
            if (request.getType().equals("Formula")) {
                labelToReturn = new FormulaLabel(request.getFormula().toString());
                labelToReturn.setToolTipText("Formula Request");
            }
            if (request.getType().equals("Argument")) {
                labelToReturn = new FormulaLabel(request.getConclusion().toString());
                labelToReturn.setToolTipText("Argument Request");
            }

        }
        if (isSelected) {
            labelToReturn.setForeground(Color.red);
        } else {
            labelToReturn.setForeground(Color.black);
        }

        return labelToReturn;

    }
}
