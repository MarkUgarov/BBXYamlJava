/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainsrc.datatypes.applications;

import java.util.ArrayList;

/**
 *
 * @author mugarov
 * Just a prototype of an Assembler using private fields.
 */
public class PrivateAssembler extends Application{
    private int id;
    
    private String name;
    
    private String type;
    
    private String description;
    
    private String repository;
    
    private String source;
    
    private String pmid; 
    
    private String homepage;
    
    private String mailing_list;
    
    private ArrayList<String> tasks;
    
    
    public PrivateAssembler(int id){
        this.id = id;
        this. name = null;
        this. type = "assemblers";
        this.description = null;
        this.repository = null;
        this.source = "unkonw";
        this.homepage = null;
        this.mailing_list = "not available";
        this.tasks = new <String>ArrayList();        
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getRepository() {
        return repository;
    }

    public String getSource() {
        return source;
    }

    public String getPmid() {
        return pmid;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getMailing_list() {
        return mailing_list;
    }

    public ArrayList<String> getTasks() {
        return tasks;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setPmid(String pmid) {
        this.pmid = pmid;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public void setMailing_list(String mailing_list) {
        this.mailing_list = mailing_list;
    }
    
     public void setTasks(ArrayList<String> tasks) {
        this.tasks = tasks;
    }
    
    public void addTasks(String task) {
        this.tasks.add(task);
    }
    
    public String getText(){
        String n = System.getProperty("line.separator");
        StringBuilder taskLister = new StringBuilder();
        for (String t: this.tasks){
            taskLister.append("    - "+t+n);
        }
        return new String(
                "   image:"+n+
                "       dockerhub: " +this.name +n+
                "       repo: " + this.repository +n+
                "       source: "+ this.source + n+ 
                "   pmid: "+this.pmid +n+
                "   homepage: "+ this.homepage + n+
                "   description:" + this.description +n+
                "   tasks: " +n + taskLister.toString()
        );
    }

   

   


}
