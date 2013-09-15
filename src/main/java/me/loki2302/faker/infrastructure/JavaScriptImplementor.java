package me.loki2302.faker.infrastructure;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class JavaScriptImplementor {
    private final JavaScriptEvaluator javaScriptEvaluator;
    
    public JavaScriptImplementor(JavaScriptEvaluator javaScriptEvaluator) {
        this.javaScriptEvaluator = javaScriptEvaluator;
    }
    
    @SuppressWarnings("unchecked")
    public <T> T implement(Class<T> clazz) {
        Map<Method, MethodImplementation> methodsMap = new HashMap<Method, MethodImplementation>(); 
        
        Method[] methods = clazz.getMethods();
        for(Method method : methods) {
            JavaScript javaScriptAnnotation = method.getAnnotation(JavaScript.class);
            if(javaScriptAnnotation == null) {
                throw new RuntimeException();
            }
            
            String javaScriptExpression = javaScriptAnnotation.value();
            JavaScriptResultMapper resultMapper = decideResultMapperForReturnType(method.getReturnType());            
            MethodImplementation methodImplementation = new MethodImplementation(
                    javaScriptExpression, 
                    resultMapper);
            
            methodsMap.put(method, methodImplementation);
        }
        
        JavaScriptProxyInvocationHandler invocationHandler = new JavaScriptProxyInvocationHandler(
                javaScriptEvaluator, 
                methodsMap);
        
        return (T)Proxy.newProxyInstance(
                clazz.getClassLoader(), 
                new Class[] { clazz }, 
                invocationHandler);
    }
    
    private static JavaScriptResultMapper decideResultMapperForReturnType(Class<?> clazz) {
        if(clazz.equals(String.class)) {
            return new PrimitiveTypeMapper(clazz);
        }
        
        return new ComplexTypeMapper(clazz);
    }    
}