/**
 * 
 * Originally the BBXYamlJava mainmethod was like this:
 * 
 * public static void main(String [] args){
    YamlInparse  inp=new YamlInparse();
    inp.updateFile(); // getting the default file from the default url
    inp.parse(); // parsing the content of the file
    inp.listAllAssemblers(); // list all assemblers to show it works

    YamlOutparse out = new YamlOutparse();
    out.generateTest();//there was a method generating the complex data types
    // for further information about creating a propper Input for the 
    // outparser see junit testcases
    out.write(); // write out the datatypes in the default file
        
    }
 */
package mainsrc;
