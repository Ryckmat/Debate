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
import satoulouse.Formula;
import satoulouse.SATSolverSAT4J;

/**
 *
 * @author Propriétaire
 */
public class Player extends Participant {

    /*************************/
    /*                       */
    /*      ATTRIBUTS        */
    /*                       */
    /*************************/
    private int speechtime;//temps de parole restant
    private String nickname;//pseudo du joueur
    private List<Request> requestList;//liste des requetes pour le joueur
    private SATSolverSAT4J solver;//solveur SAT4J du joueur

    /*************************/
    /*                       */
    /*      CONSTRUCTEURS    */
    /*                       */
    /*************************/
    public Player(String n, int sp) {
        super();
        speechtime = sp;
        requestList = new Vector<Request>();
        this.nickname = n;
        solver = new SATSolverSAT4J();
    }

    /*************************/
    /*                       */
    /*      ACCESSEURS       */
    /*                       */
    /*************************/
    public SATSolverSAT4J getSolver() {
        return solver;
    }

    public void setSolver(SATSolverSAT4J s) {
        solver = s;
    }

    public String getNickname() {
        return nickname;
    }

    public void setSpeechtime(int t) {
        speechtime = t;
    }

    public int getSpeechtime() {
        return speechtime;
    }

    public List<Request> getRequestList() {
        return requestList;
    }

    @Override
    public String toString() {
        return nickname;
    }

    /*************************/
    /*                       */
    /*        METHODES       */
    /*                       */
    /*************************/
    /**
     * ajoute une liste de requete correspondant à chaque formule (sous forme de String)
     * @param arrayListFormulas 
     */
    public void addRequestWithFormula(ArrayList<String> arrayListFormulas) {
        for (String s : arrayListFormulas) {
            requestList.add(new Request(new Formula(s)));
        }

    }

    /**
     * Ajoute une requete à partir d'un argument
     * @param argument 
     */
    public void addRequest(Argument argument) {
        requestList.add(new Request(argument));
    }

    /**
     * Retire une requete
     * @param request
     * @return 
     */
    public boolean removeRequest(Request request) {
        return requestList.remove(request);
    }
}
