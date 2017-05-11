/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package debate.move;

import debate.game.Player;
import debate.game.Referee;
import satoulouse.ArgumentDialog;
import satoulouse.FormulaDialog;

/**
 *
 * @author Propriétaire
 */
public class Assert implements MoveHandler {

    public boolean preconditions(Player p1, Player p2, Referee r) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean postconditions(Player p1, Player p2, Referee r) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void assertFormula(Player player1, Player player2, Referee referee) {
        final Player p1 = player1;
        final Player p2 = player2;
        final FormulaDialog dialog = new FormulaDialog(null,player1.getSolver(), true);
        dialog.addFormulaFromReferee(referee);
        dialog.addFormulaFromPlayer(player1);
        dialog.setSendFormulaListener(new Runnable() {

            @Override
            public void run() {
                p1.addFormulaList(dialog.getArrayListFormulas());
                p2.addRequestWithFormula(dialog.getArrayListFormulas());
                dialog.dispose();
            }
        });
        dialog.setVisible(true);
    }
}
