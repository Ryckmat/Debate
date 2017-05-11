/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package debate.move;

import debate.game.Player;
import debate.game.Referee;
import debate.logical.Request;
import javax.swing.JOptionPane;
import satoulouse.Formula;

/**
 *
 * @author Propriétaire
 */
public class Accept implements MoveHandler {

    public boolean preconditions(Player p1, Player p2, Referee r) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean postconditions(Player p1, Player p2, Referee r) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void accept(Player pWithRequest, Player pWithFormula, Referee referee, Request request) {
        //Cas ou la requete est de type formule
        if (request.getType().equals("Formula")) {
            //Ajout de la formule aux connaissances communes
            referee.addFormula(request.getFormula());
            //Retrait de la formule de la liste de l'autre joueur
            if (pWithRequest.removeRequest(request)) {
                pWithFormula.removeFormula(request.getFormula());
                JOptionPane.showMessageDialog(null, "Request Accepted");
            }
        }
        // Cas ou la requete est de type argument
        if (request.getType().equals("Argument")) {
            //Ajout de l'argument aux arguments communs
            referee.addArgument(request.getArgument());
            //Ajout de toutes les formules à la liste des connaissances communes
            for (Formula f : request.getSupport()) {
                referee.addFormula(f);
            }
            referee.addFormula(request.getConclusion());
            //Retrait de l'argument de la liste de l'autre joueur
            //Et de la requete du premier joueur
            if (pWithRequest.removeRequest(request)) {
                pWithFormula.removeArgument(request.getArgument());
                JOptionPane.showMessageDialog(null, "Request Accepted");
            }
        }
    }
}
