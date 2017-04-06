/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package debate.game;


/**
 *
 * @author Propriétaire
 */
public class Referee extends Participant {
 private int advantage;
    public Referee(){
        super();
        advantage=0;
}


    /**
     * @return the advantage
     */
    public int getAdvantage() {
        return advantage;
    }

    /**
     * @param advantage the advantage to set
     */
    public void setAdvantage(int advantage) {
        this.advantage = advantage;
    }



}
