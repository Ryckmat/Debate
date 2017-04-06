/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package debate.game;

import debate.logical.Argument;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Propriétaire
 */
 public abstract class Participant {
    private List<String> formulaList;
    private List<Argument> argumentList;
    public Participant(){
        formulaList=new ArrayList<String>();
        argumentList=new ArrayList<Argument>();
    }

    /**
     * @return the formulaList
     */
    public List<String> getFormulaList() {
        return formulaList;
    }

    /**
     * @return the argumentList
     */
    public List<Argument> getArgumentList() {
        return argumentList;
    }

}
    

