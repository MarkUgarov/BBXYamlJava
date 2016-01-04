/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse.generators;

import java.util.ArrayList;
import yamlparse.Constants;
import yamlparse.datatypes.bioboxdatas.BBXArgument;
import yamlparse.datatypes.bioboxdatas.BioboxTopType;
import yamlparse.datatypes.bioboxdatas.Cache;
import yamlparse.datatypes.bioboxdatas.DataFormat;
import yamlparse.datatypes.bioboxdatas.FastaType;
import yamlparse.datatypes.bioboxdatas.Fasta_DirType;
import yamlparse.parser.BioboxfileOutparser;
import yamlparse.parser.Manager.OutparseManager;

/**
 *
 * @author Mark
 */
public class AssemblyEvaluationGenerator {
    
    private String version;
    
    private String fastaID;
    private Constants.FastType fastaType;
    private String fastaValue;
    
    private String fastaDir;
    private String cache;
    
    
    private String outputPath;
    private OutparseManager outParsMan;
    
    public AssemblyEvaluationGenerator(){
        this.version = Constants.BBX_VERSION;
        this.fastaID = null;
        this.fastaType = null;
        this.fastaValue= null;
        this.fastaDir = null;
        this.cache = null;
        this.outputPath = null;
        this.outParsMan = new OutparseManager(Constants.BBX_FILE_NAME, new BioboxfileOutparser());
    }
    /**
     * Writes the current set of data to a file with the set outputpath.
     */
    public void write(){
       // generating the fasta- part
       FastaType fasta = new FastaType();
       ArrayList<DataFormat> dataList1 = new ArrayList<>();
       DataFormat df1 = new DataFormat();
       df1.setId(this.fastaID);
       df1.setType(this.fastaType);
       df1.setValue(this.fastaValue);
       dataList1.add(df1);
       fasta.setFasta(dataList1);
       
       // set the fasta_dir
       Fasta_DirType fdir = new Fasta_DirType();
       fdir.setFasta_dir(this.fastaDir);
        
       // set the cache
       Cache c = new Cache();
       c.setCache(this.cache);
        
       // set the top-component
       BioboxTopType top = new BioboxTopType();
       top.setVersion(this.version);
       ArrayList<BBXArgument> args = new ArrayList<>(); 
       args.add(fasta);
       args.add(fdir);
       args.add(c);
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
     * Sets the bioboxes-version.
     * @param version should be something like X.Y.Z (0.9.0 is default)
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Sets the ID of the fasta file.
     * @param fastaID can be any string and is null at default
     */
    public void setFastaID(String fastaID) {
        this.fastaID = fastaID;
    }

    /**
     * Sets the type of the fasta. 
     * @param fastaType should be "scaffold" or "contig" .
     */
    public void setFastaType(Constants.FastType fastaType) {
        this.fastaType = fastaType;
    }

    /**
     * Sets the value of the fasta file. 
     * @param fastaValue should be a valid path of an existing fasta file. 
     */
    public void setFastaValue(String fastaValue) {
        this.fastaValue = fastaValue;
    }

    /**
     * Sets the directory of fasta-files. 
     * @param fastaDir should be the path or the parent directory of fasta-files
     */
    public void setFastaDir(String fastaDir) {
        this.fastaDir = fastaDir;
    }

    /**
     * Sets the cache. Should be dpendend on the working system. 
     * @param cache will be null at default 
     */
    public void setCache(String cache) {
        this.cache = cache;
    }

    /**
     * Sets the path whre to write this file by using the write()-method. 
     * @param outputPath should be a valid path to a file which will be created
     * by using write()
     */
    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }
    
    
}
