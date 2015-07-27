/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse;

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
import yamlparse.datatypes.ParseableType;


/**
 *
 * @author Mark
 */
public abstract class Inparser {
    
   
    /**
     * Can be intantiated with two parameters.
     * @param path for the path where the local file will be created if you use
     * updateFile() and where the data will be read from in case you use 
     * readFile()
     * @param url for the online source where the data will be read from if you 
     * use updateFile() 
     */
    public Inparser(String path, String url){
        
    };
    
    /**
     * Can be intantiated without parameters - don't forget to set the 
     * the url before updating and/or the path before reading  and/or the
     * yamlString before parsing seperatly.
     */
    public Inparser(){
        
    };
    
    public abstract void parse();
    
    
    /**
     * Sets the String for the parse()- method manually. 
     * @param inp is a String with the content of the input. 
     */
    public abstract void setYamlString(String inp);
    /**
     * If you want to read out from a file, you can set the path here.
     * Don't forget to use the right slash depending on your filsystem and 
     * reread the file via the readFile() - method.
     * @param path is a String
     * Be careful: The file will be overwritten if you use updateFile() after 
     * that
     */
    public abstract void setlocalPath(String path);
    
    public abstract String getlocalPath();
    
    public abstract void readFile();
    
    /**
     * This will read from the url you set and set its content for the String
     * which will be parsed if you use parse() later on. 
     * Be careful: It will overwrite the current file on the local path. You
     * can change the path with the setlocalPath(String ...)- method. 
     */
    public abstract void updateFile();
    
    public abstract String getWebURLString();

    public abstract void setWebURLString(String webURLString);

    public abstract ParseableType getParseResults();
    
    public abstract String getString();

}
