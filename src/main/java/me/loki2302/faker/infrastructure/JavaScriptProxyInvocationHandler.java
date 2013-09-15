package me.loki2302.faker.infrastructure;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;


public class JavaScriptProxyInvocationHandler implements InvocationHandler {
    private final JavaScriptEvaluator javaScriptEvaluator;
    private final Map<Method, MethodImplementation> methodsMap;
    
    public JavaScriptProxyInvocationHandler(
            JavaScriptEvaluator javaScriptEvaluator, 
            Map<Method, MethodImplementation> methodsMap) {
        this.javaScriptEvaluator = javaScriptEvaluator;
        this.methodsMap = methodsMap;
    }
    
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(Object.class  == method.getDeclaringClass()) {
            String name = method.getName();
            if("equals".equals(name)) {
                return proxy == args[0];
            } else if("hashCode".equals(name)) {
                return System.identityHashCode(proxy);
            } else if("toString".equals(name)) {
                return String.format(
                        "%s@%s, %s", 
                        proxy.getClass().getName(), 
                        Integer.toHexString(System.identityHashCode(proxy)), 
                        this);
            } else {
                throw new IllegalStateException(String.valueOf(method));
            }
        }
        
        MethodImplementation js = methodsMap.get(method);
        return js.invoke(javaScriptEvaluator);
    }
}