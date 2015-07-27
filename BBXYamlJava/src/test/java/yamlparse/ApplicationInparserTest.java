/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse;

import yamlparse.parser.ApplicationInparser;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import yamlparse.datatypes.ParseableType;
import yamlparse.datatypes.applications.Applications;
import yamlparse.datatypes.applications.Assembler;
import yamlparse.datatypes.applications.ImageType;

/**
 *
 * @author Mark
 */
public class ApplicationInparserTest {
    
    public ApplicationInparserTest() {
    }

   /**
     * Test of parse method, of class Inparser.
     */
    @Test
    public void testParse() {
        System.out.println("parse");
        assertEquals(true,true);
    }

    /**
     * Test of setYamlString method, of class Inparser.
     */
    @Test
    public void testSetYamlString() {
        System.out.println("setYamlString");
        String newline = "\n";
        String inp = "---\n" +
                        "assemblers:\n" +
                        "  -\n" +
                        "    image:\n" +
                        "      dockerhub: bioboxes/velvet\n" +
                        "      repo: https://github.com/bioboxes/velvet\n" +
                        "      source: https://github.com/dzerbino/velvet\n" +
                        "    pmid: 18349386\n" +
                        "    homepage: https://www.ebi.ac.uk/~zerbino/velvet/\n" +
                        "    description:\n" +
                        "      The velvet assembler was one of the first assemblers created for short read sequencing. Velvet was developed at the European Bioinformatics Institute.\n" +
                        "    tasks:\n" +
                        "      - default\n" +
                        "      - careful";
        Inparser instance = new InparserGenerator().getNewApplicationInparser();
        instance.setYamlString(inp);
        instance.parse();
        Assembler ass = new Assembler();
        ImageType img = new ImageType();
        img.setDockerhub("bioboxes/velvet");
        img.setRepo("https://github.com/bioboxes/velvet");
        img.setSource("https://github.com/dzerbino/velvet");
        ass.setImage(img);
        ass.setPmid("18349386");
        ass.setHomepage("https://www.ebi.ac.uk/~zerbino/velvet/");
        ass.setDescription("The velvet assembler was one of the first assemblers created for short read sequencing. Velvet was developed at the European Bioinformatics Institute.");
        ass.setMailing_list(null);
        List tasks = new ArrayList();
        tasks.add("default");
        tasks.add("careful");
        ass.setTasks(tasks);
        Applications helperApp = new Applications();
        String expected = helperApp.getAssemblerString(ass);
        String parsedString = helperApp.getAssemblerString(((Applications)instance.getParseResults()).getAssemblers().get(0));
        assertEquals(expected,parsedString);
    }

    

    /**
     * Test of readFile method, of class Inparser.
     */
    @Test
    public void testReadFile() {
         System.out.println("readFile and updateFile");
        Inparser instance = new InparserGenerator().getNewApplicationInparser();
        
        try {
            File file = File.createTempFile("TempInpFile", null);
            instance.setlocalPath(file.getAbsolutePath());
                    } catch (IOException ex) {
            Logger.getLogger(ApplicationInparserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        instance.updateFile();
        instance.readFile();
        instance.parse();
        boolean assemblersFound = !(((ApplicationInparser)instance).getParseResults().getAssemblers().isEmpty());
        assertEquals(true,assemblersFound);
    }

    /**
     * Test of updateFile method, of class Inparser.
     */
    @Test
    public void testUpdateFile() {
        System.out.println("updateFile");
        Inparser instance = new InparserGenerator().getNewApplicationInparser();
         try {
            File file = File.createTempFile("TempInpFile", null);
            instance.setlocalPath(file.getAbsolutePath());
                    } catch (IOException ex) {
            Logger.getLogger(ApplicationInparserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        instance.updateFile();
        // no assertEquals needed because the method itself would throw an error
        // if an error occurs check your connection to the internet
    }

    
}
