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
   
    private String fsID;
    private FastType fsType;
    private String fsValue;
    
    private OutparseManager outParsMan;
    private String outputPath;
    
    public AssemblerGenerator(){
        this.version = "0.9.0";
        // set default atom types
        this.fastqID= null;
        this.fastqType = null;
        this.fastqValue = null;
        this.fsID = null;
        this.fsType = null;
        this.fsValue = null;
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
       fastq.setFastq(dataList1);

       // generate the fragment-size - part
       FragmentSizeType fragSize = new FragmentSizeType();
       ArrayList<DataFormat> dataList2 = new ArrayList<>();
       DataFormat df2 = new DataFormat();
       df2.setId(this.fsID);
       df2.setType(this.fsType);
       df2.setValue(this.fsValue);
       dataList2.add(df2);
       fragSize.setFragment_size(dataList2);
       
       
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
        this.fastqID = fastqID;
    }

    public void setFastqType(FastType fastqType) {
        this.fastqType = fastqType;
    }

    public void setFastqValue(String fastqValue) {
        this.fastqValue = fastqValue;
    }

    public void setFsID(String fsID) {
        this.fsID = fsID;
    }

    public void setFsType(FastType fsType) {
        this.fsType = fsType;
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
    
   
}
