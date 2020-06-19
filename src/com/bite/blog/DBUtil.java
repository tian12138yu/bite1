package com.bite.blog;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author tjy
 * @Date 2020/6/8 19:15
 */

// Utilize 工具
public class DBUtil {
    // 静态属性，这个代码运行过程中，只有一份（整个进程运行过程中）
    private static volatile DataSource dataSource = null;

    public static Connection getConnection() throws SQLException {
        if (dataSource == null){
            synchronized (DBUtil.class){
                if (dataSource == null){
                    MysqlDataSource mysqlDataSource = new MysqlDataSource();
                    mysqlDataSource.setServerName("127.0.0.1");
                    mysqlDataSource.setPort(3306);
                    mysqlDataSource.setUser("root");
                    mysqlDataSource.setPassword("root");
                    mysqlDataSource.setDatabaseName("bite_blog");
                    mysqlDataSource.setUseSSL(false);
                    mysqlDataSource.setCharacterEncoding("utf8");
                    dataSource = mysqlDataSource;
                }
            }
        }
        return dataSource.getConnection();
    }
}
