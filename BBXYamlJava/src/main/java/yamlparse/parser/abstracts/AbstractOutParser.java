/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse.parser.abstracts;

import yamlparse.datatypes.ParseableType;


/**
 *
 * @author Mark
 */
public abstract class AbstractOutParser extends AbstractParser {

    /**
     * Should 
     * @param outputPath
     * @param topType
     */
    public abstract void parse(String outputPath, ParseableType topType );
}
