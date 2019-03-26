package example.dao;

import java.sql.ResultSet;

/**
 * @author 受人敬仰的Fm
 * @date 2019/3/11
 * 航班查询类
 */
public interface Fly {

    /**
     * @param a 起飞机场
     * @param b 降落机场
     * @return  航班号
     */
    String inquire(String a,String b);


}
