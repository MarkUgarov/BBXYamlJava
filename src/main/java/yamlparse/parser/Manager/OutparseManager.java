/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse.parser.Manager;

import yamlparse.datatypes.ParseableType;
import yamlparse.parser.abstracts.AbstractOutParser;
import yamlparse.parser.abstracts.AbstractParseManager;
import yamlparse.parser.abstracts.AbstractParser;

/**
 *
 * @author Mark
 */
public class OutparseManager extends AbstractParseManager{
    private String localPath;
    private AbstractOutParser outparser;
    

    private ParseableType topType;
    
    public OutparseManager(String path, AbstractOutParser out){
        this.localPath = path;
        this.outparser = out;
        this.topType = null;
    }

    /**
     * Parses the current Toptype into a file described by the current 
     * outputPath. 
     */
    @Override
    public void parse() {
        this.outparser.parse(this.localPath, this.topType);
    }

    /**
     * Not supported! 
     * If necessary, this method has to be implemented
     * by reading out the parsed file (what seems to be pretty nonsense at this 
     * time).
     * @return 
     */
    @Override
    public String getString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * @return the current outputPath. Please check validity by yourself.
     */
    public String getOutputPath() {
        return localPath;
    }
  
    /**
     * Sets the ouputPath of the file where to parse the Toptype.
     * @param outputPath 
     */
    public void setOutputPath(String outputPath) {
        this.localPath = outputPath;
    }
    
    /**
     * @return the current ParseableType (usually a BioboxTopType) which will
     * be parsed into the file by using parse()
     */
    public ParseableType getToptype() {
        return topType;
    }

    /**
     * Sets the Toptype which to parse into a the file described be the 
     * outputPath
     * @param toptype must be a valid toptype (usually a BioboxTopType) which 
     * will  be parsed into a file when using parse().
     */
    public void setToptype(ParseableType toptype) {
        this.topType = toptype;
    }

    /**
     * To set a new AbstractParser (usually a BioboxfileOutparser which will
     * be used to parse. 
     * @param parser must be an AbstractOutParser!
     */
    @Override
    public void setParser(AbstractParser parser) {
        this.outparser = (AbstractOutParser) parser;
    }
    
    
}
