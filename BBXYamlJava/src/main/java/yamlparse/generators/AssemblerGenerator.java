/**
 * Provides methods to generate a biobox.yaml - file for assemblers in an easy
 * way. 
 */
package yamlparse.generators;

import java.util.ArrayList;
import yamlparse.Constants;
import yamlparse.Constants.FastType;
import yamlparse.datatypes.bioboxdatas.*;
import yamlparse.parser.BioboxfileOutparser;
import yamlparse.parser.Manager.OutparseManager;

/**
 *
 * @author Mark
 */
public class AssemblerGenerator {
    
    private String version;
    
    private String fastqID;
    private FastType fastqType;
    private String fastqValue;
    
    private String fastqID2;
    private String fastqValue2;
   
    private String fsID;
    private String fsValue;
    
    private String fsID2;
    private String fsValue2;
    
    private OutparseManager outParsMan;
    private String outputPath;
    
    public AssemblerGenerator(){
        this.version = "0.9.0";
        // set default atom types
        this.fastqValue = null;
        this.fastqID= null;
        this.fastqType = null;
        this.fastqID2 = null;
        this.fastqValue2 = null;
        
        this.fsID = null;
        this.fsID2 = null;

        this.fsValue = null;
        this.fsValue2 = null;
        
        
        
        // generate a parser in advance
        this.outParsMan = new OutparseManager(Constants.BBX_FILE_NAME, new BioboxfileOutparser());
    }
    
    public void write(){
       
       // generating the fastq- part
       FastqType fastq = new FastqType();
       ArrayList<DataFormat> dataList1 = new ArrayList<>();
       DataFormat df1 = new DataFormat();
       df1.setId(this.fastqID);
       df1.setType(this.fastqType);
       df1.setValue(this.fastqValue);
       dataList1.add(df1);
       if(this.fastqType.equals(FastType.paired)){
           DataFormat df12 = new DataFormat();
           df12.setId(this.fastqID2);
           df12.setValue(this.fastqValue2);
           dataList1.add(df12);
       }
       fastq.setFastq(dataList1);
      

       // generate the fragment-size - part
       FragmentSizeType fragSize;
        if(this.fsValue != null && this.fsID != null){
            fragSize = new FragmentSizeType();
            ArrayList<DataFormat> dataList2 = new ArrayList<>();
            DataFormat df2 = new DataFormat();
            df2.setId(this.fsID);
            df2.setValue(this.fsValue);
            dataList2.add(df2);
            if(this.fastqType.equals(FastType.paired)){
                DataFormat df22 = new DataFormat();
                df22.setValue(this.fsValue2);
                df22.setId(this.fsID2);
                dataList2.add(df22);
            }
            fragSize.setFragment_size(dataList2);
       }
        else{
           fragSize = null; 
        }
       
       
       
       //add the components to the actual Top-FastType
       BioboxTopType top = new BioboxTopType();
       top.setVersion(this.version);
       ArrayList<BBXArgument> args = new ArrayList<>();
       args.add(fastq);
       args.add(fragSize);
       top.setArguments(args);
       
       //configure the output-path and name
       if (this.outputPath != null){
           this.outParsMan.setOutputPath(outputPath);
       }
       //start the parsing
       this.outParsMan.setToptype(top);
       this.outParsMan.parse();
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setFastqID(String fastqID) {
        if(this.fsID == null || this.fastqID.equals(this.fastqID)){
            this.fsID = fastqID;
        }
        this.fastqID = fastqID;
        if(this.fsID == null){
            this.fsID = fastqID;
        }
    }

    /**
     * Please don't forget that you need two values and ids if you want to
     * use paired reads. 
     * @param fastqType 
     */
    public void setFastqType(FastType fastqType) {
        this.fastqType = fastqType;
    }

    public void setFastqValue(String fastqValue) {
        this.fastqValue = fastqValue;
    }
    
    /**
     * Use carefully! Set only if you know what to do!
     * @param fsID will be the Fastq-ID at default
     */
    public void setFsID(String fsID) {
        this.fsID = fsID;
    }


    public void setFsValue(String fsValue) {
        this.fsValue = fsValue;
    }

    public void setOutParsMan(OutparseManager outParsMan) {
        this.outParsMan = outParsMan;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

     /**
     * for paired reads only
     */
    public String getFastqID2() {
        return fastqID2;
    }

     /**
     * for paired reads only
     */
    public void setFastqID2(String fastqID2) {
        if(this.fsID2 == null || this.fsID2.equals(this.fastqID2)){
            this.fsID2 = fastqID2;
        }
        this.fastqID2 = fastqID2;
    }

     /**
     * for paired reads only
     */
    public String getFastqValue2() {
        return fastqValue2;
    }
    
     /**
     * for paired reads only
     */
    public void setFastqValue2(String fastqValue2) {
        this.fastqValue2 = fastqValue2;
    }
    
    /**
     * for paired reads only
     */
    public String getFsID2() {
        return fsID2;
    }

    /**
     * For paired reads only.
     * Use carefully! Set only if you know what to do! 
     * @param fsID2 will be the Fastq-ID of the second fastq-value at default
     */
    public void setFsID2(String fsID2) {
        this.fsID2 = fsID2;
    }

     /**
     * for paired reads only
     */
    public String getFsValue2() {
        return fsValue2;
    }

     /**
     * for paired reads only
     */
    public void setFsValue2(String fsValue2) {
        this.fsValue2 = fsValue2;
    }
    
   
}
