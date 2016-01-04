/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse.datatypes.bioboxdatas;

import java.util.List;

/**
 *
 * @author Mark
 */
public class FastaType implements BBXArgument{
     private List<DataFormat> fasta;

    public List<DataFormat> getFasta() {
        return fasta;
    }

    public void setFasta(List<DataFormat> fasta) {
        this.fasta = fasta;
    }
    
}
