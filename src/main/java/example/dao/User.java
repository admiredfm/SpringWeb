package example.dao;

import org.springframework.stereotype.Repository;

/**
 * @author 受人敬仰的Fm
 * @date 2019/3/5
 */
@Repository("user")
public class User {

    String string = "这是一个用户类";

    @Override
    public String toString() {
        return "User{" +
                "string='" + string + '\'' +
                '}';
    }
}
