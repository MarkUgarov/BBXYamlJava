/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainsrc.datatypes.applications;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.LinkedHashMap;

/**
 *
 * @author Mark
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="image")
public class Assembler extends Application{
    
    private ImageType image;
        
    private String pmid;
    private String homepage;
    private String description;
    private LinkedHashMap tasks; 

    public ImageType getImage() {
        return image;
    }

    public String getPmid() {
        return pmid;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getDescription() {
        return description;
    }

    public void setImage(ImageType image) {
        this.image = image;
    }

    public void setPmid(String pmid) {
        this.pmid = pmid;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LinkedHashMap getTasks() {
        return tasks;
    }

    public void setTasks(LinkedHashMap tasks) {
        this.tasks = tasks;
    }
    
    
    
}
