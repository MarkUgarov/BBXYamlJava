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
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="image")
public class Assembler extends Application{
    
    public ImageType image;
        
    public String pmid;
    public String homepage;
    public String description;
    
    public Assembler(ImageType img){
        this.image = img;
    }
    
}
