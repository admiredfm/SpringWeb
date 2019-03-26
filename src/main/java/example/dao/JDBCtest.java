package example.dao;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 受人敬仰的Fm
 * @date 2019/3/15
 */
public class JDBCtest {

    ApplicationContext applicationContext = null;

    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    {
        applicationContext = new ClassPathXmlApplicationContext("springjj.xml");

    }



    @Transactional
    @Test
    public void transaction() {
        JdbcTemplate   jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        jdbcTemplate.update("update aircraft set takeoff = ? where aerodrome = ?", "好机场", "虹桥机场");
        int i = 2 / 0;
        jdbcTemplate.update("update aircraft set takeoff = ? where takeoff = ?", "场", "好机场");
    }


    @Test
    void query() {
        jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        String sql = "select * from aircraft";
        RowMapper<FlyId> rowMapper = new BeanPropertyRowMapper<>(FlyId.class);
        FlyId flyId = jdbcTemplate.query(sql, rowMapper).get(0);
        System.out.println(flyId.getAerodrome());
    }

    @Test
    void update() {
        jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        String sql = "update aircraft set takeoff = ? where aerodrome = ?";
        System.out.println(jdbcTemplate.update(sql, "机谷歌场", "虹桥机场"));
    }

    @Test
    void jdbcTest() throws SQLException {
        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        System.out.println(dataSource.getConnection());
    }

}
