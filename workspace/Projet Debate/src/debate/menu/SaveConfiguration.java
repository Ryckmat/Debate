/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package debate.menu;

import debate.game.Player;
import debate.game.Referee;
import debate.logical.Argument;
import debate.logical.Request;
import debate.move.MoveHandler;
import java.io.IOException;
import java.util.ArrayList;
import satoulouse.Formula;
import satoulouse.TextFile;

/**
 *
 * @author David
 */
public class SaveConfiguration {

    public static void saveRefereeFormula(Referee p, String filepath) throws IOException{
       TextFile.string_ecrire_dans_fichier("  < " + p.getNickname() + " >", filepath);
       ArrayList<String>tamp=new ArrayList<>();
       for(int i=0; i< p.getFormulaList().size(); i++)
           tamp.add(p.getFormulaList().get(i));
       TextFile.string_ecrire_dans_fichier_lignes(tamp, filepath);
    }
 

    private static String saveSound(boolean b){
        if (b)
            return ("Sound enabled");      
        return ("Sound disabled");
    }
    
   public static void saveGame(String filename, Player p1, Player p2, Referee r) throws IOException{
       //Enregistrement des formules
       TextFile.removeFile(filename);
       TextFile.string_ecrire_dans_fichier(p1.getNickname(), filename);
       TextFile.string_ecrire_dans_fichier(""+p1.getSpeechtime(), filename);
       TextFile.string_ecrire_dans_fichier(""+p1.getScore(), filename);
       TextFile.string_ecrire_dans_fichier(p2.getNickname(), filename);
       TextFile.string_ecrire_dans_fichier(""+p2.getSpeechtime(), filename);
       TextFile.string_ecrire_dans_fichier(""+p2.getScore(), filename);
       
       TextFile.string_ecrire_dans_fichier(saveSound(r.getSound()), filename);
       TextFile.string_ecrire_dans_fichier(""+r.getCountMoves(), filename);
       TextFile.string_ecrire_dans_fichier_lignes(r.getTopics(), filename);
       TextFile.string_ecrire_dans_fichier(
               r.getFormulaList().size() + " "+
               r.getArgumentList().size()+ " " + 
               p1.getRequestList().size() + " " +
               p2.getRequestList().size(), filename);

       TextFile.string_ecrire_dans_fichier("          !!!! Formulas !!!!", filename);
       saveRefereeFormula(r, filename);


       //Enregistrement des arguments
       TextFile.string_ecrire_dans_fichier("          !!!! Arguments !!!!", filename);
       saveRefereeArgument(r, filename);


       //Enregistrement des requêtes
       TextFile.string_ecrire_dans_fichier("          !!!! Requetes !!!!", filename);
       savePlayerRequest(p1, filename);
       savePlayerRequest(p2, filename);
      

   }

    private static void saveRefereeArgument(Referee p, String filepath) throws IOException {
         TextFile.string_ecrire_dans_fichier("  < " + p.getNickname() + " >", filepath);
         ArrayList<String>tamp=new ArrayList<String>();
        for (Argument arg: p.getArgumentList())
        {
            for(Formula f: arg.getSupport())
                tamp.add("S: "+f.toString());
            tamp.add("C: "+arg.getConclusion().toString());
            TextFile.string_ecrire_dans_fichier_lignes(tamp, filepath);
            tamp.clear();

        }
    }

    private static void savePlayerRequest(Player p, String filepath) throws IOException{
        TextFile.string_ecrire_dans_fichier("  < " + p.getNickname() + " >", filepath);
        ArrayList<String>tamp=new ArrayList<>();
        for (Request req: p.getRequestList())
        {
            TextFile.string_ecrire_dans_fichier(req.getType().name(), filepath);
            if (MoveHandler.concernsFormula(req.getType()))
                TextFile.string_ecrire_dans_fichier(req.getFormula().toString(), filepath);

            else
            {
                for(Formula f: req.getSupport())
                    tamp.add("S: "+f.toString());
                tamp.add("C: "+req.getConclusion().toString());
                TextFile.string_ecrire_dans_fichier_lignes(tamp, filepath);
                tamp.clear();
            }
        }
}
}