package bbx.yaml;

import bbx.yaml.data.SimpleClass;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertNotNull;

public class JacksonYamlTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void canTransformJavaToJackson() throws IOException {
        YAMLFactory factory = new YAMLFactory();
        ObjectMapper yamlmap = new ObjectMapper(factory);
        File outputYaml = tempFolder.newFile("simple.yaml");

        SimpleClass simple = new SimpleClass();
        simple.setSimpleString("testString");

        FileOutputStream fos = new FileOutputStream(outputYaml);
        factory.createGenerator(fos).writeObject(simple);

        byte[] yamlBytes = Files.readAllBytes(Paths.get(outputYaml.getAbsolutePath()));
        String yaml = new String(yamlBytes, Charset.defaultCharset());
        Assert.assertEquals("---\n" +
                "simpleString: \"testString\"", yaml);
    }

    @Test
    public void canTransformYamlToJava() throws IOException {
        String yamlPath = "/simple.yaml";
        YAMLFactory factory = new YAMLFactory();
        ObjectMapper mapper = new ObjectMapper(factory);
        String file = getClass().getResource(yamlPath).getFile();
        SimpleClass simpleMapper = mapper.readValue(new File(file), SimpleClass.class);
        assertNotNull(simpleMapper.getSimpleString());
    }
}
