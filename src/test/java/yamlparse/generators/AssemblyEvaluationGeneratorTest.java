/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse.generators;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import yamlparse.BioboxfileOutparserTest;
import yamlparse.Constants;

/**
 *
 * @author Mark
 */
public class AssemblyEvaluationGeneratorTest {
    
    public AssemblyEvaluationGeneratorTest() {
    }

    /**
     * Test of write method, of class AssemblyEvaluationGenerator.
     */
    @Test
    public void testWrite() {
        System.out.println("write");
        AssemblyEvaluationGenerator instance;
        String result = null;
        try {
            // writing a testfile
            File file = File.createTempFile("TempOutFile", "yaml");
            file.createNewFile();       
            instance = this.generateTestTopType();
            instance.setOutputPath(file.getAbsolutePath());
            instance.write();
            // reading out from the file
            byte[] encoded = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
            result = new String(encoded, Charset.defaultCharset());
        } catch (IOException ex) {
            Logger.getLogger(BioboxfileOutparserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        String expected = "---\n" +
                        "version: \"0.9.0\"\n" +
                        "arguments:\n" +
                        "- fasta:\n"+
                        "  - id: \"TestFastaID\"\n"+
                        "    type: \"scaffold\"\n"+
                        "    value: \"testPathFASTA\"\n"+
                        "- fasta_dir: \"TestFastaDir\"\n"+
                        "- cache: \"noCache\"";
        //System.out.println(result);
        assertEquals(expected,result);
    }

    private AssemblyEvaluationGenerator generateTestTopType(){
        AssemblyEvaluationGenerator instance = new AssemblyEvaluationGenerator();
        instance.setFastaID("TestFastaID");
        instance.setFastaType(Constants.FastType.scaffold);
        instance.setFastaValue("testPathFASTA");
        
        instance.setFastaDir("TestFastaDir");
        instance.setCache("noCache");
        
        return instance;
    }
    
    
}
