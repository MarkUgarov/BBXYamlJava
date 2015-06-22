package bbx.yaml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.Test;

public class JacksonYamlTest {

    @Test
    public void canInitializeJackson(){
        YAMLFactory factory = new YAMLFactory();
        ObjectMapper yamlmap = new ObjectMapper(factory);
    }
}
