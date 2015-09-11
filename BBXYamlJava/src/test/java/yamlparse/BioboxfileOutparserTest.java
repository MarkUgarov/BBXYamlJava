/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse;

import yamlparse.generators.ParserGenerator;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import yamlparse.datatypes.bioboxdatas.BBXArgument;
import yamlparse.datatypes.bioboxdatas.DataFormat;
import yamlparse.datatypes.bioboxdatas.FastqType;
import yamlparse.datatypes.bioboxdatas.FragmentSizeType;
import yamlparse.datatypes.bioboxdatas.BioboxTopType;
import org.junit.Test;
import static org.junit.Assert.*;
import static yamlparse.Constants.FastType;
import yamlparse.datatypes.bioboxdatas.Cache;
import yamlparse.datatypes.bioboxdatas.FastaType;
import yamlparse.datatypes.bioboxdatas.Fasta_DirType;

import yamlparse.parser.Manager.OutparseManager;

/**
 *
 * @author Mark
 */
public class BioboxfileOutparserTest {
    /**
     * PLEASE NOTE THIS IS A GENERAL TEST AND NOT A GOOD EXAMPLE FOR USAGE.
     * For better useable examples look at the Generator-Tests.
     */
    public BioboxfileOutparserTest() {
    }

    

    /**
     * Test of parse method, of class BioboxfileOutparser.
     */
    @Test
    public void testWrite() {
        System.out.println("write");
        OutparseManager instance = (OutparseManager)(new ParserGenerator().getNewBioboxOutparser());
        String result = null;
        try {
            // writing a testfile
            File file = File.createTempFile("TempOutFile", "yaml");
            file.createNewFile();
            instance.setOutputPath(file.getAbsolutePath());
            instance.setToptype(this.generateTestTopType());
            instance.parse();
            // reading out from the file
            byte[] encoded = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
            result = new String(encoded, Charset.defaultCharset());
        } catch (IOException ex) {
            Logger.getLogger(BioboxfileOutparserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        String expected = "---\n" +
                        "version: \"0.9.0\"\n" +
                        "arguments:\n" +
                        "- fastq:\n" +
                        "  - id: \"testID1\"\n" +
                        "    type: \"unpaired\"\n" +
                        "    value: \"testValue1\"\n" +
                        "- fragment_size:\n" +
                        "  - id: \"testID2\"\n" +
                        "    value: \"testValue2\"\n" +
                        "- fasta:\n"+
                        "  - id: \"testID3\"\n"+
                        "    type: \"contig\"\n"+
                        "    value: \"testPath\"\n"+
                        "- fasta_dir: \"TestDir\"\n"+
                        "- cache: \"noCache\"";
        //System.out.println(result);
        assertEquals(expected,result);
    }
    
    private BioboxTopType generateTestTopType(){
        BioboxTopType toptype = new BioboxTopType();
        // start of the parameters of assemblers
        FastqType fq = new FastqType();
        List<DataFormat> dfList1= new ArrayList<>();
        DataFormat df1 = new DataFormat(); 
        df1.setId("testID1");
        df1.setType(FastType.unpaired);
        df1.setValue("testValue1");
        dfList1.add(df1);
        fq.setFastq(dfList1);
        
        FragmentSizeType fs = new FragmentSizeType();
        List<DataFormat> dfList2= new ArrayList<>();
        DataFormat df2 = new DataFormat(); 
        df2.setId("testID2");
        df2.setValue("testValue2");
        dfList2.add(df2);
        fs.setFragment_size(dfList2);
        
        // start of the parameters of assembly-evaluation
        Fasta_DirType fdir = new Fasta_DirType();
        fdir.setFasta_dir("TestDir");
        
        FastaType fa = new FastaType();
        List<DataFormat> dfList3= new ArrayList<>();
        DataFormat df3 = new DataFormat(); 
        df3.setId("testID3");
        df3.setType(FastType.contig);
        df3.setValue("testPath");
        dfList3.add(df3);
        fa.setFasta(dfList3);
        
        Cache c = new Cache();
        c.setCache("noCache");
        
        ArrayList<BBXArgument> args = new ArrayList<>();
        args.add(fq);
        args.add(fs);
        args.add(fa);
        args.add(fdir);
        args.add(c);
        toptype.setArguments(args);
        toptype.setVersion("0.9.0");
        return toptype;
    }
    
}
