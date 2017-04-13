/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package debate.gui.renderer;

import debate.logical.Argument;
import java.awt.Color;
import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import satoulouse.Formula;
import satoulouse.FormulaBox;
import satoulouse.LaTEX;

/**
 *
 * @author julien
 */
public class TreeCellRendererForArgument extends DefaultTreeCellRenderer {

    

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, isSelected, expanded, leaf, row, hasFocus);
        DefaultMutableTreeNode myNode = (DefaultMutableTreeNode) value;
        String formula = "";
        //Affichage d'une formule normale
        if (myNode.getUserObject() instanceof Formula) {
            formula = ((Formula) myNode.getUserObject()).toString();
        }

        //Affichage d'un argument
        if (myNode.getUserObject() instanceof Argument) {
            formula = (((Argument) myNode.getUserObject())).getConclusion().toString();
        }

        try {
          if (!formula.isEmpty())
          {
            setIcon(LaTEX.latexCodeToImageIcon(FormulaBox.formulaSchemeStringToLatexCode(formula)));
            setToolTipText("This book is in the Tutorial series.");
          }
        } catch (Exception ex) {
            Logger.getLogger(TreeCellRendererForArgument.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (isSelected) {
            setForeground(Color.red);
        } else {
            setForeground(Color.black);
        }
        return this;
    }
}
