/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainsrc;

import mainsrc.datatypes.bioboxdatas.BBXData;

/**
 *
 * @author Mark
 * 
 * This is a tool to create an biobox.yaml-file.  
 */
public class YamlOutparse {
    
    private BBXData data;
    private String path;
    
    public YamlOutparse(String id){
        this.data = new BBXData(id);
        this.path = Constants.BBX_FILE_NAME;
    }

    public BBXData getData() {
        return data;
    }

    public void setData(BBXData data) {
        this.data = data;
    }
    
    public void setBBXInputPath(String path){
        this.data.setValue(path);
    }
    

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    /**
     * TODO: Actually write that file!
     */
    public void write(){
        System.out.println(this.data.getString());
    }
    
}
