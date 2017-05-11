/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package satoulouse;

import gnu.mapping.Environment;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kawa.standard.Scheme;

/**
 *Cette classe permet d'appeler l'interpréteur Scheme (ici, Kawa) depuis Java.
 * @author François Schwarzentruber
 */
public class SchemeWithKawa {
    private static boolean cnfTransformation = true;

    public static void setCNFTransformation(boolean b)
    {
        cnfTransformation = b;
        restart();
    }



    private static kawa.standard.Scheme scheme = null;


    /**
     * redémarre l'interpréteur (en cas de plantage)
     */
    static void restart() {
        scheme = new kawa.standard.Scheme();

            Scheme.registerEnvironment();

            Environment.setCurrent(new Scheme().getEnvironment());
            lotrec_load();
    }
    
    public SchemeWithKawa() {
        if(scheme == null)
        {
            restart();
        }
    }
    
    public String evalDefine(String schemeCode)
    {
        try {
            return Scheme.eval(schemeCode, Environment.current()).toString();
        } catch (Throwable ex) {
            System.out.print(ex);
            return null;
        }
    }
    public String eval(String schemeCode)
    {
            return Scheme.eval("(format \"~a\" " + schemeCode + ")", Environment.current()).toString();

    }
    
   
    static private void evalAndDoNotCareAboutTheResult(String schemeCode)
    {
        try {
            Scheme.eval(schemeCode, Environment.current()).toString();
        } catch (Throwable ex) {
        }
    }
    
    static private void lotrec_load() {
        ressourcescheme_charger("match.scm");
        ressourcescheme_charger("formula-expander.scm");
        ressourcescheme_charger("vartablewithlists.scm");
        if(cnfTransformation)
             ressourcescheme_charger("tocnfforsat4j.scm");
        else
            ressourcescheme_charger("tocnfforsat4jancien.scm");

    }
    
    
    public void fileLoad(String fileName)
    {
        fileName = fileName.replace("\\", "/");
        evalAndDoNotCareAboutTheResult("(load \"" + fileName + "\")");
    }
    
    @SuppressWarnings("static-access")
    static private void ressourcescheme_charger(String filename)
    {   
        String s = null;
        
            
            try {
                s = TextFile.lire_dans_une_ressource_sans_les_load_descheme("resources/" + filename);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Scheme.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Scheme.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            evalAndDoNotCareAboutTheResult(s);
     
    }
    
}
