/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainsrc;

import yamlparse.YamlOutparse;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import yamlparse.datatypes.bioboxdatas.AbstractType;
import yamlparse.datatypes.bioboxdatas.DataFormat;
import yamlparse.datatypes.bioboxdatas.FastqType;
import yamlparse.datatypes.bioboxdatas.FragmentSizeType;
import yamlparse.datatypes.bioboxdatas.TopType;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mark
 */
public class YamlOutparseTest {
    
    public YamlOutparseTest() {
    }

    

    /**
     * Test of write method, of class YamlOutparse.
     */
    @Test
    public void testWrite() {
        System.out.println("write");
        YamlOutparse instance = new YamlOutparse();
        String result = null;
        try {
            // writing a testfile
            File file = File.createTempFile("TempOutFile", "yaml");
            instance.setOutputPath(file.getAbsolutePath());
            instance.setToptype(this.generateTestTopType());
            instance.write();
            // reading out from the file
            byte[] encoded = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
            result = new String(encoded, Charset.defaultCharset());
        } catch (IOException ex) {
            Logger.getLogger(YamlOutparseTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        String expected = "---\n" +
                        "version: \"0.9.0\"\n" +
                        "arguments:\n" +
                        "- fastq:\n" +
                        "  - id: \"testID1\"\n" +
                        "    type: \"testType1\"\n" +
                        "    value: \"testValue1\"\n" +
                        "- fragment_size:\n" +
                        "  - id: \"testID2\"\n" +
                        "    type: null\n" +
                        "    value: \"testValue2\"";
        assertEquals(expected,result);
    }
    
    private TopType generateTestTopType(){
        TopType toptype = new TopType();
        FastqType fq = new FastqType();
        List<DataFormat> dfList1= new ArrayList<>();
        DataFormat df1 = new DataFormat(); 
        df1.setId("testID1");
        df1.setType("testType1");
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
        ArrayList<AbstractType> args = new ArrayList<>();
        args.add(fq);
        args.add(fs);
        toptype.setArguments(args);
        toptype.setVersion("0.9.0");
        return toptype;
    }
    
}
