/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package debate.game;

import debate.logical.Argument;
import java.util.ArrayList;
import java.util.Vector;
import satoulouse.Formula;

/**
 *
 * @author Propriétaire
 */
public abstract class Participant {

    /*************************/
    /*                       */
    /*      ATTRIBUTS        */
    /*                       */
    /*************************/
    private Vector<String> formulaList;
    private Vector<Argument> argumentList;

    /*************************/
    /*                       */
    /*      CONSTRUCTEURS    */
    /*                       */
    /*************************/
    public Participant() {
        formulaList = new Vector<String>();
        argumentList = new Vector<Argument>();
    }

    /*************************/
    /*                       */
    /*      ACCESSEURS       */
    /*                       */
    /*************************/
    /**
     * @return the formulaList
     */
    public Vector<String> getFormulaList() {
        return formulaList;
    }

    /**
     * @return the argumentList
     */
    public Vector<Argument> getArgumentList() {
        return argumentList;
    }

    /*************************/
    /*                       */
    /*        METHODES       */
    /*                       */
    /*************************/
    public void addFormulaList(ArrayList<String> arrayListFormulas) {
        formulaList.addAll(arrayListFormulas);
    }
    
    public void addFormula(Formula formula) {
        formulaList.add(formula.toString());
    }
    
    public void addArgument(Argument argument) {
        argumentList.add(argument);
    }    
    
    public void removeArgument(Argument argument) {
        argumentList.remove(argument);
    }

    public void removeFormula(Formula formula) {
        formulaList.remove(formula.toString());
    }
}
