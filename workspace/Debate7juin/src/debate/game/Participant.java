/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package debate.game;

import debate.logical.Argument;
import java.util.ArrayList;
import java.util.List;
import satoulouse.Formula;
import satoulouse.FormulaForSAT4J;
import satoulouse.SATSolverSAT4J;

/**
 *
 * @author Propriétaire
 */
public abstract class Participant{

    /*************************/
    /*                       */
    /*      ATTRIBUTS        */
    /*                       */
    /*************************/
    private List<String> formulaList;
    private List<Argument> argumentList;
    private SATSolverSAT4J solver;//solveur SAT4J du joueur

    /*************************/
    /*                       */
    /*      CONSTRUCTEURS    */
    /*                       */
    /*************************/
    public Participant() {
        formulaList = new ArrayList<>();
        argumentList = new ArrayList<>();
        solver = new SATSolverSAT4J();
    }

    /*************************/
    /*                       */
    /*      ACCESSEURS       */
    /*                       */
    /*************************/
    /**
     * @return the formulaList
     */
    public List<String> getFormulaList() {
        return formulaList;
    }
     /**
     * @return the formulaList
     */
    public List<Argument> getArgumentList() {
        return argumentList;
    }
    
    public Argument getArgumentBelongedToList(Argument arg){
        boolean continu=false;
        for (Argument a : argumentList)
        {
            if (a.getConclusion().toString().equals(arg.getConclusion().toString()))
            {
                continu=true;
                 for (int i=0; i<a.getSupport().size() && continu; i++)
                 {
                        if (!a.getSupport().contains(arg.getSupport().get(i)))
                            continu=false;
                 }   
            }
            
            if (continu) 
                return a; 
    }
        return null;
    }
    /**
     * @return the argumentList
     */
    public void setArgumentList(ArrayList<Argument> al) {
        argumentList=al;
    }

    public void setFormulaList(ArrayList<String> fl){
       formulaList=fl;
    }

    /*************************/
    /*                       */
    /*        METHODES       */
    /*                       */
    /*************************/
    public void addFormulaList(ArrayList<String> arrayListFormulas) {
        formulaList.addAll(arrayListFormulas);
    }
    
    public void addFormula(String formula) {
            formulaList.add(formula);
    }
    
    
      public void addFormula(Formula formula) {
        formulaList.add(formula.toString());
    }
    
    
    public void addArgument(Argument argument) {
            argumentList.add(argument);
    }    
    
    public void removeArgument(Argument argument) {
        boolean continu=true;
        for (int i=0; continu; i++)
        {
            if (argumentList.get(i).equals(argument))       
            {
                argumentList.remove(i);
                continu=false;
            }
        }
           
    }

    public void removeFormula(Formula formula) {
        formulaList.remove(formula.toString());
    }

    public void removeFormula(String formula){
        formulaList.remove(formula);
    }

    public void replaceFormula(Formula fo1, String fo2 ) {
    boolean continu=true;
    for(int i=0; continu; i++)
         {
        if (getFormulaList().get(i).equals(fo1.toString()))
        {
            formulaList.remove(i);
            formulaList.add(i, new Formula(fo2).toString());
            continu=false;
        }

    }
    }

    public SATSolverSAT4J getSolver() {
        return solver;
    }

    public void setSolver(SATSolverSAT4J s) {
        solver = s;
    }


    public String getNickname() {
        return "Referee";
    }
    
    
      
      public void removeClauses() {
        List<String> liste=new ArrayList<>();
        for (String formString: formulaList)
            liste.add(formString);
        for (Argument arg: argumentList)
            for (String forString: arg.getStringSupport())
                if (!liste.contains(forString))
                    liste.add(forString);
        solver.getSolver().reset();
        for (String ch: liste)
            solver.addFormula(new FormulaForSAT4J(new Formula(ch, false)));
    }
      

      
      public void removeArgumentContainingFormula(String formula){
        List<Argument> newlist=new ArrayList<>();
        boolean continu;
        for (int i=0; i<argumentList.size(); i++)
        {
                continu=true;
                if (argumentList.get(i).getConclusion().toString().contentEquals(formula))
                    continu=false;
                else
                {
                    for (int j=0; j<argumentList.get(i).getSupport().size() && continu; j++)
                        if (argumentList.get(i).getSupport().get(j).toString().contentEquals(formula))
                            continu=false;  
                }
           if (continu)
              newlist.add(argumentList.get(i));
       
        }
        argumentList.clear();
        argumentList.addAll(newlist);
    }
}
