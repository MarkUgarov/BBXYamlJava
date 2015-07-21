/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse.datatypes.bioboxdatas;

import java.util.List;

/**
 *
 * @author Mark Ugarov
 
  * Data structure of this package:
                        _________
                        |BioboxTopType|
                            |
                         (lists)
                      ______|_____
                      |BBXArgument|
                  (has a List<AbstractType> 
 *                     with two Elements)
 *                     /             \ 
 *                    /               \
 *                (uses)              (uses)
 *                  /                    \
 *       __________/_________     ________\___________
 *       |FastqType         |     |FragmentSizeType  |
 *       |(ext.AbstractType)|     |(ext.AbstractType)|
 *              |                        |
 *           (uses)                    (uses)
 *         _____|______             _____|______
 *         |DataFormat|             |DataFormat|
 * 
 */
public class BioboxTopType {
    private String version;
    private List<AbstractType> arguments;

    public List<AbstractType> getArguments() {
        return arguments;
    }

    public void setArguments(List<AbstractType> arguments) {
        this.arguments = arguments;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    
    
}
