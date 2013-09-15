package me.loki2302.faker.infrastructure;

public class MethodImplementation {
    private final String javaScriptExpression;
    private final JavaScriptResultMapper javaScriptResultMapper;
    
    public MethodImplementation(
            String javaScriptExpression, 
            JavaScriptResultMapper javaScriptResultMapper) {
        this.javaScriptExpression = javaScriptExpression;
        this.javaScriptResultMapper = javaScriptResultMapper;
    }
    
    public Object invoke(JavaScriptEvaluator javaScriptEvaluator) {
        Object rawResult = javaScriptEvaluator.evaluate(javaScriptExpression);
        return javaScriptResultMapper.mapJavaScriptResult(rawResult);
    }
}