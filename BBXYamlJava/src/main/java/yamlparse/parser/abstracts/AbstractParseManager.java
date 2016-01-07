/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse.parser.abstracts;


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
