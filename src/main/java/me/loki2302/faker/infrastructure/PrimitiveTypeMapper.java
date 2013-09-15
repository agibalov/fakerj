package me.loki2302.faker.infrastructure;

import org.mozilla.javascript.Context;

public class PrimitiveTypeMapper implements JavaScriptResultMapper {
    private final Class<?> clazz;
    
    public PrimitiveTypeMapper(Class<?> clazz) {
        this.clazz = clazz;
    }
    
    public Object mapJavaScriptResult(Object javaScriptResult) {
        return Context.jsToJava(javaScriptResult, clazz);
    }        
}