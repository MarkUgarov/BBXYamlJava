/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse.datatypes.assemblyevaluation;

import java.util.ArrayList;
import yamlparse.datatypes.ParseableType;

/**
 *
 * @author Mark
 */
public class AssemblyEvaluationTopType extends ParseableType{
    private String $schema;
    private String title;
    private String type;
    
    private Properties properties;
    
    private ArrayList<String> required;
    
    private boolean additionalProperties;
    
    private Definitions definitions;
    
    @Override
    public String getString(){
       String n = System.getProperty("line.separator");
       StringBuilder taskLister = new StringBuilder();
       String ret = new String(
               "$schema: " + this.$schema +n+
               "title: " +this.title +n+
                       "This ist just a small test."
       );
       return ret;
    }

    public String get$schema() {
        return $schema;
    }

    public void set$schema(String $schema) {
        this.$schema = $schema;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public ArrayList<String> getRequired() {
        return required;
    }

    public void setRequired(ArrayList<String> required) {
        this.required = required;
    }

    public boolean isAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(boolean additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    public Definitions getDefinitions() {
        return definitions;
    }

    public void setDefinitions(Definitions definitions) {
        this.definitions = definitions;
    }
    
}
