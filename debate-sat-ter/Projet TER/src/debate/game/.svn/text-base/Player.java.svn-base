/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package debate.game;

import debate.logical.Argument;
import debate.logical.Request;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Propriétaire
 */
public class Player extends Participant {

    private int speechtime;
    private String nickname;
    private List<String> requestList;

    public Player(String n, int sp) {
        super();
        speechtime = sp;
        requestList = new ArrayList<String>();
        this.nickname = n;
    }

    public String getNickName(String s) {
        return nickname;
    }

    public void setSpeechtime(int t) {
        speechtime = t;
    }

    public int getSpeechtime() {
        return speechtime;
    }

    @Override
    public String toString() {
        return nickname ;
    }

    public void addFormula(ArrayList<String> arrayListFormulas) {
        super.getFormulaList().addAll(arrayListFormulas);
    }

    public void addRequest(ArrayList<String> arrayListFormulas) {
        requestList.addAll(arrayListFormulas);
    }

    public List<String> getRequestList() {
        return requestList;
    }
    
    
}
