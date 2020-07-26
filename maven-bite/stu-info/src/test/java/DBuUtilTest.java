import org.junit.Test;
import tjy.util.DBUtil;
import tjy.util.JSONUtil;

import java.sql.Connection;
import java.util.HashMap;

/**
 * @Author tjy
 * @Date 2020/7/26 11:28
 */

public class DBuUtilTest {
    @Test
    public void test(){
        Connection connection = DBUtil.getConnection();
        System.out.println(connection);
    }

    @Test
    public void test1(){
        HashMap<String, String> map = new HashMap<>();
        map.put("1","2");
        map.put("2","2");
        map.put("3","2");
        map.put("4","2");
        map.put("5","2");
        map.put("6","2");
        map.put("7","2");
        String write = JSONUtil.write(map);
        System.out.println(write);
    }
}
