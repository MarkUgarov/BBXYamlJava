/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import yamlparse.datatypes.bioboxdatas.BioboxTopType;

/**
 *
 * @author Mark
 * 
 * This is a tool to create an biobox.yaml-file.  
 */
public class BioboxfileOutparser {
    
    private String outputPath;
    private BioboxTopType toptype;
    
    public BioboxfileOutparser(){ 
        this.outputPath = Constants.BBX_FILE_NAME;
    }

    public void write(){
        File localFile = new File(this.outputPath);
       
        try {
            if (!localFile.exists()) {
                localFile.createNewFile();
            }
            this.setOutputPath(localFile.getAbsolutePath());

            YAMLFactory factory = new YAMLFactory();
            ObjectMapper yamlmap = new ObjectMapper(factory);
            FileOutputStream fos = new FileOutputStream(localFile);

            factory.createGenerator(fos).writeObject(this.getToptype());
        } catch (IOException ex) {
            Logger.getLogger(BioboxTopType.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public BioboxTopType getToptype() {
        return toptype;
    }

    public void setToptype(BioboxTopType toptype) {
        this.toptype = toptype;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }
   
}
