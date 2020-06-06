package com.bite.sql;

import java.sql.*;

/**
 * @Author tjy
 * @Date 2020/6/5 19:00
 */

public class JDBCDemo {

//        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
//        System.out.println(aClass.getSimpleName());
     Connection connection;
     Statement statement;
     ResultSet resultSet;
    private  void init() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        connection =
                DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/bite?useSSL=false&characterEncoding=utf8",
                        "root", "root");
//        select(connection);

//        System.out.println(connection);
    }


    public  void update(String sql)throws Exception  {
        init();
        statement = connection.createStatement();
        String sql1 = sql;
        int i = statement.executeUpdate(sql1);
        System.out.println("执行成功，影响了" + i + "行数据");
        close();
    }

    public  void select(String sql) throws Exception {
        init();
        Statement statement = connection.createStatement();
        String sql1 = sql;
        resultSet = statement.executeQuery(sql1);
        while (resultSet.next()){
            String id = resultSet.getString(1);
            String sn = resultSet.getString(2);
            String name = resultSet.getString(3);
            String qq_mail = resultSet.getString(4);
            System.out.println(id+ " " + sn + " "+ name + " " +qq_mail);
        }
        close();

    }

    private  void close() throws SQLException {
        if (connection != null){
            connection.close();
        }
        if (resultSet != null){
            resultSet.close();
        }
        if (statement != null){
            statement.close();
        }


    }
}
