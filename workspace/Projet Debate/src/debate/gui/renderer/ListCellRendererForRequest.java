/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package debate.gui.renderer;

import debate.gui.CompoundIcon;
import debate.logical.Request;
import debate.move.Move;
import java.awt.Color;
import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import satoulouse.FormulaBox;
import satoulouse.LaTEX;

/**
 *
 * @author Propriétaire
 */
public class ListCellRendererForRequest extends JLabel implements ListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index,
            boolean isSelected, boolean cellHasFocus) {
        Icon formulaIcon = null;//Icone en LATEX pour la formule affichée
        Icon coloredIcon = null;//Icone coloré pour le type de requete
        Icon compoundedIcon = null;//Fusion des deux icones
        String message = "" ; //Message d'aide à afficher dans le Tooltip

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        if (value instanceof Request) {
            Request request = (Request) value;
            if (request.getType()==Move.Assert) {
                try {
                    formulaIcon = LaTEX.latexCodeToImageIcon(FormulaBox.formulaSchemeStringToLatexCode(request.getFormula().toString()));
                    coloredIcon = new ImageIcon(getClass().getResource("/icons/icon_blue.png"));
                } catch (Exception ex) {
                    Logger.getLogger(ListCellRendererForRequest.class.getName()).log(Level.SEVERE, null, ex);
                }
                message = "You can Accept or Challenge this formula" ;
            }
           
            if (request.getType()==Move.Challenge) {
                try {
                    formulaIcon = LaTEX.latexCodeToImageIcon(FormulaBox.formulaSchemeStringToLatexCode(request.getFormula().toString()));
                    coloredIcon = new ImageIcon(getClass().getResource("/icons/icon_pink.png"));
                } catch (Exception ex) {
                    Logger.getLogger(ListCellRendererForRequest.class.getName()).log(Level.SEVERE, null, ex);
                }
                message = "Double Clic to precise this challenge";
            }
            
             if (request.getType()==Move.Argue) {
                try {
                    formulaIcon = LaTEX.latexCodeToImageIcon(FormulaBox.formulaSchemeStringToLatexCode(request.getConclusion().toString()));
                    coloredIcon = new ImageIcon(getClass().getResource("/icons/icon_green.png"));
                } catch (Exception ex) {
                    Logger.getLogger(ListCellRendererForRequest.class.getName()).log(Level.SEVERE, null, ex);
                }
                message = "You can Agree this argument";
            }
              if (request.getType()==Move.Quiz) {
                try {
                    formulaIcon = LaTEX.latexCodeToImageIcon(FormulaBox.formulaSchemeStringToLatexCode(request.getConclusion().toString()));
                    coloredIcon = new ImageIcon(getClass().getResource("/icons/icon_yellow.png"));
                } catch (Exception ex) {
                    Logger.getLogger(ListCellRendererForRequest.class.getName()).log(Level.SEVERE, null, ex);
                }
                message = "Double Clic to precise this quiz";
            }
              
                  if (request.getType()==Move.QuizLink) {
                try {
                    formulaIcon = LaTEX.latexCodeToImageIcon(FormulaBox.formulaSchemeStringToLatexCode(request.getConclusion().toString()));
                    coloredIcon = new ImageIcon(getClass().getResource("/icons/icon_bluesky.png"));
                } catch (Exception ex) {
                    Logger.getLogger(ListCellRendererForRequest.class.getName()).log(Level.SEVERE, null, ex);
                }
                message = "Double Clic to precise this quiz-link";
            }
 
            compoundedIcon = new CompoundIcon(coloredIcon, formulaIcon);
            setToolTipText(message);
            setIcon(compoundedIcon);
        }


        if (isSelected) 
            setForeground(Color.red);
        else 
            setForeground(Color.black);
        
        return this;



    }
}
