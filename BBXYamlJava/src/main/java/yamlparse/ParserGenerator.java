/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse;

import yamlparse.parser.abstracts.AbstractParseManager;
import yamlparse.parser.Manager.InparseManager;
import yamlparse.parser.ApplicationsInparser;
import yamlparse.parser.BioboxfileOutparser;
import yamlparse.parser.Manager.OutparseManager;
import yamlparse.parser.abstracts.AbstractOutParser;


/**
 *
 * @author Mark
 */
public class ParserGenerator {
    /**
     * This class generates AbstractParseManager for specific applications. 
     */
    public ParserGenerator(){
        
    }
    
    public AbstractParseManager getNewApplicationInparser(){
        return new InparseManager(Constants.APPLICATIONS_LOCAL_FILE_NAME, Constants.APPLICATIONS_INPUT_FILE_URL, new ApplicationsInparser());
    }
    
    public AbstractParseManager getNewBioboxOutparser(){
        return new OutparseManager(Constants.BBX_FILE_NAME, new BioboxfileOutparser());
    }
    
}
