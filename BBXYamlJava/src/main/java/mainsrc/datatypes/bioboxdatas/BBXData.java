/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainsrc.datatypes.bioboxdatas;

import java.util.ArrayList;
import mainsrc.Constants;

/**
 *
 * @author Mark
 * 
 * This datatype represents the data of a biobox.yaml-file.
 */
public class BBXData {
    
    private BBXArgument format;
    private BBXDataField id;
    private BBXDataField type;
    private BBXDataField value;
    
    private ArrayList<BBXArgument> additionalArguments;
    
    private final String[] availableFormats;
    private final String[] availableTypes;
    
    private StringBuilder strB;
    
    public BBXData(String id){
        this.id = new BBXDataField("id", id);
        this.type = new BBXDataField("type", "paired");
        this.value = null;
        this.format = new BBXArgument("fastq");
        this.additionalArguments = new <BBXArgument>ArrayList();
        this.availableFormats = Constants.VALID_FORMATS;
        this.availableTypes = Constants.VALID_TYPES;    
        this.strB = new StringBuilder();
        
    }
    
    /**
     * Generates the full String for the biobox.yaml-file.
     * @return 
     */
    public String getString(){
        this.strB = new StringBuilder();
        String n = System.getProperty("line.separator");
        if(this.value == null){
            System.err.println("There is currently no value (of the input path) available.");
        }
        this.format.clear();
        this.format.addData(this.id);
        this.format.addData(this.type);
        this.format.addData(this.value);
        
        
        this.strB.append("---");
        this.strB.append(n);
        this.strB.append("version: \"");
        this.strB.append(Constants.BBX_VERSION);
        this.strB.append("\"");
        this.strB.append(n);
        this.strB.append("arguments:");
        this.strB.append(n);
        this.strB.append(this.format.getString());
        this.strB.append(n);
        for(BBXArgument arg: this.additionalArguments){
            this.strB.append(arg.getString());
            this.strB.append(n);
        }
    
        return this.strB.toString();
    }

    public String getFormatName() {
        return format.getName();
    }

    public String getId() {
        return id.getValue();
    }

    public String getType() {
        return type.getValue();
    }

    public String getValue() {
        return value.getValue();
    }

    public void setFormat(String inFormat) {
        boolean affirmed = false;
        for (String f: this.availableFormats){
            if(f.equals(inFormat)){
                this.format.setName(f);
                affirmed = true;
            }
        } 
        if(!affirmed){
            System.err.println(inFormat+" is not a valid format at this time!");
        }
    }

    public void setId(String id) {
        this.id = new BBXDataField("id", id);
    }

    public void setType(String inType) {
        boolean affirmed = false;
        for (String f: this.availableTypes){
            if(f.equals(inType)){
                this.type = new BBXDataField("type", f);
                affirmed = true;
            }
        } 
        if(!affirmed){
            System.err.println(inType+" is not a valid type at this time!");
        }
    }

    public void setValue(String value) {
        this.value = new BBXDataField("value", value);
    }
    
    /**
     * Adds additional arguments for the Biobox.yaml-file.
     * There is also a get/set option to work with those arguments. 
     * @param a valid BBXArgument. 
     * 
     */
    private void addArgument(BBXArgument arg){
        this.additionalArguments.add(arg);
    }
    
    /**
     * Gets an argument of the biobox.yaml-file. 
     * Note: There is an extra method for the format-argument. 
     * @param index 
     * @return the BBXArgument on index. 
     */
    private BBXArgument getArgument(int index){
        return this.additionalArguments.get(index);
    }
    
    /**
     * Sets an additional argument on a specific position. 
     * @param index 
     * @param arg the BBXArgument which has to be set 
     */
    private void setArgument(int index, BBXArgument arg){
        this.additionalArguments.set(index, arg);
    }
    
}
