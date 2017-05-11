/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package debate.game;

import debate.logical.Argument;
import debate.logical.Request;
import debate.move.Move;
import java.util.ArrayList;
import java.util.List;
import satoulouse.Formula;

/**
 *
 * @author Propriétaire
 */
public class Player extends Participant{

    /*************************/
    /*                       */
    /*      ATTRIBUTS        */
    /*                       */
    /*************************/
    private int countFormulasAccepted;
    private int speechtime;//temps de parole restant
    private String nickname;//pseudo du joueur
    private List<Request> requestList;//liste des requetes pour le joueur

    /*************************/
    /*                       */
    /*      CONSTRUCTEURS    */
    /*                       */
    /*************************/
    
    //Nouvelle partie
     public Player(String n) {
        super();
        speechtime = 0;
        requestList = new ArrayList<>();
        this.nickname = n;
        countFormulasAccepted=0;
    }
    
    
    public Player(String n, int sp, int sc) {
        super();
        speechtime = sp;
        requestList = new ArrayList<>();
        this.nickname = n;
        countFormulasAccepted=sc;
    }
 
 


    /*************************/
    /*                       */
    /*      ACCESSEURS       */
    /*                       */
    /*************************/
    @Override
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
    
    public int getCountFormulasAccepted(){
        return countFormulasAccepted;
    }

    /*************************/
    /*                       */
    /*        METHODES       */
    /*                       */
    /*************************/
    /**
     * Ajoute une requete
     * @param request
     */
    public void addRequest(Request r) {
        requestList.add(r);
    }

    /**
     * Ajoute une requete à partir d'une formule
     * @param formula
     */
    public void addRequest(Formula formula, Move movetype) {
        requestList.add(new Request(formula, movetype));
    }

    /**
     * Ajoute une requete à partir d'un argument
     * @param argument 
     */
    public void addRequest(Argument argument, Move movetype) {
        requestList.add(new Request(argument, movetype));
    }

    /**
     * Retire une requete
     * @param request
     * @return 
     */
    public boolean removeRequest(Request request) {
        return requestList.remove(request);
    }

    public void removeRequestByFormula(String form) {
        for (int i = 0; i<requestList.size(); i++) 
            if (requestList.get(i).getFormula()!=null)
            {
                if (requestList.get(i).getFormula().toString().equals(form)) 
                    requestList.remove(i);
            }
    }

    public void removeRequestByArgument(Argument arg) {
        for (int i = 0; i<requestList.size(); i++) 
            if (requestList.get(i).getArgument()!=null)
                if (requestList.get(i).getArgument().equals(arg)) 
                    requestList.remove(i);       
    }

    public void setNickname(String get) {
        nickname = get;
    }



    public void removeArgueQuizContainingFormula(String formula, Move type) {
        ArrayList<Request> newlist=new ArrayList<>();
        boolean continu;
        for (int i=0; i<requestList.size(); i++)
        {
            continu=true;
            if (requestList.get(i).getType().name().contains(type.name()))
            {
                if (requestList.get(i).getArgument().getConclusion().toString().contentEquals(formula))
                    continu=false;
                else
                {
                    for (int j=0; j<requestList.get(i).getArgument().getSupport().size() && continu; j++)
                    {
                        if (requestList.get(i).getArgument().getSupport().get(j).toString().contentEquals(formula))
                            continu=false;
                    }
                }
            }
           if (continu)
              newlist.add(requestList.get(i));
    }
        requestList.clear();
        requestList.addAll(newlist);
    }

    public void removeChallengeContainingFormula(String f) {
        boolean continu=true;
        for (int i=0; i<requestList.size() && continu; i++)
            if (requestList.get(i).getFormula() != null)
                if (requestList.get(i).getFormula().toString().contentEquals(f))
                {
                    requestList.remove(i);
                    continu=false;
                }
    }
    

    public void addPoints(Argument argument) {
        countFormulasAccepted+=argument.getSupport().size()+1;
                  
    }
    
    public void addPoints(Formula form){
        countFormulasAccepted++;
    }

    public void withdrawSpeechingTime() {
        speechtime--;
    }
    
    public int getScore(){
        return (countFormulasAccepted - requestList.size());
    }

    

   
   
}