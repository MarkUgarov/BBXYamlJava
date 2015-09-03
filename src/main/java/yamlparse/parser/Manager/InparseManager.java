/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse.parser.Manager;

import yamlparse.parser.abstracts.AbstractInParser;
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
import yamlparse.parser.abstracts.AbstractParseManager;
import yamlparse.datatypes.ParseableType;
import yamlparse.parser.abstracts.AbstractParser;

/**
 *
 * @author Mark
 */
public class InparseManager extends AbstractParseManager{
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
    private ParseableType parseResults; 
    private AbstractInParser inparser;
   
    /**
     * Can be intantiated with two parameters.
     * @param path for the path where the local file will be created if you use
     * updateFile() and where the data will be read from in case you use 
     * readFile()
     * @param url for the online source where the data will be read from if you 
     * use updateFile() 
     */
    public InparseManager(String path, String url, AbstractInParser inp){
        this.localPath = path;
        this.parseResults = null;
        this.yamlString = null;
        this.webURLString = url;
        this.inparser = inp;
    }
    
    /**
     * Can be intantiated without parameters - don't forget to set the 
 the url before updating and/or the path before reading  and/or the
 yamlString before parsing seperatly AND set an AbstractInParser.
     */
     public InparseManager() {
        this.localPath = null;
        this.parseResults = null;
        this.yamlString = null;
        this.webURLString = null;
        this.inparser = null;
    }
    
    @Override
    public void parse(){ 
        if(this.yamlString== null){
            this.readFile();
            if(this.yamlString.length()==0){
                this.updateFile();
            }
        }
        this.parseResults =this.inparser.parse(yamlString);
    }
    
    
    /**
     * Sets the String for the parse()- method manually. 
     * @param inp is a String with the content of the input. 
     */
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
    public void setlocalPath(String path){
        this.localPath = path;
    }
    
    public String getlocalPath(){
        return this.localPath;
    }
    
    public void readFile(){
         byte[] encoded;
        try {
            encoded = Files.readAllBytes(Paths.get(this.localPath));
            this.yamlString = new String(encoded, Charset.defaultCharset());
        } catch (IOException ex) {
            Logger.getLogger(AbstractParseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
    /**
     * This will read from the url you set and set its content for the String
     * which will be parsed if you use parse() later on. 
     * Be careful: It will overwrite the current file on the local path. You
     * can change the path with the setlocalPath(String ...)- method. 
     */
    public void updateFile(){
        //adjusting the input and ouput
        try {
            this.url = new URL(this.webURLString);
        } catch (MalformedURLException ex) {
            Logger.getLogger(AbstractParseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        this.localFile = new File(this.localPath);
        if (!this.localFile.exists()) {
            try {
                this.localFile.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(AbstractParseManager.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AbstractParseManager.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }
    
    public String getWebURLString() {
        return webURLString;
    }

    public void setWebURLString(String webURLString) {
        this.webURLString = webURLString;
    }

    public ParseableType getParseResults() {
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

    public AbstractInParser getInparser() {
        return inparser;
    }

    public void setInparser(AbstractInParser inparser) {
        this.inparser = inparser;
    }

    @Override
    public void setParser(AbstractParser parser) {
        this.inparser = (AbstractInParser) parser;
    }
}
