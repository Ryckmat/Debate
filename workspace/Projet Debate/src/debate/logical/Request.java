/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package debate.logical;

import debate.move.Move;
import java.util.List;
import satoulouse.Formula;

/**
 *
 * @author Propriétaire
 */
public class Request {


    private Formula formula;
    private Argument argument;
    private Move moveType;

    // Constructeur à partir d'une formule et du type de coup
    public Request(Formula formule, Move moveType) {
    
        this.formula = formule;
        this.moveType = moveType;
    }

    // Constructeur à partir d'une formule et du type de coup
    public Request(Argument arg, Move moveType) {
        this.argument = arg;
        this.moveType = moveType;
    }

    
    //Retourne le type de requete (demande d'accept sur une formule ou sur un argument)
    public Move getType() {
        return moveType;
    }

    public Formula getFormula() {
        return formula;
    }

    public Formula getConclusion() {
        return argument.getConclusion();
    }

    public Argument getArgument() {
        return argument;
    }

    public List<Formula> getSupport() {
        return argument.getSupport();
    }


  

}
