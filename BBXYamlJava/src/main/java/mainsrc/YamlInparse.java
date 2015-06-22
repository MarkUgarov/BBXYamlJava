/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainsrc;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainsrc.datatypes.Assembler;

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


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
    private InputStream inStream;
    private StringBuilder bsb;
    private BufferedReader in;
    private FileWriter writer;
    
    
    // for parsing
    private String yamlString;
    private YAMLFactory factory;
    private JsonParser parser;
    private ArrayList<Assembler> assemblers;
  

    
    
    public YamlInparse(){
        this.localPath = Constants.LOCAL_FILE_NAME;
        this.assemblers = new <Assembler>ArrayList();
       
    }
    
    public void parseAtom(){
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(this.localPath));
            this.yamlString = new String(encoded, StandardCharsets.UTF_8);
            
            this.factory = new YAMLFactory();
            this.parser = factory.createParser(this.yamlString); // don't be fooled by method name...
            JsonToken token;
            int index = 0;
            String currentFieldName = null;
            String currentFieldValue = null;
            Assembler assembler =null;
                while ((token = this.parser.nextToken()) != null) {
                    System.out.println(this.parser.getCurrentName() + " "+ this.parser.getValueAsString());
                    
                    if(this.parser.getCurrentName() != null & this.parser.getCurrentTokenId() != 2){
                        if (this.parser.getCurrentName().equals("image") && !currentFieldName.equals("image")){ //sometimes "image" is shown multiple times
                            index++;
                            this.assemblers.add(new Assembler(index));
                            System.out.println("    new Assembler with index "+index + " and currentFieldName " +currentFieldName );
                            
                        }
                        currentFieldName =this.parser.getCurrentName();
                    }
                    currentFieldValue = this.parser.getValueAsString();
                    if(currentFieldValue!= null){
                        if(currentFieldName.equals("dockerhub")){
                             this.assemblers.get(index-1).setName(currentFieldValue);
                        }
                        else if(currentFieldName.equals("repo")){
                            this.assemblers.get(index-1).setRepository(currentFieldValue);
                        }
                        else if(currentFieldName.equals("source")){
                            this.assemblers.get(index-1).setSource(currentFieldValue);
                        }
                        else if(currentFieldName.equals("pmid")){
                            this.assemblers.get(index-1).setPmid(currentFieldValue);
                        }
                        else if(currentFieldName.equals("homepage")){
                            this.assemblers.get(index-1).setHomepage(currentFieldValue);
                        }
                        else if(currentFieldName.equals("mailing_list")){
                            this.assemblers.get(index-1).setMailing_list(currentFieldValue);
                        }
                        else if(currentFieldName.equals("description")){
                            this.assemblers.get(index-1).setDescription(currentFieldValue);
                        }
                        else if(currentFieldName.equals("tasks")){
                            this.assemblers.get(index-1).addTasks(currentFieldValue);
                        }
                        
                    }   
                }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(YamlInparse.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
                Logger.getLogger(YamlInparse.class.getName()).log(Level.SEVERE, null, ex);
        }
//        
        
    }
    
    public void parse(){
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(this.localPath));
            this.yamlString = new String(encoded, StandardCharsets.UTF_8);
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            Assembler ass = mapper.readValue(yamlString, mainsrc.datatypes.Assembler.class);
        } catch (IOException ex) {
            Logger.getLogger(YamlInparse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void listAllAssemblers(){
 
        System.out.println("---");
        System.out.println("asssemblers:");
        for(Assembler a: assemblers){
            System.out.println("-");
            System.out.println(a.getText());
        }
    }
    
    public void setlocalPath(String path){
        this.localPath = path;
    }
    
    public void updateFile(){
        
        //adjusting the input and ouput
        try {
            this.url = new URL(Constants.INPUT_FILE_URL);
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
        
        // reading and writing
        this.bsb = new StringBuilder();
        String line = null;
        try {
            
            this.inStream = this.url.openStream();
            this.in = new BufferedReader(new InputStreamReader(this.inStream));
            this.writer = new FileWriter(this.localFile, false);
            while ((line = this.in.readLine()) != null) {
                bsb.append(line);
                bsb.append(System.getProperty("line.separator"));
            }
            this.writer.write(this.bsb.toString());
            this.in.close();
            this.writer.close();
           
            
        } catch (IOException ex) {
            Logger.getLogger(YamlInparse.class.getName()).log(Level.SEVERE, null, ex);
        } 
//        System.out.println("DONE - Path is "+this.localFile.toPath());
    }
    
}
