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
* Care: this is not to create a file describing instances of the class
* yamlparse.datatypes.applications.Assembler, but to create a biobox-file
* containing all parameters necessary for a biobox which runs an assembler.
*
 * @author Mark
 * This is a more comfortable way to create biobox-files for Assembler-bioboxes.
 * It holds the all parameters as a BioboxTopType with one or two fastq-files
 * would hold, but you can set parameters directly even if they have a higher
 * level. 
 * E.g. you can set the fastq-value by 
 * #AssemblerGenerator().setFastqValue(String fastqValue) instead of
 *((FastqType) #BioboxTopType.getArguments().get(0)).getFastq().setValue(String value)
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
    
    private boolean shuffled;
    
    /**
     * Care: this is not to create a file describing instances of the class
     * yamlparse.datatypes.applications.Assembler, but to create a biobox-file
     * containing all parameters necessary for a biobox which runs an assembler.
     */
    public AssemblerGenerator(){
        this.version = Constants.BBX_VERSION;
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
        
        this.shuffled = false;
        
        // generate a parser in advance
        this.outParsMan = new OutparseManager(Constants.BBX_FILE_NAME, new BioboxfileOutparser());
    }
    
    /**
     *  Writes the current set of data to a file with the set outputpath.
     */
    public void write(){
       
       // generating the fastq- part
       FastqType fastq = new FastqType();
       ArrayList<DataFormat> dataList1 = new ArrayList<>();
       DataFormat df1 = new DataFormat();
       df1.setId(this.fastqID);
       df1.setType(this.fastqType);
       df1.setValue(this.fastqValue);
       dataList1.add(df1);
       if(this.fastqType.equals(FastType.paired) && !this.shuffled){
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
            if(this.fastqType.equals(FastType.paired)&& !this.shuffled){
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

    /**
     * Set the version of bioboxes.
     * @param version is 0.9.0 at default
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Sets the ID for the (first) fastq. Can be any String. Will set the
     * the ID of the fragment-size (fs) too if it was not set before. 
     * @param fastqID is the ID for the first fastq file (default: null)
     */
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
     * use paired reads - in that case you have to set FastqID2 and 
     * FastqValue2 too.
     * @param fastqType can be "paired" or "unpaired" 
     */
    public void setFastqType(FastType fastqType) {
        this.fastqType = fastqType;
    }

    /**
     * Sets the value of the (first) fastq file. 
     * @param fastqValue should be a path to a valid file to assemble
     */
    public void setFastqValue(String fastqValue) {
        this.fastqValue = fastqValue;
    }
    
    /**
     * Use carefully! Set only if you know what to do!
     * This will set the ID for the fragment-size (fs). Fs will not be written 
     * as long as the ID or the value is null.  The ID of the fs has to match 
     * one of the fastqIDs.
     * @param fsID will set the ID for the fragment-size (default: fastqID)
     */
    public void setFsID(String fsID) {
        this.fsID = fsID;
    }

    /**
     * This will set the value of the fragment-size (fs). Fs will not be written 
     * as long as the ID or the value is null.  
     * @param fsValue will set the value of the fragment-size (default: null),
     * should be a number
     */
    public void setFsValue(String fsValue) {
        this.fsValue = fsValue;
    }

    /**
     * Use carefully! Set only if you know what to do!
     * @param outParsMan 
     */
    public void setOutParsMan(OutparseManager outParsMan) {
        this.outParsMan = outParsMan;
    }

    /**
     * This will set the path of the file which will be created by calling the 
     * write() - method. 
     * @param outputPath has to be a valid path (for a file which will be 
     * created)
     */
    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

     /**
     * Get the ID of the second fastq file. Will be null if not set. 
     * @return the ID from the second fastq.
     * For unshuffled paired reads only, will not be written otherwise.
     */
    public String getFastqID2() {
        return fastqID2;
    }

     /**
     * Sets the ID of the second fastq file. The ID of the second fragment-size 
     * (fs2) will be set also if it was null before.
     * For unshuffled paired reads only, will not be written otherwise. 
     * @param fastqID2 the ID of the second fastq
     */
    public void setFastqID2(String fastqID2) {
        if(this.fsID2 == null || this.fsID2.equals(this.fastqID2)){
            this.fsID2 = fastqID2;
        }
        this.fastqID2 = fastqID2;
    }

     /**
      *  Will be null at default. Be careful: will only be written if 
      * paired unshuffled.
     * @return the current value of the second fastq (should be paired or null)
     */
    public String getFastqValue2() {
        return fastqValue2;
    }
    
     /**
     * Sets the value of the second fragment-size (fs2). 
     * Be careful: will only be written if paired unshuffled.
     * @param fastqValue2 should be paired (or null)
     */
    public void setFastqValue2(String fastqValue2) {
        this.fastqValue2 = fastqValue2;
    }
    
    /**
     * Null or  (if set) the ID of the second fastq at default. 
     * Be careful: will only be written if paired unshuffled.
     * @return the ID of the second fastq
     */
    public String getFsID2() {
        return fsID2;
    }

    /**
     * Use carefully! Set only if you know what to do! Equals the ID of the
     * second fragment-size (or null if not set) at default. 
     * Be careful: will only be written if paired unshuffled.
     * @param fsID2 will be the Fastq-ID of the second fastq-value at default
     */
    public void setFsID2(String fsID2) {
        this.fsID2 = fsID2;
    }

     /**
      * 
     * Be careful: will only be written if paired unshuffled.
     * @return the value of the second fragment-size as String, should be a 
     * number or null
     */
    public String getFsValue2() {
        return fsValue2;
    }

     /**
     * Set the value for the second fragment size.
     * Be careful: will only be written if paired unshuffled.
     * @param fsValue2 should be a number or null
     */
    public void setFsValue2(String fsValue2) {
        this.fsValue2 = fsValue2;
    }
    
    /**
     *
     * Set shuffled. 
     * This will disable to write all "second" elements (like FastqID2, 
     * FsID2...)
     */
    public void setShuffled(){
        this.shuffled = true;
    }
    
    /**
     * Set unshuffled. 
     * This will enable to write all "second" elements (like FastqID2, 
     * FsID2...) but be careful: they still won't be written if they are null.
     */
    public void setUnshuffled(){
        this.shuffled = false;
    }
    
    /**
     * Check if shuffled is set. 
     * @return true if shuffled is set, false otherwise. 
     */
    public boolean isShuffled(){
        return this.shuffled;
    }
   
}
