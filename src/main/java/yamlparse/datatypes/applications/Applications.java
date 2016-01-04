/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse.datatypes.applications;

import yamlparse.generators.ApplicationFlattener;
import java.util.ArrayList;
import java.util.List;
import yamlparse.datatypes.ParseableType;

/**
 *
 * @author Mark
 Representation of the Applications. 
 */
public class Applications implements ParseableType {
    
    private List<Assembler> assemblers;

    /**
     * This method returns a list of a clumsy datatype Assembler you should
     * try to use getFlatAssemblers to get a much more comfortable List of 
     * FlatAssembler.
     * @return the 
     */
    public List<Assembler> getAssemblers() {
        return assemblers;
    }

    /**
     * 
     * @param assemblers 
     */
    public void setAssemblers(List<Assembler> assemblers) {
        this.assemblers = assemblers;
    }

    /**
     * This method is written for tests and comparisons. 
     * @return a String which should be the same as the content of the file. 
     */
    @Override
    public String getString() {
        String n = System.getProperty("line.separator");
        StringBuilder taskLister = new StringBuilder();
        taskLister.append("---");
        taskLister.append(n);
        taskLister.append("assemblers");
        taskLister.append(n);
        for(Assembler ass:this.assemblers){
            taskLister.append(this.getAssemblerString(ass));
            taskLister.append(n);
        }
        return taskLister.toString();
    }
   
    /**
     * This method is written for tests and comparisons. 
     * @param ass can be any instance of the type Assembler 
     * @return a String representing ass
     */
    public String getAssemblerString(Assembler ass){
        String n = System.getProperty("line.separator");
        StringBuilder taskLister = new StringBuilder();
        return new String(
                "   image:"+n+
                "       dockerhub: " +ass.getImage().getDockerhub() +n+
                "       repo: " + ass.getImage().getRepo() +n+
                "       source: "+ ass.getImage().getSource() + n+ 
                "   pmid: "+ass.getPmid() +n+
                "   homepage: "+ ass.getHomepage() + n+
                "   description:" + ass.getDescription() +n+
                "   mailing list: "+ass.getMailing_list()+n+
                "   tasks: " +n + ass.getTasks().toString()
        );
    }
    
    /**
     * For a much simpler usage than Assembler (which is only implemented for
     * parsing), this returns a List of FlatAssemblers.
     * @return a List of FlatAssemblers with the same data as the instances 
     * of Assembler in this instance of Applications
     */
    public ArrayList<FlatAssembler> getFlatAssemblers(){
       
        ApplicationFlattener appFlat = new ApplicationFlattener(this);
        return appFlat.getAssemblers();

        
    }
   
    
}
