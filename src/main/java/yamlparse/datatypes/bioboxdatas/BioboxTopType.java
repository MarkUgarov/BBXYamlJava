/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse.datatypes.bioboxdatas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import yamlparse.datatypes.ParseableType;

/**
 *
 * @author Mark Ugarov
 
  * Data structure of this package (adapted for assemblers):
                        _________
                        |BioboxTopType|
                            |
                         (lists)
                      ______|_____
                      |BBXArgument|
                  (has a List<AbstractType> 
                     with two Elements)
                     /             \ 
                    /               \
                (uses)              (uses)
                  /                    \
       __________/_________     ________\___________
       |FastqType         |     |FragmentSizeType  |
       |(ext.BBXArgument)|     |(ext.BBXArgument)|
              |                        |
           (uses)                    (uses)
         _____|______             _____|______
         |DataFormat|             |DataFormat|
 * 
 */
public class BioboxTopType implements ParseableType{
    private String version;
    private List<BBXArgument> arguments;

    public List<BBXArgument> getArguments() {
        return arguments;
    }

    public void setArguments(List<BBXArgument> arguments) {
        this.arguments = arguments;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    
   
    @Override
    @JsonIgnore 
    public String getString() {
        return ("This is not sufficiently implemented yet because usually it "
                + "is not necessary. You can get the output from the written "
                + "biobox.yaml-file");
    }
    
    
}
