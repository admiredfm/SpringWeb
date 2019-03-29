package example.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 受人敬仰的Fm
 * @date 2019/3/4
 */
public class TestMain {


    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springjj.xml");
        Test1 dao = (Test1) applicationContext.getBean("testDao");
        dao.say();
        dao.nihao();

//        DynamicProxy dynamicProxy = new DynamicProxyImpl();
//        DynamicProxy proxy = new DynamicProxyMain(dynamicProxy).getJdKmanProxy();
//
//        System.out.println("mmmm");
//        proxy.fun();


    }

}


