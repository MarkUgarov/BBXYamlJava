/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse.datatypes.assemblyevaluation;

import java.util.ArrayList;

/**
 *
 * @author Mark
 */
public class Items {
    private ArrayList<Reference> oneOf;
    private String type;
    private boolean additionalProperties;
    private ArrayList<String> required;
    private Properties properties;

    public ArrayList<Reference> getOneOf() {
        return oneOf;
    }

    public void setOneOf(ArrayList<Reference> oneOf) {
        this.oneOf = oneOf;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(boolean additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    public ArrayList<String> getRequired() {
        return required;
    }

    public void setRequired(ArrayList<String> required) {
        this.required = required;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
