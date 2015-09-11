/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse.parser;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import yamlparse.datatypes.ParseableType;
import yamlparse.datatypes.bioboxdatas.BioboxTopType;
import yamlparse.parser.abstracts.AbstractOutParser;

/**
 *
 * @author Mark
 * 
 * This is a tool to create an biobox.yaml-file.  
 */
public class BioboxfileOutparser extends AbstractOutParser{
    
    /**
     * Only to check if the output is on the right path.
     */
    private String path;

    public BioboxfileOutparser() {
        this.path = null;
    }


    @Override
    public void parse(String outputPath, ParseableType abstractTop) {
        File localFile = new File(outputPath);
        BioboxTopType bbxType = (BioboxTopType) abstractTop;
        try {
            if (!localFile.exists()) {
                localFile.createNewFile();
            }
            this.path = localFile.getAbsolutePath();

            YAMLFactory factory = new YAMLFactory();
            ObjectMapper yamlmap = new ObjectMapper(factory);

            
            yamlmap.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            FileOutputStream fos = new FileOutputStream(localFile);

            factory.createGenerator(fos).writeObject(bbxType);
        } catch (IOException ex) {
            Logger.getLogger(BioboxfileOutparser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * To test if the file is on the right path.
     * @return the absolut path of the written file
     */
    public String getPath() {
        return path;
    }
}