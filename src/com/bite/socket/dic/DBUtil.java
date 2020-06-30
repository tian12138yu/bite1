package com.bite.socket.dic;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author tjy
 * @Date 2020/6/30 16:57
 */

public class DBUtil {

    private static volatile DataSource dataSource = null;

    public static Connection getConnection() throws SQLException {
        if (dataSource == null){
            synchronized (com.bite.blog.DBUtil.class){
                if (dataSource == null){
                    MysqlDataSource mysqlDataSource = new MysqlDataSource();
                    mysqlDataSource.setServerName("127.0.0.1");
                    mysqlDataSource.setPort(3306);
                    mysqlDataSource.setUser("root");
                    mysqlDataSource.setPassword("root");
                    mysqlDataSource.setDatabaseName("dictionaries");
                    mysqlDataSource.setUseSSL(false);
                    mysqlDataSource.setCharacterEncoding("utf8");
                    dataSource = mysqlDataSource;
                }
            }
        }
        return dataSource.getConnection();
    }
}
