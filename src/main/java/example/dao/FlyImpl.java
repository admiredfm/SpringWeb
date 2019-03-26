package example.dao;

import java.sql.*;

/**
 * @author 受人敬仰的Fm
 * @date 2019/3/11
 */
public class FlyImpl implements Fly {

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
}
