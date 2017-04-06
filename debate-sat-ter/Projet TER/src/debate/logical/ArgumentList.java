/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package debate.logical;

import debate.logical.Argument;
import java.util.ArrayList;

/**
 *
 * @author Propriétaire
 */
public class ArgumentList {
    ArrayList<Argument> arguments;

    public ArgumentList(){
        arguments=new ArrayList<Argument>();
    }

    public void addArgument(Argument r){
        arguments.add(r);

    }

    public void removeArgument(Argument r){
        arguments.remove(r);
    }

    public Argument getArgument(int i){
        return arguments.get(i);
    }

}
