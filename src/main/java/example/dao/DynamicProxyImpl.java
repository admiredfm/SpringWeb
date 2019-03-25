package example.dao;

/**
 * @author 受人敬仰的Fm
 * @date 2019/3/21
 */
public class DynamicProxyImpl implements DynamicProxy {

    @Override
    public void fun() {
        System.out.println("被代理方法");
    }

}
