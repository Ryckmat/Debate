/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package debate.move;

import debate.game.Player;
import debate.game.Referee;
import debate.logical.Argument;
import satoulouse.ArgumentDialog;

/**
 *
 * @author Propriétaire
 */
public class Argue implements MoveHandler {
private Player p1 ;
private Player p2 ;
private ArgumentDialog dialog ;
    public boolean preconditions(Player p1, Player p2, Referee r) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean postconditions(Player p1, Player p2, Referee r) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void newArgue(Player player1, Player player2, Referee referee) {
        p1 = player1;
        p2 = player2;
        dialog = new ArgumentDialog(null, player1.getSolver(), true);
        dialog.setSendArgueListener(new Runnable() {

            @Override
            public void run() {
                //Action à faire pour la validation du formulaire
                Argument argument = new Argument(dialog.getArrayListFormulas(), dialog.getConclusion()) ;
                p1.addArgument(argument) ;
                p2.addRequest(argument);
                dialog.dispose();
            }
        });
        dialog.setVisible(true);
    }
}
