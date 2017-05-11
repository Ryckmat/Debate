/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package debate.tools;

import java.awt.Window;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class MessageDialog {
    public static void displayErrorMessage(Window w, ErrorEnum err){
        String message="Error";
        switch (err){
            case GlobalRedundancyArgument:
                message="This argument belongs already to common arguments";
                break;
            case SelfRedundancyArgument:
                message="You have already written this same argument";
                break;
             case GlobalRedundancyFormula:
                message="This formula belongs already to common formula";
                break;
            case SelfRedundancyFormula:
                message="You have already written this same formula";
                 break;
            case SelfConsistencyArgument:
                message="Argument refused";
                 break;
            case GlobalConsistencyArgument:
                message="Argument refused";
                 break; 
            case SelfConsistencyFormula:
                 message="Formula refused";
                 break;
            case GlobalConsistencyFormula:
                message="Formula refused";
                 break;
            case MistakenFormula:
                message="You have many errors in the field. Please correct them ...";
                break;
            case ForgottenConclusion:
                message="You have not entered the conclusion for your argument";
                break;
            case MissingPlayer1:
                message="Expected Player 1";
                break;
            case MissingPlayer2:
                message="Expected Player 2";
                break;
            case EmptyNameField:
                message="Entered your pseudonyme. It can be empty !";
                break;
            case NoneArgumentSelected:
                message="None argument is selected to withdraw";
                break;
            case NoneFormulaSelected:
                message="None formula is selected to withdraw";
                break;
            case EmptySupport:
                message="Empty support. You have to add at least one formula to resolve the challenge";
                break;
            case ConclusionNotModified:
                message="When you response to a quilink, you should modify\n the conclusion which according"
                        + "to your opponent has not a link with\n the topic of the debate";
                break;
            case Saving:
                message="You can't save this match while you get the hand";
                break;                    
            case Loading:
                message="You can't load a match while you get the hand";
                 break;
            default:
                break;

        }     
        JOptionPane.showMessageDialog(w, message, Tools.spacing(err.name()), JOptionPane.ERROR_MESSAGE);
        
    }

    
    public static void displaySuccessMessage(Window w, Success succ){
        String message=null;
        switch (succ){
            case Loading:
                message="Successfull loading";
                break;
            case Saving:
                message="Successfull saving";
                break;
            default:
                break;
                
        }      
                
        JOptionPane.showConfirmDialog(w, message, succ.name(), JOptionPane.PLAIN_MESSAGE);
        
    }
    

    
    
    
    
        
    }
    
    
    
    
    

  
    


