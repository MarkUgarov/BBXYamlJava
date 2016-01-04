/**
 * This is used for creating biobox.yml - files for Assembler as well as 
 * for AssemblyEvaluation
 */
package yamlparse.datatypes.bioboxdatas;

import yamlparse.Constants.FastType;




/**
 *
 * @author mugarov
 */
public class DataFormat {
    private String id;
    private FastType type;
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

    public FastType getType() {
        return type;
    }

    public void setType(FastType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
}
