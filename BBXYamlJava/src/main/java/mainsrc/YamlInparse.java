/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainsrc;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import mainsrc.datatypes.applications.Application;
import mainsrc.datatypes.applications.Assembler;


/**
 *
 * @author Mark
 * 
 * Created to pull the list (in form of a .yaml-file) of the Applikations from 
 *the url given in the mainsrc.Constants and convert this list in a Java-Object. 
 */
public class YamlInparse {
 
    private URL url;
    private File localFile;
    private String localPath;
    
    // for updates
    private String webURLString;
    private InputStream inStream;
    private StringBuilder bsb;
    private BufferedReader in;
    private FileWriter writer;
    
    
    // for parsing
    private String yamlString;
    private YAMLFactory factory;
    private JsonParser parser;
    private List<Assembler> assemblers;
    
    public YamlInparse(){
        this.localPath = Constants.LOCAL_FILE_NAME;
        this.assemblers = new ArrayList<Assembler>();
        this.yamlString = null;
        this.webURLString = Constants.INPUT_FILE_URL;
    }
    
    public void parse(){ 
        try {
            if(this.yamlString== null){
                this.readFile();
                if(this.yamlString.length()==0){
                    this.updateFile();
                }
            }
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            Application app = mapper.readValue(yamlString, mainsrc.datatypes.applications.Application.class);
            this.setAssembler(app.getAssemblers());
        } catch (IOException ex) {
            Logger.getLogger(YamlInparse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void listAllAssemblers(){
        System.out.println("---");
        System.out.println("assemblers:");
        for(Assembler ass:this.assemblers){
            System.out.println(this.getAssemblerString(ass));
        }

    }
    
    /**
     * The standard method to set the input.
     * @param inp is a String with the content of the input. 
     */
    public void setYamlString(String inp){
        this.yamlString = inp;
    }
    /**
     * If you want to read out from a file, you can set the path here.
     * Don't forget to use the right slash depending on your filsystem and 
     * reread the file via the read() - method.
     * @param path is a String - please make sure you 
     */
    public void setlocalPath(String path){
        this.localPath = path;
    }
    
    public String getlocalPath(){
        return this.localPath;
    }
    
    public void readFile(){
         byte[] encoded;
        try {
            encoded = Files.readAllBytes(Paths.get(this.localPath));
            this.yamlString = new String(encoded, Charset.defaultCharset());
        } catch (IOException ex) {
            Logger.getLogger(YamlInparse.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
    public void updateFile(){
        //adjusting the input and ouput
        try {
            this.url = new URL(this.getWebURLString());
        } catch (MalformedURLException ex) {
            Logger.getLogger(YamlInparse.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        this.localFile = new File(this.localPath);
        if (!this.localFile.exists()) {
            try {
                this.localFile.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(YamlInparse.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.localPath = this.localFile.getAbsolutePath();
        
        // reading and writing
        this.bsb = new StringBuilder();
        String line = null;
        try {
            
            this.inStream = this.url.openStream();
            this.in = new BufferedReader(new InputStreamReader(this.inStream));
            this.writer = new FileWriter(this.localFile, false);
            while ((line = this.in.readLine()) != null) {
                this.bsb.append(line);
                this.bsb.append(System.getProperty("line.separator"));
            }
            this.yamlString = this.bsb.toString();
            this.writer.write(this.yamlString);
            this.in.close();
            this.writer.close();
            
            
        } catch (IOException ex) {
            Logger.getLogger(YamlInparse.class.getName()).log(Level.SEVERE, null, ex);
        } 
//        System.out.println("DONE - Path is "+this.localFile.toPath());
    }
    
    private String getAssemblerString(Assembler ass){
        String n = System.getProperty("line.separator");
        StringBuilder taskLister = new StringBuilder();
        return new String(
                "   image:"+n+
                "       dockerhub: " +ass.getImage().getDockerhub() +n+
                "       repo: " + ass.getImage().getRepo() +n+
                "       source: "+ ass.getImage().getSource() + n+ 
                "   pmid: "+ass.getPmid() +n+
                "   homepage: "+ ass.getHomepage() + n+
                "   description:" + ass.getDescription() +n+
                "   mailing list: "+ass.getMailing_list()+n+
                "   tasks: " +n + ass.getTasks().toString()
        );
    }

    public String getWebURLString() {
        return webURLString;
    }

    public void setWebURLString(String webURLString) {
        this.webURLString = webURLString;
    }

    public List<Assembler> getAssemblers() {
        return assemblers;
    }

    public void setAssembler(List<Assembler> assembler) {
        this.assemblers = assembler;
    }
    
}
