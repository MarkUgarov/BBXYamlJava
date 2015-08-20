/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse.parser.abstracts;

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
public abstract class AbstractParseManager {
    
   
    /**
     * Can be intantiated with two parameters.
     * @param path for the path where the local file will be created if you use
     * updateFile() and where the data will be read from in case you use 
     * readFile()
     * @param url for the online source where the data will be read from if you 
     * use updateFile() 
     */
    public AbstractParseManager(String path, String url){
        
    };
    
    /**
     * Can be intantiated without parameters - don't forget to set the 
     * the url before updating and/or the path before reading  and/or the
     * yamlString before parsing seperatly AND set the parser.
     */
    public AbstractParseManager(){
        
    };
    
    public abstract void parse();
    
    public abstract String getString();
    
    public abstract void setParser(AbstractParser parser);

}
