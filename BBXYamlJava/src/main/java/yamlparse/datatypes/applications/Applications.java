/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse.datatypes.applications;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import yamlparse.datatypes.ParseableType;

/**
 *
 * @author Mark
 Representation of the Applications. 
 */
public class Applications extends ParseableType {
    
    private List<Assembler> assemblers;

    public List<Assembler> getAssemblers() {
        return assemblers;
    }

    public void setAssemblers(List<Assembler> assemblers) {
        this.assemblers = assemblers;
    }

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
    
    public ArrayList<FlatAssembler> getFlatAssemblers(){
       
        ApplicationFlattener appFlat = new ApplicationFlattener(this);
        return appFlat.getAssemblers();

        
    }
   
    
}
