package tjy.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author tjy
 * @Date 2020/7/26 11:06
 */

public class DBUtil {
//    private static final String URL = "jdbc:mysql://localhost:3306/stu_info";
//    private static final String USERNAME = "root";
//    private static final String PASSWORD = "root";
    private static volatile DataSource ds;
    private static DataSource getDatasorce(){

        if (ds == null){
            synchronized (DBUtil.class){
                if (ds == null){
                    MysqlDataSource mysqlDataSource = new MysqlDataSource();
                    mysqlDataSource.setServerName("127.0.0.1");
                    mysqlDataSource.setPort(3306);
                    mysqlDataSource.setUser("root");
                    mysqlDataSource.setPassword("root");
                    mysqlDataSource.setDatabaseName("stu_info");
                    mysqlDataSource.setUseSSL(false);
                    mysqlDataSource.setCharacterEncoding("utf8");
                    ds = mysqlDataSource;
                }
            }
        }
        return ds;
    }

    public static Connection getConnection(){
        try {
            getDatasorce();
            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("数据库连接获取失败",e);
        }
    }

    public static void colse(Connection c , PreparedStatement ps, ResultSet r){
        try {
            if (c != null)
                c.close();
            if (ps != null)
                ps.close();
            if (r != null)
                r.close();
        } catch (SQLException e) {
            throw new RuntimeException("数据库资源关闭失败",e);
        }

    }
}
