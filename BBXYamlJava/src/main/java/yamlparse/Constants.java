/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse;

import java.net.URL;
import java.nio.file.Path;

/**
 *
 * @author Mark
 * Contains the constants. 
 */
public abstract class Constants {
    
    // for the YamlInparse
    public static final String INPUT_FILE_URL = "https://raw.githubusercontent.com/bioboxes/data/master/images.yml";
    public static final String LOCAL_FILE_NAME= "ApplicationList.txt";
    
    //for the YamlOutparse
    public static final String BBX_VERSION = "0.9.0";
    public static final String BBX_FILE_NAME= "biobox.yaml";
    public static final String[] VALID_FORMATS ={"fastq"};
    public static final String[] VALID_TYPES = {"paired","unpaired"};
    
}
