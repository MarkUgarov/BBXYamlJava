/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainsrc;

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
     * @return A new instance of YamlInparse.
     */
    public YamlInparse getNewYamlInparser(){
        return new YamlInparse();
    }
    
    /**
     * @return A new instance of the YamlOutparse.
     */
    public YamlOutparse getNewYamlOutparser(){
        return new YamlOutparse();
    }
}
