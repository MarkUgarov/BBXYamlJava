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
public class FastqType implements BBXArgument{
    
    private List<DataFormat> fastq;

    public List<DataFormat> getFastq() {
        return fastq;
    }

    public void setFastq(List<DataFormat> fastq) {
        this.fastq = fastq;
    }
    

    
}
