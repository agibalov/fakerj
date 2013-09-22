package me.loki2302.faker.infrastructure;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

public class JavaScriptEvaluator {
    private Context context;
    private Scriptable scope;
    
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
    
    public <T> T evaluate(String objExpression, String funcName, Class<T> returnClass, Object... args) {
        Scriptable obj = (Scriptable)context.evaluateString(scope, objExpression, "command", 1, null);
        Function func = (Function)obj.get(funcName, obj);
        
        Object[] jsArgs = new Object[args.length];
        for(int i = 0; i < args.length; ++i) {
            Object arg = args[i];
            Object jsArg = Context.javaToJS(arg, scope);
            jsArgs[i] = jsArg;
        }
        
        Object result = func.call(context, scope, obj, jsArgs);
        return (T)Context.jsToJava(result, returnClass);
    }
    
    public <T> T evaluateAsDto(String objExpression, String funcName, Class<T> returnClass, Object... args) {
        Map<?, ?> o = evaluate(objExpression, funcName, Map.class, args);
        return dtoFromScriptable(o, returnClass);
    }
       
    private static <T> T dtoFromScriptable(Object scriptable, Class<T> clazz) {
        Map<?, ?> objMap = (Map<?, ?>) Context.jsToJava(scriptable, Map.class);
        ObjectMapper mapper = new ObjectMapper();
        T dto = mapper.convertValue(objMap, clazz);
        return dto;
    } 
}