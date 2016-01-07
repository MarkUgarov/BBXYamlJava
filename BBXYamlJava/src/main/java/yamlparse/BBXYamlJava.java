/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse;

import yamlparse.generators.AssemblerGenerator;
import yamlparse.generators.AssemblyEvaluationGenerator;
import yamlparse.generators.ParserGenerator;
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
     * This returns a InparseManger which has a method to parse datas describing 
     * applications out of a file.
     * @return A new instance of ApplicationInparserGenerator.
     */
    public InparseManager getNewApplicationInparser(){
        ParserGenerator inp = new ParserGenerator();
        return inp.getNewApplicationInparser();
    }
    
    /**
     * A clumsy method - better use Generators. Otherwise you have to 
     * create an AbstractOutParser manually. Use only if you want to 
     * implement your own ParseableType.
     * @return A new instance of the BioboxfileOutparser.
     */
    public OutparseManager getNewBioboxFileOutparser(){
        ParserGenerator outp = new ParserGenerator();
        return outp.getNewBioboxOutparser();
    }
    
    /**
     * The easiest way to create a biobox.yaml file for bioboxes running 
     * assmeblers: Use the returning AssemblerGenerator to configure the
     * parameters and use #.write to finish.
     * @return an AssemblerGenerator with simple methods to set all data
     */
    public AssemblerGenerator getNewAssemblerGenerator(){
        return new AssemblerGenerator();
    }
    
    /**
     * The easiest way to create a biobox.yaml file for bioboxes running 
     * evaluation data: Use the returning AssemblyEvaluationGenerator to 
     * configure the parameters and use #.write to finish.
     * @return an AssemblyEvaluationGenerator with simple methods to set all 
     * data 
     */
    public AssemblyEvaluationGenerator getNewAssemblyEvaluationGenerator(){
        return new AssemblyEvaluationGenerator();
    }
}
