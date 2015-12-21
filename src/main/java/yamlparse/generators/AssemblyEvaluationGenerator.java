/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse.generators;

import java.util.ArrayList;
import java.util.List;
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
//    "version: \"0.9.0\"\n" +
//                        
//                        "- fasta:\n"+
//                        "  - id: \"testID3\"\n"+
//                        "    type: \"unpaired\"\n"+
//                        "    value: \"testPath\"\n"+
//                        "- fasta_dir: \"TestDir\"\n"+
//                        "- cache: \"noCache\"";
    
    private String version;
    
    private String fastaID;
    private Constants.FastType fastaType;
    private String fastaValue;
    
    private String fastaDir;
    private String cache;
    
    
    private String outputPath;
    private OutparseManager outParsMan;
    
    public AssemblyEvaluationGenerator(){
        this.version = "0.9.0";
        this.fastaID = null;
        this.fastaType = null;
        this.fastaValue= null;
        this.fastaDir = null;
        this.cache = null;
        this.outputPath = null;
        this.outParsMan = new OutparseManager(Constants.BBX_FILE_NAME, new BioboxfileOutparser());
    }
    
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

    public void setVersion(String version) {
        this.version = version;
    }

    public void setFastaID(String fastaID) {
        this.fastaID = fastaID;
    }

    public void setFastaType(Constants.FastType fastaType) {
        this.fastaType = fastaType;
    }

    public void setFastaValue(String fastaValue) {
        this.fastaValue = fastaValue;
    }

    public void setFastaDir(String fastaDir) {
        this.fastaDir = fastaDir;
    }

    public void setCache(String cache) {
        this.cache = cache;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }
    
    
}
