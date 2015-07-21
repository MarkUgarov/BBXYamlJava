/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse.assemblyevaluation;

import java.util.ArrayList;

/**
 *
 * @author Mark
 */
public class ValidationFile {
    private String $schema;
    private String title;
    private String type;
    
    private Properties properties;
    
    private ArrayList<String> required;
    
    private boolean additionalProperties;
    
    private Definitions definitions;
    
}
