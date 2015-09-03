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
    
    public ApplicationsInparser(){
        this.parseResults = null;
    }
    
    public void parseIn(String yamlString){ 
        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            this.parseResults = mapper.readValue(yamlString, yamlparse.datatypes.applications.Applications.class);
        } catch (IOException ex) {
            Logger.getLogger(AbstractParseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ParseableType parse(String yamlString) {
        this.parseIn(yamlString);
        return this.parseResults;
    }
}
