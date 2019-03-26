package example.dao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 受人敬仰的Fm
 * @date 2019/3/21
 */
public class DynamicProxyMain {

    private DynamicProxy dynamicProxy;

    public DynamicProxyMain(DynamicProxy dynamicProxy) {
        this.dynamicProxy = dynamicProxy;
    }

    public DynamicProxy getJdKmanProxy(){
        DynamicProxy proxy = null;

        ClassLoader loader = dynamicProxy.getClass().getClassLoader();

        Class [] interfaces = new Class[]{DynamicProxy.class};

        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.println("前置通知");
                Object result = method.invoke(dynamicProxy,args);
                System.out.println("后置通知");
                return null;
            }
        };
        proxy = (DynamicProxy) Proxy.newProxyInstance(loader,interfaces,h);

        return proxy;
    }

}
