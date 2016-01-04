/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse.datatypes.applications;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This is a comfortable class in which holds the same parameters 
 * as Assembler, but also provides direct methods to get parameters of
 * higher level directly. 
 * E.g. you can use #FlatAssembler.getDockerhub() instead of 
 * #FlatAssembler.getImage().getDockerhub().
 * @author Mark
 */
public class FlatAssembler {
    
    // image
    private String dockerhub;
    private String repository;
    private String source;
    // rest
    private String pmid;
    private String homepage; 
    private String mailingList;
    private String description;
    private List<String> tasks;
    
    public FlatAssembler(String hub, String repo, String src, String pmid, String homepg, String ml, String descr, String tsk){
        this.dockerhub = hub;
        this.repository = repo;
        this.source = src;
        this.pmid = pmid;
        this.homepage = homepg;
        this.mailingList = ml;
        this.description = descr;
        this.tasks = new ArrayList<>(Arrays.asList(tsk.split(" ")));
    }
    
    public FlatAssembler(String hub, String repo, String src, String pmid, String homepg, String ml, String descr, List<String> tsk){
        this.dockerhub = hub;
        this.repository = repo;
        this.source = src;
        this.pmid = pmid;
        this.homepage = homepg;
        this.mailingList = ml;
        this.description = descr;
        this.tasks = tsk;
    }
    
    /**
     * @return an ArrayList<String> containing dockerhub, repository and source
     * (in this order)
     */
    public ArrayList<String> getImage(){
        ArrayList<String> ret = new ArrayList<>();
        ret.add(this.dockerhub);
        ret.add(this.repository);
        ret.add(this.source);
        return ret;
    }

    public String getDockerhub() {
        return dockerhub;
    }

    public void setDockerhub(String dockerhub) {
        this.dockerhub = dockerhub;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPmid() {
        return pmid;
    }

    public void setPmid(String pmid) {
        this.pmid = pmid;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }
    
    public String getMailingList() {
        return mailingList;
    }

    public void setMailingList(String mailingList) {
        this.mailingList = mailingList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<String> tasks) {
        this.tasks = tasks;
    }
    
    public void clearTasks(){
        this.tasks = new ArrayList<>();
    }
    
    public void removeTask(int pos){
        this.tasks.remove(pos);
    }
    
    public void addTask(String tsk){
        this.tasks.add(tsk);
    } 
}
