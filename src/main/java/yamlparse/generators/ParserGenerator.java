/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse.generators;

import yamlparse.Constants;
import yamlparse.parser.Manager.InparseManager;
import yamlparse.parser.ApplicationsInparser;
import yamlparse.parser.BioboxfileOutparser;
import yamlparse.parser.Manager.OutparseManager;


/**
 *
 * @author Mark
 */
public class ParserGenerator {
    /**
     * This class generates AbstractParseManager for specific applications
     * or BioboxOutparser for biobox.yaml-files. 
     */
    public ParserGenerator(){
        
    }
    
    /**
     * Returns an ApplicationInparser.
     * @return a 
     */
        public InparseManager getNewApplicationInparser(){
        return new InparseManager(Constants.APPLICATIONS_LOCAL_FILE_NAME, Constants.APPLICATIONS_INPUT_FILE_URL, new ApplicationsInparser());
    }
    
    /**
     * Gets a BioboxOutparser. This is very clumsy, better use Generators 
     * unless you want to implement your own ParseableType.
     * @return 
     */
    public OutparseManager getNewBioboxOutparser(){
        return new OutparseManager(Constants.BBX_FILE_NAME, new BioboxfileOutparser());
    }
    
}
