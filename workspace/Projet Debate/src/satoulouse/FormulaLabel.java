/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SATResults.java
 *
 * Created on 26 sept. 2010, 02:57:12
 */

package satoulouse;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Cette classe représente un bouton qui permet d'insérer du texteScheme
 * dans un champ Scheme
 * Par exemple, le bouton pour insérer "(<phi> and <psi>)"
 * @author François Schwarzentruber
 */
public class FormulaLabel extends javax.swing.JLabel  {

    public FormulaLabel(String ch){
        try {
            this.setIcon(LaTEX.latexCodeToImageIcon(FormulaBox.formulaSchemeStringToLatexCode(ch)));     
        } catch (Exception ex) {
            Logger.getLogger(FormulaLabel.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setFocusable(false);
        this.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        this.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    }









}
