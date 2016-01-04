/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse.datatypes.applications;

/**
 *
 * @author Mark
 * 
 * 
 */
public class ImageType {

    private String dockerhub;
    private String repo;
    private String source;

    public String getDockerhub() {
        return dockerhub;
    }

    public String getRepo() {
        return repo;
    }

    public String getSource() {
        return source;
    }

    public void setDockerhub(String dockerhub) {
        this.dockerhub = dockerhub;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

    public void setSource(String source) {
        this.source = source;
    }
    
}
