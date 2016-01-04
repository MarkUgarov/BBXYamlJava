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
 */
public class FragmentSizeType implements BBXArgument{
                
   private List<DataFormat> fragment_size;

    public List<DataFormat> getFragment_size() {
        return fragment_size;
    }

    public void setFragment_size(List<DataFormat> fragment_size) {
        this.fragment_size = fragment_size;
    }
   
    
}
