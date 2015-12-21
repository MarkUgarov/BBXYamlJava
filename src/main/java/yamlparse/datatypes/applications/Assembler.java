/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse.datatypes.applications;

import java.util.List;

/**
 *
 * @author Mark
 */

public class Assembler extends Applications{
    
    private ImageType image;
        
    private String pmid;
    private String homepage;
    private String description;
    private List<String> tasks; 
    private String mailing_list;

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

    public List<String> getTasks() {
        return tasks;
    }

    public void setTasks(List<String> tasks) {
        this.tasks = tasks;
    }

    /**
     * @return the mailing_list
     */
    public String getMailing_list() {
        return mailing_list;
    }

    /**
     * @param mailing_list the mailing_list to set
     */
    public void setMailing_list(String mailing_list) {
        this.mailing_list = mailing_list;
    }
    
    
    
}
