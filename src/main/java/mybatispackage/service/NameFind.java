package mybatispackage.service;

import mybatispackage.pojo.MyClass;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;



public class NameFind {

    public List<MyClass> findName(String stuName,String teacherName) throws IOException {

        //读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        //构建sqlsessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //创建sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        MyClass myClass = new MyClass();
        myClass.setStuName(stuName);
        myClass.setTeacherName(teacherName);

        //执行sql语句并返回结果
        List<MyClass> list = sqlSession.selectList("mybatispackage.dao.findName.findName", myClass);
       // Cursor<MyClass> cursor = sqlSession.selectCursor("mybatispackage.dao.findName.findName", myClass);


        sqlSession.close();

        return list;

    }

    @Test
    public void test() throws IOException {
        List<MyClass> cursor = findName("", "王");
        System.out.println(cursor.size());
    }
}
