/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package satoulouse;

import debate.logical.Argument;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class ArgumentLabel extends javax.swing.JLabel  {

    public ArgumentLabel(Argument arg) throws Exception{
            String ch="\\{ (";
            for (int i=0; i<arg.getSupport().size(); i++)
            {
                ch+=FormulaBox.formulaSchemeStringToLatexCode(arg.getSupport().get(i).toString());
                if (i<arg.getSupport().size()-1)
                    ch+=", ";
            }


            ch+="), "+FormulaBox.formulaSchemeStringToLatexCode(arg.getConclusion().toString())+" \\}";
            try {
           this.setIcon(LaTEX.latexCodeToImageIcon(ch));
        } catch (Exception ex) {
            Logger.getLogger(FormulaLabel.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.setFocusable(false);
        this.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        this.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    }

}