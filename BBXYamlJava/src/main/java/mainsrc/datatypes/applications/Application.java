/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainsrc.datatypes.applications;

import java.util.LinkedHashMap;

/**
 *
 * @author Mark
 * Representation of an Application. 
 */
public class Application {
    
    private LinkedHashMap assemblers;

    public LinkedHashMap getAssemblers() {
        return assemblers;
    }

    public void setAssemblers(LinkedHashMap assemblers) {
        this.assemblers = assemblers;
    }
   
    
}
