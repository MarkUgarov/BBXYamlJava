/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse;

import yamlparse.generators.AssemblerGenerator;
import yamlparse.generators.AssemblyEvaluationGenerator;
import yamlparse.generators.ParserGenerator;
import yamlparse.parser.abstracts.AbstractParseManager;
import yamlparse.parser.BioboxfileOutparser;
import yamlparse.parser.Manager.InparseManager;
import yamlparse.parser.Manager.OutparseManager;

/**
 *
 * @author Mark
 * The startpoint of the program. 
 */
public class BBXYamlJava {
    
    public static void main(String [] args){
            // do nothing
    }
    
    /**
     * 
     * @return A new instance of ApplicationInparserGenerator.
     */
    public InparseManager getNewApplicationInparser(){
        ParserGenerator inp = new ParserGenerator();
        return inp.getNewApplicationInparser();
    }
    
    /**
     * An old method, very complicated - better use Generators for outparsing. 
     * @return A new instance of the BioboxfileOutparser.
     */
    public OutparseManager getNewBioboxFileOutparser(){
        ParserGenerator outp = new ParserGenerator();
        return outp.getNewBioboxOutparser();
    }
    
    public AssemblerGenerator getNewAssemblerGenerator(){
        return new AssemblerGenerator();
    }
    
    public AssemblyEvaluationGenerator getNewAssemblyEvaluationGenerator(){
        return new AssemblyEvaluationGenerator();
    }
}
