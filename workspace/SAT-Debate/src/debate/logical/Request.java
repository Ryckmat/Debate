/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package debate.logical;

import java.util.List;
import satoulouse.Formula;

/**
 *
 * @author Propriétaire
 */
public class Request {
    private Formula formula ;
    private Argument argument ;

    // Constructeur à partir d'une formule
    public Request(Formula formule) {
        this.formula = formule ;
    }

    //Contructeur à partir d'un argument
    public Request(Argument argument) {
        this.argument = argument;
    }
    
    //Retourne le type de requete (demande d'accept sur une formule ou sur un argument)
    public String getType () {
        if (formula == null ) {
            return ("Argument");
        }
        return ("Formula");
    }

    public Formula getFormula() {
        return formula ;
    }
    
    public Formula getConclusion () {
        return argument.getConclusion() ;
    }
    
    public Argument getArgument () {
        return argument ;
    }
    
    public List<Formula> getSupport() {
        return argument.getSupport() ;
    }

}
