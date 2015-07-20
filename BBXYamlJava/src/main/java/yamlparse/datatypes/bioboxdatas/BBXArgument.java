/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse.datatypes.bioboxdatas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mark Ugarov
 */
public class BBXArgument{
    
    private FastqType fastq;
    private FragmentSizeType fragmentSize;
    
    private List<AbstractType> list;

    public List<AbstractType> getList() {
        this.list = new ArrayList<AbstractType>();
        if(this.getFastq() != null){
            this.list.add(this.getFastq());
        }
        if(this.getFragmentSize() != null){
            this.list.add(this.getFragmentSize());
        }
        return list;
    }

    public void setList(List<AbstractType> list) {
        this.setFastq((FastqType) list.get(0));
        if(list.size() > 1 ){
            this.setFragmentSize((FragmentSizeType) list.get(1));
        }
        this.list = list;
    }

    public FastqType getFastq() {
        return fastq;
    }

    public void setFastq(FastqType fastq) {
        this.fastq = fastq;
    }

    public FragmentSizeType getFragmentSize() {
        return fragmentSize;
    }

    public void setFragmentSize(FragmentSizeType fragmentSize) {
        this.fragmentSize = fragmentSize;
    }
    
    
    
}
