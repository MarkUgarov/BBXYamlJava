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
        YamlInparse  inp=new YamlInparse();
        inp.updateFile();
        inp.parseAtom();
        inp.listAllAssemblers();
        
        YamlOutparse out = new YamlOutparse("testparser");
        out.setBBXInputPath("testvalue");
        out.write();
        
    }
}
