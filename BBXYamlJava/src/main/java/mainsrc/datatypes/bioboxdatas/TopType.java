/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainsrc.datatypes.bioboxdatas;

import java.util.List;

/**
 *
 * @author mugarov
 */
public class TopType {
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
