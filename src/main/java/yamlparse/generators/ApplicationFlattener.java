/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse.generators;

import java.util.ArrayList;
import yamlparse.datatypes.applications.Applications;
import yamlparse.datatypes.applications.Assembler;
import yamlparse.datatypes.applications.FlatAssembler;

/**
 *
 * @author Mark
 * 
 * This class provides the option to get a simple class of the Applications
 * (at this time: only assemblers) instead of a tree-like datastructure. 
 */
public class ApplicationFlattener {
    
    private Applications apps;
    private ArrayList<FlatAssembler> ass;
    
    public ApplicationFlattener(Applications appCont){
        this.apps = appCont;
        this.init();
    }
    
    private void init(){
        this.ass = new ArrayList<>();
        this.flatAssemblers();
    }
    
    private void flatAssemblers(){
        for (Assembler ass: this.getApps().getAssemblers()){
            this.ass.add(new FlatAssembler( ass.getImage().getDockerhub(),
                                            ass.getImage().getRepo(),
                                            ass.getImage().getSource(),
                                            ass.getPmid(),
                                            ass.getHomepage(),
                                            ass.getMailing_list(),
                                            ass.getDescription(),
                                            ass.getTasks()
                         )
            );
        }  
    }
    
    public ArrayList<FlatAssembler> getAssemblers(){
        return this.ass;
    }

    public Applications getApps() {
        return apps;
    }

    public void setApps(Applications apps) {
        this.apps = apps;
        this.init();
    }
    
    
}
