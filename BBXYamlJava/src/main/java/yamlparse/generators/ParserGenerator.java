/**
 * This is a more general kind of 
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
     * Does not return an instance of ApplicationsInparser (there is an
     * "s" in the middle), but a InparseManager to parse in Applications.
     * @return an InparseManager with standard parameters to parse in a
     * file containing Applications
     * 
     */
    public InparseManager getNewApplicationInparser(){
        return new InparseManager(Constants.APPLICATIONS_LOCAL_FILE_NAME, Constants.APPLICATIONS_INPUT_FILE_URL, new ApplicationsInparser());
    }
    
    /**
     * Gets a BioboxOutparser; this is very clumsy, better use Generators 
     * unless you want to implement your own ParseableType.
     * @return a OutparseManager with standard parameters to parse out an
     * instance of BioboxTopType into a biobox.yaml - file
     */
    public OutparseManager getNewBioboxOutparser(){
        return new OutparseManager(Constants.BBX_FILE_NAME, new BioboxfileOutparser());
    }
    
}
