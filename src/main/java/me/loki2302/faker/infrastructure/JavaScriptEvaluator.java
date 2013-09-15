package me.loki2302.faker.infrastructure;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

public class JavaScriptEvaluator {
    private static Context context;
    private static Scriptable scope;
    
    public JavaScriptEvaluator() {
        context = Context.enter();            
        scope = context.initStandardObjects();
    }
    
    public void loadScriptFromResource(String resourceName) throws IOException {
        URL resourceUrl = Resources.getResource(resourceName);
        String resourceContents;
        resourceContents = Resources.toString(resourceUrl, Charsets.UTF_8);
        context.evaluateString(scope, resourceContents, resourceName, 1, null);
    }
    
    public Object evaluate(String javaScript) {
        return context.evaluateString(scope, javaScript, "command", 1, null);
    }
    
    public String evaluateAsString(String javaScript) {
        Object o = context.evaluateString(scope, javaScript, "command", 1, null);
        return (String)Context.jsToJava(o, String.class);
    }
    
    public <T> T evaluateAsDto(String javaScript, Class<T> clazz) {
        Object o = context.evaluateString(scope, javaScript, "command", 1, null);
        return dtoFromScriptable(o, clazz);
    }
    
    private static <T> T dtoFromScriptable(Object scriptable, Class<T> clazz) {
        Map<?, ?> objMap = (Map<?, ?>) Context.jsToJava(scriptable, Map.class);
        ObjectMapper mapper = new ObjectMapper();
        T dto = mapper.convertValue(objMap, clazz);
        return dto;
    }
}