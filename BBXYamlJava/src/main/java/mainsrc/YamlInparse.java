/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainsrc;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.logging.log4j.core.util.FileUtils;

/**
 *
 * @author Mark
 * 
 * Created to pull the list (in form of a .yaml-file) of the Applikations from 
 *the url given in the mainsrc.Constants and convert this list in a Java-Object. 
 */
public class YamlInparse {
 
    private URL url;
    private File localFile;
    
    
    public YamlInparse(){
        this.updateFile();

    }
    
    private void updateFile(){
        
        try {
            this.url = new URL(Constants.INPUT_FILE_URL);
        } catch (MalformedURLException ex) {
            Logger.getLogger(YamlInparse.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        this.localFile = new File(Constants.LOCAL_FILE_NAME);
        if (!this.localFile.exists()) {
            try {
                this.localFile.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(YamlInparse.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            Files.copy(this.url.openStream(), this.localFile.toPath(),StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(YamlInparse.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("DONE - Path is "+this.localFile.toPath());
    }
    
}
