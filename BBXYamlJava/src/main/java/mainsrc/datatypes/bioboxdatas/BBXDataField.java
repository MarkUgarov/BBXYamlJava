/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainsrc.datatypes.bioboxdatas;

/**
 *
 * @author Mark
 */
public class BBXDataField {
    private String name;
    private String value;
    private StringBuilder strB;
    
    
    public BBXDataField(String fieldName, String fieldValue){
        this.name = fieldName;
        this.value = fieldValue;
        
    }
    /**
     * Generates the String for this Datafield.
     * @return the .yaml-compatible substring of this datafield 
     */
    public String getString(){
        return(this.getName()+ ": \""+this.getValue()+"\"");
    }

    /**
     * @return name of the field
     */
    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
}
