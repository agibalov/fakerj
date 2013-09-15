package me.loki2302.faker.infrastructure;

import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.mozilla.javascript.Context;

public class ComplexTypeMapper implements JavaScriptResultMapper {
    private final Class<?> clazz;
    
    public ComplexTypeMapper(Class<?> clazz) {
        this.clazz = clazz;
    }

    public Object mapJavaScriptResult(Object javaScriptResult) {
        Map<?, ?> objMap = (Map<?, ?>) Context.jsToJava(javaScriptResult, Map.class);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(objMap, clazz);
    }        
}