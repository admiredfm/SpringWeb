package mybatispackage.service;

import mybatispackage.dao.FindName;
import mybatispackage.pojo.MyClass;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class NameFind {

    //读取配置文件
    private InputStream inputStream;

    //构建sqlSessionFactory
    private SqlSessionFactory sqlSessionFactory;


    public NameFind() throws IOException {
        inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }


    public List<MyClass> findName(String stuName, String teacherName, int start, int end) throws IOException {


        //创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        FindName mapper = sqlSession.getMapper(FindName.class);

        List<MyClass> list = mapper.findName(stuName,teacherName, start, end);

        sqlSession.close();

        return list;

    }

    /**
     * 查询表中所有数据数量
     *
     * @return 数据总量
     * @throws IOException
     */
    public int findCount(String sname,String tname) throws IOException {


        //创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        FindName mapper = sqlSession.getMapper(FindName.class);

        int count = mapper.findCount(sname,tname);

        sqlSession.close();

        return count;

    }

    @Test
    public void test() throws IOException {
        List<MyClass> name = findName("刘", "王", 0, 4);
        System.out.println(name.size());
    }

    @Test
    public void testFindCount() throws IOException {
       // findCount();
    }
}
