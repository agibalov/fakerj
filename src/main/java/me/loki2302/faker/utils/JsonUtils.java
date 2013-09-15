package me.loki2302.faker.utils;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

public abstract class JsonUtils {
    private static final ObjectMapper mapper = new ObjectMapper();
    
    public static String json(Object o) {
        ObjectWriter objectWriter = mapper.writerWithDefaultPrettyPrinter();        
        
        try {
            return objectWriter.writeValueAsString(o);
        } catch (JsonGenerationException e) {
            return "FAIL";
        } catch (JsonMappingException e) {
            return "FAIL";
        } catch (IOException e) {
            return "FAIL";
        }
    }
}