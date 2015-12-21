/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse.parser;

import yamlparse.parser.abstracts.AbstractInParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import yamlparse.parser.abstracts.AbstractParseManager;
import yamlparse.datatypes.ParseableType;
import yamlparse.datatypes.applications.Applications;

/**
 *
 * @author Mark
 */
public class ApplicationsInparser extends AbstractInParser{
    
    private Applications parseResults;
    
    /**
     * You might not choose to call this constructor but to use methods 
     * of the ParserGenerator to get an ApplicationInparser which has also 
     * the parse()-method.
     */
    public ApplicationsInparser(){
        this.parseResults = null;
    }
    
    private void parseIn(String yamlString){ 
        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            this.parseResults = mapper.readValue(yamlString, yamlparse.datatypes.applications.Applications.class);
        } catch (IOException ex) {
            Logger.getLogger(AbstractParseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Parses any String into an instance of the class Applications if the 
     * String hsa a valid format.
     * @param yamlString should be a String in a yaml-format representing an
     * instance of yamlparse.datatypes.applications.Applications
     * @return a ParseableType which can be cast to 
     * yamlparse.datatypes.applications.Applications
     */
    @Override
    public ParseableType parse(String yamlString) {
        this.parseIn(yamlString);
        return this.parseResults;
    }
}
