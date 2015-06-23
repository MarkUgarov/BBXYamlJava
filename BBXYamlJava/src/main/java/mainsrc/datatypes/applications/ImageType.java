/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainsrc.datatypes.applications;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 *
 * @author Mark
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="dockerhub")
public class ImageType {

    public String dockerhub;
    public String repo;
    public String source;
    public ImageType(String dh){
        this.dockerhub = dh;
    }
    
}
