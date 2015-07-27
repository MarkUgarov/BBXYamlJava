/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse.parser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import yamlparse.Inparser;
import yamlparse.datatypes.applications.Applications;

/**
 *
 * @author Mark
 */
public class ApplicationInparser extends Inparser{
    private URL url;
    private File localFile;
    private String localPath;
    
    // for updates
    private String webURLString;
    private InputStream inStream;
    private StringBuilder bsb;
    private BufferedReader in;
    private FileWriter writer;
    
    
    // for parsing
    private String yamlString;
    private YAMLFactory factory;
    private JsonParser parser;
    private Applications parseResults; 
   
    /**
     * Can be intantiated with two parameters.
     * @param path for the path where the local file will be created if you use
     * updateFile() and where the data will be read from in case you use 
     * readFile()
     * @param url for the online source where the data will be read from if you 
     * use updateFile() 
     */
    public ApplicationInparser(String path, String url){
        this.localPath = path;
        this.parseResults = null;
        this.yamlString = null;
        this.webURLString = url;
    }
    
    /**
     * Can be intantiated without parameters - don't forget to set the 
     * the url before updating and/or the path before reading  and/or the
     * yamlString before parsing seperatly.
     */
     public ApplicationInparser() {
        this.localPath = null;
        this.parseResults = null;
        this.yamlString = null;
        this.webURLString = null;
    }
    
    @Override
    public void parse(){ 
        try {
            if(this.yamlString== null){
                this.readFile();
                if(this.yamlString.length()==0){
                    this.updateFile();
                }
            }
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            this.parseResults = mapper.readValue(yamlString, yamlparse.datatypes.applications.Applications.class);
        } catch (IOException ex) {
            Logger.getLogger(Inparser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**
     * Sets the String for the parse()- method manually. 
     * @param inp is a String with the content of the input. 
     */
    @Override
    public void setYamlString(String inp){
        this.yamlString = inp;
    }
    /**
     * If you want to read out from a file, you can set the path here.
     * Don't forget to use the right slash depending on your filsystem and 
     * reread the file via the readFile() - method.
     * @param path is a String
     * Be careful: The file will be overwritten if you use updateFile() after 
     * that
     */
    @Override
    public void setlocalPath(String path){
        this.localPath = path;
    }
    
    @Override
    public String getlocalPath(){
        return this.localPath;
    }
    
    @Override
    public void readFile(){
         byte[] encoded;
        try {
            encoded = Files.readAllBytes(Paths.get(this.localPath));
            this.yamlString = new String(encoded, Charset.defaultCharset());
        } catch (IOException ex) {
            Logger.getLogger(Inparser.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
    /**
     * This will read from the url you set and set its content for the String
     * which will be parsed if you use parse() later on. 
     * Be careful: It will overwrite the current file on the local path. You
     * can change the path with the setlocalPath(String ...)- method. 
     */
    @Override
    public void updateFile(){
        //adjusting the input and ouput
        try {
            this.url = new URL(this.webURLString);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Inparser.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        this.localFile = new File(this.localPath);
        if (!this.localFile.exists()) {
            try {
                this.localFile.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Inparser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.localPath = this.localFile.getAbsolutePath();
        
        // reading and writing
        this.bsb = new StringBuilder();
        String line = null;
        try {
            
            this.inStream = this.url.openStream();
            this.in = new BufferedReader(new InputStreamReader(this.inStream));
            this.writer = new FileWriter(this.localFile, false);
            while ((line = this.in.readLine()) != null) {
                this.bsb.append(line);
                this.bsb.append(System.getProperty("line.separator"));
            }
            this.yamlString = this.bsb.toString();
            this.writer.write(this.yamlString);
            this.in.close();
            this.writer.close();
            
            
        } catch (IOException ex) {
            Logger.getLogger(Inparser.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }
    
    @Override
    public String getWebURLString() {
        return webURLString;
    }

    @Override
    public void setWebURLString(String webURLString) {
        this.webURLString = webURLString;
    }

    @Override
    public Applications getParseResults() {
        return parseResults;
    }
    
    @Override
    public String getString(){
        if(this.parseResults==null){
            return "No results could be found yet. Please parse valid data.";
        }
        else{
            return this.parseResults.getString();
        }
        
    }
}
