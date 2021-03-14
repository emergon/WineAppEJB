package emergon.stateless.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptor {
    
    /* InvocationContext methods
   //returns the instance of the bean on which the method was called. 
   public Object getBean(); 
   //returns the method on the bean instance that was called. 
   public java.lang.reflect.Method getMethod();
   //returns the parameters for the method call.
   public Object[] getParameters();
   //modifies the parameters used for the method call.
   public void setParameters(Object[] params);
   //gives the interceptor methods access to the bean’s EJBContext.
   public EJBContext getEJBContext();
   //allows values to be passed between interceptor methods in the same InvocationContext instance using the Map returned.
   public java.util.Map getContextData();
   //invokes the next interceptor, if there is one, or invokes the target bean method.
   public Object proceed() throws Exception;
    */

    @AroundInvoke
    public Object logExecutionTime(InvocationContext context) throws Exception{
        String className = context.getClass().getName();
        String method = context.getMethod().getName();
        String target = className + "." + method;
        long startingTime = System.currentTimeMillis();
        System.out.println(">>Invoking "+ target);
        try{
            return context.proceed();
        }finally{
            System.out.println(">>Exiting "+ target);
            long totalTime = System.currentTimeMillis() - startingTime;
            System.out.println(">>Method:"+target+" executed in "+totalTime+"ms");
        }
        
    }
}
