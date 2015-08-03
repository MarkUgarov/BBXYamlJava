/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse.datatypes.bioboxdatas;

import yamlparse.Constants.Type;




/**
 *
 * @author mugarov
 */
public class DataFormat {
    private String id;
    private Type type;
    private String value;
    


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setId(int id) {
        this.id = id+"";
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
}
