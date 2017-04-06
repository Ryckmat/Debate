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
 private HandStatus currentplayer;
    public Referee(){
        super();
        advantage=0;
        currentplayer=HandStatus.NoOneHasHand;
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

    /**
     * @return the currentplayer
     */
    public HandStatus getCurrentplayer() {
        return currentplayer;
    }

    public void setCurrentplayer(HandStatus s) {
        currentplayer=s;
    }

    public boolean moveEnabled(){
        return(currentplayer != HandStatus.NoOneHasHand);
    }



}
