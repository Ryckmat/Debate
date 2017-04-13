/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package debate.tools;

import javax.swing.JCheckBoxMenuItem;

/**
 *
 * @author david
 */
public class Tools {

   public static void actualizeJButtonScoring(JCheckBoxMenuItem item1, JCheckBoxMenuItem item2, Score get) {
        switch (get){
            case Time:
                item1.setSelected(true);
                item2.setSelected(false);
                break;
            case Depth:
               item2.setSelected(true);
               item1.setSelected(false);
                break;
            case DepthAndTime:
               item2.setSelected(true);
               item1.setSelected(true);
                break;
            default:
                break;
        }
    }
  
       public static String spacing(String s){
        String temp="";
        for (int i=0; i<s.length(); i++)
        {
            if (s.charAt(i)>64 && s.charAt(i)<91)
                temp+=" ";
        temp+=s.charAt(i);
        }
        return temp;
    }
  
}
