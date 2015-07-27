/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse;

import yamlparse.parser.BioboxfileOutparser;
import yamlparse.parser.ApplicationInparser;

/**
 *
 * @author Mark
 * The startpoint of the program. 
 */
public class BBXYamlJava {
    
    public static void main(String [] args){
            // do nothing
    }
    
    /**
     * 
     * @return A new instance of ApplicationInparserGenerator.
     */
    public Inparser getNewApplicationInparser(){
        InparserGenerator inp = new InparserGenerator();
        return inp.getNewApplicationInparser();
    }
    
    /**
     * @return A new instance of the BioboxfileOutparser.
     */
    public BioboxfileOutparser getNewBioboxFileOutparser(){
        return new BioboxfileOutparser();
    }
}
