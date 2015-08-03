/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse.parser.Manager;

import yamlparse.datatypes.ParseableType;
import yamlparse.datatypes.bioboxdatas.BioboxTopType;
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

    @Override
    public void parse() {
        this.outparser.parse(this.localPath, this.topType);
    }

    @Override
    public String getString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String setOutputPath() {
        return localPath;
    }

    public void setOutputPath(String outputPath) {
        this.localPath = outputPath;
    }
    
    public ParseableType getToptype() {
        return topType;
    }

    public void setToptype(BioboxTopType toptype) {
        this.topType = toptype;
    }

    @Override
    public void setParser(AbstractParser parser) {
        this.outparser = (AbstractOutParser) parser;
    }
    
}
