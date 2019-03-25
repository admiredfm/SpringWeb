package example.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * @author 受人敬仰的Fm
 * @date 2019/3/11
 * 加载驱动类
 */
public class SQLTool {

    public static java.sql.Connection conn = null;


    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasetest", "root", "942678775");
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void freedConnection(Connection conn){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
