/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.net.URL;
import java.nio.file.Path;

/**
 *
 * @author Mark
 * Contains the constants. 
 */
public abstract class Constants {
    
    // for the YamlApplicationInparser
    public static final String APPLICATIONS_INPUT_FILE_URL = "https://raw.githubusercontent.com/bioboxes/data/master/images.yml";
    public static final String APPLICATIONS_LOCAL_FILE_NAME= "ApplicationList.yaml";
    
    //for the YamlBioboxfileOutparser
    public static final String BBX_VERSION = "0.9.0";
    public static final String BBX_FILE_NAME= "biobox.yaml";
    public static final String[] VALID_FORMATS ={"fastq"};
    public static enum Type implements Serializable {paired, unpaired, scaffold, contig}
   
    // for the YamlAssemblyEvaluationOutparser
    public static final String ASSEMBLY_EVALUATION_FILE_URL = "https://raw.githubusercontent.com/bioboxes/rfc/master/container/assembly-evaluation/input_schema.yaml";
    public static final String ASSEMBLY_EVALUATION_LOCAL_FILE_NAME= "AssemblyEvaluationData.yaml";
    
}
