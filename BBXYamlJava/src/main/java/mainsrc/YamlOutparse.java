/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainsrc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainsrc.datatypes.bioboxdatas.AbstractType;
import mainsrc.datatypes.bioboxdatas.DataFormat;
import mainsrc.datatypes.bioboxdatas.TopType;
import mainsrc.datatypes.bioboxdatas.FastqType;
import mainsrc.datatypes.bioboxdatas.FragmentSizeType;

/**
 *
 * @author Mark
 * 
 * This is a tool to create an biobox.yaml-file.  
 */
public class YamlOutparse {
    
    private String outputPath;
    private TopType toptype;
    
    public YamlOutparse(){ 
        this.outputPath =Constants.BBX_FILE_NAME;
    }

    
    public void generateTest(){
        this.toptype = new TopType();
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
        this.toptype.setArguments(args);
        this.toptype.setVersion("0.9.0");
    }
    

    public void write(){
        File localFile = new File(this.outputPath);
        if (!localFile.exists()) {
            try {
                localFile.createNewFile();
                this.outputPath = localFile.getAbsolutePath();
        
                YAMLFactory factory = new YAMLFactory();
                ObjectMapper yamlmap = new ObjectMapper(factory);
                FileOutputStream fos = new FileOutputStream(localFile);

                factory.createGenerator(fos).writeObject(this.toptype);
            } catch (IOException ex) {
                Logger.getLogger(YamlInparse.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    
    
}
