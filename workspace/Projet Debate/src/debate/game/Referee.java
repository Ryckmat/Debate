/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package debate.game;

import debate.tools.HandStatus;
import debate.tools.Score;
import java.util.ArrayList;

/**
 *
 * @author Propriétaire
 */
public class Referee extends Participant{

    /*************************/
    /*                       */
    /*      ATTRIBUTS        */
    /*                       */
    /*************************/
    private boolean sound;
    private HandStatus currentplayer;
    private ArrayList<String> topics;
    private int countMoves;

    /*************************/
    /*                       */
    /*      CONSTRUCTEURS    */
    /*                       */
    /*************************/
    
    //Nouvelle partie
    public Referee(ArrayList<String> topics, boolean sound, int countMoves) {
        super();
        this.sound=sound;
        currentplayer = HandStatus.NoOneHasHand;
        this.topics = topics;
        this.countMoves=countMoves;

    }
    
    //En cas de restauration
    public Referee(){
        super();
        this.sound=true;
        currentplayer = HandStatus.NoOneHasHand;
        this.topics = new ArrayList<>();
        countMoves=0;
    }
    


    /*************************/
    /*                       */
    /*      ACCESSEURS       */
    /*                       */
    /*************************/

    public boolean getSound(){
        return sound;
    }
    
    public void setSound(boolean b){
        sound=b;
    }
    
    public void incrementCountMoves(){
        countMoves++;
    }
    
    public int getCountMoves(){
        return countMoves;
    }

   

    /**
     * @return the currentplayer
     */
    public HandStatus getCurrentplayer() {
        return currentplayer;
    }

    public void setCurrentplayer(HandStatus s) {
        currentplayer = s;
    }

    public void addTopic(String filepath) {
        topics.add(filepath);
    }

    public ArrayList<String> getTopics() {
        return topics;
    }

 

    public int calculateScore(Player p1, Player p2) {
        int retour=50;
        if (p1.getScore() > p2.getScore()) 
            retour=25;
        else
            if (p1.getScore() < p2.getScore()) 
                retour=75;             
        return (retour-retour%10);
    }      
}