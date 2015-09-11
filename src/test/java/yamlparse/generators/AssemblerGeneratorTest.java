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
public class AssemblerGeneratorTest {
    
    public AssemblerGeneratorTest() {
    }

    /**
     * Test of write method, of class AssemblerGenerator.
     * The generateTestTopType - method is a good example for how to use a 
     * AssemblerGenerator. 
     */
    @Test
    public void testWrite() {
        System.out.println("write");
        AssemblerGenerator instance;
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
                        "- fastq:\n" +
                        "  - id: \"testID1\"\n" +
                        "    type: \"unpaired\"\n" +
                        "    value: \"testValue1\"\n" +
                        "- fragment_size:\n" +
                        "  - id: \"testID2\"\n" +
                        "    value: \"testValue2\"";
        //System.out.println(result);
        assertEquals(expected,result);
        
    }

   private AssemblerGenerator generateTestTopType(){
        AssemblerGenerator instance = new AssemblerGenerator();
        instance.setFastqID("testID1");
        instance.setFastqType(Constants.FastType.unpaired);
        instance.setFastqValue("testValue1");
        
        instance.setFsID("testID2");
        //instance.setFsType(Constants.FastType.paired);
        instance.setFsValue("testValue2");
        
        return instance;
    }
    
}
