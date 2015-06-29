/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainsrc;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainsrc.datatypes.applications.Assembler;
import mainsrc.datatypes.applications.ImageType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mark
 */
public class YamlInparseTest {
    
    public YamlInparseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
//        System.out.println("Start testing a method in YamlInparse");
    }
    
    @After
    public void tearDown() {
//        System.out.println("A Test of YamlInparse has been past.");
    }

  

    

    /**
     * Test of setYamlString method, of class YamlInparse.
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
        YamlInparse instance = new YamlInparse();
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
        String expected = this.getAssemblerString(ass);
        String parsedString = this.getAssemblerString(instance.getAssemblers().get(0));
        assertEquals(expected,parsedString);
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


    /**
     * Test of readFile and the updateFile method, of class YamlInparse.
     */
    @Test
    public void testReadFile() {
        System.out.println("readFile and updateFile");
        YamlInparse instance = new YamlInparse();
        
        try {
            File file = File.createTempFile("TempInpFile", null);
            instance.setlocalPath(file.getAbsolutePath());
                    } catch (IOException ex) {
            Logger.getLogger(YamlInparseTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        instance.setWebURLString(Constants.INPUT_FILE_URL);
        instance.updateFile();
        instance.readFile();
        instance.parse();
        boolean assemblersFound = !instance.getAssemblers().isEmpty();
        assertEquals(true,assemblersFound);
        
    }
    
}
