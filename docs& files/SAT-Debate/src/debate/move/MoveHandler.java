/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package debate.move;

import debate.game.Player;
import debate.game.Referee;

/**
 *
 * @author Propriétaire
 */
public interface  MoveHandler {
    public boolean preconditions(Player p1, Player p2, Referee r);
    public boolean postconditions(Player p1, Player p2, Referee r);
   

}
