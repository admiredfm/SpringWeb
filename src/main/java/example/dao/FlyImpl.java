package example.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.*;

/**
 * @author 受人敬仰的Fm
 * @date 2019/3/11
 * 连接数据库
 */
public class FlyImpl implements Fly {

//    public String jichang(){
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springjj.xml");
//        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
//        String sql = "select flight from aircraft where takeoff = ? and aerodrome = ?";
//        RowMapper<T> rowMapper = new BeanPropertyRowMapper<>()
//        jdbcTemplate.query(sql)
//        return null;
//    }

    @Override
    public String inquire(String a, String b) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet re = null;
        String flightnum = "无";

        String sql = "select flight from aircraft where takeoff = ? and aerodrome = ?";
        conn = SQLTool.getConnection();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, a);
            stmt.setString(2, b);

            re = stmt.executeQuery();
            while (re.next()) {
                flightnum = re.getString(1);
            }

            return flightnum;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SQLTool.freedConnection(conn);
            try {
                stmt.close();
                re.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return "无";
    }

    @Override
    public FlyId findFly(String jichang) {
        return null;
    }
}
