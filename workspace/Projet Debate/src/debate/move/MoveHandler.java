/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package debate.move;

import debate.logical.Argument;
import debate.tools.ErrorEnum;
import debate.tools.MessageDialog;
import java.awt.Window;
import java.util.List;
import satoulouse.Formula;

/**
 *
 * @author Propriétaire
 */
public class  MoveHandler {

     public static boolean testRedundancyFormula(Window window, List<String> l1, List<String> l2, String formula) {
         if (l1.contains(formula))
         {
                MessageDialog.displayErrorMessage((Window)window, ErrorEnum.SelfRedundancyFormula);    
                return true;
         }
         
         if (l2.contains(formula))
         {
              MessageDialog.displayErrorMessage((Window)window, ErrorEnum.GlobalRedundancyFormula);
              return true;
         }
         return false;
    }

    public static boolean testRedundancyArgument(Window window, List<Argument> argumentList0, List<Argument> argumentList, Argument argument) {
              if (checkRedundancy(argument, argumentList0)) 
              {
                MessageDialog.displayErrorMessage((Window)window, ErrorEnum.SelfRedundancyArgument);
                return true;
              }
              
             if (checkRedundancy(argument, argumentList)){
                MessageDialog.displayErrorMessage((Window)window, ErrorEnum.GlobalRedundancyArgument);
                return true;
             }
             return false;
    }

 
    public static boolean checkRedundancy(Argument argument, List<Argument> l1) {
        int test = 0;
        for (int i = 0; i < l1.size(); i++) {
            if (argument.getConclusion().equals(l1.get(i).getConclusion())) {
                //Alors meme conclusion, on va vérifier la double inclusion
              
                for (Formula f : argument.getSupport()) {
                    if (l1.get(i).getSupport().contains(f)) {
                        test++;
                    }
                }
                if (test == argument.getSupport().size()) {
                    test = 0;
                    //alors on vérifie la seconde inclusion
                    for (Formula f : l1.get(i).getSupport()) {
                        if (argument.getSupport().contains(f)) {
                            test++;
                        }
                    }
                    if (test == l1.get(i).getSupport().size()) {
                        return true;
                    }
                }

            }

        }
        return false;
    }
    
    
     public static boolean concernsFormula(Move movetype) {
        return (movetype==Move.Assert || movetype==Move.Challenge);
    }
     
     public static Move stringToEnum(String m){
         if(m.equals("Accept"))
                 return Move.Accept;
        if (m.equals("Assert"))
                 return Move.Assert;
             
        if (m.equals("Agree"))
                 return Move.Agree;
              
        if (m.equals("Argue"))
                 return Move.Argue;
             
        if (m.equals("Challenge"))
                return Move.Challenge;
              
        if (m.equals("Dismantle"))
                 return Move.Dismantle;
                 
        if (m.equals("Quiz"))
                 return Move.Quiz;
             
         if (m.equals("QuizLink"))
                 return Move.QuizLink;
                 
         
         return null;
     }
    
}
