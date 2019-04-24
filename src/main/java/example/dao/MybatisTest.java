package example.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {

    @Test
    public void findFlyByName() {
        //读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //根据配置文件构建sqlsessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //通过sqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //sqlsession执行映射文件中的sql并返回映射结果
        FlyId flyId = sqlSession.selectOne("example.dao.Fly.findFly", "北京机场");
        System.out.println(flyId.toString());
        sqlSession.close();
    }
}
