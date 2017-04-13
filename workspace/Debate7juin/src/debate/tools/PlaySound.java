/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package debate.tools;

import debate.gui.DebateFrame;
import java.awt.Window;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import sound.Jlp;

/**
 *
 * @author david
 */
public class PlaySound {
    
    public PlaySound(Window f, boolean sound, SoundEnum soundType){
        if (sound){
         URL resource = f.getClass().getResource("/sound/"+soundType.name().toLowerCase()+".mp3");
         Jlp mp = new Jlp(resource.getPath());
                try {
                    mp.play();
                } catch (JavaLayerException ex) {
                    Logger.getLogger(DebateFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
       
    }
    
}
