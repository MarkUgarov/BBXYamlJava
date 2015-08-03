/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse;

import yamlparse.parser.abstracts.AbstractParseManager;
import yamlparse.parser.BioboxfileOutparser;
import yamlparse.parser.Manager.InparseManager;

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
    public AbstractParseManager getNewApplicationInparser(){
        ParserGenerator inp = new ParserGenerator();
        return inp.getNewApplicationInparser();
    }
    
    /**
     * @return A new instance of the BioboxfileOutparser.
     */
    public BioboxfileOutparser getNewBioboxFileOutparser(){
        return new BioboxfileOutparser();
    }
}
