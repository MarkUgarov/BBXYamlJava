/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse;

import yamlparse.parser.ApplicationInparser;
import yamlparse.datatypes.applications.Applications;
import yamlparse.parser.AssemblyEvaluationInparser;

/**
 *
 * @author Mark
 */
public class InparserGenerator {
    /**
     * This class generates Inparser for specific applications. 
     */
    public InparserGenerator(){
        
    }
    
    public Inparser getNewApplicationInparser(){
        return new ApplicationInparser(Constants.APPLICATIONS_LOCAL_FILE_NAME, Constants.APPLICATIONS_INPUT_FILE_URL);
    }
    public Inparser getNewAssemblyEvaluationInparser(){
        return new AssemblyEvaluationInparser(Constants.ASSEMBLY_EVALUATION_LOCAL_FILE_NAME, Constants.ASSEMBLY_EVALUATION_FILE_URL);
    }
}
