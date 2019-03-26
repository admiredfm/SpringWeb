package example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 受人敬仰的Fm
 */

@Component("testDao")
public class TestDao implements Test1 {


    @Value("90")
    int uu = 0;

    @Resource(name = "user")
    User user;



    @Override
    public String toString() {
        return "TestDao{" +
                "uu=" + uu +
                ", user=" + user +
                '}';
    }





    @Override
    public void say() {
        System.out.println("你好");
    }

    @Override
    public void nihao() {
        System.out.println("你好啊");
    }

    public TestDao() {
        System.out.println("无参构造方法执行了...");
    }

    public TestDao(int i) {
        uu = i;
        System.out.println("有参构造方法执行了...");
    }

    public TestDao(int i, String jj) {
        uu = i;
        System.out.println("两个参数的构造方法执行了...");
    }
}
