/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package debate.logical;

import java.util.ArrayList;
import java.util.List;
import satoulouse.Formula;

/**
 *
 * @author Propriétaire
 */
public class Argument {
    private int id ;
    private List<Formula> support = new ArrayList<Formula>() ;
    private Formula conclusion ;
    // Compteur servant à la numérotation des formules
    static private int count = 0 ;
    
    //Constructeur avec les formules
    public Argument (List<Formula> support, Formula conclusion) {
        this.support = support;
        this.conclusion = conclusion ;
        this.id = count ;
        count++ ;
    }

    //Constructeur avec des Strings (ils sont traduits directement en formule)
    public Argument(List<String> arrayListFormulas, String conclusion) {
        this.conclusion = new Formula(conclusion);
        for (String s : arrayListFormulas) {
            support.add(new Formula(s));
        }
    }

    public Formula getConclusion() {
        return conclusion ;
    }

    public static int getCount() {
        return count;
    }

    public List<Formula> getSupport() {
        return support;
    }
    
    
}
