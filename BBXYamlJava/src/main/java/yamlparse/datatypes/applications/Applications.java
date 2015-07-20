/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse.datatypes.applications;

import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Mark
 Representation of the Applications. 
 */
public class Applications {
    
    private List<Assembler> assemblers;

    public List<Assembler> getAssemblers() {
        return assemblers;
    }

    public void setAssemblers(List<Assembler> assemblers) {
        this.assemblers = assemblers;
    }
   
    
}
